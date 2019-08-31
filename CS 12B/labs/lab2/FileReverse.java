//Antoine Rocha
//arocha4@ucsc.edu id# 1479979
//lab2 cmps12b
//this takes in input giel and outputs its reverse


import java.io.*;
import java.util.Scanner;

class FileReverse{
    public static void main(String[] args) throws IOException{
        // check number of command line arguments is at least 2
        if(args.length < 2){
            System.out.println("Usage: FileCopy <input file> <output file>");
            System.exit(1);
        }

        // open files
        Scanner in = new Scanner(new File(args[0]));
        PrintWriter out = new PrintWriter(new FileWriter(args[1]));

        // read lines from in, extract and print tokens from each line
        while( in.hasNextLine() ){
            // trim leading and trailing spaces, then add one trailing space so 
            // split works on blank lines
            String line = in.nextLine().trim() + " "; 

            // split line around white space 
            String[] token = line.split("\\s+");  
            
            // print out tokens       
             
            for(int i=0; i<token.length; i++){
                out.println(stringReverse(token[i]));
            }
        }

        // close files
        in.close();
        out.close();
    }
    public static String stringReverse(String s)
    {
        String reverse = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            reverse += s.charAt(i);
        }
        return reverse;
    }
}
