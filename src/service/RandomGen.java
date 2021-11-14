package service;

import model.Board;
import model.Cell;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

public class RandomGen {
    private final SecureRandom secureRandom=new SecureRandom();
    public Board randomCompute(Board board){
        List<Integer> value=new ArrayList<>();
        value.add(2);
        value.add(4);
        int randVal=value.get(secureRandom.nextInt(value.size()));
        List<Cell> emptyCell=board.emptyCell();
        Cell randCell=emptyCell.get(secureRandom.nextInt(emptyCell.size()));
        return board.placeNumber(randCell,randVal);
    }
}
