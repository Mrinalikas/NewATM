/**
 * 
 */
package Question;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.*;

/**
 * @author Dell
 *
 */
public class atm_function {
	
   public static int  right_pin=4567,bal=20000, amt_enter_chance=0, processing_chance=0;
   public static void main(String[] args) 
   {
		// TODO Auto-generated method stub
	    Scanner scan = new Scanner(System.in);
	    int enter_pin;
	    System.out.println("\t\tWelcome to Bank\t");
	    taking_input_from_user();
	}

	public static void taking_input_from_user()
	{
		int  enter_pin;
		try{
				Scanner in = new Scanner(System.in);
				System.out.println("Enter your pin");
				enter_pin=in.nextInt();
				if(enter_pin==right_pin)
					costumers_choice();
			
			}
		catch(InputMismatchException e)
			{
				System.out.println("invalid pin");
			}
	return;
	}
	public static void costumers_choice()
	{
		int choice,choice_enter_chance=0;
		System.out.println("enter your choice\n1.check balance\n2.withdrawl\n");
		Scanner scan = new Scanner(System.in);
		while(choice_enter_chance<3)
		{
			try{
				choice=scan.nextInt();
				choice_enter_chance++;
				processing(choice);
				}
			catch(InputMismatchException e)
			{
				System.out.println("INVALID CHOICE ENTERED PLEASE ENTER NUMERAL VALUE ONLY");
				choice_enter_chance++;
			}
		}
		if(choice_enter_chance==3)
		System.out.println("....Sorry session expired , u cant enter more than thrice...");
		return ;
	}
	
	public static void processing(int a)
	{
		switch(a)
		{
		case 1: check_and_print_balance();
				if(processing_chance<3)
					continue_processing();
				else
					end_message();
			break;
		case 2:
			enter_amount();
			break;
		default : System.out.println("Wrong choice of case entered");
				break;
		}
	}
	public static void check_amount_and_withdraw(int amt)
	{	
		int flag=0;
		if((amt<=bal)&&(amt>=500)&&(amt%100==0))
		{	
			bal=bal-amt;
			System.out.println("Collect your money");
			System.out.println("New balance is=");
			check_and_print_balance();
		}
		else if(amt<500)
		{
			System.out.println("Amount should be more than 500");
			flag=1;
		}
		else if(amt%100!=0)
		{
			System.out.println("Amount should be multiple of hundreds ");
			flag=1;
		}
		else 
		{
			System.out.println("Sorry! insufficient balance\n");
			flag=1;
		}

		if(flag==1 && amt_enter_chance<3)
			enter_amount();	
		if(amt_enter_chance>3)
			System.out.println("U cant enter amount more than thrice ");
		continue_processing();
		return ;
	
	}
	public static int enter_amount()	
	{	
		int amount;
		amt_enter_chance++;
		System.out.println("Enter amount");
		Scanner new2 = new Scanner(System.in);
		amount = new2.nextInt();
		check_amount_and_withdraw(amount);
		return 1;
	}
	public static void check_and_print_balance()
	{
		System.out.println(bal);
	}

	public static void continue_processing()
	{  int processing_again;
		do{
			System.out.println("Do you want to processing again\n ENTER 1 FOR YES AND 0 FOR NO");
			processing_chance=processing_chance+1;
			Scanner proc=new Scanner(System.in);
			processing_again= proc.nextInt();
			if(processing_again==1)
				costumers_choice();
			else
				end_message();
			
		}while(processing_chance<3 && processing_again==1);
		
	}

	public static void end_message()
	{
		System.out.println("THNANKS FOR USING\n");
	return;
	}
}
