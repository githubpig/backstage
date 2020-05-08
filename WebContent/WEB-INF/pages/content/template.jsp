<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/common/taglib.jsp"%>
<c:forEach items="${contents}" var="content" varStatus="cindex">
	<tr>
		<td class="tip">${content.id}
			<c:if test="${cindex.index == 0}"><input id="itemCount" type="hidden" value="${count}"></c:if>
		</td>	
		<td class="tip key">${content.title}</td>
		<td class="tip">${content.channelId}</td>	
		<td class="tip">${content.userId}</td>
		<td class="tip" data-time=" ${tz:formatDate(content.createTime,'yyyy-MM-dd HH:mm:ss')}">${tz:timeFormat(content.createTime)}</td>	
		<td class="tip"><a href="javascript:void(0)" data-mark="isTop" data-id="${content.id}" data-val="${content.isTop}" onclick="zywPage.op(this)">${content.isTop==0?"<span class='red'>否</span>":"<span class='green'>是</span>"}</a></td>
		<td class="tip"><a href="javascript:void(0)" data-mark="push" data-id="${content.id}" data-val="${content.push}" onclick="zywPage.op(this)">${content.push==0?"<span class='red'>否</span>":"<span class='green'>是</span>"}</a></td>	
		<td class="tip"><a href="javascript:void(0)" data-mark="isComment" data-id="${content.id}" data-val="${content.isComment}" onclick="zywPage.op(this)">${content.isComment==0?"<span class='red'>否</span>":"<span class='green'>是</span>"}</a></td>	
		<td class="tip"><a href="javascript:void(0)" data-mark="status" data-id="${content.id}" data-val="${content.status}" onclick="zywPage.op(this)">${content.status==0?"<span class='red'>否</span>":"<span class='green'>是</span>"}</a></td>		
		<td class="tip"><a href="javascript:void(0);" data-mark="isDelete" data-id="${content.id}" data-val="${content.isDelete}" onclick="zywPage.op(this)">${content.isDelete==0?"<span class='red'>否</span>":"<span class='green'>是</span>"}</a></td>
		<td class="tip"><a href="javascript:void(0);" data-id="${content.id}" onclick="zywPage.remove(this)">删除</a></td>
	</tr>
</c:forEach>