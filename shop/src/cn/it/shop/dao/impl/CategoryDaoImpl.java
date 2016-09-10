package cn.it.shop.dao.impl;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import cn.it.shop.dao.CategoryDao;
import cn.it.shop.model.Category;
import cn.it.shop.service.CategoryService;
import cn.it.shop.service.impl.BaseServiceImpl;
import cn.it.shop.util.HibernateSessionFactory;


//目前Service和Dao整合在一起
@Repository("categoryDao")
@SuppressWarnings("unchecked")
public class CategoryDaoImpl extends BaseServiceImpl<Category> implements CategoryDao {
	
	public CategoryDaoImpl(){
		super();
	}

	
	@Override
	public List<Category> queryJionAccount(String type,int page,int size) {
		return categoryDao.queryJionAccount(type, page, size);
	}


	@Override
	public Long getCount(String type) {
		return categoryDao.getCount(type);
	}


	@Override
	public void deleteByIds(String ids) {
		categoryDao.deleteByIds(ids);
	}


	@Override
	public List<Category> queryByHot(boolean hot) {
		return categoryDao.queryByHot(hot);
	}
	
	
}
