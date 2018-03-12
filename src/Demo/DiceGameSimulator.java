package Demo;

import java.io.*;
import java.util.*;
public class DiceGameSimulator
{
/*
	Tyler A. Green
	CISC 230
	Patrick L. Jarvis
	9-13-2015

	This class recieves an integer of the amount of times that it should run DiceGame, it then stores the results such as, game win, roll count, and last roll values. These values are recorded in an array and are passed to DiceGameResult.

	Class Variables:

		diceGame
			A variable that creates a DiceGame.

		diceGameResult
			A variable that holds onto an array that will be sent over to DiceGameResult for processing.

	Constructors:

		DiceGameSimulator(DiceGame diceGame)
			Error checks creates an object of DiceGame

		DiceGameResult[times]
			Creates an object that acts like and array and holds the results of the simulations.

		Craps()
			Creats a craps object that runs the craps game.

	Methods:

		private DiceGame getDiceGame()
			An accessor for the diceGame instance variable.

		public DiceGameResult[] runSimulator(int times)
			Runs craps a certain amount of passed times and then records game win, roll count, and last roll values. Which are then passed through a DiceGameResult object.


*/
	private DiceGame diceGame;

	public DiceGameSimulator(DiceGame diceGame)
	{
		//Error checks and creates an object that acts like and array and holds the results of the simulations.
		if(diceGame == null)
		{
			throw new IllegalArgumentException("The passed DiceGame type: labeled diceGame, is null.");
		}//if
		this.diceGame = diceGame.clone();
	}//DiceGameSimulator

	private DiceGame getDiceGame()
	{
		//An accessor for the diceGame instance variable.
		return this.diceGame;
	}//getDiceGame

	public DiceGameResult[] runSimulator(int times)
	{
		//Runs craps a certain amount of passed times and then records game win, roll count, and last roll values. Which are then passed through a DiceGameResult object.
		DiceGameResult[] diceGameResult;
		diceGameResult = new DiceGameResult[times];

		for(int i=0; i<diceGameResult.length;i++)
		{
			getDiceGame().reset();
			this.diceGame = new Craps();


			while(!diceGame.gameOver())
			{
				getDiceGame().roll();
			}//while

			diceGameResult[i] = new DiceGameResult(getDiceGame().gameWon(), getDiceGame().getValues(), getDiceGame().getRollCount());

		} //forloop
		return diceGameResult;

	}//publicDiceGameResult

}//class