package cn.it.shop.util;

import cn.it.shop.model.FileImage;

public interface FileUpload {

	//3：实现文件上传的功能，返回上传后新的名称
	public abstract String uploadFile(FileImage fileImage);
	//实现银行图片显示排序
	public String[]  getBankImage();
	public String getFilePath();

}