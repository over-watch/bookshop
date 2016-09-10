package cn.it.shop.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import cn.it.shop.dao.impl.BaseDaoImpl;
import cn.it.shop.model.Product;
import cn.it.shop.service.ProductService;

@Service("productService")
@SuppressWarnings("unchecked")
public class ProdcutServiceImpl extends BaseServiceImpl<Product> implements
		ProductService {

		
		public List<Product> queryJoinCategory(String name,int page,int size){
			return productDao.queryJoinCategory(name, page, size);
		}
		
		
		public Long getCount(String name){
			return productDao.getCount(name);
		}


		@Override
		public List<Product> queryByCid(int cid) {
			return productDao.queryByCid(cid);
		}
		
		public void deleteByIds(String ids){
			productDao.deleteByIds(ids);
		}

}
