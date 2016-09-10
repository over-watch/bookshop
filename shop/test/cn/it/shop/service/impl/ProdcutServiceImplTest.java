package cn.it.shop.service.impl;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.it.shop.model.Product;
import cn.it.shop.service.ProductService;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext-*.xml")
public class ProdcutServiceImplTest {
	@Resource
	private ProductService productService;

	
	@Test
	public void testQueryByCid() {
		for(Product product:productService.queryByCid(1)){
			System.out.println(product);
		}
	}

}
