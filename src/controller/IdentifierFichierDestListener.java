package controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class IdentifierFichierDestListener implements ActionListener {
      String rslt;
      @Override
      public void actionPerformed(ActionEvent e) {

            JFileChooser dialogue2 = new JFileChooser(new File(".."));
            PrintWriter sortie2 = null;
            File fichier2;
            if (dialogue2.showOpenDialog(null)== JFileChooser.APPROVE_OPTION) {
                  fichier2 = dialogue2.getSelectedFile();
                  try {
                        sortie2 = new PrintWriter
                                (new FileWriter(fichier2.getPath(), true));
                  } catch (IOException ex) {
                        ex.printStackTrace();
                  }
                  System.out.println(dialogue2.getSelectedFile());
                  rslt=dialogue2.getSelectedFile().toString();
                  sortie2.close();
            }

      }
      public String getRslt(){
            return rslt;
      }
}
