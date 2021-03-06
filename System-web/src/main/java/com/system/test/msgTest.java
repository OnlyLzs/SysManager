package com.system.test;

import java.util.ArrayList;
import java.util.List;

import com.gexin.rp.sdk.base.IPushResult;
import com.gexin.rp.sdk.base.impl.ListMessage;
import com.gexin.rp.sdk.base.impl.SingleMessage;
import com.gexin.rp.sdk.base.impl.Target;
import com.gexin.rp.sdk.exceptions.RequestException;
import com.gexin.rp.sdk.http.IGtPush;
import com.gexin.rp.sdk.template.LinkTemplate;
import com.gexin.rp.sdk.template.NotificationTemplate;
import com.gexin.rp.sdk.template.style.Style0;
/**
 * 个推---》》消息推送测试
 * @class msgTest
 * @author Jason
 * @description
 * @date Feb 1, 2019 5:02:40 PM
 */
public class msgTest {
	 //采用"Java SDK 快速入门"， "第二步 获取访问凭证 "中获得的应用配置，用户可以自行替换
    private static String appId = "rMM9Dl269r8dYTjiz5TZs2";
    private static String appKey = "HbeTC1f5IH9OuLaYAxJdj4";
    private static String masterSecret = "mZs3lsOffx5SJvZ2PMU233";

    static String CID = "025311ba2fa7cd43ac5cb69c6a40b42e";
  //别名推送方式
   // static String Alias = "";
    static String host = "http://sdk.open.api.igexin.com/apiex.htm";

    public static void main(String[] args) throws Exception {
        IGtPush push = new IGtPush(host, appKey, masterSecret);
        // 通知透传模板
        NotificationTemplate template = notificationTemplateDemo();
        ListMessage message = new ListMessage();
        message.setData(template);
        // 设置消息离线，并设置离线时间
        message.setOffline(true);
        // 离线有效时间，单位为毫秒，可选
        message.setOfflineExpireTime(24 * 1000 * 3600);
        message.setData(template);
        // 可选，1为wifi，0为不限制网络环境。根据手机处于的网络情况，决定是否下发
        message.setPushNetWorkType(0);
     // 配置推送目标
        List targets = new ArrayList();
        Target target1 = new Target();
        //Target target2 = new Target();
        target1.setAppId(appId);
        target1.setClientId(CID);
   //     target1.setAlias(Alias1);
       // target2.setAppId(appId);
        //target2.setClientId(CID2);
   //     target2.setAlias(Alias2);
        targets.add(target1);
        //targets.add(target2);
        // taskId用于在推送时去查找对应的message
        String taskId = push.getContentId(message);
        IPushResult ret = push.pushMessageToList(taskId, targets);
        System.out.println(ret.getResponse().toString());
    }
    public static NotificationTemplate notificationTemplateDemo() {
    	NotificationTemplate  template = new NotificationTemplate();
        // 设置APPID与APPKEY
        template.setAppId(appId);
        template.setAppkey(appKey);

        Style0 style = new Style0();
        // 设置通知栏标题与内容
        style.setTitle("title11111");
        style.setText("text11111");
        // 配置通知栏图标
        style.setLogo("icon.png");
        // 配置通知栏网络图标
        style.setLogoUrl("");
        // 设置通知是否响铃，震动，或者可清除
        style.setRing(true);
        style.setVibrate(true);
        style.setClearable(true);
        template.setStyle(style);
     // 透传消息设置，1为强制启动应用，客户端接收到消息后就会立即启动应用；2为等待应用启动
        template.setTransmissionType(1);
        template.setTransmissionContent("内容11112");
        return template;
    }
}


class PushtoSingle {
   
}