package parser;

import model.SimpleBet;
import model.SoccerMatch;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ElComparadorParser extends SportsbookWebParser {

    private final DateTimeFormatter URL_DATE_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public ElComparadorParser() {
        bettingHouses = new String[]{"bet365", "bwin", "W.HILL", "Interw.", "888sport", "MARCA", "SPORTIUM", "betfair"};
        baseURL = "http://www.elcomparador.com/html/contenido/mas_partidos.php?deporte=1&fecha=%s&offset=%d";
    }

    @Override
    public List<SoccerMatch> getMatchesInfo(List<LocalDate> dateList) {

        ArrayList<SoccerMatch> allMatches = new ArrayList<SoccerMatch>();

        for (LocalDate date : dateList) {

            System.out.print("Processing date: "+date.format(URL_DATE_FORMAT));

            // Initialization
            int pageOffset = 0;
            int matchesProcessed = 0;
            int totalMatchesProcessed = 0;

            // Each page for a specific day at www.elcomparador.com needs more loads because of pagination
            while (pageOffset == 0 || matchesProcessed == 30) {

                String url = String.format(this.baseURL, date.format(URL_DATE_FORMAT), pageOffset);

                // Initialization
                matchesProcessed = 0;

                try {
                    Document doc = Jsoup.connect(url).get();

                    List<SoccerMatch> matches = parseHTMLDocument(doc, date);

                    matchesProcessed = matches.size();
                    allMatches.addAll(matches);
                }
                catch(IOException exception) {
                    System.out.println("There was an error processing URL <" + url + ">:" + exception.getMessage());
                }

                totalMatchesProcessed += matchesProcessed;
                pageOffset += 30;
            }

            System.out.println("\t( "+totalMatchesProcessed+" matches )");
        }

        return allMatches;
    }

    private List<SoccerMatch> parseHTMLDocument(Document document, LocalDate date) {
        Elements contents = document.select("div#separador.futbol,div#contenedor_evento.borde_inferior");

        ArrayList<SoccerMatch> matches = new ArrayList<>();
        String league = "";

        for (Element content : contents) {

            if (content.id().equals("separador")) {
                league = content.selectFirst("span.titulo_comp").text();
            }
            else { // content.id().equals("contenedor_evento")
                Elements equipos = content.select("span.equipo");

                SoccerMatch match = new SoccerMatch(
                        date,
                        equipos.get(0).text(),
                        equipos.get(1).text(),
                        league
                );

                Elements filasCuotas = content.select("div#contenedor_cuotas").select("div#fila_cuotas");

                SimpleBet[] simpleBets = new SimpleBet[7];

                for (int i = 0; i < simpleBets.length; i++) {
                    simpleBets[i] = new SimpleBet();
                    simpleBets[i].setBettingHouse(this.bettingHouses[i]);
                }

                for (int i = 0; i < 3; i++) {
                    String cellClass = ((i & 1) == 0) ? ".impar" : ".par";
                    Elements filaCuotas = filasCuotas.get(i).select("div#celda_cuotas" + cellClass);

                    for (int j = 0; j < 7; j++) {
                        Element cuotaElement = filaCuotas.get(j).selectFirst("a");

                        simpleBets[j].addOdd((cuotaElement == null) ? 0.0 : Double.parseDouble(cuotaElement.text()));
                    }
                }

                Arrays.stream(simpleBets).forEach(match::addBet);

                matches.add(match);
            }
        }

        return matches;
    }
}
