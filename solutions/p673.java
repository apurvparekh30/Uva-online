import java.util.*;
import java.io.*;

class Main {

    static FastReader fs = new FastReader();
    static String s;

    static boolean solve() {
        ArrayDeque<Character> stk = new ArrayDeque<Character>();
        for(char c:s.toCharArray()){
            if (c == '[' || c == '(') {
                stk.addLast(c);
            } else {
                if (c == ']') {
                    if (stk.isEmpty() || stk.peekLast() == '(')	return false;
                    else stk.pollLast();
                } else if (c == ')') {
                    if (stk.isEmpty() || stk.peekLast() == '[')	return false;
                    else stk.pollLast();
                }
            }
        }
        if(!stk.isEmpty())
            return false;
        return true;
    }

    public static void main(String[] args) {
        int tc = fs.nextInt();
        while (tc-- != 0) {
            s = fs.nextLine();
            /*
             * if (s.isEmpty()) { System.out.println("Yes"); continue; }
             */

            if (solve())
                System.out.println("Yes");
            else
                System.out.println("No");
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