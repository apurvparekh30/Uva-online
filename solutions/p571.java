import java.util.*;
import java.io.*;

class Main {

    static FastReader fs = new FastReader();
    static int aa,bb,t;
    static boolean memo[][];
    static String[] ans;
    static int ansIdx;

    static void rec(int idx,int a,int b,String[] al){
        if(a==t || b==t){
            if(idx<ansIdx){
                ansIdx = idx;
                for(int i=0;i<idx;i++){
                    ans[i] = al[i];
                }
            }
            /* System.out.println();
            System.out.println();
            for(int i=0;i<idx;i++){
                System.out.println(al[i]);
            } */
            return;
        }
        if(memo[a][b] == true)
            return;
        if(a!=aa){
            memo[a][b] = true;
            al[idx] = "fill A";
            rec(idx+1,aa,b,al);
            memo[a][b] = false;
        }           
        if(b!=bb){
            memo[a][b] = true;
            al[idx] = "fill B";
            rec(idx+1,a,bb,al);
            memo[a][b] = false;
        }           
        if(a!=0){
            memo[a][b] = true;
            al[idx] = "empty A";
            rec(idx+1,0,b,al);
            memo[a][b] = false;
        }           
        if(b!=0){
            memo[a][b] = true;
            al[idx] = "empty B";
            rec(idx+1,a,0,al);
            memo[a][b] = false;
        }         
        int tmp = Math.min(a,bb-b);
        memo[a][b] = true;
        al[idx] = "pour A B";
        rec(idx+1,a-tmp,b+tmp,al);
        memo[a][b] = false;
        tmp = Math.min(aa-a,b);
        memo[a][b] = true;
        al[idx] = "pour B A";
        rec(idx+1,a+tmp,b-tmp,al);
        memo[a][b] = false;
    }

    public static void main(String[] args) {
        while(true){
            String ln = fs.nextLine();
            if(ln == null || ln.isEmpty())
                break;
            StringTokenizer st = new StringTokenizer(ln);
            aa = Integer.parseInt(st.nextToken());
            bb = Integer.parseInt(st.nextToken());
            t = Integer.parseInt(st.nextToken());
            memo = new boolean[aa+1][bb+1];
            ans = new String[1000000];
            ansIdx = 1000000;
            rec(0,0,0,new String[1000000]);
            for(int i=0;i<ansIdx;i++){
                System.out.println(ans[i]);
            }
            System.out.println("success");
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