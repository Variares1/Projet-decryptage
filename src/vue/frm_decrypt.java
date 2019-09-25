package vue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class frm_decrypt extends JFrame implements ActionListener{

      JLabel titre=new JLabel("Chiffrement/Decryptage");
      JButton decrypt=new JButton("Decryptage");
      JButton chargerFichierChiffre=new JButton("Charger le fichier crypter");
      JButton identifierFichierDest=new JButton("Identifier le fichier de destination");
      JPanel pan=new JPanel();

      final JFileChooser fc = new JFileChooser();

      public frm_decrypt() {
            this.setTitle("Decryptage");
            this.setSize(400, 200);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setLocationRelativeTo(null);

            Font ftitre = new Font("Arial", Font.BOLD, 40);

            pan.setBackground(Color.darkGray);
            pan.setLayout(new BorderLayout());

            JPanel top = new JPanel();
            JPanel mid = new JPanel();
            JPanel bot = new JPanel();

            titre.setFont(ftitre);

            top.add(chargerFichierChiffre);
            mid.add(identifierFichierDest);
            bot.add(decrypt);

            pan.add(top, BorderLayout.NORTH);
            pan.add(mid, BorderLayout.CENTER);
            pan.add(bot, BorderLayout.SOUTH);

            chargerFichierChiffre.addActionListener(this );

            this.setContentPane(pan);
            this.setVisible(true);

            }

      @Override
      public void actionPerformed(ActionEvent e) {
            if(e.getSource() == chargerFichierChiffre){
                  /* init du filechooser */
                  JFileChooser fc = new JFileChooser();
                  /* affichage du dialog et test si le bouton ok est pressé */
                  if (fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION)
                        try {
                              /* demande au système d'ouvrir le fichier précédemment séléctionné */
                              Desktop.getDesktop().open(fc.getSelectedFile());
                        } catch (IOException e1) {
                              e1.printStackTrace();
                        }
            }else if(e.getSource()==identifierFichierDest){

            }

      }
}

