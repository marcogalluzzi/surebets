# Sure Bets for Soccer Matches

Calculate the Sure Bets for the upcoming soccer matches by scraping a website that show all the odds from different betting houses.

It's a very short JAVA program that does the work by: 
* Reading data from a website
* Parsing the data to extract relevant information
* Calculate the list of soccer matches with Sure Bets from the extracted information

**WARNING!** Be careful executing this program, it's scraping a website and programming repeated executions could affect the target website performance.

## Technology

It's a `JAVA 8` project using `maven` and the following library for HTML parsing: `jsoup`.

About `jsoup` in their website [jsoup.org](https://jsoup.org/):


_`jsoup` is a Java library for working with real-world HTML. It provides a very convenient API for extracting and manipulating data, using the best of DOM, CSS, and jquery-like methods._

## Running

Just run the JAVA code and you will get the results in the system output.

You will first see that some processing is going on to extract the data for the next 11 days. The day and the number of soccer matches being processed is displayed.

```
Processing date: 2018-03-05	( 71 matches )
Processing date: 2018-03-06	( 167 matches )
Processing date: 2018-03-07	( 230 matches )
Processing date: 2018-03-08	( 125 matches )
Processing date: 2018-03-09	( 186 matches )
Processing date: 2018-03-10	( 884 matches )
Processing date: 2018-03-11	( 762 matches )
Processing date: 2018-03-12	( 109 matches )
Processing date: 2018-03-13	( 115 matches )
Processing date: 2018-03-14	( 224 matches )
Processing date: 2018-03-15	( 46 matches )
```

Then you will get the list of Sure Bets for the upcoming soccer matches, ordered by earnings rate descending:

```
11-03-2018 Dinamarca - 1. Division        Esbjerg         Fredericia      888sport                  888sport                  MARCA                     3.65   3.4    4.2    24,04 %
11-03-2018 Italia - Serie A               Bologna         Atalanta        bet365/W.HILL/888sport    Interw./betfair           Interw.                   4.0    3.3    2.3    1,23 %
10-03-2018 Inglaterra - League 2          Coventry        Barnet          W.HILL                    bwin                      bwin                      2.0    3.6    4.75   1,18 %
05-03-2018 Argentina - Superliga          San Martin San  Independiente   bet365                    MARCA/betfair             888sport                  4.5    3.25   2.17   0,93 %
06-03-2018 Inglaterra - Championship      Ful Ham         Sheffield Unite betfair                   betfair                   bet365                    1.95   3.9    4.5    0,86 %
05-03-2018 Inglaterra - Premier League    Crystal Palace  Manchester Unit betfair                   bet365/888sport/MARCA/bet Interw.                   8.0    4.5    1.55   0,77 %
08-03-2018 Internacional - Europa League  Atlético Madrid Lok. Moscow     888sport                  Interw.                   MARCA                     1.3    6.0    17.0   0,53 %
11-03-2018 Alemania - 2. Bundesliga       Union Berlin    Aue             Interw.                   MARCA                     bet365                    1.8    3.75   5.75   0,39 %
06-03-2018 Inglaterra - Championship      Hull            Millwall        betfair                   betfair                   bet365                    2.5    3.4    3.29   0,19 %
06-03-2018 Internacional - Champions Leag Paris Saint Ger Real Madrid     Interw./betfair           bet365                    betfair                   2.1    4.2    3.5    0,00 %
06-03-2018 Inglaterra - Championship      Birmingham      Middlesbrough   bet365                    bet365/bwin               betfair                   4.2    3.5    2.1    0,00 %
```

The final tabulated information shows the following data on each column:
1. Day of soccer match, with format "dd-MM-yyyy"
2. League or tournament
3. First soccer team
4. Second soccer team
5. Betting house/s with best odd for result _first team wins (1)_
6. Betting house/s with best odd for result _tie (X)_
7. Betting house/s with best odd for result _second team wins (2)_
8. Odd value for result _first team wins (1)_
9. Odd value for result _tie (X)_
10. Odd value for result _second team wins (2)_
11. Earnings rate

### Future work

* Add tests
* Use persistent storage

## Author

* **Marco Galluzzi** - [marcogalluzzi](https://github.com/marcogalluzzi)
