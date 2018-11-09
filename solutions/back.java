import java.util.*;
import java.io.*;

class Main {

    static FastReader fs = new FastReader();
    static int aa,bb,t;
    static boolean memo[][];

    static boolean rec(int idx,int a,int b,ArrayList<String> al){
        if(a==t || b==t){
            for(int i=0;i<idx;i++){
                System.out.println(al.get(i));
            }
            System.out.println("success");
            return true;
        }
        if(memo[a][b] == true)
            return false;
        memo[a][b] = true;
        if(a!=aa){
            al.add(idx,"fill A");
            if(rec(idx+1,aa,b,al))
                return true;
        }           
           
        if(b!=bb){
            al.add(idx,"fill B");
            if(rec(idx+1,a,bb,al))
                return true;
        }           
        if(a!=0){
            al.add(idx,"empty A");
            if(rec(idx+1,0,b,al))
                return true;
        }           
            
        if(b!=0){
            al.add(idx,"empty B");
            if(rec(idx+1,a,0,al))
                return true;
        }         
        int tmp = Math.min(a,bb-b);
        al.add(idx,"pour A B");
        if(rec(idx+1,a-tmp,b+tmp,al))
            return true; 
        tmp = Math.min(aa-a,b);
        al.add(idx,"pour B A");
        if(rec(idx+1,a+tmp,b-tmp,al))
            return true;
        return false;  
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
            System.out.println(t);
            memo = new boolean[aa+1][bb+1];
            rec(0,0,0,new ArrayList<String>());
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