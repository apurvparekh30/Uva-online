import java.util.*;
import java.io.*;

class Main {

    static FastReader fs = new FastReader();
    static int c, s;
    static int[] ss;

    public static void main(String[] args) {
        int tc = 0;
        while (true) {
            tc++;
            String ln = fs.nextLine();
            if (ln == null || ln.isEmpty())
                break;
            StringTokenizer st = new StringTokenizer(ln);
            c = Integer.parseInt(st.nextToken());
            s = Integer.parseInt(st.nextToken());
            ss = new int[2 * c];
            double sum = 0, avg;
            for (int i = 0; i < s; i++) {
                ss[i] = fs.nextInt();
                sum += ss[i];
            }
            avg = sum / c;
            Arrays.sort(ss);
            //System.out.println(Arrays.toString(ss));
            double imb = 0;
            System.out.printf("Set #%d\n", tc);
            for (int i = 0, j = 2*c-1; i < c; i++, j--) {
                double tot = ss[i] + ss[j];
                imb += Math.abs(avg - tot);
                if(ss[i]==0 && ss[j]==0)
                    System.out.printf(" %d:\n", i);
                else if(ss[i]==0)
                    System.out.printf(" %d: %d\n", i, ss[j]);
                else if(ss[j]==0)
                    System.out.printf(" %d: %d\n", i, ss[i]);
                else 
                    System.out.printf(" %d: %d %d\n", i, ss[i], ss[j]);
            }
            System.out.printf("IMBALANCE = %.5f\n", imb);
            System.out.println();
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