# Sure Bets for Soccer Matches

Calculate the Sure Bets for the upcoming soccer matches by scraping a website that show all the odds from different betting houses.

It's a very short JAVA program that does the work by: 
* Reading data from a website
* Parsing the data to extract relevant information
* Calculate the list of soccer matches with Sure Bets from the extracted information

## Technology

It's a `JAVA 8` project using `maven` and the following library for HTML parsing: `jsoup`.

About `jsoup` in their website [jsoup.org](https://jsoup.org/):


_`jsoup` is a Java library for working with real-world HTML. It provides a very convenient API for extracting and manipulating data, using the best of DOM, CSS, and jquery-like methods._

## Running

Just run the JAVA code and you will get the results in the system output.

You will first see that some processing is going on to extract the data for the next 11 days. The day and the number of soccer matches being processed is displayed.

```
Processing date: 2018-03-02	( 188 matches )
Processing date: 2018-03-03	( 801 matches )
Processing date: 2018-03-04	( 800 matches )
Processing date: 2018-03-05	( 115 matches )
Processing date: 2018-03-06	( 156 matches )
Processing date: 2018-03-07	( 227 matches )
Processing date: 2018-03-08	( 117 matches )
Processing date: 2018-03-09	( 179 matches )
Processing date: 2018-03-10	( 889 matches )
Processing date: 2018-03-11	( 722 matches )
Processing date: 2018-03-12	( 102 matches )
```

Then you will get the list of Sure Bets for the upcoming soccer matches, ordered by earnings rate descending:

```
06-03-2018 Ecuador - Serie A - Apertura   River Plate     Emelec          MARCA                     MARCA                     W.HILL                    5.25   3.75   2.15   8,43 %
04-03-2018 Italia - Serie A               Atalanta        Sampdoria       Interw.                   SPORTIUM                  bet365/MARCA/SPORTIUM     2.0    3.9    4.75   3,42 %
03-03-2018 Alemania - 2. Bundesliga       Holstein Kiel   Duisburg        Interw.                   MARCA                     bet365                    2.0    3.85   4.75   3,06 %
02-03-2018 Francia - Ligue 1              Nice            Lille           Interw.                   bet365/SPORTIUM           bet365                    1.9    3.6    6.0    3,01 %
03-03-2018 Inglaterra - Premier League    Tottenham       Huddersfield    Interw.                   bet365/888sport/SPORTIUM  SPORTIUM                  1.25   7.5    21.0   1,94 %
03-03-2018 Austria - Bundesliga           Mattersburg     Adm/Modling     Interw.                   bet365                    W.HILL                    2.1    3.75   4.2    1,94 %
02-03-2018 Finlandia - Cup Grp. B         SeinÃ¤joen JK   VPS             bet365/888sport           W.HILL                    W.HILL                    1.95   4.2    4.2    1,11 %
03-03-2018 Inglaterra - Premier League    Burnley         Everton         Interw.                   Interw.                   SPORTIUM                  2.6    3.3    3.3    0,94 %
02-03-2018 Kuwait - Premier League        Al-Kuwait       Al-Quadsia      Interw./MARCA             W.HILL                    W.HILL                    1.4    6.0    9.0    0,80 %
03-03-2018 España - Primera Division      Real Madrid     Getafe          Interw.                   bet365/W.HILL/888sport/SP MARCA                     1.25   7.5    17.0   0,79 %
08-03-2018 Internacional - Europa League  Atlético Madrid Lok. Moscow     W.HILL/888sport           Interw.                   MARCA                     1.3    6.0    17.0   0,53 %
04-03-2018 España - Primera Division      Real Sociedad   Alaves          Interw.                   bet365/SPORTIUM           bet365/MARCA              1.8    4.0    5.25   0,40 %
03-03-2018 España - Primera Division      Leganes         Málaga          bwin/MARCA/SPORTIUM       Interw.                   bet365                    2.15   3.4    4.2    0,27 %
03-03-2018 Francia - Ligue 1              Angers          Guingamp        Interw.                   W.HILL/MARCA/SPORTIUM     bwin                      2.2    3.25   4.25   0,25 %
03-03-2018 Inglaterra - Premier League    Southampton     Stoke           Interw.                   bet365/888sport           bet365                    1.85   3.75   5.25   0,23 %
03-03-2018 Alemania - 1. Bundesliga       RasenBallsport  Borussia Dortmu bwin/888sport/MARCA/SPORT bwin/SPORTIUM             Interw.                   2.55   3.6    3.05   0,22 %
03-03-2018 Alemania - 1. Bundesliga       Augsburg        Hoffenheim      MARCA                     bwin/W.HILL               Interw.                   2.7    3.4    3.0    0,22 %
04-03-2018 Dinamarca - Superligaen        Brondby         Odense          W.HILL                    MARCA                     MARCA                     1.44   5.0    9.5    0,03 %
```

The final tabulated information shows the following data on each column:
1. Day of soccer match
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
