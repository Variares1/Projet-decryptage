package controller;

import model.CAD;
import model.Decrypt;
import model.Files;
import model.Map_Dic;

import java.nio.charset.StandardCharsets;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class wkf_decrypt {
    public boolean pcs_decrypter(String source_path, String destination_path){
        Files file = new Files();
        Decrypt decrypt = new Decrypt();
        Map_Dic map_dic = new Map_Dic();
        CAD cad = new CAD();
        String [] textSplit;
        String out_data="";
        char [] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        int nbGood = 0;
        int nbGoodTotal = 0;
        int [] value = new int[4];
        String lettre = "";
        String source_data = file.getData(source_path);
        String key = "awqpmndf";
        String key1;
        Pattern pattern = Pattern.compile("^[A-Za-z0-9'.,]+$");
        Matcher matcher;
        do{
            System.out.println(key);
                        for(int m=0;m<alphabet.length;m++){

                            key1=key + alphabet[m] + getChar(key.length());

                            out_data = decrypt.decrypt(source_data, key1);
                            System.out.println(out_data);
                            textSplit = out_data.split(" ");
                            nbGood = 0;
                            for(int i = 0 ; i<textSplit.length;i++){
                                matcher = pattern.matcher(textSplit[i]);
                                if(matcher.find()){
                                    if(textSplit[i].contains(",") || textSplit[i].contains(".")){
                                        textSplit[i].replaceAll("[,.]+", "");
                                    }
                                    try(ResultSet rs = cad.GetRows(map_dic.selectWord(textSplit[i]),"")){
                                        if(rs.first()){
                                            nbGood+=1;
                                        }
                                    }catch (SQLException e){
                                        e.printStackTrace();
                                    }
                                }
                            }
                            if(nbGood>nbGoodTotal){
                                nbGoodTotal = nbGood;
                                lettre = String.valueOf(alphabet[m]);
                            }
                            if(nbGood==0){
                                nbGoodTotal = 0;
                                lettre = "a";
                            }
                            if (nbGood!=0) System.out.println("key : " + key1 + " et nbgood = " +nbGood + " et lettre = " + lettre);
                        }
                        value[11-key.length()]=nbGoodTotal;
                        key += lettre;
            System.out.println(key.length());
        }while(key.length()!=12);
        System.out.println(key);
        file.setData(destination_path, decrypt.decrypt(source_data, key));

        if (value[3]<value[2] && value[2]<value[1] && value[1]<value[0]) {
            System.out.println("decrypté");
            return true;
        }
        else{
            System.out.println("non decrypté");
            return false;
        }
    }
    private String getChar(int length){
        String endKey = "";
        for(int i=length;i<11;i++){
            endKey+="a";
        }
        return endKey;
    }
}
