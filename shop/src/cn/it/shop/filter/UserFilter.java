package cn.it.shop.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
			//判断当前session是否有用户信息
		HttpServletRequest req=(HttpServletRequest)request;
		HttpServletResponse res=(HttpServletResponse)response;
		if(req.getSession().getAttribute("user")==null){
//			System.out.println(req.getRealPath("/"));//已过时地址，服务器地址
//			System.out.println(req.getContextPath());//工程目录
			System.out.println(req.getServletPath());//当前地址
			System.out.println(req.getQueryString());//参数
			String goURL=req.getServletPath();
			String param=req.getQueryString();
			if(param!=null){
				goURL=goURL+"?"+param;
			}
			req.getSession().setAttribute("goURL", goURL);
			//非法请求，跳转到登陆页面
			req.getSession().setAttribute("error", "非法请求，请先登录");
			res.sendRedirect(req.getContextPath()+"/ulogin.jsp");
		}else{
			//如果有下一个过滤器跳转，否则直接跳转到目标页面
			chain.doFilter(request, response);
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
