package controller;

import model.CAD;
import model.Map_P;

import java.sql.ResultSet;
import java.sql.SQLException;

public class wkf_cpte {
    public boolean pcs_authentifier(String login, String password){
        CAD cad = new CAD();
        try(ResultSet rs = cad.GetRows(Map_P.selectIDbyLoginPassword(login, password), "")){
            if(rs.first()){
                return true;
            }
        }catch (SQLException e){
            System.out.println("error sql " + e);
        }

        return false;
    }
}
