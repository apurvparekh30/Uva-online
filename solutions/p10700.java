import java.util.*;
import java.io.*;

class Main {

    static FastReader fs = new FastReader();

    public static void main(String[] args) {
        int tc = fs.nextInt();
        for(int tt=1;tt<=tc;tt++){
            char[] expr = fs.nextLine().toCharArray();
            ArrayDeque<Long> al = new ArrayDeque<>();
            long mx=1,mn=0;
            boolean flg = false;
            String num = "";
            for(int i=0;i<expr.length;i++){
                char c = expr[i];
                if(c>='0' && c<='9'){
                    num+=c;
                }
                else{
                    //System.out.println(al + " "+flg + " " + c);
                    long number = Long.parseLong(num);
                    //System.out.println(number);
                    if(flg){
                        al.addLast(number + al.pollLast());
                    }
                    else {
                        al.addLast(number);
                    }
                    num="";
                    if(c=='+'){
                        flg = true;
                        continue;
                    }
                    if(c=='*'){
                        flg = false;
                        continue;
                    }
                }
            }
            long number = Long.parseLong(num);
            if(flg){
                al.addLast(number + al.pollLast());
            }
            else {
                al.addLast(number);
            }
            for(long i:al){
                mx*=i;
            }

            al = new ArrayDeque();
            flg = false;
            num = "";
            for(int i=0;i<expr.length;i++){
                char c = expr[i];
                if(c>='0' && c<='9'){
                    num+=c;
                }
                else{
                    //System.out.println(al + " "+flg + " " + c);
                    number = Long.parseLong(num);
                    //System.out.println(number);
                    if(flg){
                        al.addLast(number * al.pollLast());
                    }
                    else {
                        al.addLast(number);
                    }
                    num="";
                    if(c=='+'){
                        flg = false;
                        continue;
                    }
                    if(c=='*'){
                        flg = true;
                        continue;
                    }
                }
            }
            number = Long.parseLong(num);
            if(flg){
                al.addLast(number * al.pollLast());
            }
            else {
                al.addLast(number);
            }
            //System.out.println(al);
            mn = 0;
            for(long i:al){
                mn+=i;
            }
            System.out.printf("The maximum and minimum are %d and %d.\n",mx,mn);
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