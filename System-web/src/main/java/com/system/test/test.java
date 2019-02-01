package com.system.test;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFClientAnchor;
import org.apache.poi.hssf.usermodel.HSSFPatriarch;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
class Question{
	
	private String id;
	private String title;
	private String description;
	private String image;
	private String type;
	private String level;
	private String active;
	private String correctAnswer;
	private String lessonId;
	private String answerDescriptionA;
	private String answerDescriptionB;
	private String answerDescriptionC;
	private String answerDescriptionD;
	private String answerImageA;
	private String answerImageB;
	private String answerImageC;
	private String answerImageD;
	
}

@Controller
public class test {

	@RequestMapping("/getHomeWork")
	@ResponseBody
	public void getHomeWork(HttpServletResponse servletResponse) {
		/*OkHttpClient client = new OkHttpClient();

		MediaType mediaType = MediaType.parse("multipart/form-data; boundary=----WebKitFormBoundary7MA4YWxkTrZu0gW");
		RequestBody body = RequestBody.create(mediaType,
				"------WebKitFormBoundary7MA4YWxkTrZu0gW\r\nContent-Disposition: form-data; name=\"homeworkId\"\r\n\r\n1128707565\r\n------WebKitFormBoundary7MA4YWxkTrZu0gW\r\nContent-Disposition: form-data; name=\"token\"\r\n\r\n9EWAoyIXXNhl248EpIRCuyOnO-RDJZNdK_PB5GfWkEE2icKZiATbR7-5FCkNVbohXMf85RHOnb7UzPSb-e48wExWA6le_uoaMOGCzWbEoU8/\r\n------WebKitFormBoundary7MA4YWxkTrZu0gW\r\nContent-Disposition: form-data; name=\"type\"\r\n\r\nhomework\r\n------WebKitFormBoundary7MA4YWxkTrZu0gW--");
		Request request = new Request.Builder()
				.url("https://ssapinew.knowbox.cn/teacher/pc/homework-detail?apiVersion=3&version=378&source=pcTeacher")
				.post(body)
				.addHeader("content-type", "multipart/form-data; boundary=----WebKitFormBoundary7MA4YWxkTrZu0gW")
				.addHeader("Content-Type", "application/x-www-form-urlencoded").addHeader("cache-control", "no-cache")
				.addHeader("Postman-Token", "b2574d06-35f1-4314-91e2-b8c671ac9163").build();
*/
		OkHttpClient client = new OkHttpClient();

		MediaType mediaType = MediaType.parse("multipart/form-data; boundary=----WebKitFormBoundary7MA4YWxkTrZu0gW");
		RequestBody body = RequestBody.create(mediaType, "------WebKitFormBoundary7MA4YWxkTrZu0gW\r\nContent-Disposition: form-data; name=\"type\"\r\n\r\nhomework\r\n------WebKitFormBoundary7MA4YWxkTrZu0gW\r\nContent-Disposition: form-data; name=\"token\"\r\n\r\n9EWAoyIXXNhl248EpIRCuyOnO-RDJZNdK_PB5GfWkEE2icKZiATbR7-5FCkNVbohXMf85RHOnb7UzPSb-e48wExWA6le_uoaMOGCzWbEoU8/\r\n------WebKitFormBoundary7MA4YWxkTrZu0gW\r\nContent-Disposition: form-data; name=\"homeworkId\"\r\n\r\n1129204832\r\n------WebKitFormBoundary7MA4YWxkTrZu0gW--");
		Request request = new Request.Builder()
		  .url("https://ssapinew.knowbox.cn/teacher/pc/homework-detail?apiVersion=3&version=378&source=pcTeacher")
		  .post(body)
		  .addHeader("content-type", "multipart/form-data; boundary=----WebKitFormBoundary7MA4YWxkTrZu0gW")
		  .addHeader("Content-Type", "application/x-www-form-urlencoded")
		  .addHeader("cache-control", "no-cache")
		  .addHeader("Postman-Token", "b62ff6e7-c903-4bf0-bc3d-63698b996479")
		  .build();

		try {
			Response response = client.newCall(request).execute();
			JSONObject jsonObject = JSONObject.parseObject(response.body().string().toString());
			JSONObject data = jsonObject.getJSONObject("data");
			JSONObject answerData = data.getJSONObject("answerData");
			JSONArray jcList = answerData.getJSONArray("jcList");
			JSONArray ksList = answerData.getJSONArray("ksList");
			
			List<Question> questionList = new ArrayList<>();
			Question questionBean;
			for (int a = 0; a < jcList.size(); a++) {
				
				questionBean = new Question();
				
				JSONObject obj = (JSONObject) jcList.get(a);
				String questionType = obj.getString("questionType");//类型
				String questionId = obj.getString("questionId");//编号
				String question = obj.getString("question");//题目
				String questionItem = obj.getString("questionItem");//题目编号
				String rightAnswer = obj.getString("rightAnswer");//正确答案
				
				if (questionType.equals("1")) {
					System.out.println("此题目为选择题");
					questionBean.setType("1");
				} else if (questionType.equals("0")) {
					System.out.println("此题目为填空题");
					//s我自己定义的填空题类型为2
					questionBean.setType("2");
				} else {
					continue;
				}
				
				// s对于题目的解析
				int picNumber = 1;
				while (true) {
					int start = 0;
					int end = 0;
					start = question.indexOf("#{");
					end = question.indexOf("}#") + 2;
					String tempStr = question.substring(start, end);
					if (tempStr.indexOf("src") > 0) {
						// System.out.println("具有src图片的中间数据");
						String srctempStr = tempStr.replace("#", "");
						// System.out.println(srctempStr);
						JSONObject srcObj = JSONObject.parseObject(srctempStr);
						String src = (String) srcObj.get("src");
						if (src.indexOf(".mp3") < 0) {
							System.out.println("题目图片" + picNumber + "   : " + src);
							questionBean.setImage(src);
							question = question.replace(tempStr, " 图片" + picNumber + " ");
							picNumber++;
						}
					}
					if (tempStr.indexOf("blank") > 0) {
						question = question.replace(tempStr, "_");
					} else {
						question = question.replace(tempStr, "");
					}
					if (question.indexOf("#{") == -1 && question.indexOf("}#") == -1) {
						break;
					}
				}
				System.out.println("题目          ： " + question);
				questionBean.setDescription(question);
				
				if (questionType.equals("1")) {
					JSONArray questionItems = JSONArray.parseArray(questionItem);
					for (int i = 0; i < questionItems.size(); i++) {
						String ItemCode = questionItems.getJSONObject(i).get("itemCode").toString();
						String Item = questionItems.getJSONObject(i).get("questionItem").toString();
						// s对答案的图片进行解析
						if (Item.indexOf("src") > 0) {
							Item = Item.replace("#", "");
							JSONObject answerSrc = JSONObject.parseObject(Item);
							Item = answerSrc.getString("src");
							Item = Item.replace("\\", "");
							if(i==0) {
								questionBean.setAnswerImageA(Item);
							}
							if(i==1) {
								questionBean.setAnswerImageB(Item);
							}
							if(i==2) {
								questionBean.setAnswerImageC(Item);
							}
							if(i==3) {
								questionBean.setAnswerImageD(Item);
							}
						}else {
							if(i==0) {
								questionBean.setAnswerDescriptionA(Item);
							}
							if(i==1) {
								questionBean.setAnswerDescriptionB(Item);
							}
							if(i==2) {
								questionBean.setAnswerDescriptionC(Item);
							}
							if(i==3) {
								questionBean.setAnswerDescriptionD(Item);
							}
						}
						System.out.println("选项：" + ItemCode + " " + Item);
					}
					
					
					JSONArray rightAnswers = JSONArray.parseArray(rightAnswer);
					for (int i = 0; i < rightAnswers.size(); i++) {
						String answer = rightAnswers.getJSONObject(i).get("choice").toString();
						System.out.println("选择题答案 ：" + answer);
						questionBean.setCorrectAnswer(answer);
					}
					System.out.println();
				}
				if (questionType.equals("0")) {
					JSONArray rightAnswers = JSONArray.parseArray(rightAnswer);
					String finalAnswer="";
					for (int i = 0; i < rightAnswers.size(); i++) {
						String answer = rightAnswers.getJSONObject(i).get("content").toString();
						if(i==0) {
							finalAnswer = answer;
						}else {
							finalAnswer+=","+answer;
						}
					}
					System.out.println("填空题答案 ： " + finalAnswer);
					questionBean.setCorrectAnswer(finalAnswer);
				}
				System.out.println("===============================");
				
				questionList.add(questionBean);
				
			}
			
			HSSFWorkbook wb = exportExcel(questionList);
			String fileName = "一年级数学题"+System.currentTimeMillis()+".xls";
			//s响应到客户端
			this.setResponseHeader(servletResponse, fileName);
			OutputStream os = servletResponse.getOutputStream();
			wb.write(os);
			os.flush();
			os.close();
			
			
		} catch (IOException e) {
			e.printStackTrace();
			
		}
	}
	
	
	//s发送响应流方法
    public void setResponseHeader(HttpServletResponse response, String fileName) {
        try {
            try {
                fileName = new String(fileName.getBytes(),"ISO8859-1");
            } catch (UnsupportedEncodingException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            response.setContentType("application/octet-stream;charset=ISO8859-1");
            response.setHeader("Content-Disposition", "attachment;filename="+ fileName);
            response.addHeader("Pargam", "no-cache");
            response.addHeader("Cache-Control", "no-cache");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
	
	/**
	 * 导出Excel
	 * @Description
	 * @author Jason
	 * @date Jan 23, 2019
	 * @param questionList
	 * @return 
	 */
	
	private HSSFWorkbook exportExcel(List<Question> questionList) {
		
		String sheetName ="一年级数学题";
		String[] title = {"id","title","description","image","type","level","active","correctAnswer","lessonId","answerDescriptionA","answerDescriptionB","answerDescriptionC","answerDescriptionD","answerImageA","answerImageB","answerImageC","answerImageD"};
		String[][] question =new String[questionList.size()][];
		
		for(int i=0;i<questionList.size();i++) {
			question[i] = new String[title.length];
			for(int j=0;j<title.length;j++) {
				// s利用反射将excel上的值 对应到实体
				Field[] fields =questionList.get(i).getClass().getDeclaredFields();
				for (Field field : fields) {
					// s设置私有属性可以访问
					field.setAccessible(true);
					// s将实体属性等于第一行标题名    （这里面 String title的顺序 必须和实体里面的顺序一样 不然 会映射不上  ，或者你再套一个循环）
					if (field.getName().equals(title[j])) {
						// s二维数组的 第i行第j列  等于第i个题目的 等于标题名的属性
						try {
							question[i][j] = (String) field.get(questionList.get(i));
						} catch (IllegalArgumentException | IllegalAccessException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						break;
					}
				}
			}
		}
		//System.out.println(question);
		
		HSSFWorkbook wb = getHSSFWorkbook(sheetName, title, question, null);
		return wb;
		
	}




	/**
	 * 导出Excel
	 * 
	 * @param sheetName sheet名称
	 * @param title     标题
	 * @param values    内容
	 * @param wb        HSSFWorkbook对象
	 * @return
	 */
	public  HSSFWorkbook getHSSFWorkbook(String sheetName, String[] title, String[][] values, HSSFWorkbook wb) {

		// 1，创建一个HSSFWorkbook，对应一个Excel文件
		if (wb == null) {
			wb = new HSSFWorkbook();
		}

		// 2，在workbook中添加一个sheet,对应Excel文件中的sheet
		HSSFSheet sheet = wb.createSheet(sheetName);
		sheet.setColumnWidth(2, 50 * 256);
		sheet.setColumnWidth(3, 50 * 256);
		sheet.setColumnWidth(13, 50 * 256);
		sheet.setColumnWidth(14, 50 * 256);
		sheet.setColumnWidth(15, 50 * 256);
		sheet.setColumnWidth(16, 50 * 256);
		//sheet.setDefaultRowHeightInPoints(200);
		
		// 3，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制
		HSSFRow row = sheet.createRow(0);
		
		// 4，创建单元格，并设置值表头 设置表头居中
		HSSFCellStyle style = wb.createCellStyle();
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式
		

		// 5
		HSSFCell cell = null;

		// 6
		for (int i = 0; i < title.length; i++) {
			cell = row.createCell(i);
			cell.setCellValue(title[i]);
			cell.setCellStyle(style);
		}

		// 7 创建内容
		for (int i = 0; i < values.length; i++) {
			row = sheet.createRow(i + 1);
			row.setHeight((short) 2500);
			for (int j = 0; j < values[i].length; j++) {
				if((j==3||j==13||j==14||j==15||j==16)&&values[i][j]!=null&&values[i][j]!="") {
					row.createCell(j);
					//HSSFPatriarch 就是一个容器，可以创建图片和形状。
					HSSFPatriarch patriarch = sheet.createDrawingPatriarch();
					drawPictureInfoExcel(wb,patriarch,j,i+1,values[i][j]);
					
				}else {
					// 7.1将内容按顺序赋给对应的列对象
					row.createCell(j).setCellValue(values[i][j]);
				}
				
			}
		}
		return wb;
	}
	
	private void drawPictureInfoExcel(HSSFWorkbook wb, HSSFPatriarch patriarch,int columIndex, int rowIndex, String pictureUrl) {
		try {
			// anchor主要用于设置图片的属性
			 /*dx1 - 第一个单元格内的x坐标。
			dy1 - 第一个单元格内的y坐标。
			dx2 - 第二个单元格内的x坐标。
			dy2 - 第二个单元格内的y坐标。
			col1 - 第一个单元格的列（基于0）。起始列
			row1 - 第一个单元格的行（基于0）。起始行
			col2 - 第二个单元格的列（基于0）。结束列
			row2 - 第二个单元格的行（基于0）。结束行*/ 
			HSSFClientAnchor anchor = new HSSFClientAnchor(0, 0, 255, 255, (short) columIndex, rowIndex, (short) columIndex, rowIndex);
			// Sets the anchor type （图片在单元格的位置）
			// 0 = Move and size with Cells, 2 = Move but don't size with cells, 3 = Don't
			// move or size with cells.
			anchor.setAnchorType(0);
			URL url = new URL(pictureUrl);
			BufferedImage bufferImg = ImageIO.read(url);
			ByteArrayOutputStream byteArrayOut = new ByteArrayOutputStream();
			ImageIO.write(bufferImg, "jpg", byteArrayOut);
			byte[] data = byteArrayOut.toByteArray();
			patriarch.createPicture(anchor, wb.addPicture(data, HSSFWorkbook.PICTURE_TYPE_JPEG));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}