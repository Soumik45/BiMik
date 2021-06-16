/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import logic.Score;

/**
 *
 * @author Asus
 */
public class FileDeo {
    
    public int highScore ;
    String path;
    int Points;
 void get(int x)
 {
     Points=x;
     filekamkaj();
 }
int neo ()
{
    return highScore;
}
   
    File file= new File("Habla.txt");
    
       
  void filekamkaj()
  {
      
    //  System.out.println(highScore);
      try {
            file.createNewFile();
           // System.out.println(file.getAbsolutePath());
        } catch (IOException ex) {
            
        }
      try {
            BufferedReader reader = new BufferedReader(new FileReader("Habla.txt"));
             try {
        BufferedWriter output = new BufferedWriter(new FileWriter(file, true));
        output.newLine();
        output.append("" + Points);
        output.close();

    } catch (IOException ex1) {
        System.out.printf("ERROR writing score to file: %s\n", ex1);
    }
            String line = reader.readLine();
     while (line != null)                 
        {
            try {
                int score = Integer.parseInt(line.trim());   
                if (score > highScore)                       
                { 
                    highScore = score; 
                }
            } catch (NumberFormatException e1) {
                
                //System.err.println("ignoring invalid score: " + line);
            }
            line = reader.readLine();
        }
        reader.close();
        
        
       
        }  catch (IOException ex) {
        System.err.println("ERROR reading scores from file");
    }
     
  }
   
}
