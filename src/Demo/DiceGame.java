package Demo;

import java.io.*;
import java.util.*;
abstract public class DiceGame implements Cloneable
{
/*
	Tyler A. Green
	CISC 230
	Patrick L. Jarvis
	9-13-2015

	This class is coneable and implements the rules of the games extended to it. it rolls dice, and gets the overall and individual values of the dice and determines when the game is over.

	Variables:

		dice
			An instance variable that is an object of Dice.

		rollCount
			An instance variable that holds onto the number of times dice are rolled.

	Constructors:

		DiceGame(numberOfDies)
			Error checks and initializes rollCount to zero and dice to Dice(numberOfDies).

	Methods:

		private Dice getDice()
			An accessor for the instance variable dice.

		public void roll()
			Rolls the dice in Dice and adds one to rollCount.

		public int getValue(int whichOne)
			Grabs the exact value of a specific(whichOne) die.

		public int[] getValues()
			Creates an array of all the rolled die values.

		public int getValue()
			Gets the sum of all the die rolled.

		public int getRollCount()
			Accessor for the instance variable rollCount.

		public void reset()
			resets rollCount back to zero.

		public DiceGame clone()
			This method tries to clone DiceGame, if caught, a state error is thrown.

		public boolean gameOver()
			Determines if the game is over.

		abstract public boolean gameWon()
			Abstract that is subclasses to game classes

		abstract public boolean gameLost()
			Abstract that is subclasses to game classes

*/
	private Dice dice;

	private int rollCount;

	private ArrayList<int[]> rollHistory;

	public DiceGame(int numberOfDies)
	{
		//Error checks and initializes rollCount to zero and dice to Dice(numberOfDies).
		if(numberOfDies < 1)
		{
			throw new IllegalArgumentException("the number passed was " + numberOfDies + ", which is less than 1");
		}//if
		this.rollCount = 0;
		this.dice = new Dice(numberOfDies);
		this.rollHistory = new ArrayList<int[]>();
	}//public DiceGame

	public int[][] getRollHistory()
	{
		//vector list is put into a new array, the new array values were mutable, so a deep clone of the array list is made.
		int[][] x;

		x = this.rollHistory.toArray(new int[0][]);

		for(int i=0; i<x.length;i++)
		{
			x[i] = x[i].clone();
		}//for

		return x;
	}//public getRollHistory

	private Dice getDice()
	{
		//An accessor for the instance variable dice.
		return this.dice;
	}//private getDice

	public void roll()
	{
		//Rolls the dice in Dice and adds one to rollCount.
		this.getDice().roll();
		this.rollCount = getRollCount() + 1;
		this.rollHistory.add(this.getValues());
	}//public rollDice

	public int getValue(int whichOne)
	{
		//Grabs the exact value of a specific(whichOne) die.
		return this.dice.getValue(whichOne);
	}//public getValue

	public int[] getValues()
	{
		//Creates an array of all the rolled die values.
		return this.dice.getValues();
	}//public getValues

	public int getValue()
	{
		//Gets the sum of all the die rolled.
		return this.dice.getValue();
	}//public getValue

	public int getRollCount()
	{
		//Accessor for the instance variable rollCount.
		return  this.rollCount;
	}//public getRollCount

	public void reset()
	{
		//resets rollCount back to zero.
		this.rollCount =  0;
	}//public reset

	public DiceGame clone()
	{
		//This method tries to clone DiceGame, if caught, a state error is thrown.
		try{return (DiceGame)super.clone();}
		catch(CloneNotSupportedException cns)
		{
			throw new RuntimeException(cns.getMessage());
		}//catch
	}//public clone

	public boolean gameOver()
	{
		//Determines if the game is over.
		return gameWon() || gameLost();
	}//public gameOver

	public int getNumberOfDies()
	{
		return getDice().getNumberOfDies();
	}

	abstract public boolean gameWon(); //Abstract that is subclasses to game classes

	abstract public boolean gameLost(); //Abstract that is subclasses to game classes


}//public class DiceGame