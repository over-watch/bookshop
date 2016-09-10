package cn.it.shop.service.impl;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.type.TrueFalseType;
import org.junit.runners.Parameterized;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.sun.org.apache.xml.internal.security.Init;


import cn.it.shop.dao.AccountDao;
import cn.it.shop.dao.BaseDao;
import cn.it.shop.dao.CategoryDao;
import cn.it.shop.dao.ForderDao;
import cn.it.shop.dao.ProductDao;
import cn.it.shop.dao.SorderDao;
import cn.it.shop.dao.UserDao;
import cn.it.shop.service.BaseService;

@SuppressWarnings("unchecked")
@Service("baseService")
@Lazy(true)
public class BaseServiceImpl<T> implements BaseService<T> {
	
	private Class clazz;		//c
	
	public BaseServiceImpl(){
		System.out.println("this代表的是当前调用构造方法的对象："+this);
		System.out.println("获取当前this对象的父类信息："+this.getClass().getSuperclass());
		System.out.println("获取当前this对象的父类信息（包括泛型信息）"+this.getClass().getGenericSuperclass());
		ParameterizedType type=(ParameterizedType)this.getClass().getGenericSuperclass();
		clazz=(Class)type.getActualTypeArguments()[0];
	}
	@PostConstruct
	public void init(){
		String clazzname=clazz.getSimpleName();
	String clazzDao=clazzname.substring(0, 1).toLowerCase()+clazzname.substring(1)+"Dao";
		try {
		Field clazzField=this.getClass().getSuperclass().getDeclaredField(clazzDao);
		Field baseField=this.getClass().getSuperclass().getDeclaredField("baseDao");
		baseField.set(this, clazzField.get(this));
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}
	
	protected BaseDao baseDao;
	@Resource
	protected AccountDao accountDao;
	@Resource
	protected CategoryDao categoryDao;
	@Resource 
	protected ForderDao forderDao;
	@Resource
	protected SorderDao sorderDao;
	@Resource
	protected UserDao userDao;
	@Resource
	protected ProductDao productDao;
	
//	@Resource	//没有指定名称默认是属性的名称和id绑捆
//	private SessionFactory sessionFactory;
//	
//	protected Session getSession() {
//		return sessionFactory.getCurrentSession();
//	}
//	
//	public void setSessionFactory(SessionFactory sessionFactory) {
//		this.sessionFactory = sessionFactory;
//	}

	@Override
	public void save(T t) {
		baseDao.save(t);
		
			
	}

	@Override
	public void update(T t) {
		baseDao.update(t);
	}

	@Override
	public void delete(int id) {
		baseDao.delete(id);
	}

	
	@Override
	public T get(int id) {
		return (T)baseDao.get(id);
	}

	@Override
	public List<T> query() {
		return baseDao.query();
	}

}
