<@ms.html5>
	<@ms.nav title="预约管理" back=true>
		<@ms.saveButton  id="saveUpdate" /> 
	</@ms.nav>
	<@ms.panel>
		<#if reservation.reservationDateBegin??>
			<#assign reservationDateBegin = reservation.reservationDateBegin>
		<#else>
			<#assign reservationDateBegin = .now>
		</#if>
		
		<#if reservation.reservationDateEnd??>
			<#assign reservationDateEnd = reservation.reservationDateEnd>
		<#else>
			<#assign reservationDateEnd = .now>
		</#if>
		
		<@ms.form isvalidation=true name="reservationForm" action="${base}/manager/reservation/save.do" >
			<input type="hidden" name="id" value="${reservation.id?default(0)}">
			<@ms.text name="userName" width="400" label="姓名"	title="姓名"   placeholder="请输入姓名"  value="${reservation.userName?default('')}"  validation={"maxlength":"30","required":"true", "data-bv-notempty-message":"姓名不能为空","data-bv-stringlength-message":"标题在30个字符以内!"}/>
			<@ms.text name="phoneNum" width="400" label="手机号码" placeholder="请输入手机号码" title="" value="${reservation.phoneNum!}"  validation={"required":"true","maxlength":"18","data-bv-stringlength":"true","data-bv-stringlength-max":"18","data-bv-notempty-message":"手机号码不能为空","data-bv-stringlength-message":"手机号码长度不能超过18个字符","data-bv-regexp":"true", "data-bv-regexp-regexp":'^[1][1-8][0-9]{9}',"data-bv-regexp-message":"手机号码格式错误"}/>
			<@ms.date name="reservationDateBegin" width="800" label="预约日期起" single=true readonly="readonly" style="width:36%;" value="${reservationDateBegin?string('yyyy-MM-dd')}" validation={"required":"true", "data-bv-notempty-message":"必填项目"} placeholder="预约日期起"  />
			<@ms.date name="reservationDateEnd" width="800" label="预约日期止" single=true readonly="readonly" style="width:36%;" value="${reservationDateEnd?string('yyyy-MM-dd')}" validation={"required":"true", "data-bv-notempty-message":"必填项目"} placeholder="预约日期止"  />
			<@ms.textarea name="comment" label="备注" width="400" wrap="Soft" rows="4"  size=""  value="${reservation.comment?default('')}" placeholder="备注"/>
		</@ms.form>
	</@ms.panel>
</@ms.html5>	      
<script>
$(document).ready(function(){
	$("#saveUpdate").on("click",function(){
		var vobj = $("#reservationForm").data('bootstrapValidator').validate();
		var actionUrl = $("#reservationForm").attr("action");
		if(vobj.isValid()){
		
		
		
		
			$(this).request({url:actionUrl,data:$("#reservationForm").serialize(),loadingText:"保存中...",method:"post",type:"json",func:function(obj) {
					alert(obj.msg);
					if("success"==obj.msgCode){
						location.href=base+"/manager/reservation/list.do";
					}
			}});
				
				
				
				
			/*$.ajax({
			   type: "POST",
			   url: $("#reservationForm")[0].action,
			   data: $("#reservationForm").serialize(),
			   success: function(msg){
			     if(msg){
			     	try{
			     		var result = eval("("+msg+")");
			     		if("success"==result.msgCode){
			     			alert("保存成功！");
			     			
			     		}else if("error"==result.msgCode){
			     			alert(result.msg);
			     		}else{
			     			alert("保存失败！");
			     		}
			     	}catch(e){
			     		alert("保存失败！");
			     	}
			     }
			   }
			});*/
		}
		//$($("#reservationForm")[0]).submit();
	});		
});
</script>