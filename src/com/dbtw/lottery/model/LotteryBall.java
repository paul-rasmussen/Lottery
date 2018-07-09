package com.dbtw.lottery.model;

import java.util.InputMismatchException;

import com.dbtw.widgets.DebugLogger;
import com.dbtw.widgets.LogFile;
import com.dbtw.widgets.UserPrefs;

/* The LotteryBall class represents any ball drawn during a lottery, for random ball lotteries.
 * 
 *  Each ball can be any number between 1 and the max value.
 * 
 */
public class LotteryBall {
  //Constants
  //Private variables
  private int value_max = 0;
  private int value = 0;
  //Public variables

  //Constructors
  public LotteryBall() throws InputMismatchException {
    init(0,0);
  }
  
  public LotteryBall(int value, int valueMax) throws InputMismatchException {
    init(value, valueMax);
  }

  public LotteryBall(int value) throws InputMismatchException {
    init(value, 0);
  }

  //Static methods
  //Public methods
  public void setValue(int val) {
    value = val;
  }
  
  public int getValue() {
    return value;
  }
  
  public void setMaxValue(int max_value) {
    value_max = max_value;
  }
  
  public int getMaxValue() {
    return value_max;
  }
  
  //Private methods
  private void init(int val, int vmax) throws InputMismatchException {
    if (value_max < vmax) {
      value_max = vmax;
    }
    if ((val <= value_max) && (val > 0)) {
      value = val;
    }
    else {
      String emsg = "Input must be between 1 and " + value_max;
      throw new InputMismatchException(emsg);
    }
  }
}
