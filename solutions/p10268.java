import java.util.*;
import java.io.*;

class Main {

    static FastReader fs = new FastReader();
    static int x,n;
    static ArrayList<Integer> al;

    public static void main(String[] args) {
        while(true){
            String ln = fs.nextLine();
            if(ln == null || ln.isEmpty()) 
                break;
            x = Integer.parseInt(ln);
            al = new ArrayList<Integer>();
            ln = fs.nextLine();
            StringTokenizer st = new StringTokenizer(ln);
            while(st.hasMoreTokens()){
                al.add(Integer.parseInt(st.nextToken()));
            }
            n = al.size() - 1;
            //System.out.println(al.toString());
            int result = al.get(0) * n;
            for(int i=1;i<al.size()-1;i++){
                result=result*x+al.get(i)*(n-1);
                n--;
            }
                
            System.out.println(result);
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