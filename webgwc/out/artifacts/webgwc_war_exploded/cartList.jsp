<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.czxy.domain.Product"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>购物车</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta charset="utf-8">

<link
	href="<%=request.getContextPath()%>/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="<%=request.getContextPath()%>/bootstrap/css/bootstrap-theme.min.css"
	rel="stylesheet">
<script type="text/javascript"
	src="<%=request.getContextPath()%>/bootstrap/js/jquery-1.11.3.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/bootstrap/js/bootstrap.min.js"></script>

</head>
<body>
	<div class="container">
		<div class="panel panel-default">
			<div class="panel-heading text-center">
				<h2>购物车</h2>
			</div>
			<div class="panel-body">
				<table class="table table-hover">
					<thead>
						<tr>
							<th>商品名称</th>
							<th>商品型号</th>
							<th>商品单价</th>
							<th>购买数量</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
					<%
						//从request中取得商品列表
						Map<String, Product> productMap = (Map<String, Product>) request.getAttribute("productMap");
						Cookie[] cookies = request.getCookies();
						for (Cookie c : cookies) {
							if(c.getName().startsWith("id")){
							    Product p = productMap.get(c.getName().replace("id",""));


					%>
					<tr>
						<td><%=p.getName() %></td>
						<td><%=p.getType() %></td>
						<td><%=p.getPrice() %></td>
						<td><%=c.getValue() %></td>
						<td><a class="btn btn-info"
							   href="<%=request.getContextPath()%>/cookie?method=delete&id=<%=p.getId() %>"
							   target="_blank">删除</a></td>
					</tr>
					<%
							}}
					%>
					</tbody>
				</table>
			</div>


		</div>
	</div>

</body>
</html>

