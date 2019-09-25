package model;

public class Decrypt {
    String decrypt(String data, String keyString){
        int spos = 0;
        byte [] output = null;
        String out = "";
        try{
            byte[] key = keyString.getBytes("UTF-8");
            output=(new sun.misc.BASE64Decoder().decodeBuffer(data));
            for (int pos = 0; pos < output.length; ++pos) {
                output[pos] = (byte) (output[pos] ^ key[spos]);
                ++spos;
                if (spos >= key.length) {
                    spos = 0;
                }
            }
            out = new String(output, "UTF-8");
        }catch(Exception e){
            System.out.println("error" + e);
        }
        return out;
    }
}
