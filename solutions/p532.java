import java.util.*;
import java.io.*;

class Main {

    static Scanner fs = new Scanner(System.in);
    static int l,r,c;
    static char [][][]g;
    static boolean [][][]v;

    static int dr[] = {1,0,-1,0};
    static int dc[] = {0,-1,0,1};
    static int dl[] = {-1,1};

    static class state {
        int k,i,j,m;
        state(int k,int i,int j,int m){
            this.k= k;
            this.i = i;
            this.j = j;
            this.m = m;
        }
    }
    
    public static void main(String[] args) {
        while(true){
            l = fs.nextInt();
            r = fs.nextInt();
            c = fs.nextInt();
            if(l==0 && r==0 && c==0)
                break;
            g = new char[l][r][c];
            v = new boolean[l][r][c];
            Queue<state> q = new ArrayDeque<>();
            for(int k=0;k<l;k++){
                for(int i=0;i<r;i++){
                    g[k][i] = fs.next().toCharArray();
                    for(int j=0;j<c;j++){
                        if(g[k][i][j]=='S'){
                            q.offer(new state(k,i,j,0));
                        }
                    }
                }
            }
            StringBuilder sb = new StringBuilder("Trapped!");
            while(!q.isEmpty()){
                state curr = q.poll();
                int k,i,j,m;
                k = curr.k;
                i = curr.i;
                j = curr.j;
                m = curr.m;
                if(g[k][i][j]=='E'){
                    sb = new StringBuilder("Escaped in "+m+" minute(s).");
                    break;
                }
                for(int index = 0;index < 4; index++){
                    int ii = i + dr[index];
                    int jj = j + dc[index];
                    if(ii < 0 || ii>=r || jj<0 || jj>=c)
                        continue;
                    if(v[k][ii][jj] || g[k][ii][jj]=='#')
                        continue;
                    v[k][ii][jj] = true;
                    q.offer(new state(k,ii,jj,m+1));
                }
                for(int index=0;index<2;index++){
                    int kk = k + dl[index];
                    if(kk < 0 || kk>=l)
                        continue;
                    if(v[kk][i][j] || g[kk][i][j]=='#')
                        continue;
                    v[kk][i][j] = true;
                    q.offer(new state(kk,i,j,m+1));
                }
            }
            System.out.println(sb);
        }
    }
}