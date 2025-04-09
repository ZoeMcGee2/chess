
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.imageio.ImageIO;

//you will need to implement two functions in this file.
public class Star extends Piece {
    private boolean color;
    private BufferedImage img;
    
    public Star(boolean isWhite, String img_file) {
      super(isWhite,img_file);  
    }
    
    @Override
    public String toString(){
      return "A " + super.toString() + "star";
    }
    
    // TO BE IMPLEMENTED!
    //return a list of every square that is "controlled" by this piece. A square is controlled
    //if the piece capture into it legally.
    @Override
    public ArrayList<Square> getControlledSquares(Square[][] board, Square start) {
      ArrayList<Square> controlled = new ArrayList<Square>();
      if(start.getCol()+2 < 8 && (!board[start.getRow()][start.getCol()+2].getOccupyingPiece().getColor())){
        controlled.add(board[start.getRow()][start.getCol()+2]);
      }
      if(start.getCol()-2 >= 0 && (!board[start.getRow()][start.getCol()-2].getOccupyingPiece().getColor())){
        controlled.add(board[start.getRow()][start.getCol()-2]);
      }
      if(start.getRow()+2 < 8 && (!board[start.getRow()+2][start.getCol()].getOccupyingPiece().getColor())){
        controlled.add(board[start.getRow()+2][start.getCol()]);
      }
      if(start.getRow()-2 >= 0 && (!board[start.getRow()-2][start.getCol()].getOccupyingPiece().getColor())){
        controlled.add(board[start.getRow()-2][start.getCol()]);
      }

      return controlled;
    }
    

    //TO BE IMPLEMENTED!
    //this piece can move 2 squares up, down, to the left, or to the right
    @Override
    public ArrayList<Square> getLegalMoves(Board b, Square start){
    	ArrayList<Square> moves = new ArrayList<Square>();
      if((b.getSquareArray()[start.getRow()][start.getCol()].getOccupyingPiece().getColor() && b.getTurn()) || (!b.getSquareArray()[start.getRow()][start.getCol()].getOccupyingPiece().getColor() && !b.getTurn())){
        if(start.getCol()+2 < 8 && (b.getSquareArray()[start.getRow()][start.getCol()+2].getOccupyingPiece()==null || b.getSquareArray()[start.getRow()][start.getCol()].getOccupyingPiece().getColor() != b.getSquareArray()[start.getRow()][start.getCol()+2].getOccupyingPiece().getColor())){
          moves.add(b.getSquareArray()[start.getRow()][start.getCol()+2]);
        }
        if(start.getCol()-2 >= 0 && (b.getSquareArray()[start.getRow()][start.getCol()-2].getOccupyingPiece()==null || b.getSquareArray()[start.getRow()][start.getCol()].getOccupyingPiece().getColor() != b.getSquareArray()[start.getRow()][start.getCol()-2].getOccupyingPiece().getColor())){
          moves.add(b.getSquareArray()[start.getRow()][start.getCol()-2]);
        }
        if(start.getRow()+2 < 8 && (b.getSquareArray()[start.getRow()+2][start.getCol()].getOccupyingPiece()==null || b.getSquareArray()[start.getRow()][start.getCol()].getOccupyingPiece().getColor() != b.getSquareArray()[start.getRow()+2][start.getCol()].getOccupyingPiece().getColor())){
          moves.add(b.getSquareArray()[start.getRow()+2][start.getCol()]);
        }
        if(start.getRow()-2 >= 0 && (b.getSquareArray()[start.getRow()-2][start.getCol()].getOccupyingPiece()==null || b.getSquareArray()[start.getRow()][start.getCol()].getOccupyingPiece().getColor() != b.getSquareArray()[start.getRow()-2][start.getCol()].getOccupyingPiece().getColor())){
          moves.add(b.getSquareArray()[start.getRow()-2][start.getCol()]);
        }
      }
      return moves;
    }
}