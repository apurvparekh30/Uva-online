import java.util.*;
import java.io.*;

class Main {

    static FastReader fs = new FastReader();

    static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static void main(String[] args) {
        while (true) {
            String line = fs.nextLine();
            if (line == null || line.isEmpty())
                break;
            StringTokenizer st = new StringTokenizer(line);
            int n, k;
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            ArrayList<fraction> al = new ArrayList<>();
            for (int i = 1; i < n; i++) {
                for (int j = i+1; j <= n; j++) {
                    if (gcd(i,j) == 1)
                        al.add(new fraction(i,j));
                }
            }
            al.add(new fraction(1, 1));
            Collections.sort(al);
            //System.out.println(al);
            System.out.println(al.get(k-1));
        }
    }

    static class fraction implements Comparable<fraction> {
        int p, q;

        fraction(int pp, int qq) {
            p = pp;
            q = qq;
        }

        @Override
        public int compareTo(fraction other) {
            double dif = (double) p / (double) q - (double) other.p / (double) other.q;
            if (dif < 0)
                return -1;
            else if (dif > 0)
                return 1;
            return 0;
        }

        @Override
        public String toString() {
            return p + "/" + q;
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