package Demo;

import java.io.*;
import java.util.*;
public class Craps extends DiceGame
{
/*
	Tyler A. Green
	CISC 230
	Patrick L. Jarvis
	9-13-2015

	This class acts like a game of craps and rolls two die. It then determines if the specific values from the die constitute a victory or defeat.

	Variables:

		thePoint
			A variable that holds the value of the first roll.

		checkWin
			A variable that holds a boolean of if the value of the die constitute a victory.

		checkLoss
			A variable that holds a boolean of if the value of the die constitute a defeat.

	Constructors:

		Craps()
			Tells the DiceGame that it uses 2 die and sets thePoint to zero.

	Mothods:

		public boolean gameWon()
			Returns a boolean of if the rolled die value constitutes a victory by the rules of craps.

		public boolean gameLost()
			Returns a boolean of if the rolled die value constitutes a defeat by the rules of craps.

		public int thePoint()
			Error checks and accessor for the instance variable thePoint;

		public void roll()
			rolls the dice that are in the DiceGame;

*/

	private int thePoint;

	public Craps()
	{
		//Tells the DiceGame that it uses 2 die and sets thePoint to zero.
		super(2);
		this.thePoint=0;
	}//Craps()

	public boolean gameWon()
	{
		//Returns a boolean of if the rolled die value constitutes a victory by the rules of craps.
		boolean checkWin;
		checkWin = false;

		if(super.getRollCount() == 1 && (super.getValue() == 7 || super.getValue() == 11))
		{
			checkWin = true;
		}//ifgetRollCount
		if(super.getRollCount() > 1 && super.getValue() == thePoint())
		{
			checkWin = true;
		}//ifgetValue
		return checkWin;
	}//public GameWon

	public boolean gameLost()
	{
		//Returns a boolean of if the rolled die value constitutes a defeat by the rules of craps.
		boolean checkLoss;
		checkLoss = false;
		if(super.getRollCount() == 1 && (thePoint() == 2 || thePoint() == 3 || thePoint() == 12))
		{
			checkLoss = true;
		}//ifgetRollCount
		if(super.getRollCount() > 1 && super.getValue() == 7)
		{
			checkLoss = true;
		}//ifgetValue
		return checkLoss;
	}//public gameLost

	public int thePoint()
	{
		//Error checks and accessor for the instance variable thePoint;
		if(super.getRollCount() == 0)
		{
			throw new IllegalStateException("The rollcount is 0, dice haven't been rolled and you called for the count.");
		}//if=0
		if(super.getRollCount() == 1)
		{
			this.thePoint = super.getValue();
		}//if==1
		return this.thePoint;
	}//public thePoint

	public void roll()
	{
		//rolls the dice that are in the DiceGame;
		super.roll();
	}//public roll

}//class