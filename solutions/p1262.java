import java.util.*;
import java.io.*;

class Main {

    static FastReader fs = new FastReader();
    static char [][] a,b;
    static int k;
    static HashMap<String,Boolean> hm;
    static ArrayList<String> al;

    static boolean valid(int c,int r){
        //System.out.println(r + " " + c);
        char ch = a[r][c];
        for(int i=0;i<6;i++){
            if(b[i][c]==ch) 
                return true;
        }
        return false;
    }

    static void backtrack(int c,String curr){
        if(c==5){
            if(!hm.containsKey(curr)){
                al.add(curr);
                hm.put(curr,true);
            }
            return ;
        }
        for(int i=0;i<6;i++){
            if(valid(c,i)){
                backtrack(c+1, curr+a[i][c]);
            }
        }
    }

    public static void main(String[] args) {
        int tc = fs.nextInt();
        while(tc-- > 0){

            a = new char[6][5];
            b = new char[6][5];
            hm = new HashMap<String,Boolean>();
            al = new ArrayList<String>();

            k = fs.nextInt();
            for(int i=0;i<6;i++){
                String nxt = fs.next();
                a[i]=nxt.toCharArray();
            }
            for(int i=0;i<6;i++){
                String nxt = fs.next();
                b[i]=nxt.toCharArray();
            }

            backtrack(0,"");

            if(al.size()<k) System.out.println("NO");
            else{
                Collections.sort(al);
                System.out.println(al.get(k-1));
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