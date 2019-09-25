package vue;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import controller.wkf_cpte;
import controller.wkf_decrypt;
import jdk.nashorn.internal.scripts.JO;

public class frm_auth extends JFrame implements ActionListener {
            private JPanel pan=new JPanel();
            private JFormattedTextField login=new JFormattedTextField();
            private JFormattedTextField password=new JFormattedTextField();
            private JLabel Llogin=new JLabel("Identifiant");
            private JLabel LPassword=new JLabel("Mot de passe");
            private JLabel titre=new JLabel("<html>Mad Max<br></html>");
            private JButton log=new JButton("S'authentifier");
            private JOptionPane warning=new JOptionPane();

            boolean test=false;

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

                  Font fTitre=new Font("Arial",Font.BOLD,50);

                  titre.setFont(fTitre);

                  top.add(titre);
                  centre.add(Llogin);
                  centre.add(login);
                  centre.add(LPassword);
                  centre.add(password);

                  btn.add(log);
                  log.addActionListener(this);


                  pan.add(top,BorderLayout.NORTH);
                  pan.add(centre, BorderLayout.CENTER);
                  pan.add(btn, BorderLayout.SOUTH);
                  this.setContentPane(pan);
                  this.setVisible(true);

            }

            public void actionPerformed(ActionEvent e){
                  wkf_cpte contro=new wkf_cpte();
                  if(contro.pcs_authentifier(getLogin(), getPassword())){
                        this.test=true;
                        this.dispose();
                        new frm_decrypt();

                  }
                  else {warning.showMessageDialog(null,"Identifiqnt ou mot passe incorect","Erreur",JOptionPane.ERROR_MESSAGE);}
            }

            public String getLogin(){
                  return login.getText();
            }
            public String getPassword(){
                  return password.getText();
            }


            public boolean getTest(){
                  return this.test;
            }


}


