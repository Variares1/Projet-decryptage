package model;

import java.sql.*;

public class CAD {
    private Connection conn = null;
    private static String MYSQL_URL = "jdbc:mysql://localhost:3306/projetdecryptage";
    private static String DB_USER = "user";
    private static String DB_PASS = "bonjour";
    public CAD(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            this.conn = DriverManager.getConnection(MYSQL_URL, DB_USER, DB_PASS);
        }catch (Exception e){
            System.out.println("sql error " + e);
        }
    }
    public ResultSet GetRows(String rq_sql, String resultSetName){
        ResultSet rs = null;
        if(this.conn != null){
            try{
                Statement st = this.conn.createStatement();
                rs = st.executeQuery(rq_sql);
            }catch (SQLException e){
                System.out.println("sql error" + e);
            }
        }
        return rs;
    }
    public void ActionRows(String rq_sql){
    }
}
