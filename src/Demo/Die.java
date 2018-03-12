package Demo;

import java.io.*;
import java.util.*;
public class Die
{
/*
	Tyler A. Green
	CISC 230
	Patrick L. Jarvis
	9-13-2015

	This class rolls the dice.

	Variables:

		value
			An instance variable that holds the value of rolled die.

	Constructors:

		Die()
			This constructor rolls dice.

	Methods:

		public int getValue()
			An accessor to the instance variable value.

		public void roll()
			Rolls die.


*/
	private int value;

	public Die()
	{
		//This constructor rolls dice.
		this.roll();
	}//public Die

	public int getValue()
	{
		//An accessor to the instance variable value.
		return this.value;
	}//public getValue

	public void roll()
	{
		//Rolls die.
		this.value = (int)(Math.random() * 6) +1;
	}//public roll

}//class Die