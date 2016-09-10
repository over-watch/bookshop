<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <%@ include file="/public/head.jspf" %>
  </head>
  
  <body>
  	<table width="700" border="" cellspacing="0" cellpadding="2">
  	<!-- 大循环开始 -->
  		<c:forEach items="${applicationScope.bigList }" var="list">
  		<!-- 显示当前类别名称 -->
  		<tr>
  			<td colspan="4">
  				${list[0].category.type }
  			</td>
  		</tr>
  		<!-- 显示当前类别的商品信息 -->
  		<tr>
  			<td>
  				<table width="100%" border="0" cellspacing="0" cellpadding="0">
  					<tr>
  					<!-- 小循环开始 -->
  						<c:forEach items="${list }" var="product">
  						<td>
  							<!-- 显示商品具体信息 -->
  							<table width="100%" border="0" cellspacing="0" cellpadding="0">
  								<tr>
  									<td><!-- 商品图片 -->
  										<img src="${shop }/image/${product.pic}" />
  									</td>
  								</tr>
  								<tr>
  									<td>
  										商品名称：${product.name }
  									</td>
  								</tr>
  								<tr>
  									<td>
  										商品价格：${product.price }
  									</td>
  								</tr>
  							</table><!-- 商品信息结束 -->
  						</td><!-- 小循环结束 -->
  						</c:forEach>
  					</tr>
  				</table>
  			</td>
  		</tr><!-- 大循环结束 -->
  		</c:forEach>
  	</table>
    
  </body>
</html>
