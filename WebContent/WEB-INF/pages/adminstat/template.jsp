<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/common/taglib.jsp"%>
<c:forEach items="${adminstats}" var="adminstat" varStatus="cindex">
	<tr>
		<td class="tip">${adminstat.id}
			<c:if test="${cindex.index == 0}"><input id="itemCount" type="hidden" value="${count}"></c:if>
		</td>	
		<td class="tip">${adminstat.classname}</td>
		<td class="tip">${adminstat.userId}</td>
		<td class="tip">${adminstat.username}</td>
		<td class="tip" data-time=" ${tz:formatDate(adminstat.createTime,'yyyy-MM-dd HH:mm:ss')}">${tz:timeFormat(adminstat.createTime)}</td>	
		<td class="tip">${adminstat.method}</td>
		<td class="tip">${adminstat.runtime}</td>		
		<td class="tip">${adminstat.ipaddress}</td>
		<td class="tip"><a href="javascript:void(0);">${adminstat.ip}</a></td>
		<td class="tip">操作</td>
	</tr>
</c:forEach>