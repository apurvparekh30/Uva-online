import java.util.*;
import java.io.*;

class Main {

    static FastReader fs = new FastReader();
    static int n,d;
    public static void main(String[] args) {
        int tc = fs.nextInt();
        for(int tt=1;tt<=tc;tt++){
            n = fs.nextInt();
            d = fs.nextInt();
            int []rocks = new int[n+2];
            ArrayList<Integer> al = new ArrayList<>();
            rocks[0] = 0;
            rocks[n+1] = d;
            al.add(0);
            for(int i=1;i<=n;i++){
                String s = fs.next();
                if(s.charAt(0)=='B'){
                    al.add(i);
                }
                rocks[i] = Integer.parseInt(s.substring(2));
            }
            al.add(n+1);
            //System.out.println(Arrays.toString(rocks));
            //System.out.println(al);
            int m = 0;
            for(int i=0;i<al.size()-1;i++){
                int from = al.get(i);
                int to = al.get(i+1);
                if(to - from == 1){
                    m = Math.max(m,rocks[to]-rocks[from]);
                    continue;
                }
                int j;
                j = from + 2;
                for(;j<=to;j+=2){
                    m = Math.max(m,rocks[j]-rocks[j-2]);
                }
                if(j < to){
                    m = Math.max(m,rocks[to]-rocks[j]);
                }
                
                j = from + 1;
                m = Math.max(m,rocks[j]-rocks[from]);
                j=j+2;
                for(;j<=to;j+=2){
                    m = Math.max(m,rocks[j]-rocks[j-2]);
                }
                if(j < to){
                    m = Math.max(m,rocks[to]-rocks[j]);
                }
            }
            System.out.printf("Case %d: %d\n",tt,m);
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