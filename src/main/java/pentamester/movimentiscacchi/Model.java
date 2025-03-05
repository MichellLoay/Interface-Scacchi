
package pentamester.movimentiscacchi;

import java.util.ArrayList;
import java.util.List;

public class Model {

    private final String[] piecesName = {"King", "Queen", "Rook", "Bishop", "Knight", "Pawn"};
    private final int col = 3;
    private IModelObserver observer;

    public void setObserver(IModelObserver observer) {
        this.observer = observer;
        observer.initialize(piecesName);
    }

    public void setPiece(int piece) {
        List<Coord> list = new ArrayList<>();
        int row = 3;
        if (piece == 5) {
            row = 6;
        }
        switch (piece) {
            case 0 -> {
                king(list, row);
            }
            case 1 -> {
                rook(list,row);
                bishop(list,row);
            }
            case 2 -> {
                rook(list, row);
            }
            case 3 -> {
                bishop(list, row);
            }
            case 4 -> {
                knight(list, row);
            }
            case 5 -> {
                // pawn
                list.add(new Coord(row - 1, col));
                list.add(new Coord(row -2, col));
            }
        }
        observer.setCells(list, piecesName[piece],row, col);
    }

    private void knight(List<Coord> list, int row) {
        // Knight == caballo
        list.add(new Coord(row - 2, col + 1));
        list.add(new Coord(row - 2, col - 1));
        list.add(new Coord(row + 2, col + 1));
        list.add(new Coord(row + 2, col - 1));
        
        list.add(new Coord(row - 1, col + 2));
        list.add(new Coord(row - 1, col - 2));
        list.add(new Coord(row + 1, col + 2));
        list.add(new Coord(row + 1, col - 2));
    }

    private void king(List<Coord> list, int row) {
        // king
        list.add(new Coord(row - 1, col));
        list.add(new Coord(row + 1, col));
        list.add(new Coord(row, col - 1));
        list.add(new Coord(row, col + 1));
        list.add(new Coord(row - 1, col + 1));
        list.add(new Coord(row + 1, col + 1));
        list.add(new Coord(row + 1, col - 1));
        list.add(new Coord(row - 1, col - 1));
    }

    private void bishop(List<Coord> list, int row) {
        // bishop
        int i;
        for (i = 0; i < 8; i++) {
            list.add(new Coord(i,i));
        }
        for (i = 0; i < 7; i++) {
            list.add(new Coord(i,7-i-1));
            
        }
        list.remove(new Coord(row, col));
        list.remove(new Coord(row, col));
    }

    private void rook(List<Coord> list, int row) {
        // roock == torre
        for (int i = 0; i < 8; i++) {
            list.add(new Coord(row, i));
            list.add(new Coord(i, col));
            
        }
        list.remove(new Coord(row, col));
        list.remove(new Coord(row, col));
    }
}
