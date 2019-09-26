package model;

import java.nio.charset.StandardCharsets;

public class Decrypt {
    public String decrypt(final String data, final String keyString){
        /*int spos = 0;
        byte [] output;
        String out = "";
        try{
            byte[] key = keyString.getBytes(StandardCharsets.US_ASCII);
            output=(new sun.misc.BASE64Decoder().decodeBuffer(data));
            for (int pos = 0; pos < output.length; ++pos) {
                output[pos] = (byte) (output[pos] ^ key[spos]);
                ++spos;
                if (spos >= key.length) {
                    spos = 0;
                }
            }
            out = new String(output, StandardCharsets.US_ASCII);
        }catch(Exception e){
            System.out.println("error" + e);
        }
        return out;*/
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < data.length(); i++)
            sb.append((char)(data.charAt(i) ^ keyString.charAt(i % (keyString.length()))));
        return(sb.toString());
    }
}
