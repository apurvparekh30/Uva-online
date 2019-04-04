
//Apurv Parekh
import java.util.*;
import java.io.*;

class Main {
    static FastReader scan = new FastReader();
    static String s;
    static int n;
    static HashMap<Character, Integer> hm;

    public static void main(String[] args) {
        n = scan.nextInt();
        while (n-- > 0) {
            hm = new HashMap<Character, Integer>();
            int k, m;
            k = scan.nextInt();
            while (k-- > 0) {
                char c = scan.next().charAt(0);
                int p = scan.nextInt();
                hm.put(c, p);
            }
            m = scan.nextInt();
            int money = 0;
            while (m-- > 0) {
                s = scan.nextLine();
                // System.out.println(s);
                for (char c : s.toCharArray()) {
                    if (hm.containsKey(c)) {
                        money += hm.get(c);
                    }
                }
            }
            // System.out.println(hm.toString());
            double ans = money / 100.0;
            System.out.printf("%.2f",ans);
            System.out.println("$");
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