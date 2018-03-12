package Demo;

import java.io.*;
import java.util.*;
public class DiceGameResult
{
/*
	Tyler A. Green
	CISC 230
	Patrick L. Jarvis
	9-13-2015

	This class recieves an array with gamewon, the final throw, and the rollcount. It then stores them in instance variables that can be accessed by the driver.

	Class Variables:

		GameWon
			A variable that contains a boolean of if is the game was won or not.

		finalThrow
			A variable that contains an integer array of the 2 final die that were thrown.

		rollCount
			A variable that contains an integer of the amount of rounds/times dice were rolled.

		copyArray
			A variable that contains the copy of the finalThrow array.

	Contructors:

		DiceGameResult
			error checks and sets gameWon, finalThrow, and rollCount to the value of the parameter.

		int[]
			creates an array that is ready to take in integers.

	Methods:

		public boolean gameWon()
			accessor for the instance variable gameWon.

		public int rollCount()
			accessor for the instance variable rollCount.

		public int[] getFinalThrow()
			copies the finalThrow array into a new array and then passes said new array.

*/
	private boolean gameWon;

	private int[] finalThrow;

	private int rollCount;

	public DiceGameResult(boolean gameWon, int[] finalThrow, int rollCount)
	{
		//error checks and sets gameWon, finalThrow, and rollCount to the value of the parameter.
		if(finalThrow.length != 2)
		{
			throw new IllegalArgumentException("The passed last throw of the game was not a two length array");
		}//if
		if(rollCount <= 0)
		{
			throw new IllegalArgumentException("The passed rollCount was less than one");
		}//if

		this.gameWon = gameWon;

		this.finalThrow = finalThrow;

		this.rollCount = rollCount;

	}//public DiceGameResult

	public boolean gameWon()
	{
		//accessor for the instance variable gameWon.
		return this.gameWon;
	}//gameWon

	public int rollCount()
	{
		//accessor for the instance variable rollCount.
		return this.rollCount;
	}//rollCount

	public int[] getFinalThrow()
	{
		//copies the finalThrow array into a new array and then passes said new array.
		int[] copyArray;
		copyArray = new int[this.finalThrow.length];
		System.arraycopy(this.finalThrow,0,copyArray,0,this.finalThrow.length);
		return copyArray;
	}//getFinalThrow

}//public class