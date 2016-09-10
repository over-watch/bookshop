package cn.it.shop.listener;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

import javax.annotation.Resource;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import sun.print.resources.serviceui;

import cn.it.shop.model.Category;
import cn.it.shop.model.Product;
import cn.it.shop.service.CategoryService;
import cn.it.shop.service.ProductService;
import cn.it.shop.util.FileUpload;
import cn.it.shop.util.ProductTimerTask;

//用于项目启动的时候数据初始化

public class InitDataListener implements ServletContextListener {
	
	private ApplicationContext context=null;
	
	protected ProductTimerTask productTimerTask=null;
	
	protected FileUpload fileUpload=null;
	
	@Override
	public void contextDestroyed(ServletContextEvent event) {
		//1：获取业务逻辑类查询商品信息
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		//解决方案1：不可取的，会把Spring配置文件加载两次
//		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext-*.xml");
//		productService=(ProductService) context.getBean("productService");
//		System.out.println(productService);
		
		//2：在项目启动时，把Spring配置文件通过监听器加载，存储在ServeltContext中，我们只需获取即可
		//解决方案2：直接到ServeltContext中获取Spring配置文件
//		ApplicationContext context=(ApplicationContext)event.getServletContext().getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
//		productService=(ProductService) context.getBean("productService");
//		System.out.println("productService:"+productService);
		
		//解决方案3：通过工具类加载即可
		context=WebApplicationContextUtils.getWebApplicationContext(event.getServletContext());
//		categoryService =(CategoryService) context.getBean("categoryService");
//		productService =(ProductService) context.getBean("productService");
		productTimerTask=(ProductTimerTask) context.getBean("productTimerTask");
		fileUpload=(FileUpload) context.getBean("fileUpload");
//		List<List<Product>> bigList=new ArrayList<List<Product>>();
		//查询出热点类别
//			for(Category category:categoryService.queryByHot(true)){
				//根据热点类别id获取推荐商品信息
//				bigList.add(productService.queryByCid(category.getId()));
//			}
			
		//把查询的bigList交给application内置对象
//			event.getServletContext().setAttribute("bigList", bigList);
		//把内置对象交给productTimerTask
		productTimerTask.setApplication(event.getServletContext());
		//通过设置定时器，让首页的数据每隔一个小时同步一次（要配置为守护线程）
		new Timer(true).schedule(productTimerTask, 0, 1000*60*60);
		//项目启动时候要加载图标
		event.getServletContext().setAttribute("bankList", fileUpload.getBankImage());
	}

}
