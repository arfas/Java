/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.Scanner;
import java.util.Random;
/**
 *
 * @author arfas
 */
public class NewClass {
    

/* Name of the class has to be "Main" only if the class is public. */

	public static void main(String[] args) throws java.lang.Exception {
		Scanner Ilya = new Scanner(System. in );
		Random rnd = new Random();
		int input;
		int B = 1;
		System.out.println("ILYA IS THE GREATEST");

		System.out.println("Pick 1,2, or 3 for:");
		System.out.println("ROCK (1), PAPER(2), or SCISSOR (3)");
		while (B != 0) {
			// 1 = rock
			// 2 = paper
			// 3 = scissors
			// N= Ilya.nextInt();
			int Rock = 1, Paper = 2, Scissor = 3;

			input = Ilya.nextInt();
			int randomNumber = rnd.nextInt(3 - 1 + 1) + 1;
			if (randomNumber == Rock) {
				if (input == Rock) {
					System.out.println("Rock Vs. Rock: TIE");
				} else if (input == Paper) {
					System.out.println("Paper Vs. Rock: YOU WIN");
				} else if (input == Scissor) {
					System.out.println("Scissor Vs. Rock: YOU LOSE");
				}
			} else if (randomNumber == Paper) {
				if (input == Rock) {
					System.out.println("Rock Vs. Paper: YOU LOSE");
				} else if (input == Paper) {
					System.out.println("Paper Vs. Paper: TIE");
				} else if (input == Scissor) {
					System.out.println("Scissor Vs. Paper: YOU WIN");
				}

			} else if (randomNumber == Scissor) {
				if (input == Rock) {
					System.out.println("Rock Vs. Scissor: YOU WIN");
				} else if (input == Paper) {
					System.out.println("Paper Vs. Scissor: YOU LOSE");
				} else if (input == Scissor) {
					System.out.println("Scissor Vs. Scissor: TIE");
				}
			}

    int Y=8, N=9;
    	System.out.println("Do you want to play again? Y(8)/N(9)");
    input = Ilya.nextInt();
    if(input==Y){
      B=1;	
      System.out.println("Rock, Paper,SCISSOR");
    }
    else if(input==N)
    {System.exit(0);
    	System.out.println("GOODBYE");
		}

	}
	}
	
} 
    

