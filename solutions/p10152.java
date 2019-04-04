import java.util.*;
import java.io.*;

class Main {

    static FastReader fs = new FastReader();
    static int n;
    static HashMap<String,Integer> hm;
    static String []tur;
    static String []desired;

    public static void main(String[] args) {
        int tc = fs.nextInt();
        boolean flag = false;
        for(int tt=1;tt<=tc;tt++){
            hm = new HashMap<>();
            n = fs.nextInt();
            tur = new String[n];
            desired = new String[n];
            for(int i=0;i<n;i++)
                tur[i] = fs.nextLine();
            for(int i=0;i<n;i++){
                desired[i] = fs.nextLine();
                hm.put(desired[i],i);
            }
            int nextBig = -1;
            int bigRev = -1;
            for(int i=0;i<n;i++){
                int id = hm.get(tur[i]);
                //System.out.println(id);
                if(id < nextBig){
                    bigRev = Math.max(bigRev,id);
                }
                else{
                    nextBig = id;
                }
            }
            //System.out.println(bigRev);
            for(int i=bigRev;i>=0;i--){
                System.out.println(desired[i]);
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