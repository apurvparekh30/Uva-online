import java.util.*;
import java.io.*;

class Main {

    static FastReader fs = new FastReader();
    static int n, d;
    static double[] x, y;
    static interval inter[];

    public static void main(String[] args) {
        int tc = 0;
        while (true) {
            tc++;
            n = fs.nextInt();
            d = fs.nextInt();
            if (n == 0 && d == 0)
                break;
            x = new double[n];
            y = new double[n];
            inter = new interval[n];
            int ans = 0;
            for (int i = 0; i < n; i++) {
                x[i] = fs.nextDouble();
                y[i] = fs.nextDouble();
                if (y[i] > d)
                    ans = -1;
            }
            if (ans == 0) {
                for (int i = 0; i < n; i++) {
                    double dx = Math.sqrt(d * d - y[i] * y[i]);
                    inter[i] = new interval(x[i] - dx, x[i] + dx);
                }
                Arrays.sort(inter);
                //System.out.println(Arrays.toString(inter));
                for (int i = 0; i < n;) {
                    int j;
                    for (j = i+1; j < n; j++) {
                        if (inter[j].st > inter[i].en)
                            break;
                    }
                    i = j;
                    ans++;
                }
            }

            System.out.printf("Case %d: %d\n", tc, ans);
        }
    }

    static class interval implements Comparable<interval> {
        double st, en;

        interval(double st, double en) {
            this.st = st;
            this.en = en;
        }

        @Override
        public int compareTo(interval o) {
           return (Double.compare(this.en, o.en)==0) ? Double.compare(this.st,o.st) : Double.compare(this.en,o.en); 
        }

        @Override
        public String toString() {
            return st + " " + en;
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