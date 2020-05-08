<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/common/taglib.jsp"%>
<c:forEach items="${roles}" var="role" varStatus="cindex">
	<tr>
		<td class="tip">${role.id}
			<c:if test="${cindex.index == 0}"><input id="itemCount" type="hidden" value="${count}"></c:if>
		</td>	
		<td class="tip">${role.name}</td>
		<td class="tip" data-time=" ${tz:formatDate(role.createTime,'yyyy-MM-dd HH:mm:ss')}">${tz:timeFormat(role.createTime)}</td>	
		<td class="tip"><a href="javascript:void(0);" data-mark="isDelete" data-id="${role.id}" data-val="${role.isDelete}" onclick="zywPage.op(this)">${role.isDelete==0?"<span class='red'>否</span>":"<span class='green'>是</span>"}</a></td>
		<td class="tip">
			<a href="javascript:void(0)" data-opid="${role.id }" onclick="zywRole.allotUser(this)"><i class="fa fa-user"></i>&nbsp;&nbsp;分配角色</a>
		</td>
		<td class="tip">
			<span><a href="javascript:void(0)" data-opid="${role.id }" onclick="zywRole.impower(this)"><i class="fa fa-send"></i>授权</a></span>
		</td>
	</tr>
</c:forEach>
