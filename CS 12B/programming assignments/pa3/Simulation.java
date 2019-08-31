// Antoine Rocha
// arocha4
// Cmps12b pa4
// Simulation.java
// simulates the process of jobs.
import java.io.*;
import java.util.Scanner;

public class Simulation {


    public static void sort(int[] time) {

        for (int T = time.length - 1; T > 0; T--) {
            for (int j = 1; j <= T; j++) {
                if (time[j] < time[j - 1]) {
                    int temp = time[j];
                    time[j] = time[j - 1];
                    time[j - 1] = temp;
                }
            }
        }
    }

    public static Job getJob(Scanner in ) {
        String[] Z = in .nextLine().split(" ");
        int ar = Integer.parseInt(Z[0]);
        int dep = Integer.parseInt(Z[1]);
        return new Job(ar, dep);
    }



    public static void main(String[] args) throws IOException {

        if (args.length != 1) {
            System.err.println("Usage: Simulation -inputfile.");
            System.exit(1);
        }

        //variables
        Scanner sc = new Scanner(new File(args[0]));
        PrintWriter Report = new PrintWriter(new FileWriter(args[0] + ".rpt"));
        PrintWriter Trace = new PrintWriter(new FileWriter(args[0] + ".trc"));
        int totalWait, maximumWait;
        double averageWait;
        Queue store = new Queue();


        //get number of jobs
        String NumberOfJobs = sc.nextLine();
        int J = Integer.parseInt(NumberOfJobs);

        while (sc.hasNext()) {
            store.enqueue((Job) getJob(sc));
        }


        //heading for files
        Trace.println("Trace file: " + args[0] + ".trc");
        Trace.println(J + " Jobs:");
        Trace.println(store + "\n");
        Report.println("Report file: " + args[0] + ".rpt");
        Report.println(NumberOfJobs + " Jobs:");
        Report.println(store);
        Report.println("****************************************************");

        //create a range of processors
        for (int m = 1; m < J; m++) {
            int time = 0;

            Queue[] pro = new Queue[m + 1];
            for (int i = 0; i <= m; i++)
                pro[i] = new Queue();

            //copy store into array
            for (int i = 0; i < J; i++) {
                Job g = (Job) store.dequeue();
                g.resetFinishTime();
                pro[0].enqueue(g);
                store.enqueue(g);

            }

            Trace.println("******************************************************");
            //singular vs plural
            Trace.println(m == 1 ? m + " processor:" : m + " processors");
            Trace.println("******************************************************");

            while (pro[0].isEmpty() || pro[0].length() != J || ((Job) pro[0].peek()).getFinish() == -1) {

                int[] t = new int[pro.length];

                if (time == 0) {
                    Trace.println("time=0");
                    for (int i = 0; i <= m; i++)
                        Trace.println(i + ": " + pro[i]);
                }
                Trace.println();

                //calculates the next time
                if (time == 0 && !pro[0].isEmpty()) {
                    time = ((Job) pro[0].peek()).getArrival();
                } else if (!pro[0].isEmpty()) {
                    Job k = (Job) pro[0].peek();
                    if (k.getFinish() == -1)
                        t[0] = k.getArrival();
                }

                for (int i = 1; i < pro.length; i++) {
                    if (!pro[i].isEmpty())
                        t[i] = ((Job) pro[i].peek()).getFinish();
                }
                sort(t);

                for (int i = 0; i < t.length; i++) {
                    // if( t[i] == 0 ) 
                    // 	continue;
                    if (t[i] != 0) {
                        time = t[i];
                        break;
                    }
                } //

                //store back job if finishtime is calculated and calculate finishtime of
                //any upcoming jobs
                for (int i = 1; i <= m; i++) {
                    if (!pro[i].isEmpty() && ((Job) pro[i].peek()).getFinish() == time) {
                        pro[0].enqueue(pro[i].dequeue());
                        if (pro[i].length() > 0 && ((Job) pro[i].peek()).getFinish() == -1) {
                            ((Job) pro[i].peek()).computeFinishTime(time);
                        }
                    }
                } //

                //put jobs in processors
                if (pro.length - 1 == 1 && !pro[0].isEmpty() && ((Job) pro[0].peek()).getArrival() == time)
                    pro[1].enqueue(pro[0].dequeue());
                else {
                    if (!pro[0].isEmpty() && ((Job) pro[0].peek()).getArrival() == time) {
                        int[] length = new int[pro.length - 1];
                        for (int i = 0; i < length.length; i++)
                            length[i] = pro[i + 1].length();
                        int index = 0;
                        int min = length[0];
                        for (int i = 1; i < length.length; i++) {
                            if (length[i] < min) {
                                min = length[i];
                                index = i;
                            }
                        }
                        pro[index + 1].enqueue(pro[0].dequeue());
                    }
                }
                for (int i = 1; i < pro.length; i++) {
                    if (!pro[i].isEmpty() && ((Job) pro[i].peek()).getFinish() == -1)
                        ((Job) pro[i].peek()).computeFinishTime(time);
                } //

                //computing is done. print out job process
                Trace.println("time=" + time);
                for (int i = 0; i <= m; i++) {
                    Trace.println(i + ": " + pro[i]);
                } //

            }
            //calculate avg & total time
            totalWait = 0;
            int[] AllTheTimes = new int[pro[0].length()];
            for (int i = 0; i < AllTheTimes.length; i++) {
                AllTheTimes[i] = ((Job) pro[0].peek()).getWaitTime();
                totalWait = totalWait + AllTheTimes[i];
                pro[0].enqueue(pro[0].dequeue());
            }
            sort(AllTheTimes);
            maximumWait = AllTheTimes[AllTheTimes.length - 1];
            averageWait = (double) totalWait / (double) AllTheTimes.length;

            //print to Report file
            Report.println(m == 1 ? m + " processor: " : m + " processors: ");
            Report.println("totaWait=" + totalWait + ", maxWait=" + maximumWait + ", averageWait=" + averageWait);
        }

        Trace.close();
        Report.close();
        sc.close();

    }
}