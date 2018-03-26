package Demo;

import com.google.gson.Gson;

public class Driver
{

/*
	Tyler A. Green
	CISC 230
	Patrick L. Jarvis
	9-13-2015

	This class accepts a number to determine the amount of times DiceGame should run Craps. It then collects information of game won, game lost, the amount of rolls, and the specific value of both individual dies that were rolled that ended the game.

*/
	//public static void main(String[] args)
	public String runner(int times)
	{
		//This main accepts a number to determine the amount of times DiceGameSimulator should run DiceGame which, in turn, runs Craps. It then collects information of game won, game lost, the amount of rolls, and the specific value of both individual dies that were rolled that ended the game.

		DiceGameSimulator diceGameSimulator;
		DiceGameResult[] array;

		diceGameSimulator = new DiceGameSimulator(new Craps());
		array = diceGameSimulator.runSimulator(times);

		//StringBuilder string = new StringBuilder();

		/*for(int i=0; i<array.length; i++)
		{
			//System.out.print(array[i].gameWon() + "; " + array[i].rollCount() + "; ");
			string.append(array[i].gameWon() + "; " + array[i].rollCount() + "; ");
			for(int j=0; j<array[i].getFinalThrow().length;j++)
			{
				//System.out.print(array[i].getFinalThrow()[j] + " ");
				string.append(array[i].getFinalThrow()[j] + " ");
			}//for
			//System.out.println();
			string.append("\n");
		}//for*/

		//return string.toString();
		String temp = new Gson().toJson(array);
		return new Gson().toJson(array);
	}//public main

}//Driver