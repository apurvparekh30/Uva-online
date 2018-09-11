import java.util.*;
import java.io.*;

class Main {

    static FastReader fs = new FastReader();
    static String str;
    static int []arr;

    public static void main(String[] args) {
        int tc = fs.nextInt();
        while(tc-- > 0){
            arr = new int[10];
            int n = fs.nextInt();
            str = new String("");
            for(int i=1;i<=n;i++)
                str+=new Integer(i).toString();
            //System.out.println(str);
            for(char c:str.toCharArray()){
                arr[c-'0']++;
            }
            boolean flag=false;
            for(int i:arr){
                if(flag) System.out.print(" ");
                flag=true;
                System.out.print(i);
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