package Suduko;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class suduko_solving
{
    static Scanner sc=new Scanner(System.in);
    static Random m=new Random();
    static int suduko[][]=new int[9][9];
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		sudoko_generator s=new sudoko_generator();
		input();
		s.display(suduko);
		solve();
		s.display(suduko);		
		}
	public static void input()
	{
		for(int i=0;i<9;i++)
		{
			for(int j=0;j<9;j++)
			{
				suduko[i][j]=sc.nextInt();
			}
		}	
	}
	public static boolean solve()
	{
		for(int i=0;i<9;i++)
		{
			for(int j=0;j<9;j++)
			{
				boolean f=true;
				if(suduko[i][j]==0)
				{
					for(int k=1;k<=9;k++)
					{
						if(check_2(i,j,k))
						{
							f=false;
							suduko[i][j]=k;
							if(solve())
								break;
							else
							{
								suduko[i][j]=0;
								f=true;
							}
						}
					}
					if(f==true)
						return false;
				}
			}
		}
		return true;
	}
	public static boolean check(int a,int b,int k)
	{
		for(int i=a;i<a+3;i++)
		{
			for(int j=b;j<b+3;j++)
			{
				if(suduko[i][j]==k) 
					 return false;	 
			}
		}
		return true;
	}
	public static boolean check_2(int a,int b,int k)
	{
		
		if(check(a-(a%3),b-(b%3),k))
		{
			for(int i=0;i<9;i++)
			{
					if(suduko[a][i]==k)
						return false;
					if(suduko[i][b]==k)
						return false;
				}
			
			return true;
		}
		else
			return false;
	}
}
