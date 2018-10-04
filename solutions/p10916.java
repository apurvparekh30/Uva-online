import java.util.*;
import java.io.*;

class Main {

    static FastReader fs = new FastReader();
    static int y;
    static final double LOG2 = Math.log(2);

    public static void main(String[] args) {
        while(true){
            y = fs.nextInt();
            if(y==0) break;
            double n = 1<<((y-1960)/10)+2;
            int i = 1;
            while(n > 0){
                n-=Math.log(i)/LOG2;
                i++;
            }
            System.out.println(i-2);
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