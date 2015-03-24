package atm_machine;
import java.util.Scanner;
import java.io.*;


public class atm_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int  ch,pin,right_pin=4567,bal=20000,amt;
	
		Scanner in = new Scanner(System.in);
		System.out.println("\t\tWelcome to Bank\nInsert your card");
		System.out.println("Enter your pin");
		try//used here for accepting only integer value for pin it prints error message on entering any value other than integer
		{
			
		
			pin= in.nextInt();
			if(pin==right_pin)
			{
				System.out.println("enter your choice\n1.check balance\n2.withdrawl\n");
				//Scanner in = new Scanner(System.in);
				ch = in.nextInt();
				switch(ch)
				{
				case 1:
					System.out.println(bal);
							break;
				case 2: {
					System.out.println("Enter amount");
					//Scanner in = new Scanner(System.in);
					amt=in.nextInt();
						if((amt<=bal)&&(amt>=500)&&(amt%100==0))
						{
							System.out.println("Collect your money");
							bal=bal-amt;
							System.out.println("New balance is="+bal);
						
						}
						else if(amt<500)
						{
							System.out.println("Amount should be more than 500");
						}
						else if(amt%100!=0)
						{
							System.out.println("Amount should be multiple of hundreds ");
						}
						else  {
							System.out.println("Sorry! insufficient balance\n");
						}

				}
					break;
				default: 
				System.out.println("Sorry wrong choice entered\n");
					System.exit(0);
					break;
					//this case works on entering any other integer chioce except 1 or 2	
				}
			
		}
			else
			{
				System.out.println("\tWRONG PIN ENTERED");
				System.exit(0);
			}
		
					
			
		}
		catch(Exception e)
		{
			System.out.println("\tINVALID INPUT\t");
		}
		System.out.println("\tTHANKS FOR USING\t");
				
	}	
}


