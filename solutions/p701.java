import java.util.*;
import java.io.*;

class Main {

    static FastReader fs = new FastReader();
    final static double LOG2 = Math.log(2.0);
    final static double LOG2_10 = Math.log(10) / LOG2;

    public static void main(String[] args) {
        while (true) {
            String input = fs.nextLine();
            if (input == null || input.isEmpty())
                break;
            int k = input.length() + 1;
            int N = Integer.parseInt(input);
            long left = (long) ((Math.log(N) / LOG2) + k * LOG2_10);
            long right = (long) ((Math.log(N + 1) / LOG2) + k * LOG2_10);
            while (left == right) {
                k++;
                left = (long) ((Math.log(N) / LOG2) + k * LOG2_10);
                right = (long) ((Math.log(N + 1) / LOG2) + k * LOG2_10);
            }
            System.out.println(right);
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