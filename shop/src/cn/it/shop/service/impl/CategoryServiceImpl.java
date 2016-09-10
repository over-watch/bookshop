package cn.it.shop.service.impl;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;

import cn.it.shop.dao.impl.BaseDaoImpl;
import cn.it.shop.model.Category;
import cn.it.shop.service.CategoryService;
import cn.it.shop.util.HibernateSessionFactory;


//目前Service和Dao整合在一起
@Service("categoryService")
@SuppressWarnings("unchecked")
public class CategoryServiceImpl extends BaseDaoImpl<Category> implements CategoryService {
	
	public CategoryServiceImpl(){
		super();
	}

	
	@Override
	public List<Category> queryJionAccount(String type,int page,int size) {
	return	getSession().createQuery("FROM Category c LEFT JOIN FETCH c.account WHERE c.type LIKE :type")
		.setString("type", "%"+ type + "%")
		.setFirstResult((page-1)*size)
		.setMaxResults(size)
		.list();
	}


	@Override
	public Long getCount(String type) {
		String hqlS="SELECT count(c) FROM Category c  WHERE c.type LIKE :type";
		return (Long)getSession().createQuery(hqlS)
		.setString("type", "%"+type+"%")
		.uniqueResult();
	}


	@Override
	public void deleteByIds(String ids) {
		String hql="DELETE FROM Category WHERE id in ("+ids+")";
		getSession().createQuery(hql)
		.executeUpdate();
	}


	@Override
	public List<Category> queryByHot(boolean hot) {
		String hql=" FROM Category c WHERE c.hot=:hot";
		return getSession().createQuery(hql)
		.setBoolean("hot", hot)
		.list();
	}
	
	
}
