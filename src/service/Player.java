package service;

import enums.Direction;
import model.Board;

public class Player {
    private MatrixTransform transform;
    public Board makeMove(Direction direction, Board board){
        transform=new MatrixTransform();
        board.setBoard(transform.makeMove(board.getBoard(),direction));
        return board;
    }
}
