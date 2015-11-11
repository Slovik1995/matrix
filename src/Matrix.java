import java.nio.charset.IllegalCharsetNameException;
import java.util.IllegalFormatException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Matrix {
	private int dimension;
	int[][] board;
	
	public int getDimension()
	{
		return dimension;
	}
	public Matrix(int d)
	{
		dimension=d;
		board = new int[d][d];
	}
	public void makeMatrix(){
		Scanner s = new Scanner(System.in);
	  for(int i=0; i<getDimension(); i++)
		  for(int j=0; j<getDimension(); j++)
		  {
			  try{
			  board[i][j]=s.nextInt();
			  }
			  catch(InputMismatchException e){
				  System.out.println("zle dane");
				  System.exit(0);
			  }
		  }
	}
	public Matrix add(Matrix m){
		if(getDimension()!=m.getDimension()){
			return null;
		}
		Matrix outcome = new Matrix(getDimension());
		for(int i=0; i<getDimension(); i++)
			for(int j=0; j<getDimension();j++)
				outcome.board[i][j]=this.board[i][j]+m.board[i][j];
	
		return outcome;
		
	}
	public Matrix sub(Matrix m)
	{
		if(getDimension()!=m.getDimension()){
			return null;
		}
		Matrix outcome = new Matrix(getDimension());
		for(int i=0; i<getDimension(); i++)
			for(int j=0; j<getDimension();j++)
				outcome.board[i][j]=this.board[i][j]-m.board[i][j];
			
		return outcome;
	}
	public Matrix mul(Matrix m)
	{
		if(getDimension()!=m.getDimension())
			return null;
		Matrix outcome = new Matrix(getDimension());
		
	   for(int i=0; i<getDimension(); i++)
		   for(int j=0; j<getDimension(); j++)
		   {
			   outcome.board[i][j]=0;
			   for(int k=0; k<getDimension(); k++)
				   outcome.board[i][j]+=this.board[i][k]*m.board[k][j]; 
		   }
	   return outcome;
	}
	public void show(){
		for(int i=0; i<getDimension(); i++)
			 for(int j=0; j<getDimension(); j++)
			 {
				 System.out.print(board[i][j]+" ");
				 if(j==getDimension()-1)
					 System.out.println();
			 }
		System.out.println();
		
	}
	public static void main(String[] arg){
		Matrix m = new Matrix(2);
		m.makeMatrix();
		Matrix m2 = new Matrix(2);
		m2.makeMatrix();
		Matrix m3;
		m3 = m.mul(m2);
		m3.show(); 
		m3=m.add(m2);
		m3.show(); 
		m3=m.sub(m2);
		m3.show(); 
	}
}
