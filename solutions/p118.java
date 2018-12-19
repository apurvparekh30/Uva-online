import java.util.*;
import java.io.*;

class Main {

    static FastReader fs = new FastReader();
    static int d;
    static int sx, sy;
    static int n, m;
    static boolean pre[][];

    public static void main(String[] args) {
        n = fs.nextInt();
        m = fs.nextInt();
        pre = new boolean[n+1][m+1];
        while (true) {
            
            String nxtLine = fs.nextLine();
            if (nxtLine == null || nxtLine.isEmpty()) {
                break;
            }
            StringTokenizer st = new StringTokenizer(nxtLine);
            sx = Integer.parseInt(st.nextToken());
            sy = Integer.parseInt(st.nextToken());
            d = st.nextToken().charAt(0);
            boolean flag = false;
            char[] cmd = fs.next().toCharArray();
            for (int i = 0; i < cmd.length; i++) {
                if (cmd[i] == 'F') {
                    switch (d) {
                    case 'N':
                        sy++;
                        break;
                    case 'E':
                        sx++;
                        break;
                    case 'W':
                        sx--;
                        break;
                    case 'S':
                        sy--;
                        break;
                    }
                } else if (cmd[i] == 'R') {
                    switch (d) {
                    case 'N':
                        d = 'E';
                        break;
                    case 'E':
                        d = 'S';
                        break;
                    case 'W':
                        d = 'N';
                        break;
                    case 'S':
                        d = 'W';
                        break;
                    }
                } else {
                    switch (d) {
                    case 'N':
                        d = 'W';
                        break;
                    case 'E':
                        d = 'N';
                        break;
                    case 'W':
                        d = 'S';
                        break;
                    case 'S':
                        d = 'E';
                        break;
                    }
                }
                if (sx < 0 || sy < 0 || sx > n || sy > m) {
                    switch (d) {
                    case 'N':
                        sy--;
                        break;
                    case 'E':
                        sx--;
                        break;
                    case 'W':
                        sx++;
                        break;
                    case 'S':
                        sy++;
                        break;
                    }
                    if (pre[sx][sy] == true)
                        continue;
                    flag = true;
                    pre[sx][sy] = true;
                    break;
                }
            }
            if (!flag)
                System.out.printf("%d %d %c\n", sx, sy, d);
            else {
                System.out.printf("%d %d %c LOST\n", sx, sy, d);
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