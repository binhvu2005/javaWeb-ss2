<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.*, com.data.ss2.Product" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Danh Sách Sản Phẩm</title>
</head>
<body>
<h1 style="text-align: center;">Danh Sách Sản Phẩm</h1>

<div style="width: 400px; margin: auto; border: 1px solid black; padding: 20px;">
    <h2 style="text-align: center;">Thêm Sản Phẩm</h2>
    <form action="products" method="post">
        Tên: <input type="text" name="name" required><br><br>
        Giá: <input type="number" name="price" step="0.1" required><br><br>
        <input type="submit" value="Thêm">
    </form>
</div>

<br><br>
<table border="1" cellspacing="0" cellpadding="10" style="margin: auto;">
    <tr>
        <th>ID</th>
        <th>Tên Sản Phẩm</th>
        <th>Giá</th>
        <th>Hành động</th>
    </tr>
    <%
        List<Product> list = (List<Product>) request.getAttribute("productList");
        if (list != null) {
            for (Product p : list) {
    %>
    <tr>
        <td><%= p.getId() %></td>
        <td><%= p.getName() %></td>
        <td><%= p.getPrice() %></td>
        <td>
            <form action="products" method="get" style="display:inline;">
                <input type="hidden" name="action" value="edit">
                <input type="hidden" name="id" value="<%= p.getId() %>">
                <input type="submit" value="Sửa">
            </form>
            <form action="products" method="post" style="display:inline;" onsubmit="return confirm('Bạn có chắc chắn muốn xóa sản phẩm này không?');">
                <input type="hidden" name="action" value="delete">
                <input type="hidden" name="id" value="<%= p.getId() %>">
                <input type="submit" value="Xóa">
            </form>
        </td>
    </tr>
    <% }} %>
</table>
</body>
</html>
