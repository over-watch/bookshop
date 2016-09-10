<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<!-- 引入公共的JSP片段 -->
	<%@ include file="/public/head.jspf"%>
	<script type="text/javascript">
	$(function(){
		var dg=parent.$("iframe[title='商品管理']").get(0).contentWindow.$("#dg");
		$('#cc').combobox({    
 		    url:'category_query.action',    
 		    valueField:'id',    
 		    textField:'type',
 		    panelHeight:'auto',
 		    panelWidth:120,
 		    width:120
 		}); 
		//完成数据回显
			var rows=dg.datagrid("getSelections");
			$('#ff').form('load',{
				id:rows[0].id,
				name:rows[0].name,
				price:rows[0].price,
				commend:rows[0].commend,
				'category.id':rows[0].category.id,
				open:rows[0].open,
				remark:rows[0].remark,
				xremark:rows[0].xremark,
				$("input[name='fileImage.upload']").get()
			});
			 //窗体弹出默认是禁用验证
			$("#ff").form("disableValidation");
			$("#btn").click(function(){
				alert($("#pic").value);
				//开启验证
				$("#ff").form("enableValidation");
				if($("#ff").form("validate")){
					//如果验证成功，调用submit方法提交数据
					$('#ff').form('submit',{
						url:'product_update.action',
						success:function(){
							//关闭当前窗体
							parent.$("#win").window('close');
							//刷新页面
							dg.datagrid("reload");
						}
					});
				}
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
<form title="添加商品"  id="ff" method="post" enctype="multipart/form-data">
	<div>
		<label>商品名称:</label> <input type="text" name="name"  />
	</div>
	<div>
		<label>商品价格:</label> <input type="text" name="price"  />
	</div>
	<div>
		<label>图片上传:</label> <input   type="file"  name="fileImage.upload"   />
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
	<div align="center">
		<a id="btn"  href="#" class="easyui-linkbutton">更新商品</a> 
		<input type="hidden" name="id"/>
	</div>
</form>
</body>
</html>
