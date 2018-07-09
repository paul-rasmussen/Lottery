package com.dbtw.lottery;

import com.dbtw.lottery.dialog.MainFrame;

public class LotteryMain {
  public static final int LOTTO = 0;
  public static final int POWERBALL = 1;
  public static final int MEGAMILLION = 2;
  
  public static final int POWERBALL_WHITE_COUNT = 5;
  public static final int MEGAMIL_WHITE_COUNT = 5;
  
  public static final int POWERBALL_RED_MAX = 26;
  public static final int POWERBALL_WHITE_MAX = 69;
  public static final int MEGAMIL_RED_MAX = 25;
  public static final int MEGAMIL_WHITE_MAX = 70;
  
  public static final int FIRST = 0;
  public static final int SECOND = 1;
  public static final int THIRD = 2;
  public static final int FOURTH = 3;
  public static final int FIFTH = 4;
  public static final int SIXTH = 5;
  public static final int SEVENTH = 6;
  
  public static final int P = 0;
  public static final int PP = 1;
  public static final int T = 2;
  public static final int TP = 3;
  public static final int Q = 4;
  
	public static void main(String[] args) {
		MainFrame frame = new MainFrame();
		frame.setVisible(true);
	}
	
}
