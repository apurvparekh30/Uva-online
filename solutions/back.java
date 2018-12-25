import java.util.*;
import java.io.*;

class Main {

    static FastReader fs = new FastReader();
    static int n;
    static int[] r, p;

    static int findSet(int i) {
        return (p[i] == i) ? i : (p[i] = findSet(p[i]));
    }

    static void union(int a, int b) {
        int x = findSet(a);
        int y = findSet(b);
        if (x != y) {
            if (r[x] > r[y]) {
                p[y] = x;
            } else {
                p[x] = y;
                if (r[x] == r[y])
                    r[y]++;
            }
        }
    }

    static int eid(int x){
        return x + n;
    }

    static int isFriend(int a, int b) {
        int x = findSet(a);
        int y = findSet(b);
        if (x == y)
            return 1;
        return 0;
    }

    static int isEn(int a, int b) {
        if (isFriend(a, b) == 1)
            return 0;
        for (int e : en[a]) {
            if (isFriend(e, b) == 1)
                return 1;
        }
        for (int e : en[b]) {
            if (isFriend(e, a) == 1)
                return 1;
        }
        return 0;
    }

    static int setFriend(int a, int b) {
        boolean flag = true;
        for (int e : en[a]) {
            int tmp = isFriend(e, b);
            if (tmp == 1) {
                flag = false;
                break;
            }
        }
        for (int e : en[b]) {
            int tmp = isFriend(e, a);
            if (tmp == 1) {
                flag = false;
                break;
            }
        }
        if (!flag)
            return -1;
        int x = findSet(a);
        int y = findSet(b);
        if (x != y) {
            if (r[x] > r[y]) {
                p[y] = x;
            } else {
                p[x] = y;
                if (r[x] == r[y])
                    r[y]++;
            }
        }
        return -2;
    }

    static int setEn(int a, int b) {
        boolean flag = true;
        for (int e : en[a]) {
            int tmp = isEn(e, b);
            if (tmp == 1) {
                flag = false;
                break;
            }
        }
        for (int e : en[b]) {
            int tmp = isEn(e, a);
            if (tmp == 1) {
                flag = false;
                break;
            }
        }
        if (!flag)
            return -1;
        en[a].add(b);
        en[b].add(a);
        return -2;
    }

    public static void main(String[] args) {
        n = fs.nextInt();
        en = new ArrayList[n];
        r = new int[n];
        p = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = i;
            en[i] = new ArrayList<>();
        }

        while (true) {
            int o, a, b;
            o = fs.nextInt();
            a = fs.nextInt();
            b = fs.nextInt();
            if (o == 0 && a == 0 && b == 0)
                break;
            if (o == 1){
                if(findSet(a)==findSet(eid(b)) || findSet(b)==findSet(eid(a)))
                    System.out.println("-1");
                else
                    union(a,b);
                    //union(eid(a),eid(b));
            }
            else if (o == 2){
                if(findSet(a)==findSet(b) || findSet())
            }
            if (o == 3)
                ans = isFriend(a, b);
            if (o == 4)
                ans = isEn(a, b);

            if (ans != -2) {
                // System.out.println("for operation : " + o + " " + a + " " + b + " ans = " +
                // ans);
                System.out.printf("%d\n", ans);
            }
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