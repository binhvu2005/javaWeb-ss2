<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page pageEncoding="UTF-8" %>
<html>
<head>
    <title>Game Đoán Chữ</title>
</head>
<body>
<h2>Game Đoán Chữ</h2>

<p><strong>Gợi ý từ:</strong> <%= session.getAttribute("displayHint") %></p>
<p>Bạn còn: <%= session.getAttribute("attemptsLeft") %> lượt đoán</p>

<form method="post" action="guess">
    <input type="text" name="guess" required placeholder="Nhập cả từ bạn đoán"/>
    <input type="submit" value="Đoán"/>
</form>

<p style="color: red;">
    <%= session.getAttribute("message") %>
</p>

<% String msg = (String) session.getAttribute("message");
    if (msg.contains("thua") || msg.contains("đoán đúng")) { %>
<form action="guess" method="get">
    <button type="submit">Chơi lại</button>
</form>
<% } %>
</body>
</html>
