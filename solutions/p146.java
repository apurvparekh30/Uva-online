// Apurv Parekh

import java.util.*;
import java.io.*;

class Main {
    static FastReader fs = new FastReader();
    static String s;
    static char [] arr;

    static void swap(int a,int b){
        char tmp = arr[a];
        arr[a] = arr[b];
        arr[b]=tmp;
    }

    static void reverse(int st){
        int i=st; int j=arr.length-1;
        while(i<j){
            swap(i,j);
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        while(true){
            s = fs.next();
            if(s.equals("#")) break;
            arr = s.toCharArray();
            int l=-1;
            int st=0,en=0;
            for(int i=1;i<arr.length;i++){
                if(arr[i]>arr[i-1]){
                    st=i-1;
                    l = i;
                }
            }
            if(l==-1){
                System.out.println("No Successor");
                continue;
            }
            for(;l<arr.length;l++)
                if(arr[l] > arr[st])
                    en=l;
            swap(st,en);
            reverse(st+1);
            System.out.println(new String(arr));
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