package model;

import java.sql.*;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;

public class CAD {
    public /*DataSet*/void GetRows(String rq_sql, String resultSetName){
        //"SELECT * FROM tb_personne WHERE pseudo = ? && mdp = ?" = rq_sql

        Connection conn = null;
        try{
            conn = DriverManager.getConnection(/*MYSQL_URL*/"", /*DB_USER*/"", /*DB_PASS*/"");
        }catch (SQLException e){
            System.out.println("sql error " + e);
        }
        int foovalue = 500;
        String mdpr = null; // mp de la personne
        ResultSet rs = null;
        if(conn != null){
            try(PreparedStatement st = conn.prepareStatement(rq_sql)){
                st.setString(1, resultSetName);
                st.setString(2, mdpr);
                rs = st.executeQuery();
                while (rs.next()) {
                    System.out.print("Colonne 1 renvoyée ");
                    System.out.println(rs.getString(1));
                }
            }catch (SQLException e){
                System.out.println("sql error" + e);
            }finally {
                try {
                    if(rs!= null){
                        rs.close();
                    }
                }catch (SQLException e){
                    System.out.println("sql error " + e);
                }

            }
        }
    }
    public void ActionRows(String rq_sql){
    }
}
