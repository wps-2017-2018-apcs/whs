import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Tile extends JButton implements ActionListener {
  private int row;
  private int column;
  private boolean isMine;
  
  public Tile(int r, int c) {
    addActionListener(this);
    row = r;
    column = c;
  }
  
  public void actionPerformed(ActionEvent e) {
    //System.out.print(row + " " + column);
    Main.startTimer(false);
  }
  
  public int getRow() {
    return row;
  }
  
  public int getCol() {
    return column;
  } 
}
