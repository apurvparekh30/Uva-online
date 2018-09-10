import java.util.*;
import java.io.*;

class Main {

    static FastReader fs = new FastReader();
    static int []arr;
    static TreeSet<Integer> ts;

    public static void main(String[] args) {
        int tc=0;
        while(true){
            tc++;
            int n = fs.nextInt();
            if(n==0) break;
            arr = new int[n];
            ts = new TreeSet<Integer>();

            for(int i=0;i<n;i++)
                arr[i]=fs.nextInt();

            for(int i=0;i<n;i++)
                for(int j=i+1;j<n;j++){
                    ts.add(arr[i] + arr[j]);
                }

            System.out.println("Case "+tc+":");
            int m = fs.nextInt();
            while(m-- > 0){
                int ans = -1;
                int target = fs.nextInt();
                int hi = -1,lo = -1;
                if(ts.ceiling(target)!=null)
                    hi = ts.ceiling(target);
                if(ts.floor(target)!=null)
                    lo = ts.floor(target);
                if(hi==-1) ans = lo;
                else if(lo==-1) ans = hi;
                else ans = (hi-target < target-lo) ? hi:lo;
                System.out.println("Closest sum to "+target+" is "+ans+".");
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