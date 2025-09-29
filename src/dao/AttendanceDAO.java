package dao;

import java.sql.*;
import java.util.*;
import model.Attendance;

public class AttendanceDAO {
    public void markCheckIn(int empId) {
        try (Connection con = DBConnection.getConnection()) {
            String sql = "INSERT INTO attendance (employee_id, date, check_in) VALUES (?, CURDATE(), NOW())";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, empId);
            ps.executeUpdate();
        } catch (Exception e) { e.printStackTrace(); }
    }

    public void markCheckOut(int empId) {
        try (Connection con = DBConnection.getConnection()) {
            String sql = "UPDATE attendance SET check_out=NOW() WHERE employee_id=? AND date=CURDATE()";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, empId);
            ps.executeUpdate();
        } catch (Exception e) { e.printStackTrace(); }
    }

    public List<Attendance> getAttendanceReport() {
        List<Attendance> list = new ArrayList<>();
        try (Connection con = DBConnection.getConnection()) {
            String sql = "SELECT * FROM attendance";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Attendance a = new Attendance();
                a.setId(rs.getInt("attendance_id"));
                a.setEmployeeId(rs.getInt("employee_id"));
                a.setDate(rs.getDate("date"));
                a.setCheckIn(rs.getTimestamp("check_in"));
                a.setCheckOut(rs.getTimestamp("check_out"));
                list.add(a);
            }
        } catch (Exception e) { e.printStackTrace(); }
        return list;
    }
}
