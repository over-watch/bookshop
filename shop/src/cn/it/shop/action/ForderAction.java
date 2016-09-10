package cn.it.shop.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import cn.it.shop.model.Forder;
import cn.it.shop.model.Status;
import cn.it.shop.model.User;

@Controller
@Scope("prototype")
public class ForderAction extends BaseAction<Forder> {
	
	
	
	
	@Override
	public Forder getModel() {
		model=(Forder)session.get("forder");
		return model;
	}

	//实现购物车（订单）与购物项（商品）级联入库
	public String save(){
		//把session中的购物项交给当前的model对象
//		Forder forder=(Forder)session.get("forder");
//		model.setSorderSet(forder.getSorderSet());
//		forder.setAddress(model.getAddress());
//		forder.setName(model.getName());
//		forder.setPhone(model.getPhone());
//		forder.setPost(model.getPost());
//		forder.setRemark(model.getRemark());
		model.setStatus(new Status(1));
		model.setUser((User)session.get("user"));
		//级联入库（需要在XML中配置），需要sorder关联forder，在SorderServiceImpl业务逻辑中，追加sorder.setForder(forder);
		forderService.save(model);
//		session.put("oldForder", session.get("forder"));
//		//此时购物车已经入库，那么原来session中的购物车就应该清空
//		session.put("forder", new Forder());
		session.put("oldForder", session.remove("forder"));
		
		return "bank";
	}

}
