import java.util.*;

class Main {

    static Scanner fs = new Scanner(System.in);
    static hatti[] arr;

    static class hatti implements Comparable<hatti> {
        int w;
        int q;
        int id;

        hatti(int w, int q,int id) {
            this.w = w;
            this.q = q;
            this.id = id;
        }
        @Override
        public int compareTo(hatti o) {
            return Integer.compare(this.w,o.w);
        }
        @Override
        public String toString() {
            return w + " " + q;
        }
    }

    public static void main(String[] args) {
        arr = new hatti[1000];
        int n = 0;
        while (true) {
            if (fs.hasNextLine()) {
                StringTokenizer st = new StringTokenizer(fs.nextLine());
                arr[n] = new hatti(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),n+1);
                n++;
            } else {
                break;
            }
        }
        Arrays.sort(arr,0,n);
        int count[] = new int[n];
        count[0] = 0;
        for (int i = 1; i < n; i++) {
            count[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[i].w > arr[j].w && arr[j].q > arr[i].q) {
                    if (count[i] < count[j] + 1) {
                        count[i] = count[j] + 1;
                    }
                }
            }
        }  
        //System.out.println(Arrays.toString(count));
        int max = 0;
        for(int i = 0;i<count.length;i++){
            max = Math.max(count[i],max);
        }
        System.out.println(max);
        int []solution = new int[max];
        boolean first=true;
		int last=0;
		for (int i=count.length-1;i>=0 && max>0;i--) {
			if (count[i]==max && (first || last<arr[i].q)) {
				last=arr[i].q;
				solution[--max]=arr[i].id;
				first=false;
			}
		}
		
		for (int i=0;i<solution.length;i++) {
			System.out.println(solution[i]);
}
    }
}