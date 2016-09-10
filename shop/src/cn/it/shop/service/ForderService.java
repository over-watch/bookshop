package cn.it.shop.service;

import java.math.BigDecimal;
import java.util.List;

import cn.it.shop.model.Forder;

public interface ForderService extends BaseService<Forder>{
	//计算购物总价格
	public BigDecimal cluTotal(Forder forder);
	
	public void updateStatusById(int id,int sid);
}
