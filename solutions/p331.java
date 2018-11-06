import java.util.*;
import java.io.*;

class Main {

    static FastReader fs = new FastReader();
    static int n;
    static int arr[];
    static int maxSwaps;
    static int cnt;

    static boolean sorted(){
        for(int i=1;i<n;i++){
            if(arr[i-1] > arr[i])
                return false;
        }
        return true;
    }

    static void rec(int m){
        if(sorted()){
            if(maxSwaps > m){
                maxSwaps = m;
                cnt = 0;
            }
            if(m==maxSwaps)
                cnt++;
            return ;
        }

        if(m>maxSwaps)
            return;

        for(int i=0;i<n-1;i++){
            int tmp;
            tmp = arr[i]; 
            arr[i] = arr[i+1];
            arr[i+1] = tmp;

            rec(m+1);

            tmp = arr[i]; 
            arr[i] = arr[i+1];
            arr[i+1] = tmp;
        }
    }

    public static void main(String[] args) {
        
        int tc = 0;

        while(true){
            tc++;
            n = fs.nextInt();
            if(n==0)
                break;
            arr = new int[n];
            for(int i=0;i<n;i++)
                arr[i] = fs.nextInt();
            maxSwaps = n*(n-1)/2+1;
            cnt = 0;
            if(!sorted()){
                rec(0);
            }
            System.out.printf("There are %d swap maps for input data set %d.\n",cnt,tc);
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