package com.dbtw.lottery.model;

import java.util.Date;
import java.util.LinkedList;

import com.dbtw.lottery.LotteryMain;
import com.dbtw.widgets.DebugLogger;
import com.dbtw.widgets.LogFile;
import com.dbtw.widgets.UserPrefs;

/* The LotteryDrawing class represents a random ball drawing type of lottery drawing.
 * 
 * The class is used to represent drawings for a number of games. As the number of balls,
 * and their max values do seem to change over time, it was decided to NOT subclass the
 * game drawings and instead make the limits attributes.
 * 
 * The constants used are defined in the Main class, though this is expected to change.
 */
public class LotteryDrawing implements Drawing {
  //Constants
  //Private variables
  private int game = 0;
  private int maxValue = 0;
  private int maxRed = 0;
  private int maxPositions = 0;
  private Date drawing;
  private LinkedList<Integer> balls;
  private int redBall;
  //Public variables

  //Constructors
  public LotteryDrawing(int game, Date drawingDate, int[] balls, int redball) {
    init(game, drawingDate, balls, redball);
  }

  //Static methods
  //Public methods
  @Override
  public void setDate(Date date) {
    // TODO Auto-generated method stub

  }

  @Override
  public void setNumber(int position, int value) {
    balls.set(position, value);
  }

  @Override
  public void setGameType(int game) {
    this.game = game;
  }

  @Override
  public Date getDate() {
    return drawing;
  }

  @Override
  public int getNumber(int position) {
    return balls.get(position).intValue();
  }

  @Override
  public int getGame() {
    return game;
  }

  //Private methods
  private void init(int game, Date drawingDate, int[] balls, int redball) {
    this.game = game;
    switch (game) {
      case (LotteryMain.POWERBALL) : {
        maxValue = LotteryMain.POWERBALL_WHITE_MAX;
        maxRed = LotteryMain.POWERBALL_RED_MAX;
        maxPositions = LotteryMain.POWERBALL_WHITE_COUNT;
        break;
      }
      case (LotteryMain.MEGAMILLION) : {
        maxValue = LotteryMain.MEGAMIL_WHITE_MAX;
        maxRed = LotteryMain.MEGAMIL_RED_MAX;
        maxPositions = LotteryMain.MEGAMIL_WHITE_COUNT;
        break;
      }
    }      
    drawing = drawingDate;
    addRedBall(redball);
    redBall = redball;
    for (int i = 0; i < balls.length; i++) {
      this.balls.add(new Integer(balls[i]));
    }
    this.balls.sort(null);
  }

  private void addRedBall(int value) {
    if ((value > 0) && (value <= maxRed)) {
      redBall = value;
    }
  }
  
  private void addWhiteBall(int value) {
    if ((value > 0) && (value <= maxValue)) {
      if (balls.size() <= maxPositions) {
        balls.add(new Integer(value));
      }
    }
  }
  
}
