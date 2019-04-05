import java.util.*;

class Main {

    static Scanner fs = new Scanner(System.in);
    static TreeMap<point,List<node>> adj;
    static int oo = 987654321;

    static double g(int x1,int x2,int y1,int y2){
        return Math.hypot(x1-x2,y1-y2);
    }

    static class point implements Comparable<point> {
        int x,y;
        point(int x,int y){
            this.x = x;
            this.y = y;
        }
        @Override
        public int compareTo(point o) {
            if(this.x == o.x)
                return Integer.compare(this.y, o.y);
            return Integer.compare(this.x, o.x);
        }
        @Override
        public String toString() {
            return x + " " + y;
        }
    }
    static class node implements Comparable<node> {
        point p;
        double time;
        node(point p,double time){
            this.p = p;
            this.time = time;
        }
        @Override
        public int compareTo(node o) {
            return Double.compare(this.time, o.time);
        }
    }

    public static void main(String[] args) {
        int tc = fs.nextInt();
        while(tc-- > 0){
            List<point> list = new ArrayList<>();
            adj = new TreeMap<>();
            TreeMap<point,Double> dist = new TreeMap<>();
            point home = new point(fs.nextInt(),fs.nextInt());
            point school = new point(fs.nextInt(),fs.nextInt());
            list.add(home);
            list.add(school);
            adj.put(home,new ArrayList<>());
            dist.put(home,Double.MAX_VALUE);
            adj.put(school,new ArrayList<>());
            dist.put(school,Double.MAX_VALUE);
            //System.out.println(adj + " " + adj.containsKey(school));
            while(fs.hasNextInt()){
                point prev = null;
                while(true){
                    int x = fs.nextInt();
                    int y = fs.nextInt();
                    if(x==-1 && y==-1)
                        break;
                    
                    point p = new point(x,y);
                    dist.put(p,Double.MAX_VALUE);
                    list.add(p);
                    //System.out.println("hnnnn" + adj + " " + adj.containsKey(school) + " " + p);
                    adj.put(p,new ArrayList<>());
                    
                    if(prev!=null){
                        double d = g(prev.x,x,prev.y,y);
                        adj.get(prev).add(new node(new point(x,y),d/200*18));
                        //System.out.println(adj + " " + adj.containsKey(school));
                    }
                    prev = p;
                }
            }
            //System.out.println(adj + " " + adj.containsKey(school));
            for(int i=0;i<list.size();i++){
                for(int j=0;j<list.size();j++){

                    if(i!=j){
                        point p1 = list.get(i);
                        point p2 = list.get(j);
                        double d = g(p1.x,p2.x,p1.y,p2.y);
                        double t = d / 50*18;
                        adj.get(p1).add(new node(p2,t));
                        List<node> ls = adj.get(p2);
                        //System.out.println(adj + " " + adj.containsKey(new point(10000,1000)) + " " + p2);
                        ls.add(new node(p1,t));
                    }
                }
            }
            Queue <node> pq = new PriorityQueue<>();
            pq.offer(new node(home,0.0));
            System.out.println(dist);
            while(!pq.isEmpty()){
                node curr = pq.poll();
                point u = curr.p;
                double time = curr.time;
                System.out.println(time);
                if(time > dist.get(u))
                    continue;
                for(node next:adj.get(u)){
                    if(dist.get(next.p) > time + next.time){
                        dist.put(next.p,time+next.time);
                        pq.offer(new node(next.p,dist.get(next.p)));
                    }
                }
            }
            System.out.println(dist.get(school));
        }
    }
}