import java.util.*;
import java.io.*;

class Main {

    static FastReader fs = new FastReader();
    static int n;
    static ArrayList<Integer> al;

    public static void main(String[] args) {
        while(true){
            al = new ArrayList<Integer>();
            n = fs.nextInt();
            if(n==0) break;
            for(int i=0;i<n;i++){
                int no = fs.nextInt();
                if(no==0) continue;
                al.add(no);
            }
            boolean flag = false;
            if(al.isEmpty()) al.add(0);
            for(int a:al){
                if(flag) System.out.print(" ");
                flag=true;
                System.out.print(a);
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