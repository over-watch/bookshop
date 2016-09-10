package cn.it.shop.dao;

import java.util.List;

import cn.it.shop.model.Forder;

public interface ForderDao extends BaseDao<Forder>{
	//计算购物总价格
	public void updateStatusById(int id,int sid);
}
