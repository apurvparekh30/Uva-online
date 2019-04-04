import java.util.*;
import java.io.*;

class Main{

    static FastReader fs = new FastReader();
    static int []digit = new int[10];
    static int []input;
    static String []dig;
    static int n;

    static int seq(char[] s){
        int result = 0;
        int j=6;
        for(int i=0;i<7;i++,j--){
            if(s[i]=='Y')
                result|=(1<<j);
        }

        return result;
    }

    static boolean bk(int dI,int idx,int bMask){
        if(idx == n ) return true;
        if((input[idx] & bMask)!=0) return false;

        if(((digit[dI] ^ input[idx]) & input[idx]) == 0){
            //if(dI==7) System.out.println((digit[dI] ^ input[idx]) + "   " + input[idx]);
            return bk(dI-1,idx+1,bMask|(digit[dI] ^ input[idx]));
        }
        return false;
    }

    public static void main(String[] args) {
        digit[0] = seq("YYYYYYN".toCharArray());
        digit[1] = seq("NYYNNNN".toCharArray());
        digit[2] = seq("YYNYYNY".toCharArray());
        digit[3] = seq("YYYYNNY".toCharArray());
        digit[4] = seq("NYYNNYY".toCharArray());
        digit[5] = seq("YNYYNYY".toCharArray());
        digit[6] = seq("YNYYYYY".toCharArray());
        digit[7] = seq("YYYNNNN".toCharArray());
        digit[8] = seq("YYYYYYY".toCharArray());
        digit[9] = seq("YYYYNYY".toCharArray());
        //System.out.println(Arrays.toString(digit));
        while(true){
            n = fs.nextInt();
            if(n==0) break;
            input = new int[n];
            for(int i=0;i<n;i++){
                String curr = fs.next();
                input[i] = seq(curr.toCharArray());
            }
            boolean match = false;
            for(int dig=9;dig>=n-1 && !match;dig--){
                //System.out.println(match);
                match|=bk(dig,0,0);
            }
            if(match)
                System.out.println("MATCH");
            else   
                System.out.println("MISMATCH");
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