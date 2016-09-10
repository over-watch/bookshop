package cn.it.shop.util;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.UUID;

import org.apache.catalina.Session;
import org.apache.catalina.connector.Request;
import org.apache.commons.io.FilenameUtils;
import org.aspectj.util.FileUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import cn.it.shop.model.FileImage;

@Component("fileUpload")
public class FileUploadUtil implements FileUpload {
	
	@Value("#{prop.basePath+prop.bankPath}")
	private String bankPath;
	@Value("#{prop.basePath+prop.filePath}")
	private String filePath;
	
	
//	public void setFilePath(String filePath) {
//		System.out.println("filePath:"+filePath);
//		this.filePath = filePath;
//	}
	
	public String getFilePath() {
		return filePath;
	}
	//通过文件名获取扩展名
	private String getFileExt(String fileName){
		return FilenameUtils.getExtension(fileName);
	}
	//生成 UUID随机数，作为新的文件名
	private String newFileName(String fileName){
		String ext=getFileExt(fileName);
		return UUID.randomUUID().toString()+"."+ext;
	}
	@Override
	public String uploadFile(FileImage fileImage){
		//获取唯一文件名
		String pic=newFileName(fileImage.getFilename());
		
			try {
				FileUtil.copyFile(fileImage.getFile(), new File(filePath,pic));
				return pic;
			} catch (IOException e) {
				e.printStackTrace();
			}finally{
				fileImage.getFile().delete();
			}
			return pic;
	}

	@Override
	public String[] getBankImage() {
	return	new File(bankPath).list(new FilenameFilter() {
			
			@Override
			public boolean accept(File dir, String name) {
				//通过文件后缀来实现过滤
//				System.out.println("dir:"+dir+",name:"+name);
				return name.endsWith(".gif");
			}
		});
	}
	
	
//	public static void main(){
//		String[] list=new File("C:/").list(new FilenameFilter() {
//			
//			@Override
//			public boolean accept(File dir, String name) {
//				//通过文件的后缀来过滤
//				System.out.println("dir:"+dir+",name:"+name);
//				return name.endsWith(".gif");
//			}
//		});
//		
//		System.out.println("-----------");
//		for(String temp:list){
//			System.out.println(temp);
//		}
//	}
}
