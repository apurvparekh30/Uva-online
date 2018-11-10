import java.util.*;
import java.io.*;

class Main {

    static FastReader fs = new FastReader();
    static String[] words;
    static char[] pattern;

    static void rec(int idx, int pos, char[] sb) {
        if (idx == pattern.length) {
            System.out.println(new String(sb, 0, pos));
            return;
        }
        if (pattern[idx] == '0') {
            for (int i = 0; i <= 9; i++) {
                sb[pos] = (char) (i + '0');
                rec(idx + 1, pos + 1,  sb);
            }
        } else {
            for (int i = 0; i < words.length; i++) {
                    int k = pos;
                    for (char j : words[i].toCharArray()) {
                        sb[k++] = j;
                    }
                    rec(idx + 1, pos + words[i].length(), sb);
                
            }
        }
    }

    public static void main(String[] args) {
        while (true) {
            String ln = fs.nextLine();
            if (ln == null || ln.isEmpty())
                break;
            StringTokenizer st = new StringTokenizer(ln);
            int n = Integer.parseInt(st.nextToken());
            words = new String[n];
            for (int i = 0; i < n; i++)
                words[i] = fs.next();
            int m = Integer.parseInt(new StringTokenizer(fs.nextLine()).nextToken());
            System.out.println("--");
            for (int i = 0; i < m; i++) {
                pattern = fs.next().toCharArray();
                rec(0, 0, new char[10000]);
            }

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