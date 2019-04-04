//Apurv Parekh

import java.util.*;
import java.io.*;

class Main {

    static FastReader fs = new FastReader();
    static LinkedList<StringBuilder> ll;
    static String str;

    public static void main(String[] args) {
        while(true){
            ll = new LinkedList<StringBuilder>();
            str=fs.nextLine();
            if(str==null || str.isEmpty()) break;
            boolean front = false;
            StringBuilder word = new StringBuilder();
            for(char c:str.toCharArray()){
                if(c == '['){
                    if(front)
                        ll.addFirst(word);
                    else 
                        ll.addLast(word);
                    word = new StringBuilder();
                    front=true;
                    continue;
                }
                if(c ==']'){
                    if(front)
                        ll.addFirst(word);
                    else 
                        ll.addLast(word);
                    word = new StringBuilder();
                    front=false;
                    continue;
                }
                else{
                    word.append(c);
                }
            }
            if(front) ll.addFirst(word);
            else ll.addLast(word);

            StringBuilder ans = new StringBuilder();
            for(StringBuilder c:ll){
                ans.append(c);
            }
            System.out.println(ans);
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