<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/common/taglib.jsp"%>
<c:forEach items="${adminusers}" var="adminuser" varStatus="cindex">
	<tr>
		<td class="tip">${adminuser.id}
			<c:if test="${cindex.index == 0}"><input id="itemCount" type="hidden" value="${count}"></c:if>
		</td>	
		<td class="tip">${adminuser.username}</td>
		<td class="tip">${adminuser.email}</td>
		<td class="tip" data-time=" ${tz:formatDate(adminuser.createTime,'yyyy-MM-dd HH:mm:ss')}">${tz:timeFormat(adminuser.createTime)}</td>	
		<td class="tip">${adminuser.age}</td>		
		<td class="tip">${adminuser.male}</td>
		<td class="tip">${adminuser.address}</td>
		<td class="tip">${adminuser.telephone}</td>
		<td class="tip">${tz:formatDate(adminuser.birthday,'yyyy-MM-dd')}</td>
		<td class="tip"><a href="javascript:void(0);">${adminuser.isDelete}</a></td>
		<td class="tip">${adminuser.forbiden}</td>
		<td class="tip">操作</td>
	</tr>
</c:forEach>
