package model;

import java.io.*;

public class Files {
    public String getData(String path){
        StringBuilder str = new StringBuilder();
        System.out.println(path);
        try {
            FileReader fr=new FileReader(new File(path));
            int i=0;
            while((i=fr.read())!=-1){
                str.append(i);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return str.toString();
    }

    public void setData(String path, String text){
        try{
            FileWriter fw=new FileWriter(new File(path));
            fw.write(text);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
