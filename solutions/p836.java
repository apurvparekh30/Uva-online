import java.util.*;


class Main {

    static Scanner fs = new Scanner(System.in);
    static int [][]mat;
    static int n,m;

    public static void main(String[] args) {
        int tc = Integer.parseInt(fs.nextLine());
        fs.nextLine();
        boolean newLine = false;
        while(tc-- > 0){
            mat = new int[25][];
            n = 0;
            while(true){
                if(!fs.hasNextLine())
                    break;
                String line = fs.nextLine();
                if(line==null || line.isEmpty())
                    break;
                char []temp = line.toCharArray();
                mat[n] = new int[temp.length];
                m = 0;
                for(char c:temp){
                    int no = c - '0';
                    mat[n][m++] = no;
                }
                n++;
            }
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    if(i > 0)
                        mat[i][j] += mat[i-1][j];
                    if(j > 0)
                        mat[i][j] += mat[i][j-1];
                    if(i > 0 && j > 0)
                        mat[i][j] -= mat[i-1][j-1];
                }
            }
            int max = 0;
            for(int i=0;i<n;i++) {
                for(int j=0;j<m;j++){
                    for(int k=i;k<n;k++){
                        for(int l=j;l<m;l++){
                            int sum = mat[k][l];
                            if(i > 0)
                                sum-=mat[i-1][l];
                            if(j > 0)
                                sum-=mat[k][j-1];
                            if(i>0 && j>0)
                                sum+=mat[i-1][j-1];
                            int expected = (k-i+1) * (l-j+1);
                            if(sum == expected){
                                if(max < sum){
                                    max = sum;
                                }
                            }
                        }
                    }
                }
            }
            if(newLine)
                System.out.println();
            newLine = true;
            System.out.println(max);
        }
    }
}