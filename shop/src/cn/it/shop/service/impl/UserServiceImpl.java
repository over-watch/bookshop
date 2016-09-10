package cn.it.shop.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import cn.it.shop.dao.impl.BaseDaoImpl;
import cn.it.shop.model.Forder;
import cn.it.shop.model.Product;
import cn.it.shop.model.Sorder;
import cn.it.shop.model.User;
import cn.it.shop.service.SorderService;
import cn.it.shop.service.UserService;

@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<User> implements
		UserService {

	@Override
	public User login(User user) {
		return userDao.login(user);
	}
	
	

}
