package parser;

import model.SoccerMatch;

import java.time.LocalDate;
import java.util.List;

abstract class SportsbookWebParser {
    protected String[] bettingHouses = null;
    protected String baseURL = null;

    abstract public List<SoccerMatch> getMatchesInfo(List<LocalDate> dateList);
}
