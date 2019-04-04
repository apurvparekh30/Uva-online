
// Apurv Parekh

import java.util.*;
import java.io.*;

class Main {

    static Scanner fs = new Scanner(System.in);
    static long arr[] = new long[10000];

    public static void main(String[] args) {
        int idx = 0;
        while(fs.hasNextLong()){
            long tmp = fs.nextLong();
            int j=idx - 1;
            while(j>=0 && arr[j]>tmp){
                arr[j+1] = arr[j];
                j--;
            }         
            arr[j+1] = tmp;
            long res=0;
            if(idx%2 == 0){
                res = arr[idx/2];
            }
            else {
                int x = idx/2;
                res = (arr[x]+arr[x+1])/2;
            }
            System.out.println(res);
            idx++;
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