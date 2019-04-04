import java.util.*;

class Main {

    static Scanner fs = new Scanner(System.in);
    static int n, m;
    static int[][] in, cost, path;
    static int[] dr = { -1, 0, 1 };
    static int[] dc = { 1, 1, 1 };

    static int g(int i, int d) {
        return (((i % d) + d) % d);
    }

    public static void main(String[] args) {
        while (fs.hasNextInt()) {
            // String line = fs.nextLine();
            // System.out.println(line);
            // StringTokenizer st = new StringTokenizer(line);
            n = fs.nextInt(); // Integer.parseInt(st.nextToken());
            m = fs.nextInt(); // .parseInt(st.nextToken());
            in = new int[n][m];
            cost = new int[n][m];
            path = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    in[i][j] = fs.nextInt();
                }
            }
            for (int i = 0; i < n; i++) {
                cost[i][m - 1] = in[i][m - 1];
            }
            /*
             * for(int []r:cost){ System.out.println(Arrays.toString(r)); }
             */
            for (int col = m - 2; col >= 0; col--) {
                for (int row = n - 1; row >= 0; row--) {
                    int d = Integer.MAX_VALUE;
                    for (int i = 0; i < 3; i++) {
                        int nr = row + dr[i];
                        int nc = col + dc[i];
                        nr = g(nr, n);
                        if (nr >= n || nc >= m)
                            break;
                        if (d >= (in[row][col] + cost[nr][nc])) {
                            
                            if(d > (in[row][col] + cost[nr][nc])){
                                d = in[row][col] + cost[nr][nc];
                                path[row][col] = nr;
                            }
                            else {
                                path[row][col] = Math.min(path[row][col],nr);
                            }
                                
                        }
                    }
                    cost[row][col] = d;

                }
                /*
                 * for(int []r:cost){ System.out.println(Arrays.toString(r)); }
                 * System.out.println();
                 */
            }
            int []ans = new int[m];
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                if(min > cost[i][0]){
                    int r = i;
                    for(int j=0;j<m;j++){
                        ans[j] = r+1;
                        r = path[r][j];
                    }
                    min = cost[i][0];
                }
            }
            boolean space = false;
            for(int i=0;i < ans.length;i++){
                if(space)
                    System.out.print(" ");
                space = true;
                System.out.print(ans[i]);
            }
            System.out.println();
            System.out.println(min);
        }
    }
}