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
import java.util.Map;
import com.mingsoft.base.entity.BaseEntity;
import com.mingsoft.basic.biz.IBasicBiz;
import com.mingsoft.basic.constant.e.FieldSearchEnum;
import com.mingsoft.basic.entity.FieldEntity;
import com.mingsoft.util.PageUtil;

/**
 * 
 * 
 * <p>
 * <b>铭飞CMS-铭飞内容管理系统</b>
 * </p>
 * 
 * <p>
 * Copyright: Copyright (c) 2014 - 2015
 * </p>
 * 
 * <p>
 * Company:景德镇铭飞科技有限公司
 * </p>
 * 
 * @author 姓名：张敏
 * 
 * @version 300-001-001
 * 
 * <p>
 * 版权所有 铭飞科技
 * </p>
 *  
 * <p>
 * Comments:字段业务层，继承IBasicBiz 推荐使用IContentModelFieldBiz @see IContentModelFieldBiz
 * </p>
 *  
 * <p>
 * Create Date:2014-9-11
 * </p>
 *
 * <p>
 * Modification history:暂无
 * </p>
 * 
 */
@Deprecated 
public interface IFieldBiz extends IBasicBiz{  
	
	/**
	 * checkbox类表单
	 */
	 int CHECKBOX = 11;

	/**
	 * radio类的表单
	 */
	 int RADIO = 10;

	/**
	 * option 类的表单
	 */
	 int OPTION = 9;

	/**
	 * 整数类的表单
	 */
	 int INT = 4;

	/**
	 * float类的表单
	 */
	 int FLOAT = 5;

	
	
	/**
	 * 查询指定表单的自定义字段列表
	 * @param fieldCmid 表单ID
	 * @return
	 */
	public List<BaseEntity> queryListByCmid(int fieldCmid);
	
	/**
	 * 统计指定表单的字段数量
	 * @param fieldCmid
	 * @return
	 */
	public int queryCountByCmid(int fieldCmid);
	
	/**
	 * 分页查询指定表单的字段
	 * @param fieldCmid 表单ID
	 * @param pageNo 当前页
	 * @param pageSize 每页显示数
	 * @param orderBy 排序字段
	 * @param order 排序方式
	 * @return 返回字段集合
	 */
	public List<BaseEntity> queryByPage(int fieldCmid,PageUtil page,String orderBy,boolean order);
	
	/**
	 * 根据字段名和表单模型id查找符合条件的记录个数
	 * @param fieldName :字段名
	 * @param fieldCmdId : 表单模型id
	 * @return 记录个数
	 */
	public int getCountFieldName(String fieldFieldName,int fieldCmdId);
	
	/**
	 * 通过字段名获取字段实体
	 * @param fieldFieldName 字段名
	 * @return 字段实体
	 */
	public FieldEntity getEntityByFieldName(String fieldFieldName);
	
	/**
	 * 根据内容模型id和字段名查找字段实体
	 * @param cmId
	 * @param fieldFieldName
	 * @return 字段实体
	 */
	public FieldEntity getEntityByCmId(int cmId,String fieldFieldName);
	
	/**
	 * 根据自定义字段信息动态查询表
	 * @param table 表名
	 * @param diyFieldName 自定义字段
	 * @return 返回ID集合
	 */
	public List<Integer> queryListBySQL(String table,Map<String,String> diyFieldName);
	
	/**
	 * 根据内容模型id获取到所有的字段
	 * @param contentModelId 内容模型字段
	 * @return 字段列表
	 */
	public List<FieldEntity> queryByContentModelId(int contentModelId);
	
	/**
	 * 查询需要搜索的字段列表信息
	 * @param contentMdoel 内容模型id
	 * @param fieldIsSearch 是否支持搜索
	 * @return 字段列表信息
	 */
	public List<FieldEntity> queryByIsSearch(int contentMdoelId,FieldSearchEnum fieldIsSearch);
	
	/**
	 * 根据模型ID删除相应字段
	 * @param fieldCmid 模型ID
	 */
	public void deleteEntityByFieldCmid(int fieldCmid);
}