import java.util.*;
import java.io.*;

class Main {

    static FastReader fs = new FastReader();
    static int n;

    public static void main(String[] args) {
        int tc = fs.nextInt();
        boolean flag = false;
        while(tc-- > 0){
            n = fs.nextInt();
            double ans = 0.0;
            if(n==1)
                ans=0.0;
            else if(n==2)
                ans=4.0;
            else    
                ans = (n*n)+(Math.sqrt(2) - 1.0)*(n-2)*(n-2);
            
            if(flag) System.out.println(); flag=true;
            System.out.printf("%.3f\n",ans);
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