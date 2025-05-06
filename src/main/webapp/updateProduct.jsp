<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="com.data.ss2.Product" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Cập Nhật Sản Phẩm</title>
</head>
<body>
<%
    Product product = (Product) request.getAttribute("product");
    String error = (String) request.getAttribute("error");
%>

<h2 style="text-align:center;">Cập Nhật Sản Phẩm</h2>

<% if (error != null) { %>
<p style="color:red; text-align:center;"><%= error %></p>
<% } %>

<form action="products" method="post" style="width: 300px; margin: auto;">
    <input type="hidden" name="action" value="update">
    <input type="hidden" name="id" value="<%= product.getId() %>">

    Tên: <input type="text" name="name" value="<%= product.getName() %>" required><br><br>
    Giá: <input type="number" step="0.1" name="price" value="<%= product.getPrice() %>" required><br><br>
    <input type="submit" value="Cập nhật">
</form>
</body>
</html>
