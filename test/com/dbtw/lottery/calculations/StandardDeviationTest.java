package com.dbtw.lottery.calculations;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Vector;

import org.junit.Test;

import com.dbtw.widgets.DebugLogger;
import com.dbtw.widgets.LogFile;
import com.dbtw.widgets.UserPrefs;

public class StandardDeviationTest {
  //Constants
  private final String WHOAMI = "StandardDeviationTest";
  //Public variables
  //Protected variables
  //Private variables
  private int[] day1n = {41,48,49,53,64,20};
  private int[] day2n = {8,10,26,27,33,22};
  private int[] day3n = {3,14,18,25,45,7};
  private int[] day4n = {17,19,21,37,44,16};
  private HashMap<Date, Vector<Integer>> data = new HashMap<Date, Vector<Integer>>();
  private HashMap<Integer, Integer> counts = new HashMap<Integer, Integer>();
  //Constructors
  public StandardDeviationTest() {
    init();
  }

  //Static methods
  //Public methods
  @Test
  public void testGetCounts() {
    fail("Not yet implemented");
  }
  
  @Test
  public void testGetDeviation() {
    fail("Not yet implemented");
  }

  @Test
  public void testGetDeviations() {
    fail("Not yet implemented");
  }
  
  @Test
  public void testGetMean() {
    fail("Not yet implemented");
  }

  //Protected methods
  //Private methods
  private void init() {
    Calendar date = Calendar.getInstance();
    date.add(Calendar.DAY_OF_YEAR, -7);
    Vector<Integer> d = new Vector<Integer>();
    for (int i = 0; i < day1n.length; i++) {
      d.add(day1n[i]);
    }
    data.put(date.getTime(), d);
    date.add(Calendar.DAY_OF_YEAR, 1);
    d = new Vector<Integer>();
    for (int i = 0; i < day2n.length; i++) {
      d.add(day2n[i]);
    }
    data.put(date.getTime(), d);
    date.add(Calendar.DAY_OF_YEAR, 1);
    for (int i = 0; i < day3n.length; i++) {
      d.add(day3n[i]);
    }
    data.put(date.getTime(), d);
    date.add(Calendar.DAY_OF_YEAR, 1);
    for (int i = 0; i < day4n.length; i++) {
      d.add(day4n[i]);
    }
    data.put(date.getTime(), d);
    counts.put(3, 1);
    counts.put(7, 1);
    counts.put(8, 1);
    counts.put(10, 1);
    counts.put(14, 1);
    counts.put(16, 1);
    counts.put(17, 1);
    counts.put(18, 1);
    counts.put(19, 1);
    counts.put(20, 1);
    counts.put(21, 1);
    counts.put(22, 1);
    counts.put(25, 1);
    counts.put(26, 1);
    counts.put(27, 1);
    counts.put(33, 1);
    counts.put(37, 1);
    counts.put(41, 1);
    counts.put(44, 1);
    counts.put(45, 1);
    counts.put(48, 1);
    counts.put(49, 1);
    counts.put(53, 1);
    counts.put(64, 1);
  }

}
