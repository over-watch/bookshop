package cn.it.shop.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

import cn.it.shop.model.Account;

@Controller
@Scope("prototype")
public class AccountAction extends BaseAction<Account> {
	
	public String update(){
		System.out.println(ActionContext.getContext().getValueStack().getRoot());
		System.out.println("-----------update----------");
		System.out.println(model);
//		categoryService.update(category);
		return "index";
	}
	
	public String save(){
		System.out.println("-----------save----------");
		System.out.println(model);
		return "index";
	}
	
	public String query(){
		
		jsonList=accountService.query();
		return "jsonList";
		
	}
	
	public String aindex(){
		return "aindex";
		
	}

}
