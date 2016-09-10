package cn.it.shop.dao;

import java.util.List;

import cn.it.shop.model.Category;

public interface CategoryDao extends BaseDao<Category>{
	
	//查询类别信息，级联
	public  List<Category> queryJionAccount(String  type,int page,int size);
	
	public Long getCount(String type);
	//根据ids删除多条记录
	public void deleteByIds(String ids);
	//根据boolean查询热点或者非热点类别
	public List<Category> queryByHot(boolean hot);
	
}
