package com.techlab.cricketdata;

import com.techlab.score.display.AverageScoreDisplay;
import com.techlab.score.display.CurrentScoreDisplay;

public class CricketData {

    int runs, wickets; 
    float overs; 
    CurrentScoreDisplay currentScoreDisplay; 
    AverageScoreDisplay averageScoreDisplay; 
  
    public CricketData(CurrentScoreDisplay currentScoreDisplay, 
                       AverageScoreDisplay averageScoreDisplay) 
    { 
        this.currentScoreDisplay = currentScoreDisplay; 
        this.averageScoreDisplay = averageScoreDisplay; 
    } 
    private int getLatestRuns() 
    { 
        return 90; 
    } 
  
    private int getLatestWickets() 
    {  
        return 2; 
    } 
 
    private float getLatestOvers() 
    {  
        return 10.2f; 
    } 
  
    public void dataChanged() 
    { 
        runs = getLatestRuns(); 
        wickets = getLatestWickets(); 
        overs = getLatestOvers(); 
  
        currentScoreDisplay.update(runs,wickets,overs); 
        averageScoreDisplay.update(runs,wickets,overs); 
    } 
}
