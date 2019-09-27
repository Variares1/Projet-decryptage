package model;

public class Decrypt {
    public String decrypt(final String data, final String keyString){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < data.length(); i++)
            sb.append((char)(data.charAt(i) ^ keyString.charAt(i % (keyString.length()))));
        return(sb.toString());
    }
}
