/**
The MIT License (MIT) * Copyright (c) 2015 铭飞科技

 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal in
 * the Software without restriction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of
 * the Software, and to permit persons to whom the Software is furnished to do so,
 * subject to the following conditions:

 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.

 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
 * FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 * COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER
 * IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
 * CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package com.mingsoft.basic.entity;

import java.sql.Timestamp;
import java.util.Date;
import com.mingsoft.base.entity.BaseEntity;

/**
 * 基本应用实体绑定
 * @author 王天培QQ:78750478
 * @version 
 * 版本号：100-000-000<br/>
 * 创建日期：2012-03-15<br/>
 * 历史修订：<br/>
 */
public class BasicEntity extends BaseEntity {
	/**
	 * 基本实体自增长编号
	 */
	private int basicId;
	
	/**
	 *标题
	 *长度:200 
	 */
	private String basicTitle;

	/**
	 * 描述
	 * 长度:1500
	 */
	private String basicDescription;
	
	/**
	 * 缩略图
	 * 长度:200
	 */
	private String basicThumbnails;

	/**
	 * 点击次数
	 */
	private int basicHit;

	/**
	 * 发布时间
	 */
	private Timestamp basicDateTime;

	/**
	 * 更新时间
	 */
	private Date basicUpdateTime;

	/**
	 * 用户编号
	 */
	private int basicPeopleId;
	
	/**
	 * 排序
	 */
	private int basicSort;
	


	/**
	 *所属分类编号
	 */
	private int basicCategoryId=0;
	
	/**
	 * 文章所属应用
	 */
	private int basicAppId;
	
	/**
	 * 模块编号
	 */
	private int basicModelId;
	
	public int getBasicModelId() {
		return basicModelId;
	}

	public void setBasicModelId(int basicModelId) {
		this.basicModelId = basicModelId;
	}

	public int getBasicAppId() {
		return basicAppId;
	}

	/**
	 *获取 basicCategoryId
	 * @return basicCategoryId
	 */
	public int getBasicCategoryId() {
		return basicCategoryId;
	}

	/**
	 *获取 basicDateTime
	 * @return basicDateTime
	 */
	public Timestamp getBasicDateTime() {
		return basicDateTime;
	}

	/**
	 *获取 basicDescription
	 * @return basicDescription
	 */
	public String getBasicDescription() {
		return basicDescription;
	}

	/**
	 *获取 basicHit
	 * @return basicHit
	 */
	public int getBasicHit() {
		return basicHit;
	}

	/**
	 *获取 basicId
	 * @return basicId
	 */
	public int getBasicId() {
		return basicId;
	}

	/**
	 *获取 basicPeopleId
	 * @return basicPeopleId
	 */
	public int getBasicPeopleId() {
		return basicPeopleId;
	}

	/**
	 *获取 basicThumbnails
	 * @return basicThumbnails
	 */
	public String getBasicThumbnails() {
		return basicThumbnails;
	}


	/**
	 *获取 basicTitle
	 * @return basicTitle
	 */
	public String getBasicTitle() {
		return basicTitle;
	}

	/**
	 *获取 basicUpdateTime
	 * @return basicUpdateTime
	 */
	public Date getBasicUpdateTime() {
		return basicUpdateTime;
	}

	public void setBasicAppId(int basicAppId) {
		this.basicAppId = basicAppId;
	}

	/**
	 *设置basicCategoryId
	 * @param basicCategoryId
	 */
	public void setBasicCategoryId(int basicCategoryId) {
		this.basicCategoryId = basicCategoryId;
	}


	/**
	 *设置basicDateTime
	 * @param basicDateTime
	 */
	public void setBasicDateTime(Timestamp basicDateTime) {
		this.basicDateTime = basicDateTime;
	}

	/**
	 *设置basicDescription
	 * @param basicDescription
	 */
	public void setBasicDescription(String basicDescription) {
		this.basicDescription = basicDescription;
	}

	/**
	 *设置basicHit
	 * @param basicHit
	 */
	public void setBasicHit(int basicHit) {
		this.basicHit = basicHit;
	}

	/**
	 *设置basicId
	 * @param basicId
	 */
	public void setBasicId(int basicId) {
		this.basicId = basicId;
	}

	/**
	 *设置basicPeopleId
	 * @param basicPeopleId
	 */
	public void setBasicPeopleId(int basicPeopleId) {
		this.basicPeopleId = basicPeopleId;
	}

	/**
	 *设置basicThumbnails
	 * @param basicThumbnails
	 */
	public void setBasicThumbnails(String basicThumbnails) {
		this.basicThumbnails = basicThumbnails;
	}

	/**
	 *设置basicTitle
	 * @param basicTitle
	 */
	public void setBasicTitle(String basicTitle) {
		this.basicTitle = basicTitle;
	}

	/**
	 *设置basicUpdateTime
	 * @param basicUpdateTime
	 */
	public void setBasicUpdateTime(Date basicUpdateTime) {
		this.basicUpdateTime = basicUpdateTime;
	}
	
	public int getBasicSort() {
		return basicSort;
	}

	public void setBasicSort(int basicSort) {
		this.basicSort = basicSort;
	}
	
	
}