import java.util.*;

class Main {

    static Scanner fs = new Scanner(System.in);
    static String [][]sheet;
    static int n,m;

    static class pair {
        int row,col;
        pair(int row,int col){
            this.row = row;
            this.col = col;
        }
    }
    static pair c(char []str){
        int row = 0;
        int col = 0;
        for(int i=0;i<str.length;i++){
            if(Character.isDigit(str[i])){
                row = row * 10 + (str[i] - '0');
            }
            else {
                col = (26 * i + (str[i]-'A'));
            }
        }
        return new pair(row-1,col);
    }

    static String rec(int i,int j,String str){
        int sum = 0;
        String token = "";
        for(char c:str.toCharArray()){
            if(c=='+'){
                pair p = c(token.toCharArray());
                token = "";
                int row = p.row;
                int col = p.col;
                if(sheet[row][col].charAt(0) == '='){
                    sum = sum + Integer.parseInt(rec(row,col,sheet[row][col].substring(1)));
                }
                else {
                    sum = sum + Integer.parseInt(sheet[row][col]);
                }
            }
            else {
                token = token + c;
            }
        }
        return sheet[i][j] = String.valueOf(sum);
    }

    public static void main(String[] args) {
        int tc = fs.nextInt();
        while(tc-- > 0){
            n = fs.nextInt();
            m = fs.nextInt();
            sheet = new String[m][n];
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    sheet[i][j] = fs.next();
                }
            }
            for(int i=0;i<m;i++){
                boolean space = false;
                StringBuilder sb = new StringBuilder();
                for(int j=0;j<n;j++){
                    if(sheet[i][j].charAt(0)=='='){
                        sheet[i][j] = rec(i,j,sheet[i][j].substring(1));
                    }
                    if(space)
                        sb.append(" ");
                    space = true;
                    sb.append(sheet[i][j]);
                }
                System.out.println(sb);
            }
        }
    }
}