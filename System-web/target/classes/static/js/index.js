/**
 * Created by chenyi on 2017/12/20.
 */

$(document).ready(function () {
    //s设置显示菜单
    createMenu("sys/queryMenu?" + $.now());
    
    //s选项卡
//    layui.use('element', function () {
//        var element = layui.element;
//        element.on('nav(menuFilter)', function(data){
//        	alert(1111)
//        	console.log(data);
//        });
//    });
    layui.use('element', function () {
	    var element = layui.element;
	    $(".layui-nav-tree").on("click", ".site-active",function(){
	    	var currActive = $(this);
			//s判断右侧.layui-tab-title属性下的lay-id属性的li的数目，即已经打开的tab项数目
			if($(".layui-tab-title li").length <= 0){
				active.tabAdd(currActive.attr("data-url"), currActive.attr("data-id"), currActive.attr("title"));
			}else if($(".layui-tab-title li").length >= 15){
				
			}else{
				var isActive = false; //s初始化一个标志，为false说明未打开该tab项，为true则说明已有。
				$.each($(".layui-tab-title li"), function(index, item){
					//var id = $(item).attr("lay-id");
					if($(this).attr("lay-id") == currActive.attr("data-id")){
						isActive = true;
					}
				});
				if(!isActive){
					//s该选项第一次打开
					active.tabAdd(currActive.attr("data-url"), currActive.attr("data-id"), currActive.attr("title"));
				}
			}
			
			//s转到要打开的选项页面上
			active.tabChange(currActive.attr("data-id"));
    })
    var active = {
				tabAdd: function(url, id, title){
					//新增一个Tab项
					element.tabAdd('navTab', {
						title: title,
						content: '<iframe data-frameId="'+ id +'" scrolling="auto" frameborder="0" src="'+ url +'" style="width:100%;height:99%;"></iframe>',
						id: id
					});
					//计算iframe层的大小
					setFrameWH();
				},
				
				tabChange: function(id){
					//切换到指定Tab项
					element.tabChange('navTab', id);
				},
				
				tabDelete: function(id){
					element.tabDelete('navTab', id);
				}
		}
    })
    
});
//s生成菜单
function createMenu(url) {
    $.getJSON(url, function (r) {
    	console.log("菜单打印"+r.data)
        //s设置菜单缓存
        //$t.setStorageItem("menuList", r.data);
        //s显示菜单
        setMenu(r.data);

    });
}
//s开始生成生成菜单
function setMenu(menuList) {
    $(".layui-nav-tree").html("");
    for (var i = 0; i < menuList.length; i++) {
        var _li;
        if (menuList[i].type == 0) {
            _li = ['<li class="layui-nav-item" ><a  href="javascript:;" title="'+menuList[i].resourceName+'">',
                '<i class="' + 'fa fa-cog ' + '"></i>',
                '<span>' + menuList[i].resourceName + '</span>',
                '' +
                '</a></li>'].join("");
            //s是否有下级菜单
            if (menuList[i].childrenResources.length) {
                var $li=$(_li);
                $li.find("a").after('<ul class="layui-nav-child"></ul>');
                var childNodes = addMenu(menuList[i].childrenResources);
                if (childNodes != "") {
                    $li.find(".layui-nav-child").append(childNodes);
                    _li=$li.prop("outerHTML");
                }
            }
        }
        if (menuList[i].type == 1) {
            _li = '$(<li><a href="javascript:;" class="site-active" data-id="'+menuList[i].resourceId+'" data-url="' + menuList[i].url + '" title="'+menuList[i].resourceName+'"><i class="' + 'fa fa-cog' + '"></i> ' + menuList[i].resourceName + '</a></li>)';
        }
        $(".layui-nav-tree").append(_li);
    }
    layui.use('element', function () {
        var element = layui.element;
        element.render('nav')
    });

}
//s递归显示菜单 支持多级
function addMenu(list) {
    if (list) {
        var lis="";
        for (var i = 0; i < list.length; i++) {
            var _li;
            if (list[i].type == 0) {
                _li = ['<li ><a class="layui-nav-child" href="javascript:;" title="'+list[i].resourceName+'">',
                    '<i class="' + 'fa fa-cog' + '"></i>',
                    '<span>' + list[i].resourceName + '</span>',
                    '<i class="fa fa-angle-left pull-right"></i>' +
                    '</a></li>'].join("");
                //s是否有下级菜单
                if (list[i].list) {
                    var $li=$(_li);
                    $li.find("a").after('<ul class="layui-nav-child"></ul>');
                    var childNodes = addMenu(list[i].list);
                    if (childNodes != "") {
                        $li.find(".layui-nav-child").append(childNodes);
                    }
                }
                _li= $li.prop("outerHTML");
            }
            if (list[i].type == 1) {
                _li = $('<li><a href="javascript:;" class="site-active" data-id="'+list[i].resourceId+'" data-url="' + list[i].url + '" title="'+list[i].resourceName+'"><i class="' + 'fa fa-cog' + '"></i> ' + list[i].resourceName + '</a></li>');
            }
            lis+=$(_li).prop("outerHTML");
        }
        return lis;
    }
}

$(window).on('resize', function () {
    var $content = $('.content');
    $content.height($(this).height() - 120);
    $content.find('iframe').each(function () {
        $(this).height($content.height());
    });
}).resize();

function clearStorage() {
    var index = layer.load(1, {
        shade: [0.1,'#fff'] //0.1透明度的白色背景
    });
    localStorage.clear();
    layer.close(index);
    layer.msg('清除成功 !', {icon: 1});
}

function updatePassword (){
    //s修改密码
     layer.open({
         type: 1,
         skin: 'layui-layer-molv',
         title: "修改密码",
         area: ['550px', '270px'],
         shadeClose: false,
         content: jQuery("#passwordLayer"),
         btn: ['修改','取消'],
         btn1: function (index) {
             var data = "password="+$("#password").val()+"&newPassword="+$("#newPassword").val();
             $.ajax({
                 type: "POST",
                 url: "sys/user/password",
                 data: data,
                 dataType: "json",
                 success: function(result){
                     if(result.code == 0){
                         layer.close(index);
                         layer.alert('修改成功', function(index){
                             location.reload();
                         });
                     }else{
                         Msg.error(result.msg);
                     }
                 }
             });
         }
     });
}

//s打赏作者
function reward() {
    layer.open({
        title:'',
        type: 1,
        area: ['600px', '448px'], //宽高
        content: '<img src="/statics/img/cy/reward.png">'
    });
}

function setFrameWH(){
	var h = $(window).height();
	$("iframe").css("height", h+"px");
}
