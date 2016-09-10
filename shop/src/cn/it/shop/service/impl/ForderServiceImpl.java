package cn.it.shop.service.impl;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import cn.it.shop.dao.ForderDao;
import cn.it.shop.dao.impl.BaseDaoImpl;
import cn.it.shop.model.Forder;
import cn.it.shop.model.Sorder;
import cn.it.shop.service.ForderService;

@Service("forderService")
public class ForderServiceImpl extends BaseServiceImpl<Forder> implements
		ForderService {

	


	@Override
	public void updateStatusById(int id, int sid) {
		forderDao.updateStatusById(id, sid);
	}

	@Override
	public BigDecimal cluTotal(Forder forder) {
		BigDecimal total=new BigDecimal(0.00);
		for(Sorder temp:forder.getSorderSet()){
			System.out.println(temp.getPrice());
			total=total.add(temp.getPrice().multiply(new BigDecimal(temp.getNumber())));
		}
		System.out.println(total);
		return total;
	}

//	@Override
//	public double cluTotal(Forder forder) {
//		double total=0.0;
//		for(Sorder temp:forder.getSorderSet()){
//			total +=temp.getNumber()*temp.getPrice();
//		}
//		return total;
//	}
	
	
	

}
