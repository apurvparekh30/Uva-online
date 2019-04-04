import java.util.*;
import java.io.*;

class Main {

    static FastReader fs = new FastReader();
    static char[] s;
    static int n;
    static char[] ans;

    static void rec(int idx) {
        if (idx == s.length) {
            ans[idx] = '\0';
            System.out.println(new String(ans, 0, idx));
            return;
        }
        for (int i = idx; i >= 1; i--)
            ans[i] = ans[i - 1];
        for (int i = 0; i <= idx; i++) {
            ans[i] = s[idx];
            rec(idx + 1);
            ans[i] = ans[i + 1];
        }
    }

    public static void main(String[] args) {
        boolean flag = false;
        while (true) {
            String ln = fs.nextLine();
            if (ln == null || ln.isEmpty())
                break;
            s = new StringTokenizer(ln).nextToken().toCharArray();
            ans = new char[s.length + 1];
            if(flag)
                System.out.println();
            flag = true;
            rec(0);
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