package cn.it.shop.service.impl;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.it.shop.model.Account;
import cn.it.shop.service.AccountService;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext-*.xml")
public class AccountServiceImplTest {

	@Resource
	private AccountService accountService;
//	@Test
//	public void testSave() {
//		accountService.save(new Account("user2","客服2","user2"));
//	}

	@Test
	public void testUpdate() {
		accountService.update(new Account(1,"admin","管理员","admin"));
		accountService.update(new Account(2,"user1","客服1","user1"));
		accountService.update(new Account(3,"user2","客服2","user2"));
	}

	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

	@Test
	public void testGet() {
		fail("Not yet implemented");
	}

	@Test
	public void testQuery() {
		fail("Not yet implemented");
	}

}
