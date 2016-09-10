package cn.it.shop.dao;

import java.util.List;

import cn.it.shop.model.Category;
import cn.it.shop.model.Forder;
import cn.it.shop.model.Product;
import cn.it.shop.model.Sorder;
import cn.it.shop.model.User;

public interface UserDao extends BaseDao<User>{
		
	public User login(User user);
	
	public boolean checkLogin(String login);
}
