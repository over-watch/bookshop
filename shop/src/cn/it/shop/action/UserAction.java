package cn.it.shop.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.it.shop.model.User;
@Controller
@Scope("prototype")
public class UserAction extends BaseAction<User> {
	public String login(){
		//先判断登录信息
		model=userService.login(model);
		if(model==null){
			session.put("error", "登录失败");
			return "ulogin";
		}else{
			//登录成功，根据情况返回
			session.put("user", model);
			
			if(session.get("goURL")==null){
				return "index";
			}else{
			return "goURL";
			}
		}
	}
	
	public String save(){
		
		userService.save(model);
		
		return "goURL";
	}
	
	public void checkLogin(){
		
	}
}
