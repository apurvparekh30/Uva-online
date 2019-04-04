import java.util.*;
import java.io.*;

class Main {
    static FastReader fs = new FastReader();

    static int n,g;
    static int []x;
    static int []r;
    static interval []in;

    public static void main(String[] args) {
        while(true){
            n = fs.nextInt();
            g = fs.nextInt();

            if(n==0)
                break;
                
            x = new int[g];
            r = new int[g];
            in = new interval[g];

            for(int i=0;i<g;i++){
                x[i] = fs.nextInt();
                r[i] = fs.nextInt();
                in[i] = new interval(x[i]-r[i],x[i]+r[i]);
            }
            Arrays.sort(in);
            int cx = 0;
            int cy = 0;
            int i = 0;
            int cnt = 0;
            while(cx<n){
                for(;i<g && in[i].st<=cx;i++){
                    if(in[i].en > cy)
                        cy = in[i].en;
                }
                if(cy == cx)
                    break;
                cnt++;
                cx = cy;
            }
            if(cx < n)
                System.out.println(-1);
            else
                System.out.println(g-cnt);
        }
    }


    static class interval implements Comparable<interval>{
        int st,en;
        interval(int st,int en){
            this.st = st;
            this.en = en;
        }
        public int compareTo(interval o){
            return Integer.compare(this.st, o.st);
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