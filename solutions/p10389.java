import java.util.*;

class Main {
    static Scanner fs = new Scanner(System.in);
    static TreeMap<point, Integer> map = new TreeMap<>();
    static Map<Integer, List<state>> adj;

    static double g(int x1, int x2, int y1, int y2) {
        return Math.hypot(x1 - x2, y1 - y2);
    }

    static class point implements Comparable<point> {
        int x, y;

        point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(point o) {
            if (this.x == o.x)
                return Integer.compare(this.y, o.y);
            return Integer.compare(this.x, o.x);
        }
        @Override
        public String toString() {
            return x + " " + y;
        }
    }

    static class state implements Comparable<state> {
        int v;
        double c;

        state(int v, double c) {
            this.v = v;
            this.c = c;
        }

        @Override
        public int compareTo(state o) {
            return Double.compare(this.c, o.c);
        }
        @Override
        public String toString() {
            return v + " " + c;
        }
    }

    public static void main(String[] args) {
        int tc = Integer.parseInt(fs.nextLine());
        fs.nextLine();
        boolean newLine = false;
        while (tc-- > 0) {
            adj = new HashMap<>();
            map = new TreeMap<>();
            List<point> list = new ArrayList<>();
            int n = 0;
            String line = fs.nextLine();
            StringTokenizer st = new StringTokenizer(line);
            point home = new point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            point school = new point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            list.add(home);
            list.add(school);
            map.put(home, n++);
            map.put(school, n++);
            adj.put(0, new ArrayList<>());
            adj.put(1, new ArrayList<>());
            while (fs.hasNextLine()) {
                line = fs.nextLine();
                if (line == null || line.isEmpty())
                    break;
                st = new StringTokenizer(line);
                point prev = null;
                while (true) {
                    point u = new point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
                    if (u.x == -1 && u.y == -1)
                        break;
                    map.put(u, n++);
                    list.add(u);
                    adj.put(map.get(u), new ArrayList<>());
                    if (prev != null) {
                        double d = g(prev.x, u.x, prev.y, u.y) / 1000.0;
                        double t = d * 60 / 40;
                        adj.get(map.get(prev)).add(new state(map.get(u), t));
                        adj.get(map.get(u)).add(new state(map.get(prev), t));
                    }
                    prev = u;
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if(i==j)
                        continue;
                    point p1 = list.get(i);
                    point p2 = list.get(j);
                    double d = g(p1.x, p2.x, p1.y, p2.y) / 1000.0;
                    double t = d * 60 / 10;
                    adj.get(i).add(new state(j, t));
                    adj.get(j).add(new state(i, t));
                }
            }
            double dist[] = new double[n];
            Arrays.fill(dist,Double.MAX_VALUE);
            Queue<state> pq = new PriorityQueue<>();
            pq.offer(new state(0,0.0));
            dist[0] = 0.0;
            
            while(!pq.isEmpty()){
                state curr = pq.poll();
                int u = curr.v;
                double c = curr.c;
                if(dist[u] < c)
                    continue;
                if(u == 1)
                    break;
                for(state next:adj.get(u)){
                    if(dist[next.v] > c + next.c){
                        dist[next.v] = c + next.c;
                        pq.offer(new state(next.v,dist[next.v]));
                    }
                }
            }
            if(newLine)
                System.out.println();
            newLine = true;
            System.out.println((int) Math.round(dist[1]));
        }
    }
}