package cn.it.shop.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import cn.it.shop.dao.impl.BaseDaoImpl;
import cn.it.shop.model.Forder;
import cn.it.shop.model.Product;
import cn.it.shop.model.Sorder;
import cn.it.shop.service.SorderService;

@Service("sorderService")
public class SorderServiceImpl extends BaseServiceImpl<Sorder> implements
		SorderService {

	@Override
	public Forder addSorder(Forder forder,Product product) {
		System.out.println("----add-----");
		boolean isHave=false;
		Sorder sorder=productToSorder(product);
		//判断当前购物项是否重复，如果重复则添加数量即可
		for(Sorder old:forder.getSorderSet()){
			if(old.getProduct().getId().equals(sorder.getProduct().getId())){
				//购物项有重复，添加数量即可
				old.setNumber(old.getNumber()+sorder.getNumber());
				isHave=true;
				break;
			}
		}
		//说明当前购物项在当前购物车中不存在，新添加
		if(!isHave){
			//建立购物项与购物车的关联，此时forder.id为null,但是在入库的时候先入库购物车，再入库购物项，那时就有主键了
			sorder.setForder(forder);
			forder.getSorderSet().add(sorder);
		}
		return forder;
	}

	@Override
	public Sorder productToSorder(Product product) {
		Sorder sorder=new Sorder();
		sorder.setName(product.getName());
		sorder.setNumber(1);
		sorder.setPrice(product.getPrice());
		sorder.setProduct(product);
		return sorder;
	}

	@Override
	public List<Object> querySale(int number) {
		return sorderDao.querySale(number);
	}

	@Override
	public Forder updateSorder(Forder forder, Sorder sorder) {
		for(Sorder temp:forder.getSorderSet()){
			if(temp.getProduct().getId().equals(sorder.getProduct().getId())){
				temp.setNumber(sorder.getNumber());
			}
		}
		return forder;
	}

	@Override
	public List<Product> querySaleNumber(int number) {
		return null;
	}

	

	
	
	
}
