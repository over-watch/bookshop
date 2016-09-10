<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<!-- 引入公共的JSP片段 -->
	<%@ include file="/public/head.jspf"%>
	<script type="text/javascript">
	$(function(){
		
		//自定义验证方法,向validatebox.defaults.rules中注册新函数
		$.extend($.fn.validatebox.defaults.rules,{
			//函数的名称：函数实现体（又是一个json对象，里面包含函数的实现，和错误消息设置）
			format:{
				//函数实现
				validator: function(value,param){
					//alert(value+","+param.length);
					//获取当前文件的后缀名
					var ext=value.substring(value.lastIndexOf('.')+1);
					//获取支持的文件后缀名，然后比较即可
					var arr=param[0].split(",");
					for(var i=0;i<arr.length;i++){
						if(ext==arr[i])
							return true;
					}
					return false;
				},
				//错误消息
				message:'文件必须:{0}'
			}
		});
		
		$('#cc').combobox({    
 		    url:'category_query.action',    
 		    valueField:'id',    
 		    textField:'type',
 		    panelHeight:'auto',
 		    panelWidth:120,
 		    width:120,
 		    editable:false,
 		    required:true,
 		    missingMessage:'请选择商品类别'
 		}); 
		
		$("input[name=name]").validatebox({
			required:true,
			missingMessage:'请输入商品名称'
		});
 		$("input[name=price]").numberbox({
			required:true,
			missingMessage:'请输入价格',
			min:0,
			precision:2,
			prefix:'￥'
		}); 
	  $("input[name='fileImage.upload']").validatebox({
			required:true,
			missingMessage:'请上传图片',
			//设置自定义方法
			validType:"format['gif,jpg,jpeg,png']"
	  });
	  //当文件域内容发生变化时候，则调用验证方法（默认是单击提交时调用验证）
	  $("input[name='fileImage.upload']").change(function(){
		  //验证本文本框是否有效
		  $(this).validatebox("validate");
	  });
	  $("textarea[name=remark]").validatebox({
			required:true,
			missingMessage:'请输入商品描述'
		});
	  $("#ff").form("disableValidation");
	  
	  
		$("#submit").click(function(){
			 
			 $("#ff").form("enableValidation");
			if($("#ff").form("validate")){
				$('#ff').form('submit',{
					url:'product_save.action',
					success: function(){
						parent.$("#win").window('close');
						parent.$("iframe[title='商品管理']").get(0).contentWindow.$("#dg").datagrid("reload");
					}
					
				}); 
			}
		});
		
		$("#reset").click(function(){
			$("#ff").form("reset");
		});
	});
	</script>
	<style type="text/css">
		form div{
			margin: 10px;
		}
	</style>
</head>

<body>
<form title="添加商品" id="ff" method="post" enctype="multipart/form-data">
	<div>
		<label>商品名称:</label> <input type="text" name="name" />
	</div>
	<div>
		<label>商品价格:</label> <input type="text" name="price" />
	</div>
	<div>
		<label>图片上传:</label> <input type="file" name="fileImage.upload" />
	</div>
	<div>
		<label>所属类别：</label> 
		<input id="cc" name="category.id">
		</input>
	</div>
	<div>
		<label>加入推荐:</label> 推荐:<input type="radio" name="commend"
			checked="checked" value="true" />  不推荐:<input type="radio"
			name="commend" value="false" /> 
	</div>
	<div>
		<label>是否有效:</label>
		上架:<input type="radio" name="open" checked="checked"value="true" />
		下架:<input type="radio" name="open" value="false" />
				
	</div>
	<div>
		<label>简单描述:</label>
		<textarea name="remark" cols="40" rows="4"></textarea>
	</div>
	<div>
		<label>详细描述:</label>
		<textarea name="xremark" cols="40" rows="8"></textarea>
	</div>
	<div>
		<a id="submit" href="#" class="easyui-linkbutton">添 加</a> 
		<a id="reset" href="#" class="easyui-linkbutton">重 置</a>
	</div>
</form>
</body>
</html>
