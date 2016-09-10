package cn.it.shop.service;

import java.util.List;

import cn.it.shop.model.Category;
import cn.it.shop.model.Forder;
import cn.it.shop.model.Product;
import cn.it.shop.model.Sorder;

public interface SorderService extends BaseService<Sorder>{
	//计算购物总价格
	public Forder addSorder(Forder forder,Product product);
	//把商品数据转化为Sorder
	public Sorder productToSorder(Product product);
	//根据查询热点日期的销售量
	public List<Object> querySale(int number);
	
	public Forder updateSorder(Forder forder,Sorder sorder);
	
	public List<Product> querySaleNumber(int number);
	
	
}
