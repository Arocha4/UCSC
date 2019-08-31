// Antoine Rocha 
// arocha4@ucsc.edu
// cmps12b pa2
// Search.java
//Program reads in a file from the command line to search for target words entered
//


import java.io.*;
import java.util.Scanner;

public class Search{
  public static void main(String[] args) throws IOException{
    Scanner file = null;
    String line = null;
    String[] token = null;
    int NumOfLines = 0;
    int[] line_number = null;
    
  
    if(args.length < 2){
      System.err.println("Usage: Search file target1  [target[2  ..] ");
      System.exit(1);
    }
    
    //while loop scans and counts the number of lines in the file
    file = new Scanner(new File(args[0]));
    while( file.hasNextLine() ){
      NumOfLines++;
      line = file.nextLine();
    }
    
    //intialize's the length of the String and int array
    token = new String[NumOfLines];
    line_number = new int[NumOfLines];
    file = new Scanner(new File(args[0]));//re-scans the file
    
    //adds number to the array
    for(int i=1; i<=line_number.length; i++){
      line_number[i-1] = i;
    }
    //Scans the file, putting the word in the String array
    for(int i =0; file.hasNextLine(); i++){
      line = file.nextLine();
      token[i] = line;
    }
    //puts the string Array in order
    mergeSort(token,line_number, 0, token.length-1);
    //prints if the target is found and on what line
    for(int i=1; i<args.length; i++){
      System.out.println( binarySearch(token, line_number, 0, token.length-1, args[i]));
    }
    
    file.close();
    
  }
  
  
  //binarySearch 
  //Pre: takes two Arrays, a target, along with two if ntegers d and r. 
  //     p and r must be >= 0 && < the length of the Array 
  //Pos: returns a string with the word and line it was found on
  public static String binarySearch(String[] word, int[] line_number, int min, int max, String target){
    int mid;
    if( min == max ){
      return target + " not found";
    }
    else{
      mid = (min+max)/2;
      if( word[mid].compareTo(target) == 0){
        return target + " found on line " + line_number[mid];
      }
      else if( word[mid].compareTo(target)<0 ) {
        return binarySearch(word, line_number, min, mid, target);
      }
      else{ 
        return binarySearch(word, line_number, mid+1, max, target);
      }
    }
    
  } 
  
  //mergeSort 
  //Pre: takes two Arrays, along with two integers p and r. 
  //     p and r must be >= 0 && < the length of the Array 
  //Pos: gives the task to merge
  static void mergeSort(String[] word, int[] line_number, int min, int max){
    int mid;
    if(min<max){
      mid = (min+max)/2;
      mergeSort(word, line_number, min, mid);
      mergeSort(word, line_number, mid+1, max); 
      merge(word, line_number, min, mid, max);
    }
  }
 





 //merge 
  //Pre: takes two Arrays, along with two integers p and r. 
  //     that are given from mergeSort
  //Pos: changes the order of the Array putting them in lexical order
  static void merge(String[] word, int[] line_number, int min, int mid, int max){
    int n1 = mid-min+1;
    int n2 = max-mid;
    String[] left = new String[n1];
    String[] right = new String[n2];
    int[] leftNum = new int[n1];
    int[] rightNum = new int[n2];
    int i, j, k;
    
    for(i=0; i<n1; i++){
      left[i] = word[min+i];
      leftNum[i] = line_number[min+i];
    }
    for(j=0; j<n2; j++){
      right[j] = word[mid+j+1];
      rightNum[j] = line_number[mid+j+1];
    }
    i = 0;
    j = 0;
    for(k=min; k<=max; k++){
      if( i<n1 && j<n2){
        if( left[i].compareTo(right[j])>0 ){
          word[k] = left[i];
          line_number[k] = leftNum[i]; 
          i++;
        }
        else{
          word[k] = right[j];
          line_number[k] = rightNum[j];
          j++;
        } 
      }
      else if( i<n1){
        word[k] = left[i];
        line_number[k] = leftNum[i];
        i++;
      }
      else{  // j<n2
        word[k] = right[j];
        line_number[k] = rightNum[j];
        j++;
      } 
    }
  } 
}
