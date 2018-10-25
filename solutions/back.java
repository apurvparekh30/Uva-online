import java.util.*;
import java.io.*;

class Main {

    static FastReader fs = new FastReader();
    static double dist;
    static double []gDist,gCost;
    static double cost;
    static double capacity,milage;
    static int no;
    static double totalCost;

    static void rec(int i,double currGas, double currCost){
        if(i==no+1){
            totalCost = Math.min(totalCost,currCost);
            return ;
        }
        double nextDist = gDist[i+1] - gDist[i];
        double reachable = currGas * milage;
        if(nextDist <= reachable && currGas > (capacity/2.0)){
            rec(i+1,currGas - (nextDist/milage),currCost);
        }
        rec(i+1,capacity - (nextDist/milage),currCost + (Math.round((capacity - currGas)*gCost[i])+200.00));
    }

    public static void main(String[] args) {
        int tc = 0;
        while(true){
            tc++;
            dist = fs.nextDouble();
            if(dist < 0)
                break;
            capacity = fs.nextDouble();
            milage = fs.nextDouble();
            cost = fs.nextDouble();
            no = fs.nextInt();
            gDist = new double[no+1];
            gCost = new double[no+1];
            for(int i=0;i<no;i++){
                gDist[i] = fs.nextDouble();
                gCost[i] = fs.nextDouble();
            }
            gDist[no] = dist;
            totalCost = Double.MAX_VALUE;
            rec(0,capacity - (gDist[0]/milage),cost*100);
            System.out.println("Data Set #"  + tc);
            System.out.println("minimum cost = $" + (totalCost/100.0));
        }
    }


    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}