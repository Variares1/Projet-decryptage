package vue;
import javax.swing.*;
import java.awt.*;

public class frm_auth extends JFrame{
            private JPanel pan=new JPanel();
            private JFormattedTextField login=new JFormattedTextField();
            private JFormattedTextField password=new JFormattedTextField();
            private JLabel Llogin=new JLabel("Identifiant");
            private JLabel LPassword=new JLabel("Mot de passe");
            private JLabel titre=new JLabel("<html>Mad Max<br></html>");
            private JButton log=new JButton("S'authentifier");

            public frm_auth(){
                  this.setTitle("Mad Max");
                  this.setSize(400,200);
                  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                  this.setLocationRelativeTo(null);

                  pan.setBackground(Color.darkGray);
                  pan.setLayout(new BorderLayout());

                  JPanel btn=new JPanel();
                  JPanel top=new JPanel();
                  JPanel centre=new JPanel();

                  login.setPreferredSize(new Dimension(100,30));

                  password.setPreferredSize(new Dimension(100,30));

                  Font fTitre=new Font("Ariel",Font.BOLD,50);

                  titre.setFont(fTitre);

                  top.add(titre);
                  centre.add(Llogin);
                  centre.add(login);
                  centre.add(LPassword);
                  centre.add(password);

                  btn.add(log);


                  pan.add(top,BorderLayout.NORTH);
                  pan.add(centre, BorderLayout.CENTER);
                  pan.add(btn, BorderLayout.SOUTH);
                  this.setContentPane(pan);
                  this.setVisible(true);
            }

}


