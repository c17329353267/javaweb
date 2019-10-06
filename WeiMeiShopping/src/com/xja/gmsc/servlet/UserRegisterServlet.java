package com.xja.gmsc.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.xja.gmsc.domain.Register;
import com.xja.gmsc.service.UserRegisterService;
import com.xja.gmsc.service.impl.UserRegisterServiceImpl;

/**
 * 注册
 * @author Administrator
 *
 */
@WebServlet("/UserRegisterServlet")
public class UserRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("in UserRegisterServlet ");
		request.setCharacterEncoding("utf-8");
		//Map<String,String> map = new HashMap<>();//
		List<Object> lists= new ArrayList<>();
		Register register = new Register();
	    UserRegisterService userRegisterService = new UserRegisterServiceImpl();
		//图像文件的上传
		try {
			String realUploads = getServletContext().getRealPath("/fileuploads/picture");
			//获取磁盘工厂
			DiskFileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload fileupload = new ServletFileUpload(factory);
			//设置单个上传文件大小
			//fileupload.setFileSizeMax(1024*1024);
			//设置总上传文件大小
			//fileupload.setSizeMax(5*1024*1024);
			List<FileItem> fileItems = fileupload.parseRequest(request);		
			for(FileItem item:fileItems) {
				if(item.isFormField()) {
					//普通输入框字段
					String inputName = item.getFieldName();	
					String inputValue = item.getString();
					//======================================
					//转换字符编码
					byte[] tempVal = inputValue.getBytes("iso-8859-1");
					inputValue = new String(tempVal,"utf-8");
					/*String bobbys = "";
					if(inputName.startsWith("hobby")) {
						bobbys +=inputValue;
						inputValue=bobbys;
					}*/
					lists.add(inputValue);

				}else {
					//得到文件的MIME类型
					String fileType = item.getContentType();
					//System.out.println("当前文件类型："+fileType);
					//获取当前文件名
					String fileName = item.getName();
					//转换当前文件名的字符格式
					fileName = new String(fileName.getBytes(),"utf-8");
					fileName = UUID.randomUUID().toString()+"_"+fileName;
					//System.out.println("fileName="+fileName);
					String pictureUrl = realUploads+"/"+fileName;
					//map.put("picture", pictureUrl);
					lists.add(fileName);
					InputStream inputStream = item.getInputStream();
					OutputStream outputStream = new FileOutputStream(realUploads+"/"+fileName);
					int len = -1;
					byte[] array = new byte[1024];
					while((len=inputStream.read(array))!=-1) {
						outputStream.write(array,0,len);
					}
					outputStream.close();
					inputStream.close();					
				}
				
			}
			String fname=(String) lists.get(0);
			String lname=(String)lists.get(2);//姓氏
			String sname=(String)lists.get(1);//登陆min
			String pass=(String)lists.get(3);//密码
			String email=(String)lists.get(5);//邮件
			String gender=(String)lists.get(6);//性别
			String filepicture=(String)lists.get(7);//图片地址
			String bobby=(String)lists.get(0);
			String nDay = (String)lists.get(lists.size()-1);
			String nMonth = (String) lists.get(lists.size()-2);
			String nyear = (String)lists.get(lists.size()-3);
			String dataofbirth = nyear+"-"+nMonth+"-"+nDay;
			
			register.setUserName(fname);
			register.setLoginName(lname);
			register.setSurName(sname);
			register.setPassword(pass);
			register.setEmail(email);
			register.setSex(gender);
			register.setPicture(filepicture);
			register.setDataOfBirth(dataofbirth);
			register.setState(0);
			System.out.println("register="+register);
			userRegisterService.addUser(register);
			
			request.getRequestDispatcher("/register_success.jsp").forward(request, response);
		}catch(Exception e) {
			System.out.println("进入了异常捕获");
			e.printStackTrace();
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
