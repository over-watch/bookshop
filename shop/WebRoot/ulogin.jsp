<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<%@include file="/public/head.jspf"%>
	
	<style type="text/css">
		#dd div{
			padding: 5px;
		}
	</style>
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
						<li><a href="ulogin.jsp">登录</a></li>
					</ul>
					<!--头部小导航结束-->
					<!-- logo -->
					<h1 class="logo clear fl">
						<a href="index.html"> <img src="images/logo.png" /> </a>
					</h1>
					<!-- 小购物车 -->
					<div class="minicart">
						<a class="minicart_link" href="#"> <span class="item">
								 </span> </a>
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
			<div id="dd" class="action_buttonbar" style="text-align:center;">
				<form method="post" action="${shop}/user_login.action">
					<div>
						<label for="login">账号:&nbsp;</label> 
						<input type="text" name="login" />
					</div>
					<div>
						<label for="pass">密码:&nbsp</label> 
						<input type="text" name="pass" />
					</div>
					<div>
						${sessionScope.error}  
					</div>
					<div>
						<input type="submit" value="登陆" style="width:60px;height:30px" />
						<input type="button" value="注册" onclick="window.open('${shop}/index.jsp','_self')" style="width:60px;height:30px" />
					</div>
			   </form>
			   <div style="clear:both"></div>
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
