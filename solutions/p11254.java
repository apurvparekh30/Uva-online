import java.util.*;
import java.io.*;

class Main {

    static FastReader fs = new FastReader();
    static int n,a;

    public static void main(String[] args) {
        while(true){
            n = fs.nextInt();
            if(n<0) break;
            int i;
            for(i=(int)Math.sqrt(2*n);i>0;i--){
                if((2*n+i-i*i)%(2*i)==0){
                    a = (2*n+i-i*i)/(2*i);
                    break;
                }
            }
            System.out.println(n + " = " + a + " + ... + "+(a+i-1));
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