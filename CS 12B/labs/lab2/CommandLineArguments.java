Line 1 contains 2 tokens:
 //
 FileCopy.java
Line 2 contains 4 tokens:
 //
 Illustrates
 file
 IO
Line 3 contains 2 tokens:
 import
 java.io.*;
Line 4 contains 2 tokens:
 import
 java.util.Scanner;
Line 5 contains 2 tokens:
 class
 FileCopy{
Line 6 contains 7 tokens:
 public
 static
 void
 main(String[]
 args)
 throws
 IOException{
Line 7 contains 0 tokens:
Line 8 contains 4 tokens:
 Scanner
 in
 =
 null;
Line 9 contains 4 tokens:
 PrintWriter
 out
 =
 null;
Line 10 contains 4 tokens:
 String
 line
 =
 null;
Line 11 contains 2 tokens:
 int
 n;
Line 12 contains 11 tokens:
 //
 check
 number
 of
 command
 line
 arguments
 is
 at
 least
 2
Line 13 contains 3 tokens:
 if(args.length
 <
 2){
Line 14 contains 6 tokens:
 System.out.println("Usage:
 FileCopy
 <input
 file>
 <output
 file>");
Line 15 contains 0 tokens:
Line 16 contains 1 tokens:
 System.exit(1);
Line 17 contains 1 tokens:
 }
Line 18 contains 3 tokens:
 //
 open
 files
Line 19 contains 5 tokens:
 in
 =
 new
 Scanner(new
 File(args[0]));
Line 20 contains 5 tokens:
 out
 =
 new
 PrintWriter(new
 FileWriter(args[1]));
Line 21 contains 9 tokens:
 //
 read
 lines
 from
 in,
 write
 lines
 to
 out
Line 22 contains 3 tokens:
 while(
 in.hasNextLine()
 ){
Line 23 contains 3 tokens:
 line
 =
 in.nextLine();
Line 24 contains 3 tokens:
 out.println(
 line
 );
Line 25 contains 1 tokens:
 }
Line 26 contains 3 tokens:
 //
 close
 files
Line 27 contains 1 tokens:
 in.close();
Line 28 contains 1 tokens:
 out.close();
Line 29 contains 1 tokens:
 }
Line 30 contains 1 tokens:
 }
