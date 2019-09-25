package vue;

import javax.swing.*;
import java.awt.*;

public class frm_decrypt extends JFrame {

      JLabel titre=new JLabel("Chiffrement/Decryptage");
      JButton decrypt=new JButton("Decryptage");
      JButton chargerFichierChiffre=new JButton("Charger le fichier crypter");
      JButton identifierFichierDest=new JButton("Identifier le fichier de destination");
      JPanel pan=new JPanel();

      public frm_decrypt(){
            this.setTitle("Decryptage");
            this.setSize(400,200);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setLocationRelativeTo(null);

            Font ftitre=new Font("Arial",Font.BOLD,40);

            pan.setBackground(Color.darkGray);
            pan.setLayout(new BorderLayout());

            JPanel top=new JPanel();
            JPanel mid=new JPanel();
            JPanel bot=new JPanel();

            titre.setFont(ftitre);

            top.add(chargerFichierChiffre);
            mid.add(identifierFichierDest);
            bot.add(decrypt);

            pan.add(top, BorderLayout.NORTH);
            pan.add(mid, BorderLayout.CENTER);
            pan.add(bot, BorderLayout.SOUTH);

            this.setContentPane(pan);
            this.setVisible(true);
      }
}
