<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<%@include file="/public/head.jspf"%>
	<script type="text/javascript">
		$(function(){
			//注册事件
			$(".text").change(function(){
				//验证数据的有效性,必须是自然数
				var number=this.value;
				if(!isNaN(number)&&parseInt(number)==number&&number>0){
					//更新合法数据
					$(this).attr("lang",number);
					var pid=$(this).parents("tr:first").attr("lang");
					//发送ajax请求，传输当前的数量与商品的id，返回的是总价格
					$.post("sorder_updateSorder.action",{number:number,'product.id':pid},function(total){
						$("#total").html(total);
						
					},"text");
						
					 var price=($(this).parent().prev().html()*number).toFixed(2);
					
					$(this).parent().next().html(price);
				}else{
					this.value=$(this).attr("lang");
				}
			});
		});
	</script>
	
<body>
	<div class="wrapper">
		<div class="header">
			<div class="header_container">
				<!--头部开始-->
				<div class="top_bar clear">
					<!--头部小导航-->
					<div class="welcom fl">欢迎光临書长久 </div>
					<ul class="top_links fr">
						<li class="highlight"><a href="index.jsp">首页</a></li>
						<li><a href="#">我的账户</a></li>
						<li><a href="#">购物车</a></li>
						<li><a href="#">注册</a></li>
						<li><a href="#">登录</a></li>
					</ul>
					<!--头部小导航结束-->
					<!-- logo -->
					<h1 class="logo clear fl">
						<a href="index.html"> <img src="images/logo.png" /> </a>
					</h1>
					<!-- 小购物车 -->
					<div class="minicart">
						<a class="minicart_link" href="#"> <span class="item">
								<b>暑期大放送</b> ： </span> <span class="price"> <b>满100返50</b> </span> </a>
					</div>
					<!-- 小购物车结束 -->
					<!-- 搜索框 -->
					<div class="header_search">
						<div class="form-search ">
							<input value="请输入商品名称" class="input-text" type="text" />
							<button type="submit" title="Search"></button>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- 头部结束 -->
		<!-- 导航栏 -->
		<div class="navigation_container">
			<!---->
			<div class="nav">
				<ul class="primary_nav">
					<li class="active highlight"><a href="#">科学技术</a> <!--二级菜单-->
						<ul class="sub_menu">
							<li><a href="#">1</a>
								<ul>
									<li><a href="#">2</a></li>
									<li><a href="#">3</a></li>
									<li><a href="#">4</a></li>
									<li><a href="#">5</a></li>
									<li><a href="#">6</a></li>
									<li><a href="#">7</a></li>
									<li><a href="#">8</a></li>
								</ul></li>
							
						</ul></li>
					<!--二级菜单结束-->
					<li><a href="#">经管励志</a> <!--二级菜单-->
						<ul class="sub_menu">
							
						</ul> <!--二级菜单结束--></li>
					<li><a href="#">人文社科</a></li>
					<li><a href="#">生活时尚</a></li>
					<li><a href="#">艺术人生</a></li>
				</ul>
			</div>
		</div>
		<!--导航栏结束-->
		<div class="section_container">
			<!-- 购物车 -->
			<div id="shopping_cart">
				<div class="message success">我的购物车</div>
				<table class="data-table cart-table" cellpadding="0" cellspacing="0">
					<tr>
						<th class="align_center" width="10%">商品编号</th>
						<th class="align_left" width="35%" colspan="2">商品名称</th>
						<th class="align_center" width="10%">销售价格</th>
						<th class="align_center" width="20%">数量</th>
						<th class="align_center" width="15%">小计</th>
						<th class="align_center" width="10%">删除</th>
					</tr>
					<c:forEach items="${sessionScope.forder.sorderSet }" var="sorder">
					<tr lang="${sorder.product.id }">
						<td class="align_center"><a href="#" class="edit">${sorder.product.id }</a>
						</td>
						<td width="80px"><img src="${shop }/image/${sorder.product.pic}" width="80"
							height="80" />
						</td>
						<td class="align_left"><a class="pr_name" href="#">${sorder.name }</a>
						</td>
						<td class="align_center vline">${sorder.price }
						</td>
						<td class="align_center vline">
								<input class="text" style="height: 20px;" value="${sorder.number }" lang="${sorder.number }">		
						</td>
						<td class="align_center vline">￥${sorder.price*sorder.number }
						</td>
						<td class="align_center vline"><a href="#" class="remove"></a>
						</td>
					</tr>
					</c:forEach>
				</table>
				<!-- 结算 -->
				<div class="totals">
					<table id="totals-table">
						<tbody>
							<tr>
								<td width="60%" colspan="1" class="align_left"><strong>小计</strong>
								</td>
								<td class="align_right" style="" ><strong><span
										class="price" >￥${sessionScope.forder.total }</span>
								</strong>
								</td>
							</tr>
							<tr>
								<td width="60%" colspan="1" class="align_left">运费</td>
								<td class="align_right" style=""><span class="price">￥0.00</span>
								</td>
							</tr>
							<tr>
								<td width="60%" colspan="1" class="align_left total"><strong>总计</strong>
								</td>
								<td class="align_right" style="" ><span class="total" id="total">￥<strong>${sessionScope.forder.total }</strong>
								</span>
								</td>
							</tr>
						</tbody>
					</table>
					<div class="action_buttonbar">
						<button type="button" title="" class="checkout fr"
							style="background-color: #f38256;">
							<font><font><a href="${shop }/user/confirm.jsp">订单确认</a></font>
							</font>
						</button>
						<button type="button" title="" class=" fr">
							<font><font>清空购物车</font>
							</font>
						</button>
						<button type="button" title="" class="continue fr">
							<font><font><a href="${shop }/index.jsp">继续购物</a></font>
							</font>
						</button>
						<div style="clear:both"></div>
					</div>
				</div>
			</div>
			<!-- 导航栏结束 -->
			<div class="footer_container">
				<div class="footer">
					<ul class="footer_links">
						 <li> <span>收藏本店</span>
                    <ul>
                        <li><a href="#">工具书</a></li>
                        <li><a href="#">考级</a></li>
                        <li><a href="#">专业书</a></li>
                        <li><a href="#">小说</a></li>
                        <li><a href="#">漫画</a></li>
                        <li><a href="#">期刊</a></li>
                        <li><a href="#">少儿</a></li>
                    </ul>
                </li>
                <li class="seperator"> <span>出售的书籍</span>
                    <ul>
                        <li><a href="#">历史军事</a></li>
                        <li><a href="#">政治地理</a></li>
                        <li><a href="#">经天纬地</a></li>
                        <li><a href="#">时尚刊物</a></li>
                        <li><a href="#">胎教少儿</a></li>
                        <li><a href="#">青春文艺</a></li>
                        <li><a href="#">生活节奏</a></li>
                        <li><a href="#">艺术情操</a></li>
							</ul></li>
						<li><span>客户服务</span>
							<ul>
								<li><a href="#">帮助</a></li>
								<li><a href="#">速递</a></li>
								<li><a href="#">退换货</a></li>
								<li><a href="#">付款方式</a></li>
								<li><a href="#">订单跟踪</a></li>
								<li><a href="#">礼物包选项</a></li>
								<li><a href="#">国际服务</a></li>
								<li><a href="#">退运险</a></li>
							</ul></li>
						<li><span>个人账户</span>
							<ul>
								<li><a href="#">个人账户信息</a></li>
								<li><a href="#">用户密码</a></li>
								<li><a href="#">订单历史</a></li>
								<li><a href="#">付款方式</a></li>
								<li><a href="#">我的收货地址</a></li>
								<li><a href="#">我的通知</a></li>
							</ul></li>
					</ul>
				</div>
			</div>
</body>
</html>
