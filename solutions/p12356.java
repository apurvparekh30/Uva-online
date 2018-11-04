import java.util.*;
import java.io.*;

class Main {
    static int s,c;
    static int [] L,R;
    static FastReader fr = new FastReader();

    public static void main(String[] args) {
        while(true){
            s = fr.nextInt();
            c = fr.nextInt();
            if(s==0 && c==0) break;

            L = new int[s+2];
            R = new int[s+2];

            for(int i=1;i<=s;i++){
                L[i] = i - 1;
                R[i] = i + 1;
            }
            //System.out.println(c);
            StringBuilder sb=new StringBuilder();
            while(c-- > 0){
                int a,b; 
                a=fr.nextInt();
                b=fr.nextInt();

                L[R[b]] = L[a];
                if(L[a] == 0)
                    sb.append("*");
                else sb.append(L[a]);
                sb.append(" ");
                
            
                R[L[a]] = R[b];
                if(R[b]>s) sb.append("*");
                else sb.append(R[b]);
                sb.append("\n");
            }   
            sb.append("-");
            System.out.println(sb);
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