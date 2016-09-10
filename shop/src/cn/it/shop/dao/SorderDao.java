package cn.it.shop.dao;

import java.util.List;

import cn.it.shop.model.Category;
import cn.it.shop.model.Forder;
import cn.it.shop.model.Product;
import cn.it.shop.model.Sorder;

public interface SorderDao extends BaseDao<Sorder>{
	//计算购物总价格
	public Forder addSorder(Forder forder,Product product);
	//把商品数据转化为Sorder
	public Sorder productToSorder(Product product);
		
	public List<Object> querySale(int number);
	
	public List<Object> querySaleList(int number);
	
}
