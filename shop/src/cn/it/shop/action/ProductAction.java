package cn.it.shop.action;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import org.apache.commons.io.FilenameUtils;
import org.aspectj.util.FileUtil;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;

import cn.it.shop.model.Product;

@Controller
@Scope("prototype")
public class ProductAction extends BaseAction<Product> {
	
	public String queryJoinCategory(){
		pageMap =new HashMap<String, Object>();
		System.out.println("name:"+model.getName());
		List<Product> productList=productService.queryJoinCategory(model.getName(), page, rows);
		pageMap.put("rows", productList);
		pageMap.put("total", productService.getCount(model.getName()));
		return "jsonMap";
	}
	
	public void save() {
		System.out.println(model);
		String pic=fileUpload.uploadFile(fileImage);
		model.setPic(pic);
		productService.save(model);
	}
	
	public String get(){
		request.put("product", productService.get(model.getId()));
		return "detail";
	}
	
	public void update(){
		productService.update(model);
	}
	
	public String deleteByIds(){
		System.out.println("删除id为："+ids);
		productService.deleteByIds(ids);
		inputStream=new ByteArrayInputStream("true".getBytes());
		return "stream";
		
	}
	
	public String getImagePath(int id){
		String imagePath=fileUpload.getFilePath();
		return imagePath;
	}
	
//	public Product query(){
//		Product product=productService.get(model.getId());
//	       return product;
//	}
}
