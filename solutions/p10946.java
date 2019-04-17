import java.util.*;

class Main {
    static Scanner fs = new Scanner(System.in);
    static int n,m;
    static char [][]grid;
    static List<pair> list;
    static int []dr = {1,0,-1,0};
    static int []dc = {0,-1,0,1};

    static class pair implements Comparable<pair> {
        char c;
        int count;
        pair(char c,int count){
            this.c = c;
            this.count = count;
        }
        @Override
        public int compareTo(pair o) {
            if(this.count == o.count){
                return Character.compare(this.c, o.c);
            }
            return Integer.compare(o.count,this.count);
        }
        @Override
        public String toString() {
            return c + " " + count;
        }
    }

    static int dfs(int i,int j,char c){
        int count = 0;
        for(int k=0;k<4;k++){
            int ni = i + dr[k];
            int nj = j + dc[k];
            if(ni<0 || ni>=n || nj<0 || nj>=m)
                continue;
            if(grid[ni][nj]!=c)
                continue;
            grid[ni][nj] = '.';
            count += dfs(ni,nj,c);
        }
        return count + 1;
    }

    public static void main(String[] args) {
        int tc = 0;
        while(true){
            tc++;
            n = fs.nextInt();
            m = fs.nextInt();
            if(n==0 && m==0)
                break;
            grid = new char[n][];
            list = new ArrayList<>();
            for(int i=0;i<n;i++){
                grid[i] = fs.next().toCharArray();
            }
            pair ans = new pair('A','0');
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    if(grid[i][j]!='.'){
                        char c = grid[i][j];
                        grid[i][j] = '.';
                        int curr =  dfs(i,j,c);
                        list.add(new pair(c,curr));
                    }
                }
            }
            Collections.sort(list);
            System.out.println("Problem " + tc + ":");
            for(pair p:list){
                System.out.println(p);
            }
        }
    }
}