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

package com.mingsoft.basic.biz;

import java.util.List;
import com.mingsoft.base.biz.IBaseBiz;
import com.mingsoft.basic.entity.DiyFormFieldEntity;

/**
 * 自定义表单接口
 * @author 王天培QQ:78750478
 * @version 
 * 版本号：100-000-000<br/>
 * 创建日期：2012-03-15<br/>
 * 历史修订：<br/>
 */
public interface IDiyFormFieldBiz extends IBaseBiz{
	
	/**
	 * 通过from的id获取实体
	 * @param diyFormId　自定义表单id 
	 * @return　返回实体
	 */
	List<DiyFormFieldEntity> queryByDiyFormId( int diyFormId);
	
	/**
	 * 获取自定义表单字段
	 * @param diyFormFieldFormId　自定义表单id 
	 * @param diyFormFieldFieldName 　自定义表单字段名
	 * @return 返回自定义表单实体
	 */
	DiyFormFieldEntity  getByFieldName(Integer diyFormFieldFormId,String diyFormFieldFieldName);
	
}