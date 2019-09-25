
import java.sql.*;

public class Connection {

      public static void main(String[]args){
            ConnecDB();
      }

      public static void ConnecDB() {
            try{
                  Class.forName("com.mysql.jdbc.Driver");

                  String url="jdbc:mysql://localhost:3306/seminaire";
                  String user="root";
                  String pass="";

                  Connection con= (Connection) DriverManager.getConnection(url, user, pass);

                  //Afficher les donnees
                  Statement stmtAff=con.createStatement();
                  ResultSet rs1=stmtAff.executeQuery("SELECT * FROM PERSONNAGE WHERE NOM='Rekiha'");
                  ResultSetMetaData rslt=rs1.getMetaData();
                  System.out.println("\n****************************************************************************************");

                  for(int i=1; i<rslt.getColumnCount();i++){
                        System.out.print("\t" +rslt.getColumnName(i).toUpperCase()+"\t *");
                  }
                  System.out.println("\n****************************************************************************************");
                        while(rs1.next()){
                        for (int i=1;i<rslt.getColumnCount();i++){
                              System.out.print("\t" + rs1.getObject(i).toString() + "\t |");
                        }
                  }
                  System.out.println("\n****************************************************************************************");


                  //Update la BDD
                  Statement stmt=con.createStatement();
                  int rs=stmt.executeUpdate("UPDATE PERSONNAGE SET STRENGH=14 WHERE NOM='Rekiha'");

                  con.close();
                  stmt.close();
                  stmtAff.close();
            }catch(Exception e){
                  e.printStackTrace();
            }
      }
}
