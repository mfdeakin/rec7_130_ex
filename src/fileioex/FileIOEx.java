/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileioex;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author michael
 */
public class FileIOEx {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) throws IOException {
    BufferedReader reader = null;
    reader = new BufferedReader(new FileReader("/home/michael/originaltext.txt"));
    Scanner scan = new Scanner(reader);
    HashMap<String, Integer> wordCount = new HashMap<>();
    while(scan.hasNext()) {
      String word = scan.next();
      int count = wordCount.getOrDefault(word, new Integer(0));
      count++;
      wordCount.remove(word);
      wordCount.put(word, count);
    }
    
    BufferedWriter writer = new BufferedWriter(new FileWriter("/home/michael/wordcount.txt"));
    for(String word : wordCount.keySet()) {
      int count = wordCount.get(word);
      writer.write(word + ": " + count);
      System.out.println(word + ": " + count);
    }
    scan.close();
  }
  
}
