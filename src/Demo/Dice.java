package Demo;

import java.io.*;
import java.util.*;
public class Dice
{
/*
	Tyler A. Green
	CISC 230
	Patrick L. Jarvis
	9-13-2015

	This class recieves the amount of dice that should be rolled, rolls them, and gets their values.

	Variables:

		dice
			An instance variable that is an object array for Die.

		value
			A variable that holds the integer array of the specific value of all the dies.

		count
			A variable that holds the sum of all the rolled dice.

	Constructors:

		Dice(numberOfDies)
			Error Checks and initializes dice to the value of passed number of dice.

	Methods:

		private Die[] getDice()
			Accessor to the instance variable dice.

		public int[] getValues()
			Gets the individual values of the rolled dice.

		public void roll()
			Rolls the selected die.

		public int getValue()
			Gets the sum of all the rolled dice.

		public int getValue(int whichOne)
			gets the value of an indivual(whicOne) die.



*/
	private Die[] dice;

	public Dice(int numberOfDies)
	{
		//Error Checks and initializes dice to the value of passed number of dice.
		if(numberOfDies< 1)
		{
			throw new IllegalArgumentException("the number passed was " + numberOfDies + ", which is less than 1");
		} //if
		this.dice = new Die[numberOfDies];
		for(int i=0; i<getDice().length;i++)
		{
			this.dice[i] = new Die();
		} //for
	}//Dice

	private Die[] getDice()
	{
		//Accessor to the instance variable dice.
		return this.dice;
	} //privateDie[]

	public int[] getValues()
	{
		//Gets the individual values of the rolled dice.
		int[] value;
		value = new int[this.getDice().length];
		for(int i=0; i < value.length; i++)
		{
			value[i] = this.getDice()[i].getValue();
		}//for
		return value;
	} //public getValues()

	public void roll()
	{
		//Rolls the selected die.
		for(int i=0; i<this.getDice().length; i++)
		{
			this.getDice()[i].roll();
		}//for

	}//public roll()


	public int getValue()
	{
		//Gets the sum of all the rolled dice.
		int count;

		count = 0;
		for(int i=0; i<this.dice.length;i++)
		{
			count = count + this.getDice()[i].getValue();
		}//for
		return count;

	}//public getValue()

	public int getValue(int whichOne)
	{
		//gets the value of an indivual(whicOne) die.
		return this.getDice()[whichOne-1].getValue();
	}//public getValue(whichOne)

	public int getNumberOfDies()
	{
		return getDice().length;
	}

}//public class