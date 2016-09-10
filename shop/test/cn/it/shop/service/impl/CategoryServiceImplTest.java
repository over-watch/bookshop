package cn.it.shop.service.impl;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.it.shop.model.Category;
import cn.it.shop.service.CategoryService;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext-*.xml")
public class CategoryServiceImplTest {

	@Resource
	private CategoryService categoryService;
	@Test
	public void testSave() {
		categoryService.save(new Category("女士休闲",true));
		categoryService.save(new Category("儿童休闲",true));
		categoryService.save(new Category("男士休闲",true));
		categoryService.save(new Category("女士休闲",true));
		categoryService.save(new Category("儿童休闲",true));
		categoryService.save(new Category("男士休闲",true));
	}

//	@Test
//	public void testUpdate() {
//		categoryService.update(new Category(1,"女士休闲",true,1));
//		categoryService.update(new Category(2,"儿童休闲",false,2));
//		categoryService.update(new Category(3,"男士休闲",true,3));
//	}

//	@Test
//	public void testDelete() {
//		categoryService.delete(3);
//	}
//	@Test
//	public void deleteByIds(){
//		categoryService.deleteByIds("2,3,4,5");
//		
//	}

	@Test
	public void testGet() {
		fail("Not yet implemented");
	}

//	@Test
//	public void testQuery() {
//		categoryService.query();
//	}
//	@Test
//	public void queryJionAccount(){
//		for(Category temp:categoryService.queryJionAccount("",3,3)){
//			System.out.println(temp);
//			System.out.println(temp.getAccount());
//		}
//	}
	
	@Test
	public void getCount(){
		System.out.println(categoryService.getCount(""));
	}

}
