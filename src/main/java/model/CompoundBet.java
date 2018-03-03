package model;

import utils.BetStatistics;

import java.util.ArrayList;
import java.util.List;

public class CompoundBet {
    private List<Double> odds;
    private List<String> bettingHouses;
    private Double simpleProbability;

    public CompoundBet() {
        this.odds = new ArrayList<>();
        this.bettingHouses = new ArrayList<>();
        this.simpleProbability = null;
    }

    public void addOdd(Double odd, String betttingHouse) {
        this.odds.add(odd);
        this.bettingHouses.add(betttingHouse);
        this.simpleProbability = BetStatistics.computeSimpleProbability(this.odds);
    }

    public CompoundBet(List<Double> odds, List<String> bettingHouses) {
        this.odds = odds;
        this.bettingHouses = bettingHouses;
        this.simpleProbability = BetStatistics.computeSimpleProbability(this.odds);
    }

    public Double getSimpleProbability() {
        return simpleProbability;
    }


    public Boolean isSureBet() {
        return simpleProbability < 1.0;
    }

    public Boolean hasRiskyBet(String betttingHouse) {
        Double[] oddsArray = new Double[odds.size()];
        oddsArray = odds.toArray(oddsArray);

        String[] bettingHousesArray = new String[bettingHouses.size()];
        bettingHousesArray = bettingHouses.toArray(bettingHousesArray);

        for (int i=0; i<oddsArray.length; i++) {
            if (oddsArray[i] >= 1.7 && bettingHousesArray[i].equals(betttingHouse))
                return true;
        }
        return false;
    }

    private Double getProfit() {
        return ((1.0/simpleProbability)-1.0)*100;
    }

    public String toTabularString() {
        return toTabularString(" ");
    }

    private String toTabularString(String separator) {
        StringBuffer line = new StringBuffer();

        for (String bettingHouse : bettingHouses) {
            line.append(String.format("%-25.25s", bettingHouse));
            line.append(separator);
        }

        for (Double odd : odds) {
            line.append(String.format("%-6s", odd));
            line.append(separator);
        }

        line.append(String.format("%.2f %%", getProfit()));

        return line.toString();

    }

    @Override
    public String toString() {
        String oddsString = "";

        for (int i=0; i<odds.size()-1; i++) {
            oddsString += "{bettingHouse: "+bettingHouses.get(i)+", odd: "+odds.get(i)+"},";
        }
        oddsString += "{bettingHouse: "+bettingHouses.get(odds.size()-1)+", odd: "+odds.get(odds.size()-1)+"}";

        return "{odds: {"+oddsString+"}, profit: "+String.format("%.2f", getProfit())+" %}";
    }

}
