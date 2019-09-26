package model;

import java.io.*;

public class Files {
    public String getData(String path){
        String str = "";
        System.out.println(path);
        try {
            FileReader fr=new FileReader(new File(path));
            int i=0;
            while((i=fr.read())!=-1){
                str += (char)i;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return str;
    }

    public void setData(String path, String text){
        try{
            FileWriter fw=new FileWriter(new File(path));
            fw.write(text);
            fw.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
