<@ms.html5>
	<@ms.nav title="预约列表" back=true></@ms.nav>
	<@ms.panel>
		<#if reservationDateBegin??>
			<#assign reservationDateBegin = reservationDateBegin?string('yyyy-MM-dd')>
		
		</#if>
		
		<#if reservationDateEnd??>
			<#assign reservationDateEnd = reservationDateEnd?string('yyyy-MM-dd')>
		
		</#if>
			<@ms.searchForm   name="searchForm" action="">
					<@ms.text label="姓名" labelStyle="width:80px;text-align:right;"  width="200"  name="userName" value="" title="请输入姓名"  placeholder="请输入姓名" value="${userName?default('')}"/>
					<@ms.date name="reservationDateBegin" labelStyle="width:150px;text-align:right;" width="200" label="预约日期起" single=true readonly="readonly"  value="${reservationDateBegin!}" placeholder="预约日期起"  />
					<@ms.date name="reservationDateEnd" labelStyle="width:150px;text-align:right;" width="200" label="预约日期止" single=true readonly="readonly"  value="${reservationDateEnd!}"  placeholder="预约日期止"  />
					<@ms.text name="phoneNum" label="手机号" placeholder="请输入手机号" title="" labelStyle="width:150px;text-align:right;" width="200"  />
					<@ms.searchFormButton>
						<@ms.queryButton id="submitSearch"/>								
					</@ms.searchFormButton>
				</@ms.searchForm>
				
				<@ms.panelNav>
				<@ms.panelNavBtnGroup>
					<@ms.panelNavBtnAdd title="" />
				</@ms.panelNavBtnGroup>
				</@ms.panelNav>
				<@ms.table head=['姓名,300','手机号码,120','预约日期,250','备注']>
					<#if reservationList?has_content>
			        	<#list reservationList as reservation>
		                	<tr id="tableReservation">
					        	<#--<td>
									<input type="checkbox" name="id" value="${reservation.id?c?default(0)}">
					            </td>-->
					        	<td  >
					        		<a href="${base}/manager/reservation/editReservaiton.do?id=${reservation.id?default(0)}">${reservation.userName!}</a>
					        	</td>
					            <td>
					            	${reservation.phoneNum!}
					            </td>
					            <td>
					            	${reservation.reservationDateBegin?string('yyyy-MM-dd')}至${reservation.reservationDateEnd?string('yyyy-MM-dd')}
					            </td>
					            <td>${reservation.comment?default("")}</td>
			          		</tr>
					   </#list>
			      	<#else>
		            <#if articleShow?has_content>
		             	<tr>
				            <td colspan="8" class="text-center">
				            	<@ms.nodata content="暂无预约"/>
							</td>
			          	</tr>
			        <#else>
			          	<tr>
			            	<td colspan="8" class="text-center">
				            	<@ms.nodata content="没有搜索到预约"/>
							</td>
			          	</tr>
		         	</#if>	
		        </#if>
				</@ms.table>
				<!--分页-->
			   	<@ms.showPage page=page displayedPages=2 edges=2/> 
	</@ms.panel>
</@ms.html5>	
<!--删除限时文章-->    
<@ms.modal modalName="delete" title="删除文章">
	  <@ms.modalBody>
	  		确定要删除所选的文章吗?
     </@ms.modalBody>
	 <@ms.modalButton>
 		<@ms.button class="btn btn-danger rightDelete" value="确定"/>
 	</@ms.modalButton>
</@ms.modal>			
<script>
	$(function(){	
		var listTitle="<#if categoryTitle?has_content>${categoryTitle}<#else>全部</#if>&nbsp;<small><#if articleShow?has_content>列表<#else>查询结果</#if></small>";
		$(".ms-content-body-title>span").html(listTitle);
		//预览文章
		/*$(".preview").click(function(){
			var articleId = $(this).attr("data-id");
			var viewAction = articleId+"detail.do"
			window.open(base+"/manager/cms/generate/"+viewAction+"/viewIndex.do");
		});*/
		//添加文章
		$("#addButton").click(function(){
			location.href = base+"/manager/reservation/editReservaiton.do"; 
		});	
		//编辑文章
		$(".updateArticle").click(function(){
			var id = $(this).attr("data-id");
			location.href = base+"/manager/reservation/editReservaiton.do?id="+id;
		});	
		//全选
	   	$("input[name='allCheck']").on("click",function(){  
			if(this.checked){   
				$("input[name='ids']").each(function(){this.checked=true;});
			}else{   
				$("input[name='ids']").each(function(){this.checked=false;});   
			}
		});		
		//筛选文章
		$("#submitSearch").click(function(){
			//$("#searchForm").attr("action",base+"/manager/reservation/list.do");
			//$("#searchForm").submit();
			var param = "";
			var userNameVal = $("#searchForm input[name='userName']").val();
			if(userNameVal&&""!=userNameVal){
				param += "userName="+userNameVal + "&";
			}
			var reservationDateBeginVal = $("#searchForm input[name='reservationDateBegin']").val();
			if(reservationDateBeginVal&&""!=reservationDateBeginVal){
				param += "reservationDateBegin="+reservationDateBeginVal + "&";
			}
			var reservationDateEndVal = $("#searchForm input[name='reservationDateEnd']").val();
			if(reservationDateEndVal&&""!=reservationDateEndVal){
				param += "reservationDateEnd="+reservationDateEndVal + "&";
			}
			var phoneNumVal = $("#searchForm input[name='phoneNum']").val();
			if(phoneNumVal&&""!=phoneNumVal){
				param += "phoneNum="+phoneNumVal + "&";
			}
			location.href = base+"/manager/reservation/list.do?"+param;
		});
		//点击重置按钮
		$(".reset").click(function(){
			$("input[name=userName]").val("");
			$("input[name=reservationDateBegin]").val("");
			$("input[name=reservationDateEnd]").val("");
			$("input[name=phoneNum]").val("");
		})
	   	var articleId="";//单个文章id
	   	var ids ="";//多个文章id
		
		//多选删除
		$("#delButton").click(function(){
			ids = $("input[name='ids']").serialize();
			if(ids!=""){
				$(".delete").modal();
			}else{
				alert("请选择文章!");
			}
		});
		//删除多个文章
		$(".rightDelete").click(function(){
			if(ids=="" && articleId!="" ){
				ids= "ids="+articleId;
			}
			deletes(ids);
		});

	});
	//删除文章
	function deletes(ids){
		if(ids!=""){
			$(this).request({url:base+"/manager/cms/article/delete.do",type:"json",data:ids,method:"post",func:function(msg) {
				if (msg.result) {
					alert("删除成功！")
					location.href="${basePath}/"+msg.resultData; 
				} else {
					alert("删除失败");
				}
			}});
		}else{
	    	alert("请选择文章！");
	    }
	}
</script>
