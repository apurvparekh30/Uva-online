import java.util.*;
import java.io.*;

class Main {

    static FastReader fs = new FastReader();
    static double d,v,u;

    public static void main(String[] args) {
        int tc = fs.nextInt();
        for(int t=1;t<=tc;t++){
            d=fs.nextDouble();
            v=fs.nextDouble();
            u=fs.nextDouble();
            double t1 = d/u;
            double t2 = d/(Math.sqrt(u*u-v*v));
            if(v>=u || t1==t2)
                System.out.printf("Case %d: can't determine\n",t);
            else
                System.out.printf("Case %d: %.3f\n",t,t2-t1);
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