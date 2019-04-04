
// Apurv Parekh

import java.util.*;
import java.io.*;

class Main {

    static FastReader fs = new FastReader();
    static String in,out;

    static boolean possible(String a,String b){
        if(a.length()!=b.length()) return false;
        char []s1,s2;
        s1=a.toCharArray();
        s2=b.toCharArray();
        Arrays.sort(s1);
        Arrays.sort(s2);
        for(int i=0;i<s1.length;i++)
            if(s1[i]!=s2[i]) return false;
        return true;
    }

    static void dfs(Deque<Character> st, String op, String v) throws Exception {
        int i = v.length() + st.size();
        if (v.equals(out)) {
            boolean flag=false;
            for(char c:op.toCharArray()){
                if(flag) System.out.print(" "); flag=true;
                System.out.print(c);
            }
            System.out.println();
        }
        if (i < out.length()) {
            st.addLast(in.charAt(i));
            dfs(new ArrayDeque<Character>(st), op + "i", v);
            st.removeLast();
        }
        if (!st.isEmpty() && st.peekLast() == out.charAt(v.length())) {
            char c = st.removeLast();
            String t = v + c;
            dfs(new ArrayDeque<Character>(st), op + "o", t);
        }
    }

    public static void main(String[] args) throws Exception {
        while (true) {
            in = fs.nextLine();
            if (in == null || in.isEmpty())
                break;
            out = fs.nextLine();
            
                System.out.println("[");
                if(possible(in,out))
                    dfs(new ArrayDeque<Character>(), "", "");
                System.out.println("]");
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