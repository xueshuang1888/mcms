package com.mingsoft.business.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mingsoft.base.action.BaseAction;
import com.mingsoft.base.constant.CookieConst;
import com.mingsoft.business.biz.IReservationBiz;
import com.mingsoft.business.entity.ReservationEntity;
import com.mingsoft.util.PageUtil;

@Controller("reservationAction")
@RequestMapping("/manager/reservation")
public class ReservationAction extends BaseAction{

	@Autowired
	private IReservationBiz reservationBiz;
	
	@RequestMapping("/list")
	public String list(@ModelAttribute("reservation") ReservationEntity reservation,HttpServletRequest request, ModelMap mode, HttpServletResponse response){
		
		/*PageUtil page = new PageUtil(pageNo, recordCount, linkUrl);
		this.reservationBiz.queryByPage(page, "createTime", true);*/
		if (reservation==null) {
			reservation =  new ReservationEntity();
		}
		// 查询数据表中记录集合总数
		int count = this.reservationBiz.queryCountByCond(reservation);
		
		// 当前页面
		int pageNo = 1;
		// 获取页面的当页数
		if (request.getParameter("pageNo") != null) {
			pageNo = Integer.parseInt(request.getParameter("pageNo"));
		}
		
		String url =  "/manager/reservation/list.do";
		// 分页集合
		PageUtil page = new PageUtil(pageNo, 20, count, getUrl(request) + url);
		// 实例化对象
		List<ReservationEntity> reservationList = this.reservationBiz.queryByPage(page, reservation);
		
		// 实例化对象
		mode.addAttribute("reservationList", reservationList);
		mode.addAttribute("page", page);
		
		mode.addAttribute("articleShow", "");
		
		//将搜索的参数再传回页面
		mode.addAttribute("userName", reservation.getUserName());
		mode.addAttribute("reservationDateBegin", reservation.getReservationDateBegin());
		mode.addAttribute("reservationDateEnd", reservation.getReservationDateEnd());
		mode.addAttribute("phoneNum", reservation.getPhoneNum());
		
		// 返回路径
		this.setCookie(request, response, CookieConst.BACK_COOKIE,url+"&pageNo="+pageNo);
		return "manager/cms/reservation/reservation_list";
	} 
	
	@RequestMapping("/editReservaiton")
	public String editReservation(@ModelAttribute("reservation") ReservationEntity reservation,HttpServletRequest request, ModelMap mode, HttpServletResponse response){
		mode.addAttribute("reservation", reservation);
		return "manager/cms/reservation/edit_reservation";
	}
	
	@RequestMapping("/save")
	@ResponseBody
	public Map<String, String> saved(@ModelAttribute("reservation")ReservationEntity reservation, HttpServletRequest request,HttpServletResponse response){
		
		//ReservationEntity reservation = new ReservationEntity();
		Map<String, String> msgMap = new HashMap<String,String>();
		String msg = "";
		if (reservation.getUserName()==null||"".equals(reservation.getUserName())) {
			msg += "姓名不能为空\n";
		}
		if (reservation.getPhoneNum()==null||"".equals(reservation.getPhoneNum())) {
			msg += "手机号不能为空\n";
		}
		
		if (reservation.getReservationDateBegin()==null||reservation.getReservationDateEnd()==null) {
			msg += "预约时间不能为空\n";
		}
		if (!"".equals(msg)) {
			//msg = "{msgCode:'error',msg:'"+msg+"'}";
			msgMap.put("msgCode", "error");
			msgMap.put("msg", msg);
			return msgMap;
		}
		
		try {
			this.reservationBiz.saveEntity(reservation);
			//msg = "{msgCode:'success',msg:'保存成功！'}";
			msgMap.put("msgCode", "success");
			msgMap.put("msg", "保存成功！");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			//msg = "{msgCode:'failur',msg:'系统错误！'}";
			msgMap.put("msgCode", "failur");
			msgMap.put("msg", "系统错误！");
		}	
		
		return msgMap;
	}
	
	@RequestMapping("/testPage")
	public String testPage(@ModelAttribute("reservation") ReservationEntity reservation,HttpServletRequest request, ModelMap mode, HttpServletResponse response){
		mode.addAttribute("reservation", reservation);
		return "manager/cms/reservation/edit_reservation";
	}
	
	@ModelAttribute("reservation")
	public ReservationEntity getReservationEntity(@RequestParam(value="id",required=false)Integer id){
		ReservationEntity reservationEntity = null;
		if (id!=null&&id!=0) {
			reservationEntity = this.reservationBiz.getReservationEntity(id);
		}else{
			reservationEntity = new ReservationEntity();
			
		}
		
		return reservationEntity;
	}
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		 SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
		//dataBinder.registerCustomEditor(Boolean.class, new CustomBooleanEditor(true));
	}

	
}
