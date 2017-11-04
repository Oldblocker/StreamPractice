/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streampractice;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author Luke
 */
public class StreamPractice {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<String> lst = new ArrayList<>();
        String fileName = "loremipsum.txt";
        String nextLine = null;
        int i = 0;
        try (FileReader fr = new FileReader(fileName); BufferedReader br = new BufferedReader(fr);)
        {
           while((nextLine = br.readLine()) != null)
           {
               lst.addAll(Arrays.asList(nextLine.split(" ")));
           }
            
        } catch (IOException ex) {
            Logger.getLogger(StreamPractice.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        lst = lst.stream().map(s -> s.replaceAll(",", "").replaceAll("\\.", "")).collect(Collectors.toList());
        long count = lst.stream().filter(s -> s.startsWith("s")).peek(s -> System.out.println(s)).count();
        System.out.println();
        long five = lst.stream().filter(s -> s.length() == 5).peek(s -> System.out.println(s)).count();
        
        System.out.println("Słów zaczynających się na s: " + count);
        System.out.println();
        System.out.println("Słów o 5 literach " + five);
        
        
        
    }
    
}
