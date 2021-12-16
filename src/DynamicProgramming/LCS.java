package DynamicProgramming;

import static DynamicProgramming.State.SKIPX;

enum State {SKIPX,SKIPY,ADDXY};
public class LCS {

    static void getLCS(char x[], char y[]){
        int m = x.length;
        int n = y.length;
        int [][]c = new int[m+1][n+1];
        State [][]b = new State[m+1][n+1];
        for(int i = 0 ; i <=m ; i++){
            c[i][0] = 0;
            b[i][0] = SKIPX;
        }
        for(int j = 0; j <= n; j++){
            c[0][j] = 0;
            b[j][0] = State.SKIPY;
        }
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(x[i-1] == y[j-1]){
                    c[i][j] = c[i-1][j-1]+1;
                    b[i][j] = State.ADDXY;
                }
                else if(c[i-1][j] >= c[i][j-1]){
                    c[i][j] = c[i-1][j];
                    b[i][j] = SKIPX;
                }
                else{
                    c[i][j] = c[i][j-1];
                    b[i][j] = State.SKIPY;
                }
            }
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                System.out.print(c[i][j]);
            }
            System.out.println();
        }
        //get LCS
        String LSC = "";
        int i = x.length;
        int j = y.length;
        while(i != 0 && j!= 0){
            switch (b[i][j])
            {
                case ADDXY:
                    LSC = LSC + x[i-1];
                    i--;
                    j--;
                    break;
                case SKIPX:
                    i--;
                    break;
                case SKIPY:
                    j--;
                    break;
                default:
                    break;
            }
        }
        System.out.println(LSC);
    }

    public static void main(String[] args) {
        char []x = {'A','T','A','T','G','G','T','C'};
        char []y = {'A','T','G','C','T','C','A','T'};
        getLCS(x,y);
    }
}
