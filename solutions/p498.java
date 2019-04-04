import java.util.*;
import java.io.*;

class Main{

    static FastReader fs = new FastReader();
    static ArrayList<Integer> al;

    static void solve(int x){
        int xx=1;
        int n = al.size();
        long res = 0;
        for(int i=n-1;i>=0;i--){
            int c = al.get(i);
            res+=c*xx;
            xx=x*xx;
        }
        System.out.print(res);
    }

    public static void main(String[] args) {
        while(true){
            String ln = fs.nextLine();
            if(ln == null || ln.isEmpty()) break;
            al = new ArrayList<Integer>();
            StringTokenizer st = new StringTokenizer(ln);
            while(st.hasMoreTokens()){
                al.add(Integer.parseInt(st.nextToken()));
            }
            ln = fs.nextLine();
            st = new StringTokenizer(ln);
            boolean flag = false;
            while(st.hasMoreTokens()){
                int x = Integer.parseInt(st.nextToken());
                if(flag) System.out.print(" "); flag=true;
                solve(x);
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