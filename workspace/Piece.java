
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
public class Piece {
    private final boolean color;
    private BufferedImage img;
    
    public Piece(boolean isWhite, String img_file) {
        this.color = isWhite;
        
        try {
            if (this.img == null) {
              this.img = ImageIO.read(getClass().getResource(img_file));
            }
          } catch (IOException e) {
            System.out.println("File not found: " + e.getMessage());
          }
    }
    
    

    
    public boolean getColor() {
        return color;
    }
    
    public Image getImage() {
        return img;
    }
    
    public void draw(Graphics g, Square currentSquare) {
        int x = currentSquare.getX();
        int y = currentSquare.getY();
        
        g.drawImage(this.img, x, y, null);
    }
    
    
    // TO BE IMPLEMENTED!
    //return a list of every square that is "controlled" by this piece. A square is controlled
    //if the piece capture into it legally.
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
    public ArrayList<Square> getLegalMoves(Board b, Square start){
    	ArrayList<Square> moves = new ArrayList<Square>();
      if(start.getCol()+2 < 8 && (b.getSquareArray()[start.getRow()][start.getCol()+2].getOccupyingPiece()==null || !b.getSquareArray()[start.getRow()][start.getCol()+2].getOccupyingPiece().getColor())){
        moves.add(b.getSquareArray()[start.getRow()][start.getCol()+2]);
      }
      if(start.getCol()-2 >= 0 && (b.getSquareArray()[start.getRow()][start.getCol()-2].getOccupyingPiece()==null || !b.getSquareArray()[start.getRow()][start.getCol()-2].getOccupyingPiece().getColor())){
        moves.add(b.getSquareArray()[start.getRow()][start.getCol()-2]);
      }
      if(start.getRow()+2 < 8 && (b.getSquareArray()[start.getRow()+2][start.getCol()].getOccupyingPiece()==null || !b.getSquareArray()[start.getRow()+2][start.getCol()].getOccupyingPiece().getColor())){
        moves.add(b.getSquareArray()[start.getRow()+2][start.getCol()]);
      }
      if(start.getRow()-2 >= 0 && (b.getSquareArray()[start.getRow()-2][start.getCol()].getOccupyingPiece()==null || !b.getSquareArray()[start.getRow()-2][start.getCol()].getOccupyingPiece().getColor())){
        moves.add(b.getSquareArray()[start.getRow()-2][start.getCol()]);
      }
      return moves;
    }
}