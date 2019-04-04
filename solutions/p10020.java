import java.util.*;
import java.io.*;

class Main {

    static FastReader fs = new FastReader();
    static int m;
    static interval inter[], sol[];

    public static void main(String[] args) {
        int tc = fs.nextInt();
        boolean flag = false;
        for (int tt = 1; tt <= tc; tt++) {
            m = fs.nextInt();
            inter = new interval[100005];
            sol = new interval[100005];
            int n = 0;
            while (true) {
                int s, e;
                s = fs.nextInt();
                e = fs.nextInt();
                if (s == 0 && e == 0)
                    break;
                inter[n++] = new interval(s, e);
            }
            Arrays.sort(inter, 0, n);
            int currSt = 0, count = 0, curr = 0;
            while (currSt < m && curr < n) {
                sol[count] = new interval(0, 0);
                for (; inter[curr].st <= currSt ; curr++) {  
                    if (inter[curr].en > sol[count].en) {
                        sol[count] = inter[curr];
                    }
                    if(curr==n-1)
                        break;
                }
                if (sol[count].en == currSt) {
                    break;
                }
                currSt = sol[count].en;
                count++;
            }
            if (flag)
                System.out.println();
            flag = true;
            if (currSt >= m) {
                System.out.println(count);
                for (int i = 0; i < count; i++) {
                    System.out.println(sol[i].st + " " + sol[i].en);
                }
            } else {
                System.out.println("0");
            }
        }
    }

    static class interval implements Comparable<interval> {
        int st, en;

        interval(int st, int en) {
            this.st = st;
            this.en = en;
        }

        @Override
        public int compareTo(interval o) {
            return Integer.compare(this.st, o.st);
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