
// Apurv Parekh

import java.util.*;
import java.io.*;

class Main {

    static Scanner fs = new Scanner(System.in);
    static int n;
    static int pts;
    static int []sum;
    static int [] wt;

    public static void main(String[] args) {
        while(fs.hasNextInt()){
            n = fs.nextInt();
            
            pts = (int) Math.pow(2,n);
            sum = new int[pts];
            wt = new int[pts];

            for(int i=0;i<pts;i++)
                wt[i]=fs.nextInt();

            // share edge only if there is 1 bit common    
            for(int i=0;i<pts;i++) {
                for(int j=0;j<pts;j++) {
                    if(Integer.bitCount(i^j)==1){
                        sum[i]+=wt[j];
                    }
                } 
            }
            int res=-1;
            for(int i=0;i<pts;i++)
                for(int j=0;j<pts;j++)
                    if(Integer.bitCount(i^j)==1)
                        res = Math.max(res,sum[i]+sum[j]);
            
            System.out.println(res);

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