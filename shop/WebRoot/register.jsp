<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
 	<%@ include file="/public/head.jspf" %>
 	<script type="text/javascript" src="jquery-easyui-1.3.5/jquery-1.8.3.js"></script>
 	<script type="text/javascript" src="jquery-easyui-1.3.5/jquery.validate.js"></script>
 	<script type="text/javascript">
 		$(function(){
 			//187行有缺省的验证方法，282行，有验证方法出错的错误消息
 			//让当前表单调用validate方法，实现表单验证功能
 			$("#ff").validate({
 				//debug:true, //调试模式，验证成功
 				onkeyup:true,
 				errorElement:"label",
 				success:'ok',
 				errorPlacement:function(error,element){
 					$(element).parent().next().html(error);
 				},
 				rules:{
 					login:{
 						required:true
 						//remote:'ajax_check.action'
 					},
 					 pass:{
 						required:true,
 						rangelength:[6,12]
 					},
 					pass2:{
 						required:true,
 						equalTo:'#pass'
 					},
 					name:{
 						required:true
 					},
 					phone:{
 						required:true,
 						rangelength:[11,11]
 					},
 					email:{
 						required:true,
 						email:true
 					}
 				} ,
 				messages:{
 					login:{
 						required:'登录名必填'
 					},
 					pass:{
 						required:'密码必填',
 						rangelength:$.format("字段长度必须为{0}到{1}之前")
 					},
 					pass2:{
 						required:'密码确认必填',
 						equalTo:'密码必须一致'
 					},
 					name:{
 						required:'昵称必填',
 					},
 					phone:{
 						required:'手机号必填',
 						rangelength:'长度不正确'
 					},
 					email:{
 						required:'邮箱必填',
 						email:'邮箱格式不正确'
 					}
 				}
 			});
 		});
 	</script>
 	<style type="text/css">
 		form label {
 			color:red;
 			background-image:url("images/wrong.png");
 			background-repeat:no-repeat;
 			padding-left:20px;
 		}
 		.ok{
 			background-image:url("images/right.png");
 			background-repeat:no-repeat;
 		}
 		table{
 			margin:50px 0 0 500px;
 			border:0;
 		}
 		table td{
 			border:0;
 			height:40px;
 			
 		}
 	
 		
 	</style>
  </head>
  
  <body>
  	<div class="wrapper">
  		<div class="header">
            <div class="header_container">
                <!--头部开始-->
                        <div class="top_bar clear">
                            <!--头部小导航-->
                            <div class="welcom fl">欢迎光临書长久 <span color="green"><a href="${shop }/send_main_aindex.action" >到后台</a></span></div>
                            <ul class="top_links fr">
                                <li class="highlight"><a href="#">首页</a></li>
                                <li><a href="#">我的账户</a></li>
                                <li><a href="#">购物车</a></li>
                                <li><a href="#">注册</a></li>
                                <li ><a href="ulogin.jsp">登录</a></li>
                            </ul>
                            <!--头部小导航结束-->
                            <!-- logo -->
                            <h1 class="logo clear fl"> <a href="index.html"><img src="images/logo.png" /></a> </h1>
                            <!-- 购物车 -->
                            <div class="minicart">
                                <a class="minicart_link" href="#">
                                    <span class="item">
                                        <b></b>
                                    </span>
                                    <span class="price">
                                        <b></b>
                                    </span>
                                </a>
                            </div>
                            <!-- 购物车结束 -->
                            <!-- 搜索框 -->
                            <div class="header_search">
                                <div class="form-search ">
                                    <input  value="请输入商品名称" class="input-text"  type="text"/>
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
		<div id="dd" class="action_buttonbar" style="text-align:center;">
				<form id="ff" method="post" action="${shop}/user_save.action">
				<table height="30px" border="0px">
					<tr align="left">
						<td>帐&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号:&nbsp;</td> 
						<td><input type="text" name="login" /></td>
						<td>&nbsp;</td>
					</tr >
					<tr align="left">
						<td>密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码:&nbsp;</td>
						<td><input id="pass" type="password" name="pass" /></td>
						<td>&nbsp;</td>
					</tr>
					<tr align="left">
						<td>确认密码:</td> 
						<td><input type="password" name="pass2" /></td>
						<td>&nbsp;</td>
					</tr>
					<tr align="left">
						<td>昵&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;称:&nbsp;</td> 
						<td><input type="text" name="name" /></td>
						<td>&nbsp;</td>
					</tr>
					<tr align="left">
						<td>性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别:&nbsp;</td>
						<td>男:<input name="sex" type="radio" checked="checked" value="男"/>&nbsp;&nbsp;女:<input name="sex" type="radio" value="女"/></td>
					</tr>
					<tr align="left">
						<td>联系方式:</td> 
						<td><input type="text" name="phone" /></td>
						<td>&nbsp;</td>
					</tr>
					<tr align="left">
						<td>邮&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;箱:&nbsp;</td> 
						<td><input type="text" name="email" /></td>
						<td>&nbsp;</td>
					</tr>
					<tr align="center" >
						<td><input id="submit" type="submit" value="提交" style="width:60px;height:30px" />
						<input type="button" value="重置" onclick="window.open('${shop}/index.jsp','_self')" style="width:60px;height:30px" /></td>
						
					</tr>
					</table>
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
