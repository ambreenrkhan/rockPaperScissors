This project contains solution for 'Paper Scissors Rock' game.

This project has dependencies on lombok, junit and mockito artifacts.

To play 'Paper Scissors Rock' game, run "ConsoleGameMain.java" file.
Some notes regarding design:
Enum 'Symbol.java' contains supported weapons for this game. Each symbol has an array of beatable symbols that it can beat. An array has been used to allow more symbols to be introduced in future.
PaperScissorsRockGame.java is an implementation for 'Paper Scissors Rock' symbols, and we can have more implementations in future to support other variations of this game such as 'muk-jji-ppa', 'jak-en-poy' [https://en.wikipedia.org/wiki/Rock_paper_scissors#Variations].
Game.java supports multiple players to allow for specific implementations which support more than 2 players.

