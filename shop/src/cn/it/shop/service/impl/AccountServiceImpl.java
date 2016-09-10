package cn.it.shop.service.impl;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;

import cn.it.shop.dao.impl.BaseDaoImpl;
import cn.it.shop.model.Account;
import cn.it.shop.model.Category;
import cn.it.shop.service.AccountService;
import cn.it.shop.service.CategoryService;
import cn.it.shop.util.HibernateSessionFactory;


//目前Service和Dao整合在一起
@Service("accountService")
public class AccountServiceImpl extends BaseDaoImpl<Account> implements AccountService{
	
		//管理员登录功能
		
	
}
