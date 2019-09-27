package vue;

import controller.ChargerFichierChiffreListener;
import controller.IdentifierFichierDestListener;
import controller.wkf_decrypt;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class frm_decrypt extends JFrame implements ActionListener{

      private JLabel titre=new JLabel("Chiffrement/Decryptage");
      private JButton decrypt=new JButton("Decryptage");
      private JButton chargerFichierChiffre=new JButton("Charger le fichier crypter");
      private JButton identifierFichierDest=new JButton("Identifier le fichier de destination");
      private JPanel pan=new JPanel();
      private ChargerFichierChiffreListener charger;
      private IdentifierFichierDestListener identifier;
      private JOptionPane warning=new JOptionPane();
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

            charger = new ChargerFichierChiffreListener();
            identifier=new IdentifierFichierDestListener();
            chargerFichierChiffre.addActionListener(charger);
            identifierFichierDest.addActionListener(identifier);
            decrypt.addActionListener(this);

            this.setContentPane(pan);
            this.setVisible(true);

            }
      @Override
      public void actionPerformed(ActionEvent e) {
//            ChargerFichierChiffreListener charger=new ChargerFichierChiffreListener();
//            IdentifierFichierDestListener identifier=new IdentifierFichierDestListener();
            wkf_decrypt decrypt=new wkf_decrypt();
            System.out.println(charger.getRslt());
            System.out.println((identifier.getRslt()));
            if(decrypt.pcs_decrypter(charger.getRslt(),identifier.getRslt())){
                  warning.showMessageDialog(null,"Fichier décryter","Félicitation",JOptionPane.INFORMATION_MESSAGE);
            }
            else{
                  warning.showMessageDialog(null,"Fichier non décryter","Warning",JOptionPane.WARNING_MESSAGE);
            }

      }
}


