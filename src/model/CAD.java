package model;

import java.sql.*;

public class CAD {
    private Connection conn = null;
    public CAD(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.conn = DriverManager.getConnection(/*MYSQL_URL*/"", /*DB_USER*/"", /*DB_PASS*/"");
        }catch (Exception e){
            System.out.println("sql error " + e);
        }
    }
    public /*DataSet*/ResultSet GetRows(String rq_sql, String resultSetName){
        ResultSet rs = null;
        if(this.conn != null){
            try{
                Statement st = this.conn.createStatement();
                rs = st.executeQuery(rq_sql);
            }catch (SQLException e){
                System.out.println("sql error" + e);
            }/*finally {
                try {
                    if(rs!= null){
                        rs.close();
                    }
                }catch (SQLException e){
                    System.out.println("sql error " + e);
                }

            }*/
        }
        return rs;
    }
    public void ActionRows(String rq_sql){
    }
}
