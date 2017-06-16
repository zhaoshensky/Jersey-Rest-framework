package com.sdc.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.apache.log4j.Logger;


@SuppressWarnings("unused")
public class FtpManager {
	
	private final static String serverPath = "d:/work";
	
	public  final static String server = "192.168.3.37";
	private final static String username = "ll";
	private final static String password = "ll";
	
	public final static String sechme=  "http://";
	public final static String remoteSechmeServer=new StringBuffer(sechme+server+"/").toString();
	private static FtpManager instance;
	private final static Logger logger=Logger.getLogger(FtpManager.class);
	public synchronized static FtpManager getInstance(){
		if( instance == null ){
			instance = new FtpManager(); 
		}
		return instance;
	}  
	
	/**
	 * 获取远程服务器数据
	 * @return
	 */
	public String getRemoteSechmeServer(){
		return remoteSechmeServer;
	}
	/**
	 * 登录
	 * @param s_url
	 * @param uname
	 * @param pass
	 */
	public FTPClient login(String s_url,String uname,String pass){
		FTPClient ftpClient = new FTPClient();
		try{
			//连接
			ftpClient.connect(s_url);
			ftpClient.login(uname,pass);
			//检测连接是否成功
			int reply = ftpClient.getReplyCode();
			if(!FTPReply.isPositiveCompletion(reply)) {
				this.closeCon(ftpClient);
				System.err.println("FTP server refused connection.");
				System.exit(1);
			}
		}catch(Exception ex){
			ex.printStackTrace(); 
			this.closeCon(ftpClient);
			throw new RuntimeException("FTP客户端出错！", ex); 
		}
		return ftpClient;
	}
	/** 
     * FTP上传单个文件测试 
     */ 
    public boolean upload(File srcFile,String path,String fileName,File water,boolean isAddWater) { 
		
			if (isAddWater) {
				ImageUtils.pressImage(srcFile, water, 1.0f);
			}
		
        FTPClient ftpClient = FtpManager.getInstance().login(server, username, password);
        FileInputStream fis = null; 
        try { 
            fis = new FileInputStream(srcFile); 
            if (path.contains("/")) {
            	if(!CreateDirecroty(path + fileName,ftpClient)) {
                	return false;
                }
            }
            //设置上传目录 
            ftpClient.changeWorkingDirectory(serverPath + path); 
//            ftpClient.setBufferSize(1024); 
//            ftpClient.setControlEncoding("GBK"); 
            //设置文件类型（二进制） 
            ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE); 
            ftpClient.storeFile(fileName, fis); 
        } catch (IOException e) { 
        	logger.error("上传文件失败:"+e.getMessage());
            return false;
        } finally { 
        	srcFile.delete();
        	this.closeCon(ftpClient);
        	IOUtils.closeQuietly(fis); 
        } 
        return true;
    } 
    
    /** 
     * FTP下载单个文件测试 
     */ 
    public boolean download(String filePath,String downPath) { 
    	FTPClient ftpClient = FtpManager.getInstance().login(server, username, password);
    	FileOutputStream fos = null; 
        try { 
            //String remoteFileName = serverPath + filePath; 
            fos = new FileOutputStream(downPath); 
//            ftpClient.setBufferSize(1024); 
            //设置文件类型（二进制） 
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
    
    public InputStream downloadFile(String filePath ,InputStream inputStream) { 
    	FTPClient ftpClient = FtpManager.getInstance().login(server, username, password);
    	try { 
            String remoteFileName =  filePath; 

//            ftpClient.setBufferSize(1024); 
            //设置文件类型（二进制） 
            ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE); 
            inputStream = ftpClient.retrieveFileStream(filePath);
        } catch (IOException e) { 
            System.out.println(e.getMessage());
        } finally { 
        	this.closeCon(ftpClient);
        }
        return inputStream;
    }
    /**
     * 删除服务器文件
     * @param srcFname
     * @return
     */
    public boolean removeFile(String srcFname){  

    	FTPClient ftpClient = FtpManager.getInstance().login(server, username, password);

    	boolean flag = false;
		try {
			flag = ftpClient.deleteFile(srcFname);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			this.closeCon(ftpClient);
		}
    	return flag;
    }
    
    /**
    * 递归创建远程服务器目录
    * @param remote  远程服务器文件绝对路径
    * @return 目录创建是否成功
    * @throws IOException
    */
    public boolean CreateDirecroty(String remote,FTPClient ftpClient) throws IOException {
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
     * 销毁ftp连接 
     */ 
    public void closeCon(FTPClient ftpClient){
    	if(ftpClient !=null){
    		if(ftpClient.isConnected()){
    			try {
					ftpClient.disconnect();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
//    			try {
//    				//ftpClient.logout();
//    				//ftpClient.disconnect();
//    			} catch (IOException e) {
//    				e.printStackTrace();
//    			}
    		}
    	}
    }

   public static void main(String[] args) throws IOException { 

//    	File file = new File("http://114.113.151.46/index.html");
//    	//System.out.println(file.getName());
//    	File srcFile = new File("d:\\test.zip"); 
//    	FtpManager.getInstance().upload(srcFile, "admina/test/resa/2012a/12a/05a/", "test222.jpg");
//    	FtpManager.getInstance().upload(srcFile, "admina/test/res/a2012a/12a/05a/", "test333.jpg");
    	//FtpManager.getInstance().removeFile("1/test.jpg");
//; 
	     /*OutputStream out=new FileOutputStream("d:/7766666a.jpg");
	     byte bys[]=new byte[1024];
	     InputStream in=FtpManager.getInstance().downloadFile("shopping/tenderbid/2014/21/20/3.jpg", null);
    	//System.out.println(FtpManager.getInstance().download("shopping/tenderbid/2014/21/20/3.jpg", "d:/77a.jpg"));
	     int n=-1;
	     while((n=in.read(bys))!=-1){
	    	 out.write(bys, 0, n);
	     }
	     out.close();
	     in.close();*/
	      File file=new File("F:\\图片");
	      File[] child=  file.listFiles();
	      for(File fi:child){
	    	  String name=fi.getName();
	    	  FtpManager.getInstance().upload(fi, "/cdh/images/", name,null,false);
	      }
	   
    }	

}

