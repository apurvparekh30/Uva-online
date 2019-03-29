<<<<<<< HEAD


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

class Main {

	static Cell[][] sheet;
	static int R,C;
	
	static void compute(int i, int j)
	{
		Cell cur = sheet[i][j];
		int sum = 0;
		while(!cur.stack.isEmpty())
		{
			Pair e = cur.stack.pop();
			if(sheet[e.r][e.c].isFormula)
				compute(e.r,e.c);
			sum += sheet[e.r][e.c].val;
		}
		cur.val = sum;
		cur.isFormula = false;
	}
	static void compute()
	{
		for(int i = 1; i <= R; i++)
			for(int j = 1; j <= C; j++)
				if(sheet[i][j].isFormula)
					compute(i,j);
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		while(TC-->0)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			C = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			sheet = new Cell[R+1][C+1];
			for(int i = 1; i <= R; i++)
			{
				st = new StringTokenizer(br.readLine());
				for(int j = 1; j <= C; j++)
				{
					String cell = st.nextToken();
					if(cell.charAt(0)=='=')
						sheet[i][j] = new Cell(cell);
					else
						sheet[i][j] = new Cell(Integer.parseInt(cell));
				}
			}
			compute();
			
			for(int i = 1; i <= R; i++)
			{
				for(int j = 1; j < C; j++)
					sb.append(sheet[i][j].val+" ");
				sb.append(sheet[i][C].val+"\n");
			}
		}
		
		System.out.print(sb);
	}

	static class Cell
	{
		int val;
		boolean isFormula;
		Stack<Pair> stack;
		
		Cell(int v){val = v;}
		
		Cell(String exp)
		{
			
			isFormula = true;
			stack = new Stack<Pair>();
			exp = exp.substring(1);
			StringTokenizer st = new StringTokenizer(exp,"+");
			int count = st.countTokens();
			while(count-->0)
				stack.push(getCell(st.nextToken()));
			
		}
		
		static Pair getCell(String x)
		{
			String col = "";
			int i;
			for(i = 0; i < x.length(); i++)
			{
				if(x.charAt(i)>='0'&&x.charAt(i)<='9')
					break;
				col += x.charAt(i);
			}
			int factor = 1;
			int c = 0;
			for(int k = 0; k < i; k++)
			{
				c += factor * (col.charAt(i-k-1) - 'A' + 1);
				factor *= 26;
			}
			
			int r = Integer.parseInt(x.substring(i));
			return new Pair(r,c);
		}

	}

	static class Pair
	{
		int r,c;
		Pair(int i, int j){r = i; c = j;}
	}
=======
import java.util.*;
import java.io.*;

class Main {

    static FastReader fs = new FastReader();
    static int f,n;
    static int stations[];
    static int []dist;
    static ArrayList<state> g[];
    static final int oo = 987654321;

    static class state implements Comparable<state> {
        int v,d;
        state(int v,int d){
            this.v = v;
            this.d = d;
        }
        @Override
        public int compareTo(state o) {
            return Integer.compare(this.d, o.d);
        }
        @Override
        public String toString() {
            return v + " " + d;
        }
    }
    public static void main(String[] args) {
        int tc = fs.nextInt();
        boolean flag = false;
        while(tc-- > 0){
            f = fs.nextInt();
            n = fs.nextInt();
            n++;
            stations = new int [f];
            dist = new int[n];
            g = new ArrayList[n];
            for(int i=0;i<f;i++)
                stations[i] = fs.nextInt();
            for(int i=1;i<n;i++)
                g[i] = new ArrayList<>();
            while(true){
                String nextLine = fs.nextLine();
                if(nextLine==null || nextLine.isEmpty())
                    break;
                int u,v,w;
                StringTokenizer st = new StringTokenizer(nextLine);
                u = Integer.parseInt(st.nextToken());
                v = Integer.parseInt(st.nextToken());
                w = Integer.parseInt(st.nextToken());
                g[u].add(new state(v,w));
                g[v].add(new state(u,w));
            }
            Arrays.fill(dist,oo);
            for(int i = 0;i<f;i++){
                Queue<state> pq = new PriorityQueue<>();
                pq.offer(new state(stations[i],0));
                while(!pq.isEmpty()){
                    state curr = pq.poll();
                    int v = curr.v;
                    int d = curr.d;
                    if(dist[v] < d)
                        continue;
                    for(state next:g[v]){
                        if(dist[next.v] > d + next.d){
                            dist[next.v] = d + next.d;
                            pq.offer(new state(next.v,dist[next.v]));
                        }
                    }
                }
            }
            int max = 0;
            int ans = 0;
            for(int i=1;i<n;i++){
                if(dist[i] > max){
                    max = dist[i];
                    ans = i;
                } 
            }
            if(flag)
                System.out.println();
            flag = true;
            System.out.println(ans);
        }
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
>>>>>>> 596022771fe107a3e70a543b8d4498f609f142f5
}