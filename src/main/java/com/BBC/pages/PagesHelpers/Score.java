package com.BBC.pages.PagesHelpers;

public class Score {
    private final int homeScore;
    private final int awayScore;

    public Score(int homeScore,int awayScore){
        this.homeScore = homeScore;
        this.awayScore = awayScore;
    }

    @Override
    public boolean equals(Object object) {
        // If the object is compared with itself then return true
        if (object == this) {
            return true;
        }

        /* Check if object is an instance of Score or not
          "null instanceof [type]" also returns false */
        if (!(object instanceof Score)) {
            return false;
        }

        // typecast object to Score so that we can compare data members
        Score score = (Score) object;

        // Compare the data members and return accordingly
        return this.homeScore == score.homeScore && this.awayScore == score.awayScore;
    }
}
