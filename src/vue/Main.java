package vue;

public class Main {
      public static void main(String[] args) {

            frm_auth auth=new frm_auth();
            if (auth.getTest()){
                  auth.dispose();
                  frm_decrypt decrypt=new frm_decrypt();
            }


      }
}
