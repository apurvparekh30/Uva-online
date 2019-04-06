import java.util.*;

class Main {
    static Scanner fs = new Scanner(System.in);
    static int d;
    static HashMap<String,Integer> dist;

    static class state implements Comparable<state> {
        int a,b,c;
        int cost;
        state(int a,int b,int c,int cost){
            this.a = a;
            this.b = b;
            this.c = c;
            this.cost = cost;
        }
        @Override
        public int compareTo(state o) {
            return Integer.compare(this.cost,o.cost);
        }
        @Override
        public String toString() {
            return a + " " + b + " " + c;
        }
    }

    public static void main(String[] args) {
        int tc = fs.nextInt();
        while(tc-- > 0){
            dist = new HashMap<>();
            int a = fs.nextInt();
            int b = fs.nextInt();
            int c = fs.nextInt();
            d = fs.nextInt();
            int []cap = new int[]{a,b,c};
            Queue<state> pq = new PriorityQueue<>();
            state curr = new state(0,0,c,0);
            pq.offer(curr);
            dist.put(curr.toString(),0);
            int ans = 0;
            int dd = 0;
            while(!pq.isEmpty()){
                curr = pq.poll();
                //System.out.println(curr);
                if(dist.containsKey(curr.toString()) &&  dist.get(curr.toString()) < curr.cost){
                    continue;
                }
                a = curr.a;
                b = curr.b;
                c = curr.c;
                int cost = curr.cost;
                //System.out.println(a + " " + b + " " + c + " " + " " + d + cost);
                if(a==d || b==d || c==d){
                    ans = cost;
                    dd = d;
                    break;
                }
                int [] arr = new int[]{a,b,c};
                int currd = -1;
                for(int i=0;i<3;i++){
                    if(arr[i] < d && (d - arr[i] < d - currd )){
                        currd = arr[i];
                    }
                }
                if(d - dd > d - currd){
                    ans = cost;
                    dd = currd;
                }
                for(int i=0;i<3;i++){
                    for(int j=0;j<3;j++){
                        if(i!=j){
                            int []temp = Arrays.copyOf(arr,arr.length);
                            //System.out.println(Arrays.toString(temp));
                            int cc = Math.min(temp[i],cap[j]-temp[j]);
                            temp[i] = temp[i] - cc;
                            temp[j] = temp[j] + cc;
                            state nState = new state(temp[0],temp[1],temp[2],cost+cc);
                            
                            if(!dist.containsKey(nState.toString()) || dist.get(nState.toString()) > nState.cost) {
                                //System.out.println(nState + " " + nState.cost);
                                dist.put(nState.toString(),nState.cost);
                                pq.offer(nState);
                            }
                        }
                    }
                }
            }
            System.out.println(ans + " " + dd);
        }
    }
}