import java.util.*;
import java.io.*;

class Main {

    static FastReader fs = new FastReader();
    static int n,l,u;

    public static void main(String[] args) {
        while(true){
            String nextline = fs.nextLine();
            if(nextline==null || nextline.isEmpty())
                break;
            StringTokenizer st = new StringTokenizer(nextline);
            n = Integer.parseInt(st.nextToken());
            l = Integer.parseInt(st.nextToken());
            u = Integer.parseInt(st.nextToken());
            long ans = 0;
            for(int i=31;i>=0;i--){
                if((n&(1L<<i))>0){
                    long tmp = ans + (1L<<i)-1;
                    //System.out.println(tmp);
                    if(tmp < l)
                        ans+=(1L<<i);
                }
                else{
                    long tmp = ans + (1L<<i);
                    if(tmp <= u)
                        ans+=(1L<<i);
                }
                //System.out.println(ans);
            }
            System.out.println(ans);
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