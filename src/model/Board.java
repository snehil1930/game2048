package model;

import exception.CellNotEmpty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Board {
    private int board[][];
    private int score;

    public Board(int size) {
        this.board = new int [size][];
        this.score = 0;
        for(int i=0;i<size;i++){
            board[i]=new int[size];
            for(int j=0;j<size;j++){
                board[i][j]=0;
            }
        }
    }

    public  Board(int [][] board,int score){
        this.board=new int [board.length][];
        this.score=0;
        for(int i=0;i<board.length;i++){
            this.board[i]= Arrays.copyOf(board[i],board[i].length);
        }
    }
    public int[][] getBoard() {
        return board;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setBoard(int[][] board) {
        this.board = board;
    }

    public int getScore() {
        return score;
    }
    public int  getCell(final Cell cell){
        return board[cell.getX()][cell.getX()];
    }
    public boolean isEmpty(final Cell cell){
        return getCell(cell)==0;
    }
    public List<Cell> emptyCell(){
        List<Cell> cellList= new ArrayList<>();
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                if(getCell(new Cell(i,j))==0){
                    cellList.add(new Cell(i,j));
                }
            }
        }
        return cellList;
    }
    public Board placeNumber(Cell cell, int number){
        if(!isEmpty(cell)){
            throw new CellNotEmpty();
        }
        Board newBoard=new Board(this.board,this.score);
        newBoard.board[cell.getX()][cell.getY()]=number;
        return newBoard;
    }

    public boolean isSpace(){
        if(emptyCell().size()==0)
            return false;
        else
            return true;
    }
    public boolean noFound(){
        for (int i=0;i<board.length;i++){
            for (int j=0;j<board[i].length;j++){
                if(board[i][j]==2048) {
                    return true;
                }
            }
        }
        return false;
    }
    public void printMatrix(){
        for(int i=0;i<board.length;i++){
            System.out.println();
            for(int j=0;j<board[i].length;j++){
                if (board[i][j]==0)
                    System.out.print("- ");
                else
                    System.out.print(board[i][j]+" ");
            }
        }
    }
}
