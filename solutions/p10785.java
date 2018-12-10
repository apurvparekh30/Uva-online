import java.util.*;
import java.io.*;

class Main {

    static FastReader fs = new FastReader();
    static int n;
    static char[] vow, con;
    static int[] vc, cc;

    static boolean isV(char c) {
        if (c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U')
            return true;
        return false;
    }

    public static void main(String[] args) {
        vow = new char[5];
        con = new char[21];
        int vidx = 0;
        int cidx = 0;
        char curr = 'A';
        for (int i = 0; i < 9; i++) {
            char tmp = curr;
            for (int j = 0; j < 3; j++) {
                if (isV(tmp)) {
                    vow[vidx++] = tmp;
                } else {
                    // System.out.println(tmp);
                    con[cidx++] = tmp;
                }
                if (i == 8 && j == 1)
                    break;
                tmp = (char) (tmp + 9);
            }
            curr++;
        }
        //System.out.println(Arrays.toString(vow));
        //System.out.println(Arrays.toString(con));
        int tc = fs.nextInt();
        for(int tt=1;tt<=tc;tt++){
            vc = new int[100];
            n = fs.nextInt();
            StringBuilder s1 = new StringBuilder();
            StringBuilder s2 = new StringBuilder();
            vidx = 0;
            for(int i=0;i<n;i+=2){
                if(vc[vow[vidx]] >= 21)
                    vidx++;
                s1.append(vow[vidx]);
                vc[vow[vidx]]++;
            }
            cidx = 0;
            for(int i=1;i<n;i+=2){
                if(vc[con[cidx]] >= 5)
                    cidx++;
                s2.append(con[cidx]);
                vc[con[cidx]]++;
            }
            char[] a=s1.toString().toCharArray();
            char[] b=s2.toString().toCharArray();
            Arrays.sort(a);
            Arrays.sort(b);

            System.out.printf("Case %d: ",tt);
            int a1=0,b1=0;
            for(int i=0;i<n;i++){
                if(i%2==0){
                    System.out.print(a[a1]);
                    a1++;
                }
                else{
                    System.out.print(b[b1]);
                    b1++;
                }
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