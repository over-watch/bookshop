package cn.it.shop.action;

import java.io.ByteArrayInputStream;
import java.util.HashSet;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

import cn.it.shop.model.Forder;
import cn.it.shop.model.Product;
import cn.it.shop.model.Sorder;
@Controller
@Scope("prototype")
public class SorderAction extends BaseAction<Sorder> {
	/**
	 * 
	 */
	

	public String addSorder(){
		//1：根据product.id获取相应的商品数据
		Product product=productService.get(model.getProduct().getId());
		
		//2：判断当前session是否有购物车，如果没有则创建
		if(session.get("forder")==null){
			session.put("forder", new Forder(new HashSet<Sorder>()));
		}
		//3：把商品信息转化为sorder，并且添加到购物车中（判断购物是否重复）
//		model.setName(product.getName());
//		model.setNumber(1);
//		model.setPrice(product.getPrice());
//		model.setProduct(product);
		Forder forder=(Forder)session.get("forder");
//		forder.getSorderSet().add(model);
		forder=sorderService.addSorder(forder, product);
		System.out.println(forder.getName()+":"+forder.getSorderSet());
		//4：计算购物综合
		forder.setTotal(forderService.cluTotal(forder));
		//5：把新的购物车存储到session中
		session.put("forder", forder);
		
		return "showCar";
	}
	
	public String querySale(){
		List<Object> jsonList=sorderService.querySale(model.getNumber());
		ActionContext.getContext().getValueStack().push(jsonList);
		return "jsonList";
	}
	//根据商品编号更新商品数量
	public String updateSorder(){
		Forder forder=(Forder)session.get("forder");
		forder=sorderService.updateSorder( forder,model);
		forder.setTotal(forderService.cluTotal(forder));
		session.put("forder", forder);
		//返回新的总价格
		inputStream=new ByteArrayInputStream(forder.getTotal().toString().getBytes());
		return "stream";
	}

}
