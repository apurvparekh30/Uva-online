import java.util.*;
import java.io.*;

class Main {

    static FastReader fs = new FastReader();
    static int k;
    static int[] cols;
    static int[][] brd;
    static int score = 0;

    static boolean valid(int row, int col) {
        for (int i = 0; i < row; i++) {
            if (cols[i] == col || (Math.abs(i - row)) == Math.abs(cols[i] - col))
                return false;
        }
        return true;
    }

    static void rec(int row, int scr) {
        if (row == 8) {
            score = Math.max(score, scr);
        }
        for (int col = 0; col < 8; col++) {
            if (valid(row, col)) {
                cols[row] = col;
                rec(row + 1, scr + brd[row][col]);
            }
        }
    }

    public static void main(String[] args) {
        k = fs.nextInt();
        for (int i = 0; i < k; i++) {
            brd = new int[8][8];
            cols = new int[8];
            for (int j = 0; j < 8; j++)
                for (int l = 0; l < 8; l++)
                    brd[j][l] = fs.nextInt();

            
            score = 0;
            rec(0, 0);
            System.out.printf("%5d\n",score);
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