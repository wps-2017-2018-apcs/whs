import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StopWatch {
  
  private boolean isRunning;
  private long startTime;
 
  public StopWatch() {
    isRunning = false; 
  }
  
  public void startStopWatch()
  {
    isRunning = true;
    startTime = System.currentTimeMillis();
  }

  public void stopStopWatch()
  {
    isRunning = false;
    startTime = System.currentTimeMillis();
  }

  public double getElapsedTime()
  {
    long result = 0;
    if (isRunning)
    {
      result = System.currentTimeMillis() - startTime;
    }
    
    return result / 1000.0;
  }
  
  public boolean isStopWatchRunning()
  {
    return isRunning;
  }
  
  public String getFormattedElapsedTime()
  {
    String result = "00:00";
    if (isRunning)
    {
      double elapsedTime = System.currentTimeMillis() - startTime;
      int seconds = (int)(elapsedTime / 1000.0);
      int minutes = (int)(seconds / 60);
      seconds -= minutes * 60;
      //result = minutes + ":" + seconds;
      result = String.format("%02d:%02d", minutes, seconds);
    }
    
    return result;
  }
}
