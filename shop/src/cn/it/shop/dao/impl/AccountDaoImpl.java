package cn.it.shop.dao.impl;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import cn.it.shop.dao.AccountDao;
import cn.it.shop.model.Account;
import cn.it.shop.model.Category;
import cn.it.shop.service.AccountService;
import cn.it.shop.service.CategoryService;
import cn.it.shop.service.impl.BaseServiceImpl;
import cn.it.shop.util.HibernateSessionFactory;


//目前Service和Dao整合在一起
@Repository("accountDao")
public class AccountDaoImpl extends BaseServiceImpl<Account> implements AccountDao{
	
		//管理员登录功能
		
	
}
