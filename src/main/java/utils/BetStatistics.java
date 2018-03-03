package utils;

import model.CompoundBet;
import model.SimpleBet;

import java.util.List;

public class BetStatistics {

    public static Double computeSimpleProbability(List<Double> odds) {
        return odds.stream().reduce(0.0, (a, b) -> a + 1.0/b);
    }

    public static Double computeSimpleProbability2(List<Double> odds) {
        Double result = 0.0;

        for (Double odd : odds) {
            result += 1.0 / odd;
        }

        return result;
    }

    public static CompoundBet getBestBet(List<SimpleBet> bets, int numberOfOdds) {
        return getBestBet(bets, numberOfOdds, null);
    }

    public static CompoundBet getBestBet(List<SimpleBet> bets, int numberOfOdds, String excludeBettingHouse) {
        CompoundBet bestBet = new CompoundBet();

        for (int i=0; i<numberOfOdds; i++) {
            Double bestOdd = 0.0;
            String bestBettingHouse = "";
            for (SimpleBet bet : bets) {
                if (excludeBettingHouse == null || !excludeBettingHouse.equals(bet.getBettingHouse())) {
                    Double currentOdd = bet.getOdds().get(i);
                    if (currentOdd > bestOdd) {
                        bestOdd = currentOdd;
                        bestBettingHouse = bet.getBettingHouse();
                    } else if (bestOdd - currentOdd < 0.01) {
                        bestBettingHouse += "/" + bet.getBettingHouse();
                    }
                }
            }

            bestBet.addOdd(bestOdd, bestBettingHouse);
        }

        return bestBet;
    }
}
