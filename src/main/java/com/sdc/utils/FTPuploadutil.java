package com.sdc.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;
import org.apache.log4j.Logger;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;


public class FTPuploadutil {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(FTPuploadutil.class);

	private static Properties pros = new Properties();
	private static String sftpaddress = null;
	static {
		try {
			pros = new ConfigUtil().getProProperties();
			sftpaddress = pros.getProperty("ftpimg").toString();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	 static FTPClient getClientInstance() {
		// 加载属性文件进来
		 PropertiesUtil.loadProperties("pro.properties");
		// FTP工具类
		FTPClient ftpClient = new FTPClient();
		int replyCode = 0;
		try {
			ftpClient.connect(PropertiesUtil.getValueInfoByKey("ipAddress"),
					Integer.parseInt(PropertiesUtil
							.getValueInfoByKey("serverPort")));
			ftpClient.login(PropertiesUtil.getValueInfoByKey("loginname"),
					PropertiesUtil.getValueInfoByKey("password"));
			replyCode = ftpClient.getReplyCode();
			if (!FTPReply.isPositiveCompletion(replyCode))
				ftpClient.disconnect();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		return ftpClient;
	}

	/**
	 * 返回一个以类型为key，value是以图片具体地址组成
	 * 
	 * @param request
	 * @return
	 */
	public static HashMap<String, List<String>> storeFile(
			HttpServletRequest request) {
		// 创建一个通用的多部分解析器
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
		// 判断 request 是否有文件上传,即多部分请求
		HashMap<String, List<String>> hashMap = new HashMap<String, List<String>>();
		if (multipartResolver.isMultipart(request)) {
			// 转换成多部分request
			MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
			// 取得request中的所有文件名
			Iterator<String> iter = multiRequest.getFileNames();
			while (iter.hasNext()) {
				// 取得上传文件
				MultipartFile file = multiRequest.getFile(iter.next());
				// 规定从前三个字节取到图片类型相关编号
				String pictype = file.getOriginalFilename().substring(0, 4);
				if (null != file) {
					// 保存时候的文件名称
					String storeFileName = DateUtil.idrand()
							+ file.getOriginalFilename()
									.substring(
											file.getOriginalFilename()
													.lastIndexOf("."));
					// 获取ftp客户端实例
					FTPClient clientInstance = getClientInstance();
					if (null != clientInstance) {
						// 远程服务器地址
						InetAddress remoteAddress = clientInstance
								.getRemoteAddress();
						try {
							// 设置文件类型（二进制）
							clientInstance
									.setFileType(FTPClient.BINARY_FILE_TYPE);
							boolean storeFile = clientInstance.storeFile(
									storeFileName, file.getInputStream());
							if (storeFile) {
								if (hashMap.containsKey(pictype)) {

									hashMap.get(pictype)
											.add(remoteAddress
													+ "/"
													+ "//G://work//cdh360//earl//src//main//webapp//"
													+ storeFileName);
									// hashMap.get(pictype).add(remoteAddress+"/"+"D:/fileUpload/picUpload/"+storeFileName);
								} else {
									List<String> addrList = new ArrayList<String>();

									addrList.add(remoteAddress
											+ "/"
											+ "//G://work//cdh360//earl//src//main//webapp//"
											+ storeFileName);
									// addrList.add(remoteAddress+"/"+"D:/fileUpload/picUpload/"+storeFileName);
									hashMap.put(pictype, addrList);
								}
							}
						} catch (IOException e) {
							e.printStackTrace();
							return null;
						} finally {
							if (clientInstance.isConnected()) {
								try {
									clientInstance.disconnect();
								} catch (IOException ioe) {
								}
							}
						}
					}
				}
			}
		}
		return hashMap;
	}

	/**
	 * 返回一个以类型为key，value是以图片具体地址组成
	 * 
	 * @param CommonsMultipartFile
	 *            [] files
	 * @return
	 */
	public static HashMap<String, List<String>> MultistoreFile(
			CommonsMultipartFile[] files) {
		// 判断 request 是否有文件上传,即多部分请求
		HashMap<String, List<String>> hashMap = new HashMap<String, List<String>>();
		if (0 < files.length) {
			for (int i = 0; i < files.length; i++) {
				// 获取ftp客户端实例
				FTPClient clientInstance = getClientInstance();
				// 远程服务器地址
				InetAddress remoteAddress = clientInstance.getRemoteAddress();
				// 保存时候的文件名称
				StringBuilder sb = new StringBuilder();
				for (int j = 0; j < 7; j++) {// 你想生成几个字符的，就把3改成几，如果改成１,那就生成一个随机字母．
					sb = sb.append(Math.random() * 26 + 'a');
				}
				String storeFileName = sb
						+ files[i].getOriginalFilename()
								.substring(
										files[i].getOriginalFilename()
												.lastIndexOf("."));
				// 规定从前三个字节取到图片类型相关编号
				String pictype = files[i].getOriginalFilename().substring(0, 4);
				try {
					clientInstance.setFileType(FTPClient.BINARY_FILE_TYPE);
					boolean storeFile = clientInstance.storeFile(storeFileName,
							files[i].getInputStream());
					if (storeFile) {
						if (hashMap.containsKey(pictype)) {

							hashMap.get(pictype)
									.add(remoteAddress + sftpaddress
											+ storeFileName);
							// hashMap.get(pictype).add(remoteAddress+"//D://work//"+storeFileName);
						} else {
							List<String> addrList = new ArrayList<String>();

							addrList.add(remoteAddress + sftpaddress
									+ storeFileName);
							// addrList.add(remoteAddress+"//D://work//"+storeFileName);
							hashMap.put(pictype, addrList);
						}
					}
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					if (clientInstance.isConnected()) {
						try {
							clientInstance.disconnect();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}
		return hashMap;
	}

	/**
	 * 返回同一个类型图片地址集合
	 * @param CommonsMultipartFile
	 *            [] files
	 * @return
	 */
	public static List<String> MultistoreFileForList(CommonsMultipartFile[] files/*,HttpServletRequest request*/) {

		logger.info("上传图片本地ftp地址路径"+sftpaddress);
		List<String> addrList = new ArrayList<String>();
		if(0<files.length){
			for (int i = 0; i < files.length; i++) {
				FTPClient clientInstance = getClientInstance();
				try {
					Calendar instance = Calendar.getInstance();
					StringBuilder directory = new StringBuilder();
					//在上传目录下创建文件夹（/2015/11/12）
					String subDirectory = (instance.get(Calendar.YEAR)+1)+"/"+
							(instance.get(Calendar.MONTH)+1)+"/"+instance.get(Calendar.DATE)+"/";
		    		directory.append(sftpaddress+subDirectory);
		    		
		    		String subStoreFileName = new StringBuilder().append(instance.get(Calendar.HOUR_OF_DAY))
					.append(instance.get(Calendar.MINUTE))
					.append(instance.get(Calendar.SECOND))
					.append(instance.get(Calendar.MILLISECOND))
					+ files[i].getOriginalFilename().substring(files[i].getOriginalFilename().lastIndexOf("."));
		    		String storeFileName = directory+subStoreFileName;
		    		/*
		    		 * 添加水印图片的方法
		    		String waterPath = request.getSession().getServletContext().getRealPath("/images");
		    		File waterImg = new File(waterPath+"/water.png");
		    		File file = new File(new StringBuilder().append(Math.random()).toString());
		    		
		    		files[i].transferTo(file);
		    		
		    		ImageUtils.pressImage(file, waterImg, 1.0f);*/
		    		
		    		//调用递归方法创建目录
		    		boolean createDirecroty = CreateDirecroty(storeFileName,clientInstance);
		    		if(createDirecroty){
		    			clientInstance.setFileType(FTPClient.BINARY_FILE_TYPE);
		    			/*boolean storeFile = clientInstance.storeFile(
		    					subStoreFileName, new FileInputStream(file));*/
		    			boolean storeFile = clientInstance.storeFile(
		    					subStoreFileName, files[i].getInputStream());
		    			if(storeFile){
		    				StringBuilder directory2 = new StringBuilder();
		    				directory2.append(subDirectory);
		    				String backFileName = directory2+subStoreFileName;
//						addrList.add(remoteAddress+PropertiesUtil.getValueInfoByKey("dynamicdirectory")+backFileName);
		    				addrList.add(PropertiesUtil.getValueInfoByKey("dynamicdirectory")+backFileName);
		    				/*File file2 = new File(file.getAbsolutePath());
		    				if(file2.exists()){
		    					file2.delete();
		    					
		    				}*/
		    			}
		    		}else{
		    			return null;
		    		}
		    		
		    		 
				} catch (IOException e) {
					e.printStackTrace();
				}finally{
					if(clientInstance.isConnected()){
						try {
							clientInstance.disconnect();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}
		return addrList;
	}

	/**
	 * FTP下载
	 */
	public boolean download(String filePath, String downPath)
	{
		FTPClient ftpClient=null;
		FileOutputStream fos = null;
		try {
			 ftpClient =getClientInstance();
			  fos = new FileOutputStream(new File(downPath));		 
			// 设置文件类型（二进制）
			ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
			ftpClient.retrieveFile(filePath, fos);
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
			return false;
		} finally {
			this.closeCon(ftpClient);
			IOUtils.closeQuietly(fos);
		}
		return true;
	}
	/**
	 *cdh-v1.0.apk
	 * 测试ftp下载
	 * @param args
	 */
//	public static void main (String[] args)
//	{
		
//		 String str="D:/"; 
//		 boolean flag = downFile("192.168.1.126", 
//				 					21, 
//				 					"earl", 
//				 					"123456", 
//				 					"E:/apache-tomcat-7.0.67/webapps", 
//				 					"app-debug.apk",
//				 					str);  
//	     System.out.println(flag);  
//	}

	
	
	/**
	 * Description: 向FTP服务器上传文件
	 * @Version1.0 earl 2016-1-22创建
	 * @param url FTP服务器hostname
	 * @param port FTP服务器端口
	 * @param username FTP登录账号
	 * @param password FTP登录密码
	 * @param path FTP服务器保存目录
	 * @param filename 上传到FTP服务器上的文件名
	 * @param input 输入流
	 * @return 成功返回true，否则返回false
	 */
	public static boolean uploadFile(String url,int port,String username, 
			String password, String path, String filename, InputStream input)
	{
		boolean success = false;
		FTPClient ftp = new FTPClient();
		try {
			int reply;
			ftp.connect(url, port);//连接FTP服务器
			//如果采用默认端口，可以使用ftp.connect(url)的方式直接连接FTP服务器
			ftp.login(username, password);//登录
			reply = ftp.getReplyCode();
			if (!FTPReply.isPositiveCompletion(reply)) {
				ftp.disconnect();
				return success;
			}
			ftp.changeWorkingDirectory(path);
			ftp.storeFile(filename, input);			
			
			input.close();
			ftp.logout();
			success = true;
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (ftp.isConnected()) {
				try {
					ftp.disconnect();
				} catch (IOException ioe) {
				}
			}
		}
		return success;
	}
	/**
	 * Description: 从FTP服务器下载文件
	 * @Version1.0 earl 2016-1-22创建
	 * @param url FTP服务器hostname
	 * @param port FTP服务器端口
	 * @param username FTP登录账号
	 * @param password FTP登录密码
	 * @param remotePath FTP服务器上的相对路径
	 * @param fileName 要下载的文件名
	 * @param localPath 下载后保存到本地的路径
	 * @return
	 */
	public static boolean downFile(String remotePath,
									String fileName,String localPath) {
		boolean success = false;
		FTPClient ftp = new FTPClient();
		try {
			int reply;
			//ftp.connect(url, port);
			//如果采用默认端口，可以使用ftp.connect(url)的方式直接连接FTP服务器
			//ftp.login(username, password);//登录
			ftp =getClientInstance();
			reply = ftp.getReplyCode();
			if (!FTPReply.isPositiveCompletion(reply)) {
				ftp.disconnect();
				return success;
			}
			ftp.changeWorkingDirectory(remotePath);//转移到FTP服务器目录
			FTPFile[] fs = ftp.listFiles();
			for(FTPFile ff:fs){
				if(ff.getName().equals(fileName)){
					File localFile = new File(localPath+"/"+ff.getName());				
					OutputStream is = new FileOutputStream(localFile); 
					ftp.retrieveFile(ff.getName(), is);
					is.close();
				}
			}
			ftp.logout();
			success = true;
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (ftp.isConnected()) {
				try {
					ftp.disconnect();
				} catch (IOException ioe) 
				{
					ioe.printStackTrace();
				}
			}
		}
		return success;
	}
	
	/**
    * 递归创建远程服务器目录
    * @param remote  远程服务器文件绝对路径
    * @return 目录创建是否成功
    * @throws IOException
    */
    public static boolean CreateDirecroty(String remote,FTPClient ftpClient) throws IOException {
        boolean success = true;
        String directory = remote.substring(0, remote.lastIndexOf("/") + 1);
        // 如果远程目录不存在，则递归创建远程服务器目录
        if (!directory.equalsIgnoreCase("/") && !ftpClient.changeWorkingDirectory(new String(directory))) {
        	int start = 0;
            int end = 0;
            if (directory.startsWith("/")) {
                start = 1;
            } else {
                start = 0;
            }
            end = directory.indexOf("/", start);
            while (true) {
                String subDirectory = new String(remote.substring(start, end));
                if (!ftpClient.changeWorkingDirectory(subDirectory)) {
                    if (ftpClient.makeDirectory(subDirectory)) {
                    	ftpClient.changeWorkingDirectory(subDirectory);
                    } else {
                        System.out.println("创建目录失败");
                        success = false;
                        return success;
                    }
                }
                start = end + 1;
                end = directory.indexOf("/", start);
                // 检查所有目录是否创建完毕
                if (end <= start) {
                    break;
                }
            }
        }
        return success;
    }
    
    /** 
     *  
     * <p>删除ftp上的文件</p> 
     * @param srcFname 
     * @return true || false 
     */  
    public static boolean removeFile(String srcFname){
    	FTPClient ftpClient = new FTPClient();
    	int reply;
    	ftpClient =getClientInstance();
		reply = ftpClient.getReplyCode();
		if (!FTPReply.isPositiveCompletion(reply)) {
			try {
				ftpClient.disconnect();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return false;
		}
    	boolean flag = false;  
    	if(srcFname.contains(".jpg")||srcFname.contains(".png")||srcFname.contains(".gif")||srcFname.contains(".jpeg")
    			||srcFname.contains(".jpg".toUpperCase())||srcFname.contains(".png".toUpperCase())||srcFname.contains(".gif".toUpperCase())
    			||srcFname.contains(".jpeg".toUpperCase())
    			){
    		String[] srcFnameStrings = srcFname.split("#");
    		for (String string : srcFnameStrings) {
    			String[] fileName = string.split("/");
    			String delFileName = fileName[fileName.length-1];
    			try {
    				if (!string.equalsIgnoreCase("/") &&!ftpClient.changeWorkingDirectory(string)) {
    					for (int i = 0; i < fileName.length; i++) {
    						ftpClient.changeWorkingDirectory(fileName[i]);
    						if(i==fileName.length-1){
    							flag = ftpClient.deleteFile(delFileName);
    						}
    					}
    				}
    			} catch (IOException e) {
    				e.printStackTrace();
    				try {
    					ftpClient.disconnect();
    				} catch (IOException e1) {
    					e1.printStackTrace();
    					return false;
    				} 
    			}
			}
    	}
        return flag;  
    }  
    
    /**
	 * 销毁ftp连接
	 */
	public void closeCon(FTPClient ftpClient) {
		if (ftpClient != null) {
			if (ftpClient.isConnected()) {
				try {
					ftpClient.disconnect();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
