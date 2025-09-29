<%@ page import="javax.servlet.http.*,dao.AttendanceDAO,model.Attendance,java.util.*" %>
<html>
<head><title>Attendance</title></head>
<body>
<h2>Mark Attendance</h2>
<form action="AttendanceServlet" method="post">
    <input type="hidden" name="employeeId" value="<%= session.getAttribute("userId") %>">
    <button type="submit" name="action" value="checkin">Check In</button>
    <button type="submit" name="action" value="checkout">Check Out</button>
</form>

<h2>Today's Attendance Records</h2>
<%
    AttendanceDAO dao = new AttendanceDAO();
    List<Attendance> list = dao.getAttendanceReport();
%>
<table border="1">
<tr><th>ID</th><th>Employee ID</th><th>Date</th><th>Check In</th><th>Check Out</th></tr>
<% for (Attendance a : list) { %>
<tr>
    <td><%= a.getId() %></td>
    <td><%= a.getEmployeeId() %></td>
    <td><%= a.getDate() %></td>
    <td><%= a.getCheckIn() %></td>
    <td><%= a.getCheckOut() %></td>
</tr>
<% } %>
</table>
</body>
</html>
