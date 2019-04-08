import java.util.*;

class Main {

    static Scanner fs = new Scanner(System.in);
    static char [][]grid;
    static int n,m;
    static int []dr = {1,1,0,-1,-1,-1,0,1};
    static int []dc = {0,-1,-1,-1,0,1,1,1};

    static int dfs(int i,int j){
        int ans = 1;
        for(int k=0;k<8;k++){
            int ni = i + dr[k];
            int nj = j + dc[k];
            if(ni<0 || ni>=n || nj<0 || nj>=m)
                continue;
            if(grid[ni][nj]=='0')
                continue;
            grid[ni][nj] = '0';
            ans += dfs(ni,nj);
        }
        return ans;
    }
    
    public static void main(String[] args) {
        int tc = Integer.parseInt(fs.nextLine());
        boolean nline = false;
        fs.nextLine();
        while(tc-- > 0){
            grid = new char[25][];
            n = 0;
            while(true) {
                if(!fs.hasNextLine()) break;
                String line = fs.nextLine();
                if(line==null || line.isEmpty())
                    break;
                grid[n++] = line.toCharArray();
                m = line.length();
            }
            int maxSize = 0;
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    if(grid[i][j] == '1'){
                        grid[i][j] = '0';
                        int size = dfs(i,j);
                        if(maxSize < size){
                            maxSize = size;
                        }
                    }
                }
            }
            if(nline)
                System.out.println();
            nline = true;
            System.out.println(maxSize);
        }
    }
}