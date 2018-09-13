import java.util.*;
import java.io.*;

class Main {

    static FastReader fs = new FastReader();
    static int a,b,v,A,s;

    public static void main(String[] args) {
        while(true){
            a = fs.nextInt();
            b = fs.nextInt();
            v = fs.nextInt();
            A = fs.nextInt();
            s = fs.nextInt();

            if(a==0) break;

            double dist = v*s;

            int hr = (int) (b + dist * Math.sin(A*Math.PI/180))/(b*2);
            int vr = (int) (a + dist * Math.cos(A*Math.PI/180))/(a*2);

            System.out.println(vr + " " + hr);
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