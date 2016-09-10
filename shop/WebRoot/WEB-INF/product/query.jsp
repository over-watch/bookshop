<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
 	<%@ include file="/public/head.jspf" %>
 	<style type="text/css">
 		body{
 			margin:1px;
 		}
 		.searchbox{
 			margin:-3;
 		}
 	
 	</style>
 	<script type="text/javascript">
 		$(function(){
 			$('#dg').datagrid({ 
 				//请求数据的URL地址
 				loadMsg:'请等待----------------',
 			    url:'product_queryJoinCategory.action',   
 			    queryParams:{name:''},
 			    //制定id字段为标识字段，在删除，更新时，选中的记录在翻页时不会丢失
 			    idField:'id',
 			   // width:250,
 			   striped:true,
 			   //数据显示在同行
 			   nowrap:true,
 			   fitColumns:true,
 			   pagination:true,
 			   pageSize:5,
 			   pageList:[5,10,15,20,25],
 			   toolbar: [{
 					iconCls: 'icon-add',
 					text:'添加商品',
 					handler: function(){
 						 parent.$("#win").window({
 							width:450,
 							height:650,
 							title:'添加商品',
 							content:'<iframe frameborder="0" width="100%" height="100%" src="send_product_save.action"/>'
 						}); 
 					}
 				},'-',{
 					iconCls: 'icon-edit',
 					text:'更新商品',
 					handler: function(){
 						//1：判断是否有选中记录
 						var rows=$("#dg").datagrid("getSelections");
 						if(rows.length!=1){
 							//弹出提示信息
 							$.messager.show({
 								title:'错误提示',
 								msg:'只能更新一条记录',
 								timeout:2000,
 								showType:'slide'
 							});
 						}else{
 							//1：弹出更新页面
 						parent.$("#win").window({
 							width:450,
 							height:650,
 							title:'更新商品',
 							content:'<iframe frameboerder="0" width="100%" height="100%" src="send_product_update.action"/>'
 						});
 						}
 					}
 				},'-',{
 					iconCls: 'icon-remove',
 					text:'删除商品',
 					handler: function(){
 						//判断是否有选中商品
 						var rows=$("#dg").datagrid("getSelections");
 						if(rows.length==0){
 							$.message.show({
 								title:'错误提示',
 								msg:'至少选中一条记录',
 								timeout:2000,
 								showType:'slide'
 							});
 						}else{
 							//提示是否确认删除，如果确认则执行删除逻辑
 							$.messager.confirm('确认对话框','是否要删除选中的记录',function(r){
 								if(r){
 									//1:获取被选中的记录，然后从记录中获取相应的id
 										var ids="";
 								for(var i=0;i<rows.length;i++){
 									ids +=rows[i].id+",";
 								}
 									//2:拼接id的值，然后发给后台
 									ids=ids.substring(0,ids.lastIndexOf(","));
 									//3：发送ajax请求
 									$.post("product_deleteByIds.action",{ids:ids},function(result){
 										if(result=="true"){
 											alert("-------删除成功--------");
 											//取消当前选中所有行
 											$("#dg").datagrid("uncheckAll");
 											$("#dg").datagrid("reload");
 										}else{
 											$.message.show({
 												title:'错误提示',
 												msg:'删除失败',
 												timeout:2000,
 												showType:'slide'
 											});
 											
 										}
 									},"text");
 								}
 							});
 							
 						}
 			
 					}
 				},'-',{
 					text:"<input id='ss'/>",
 				}],

 			   rowStyler:function(index,row){
 				  if(index%2==0){
 					  return 'background-color:#6293BB;';
 				  }else{
 					 return 'background-color:#fff;';
 				  }
 			   },
 			    frozenColumns:[[
 			         {field:'xyz',checkbox:true},          
 			         {field:'id',title:'编号',width:100}
 			       
 			    ]],
 			
 			    //配置dg的列字段，field：列字段的名称与json的key捆绑；title：列标题
 			    columns:[[    
 			        {field:'name',title:'商品名称',width:100,
		 			//用来格式化当前列的值，返回的是最终的数据      
 			        	formatter: function(value,row,index){
		 					return "<span title="+value+">"+value+"</span>";
 			        	}
 			        },
 			       {field:'price',title:'价格',width:100},
 			      {field:'remark',title:'简单介绍',width:100},
 			      {field:'xremark',title:'详细介绍',width:100},
 			     {field:'commend',title:'建议',width:100},
 			    {field:'open',title:'是否可买',width:100},

 			       /*  {field:'hot',title:'热点',width:100,align:'right',
 			        	formatter: function(value,row,index){
 			        		if(value){
 			        			return "<input type='checkbox' checked='checked' disabled='true'/>";
 			        		}else{
 			        			return "<input type='checkbox'  disabled='true'/>";
 			        		}
 			        	} */
 			        	/*styler: function(value,row,index){
 			        		 console.info("val:"+value+","+"row:"+row+","+"index:"+index);
 									if(value<60){
 										return 'color:#f00;';
 									}  
 						}
 			        },*/
 			       {field:'category.type',title:'所属类别',width:100,
 			        	formatter: function(value,row,index){
 			        		if(row.category!=null&&row.category.type!=null){
 			        			return row.category.type;
 			        		}
 			        	}
 			        },
 			       {field:'date',title:'日期',width:100}
 			    ]]    
 			});
 			//把普通的文本框转化为搜索文本框
 			$('#ss').searchbox({ 
 				//触发查询事件
 				searcher:function(value,name){ 
 				//获取当前查询的关键字，通过dg加载相应的
 				//alert(value + "," + name) 
 				$("#dg").datagrid('load',{
 					name: value
 				});
 				}, 
 				prompt:'请搜索' 
 				}); 

 		});
 	</script>
  </head>
  
  <body>
		<table id="dg"></table>
  </body>
</html>
