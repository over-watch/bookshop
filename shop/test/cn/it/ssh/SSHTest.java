package cn.it.ssh;

import javax.annotation.Resource;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.it.shop.dao.impl.CategoryDaoImpl;
import cn.it.shop.model.Category;
import cn.it.shop.service.CategoryService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext-*.xml")
public class SSHTest {
	/*@Resource
	private Date date;*/
	@Resource
	private CategoryService categoryService;
/*	@Test// 测试Spring IOC的开发环境
	public void springioc(){
		System.out.println(date);
		System.out.println("测试成功");
		
	}*/
	/*@Test //测试Hibernate的开发环境,因为没有整合，可以直接new
	public void hibernate(){
		CategoryService categoryService=new CategoryServiceImpl();
		categoryService.save(new Category("儿童休闲",true));
	}*/
	
	@Test //测试Hibernate和Spring的整合环境
	public void hibernateAndSpring(){
		categoryService.update(new Category(2,"儿童休闲",true));
		categoryService.update(new Category(1,"女士休闲",true));
		categoryService.update(new Category(3,"男士休闲",true));
	}
	
	

}
