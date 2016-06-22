package com.mingsoft.business.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mingsoft.base.dao.IBaseDao;
import com.mingsoft.base.entity.BaseEntity;
import com.mingsoft.basic.biz.impl.BasicBizImpl;
import com.mingsoft.business.biz.IReservationBiz;
import com.mingsoft.business.dao.IReservationDao;
import com.mingsoft.business.entity.ReservationEntity;
import com.mingsoft.util.PageUtil;

@Service("ReservationBizImpl")
public class ReservationBizImpl extends BasicBizImpl implements IReservationBiz{

	@Autowired
	private IReservationDao reservationDao;
	@Override
	public int queryCountByCond(ReservationEntity reservationEntity) {
		// TODO Auto-generated method stub
		if (reservationEntity==null) {
			reservationEntity = new ReservationEntity();
		}
		
		return this.reservationDao.queryCountByCond(reservationEntity);
	}

	@Override
	public List<ReservationEntity> queryByPage(PageUtil page,
			ReservationEntity reservationEntity) {
		// TODO Auto-generated method stub
		if (reservationEntity!=null) {
			reservationEntity.setPage(page);
			reservationEntity.setOrder(false);
			reservationEntity.setOrderBy("CREATE_TIME");
		}
		return this.reservationDao.queryByPage(reservationEntity);
	}

	@Override
	public void saveEntity(ReservationEntity reservationEntity) {
		// TODO Auto-generated method stub
		if (reservationEntity.getId()==0) {
			this.reservationDao.saveEntity(reservationEntity);
		}else {
			this.reservationDao.updateEntity(reservationEntity);
		}
	}

	@Override
	public void updateEntity(ReservationEntity reservationEntity) {
		// TODO Auto-generated method stub
		this.reservationDao.updateEntity(reservationEntity);
	}
	
	@Override
	public ReservationEntity getReservationEntity(int id) {
		// TODO Auto-generated method stub
		return this.reservationDao.getReservationEntity(id);
	}

	@Override
	protected IBaseDao getDao() {
		// TODO Auto-generated method stub
		return this.reservationDao;
	}

	@Override
	public void deleteEntity(int id) {
		// TODO Auto-generated method stub
		//super.deleteEntity(id);
		this.reservationDao.deleteEntity(id);
	}

	@Override
	public BaseEntity getEntity(int id) {
		// TODO Auto-generated method stub
		return this.getEntity(id);
	}
}
