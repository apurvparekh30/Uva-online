import java.util.*;

class Main {

    static Scanner fs = new Scanner(System.in);
    static double[][] g;
    static int n, m;
    static Map<String, Integer> map;

    public static void main(String[] args) {
        int tc = 0;
        while (true) {
            tc++;
            n = Integer.parseInt(fs.nextLine());
            if (n == 0)
                break;

            g = new double[n][n];
            map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                map.put(fs.nextLine(), i);
            }
            for(int i=0;i<n;i++)
                g[i][i] = 1;
            m = Integer.parseInt(fs.nextLine());
            for (int i = 0; i < m; i++) {
                StringTokenizer st = new StringTokenizer(fs.nextLine());
                String u = st.nextToken();
                double cost = Double.parseDouble(st.nextToken());
                String v = st.nextToken();
                g[map.get(u)][map.get(v)] = cost;
            }

            for (int k = 0; k < n; k++) {
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        g[i][j] = Math.max(g[i][j], g[i][k] * g[k][j]);
                    }
                }
            }

            StringBuilder sb = new StringBuilder("No");
            for (int k = 0; k < n; k++) {
                if (Double.compare(g[k][k], 1.0) > 0) {
                    sb = new StringBuilder("Yes");
                }
            }
            System.out.printf("Case %d: %s\n", tc, sb.toString());
            fs.nextLine();
        }
    }
}