import java.util.*;

class Main {

    static Scanner fs = new Scanner(System.in);
    static int k,p;
    static Map<Integer,List<Integer>> adj;
    static int cap[][];
    static final int oo = 987654321;
    static int parent[];

    static class pair {
        int u,c;
        pair(int u,int c){
            this.u = u;
            this.c = c;
        }
    }

    static int bfs(int s,int t){
        Arrays.fill(parent,-1);
        parent[s] = -2;
        Queue<pair> q = new ArrayDeque<>();
        q.offer(new pair(s,oo));
        while(!q.isEmpty()){
            pair curr = q.poll();
            int u = curr.u;
            int c = curr.c;

            for(int next:adj.get(u)){
                if(parent[next]==-1 && cap[u][next] > 0){
                    //System.out.println(next + " " + u);
                    parent[next] = u;
                    int newC = Math.min(c,cap[u][next]);
                    if(next==t){
                        return newC;
                    }
                    q.offer(new pair(next,newC));
                } 
            }
        }
        return 0;
    }

    static int maxFlow(int s,int t){
        int flow = 0;
        int newflow = 0;

        while((newflow = bfs(s,t)) > 0){
            flow = flow + newflow;
            int cur = t;
            while(cur!=s){
                int prev = parent[cur];
                cap[prev][cur] -= newflow;
                cap[cur][prev] += newflow;
                cur = prev;
            }
        }

        return flow;
    }

    public static void main(String[] args) {
        while(true){
            k = fs.nextInt();
            p = fs.nextInt();
            if(k==0 && p==0)
                break;
            cap = new int[k+p+2][k+p+2];
            parent = new int[k+p+2];
            adj = new HashMap<>();
            int []cnt = new int[k+1];
            for(int i=0;i<k+p+2;i++)
                adj.put(i,new ArrayList<>());
            for(int i=k+1;i<=k+p;i++){
                cap[0][i] = 1;
                adj.get(0).add(i);
                adj.get(i).add(0);
            }
            int tot = 0;    
            adj.put(k+p+1,new ArrayList<>());
            for(int i=1;i<=k;i++){
                adj.get(i).add(k+p+1);
                adj.get(k+p+1).add(i);
                cnt[i] = fs.nextInt();
                cap[i][k+p+1] = cnt[i];
                tot += cnt[i];
            }

            for(int i=k+1;i<=k+p;i++){
                adj.put(i,new ArrayList<>());
                int c = fs.nextInt();
                while(c-- > 0){
                    int v = fs.nextInt();
                    adj.get(i).add(v);
                    adj.get(v).add(i);
                    cap[i][v] = 1;
                }
            }

            /* System.out.println(adj);
            for(int []r:cap){
                System.out.println(Arrays.toString(r));
            } */
            int mf = maxFlow(0,k+p+1);
            //System.out.println(mf);
            if(mf == tot){
                System.out.println(1);
                for(int i=1;i<=k;i++){
                    StringBuilder sb = new StringBuilder();
                    int ct = 0;
                    for(int j=k+1;j<=k+p;j++){
                        if(cap[i][j]==1){
                            ct++;
                            sb.append(j-k).append(' ');
                        }
                        if(ct==cnt[i])
                            break;
                    }
                    System.out.println(sb);
                }
            }
            else {
                System.out.println(0);
            }
        }
    }

}