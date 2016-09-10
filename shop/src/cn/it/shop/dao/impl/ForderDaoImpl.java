package cn.it.shop.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import cn.it.shop.dao.ForderDao;
import cn.it.shop.model.Forder;
import cn.it.shop.model.Sorder;
import cn.it.shop.service.ForderService;
import cn.it.shop.service.impl.BaseServiceImpl;

@Repository("forderDao")
public class ForderDaoImpl extends BaseDaoImpl<Forder> implements
		ForderDao {

	@Override
	public void updateStatusById(int id, int sid) {
		
		
	}


}
