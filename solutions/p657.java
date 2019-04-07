import java.util.*;

class Main {

    static Scanner fs = new Scanner(System.in);
    static int n, m;
    static char[][] grid;
    static int count;
    static int dr[] = { 1, 0, -1, 0 };
    static int dc[] = { 0, -1, 0, 1 };
    static List<Integer> list;

    static void dfs2(int i, int j, char c) {
        grid[i][j] = c;
        for (int k = 0; k < 4; k++) {
            int ni = i + dr[k];
            int nj = j + dc[k];
            if (ni < 0 || ni >= n || nj < 0 || nj >= m)
                continue;
            if (grid[ni][nj] != 'X')
                continue;
            dfs2(ni, nj, c);
        }
    }

    static void dfs(int i, int j, char c) {
        for (int k = 0; k < 4; k++) {
            int ni = i + dr[k];
            int nj = j + dc[k];
            if (ni < 0 || ni >= n || nj < 0 || nj >= m)
                continue;
            if (grid[ni][nj] == '.')
                continue;
            if (grid[ni][nj] == 'X') {
                count++;
                dfs2(ni, nj, '*');
            }
            grid[ni][nj] = c;
            dfs(ni, nj, c);
        }
    }

    public static void main(String[] args) {
        int tc = 0;
        while (true) {
            tc++;
            m = fs.nextInt();
            n = fs.nextInt();

            if (n == 0 && m == 0)
                break;
            grid = new char[n][m];
            for (int i = 0; i < n; i++) {
                grid[i] = fs.next().toCharArray();
            }
            boolean space = false;
            list = new ArrayList<>();
            System.out.println("Throw " + tc);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    count = 0;
                    if (grid[i][j] != '.') {
                        dfs(i, j, '.');
                        list.add(count);
                    }
                }
            }
            Collections.sort(list);
            for (int i : list) {
                if (space)
                    sb.append(' ');
                space = true;
                sb.append(i);
            }

            System.out.println(sb);
            System.out.println();
        }
    }
}