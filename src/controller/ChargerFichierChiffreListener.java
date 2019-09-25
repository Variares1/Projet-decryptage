package controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ChargerFichierChiffreListener implements ActionListener {
      String rslt;
      @Override
      public void actionPerformed(ActionEvent e) {
            JFileChooser dialogue = new JFileChooser(new File("."));
            PrintWriter sortie = null;
            File fichier;
            if (dialogue.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                  fichier = dialogue.getSelectedFile();
                  try {
                        sortie = new PrintWriter
                                (new FileWriter(fichier.getPath(), true));
                  } catch (IOException ex) {
                        ex.printStackTrace();
                  }
                  rslt=dialogue.getSelectedFile().toString();
                  sortie.close();
            }
      }
      public String getRslt(){
            return rslt;
      }
}