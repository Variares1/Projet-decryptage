package vue;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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

            public String getLogin(){
                  return login.getText();
            }
            public String getPassword(){
                  return password.getText();
            }
            public class BoutonListener implements ActionListener{
                  @Override
                  public void actionPerformed(ActionEvent actionEvent) {

                  }
            }

            public static void connectionDB(){
                  try{
                        Class.forName("com.mysql.jdbc.Driver");

                        String url="jdbc:mysql://localhost:3306/RPG";
                        String user="rekiha";
                        String pass="Ihgsv5358";

                        Connection con= DriverManager.getConnection(url,user,pass);

                        System.out.println("OK");
                  } catch (ClassNotFoundException | SQLException e) {
                        e.printStackTrace();
                  }
            }

}


