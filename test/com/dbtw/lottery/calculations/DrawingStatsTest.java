package com.dbtw.lottery.calculations;

import static org.junit.Assert.*;

import java.util.Vector;

import org.junit.Test;

import com.dbtw.widgets.DebugLogger;
import com.dbtw.widgets.LogFile;
import com.dbtw.widgets.UserPrefs;

public class DrawingStatsTest {
  //Constants
  //Public variables
  //Protected variables
  //Private variables
  private int[] testData = {9,15,23,24,35,49,52};
  private int[] testData2 = {9,15,23,24,35,49,52,60};
  private Vector<Integer> testSet = new Vector<Integer>();
  //Constructors
  public DrawingStatsTest() {
    for (int i = 0; i < testData.length; i++) {
      testSet.add(testData[i]);
    }
  }

  //Static methods
  //Public methods
  @Test
  public void testVectorLoad() {
    DrawingStats ds = new DrawingStats(testSet);
    assertEquals("Faile", testSet, ds.getDataSet());
  }
  
  @Test
  public void testArrayLoad() {
    DrawingStats ds = new DrawingStats(testData);
    assertEquals("Faile", testSet, ds.getDataSet());
  }
    
  @Test
  public void testGetMean() {
    DrawingStats ds = new DrawingStats(testData);
    assertEquals(29.57, ds.getMean(), 0.01);
  }

  @Test
  public void testGetOddMedian() {
    DrawingStats ds = new DrawingStats(testData);
    assertEquals("Fail!",new Double(24) ,new Double(ds.getMedian()));
  }

  @Test
  public void testGetEvenMedian() {
    DrawingStats ds = new DrawingStats(testData2);
    assertEquals("Fail!",new Double(29.5) ,new Double(ds.getMedian()));
  }

  @Test
  public void testGetRange() {
    DrawingStats ds = new DrawingStats(testData);
    assertEquals("Fail!",43 ,ds.getRange());
  }
  //Protected methods
  //Private methods
}
