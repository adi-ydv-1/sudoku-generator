package Suduko;
import java.util.Random;
import java.util.Scanner;
public class sudoko_generator
{
	static Random m=new Random();
	static int suduko[][]=new int[9][9];
	static int copy[][]=new int[9][9];
  static Scanner sc=new Scanner(System.in);
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
		
		diagonal();
		non_diagonal();
		display();
		System.out.println("Enter the no of zero you want");
		int n=sc.nextInt(); 
		make_zero(n);
		display();

	}
	public static int[][] get_suduko()
	{
		for(int i=0;i<9;i++)
		{
			for(int j=0;j<9;j++)
			{
				copy[i][j]=suduko[i][j];
			}
		}
				return copy;
	}
	public static void make_zero(int suduko[][],int n)
	{
		while(n>0)
		{
			int i=m.nextInt(9);
			int j=m.nextInt(9);
			if(suduko[i][j]!=0)
			{
				suduko[i][j]=0;
				n--;
			}	
		}
	}
	public static boolean non_diagonal(int a[][])
	{
//		int count=0,i=0;
//		while(i<9) 
//		{
//			while(count<9)
//			{
//			for(int j=i;j<i+3;j++)
//			{
//				if(i==0&&count==0||i==3&&count==3||i==6&&count==6)
//				{	
//				   continue;			
//				}
//				for(int k=count;k<count+3;k++)
//				{
//					for(int no=1;no<=9;no++)
//					{
//						if(check_2(i,count,j,k,no))
//						{
//							suduko[j][k]=no;
//							break;
//						}
//					}
//				}
//			}
//			count+=3;
//		}
//			count=0;
//		i+=3;
	for(int i=0;i<9;i++)
	{
		for(int j=0;j<9;j++)
		{
			if(a[i][j]==0)
			{
				boolean f=true;
				for(int k=1;k<=9;k++)
				{
					if(check_2(i,j,k))
					{
						f=false;
					a[i][j]=k;
						if(non_diagonal(a))
						break;
						else {
							f=true;
					a[i][j]=0;	
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
	public static void diagonal()
	{
		int a,b;
		for(int i=0;i<9;i+=3)
		{
			for(int j=i;j<i+3;j++)
			{
				for(int k=i;k<i+3;k++)
				{
					while(true) 
					{
					int x=m.nextInt(9)+1;
					if(check(i,i,x))
					{
						suduko[j][k]=x;
						break;
					}
				  }
				}
			}
		}
	}
	public static void display(int a[][])
	{
		System.out.println();
		for(int i=0;i<a.length;i++)
		{
			for(int j=0;j<a.length;j++)
			{
				System.out.print(a[i][j]+" ");
			}
			System.out.println();
		}
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
