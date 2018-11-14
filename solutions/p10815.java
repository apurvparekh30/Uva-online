import java.util.*;
import java.io.*;

class Main {

    static FastReader fs = new FastReader();
    static String text;
    static TreeSet<String> ts = new TreeSet<String>();

    public static void main(String[] args) {
        while(true){
            text = fs.nextLine();
            if(text == null)
                break;
            StringTokenizer st = new StringTokenizer(text);
            while(st.hasMoreTokens()){
                String wrd = st.nextToken().toLowerCase();
                StringBuilder w = new StringBuilder();
                for(char c:wrd.toCharArray()){
                    if(c>='a' && c<='z'){
                        w.append(c);
                    }
                    else if(w.length() > 0){
                        ts.add(w.toString());
                        w = new StringBuilder();
                    }
                }
                if(w.length()>0)
                    ts.add(w.toString());
            }
            
        }
        for(String wrd:ts){
            System.out.println(wrd);
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