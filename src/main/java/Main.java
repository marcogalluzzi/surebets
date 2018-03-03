import model.SoccerMatch;
import parser.ElComparadorParser;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Main {

    // This number is the maximum allowed by the site elcomparador.com
    private static final int NUMBER_OF_DAYS = 11;

    public static void main(String[] args) throws IOException {

        // Generate the list of days to process: from Today up to NUMBER_OF_DAYS in the future
        List<LocalDate> dateList =
                Stream.iterate(LocalDate.now(), date -> date.plusDays(1))
                .limit(NUMBER_OF_DAYS)
                .collect(toList());

        ElComparadorParser sportsbookWebParser = new ElComparadorParser();

        // Retrieve matches from the website www.elcomparador.com
        List<SoccerMatch> allMatches = sportsbookWebParser.getMatchesInfo(dateList);

        // Filter matches: we are only interested in Sure Bets
        List<SoccerMatch> sureBetsMatches = allMatches
                .stream()
                .filter(match -> match.getBestBet().isSureBet())

                // Other examples of data filtering
                //.filter(match -> match.getBestBet().hasRiskyBet("bwin"))
                //.filter(match -> match.getBestBet("Interw.").hasRiskyBet("bwin"))
                //.filter(match -> match.getBestBet("Interw.").isSureBet())

                .collect(toList());

        // Sort by earnings rate descending
        sureBetsMatches.sort((m1, m2) -> m1.getBestBet().getSimpleProbability() < m2.getBestBet().getSimpleProbability()? -1:(m1.getBestBet().getSimpleProbability() > m2.getBestBet().getSimpleProbability() ? 1 : 0));

        // Visualization
        sureBetsMatches.forEach(match -> System.out.println(match.toTabularString()));
    }

}
