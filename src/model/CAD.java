package model;

import java.sql.PreparedStatement;

public class CAD {
    public /*DataSet*/void GetRows(String rq_sql, String resultSetName){

        int foovalue = 500;
        int pseudor;
        int mdpr;
        PreparedStatement st = db.prepareStatement("SELECT * FROM tb_personne WHERE pseudo = "pseudor"&& mdp = "mdpr");
        st.setInt(1, valeur);
        ResultSet rs = st.executeQuery();
        while (rs.next()) {
            System.out.print("Colonne 1 renvoyée ");
            System.out.println(rs.getString(1));
        }
        rs.close();
        st.close();

        try {
            PreparedStatement verif = con.prepareStatement("");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void ActionRows(String rq_sql){
    }
}
