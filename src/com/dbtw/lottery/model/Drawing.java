package com.dbtw.lottery.model;

import java.util.Date;

import com.dbtw.widgets.DebugLogger;
import com.dbtw.widgets.LogFile;
import com.dbtw.widgets.UserPrefs;

/* The Drawing interface must be implemented by any class representing a lottery game drawing.
 * 
 */
public interface Drawing {
  public void setDate(Date date);
  public void setNumber(int position, int value);
  public void setGameType(int game);
  public Date getDate();
  public int getNumber(int position);
  public int getGame();
}