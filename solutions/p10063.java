import java.util.*;
import java.io.*;

class Main {

    static FastReader fs = new FastReader();
    static char []arr;

    static int fact(int x){
        if(x==1) 
            return 1;
        return x*fact(x-1);
    }

    public static void main(String[] args) {
        boolean flag = false;
        while(true){
            String ln = fs.nextLine();
            if(ln==null || ln.isEmpty())
                break;
            int n = ln.length()-1;
            arr = new char[n+1];
            for(int i=0;i<=n;i++){
                arr[n-i] = ln.charAt(i);
            }
            if(flag)
                System.out.println();
            flag = true;
            int q = n + 1;
            int up = fact(q);
            System.out.println(new String(arr));
            int a=0,b=1;
            for(int i=1;i<up;i++){
                char tmp = arr[a%q];
                arr[a%q] = arr[b%q];
                arr[b%q] = tmp;
                System.out.println(new String(arr));
                a=(a+1)%q;
                b=(b+1)%q;
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