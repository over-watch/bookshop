package cn.it.shop.action;

import java.io.InputStream;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.management.RuntimeErrorException;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.it.shop.model.Category;
import cn.it.shop.model.FileImage;
import cn.it.shop.service.AccountService;
import cn.it.shop.service.CategoryService;
import cn.it.shop.service.ForderService;
import cn.it.shop.service.ProductService;
import cn.it.shop.service.SorderService;
import cn.it.shop.service.UserService;
import cn.it.shop.service.impl.PayService;
import cn.it.shop.util.FileUpload;

import com.opensymphony.xwork2.ActionSupport;
/*
 * Struts执行流程：先创建Action，再调用拦截器，拦截器访问成功再调用Action方法
 * 
 * 在项目启动的时候Struts的过滤器，已经把相应的内置对象，和内置对象对应的map存储到了ActionContext和值栈中，
 * 如果实现了详解****Aware借口，就会从ActionContext中获取相应的Map进行传入实现的拦截器为：servletConfig
*/
import com.opensymphony.xwork2.ModelDriven;

@Controller
@Scope("prototype")
public class BaseAction<T> extends ActionSupport implements RequestAware,SessionAware,ApplicationAware,ModelDriven<T>{
	
	
	protected String ids;
	protected Map<String, Object> request;
	protected Map<String, Object> session;
	protected Map<String, Object> application;
	protected T model;
	
	protected Integer page;
	protected Integer rows;
	protected FileImage fileImage;
	protected InputStream inputStream;
	protected Map<String, Object> pageMap=null;
	
	protected List<T> jsonList=null;
	
	
	
	
	
	
	

	public FileImage getFileImage() {
		return fileImage;
	}

	public void setFileImage(FileImage fileImage) {
		this.fileImage = fileImage;
	}

	public List<T> getJsonList() {
		return jsonList;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	public Map<String, Object> getPageMap() {
		System.out.println("------pageMap-----");
		return pageMap;
	}

	public void setPageMap(Map<String, Object> pageMap) {
		this.pageMap = pageMap;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getRows() {
		return rows;
	}

	public void setRows(Integer rows) {
		this.rows = rows;
	}


	@Resource
	protected CategoryService categoryService;
	@Resource
	protected AccountService accountService;
	@Resource
	protected ForderService forderService;

	@Resource
	protected ProductService productService;
	@Resource
	protected PayService payService;
	@Resource
	protected UserService userService;
	@Resource
	protected SorderService sorderService;
	@Resource
	protected FileUpload fileUpload;
	/*public void setAccountService(AccountService accountService) {
		this.accountService = accountService;
	}

	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	*/
	@Override
	public void setApplication(Map<String, Object> application) {
		this.application=application;
		
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session=session;
	}

	@Override
	public void setRequest(Map<String, Object> request) {
		this.request=request;
		
	}
	
	
	@Override
	public T getModel() {
		ParameterizedType type=(ParameterizedType)this.getClass().getGenericSuperclass();
		Class clazz=(Class)type.getActualTypeArguments()[0];
		try{
			model=(T)clazz.newInstance();
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return model;
	}

}
