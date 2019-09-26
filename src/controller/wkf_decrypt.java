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
        String out_data="";
        char [] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        int charMatch = 0;
        int nbGood = 0;
        String source_data = file.getData(source_path);

        do{
            for(int j = 0; j<alphabet.length;j++){
                for(int k=0; k<alphabet.length;k++){
                    for(int l=0; l<alphabet.length;l++){
                        for(int m=0;m<alphabet.length;m++){
                            out_data = decrypt.decrypt(source_data, "awqp" + alphabet[j] + alphabet[k] + alphabet[l] + alphabet[m]);
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
                                if(nbGood>=charMatch*0.8){
                                    j=100;
                                    k=100;
                                    l=100;
                                    m=100;
                                    i=textSplit.length+1;
                                }
                            }
                        }
                    }
                }
            }
        }while(charMatch<=nbGood*0.8);
        file.setData(destination_path, out_data);
        return true;
    }

}
