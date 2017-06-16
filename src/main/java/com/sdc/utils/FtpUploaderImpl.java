//package com.sdc.utils;
//
//import java.io.File;
//
//import com.baidu.ueditor.file.IUploader;
//
//
//
//public class FtpUploaderImpl extends IUploader {
//    private static IUploader iUploader=new FtpUploaderImpl();
//    private static String waterFile=null;
//    static{
//    	waterFile=FtpUploaderImpl.class.getClassLoader().getResource("//").getFile();
//    	waterFile=waterFile.replace("%20", " ");
//		waterFile=waterFile.replace("WEB-INF/classes/", "images/water.png");
//		waterFile=waterFile.substring(1);
//    }
//   
//    public FtpUploaderImpl(){
//    	
//    }
//	public IUploader getInstance(){
//		return iUploader;
//	}
//	
//	@Override
//	public boolean upload(File file, String path) {
//		
//		if (path == null) {
//			return false;
//		}
//		char indexChar = path.charAt(0);
//		int index = 0;
//
//		if (indexChar == '/') {
//			index = 1;
//		}
//		int lastIndex = path.lastIndexOf('/');
//		if (lastIndex < 1) {
//			return false;
//		}
//		String dir = path.substring(index, lastIndex+1);
//		String fileName = path.substring(lastIndex+1);
//		FtpManager.getInstance().upload(file, dir, fileName,new File(waterFile),true);
//		//FTP 上传后上传文件
//		if (file.exists()) {
//			file.delete();
//		}
//		return true;
//		
//	}
//	
//	public static void main(String[]args){
//		IUploader iup=new FtpUploaderImpl();
//		iup.getInstance().upload(null, "/edit/8/9.jpg");
//		
//	}
//
//}
