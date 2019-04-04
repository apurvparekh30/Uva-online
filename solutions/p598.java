import java.util.*;
import java.io.*;

class Main {

    static FastReader fs = new FastReader();

    static ArrayList<String> news;
    static int a, b;
    static int n, k;

    static void rec(int pos, int size, String[] comb) {
        if (n - pos < k - size)
            return;
        if (size == k) {
            boolean comma = false;
            for (int i = 0; i < size; i++) {
                if (comma)
                    System.out.print(", ");
                comma = true;
                System.out.print(comb[i]);
            }
            System.out.println();
            return;
        }

        // take
        comb[size] = news.get(pos);
        rec(pos + 1, size + 1, comb);

        // leave
        rec(pos + 1, size, comb);
    }

    public static void main(String[] args) {
        int tc = fs.nextInt();
        boolean flag = false;
        boolean setFlag = false;
        while (tc-- > 0) {
            StringTokenizer st = new StringTokenizer(fs.nextLine());
            if (!st.hasMoreTokens())
                st = new StringTokenizer(fs.nextLine());
            String tok1 = st.nextToken();
            String tok2 = "";
            int cnt = 1;
            if (tok1.equals("*")) {
                cnt = 0;
            } else if (st.hasMoreTokens()) {
                cnt = 2;
                tok2 = st.nextToken();
            }
            String ln;
            news = new ArrayList<String>();
            while (true) {
                ln = fs.nextLine();
                if (ln == null || ln.isEmpty())
                    break;
                news.add(ln);
            }
            n = news.size();
            if (cnt == 0) {
                a = 1;
                b = n+1;
            } else if (cnt == 1) {
                a = Integer.parseInt(tok1);
                b = a + 1;
            } else {
                a = Integer.parseInt(tok1);
                b = Integer.parseInt(tok2) + 1;
            }
            for (int i = a; i < b; i++) {
                if(setFlag) 
                    System.out.println();
                setFlag = true;
                k = i;
                System.out.println("Size " + i);
                rec(0, 0, new String[k]);
            }
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