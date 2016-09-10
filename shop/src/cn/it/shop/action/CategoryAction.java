package cn.it.shop.action;

import java.io.ByteArrayInputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.it.shop.model.Category;
import cn.it.shop.service.CategoryService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Controller
@Scope("prototype")
public class CategoryAction extends BaseAction<Category>  {
	
	
	

//	private CategoryService categoryService;
//	
//	public void setCategoryService(CategoryService categoryService) {
//		this.categoryService = categoryService;
//	}
//	
	public void update(){
		categoryService.update(model);
	}
	
	public void save(){
		System.out.println(model);
		categoryService.save(model);
	}
	
	
	
	public String query(){
		//显示值栈中的root
//		System.out.println(ActionContext.getContext().getValueStack().getRoot());
//		ActionContext.getContext().put("categoryList",categoryService.query());
//		ActionContext.getContext().getSession().put("categoryList", categoryService.query());
//		ActionContext.getContext().getApplication().put("categoryList", categoryService.query());
//		request.put("categoryList", categoryService.query());
//		session.put("categoryList", categoryService.query());
//		application.put("categoryList", categoryService.query());
		jsonList=categoryService.query();
		
		return "jsonList";
	}
	
	public String queryJoinAccount(){
		//用来存储分页的数据
		pageMap=new HashMap<String,Object>();
		
		System.out.println("type:"+model.getType());
		
		//根据关键字和分页的参数查询相应的数据
		List<Category> categoryList=categoryService.queryJionAccount(model.getType(), page, rows);
		pageMap.put("rows", categoryList);
		pageMap.put("total",categoryService.getCount(model.getType()));
		
		//根据关键字查询总记录数
		//Long total=categoryService.getCount(model.getType());
		
		return "jsonMap";
	}
	
	public String deleteByIds(){
		System.out.println("删除Id为："+ids);
		categoryService.deleteByIds(ids);
		inputStream = new ByteArrayInputStream("true".getBytes());
		return "stream";
	}

}
