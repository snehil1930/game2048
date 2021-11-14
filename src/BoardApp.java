import enums.Direction;
import model.Board;
import service.Player;
import service.RandomGen;

import java.util.Scanner;

public class BoardApp {
    public static void main(String[] args){

        Board board=new Board(4);
        RandomGen randomGen=new RandomGen();
        Player player = new Player();
        board=randomGen.randomCompute(board);
        board=randomGen.randomCompute(board);
        Scanner sc =new Scanner(System.in);
        board.printMatrix();
        int f=0;
        do{
            System.out.println("your move");
            System.out.println("enter ypur direction");
            int move=sc.nextInt();
           board= player.makeMove(Direction.RIGHT,board);
           board.printMatrix();
           if (board.noFound()){
               System.out.println("congartulations");
               f=1;
               break;
           }
           if(board.isSpace()) {
               System.out.println("random matrix");
               board = randomGen.randomCompute(board);
               board.printMatrix();
           }
           else {
               break;
           }
        }while (board.isSpace());
        if(f==0)
        System.out.println("No more moves");

    }
}
