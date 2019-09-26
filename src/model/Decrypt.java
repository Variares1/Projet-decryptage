package model;

import java.nio.charset.StandardCharsets;

public class Decrypt {
    public String decrypt(final String data, final String keyString){
        int spos = 0;
        char/*byte*/ [] output;
        String out = "";
        try{
            /*byte*/char[] key = keyString.toCharArray()/*.getBytes(StandardCharsets.UTF_8)*/;
            System.out.println(key);
            output=/*(new sun.misc.BASE64Decoder().decodeBuffer(data))*/data.toCharArray();
            for (int pos = 0; pos < output.length; ++pos) {
                output[pos] = (/*byte*/char) (output[pos] ^ key[spos]);
                ++spos;
                if (spos >= key.length) {
                    spos = 0;
                }
            }
            out = new String(output/*, StandardCharsets.UTF_8*/);
        }catch(Exception e){
            System.out.println("error" + e);
        }
        return out;
    }
}
