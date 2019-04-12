package TJDBC;

import java.sql.*;

public class Demo {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String BD_URL = "jdbc:mysql://localhost/blog";
    static final String USER = "root";
    static final String PASS = "dsznhlc";
    public static void main(String[] args) throws SQLException {
        Connection conn = null;
        Statement stmt = null;
        try{
            try {
                Class.forName(JDBC_DRIVER);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            conn = DriverManager.getConnection(BD_URL,USER,PASS);
            stmt = conn.createStatement();
            String sql;
            sql = "select id,password from  USER ";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                int id = rs.getInt("id");
                int age = rs.getInt("password");
                System.out.print("ID"+id);
                System.out.print("Age"+age);
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch(SQLException e){
            e.printStackTrace();
        } finally {
            try{
                if(stmt != null)
                    stmt.close();
            } catch (SQLException e3){
            }
            try{
                if(conn != null)
                    conn.close();
            } catch(SQLException e4){
                e4.printStackTrace();
            }
        }
    }
}