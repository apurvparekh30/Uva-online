import java.util.*;

class Main {

    static Scanner fs = new Scanner(System.in);
    static int[][] g;
    static int n;

    public static void main(String[] args) {
        int tc = -1;
        while (fs.hasNextInt()) {
            tc ++;
            int p = fs.nextInt();
            g = new int[31][31];
            int n = 0;
            for (int i = 0; i < p; i++) {
                int u = fs.nextInt();
                int v = fs.nextInt();
                g[u][v] = 1;
                n = Math.max(n, u);
                n = Math.max(n, v);
            }
            for (int k = 0; k <= n; k++) {
                for (int i = 0; i <= n; i++) {
                    for (int j = 0; j <= n; j++) {
                        g[i][j] += g[i][k] * g[k][j];
                    }
                }
            }
            for(int k=0;k<=n;k++){
                if(g[k][k] != 0){
                    for(int i=0;i<=n;i++){
                        for(int j=0;j<=n;j++){
                            if(g[i][k] != 0 && g[k][j] != 0){
                                g[i][j] = -1;
                            }
                        }
                    }
                }
            }
            System.out.println("matrix for city " + tc);
            for(int i=0;i<=n;i++){
                boolean space = false;
                for(int j=0;j<=n;j++){
                    if(space)
                        System.out.print(" ");
                    space = true;;
                    System.out.print(g[i][j]);
                }
                System.out.println();
            }
        }
    }
}