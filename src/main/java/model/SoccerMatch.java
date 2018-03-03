package model;

import utils.BetStatistics;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class SoccerMatch {
    private final static int NUMBER_OF_ODDS = 3;

    private LocalDate date;
    private String team1;
    private String team2;
    private String league;

    private List<SimpleBet> bets;
    private CompoundBet bestBet;

    public SoccerMatch(LocalDate date, String team1, String team2, String league) {
        this.date = date;
        this.team1 = team1;
        this.team2 = team2;
        this.league = league;
        bets = new ArrayList<>();
        bestBet = null;
    }

    public void addBet(SimpleBet bet) {
        bets.add(bet);
    }

    public List<SimpleBet> getBets() {
        return bets;
    }

    public CompoundBet getBestBet() {
        return getBestBet(null);
    }

    private CompoundBet getBestBet(String excludeBettingHouse) {
        if (bestBet == null) {
            bestBet = BetStatistics.getBestBet(this.bets, NUMBER_OF_ODDS, excludeBettingHouse);
        }
        return bestBet;
    }

    public String toTabularString() {
        return toTabularString(" ");
    }

    private String toTabularString(String separator) {
        StringBuffer line = new StringBuffer();
        line.append(date.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
        line.append(separator);
        line.append(String.format("%-30.30s",this.league.replace("Fútbol - ","")));
        line.append(separator);
        line.append(String.format("%-15.15s",this.team1));
        line.append(separator);
        line.append(String.format("%-15.15s",this.team2));
        line.append(separator);

        line.append(getBestBet().toTabularString());

        return line.toString();
    }

    @Override
    public String toString() {
        return "Day '"+this.date+"', League '"+this.league+"', match '"+this.team1+"' VS '"+this.team2+"'";
    }
}
