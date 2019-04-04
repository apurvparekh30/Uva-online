import java.util.*;
import java.io.*;

class Main {

    static FastReader fs = new FastReader();
    static int n,m,k;

    public static void main(String[] args) {
        while(true){
            n = fs.nextInt();
            m = fs.nextInt();
            k = fs.nextInt();

            if(n==0 && m==0 && k==0) break;

            if(k==0)
                System.out.println((n-7)*(m-7)/2);
            else
                System.out.println(((n-7)*(m-7)+1)/2);
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