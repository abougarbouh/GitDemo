package resources;

import java.sql.*;

public class jdbcconection {
    public static void main(String[] args) throws SQLException {

        String name,pass,url;
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            url="jdbc:mysql://localhost:3306/demo";
            name="root";
            pass="2243";
            con = DriverManager.getConnection(url,name,pass);
            // System.out.println("Connection created");
            // con.close();
            // System.out.println("Connection closed");
        }
        catch (Exception e) {
            System.out.println(e.toString());
        }

        Statement s=con.createStatement();
        ResultSet rs= s.executeQuery("select * from credentials where scenario='zerobalancedcard'");

        while (rs.next()) {

            System.out.println(rs.getString("username"));
            System.out.println(rs.getString("password"));
        }

    }
}
