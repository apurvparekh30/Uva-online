import java.util.*;
import java.io.*;

class Main {

    static FastReader fs = new FastReader();
    static int n,l,w;
    static interval []inter;

    public static void main(String[] args) {
        while(true){
            String ln = fs.nextLine();
            if(ln==null || ln.isEmpty())
                break;
            StringTokenizer st = new StringTokenizer(ln);
            n = Integer.parseInt(st.nextToken());
            l = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());

            inter = new interval[n];
            for(int i=0;i<n;i++){
                double d,r;
                d = fs.nextDouble();
                r = fs.nextDouble();
                double dx = (double)(Math.sqrt(r*r-(w/2.0)*(w/2.0)));
                
                inter[i] = new interval(d-dx,d+dx);
            }            
            Arrays.sort(inter);
            //System.out.println(Arrays.toString(inter));
            double currx = 0;
            double curry = 0;
            int i=0;
            int count = 0;
            while(currx < l && i<n){
                for(;i<n && inter[i].st<=currx;i++){
                    if(inter[i].en > curry)
                        curry = inter[i].en;
                }
                if(curry == currx)
                    break;
                currx = curry;
                count++;
            }
            if(currx>=l)
                System.out.println(count);
            else    
                System.out.println("-1");
        }
    }

    static class interval implements Comparable<interval> {
        double st,en;

        interval(double st,double en){
            this.st = st;
            this.en = en;
        }
        @Override
        public int compareTo(interval o){
            return Double.compare(this.st,o.st);
        }
        @Override
        public String toString(){
            return st + " " + en;
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