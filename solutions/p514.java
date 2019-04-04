// Apurv Parekh

import java.util.*;
import java.io.*;

class Main {

    static FastReader fs = new FastReader();
    static int n;
    static int [] arr;
    static Deque<Integer> dq;

    public static void main(String[] args) {
        //boolean flag = false;
        while(true){
            n = fs.nextInt();
            if(n == 0) break;
           // if(flag) System.out.println(); flag=true;
            while(true){
                arr = new int [n];
                dq = new ArrayDeque<Integer>();

                arr[0]= fs.nextInt();
                if(arr[0] == 0) break;
                for(int i=1;i<n;i++){
                    arr[i]=fs.nextInt();
                }
                boolean res = false;
                int curr=1;
                for(int i=0;i<n;i++){
                    res = false;
                    if(curr == arr[i]){
                        curr++;
                        res = true;
                        continue;
                    }
                    if(!dq.isEmpty()){
                        if(dq.peekFirst()==arr[i]){
                            res = true;
                            dq.removeFirst();
                            continue;
                        }
                    }
                    while(curr<=n){
                        if(curr == arr[i]){
                            res = true;
                            curr++;
                            break;
                        }
                        else dq.addFirst(curr);
                        curr++;
                    }
                    if(!res) break;

                }
                if(res)
                    System.out.println("Yes");
                else 
                    System.out.println("No");
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