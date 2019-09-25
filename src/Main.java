import vue.frm_auth;
import vue.frm_decrypt;


public class Main {
    public static void main(String[] args) {
        frm_auth auth = new frm_auth();
        while(auth.getTest()){ }
        if(auth.isVisible()) {
            frm_decrypt decrypt=new frm_decrypt();
        }
    }
}