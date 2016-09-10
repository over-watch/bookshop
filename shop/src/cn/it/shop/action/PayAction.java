package cn.it.shop.action;

import org.springframework.stereotype.Controller;

import com.sun.org.apache.bcel.internal.generic.RETURN;

import cn.it.shop.model.Forder;
import cn.it.shop.model.SendData;
import cn.it.shop.model.User;

@Controller
public class PayAction extends BaseAction<SendData> {
	
	
	
	public String goBank(){
		//1:补全参数p2 p3 pa pb
		Forder forder=(Forder) session.get("oldForder");
		User user=(User)session.get("user");
		model.setP2_Order(forder.getId().toString());
		model.setP3_Amt(forder.getTotal().toString());
		model.setPa_MP(user.getEmail()+","+user.getPhone());
		//2:对参数进行追加
		
		//3:加密获取签名
		//4:存储到request中
		payService.saveDataToRequest(request, model);
		//5:跳转到支付页面
		return "pay";
	}
}
