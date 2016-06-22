package com.mingsoft.business.entity;

import java.util.Date;

import com.mingsoft.basic.entity.BasicEntity;
import com.mingsoft.util.PageUtil;


/**
 * 预约管理
 * @author 678
 *
 */
public class ReservationEntity extends BasicEntity {
	
	private int id;
	private String userName;
	private String phoneNum;
	private Date reservationDateBegin;
	private Date reservationDateEnd;
	private String comment;
	private Date createTime;
	private String dealFlag;//是否处理
    private String openId;//微信ID
	private Date modifyTime;//修改时间
	
	
	private PageUtil page;
	private String orderBy;
	private boolean order;
	
	
	
	public PageUtil getPage() {
		return page;
	}
	public void setPage(PageUtil page) {
		this.page = page;
	}
	public String getOrderBy() {
		return orderBy;
	}
	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}
	public boolean isOrder() {
		return order;
	}
	public void setOrder(boolean order) {
		this.order = order;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public Date getReservationDateBegin() {
		return reservationDateBegin;
	}
	public void setReservationDateBegin(Date reservationDateBegin) {
		this.reservationDateBegin = reservationDateBegin;
	}
	public Date getReservationDateEnd() {
		return reservationDateEnd;
	}
	public void setReservationDateEnd(Date reservationDateEnd) {
		this.reservationDateEnd = reservationDateEnd;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getDealFlag() {
		return dealFlag;
	}
	public void setDealFlag(String dealFlag) {
		this.dealFlag = dealFlag;
	}
	public String getOpenId() {
		return openId;
	}
	public void setOpenId(String openId) {
		this.openId = openId;
	}
	public Date getModifyTime() {
		return modifyTime;
	}
	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}
	
	
	
}
