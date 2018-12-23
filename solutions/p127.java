import java.util.*;
import java.io.*;

class Main {

    static FastReader fs = new FastReader();
    static ArrayDeque<String> st[];

    public static void main(String[] args) {
        while (true) {
            String nxt = fs.nextLine();
            if (nxt.equals("#"))
                break;
            nxt += " ";
            nxt += fs.nextLine();
            st = new ArrayDeque[52];
            StringTokenizer tk = new StringTokenizer(nxt);
            for (int i = 0; i < 52; i++) {
                st[i] = new ArrayDeque<>();
                st[i].addLast(tk.nextToken());
            }
            for (int i = 1; i < 52;) {
                /* for(int j=0;j<52;j++)
                    System.out.print(" " + st[j]);
                System.out.println(); */
                if (st[i].isEmpty()) {
                    i++;
                    continue;
                }
                char[] top, itop;
                int idx = i-1;
                int cnt = 0;
                while(cnt < 3 && idx>=0){
                    if(!st[idx].isEmpty()){
                        cnt++;
                        if(cnt==3)
                            break;
                    }
                    idx--;
                }
                if (idx >= 0) {
                    top = st[idx].getLast().toCharArray();
                    itop = st[i].getLast().toCharArray();
                    if (top[0] == itop[0] || top[1] == itop[1]) {
                        st[idx].addLast(new String(itop));
                        st[i].removeLast();
                        i = idx;
                        continue;
                    }
                }
                idx = i-1;
                cnt = 0;
                while(idx>=0){
                    if(!st[idx].isEmpty()){
                        cnt++;
                        if(cnt==1)
                            break;
                    }
                    idx--;
                }
                if (idx >= 0) {
                    top = st[idx].getLast().toCharArray();
                    itop = st[i].getLast().toCharArray();
                    if (top[0] == itop[0] || top[1] == itop[1]) {
                        st[idx].addLast(new String(itop));
                        st[i].removeLast();
                        i = idx;
                        continue;
                    }
                }
                i++;
            }
            int piles = 52;
            ArrayList<Integer> al = new ArrayList<>();
            for (int i = 0; i < 52; i++) {
                
                if (st[i].isEmpty())
                    piles--;
                else
                    al.add(st[i].size());
            }
            String s = (piles == 1) ? "pile" : "piles";
            System.out.printf("%d %s remaining:", piles, s);
            for (int i : al) {
                System.out.print(" " + i);
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