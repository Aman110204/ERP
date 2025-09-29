package servlet;

import dao.AttendanceDAO;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class AttendanceServlet extends HttpServlet {
    private AttendanceDAO dao = new AttendanceDAO();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        int empId = Integer.parseInt(request.getParameter("employeeId"));

        if ("checkin".equals(action)) {
            dao.markCheckIn(empId);
        } else if ("checkout".equals(action)) {
            dao.markCheckOut(empId);
        }
        response.sendRedirect("attendance.jsp");
    }
}
