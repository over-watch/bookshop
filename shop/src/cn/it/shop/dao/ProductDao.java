package cn.it.shop.dao;

import java.util.List;

import cn.it.shop.model.Category;
import cn.it.shop.model.Product;

public interface ProductDao extends BaseDao<Product>{
	
	public List<Product> queryJoinCategory(String name,int page,int size);

	public Long getCount(String name);
	
	//根据热点类别，查询当前类别推荐商品（仅仅查询前4各）
	public List<Product> queryByCid(int cid);
	
	public void deleteByIds(String ids);
	
}
