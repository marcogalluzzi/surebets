package model;

import utils.BetStatistics;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SimpleBet {
    private List<Double> odds;
    private String bettingHouse;
    private Double simpleProbability;

    public SimpleBet() {
        this.odds = new ArrayList<>();
        this.bettingHouse = "";

        this.simpleProbability = null;
    }

    public void addOdd(Double odd) {
        this.odds.add(odd);

        this.simpleProbability = BetStatistics.computeSimpleProbability(this.odds);
    }

    public SimpleBet(List<Double> odds, String bettingHouse) {
        this.odds = odds;
        this.bettingHouse = bettingHouse;

        this.simpleProbability = BetStatistics.computeSimpleProbability(odds);
    }

    public List<Double> getOdds() {
        return odds;
    }

    public void setOdds(List<Double> odds) {
        this.odds = odds;
    }

    public String getBettingHouse() {
        return bettingHouse;
    }

    public void setBettingHouse(String bettingHouse) {
        this.bettingHouse = bettingHouse;
    }

    public Double getSimpleProbability() {
        return simpleProbability;
    }

    public void setSimpleProbability(Double simpleProbability) {
        this.simpleProbability = simpleProbability;
    }

    @Override
    public String toString() {
        String oddsString = String.join(", ", odds.stream().map(Object::toString).collect(Collectors.toList()));

        return "{bettingHouse: "+bettingHouse+", odds: {"+oddsString+"}, simpleProb: "+simpleProbability;
    }
}
