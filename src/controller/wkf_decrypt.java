package controller;

import model.CAD;
import model.Decrypt;
import model.Files;
import model.Map_Dic;

import java.sql.ResultSet;
import java.sql.SQLException;

public class wkf_decrypt {
    public boolean pcs_decrypter(String source_path, String destination_path){
        Files file = new Files();
        Decrypt decrypt = new Decrypt();
        Map_Dic map_dic = new Map_Dic();
        CAD cad = new CAD();
        String [] textSplit;
        String out_data;
        int charMatch = 0;
        int nbGood = 0;
        String source_data = file.getData(source_path);
        do{

            out_data = decrypt.decrypt(source_data, "awqp");
            charMatch = out_data.length() - out_data.replace(" ", "").length();
            textSplit = out_data.split(" ");
            for(int i = 0 ; i<textSplit.length;i++){
                try(ResultSet rs = cad.GetRows(map_dic.selectWord(textSplit[i]),"")){
                    if(rs.first()){
                        nbGood+=1;
                    }
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
        }while(charMatch!=nbGood);

        file.setData(destination_path, out_data);
        return true;
    }

}
