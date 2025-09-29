<%@ page import="javax.servlet.http.*" %>
<%
    String role = (String) session.getAttribute("role");
%>
<html>
<head><title>Dashboard</title></head>
<body>
<h1>Welcome, <%= session.getAttribute("username") %></h1>

<% if ("ADMIN".equals(role)) { %>
    <h2>Admin Dashboard</h2>
    <a href="employees.jsp">Manage Employees</a><br>
    <a href="inventory.jsp">Manage Inventory</a><br>
    <a href="attendanceReport.jsp">View Attendance Reports</a><br>
<% } else { %>
    <h2>Employee Dashboard</h2>
    <a href="attendance.jsp">Mark Attendance</a><br>
    <a href="profile.jsp">My Profile</a><br>
<% } %>

<a href="logout.jsp">Logout</a>
</body>
</html>
