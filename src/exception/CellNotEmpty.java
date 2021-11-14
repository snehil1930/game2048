package exception;

public class CellNotEmpty extends RuntimeException {
    public CellNotEmpty(){
        super("Cell is not empty");
    }

}
