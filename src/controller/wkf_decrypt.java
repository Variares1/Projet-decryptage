package controller;

import model.CAD;
import model.Decrypt;
import model.Files;
import model.Map_Dic;

import java.nio.charset.StandardCharsets;
import java.sql.ResultSet;
import java.sql.SQLException;
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
        int charMatch = 0;
        int nbGood = 0;
        String source_data = file.getData(source_path);
        String key1 = "awqpbira";
        byte[] key = "awqpbira".getBytes(/*"UTF-8"*/StandardCharsets.UTF_8);
        Pattern pattern = Pattern.compile("^[A-Za-z1-9.,?!;:@\\-]+$");
        Matcher matcher;
        do{
            for(int j = 0; j<alphabet.length;j++){
                for(int k=0; k<alphabet.length;k++){
                    for(int l=0; l<alphabet.length;l++){
                        for(int m=0;m<alphabet.length;m++){
                            //key="awqpbira" /*+ alphabet[j] + alphabet[k] + alphabet[l] + alphabet[m]*/;

                            System.out.println(key);
                            out_data = decrypt.decrypt(source_data, key1/*"awqp" + alphabet[j] + alphabet[k] + alphabet[l] + alphabet[m]*/);
                            charMatch = out_data.length() - out_data.replace(" ", "").length();
                            System.out.println(out_data);
                            textSplit = out_data.split(" ");
                            for(int i = 0 ; i<textSplit.length;i++){
                                matcher = pattern.matcher(textSplit[i]);
                                if(matcher.find()){
                                    try(ResultSet rs = cad.GetRows(map_dic.selectWord(textSplit[i]),"")){
                                        if(rs.first()){
                                            nbGood+=1;
                                        }
                                    }catch (SQLException e){
                                        e.printStackTrace();
                                    }
                                    if(nbGood>=charMatch*0.8 && charMatch!=0){
                                        j=100;
                                        k=100;
                                        l=100;
                                        m=100;
                                        i=textSplit.length+1;
                                    }
                                }
                            }
                            System.out.println("key : " + key1 + " et nbgood = " +nbGood );
                        }
                    }
                }
            }
        }while(nbGood<=charMatch*0.8);
        file.setData(destination_path, out_data);
        return true;
    }

}
