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

package com.mingsoft.basic.action;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import com.mingsoft.basic.action.BaseAction;
import com.mingsoft.basic.biz.IMailBiz;
import com.mingsoft.basic.constant.e.MailEnum;
import com.mingsoft.basic.entity.MailEntity;
import com.mingsoft.util.StringUtil;

/**
 * 邮箱接口管理层
 * @author 杨新远
 * @version 
 * 版本号：100-000-000<br/>
 * 创建日期：2015-1-10<br/>
 * 历史修订：<br/>
 */
@Controller
@RequestMapping("/manager/mail")
public class MailAction extends BaseAction{
	
	/**
	 * 邮箱业务层
	 */
	@Autowired
	private IMailBiz mailBiz;
	
	/**
	 * 加载邮箱接口配置页面并返回邮箱实体
	 * @param request 请求对象
	 * @param response 响应对象
	 * @return 邮箱接口配置页面地址
	 */
	@RequestMapping("/mailConfig")
	public String mailConfig(HttpServletRequest request, HttpServletResponse response){
		int appId = this.getAppId(request);
		MailEntity mailEntity = mailBiz.getByAppId(appId);
		request.setAttribute("mailEntity", mailEntity);
		return "/manager/mail/mail";
	}
	
	/**
	 * 测试邮件接口
	 * @param request 请求对象
	 * @param response 响应对象
	 */
	@RequestMapping("/mailTest")
	public void mailTest(HttpServletRequest request, HttpServletResponse response){
		int appId = this.getAppId(request);
		String[] toUser = request.getParameterValues("toUser");
		this.sendMail(request, MailEnum.TEXT, "测试邮件-文本", "<span>测试内容</span>", toUser);
		this.sendMail(request, MailEnum.HTML, "测试邮件-html文本", "<body><p>Hello Html Email 纯屌丝</p><img src='http://d1.sina.com.cn/201504/30/627400.jpg'/></body>", toUser);
	}
	
	/**
	 * 添加邮箱接口
	 * @param mailEntity 邮箱实体
	 * @param request 请求对象
	 * @param response 响应对象
	 */
	@RequestMapping("/save")
	public void save(@ModelAttribute  MailEntity mailEntity,HttpServletRequest request, HttpServletResponse response){
		
			if(
					StringUtil.isBlank(mailEntity.getMailName())
					||StringUtil.isBlank(mailEntity.getMailPassword())
					||StringUtil.isBlank(mailEntity.getMailServer())
					||StringUtil.isBlank(mailEntity.getMailPort())
					){
						this.outJson(response,null,false);
						return;
					}
			mailEntity.setMailAppId(this.getAppId(request));
			mailEntity.setMailModelId(this.getModelCodeId(request));
			mailBiz.saveEntity(mailEntity);
			this.outJson(response,null,true);
	}
	
	/**
	 * 更新邮箱接口
	 * @param mailEntity 邮箱接口实体
	 * @param request 请求对象
	 * @param response 响应对象
	 */
	@RequestMapping("/update")
	public void update(@ModelAttribute  MailEntity mailEntity,HttpServletRequest request, HttpServletResponse response){
		if(mailEntity!=null){
			mailEntity.setMailAppId(this.getAppId(request));
			mailBiz.updateEntity(mailEntity);
			this.outJson(response,null,true);
			return;
		}
		this.outJson(response,null,false);
	}
}