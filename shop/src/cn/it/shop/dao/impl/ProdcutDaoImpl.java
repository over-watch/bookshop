package cn.it.shop.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import cn.it.shop.dao.ProductDao;
import cn.it.shop.model.Product;
import cn.it.shop.service.ProductService;
import cn.it.shop.service.impl.BaseServiceImpl;

@Repository("productDao")
@SuppressWarnings("unchecked")
public class ProdcutDaoImpl extends BaseDaoImpl<Product> implements
		ProductDao {

		
		public List<Product> queryJoinCategory(String name,int page,int size){
			String hql="FROM Product p LEFT JOIN FETCH p.category WHERE p.name LIKE :name";
			return getSession().createQuery(hql)
					.setString("name", "%"+ name +"%")
					.setFirstResult((page-1)*size)
					.setMaxResults(size)
					.list();
		}
		
		
		public Long getCount(String name){
			String hql="SELECT count(p) FROM Product p WHERE p.name LIKE :name";
				return (Long)getSession().createQuery(hql)
				.setString("name", "%"+name+"%")
				.uniqueResult();
		}


		@Override
		public List<Product> queryByCid(int cid) {
			String hql="FROM Product p JOIN FETCH p.category WHERE p.commend=true AND p.open=true AND p.category.id=:cid ORDER BY p.date DESC";
			return getSession().createQuery(hql)
								.setInteger("cid", cid)
								.setFirstResult(0)
								.setMaxResults(4)
								.list();
		}
		
		public void deleteByIds(String ids){
			String hqlString="DELETE FROM Product WHERE id in ("+ids+")";
			getSession().createQuery(hqlString)
			.executeUpdate();
		}




		
}
