import java.util.*;
import java.io.*;

class Main {

    static FastReader fs = new FastReader();

    public static void main(String[] args) {
        while (true) {
            int b1, b2, b3, b4, b5, b6;
            b1 = fs.nextInt();
            b2 = fs.nextInt();
            b3 = fs.nextInt();
            b4 = fs.nextInt();
            b5 = fs.nextInt();
            b6 = fs.nextInt();
            if (b1 == 0 && b2 == 0 && b3 == 0 && b4 == 0 && b5 == 0 && b6 == 0)
                break;
            int cnt = 0;
            cnt += b6 + b5 + b4;
            b1 = b1 - (11 * b5);
            b2 = b2 - (5 * b4);
            cnt += b3 / 4;
            if (b3 % 4 != 0) {
                switch (b3 % 4) {
                case 1:
                    cnt++;
                    b2 = b2 - 5;
                    b1 = b1 - 7;
                    break;
                case 2:
                    cnt++;
                    b2 = b2 - 3;
                    b1 = b1 - 6;
                    break;
                case 3:
                    cnt++;
                    b2 = b2 - 1;
                    b1 = b1 - 5;
                    break;
                }
            }

            if (b2 > 0) { // we put b2/9 into other box because 6*6 box fits
                // with 9 of 2*2 box
                cnt += b2 / 9;
                if (b2 % 9 > 0) { // for the left over, we put them into a
                                  // new box
                    cnt++; // then check that how b1 are needed to be
                    // filled into the box
                    b1 -= 36 - ((b2 % 9) * 4);
                }
            } else if (b2 < 0) { // if some box need b2 to be filled, but b2
                                 // is not enough then use b1 instead
                b1 -= (-b2) * 4;
            }
            if (b1 > 0) { // fill 36 of b1 into the box
                cnt += b1 / 36;
                if (b1 % 36 > 0) { // if there are left over, then put all
                                   // of them into the new box
                    cnt++;
                }
            }
            System.out.println(cnt);
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