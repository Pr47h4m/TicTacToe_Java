import java.util.Scanner;
public class TicTacToe {
        public static char matrix[][]=new char[3][3];
        public static char player;
        public static boolean flag;
        public static boolean checkWin(){
            for(int i = 0;i<3;++i){
                    if(matrix[i][0] == matrix[i][1]&&matrix[i][1] == matrix[i][2]&&(matrix[i][0]=='X'||matrix[i][0]=='O')){
                        player = matrix[i][0];
                        return true;
                    }
            }
            for(int j = 0;j<3;++j){
                    if(matrix[0][j] == matrix[1][j]&&matrix[1][j] == matrix[2][j]&&(matrix[0][j]=='X'||matrix[0][j]=='O')){
                        player = matrix[0][j];
                        return true;
                    }
            }
            if(matrix[0][0] == matrix[1][1]&& matrix[1][1] == matrix[2][2]&&(matrix[1][1]=='X'||matrix[1][1]=='O')){
                player = matrix[0][0];
                return true;
            }else if(matrix[0][2] == matrix[1][1]&& matrix[1][1] == matrix[2][0]&&(matrix[1][1]=='X'||matrix[1][1]=='O')){
                player = matrix[0][2];
                return true;
            }else{
                return false;
            }
        }
        public static boolean checkMove(int i,int j){
            if(matrix[i][j] == ' '){
                return true;
            }else
            return false;
        }
        public static void initialize(){
            for(int i=0;i<3;++i){
                for(int j=0;j<3;++j){
                    matrix[i][j] = ' ';
                }
            }
        }
        public static void showMap(){
            System.out.println("(1,1) (1,2) (1,3)\n(2,1) (2,2) (2,3)\n(3,1) (3,2) (3,3)\n");
        }
        public static void makeMove(int i,int j){
            matrix[i][j] = 'X';
        }
        public static void makeComputerMove(){
            for(int x =0;x<3;++x){
                for(int y =0 ;y<3;++y){
                    if(matrix[x][y]==' '){
                        matrix[x][y] = 'O';
                        flag = true;
                        break;
                    }
                }
                if(flag){
                        break;
                }
            }
            flag = false;
        }    
        public static void repaint(){
            for(int i = 0; i<3;++i){
                for(int j = 0;j<3;++j){
                    System.out.print(matrix[i][j]+" ");
                }
                System.out.print("\n");
            }
        }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        
        System.out.println("Welcome to Tic-Tac-Toe Game");
        initialize();
        System.out.println("Coordinates System:");
        showMap();
        do{
            if(!(checkWin())){
                System.out.println("Enter Coordinates of Your Move: ");
                int i,j;
                i = s.nextInt();
                j = s.nextInt();
                --i;
                --j;
                if(checkMove(i,j)){
                    makeMove(i,j);
                    if(checkWin()){
                        repaint();
                        break;
                    }
                    makeComputerMove();
                    repaint();
                }else{
                    
                    System.out.println("Invalid Move");
                }
            }else{
                break;
            }
        }while(true);
        if(player == 'X'){
            System.out.println("YOU Win!!!");
            System.exit(0);
        }else{
            System.out.println("Computer Wins!!!");
            System.exit(0);
        }
    }    
}
