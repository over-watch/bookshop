package cn.it.shop.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import cn.it.shop.dao.UserDao;
import cn.it.shop.model.Forder;
import cn.it.shop.model.Product;
import cn.it.shop.model.Sorder;
import cn.it.shop.model.User;
import cn.it.shop.service.SorderService;
import cn.it.shop.service.UserService;
import cn.it.shop.service.impl.BaseServiceImpl;

@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl<User> implements
		UserDao {

	@Override
	public User login(User user) {
		String hql="FROM User u WHERE u.login=:login AND u.pass=:pass";
		return (User)getSession().createQuery(hql)
		.setString("login", user.getLogin())
		.setString("pass", user.getPass())
		.uniqueResult();
	}

	@Override
	public boolean checkLogin(String login) {
		String hql="SELECT count FROM User u WHERE u.login=:login";
		       if( (int) getSession().createQuery(hql)
					.setString("login",login )
					.uniqueResult()==0)
		        	  return true;
		          else
		        	  return false;
	}


}
