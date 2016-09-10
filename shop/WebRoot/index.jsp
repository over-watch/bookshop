<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <%@ include file="/public/head.jspf" %>
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
                                <li><a href="showCar.jsp">购物车</a></li>
                                <li><a href="${shop }/register.jsp">注册</a></li>
                                <li ><a href="ulogin.jsp">登录</a></li>
                            </ul>
                            <!--头部小导航结束-->
                            <!-- logo -->
                            <h1 class="logo clear fl"> <a href="index.html"><img src="images/logo.png" /></a> </h1>
                            <!-- 购物车 -->
                            <div class="minicart">
                                <a class="minicart_link" href="#">
                                    <span class="item">
                                        <b>暑期大放送</b> ：
                                    </span>
                                    <span class="price">
                                        <b>满100返50</b>
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
                <li class="active highlight"><a href="#">科技</a>
                    <!--二级菜单-->
                    <ul class="sub_menu">
                    </ul>
                </li>
                    <!--二级菜单结束-->
                
                <li><a href="#">经管励志</a>
                    <!--二级菜单-->
                    <ul class="sub_menu">
                    </ul>
                    <!--二级菜单结束-->
                </li>
                <li><a href="#">人文社科</a></li>
                <li><a href="#">生活时尚</a></li>
                <li><a href="#">艺术人生</a></li>
            </ul>
        </div>
        </div>
        <!--导航栏结束-->

        
        <div class="section_container">
            <!--左侧导航-->
            <div id="side_nav">
                <div class="sideNavCategories">
                    <h1>科技类</h1>
                    <ul class="category departments">
                        <li class="header">分类</li>
                        <li><a href="#">园林</a></li>
                        <li><a href="#">科普</a></li>
                        <li><a href="#">农业</a></li>
                        <li><a href="#">医学</a></li>
                        <li><a href="#">电子/通信</a></li>
                        <li><a href="#">科学与自然</a></li>
                        <li><a href="#">工程与工艺技术</a></li>
                        <li><a href="#">计算机与互联网</a></li>
                    </ul>
                </div>
                
            </div>
            <!-- 右侧焦点图区域 -->
            <div id="main_content ">
                <div > <img src="images/lm_banner_1.jpg" /> </div>
            </div>
        </div>

            <!-- 产品列表 -->
            <div class="products_list products_slider clear">
            <!-- 大循环开始 -->
  		<c:forEach items="${applicationScope.bigList }" var="list">
            <!-- 显示类别名称 -->
                
                <ul id="first-carousel" class="first-and-second-carousel jcarousel-skin-tango">
                   <!-- 小循环开始 -->
                   <h2 class="sub_title">${list[0].category.type }</h2>
  					<c:forEach items="${list }" var="product">
                    <li>
                    	 <a  href="${shop }/product_get.action?id=${product.id}" class="product_image"><img src="${shop }/image/${product.pic}" /></a>
                         <div class="product_info">
                            <h3><a href="#">商品名称：${product.name }</a></h3>
                            <small>${product.remark }</small> </div>
                         <div class="price_info"> 
                            <button class="pr_add"><a href="${shop }/sorder_addSorder.action?product.id=${product.id}" >添加购物车</a></button>
                            <button class="price_add" title="" type="button">
                            	<span class="pr_price">￥${product.price }</span>
                            </button>
                         </div>
                    </li>
                    </c:forEach>
                </ul>
                </c:forEach>
            </div>
        <!--产品列表结束  -->
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
                    </ul>
                </li>
                <li> <span>客户服务</span>
                    <ul>
                        <li><a href="#">帮助</a></li>
                        <li><a href="#">速递</a></li>
                        <li><a href="#">退换货</a></li>
                        <li><a href="#">付款方式</a></li>
                        <li><a href="#">订单跟踪</a></li>
                        <li><a href="#">礼物包选项</a></li>
                        <li><a href="#">国际服务</a></li>
                        <li><a href="#">退运险</a></li>
                    </ul>
                </li>
                <li> <span>个人账户</span>
                    <ul>
                        <li><a href="#">个人账户信息</a></li>
                        <li><a href="#">用户密码</a></li>
                        <li><a href="#">订单历史</a></li>
                        <li><a href="#">付款方式</a></li>
                        <li><a href="#">我的收货地址</a></li>
                        <li><a href="#">我的通知</a></li>
                    </ul>
                </li>
            </ul>
            
            </div>
    </div>
  </body>
</html>
