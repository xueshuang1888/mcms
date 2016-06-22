package com.mingsoft.business.biz;

import java.util.List;

import com.mingsoft.basic.biz.IBasicBiz;
import com.mingsoft.business.entity.ReservationEntity;
import com.mingsoft.util.PageUtil;

public interface IReservationBiz extends IBasicBiz{

	public int queryCountByCond(ReservationEntity reservationEntity);
	public List<ReservationEntity> queryByPage(PageUtil page,ReservationEntity reservationEntity);
	public void saveEntity(ReservationEntity reservationEntity);
	public void deleteEntity(int id);
	public ReservationEntity getReservationEntity(int id);
	public void updateEntity(ReservationEntity reservationEntity);
	
	
}
