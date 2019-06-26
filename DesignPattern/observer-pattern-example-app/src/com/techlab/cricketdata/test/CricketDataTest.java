package com.techlab.cricketdata.test;

import com.techlab.cricketdata.CricketData;
import com.techlab.score.display.AverageScoreDisplay;
import com.techlab.score.display.CurrentScoreDisplay;

public class CricketDataTest {
    public static void main(String args[]) 
    { 
        AverageScoreDisplay averageScoreDisplay = 
                                       new AverageScoreDisplay(); 
        CurrentScoreDisplay currentScoreDisplay = 
                                       new CurrentScoreDisplay(); 
  
        CricketData cricketData = new CricketData(currentScoreDisplay, 
                                                  averageScoreDisplay); 
  
        cricketData.dataChanged(); 
    } 
}
