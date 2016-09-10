package cn.it.shop.service.impl;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import net.sf.json.JSONSerializer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.it.shop.model.Category;
import cn.it.shop.service.CategoryService;
import cn.it.shop.service.SorderService;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext-*.xml")
public class SorderServiceImplTest {

	@Resource
	public SorderService sorderService;
	
	@Test
	public void queryJionCategory(){
		System.out.println(JSONSerializer.toJSON(sorderService.querySale(5)));
		
	}
	
}
