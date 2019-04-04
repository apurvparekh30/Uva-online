import java.util.*;
import java.io.*;

class Main {

    static FastReader fs = new FastReader();
    static int v, t;

    public static void main(String[] args) {
        while (true) {
            String line = fs.nextLine();
            if (line == null || line.isEmpty())
                break;
            StringTokenizer st = new StringTokenizer(line);
            v = Integer.parseInt(st.nextToken());
            t = Integer.parseInt(st.nextToken());
            System.out.println(2*v*t);
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