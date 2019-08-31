import java.util.Scanner;

class Lawn{

   public static void main( String[] args ){

      double lotheight, lotwidth, lotarea, area, housewidth, househeight;
      double housearea, mowrate, houselot, width, height;
      Scanner sc = new Scanner(System.in);

      //System.out.print("Enter the length and width of the lot, in feet: ");
      lotwidth = sc.nextDouble();
      lotheight = sc.nextDouble();
      lotarea = lotwidth*lotheight;

      //System.out.print("Enter the length and width of the house, in feet: ");


      housewidth = sc.nextDouble();
      househeight = sc.nextDouble();
      housearea = housewidth*househeight;
      area = lotarea-housearea;
      System.out.println("The lawn area is "+area+ " square feet.");

      //System.out.print("Enter the mowing rate, in square feet persecond: ");
      mowrate = sc.nextDouble();


      double sec = area / mowrate;
      int h, m,s,n;

      s = (int) Math.round(sec); // s = 3726
      m = s/60;
      s = s%60;  // same as s %= 60
      h = m/60;
      m = m%60;  // same as m %= 60


      System.out.print("The mowing time is ");
      System.out.print(h + (h == 1 ? " hour, " : " hours, "));
      System.out.print(m + (m == 1 ? " minute, " : " minutes, "));
      System.out.println(s + (s == 1 ? " second. " : " seconds. "));
   }

}
