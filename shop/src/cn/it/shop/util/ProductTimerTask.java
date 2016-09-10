package cn.it.shop.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.annotation.Resource;
import javax.servlet.ServletContext;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import cn.it.shop.model.Category;
import cn.it.shop.model.Product;
import cn.it.shop.service.CategoryService;
import cn.it.shop.service.ProductService;

//设置一个任务：run方法中用来加载首页商品信息数据
@Component("productTimerTask")
public class ProductTimerTask extends TimerTask {
	@Resource
	private ProductService productService=null;
	@Resource
	private CategoryService categoryService=null;
	
	private ServletContext application=null;
	
	public void setApplication(ServletContext application) {
		this.application = application;
	}
	
	@Override
	public void run() {
		List<List<Product>> bigList=new ArrayList<List<Product>>();
		//查询出热点类别
			for(Category category:categoryService.queryByHot(true)){
				//根据热点类别id获取推荐商品信息
				bigList.add(productService.queryByCid(category.getId()));
			}
			
		//把查询的bigList交给application内置对象
			application.setAttribute("bigList", bigList);
	}
	
//	public static void main(String[] args){
//		new Timer(false).schedule(new TimerTask() {
//			
//			@Override
//			public void run() {
//				System.out.println("------run------");
//			}
//		}, 0, 2000);
//	}

}
