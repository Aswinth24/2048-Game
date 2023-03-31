import java.util.*;
public class Game2048
{
  static Scanner input=new Scanner(System.in);
  int[][] board=new int[4][4];
  byte[] element={4,2};
  static boolean move;
  void initializingBoard()
  {
	
	  board[2][2]=2;
	  board[3][1]=2;
	  print();
  }
  void generateElement()
  {
	  int i=(int)(Math.random()*2);
	  //System.out.println(move);
	  while(true&&move)
	  {
	     int x=(int)(Math.random()*board.length);
		 int y=(int)(Math.random()*board.length);
		 if(board[x][y]==0)
		 {
			 //System.out.println("\t\t("+(x+1)+","+(y+1)+")="+element[i]);
			 board[x][y]=element[i];
			 break;
		 }
	  }
	  move=false;
  }	
   void moveLeft()
  {
	  int len=board.length;
	 
	  for(int i=0;i<len;i++)
	  {
		  for(int j=0;j<len-1;j++)
		  {
			  if(board[i][j]==board[i][j+1]&&board[i][j]!=0)
			  {
				  board[i][j]+=board[i][j+1];
				  board[i][j+1]=0;
				 
				  move=true;
			  }
			  else if(board[i][j]==0&&board[i][j+1]!=0)
			  {
				  board[i][j]=board[i][j+1];
				  board[i][j+1]=0;
				  move=true;
			  }
		  }
	  }
	 
	   for(int i=0;i<len;i++)
	  {
		  int j=0;
		  int k=0;
		  while(j<len)
		  {
			  if(board[i][j]!=0)
			  {
				  int temp=board[i][k];
				  board[i][k]=board[i][j];
				  board[i][j]=temp;
				  k++;
			  }
			  j++;
		  }
	  }
  }	
  void moveRight()
  {
	  int len=board.length;
	 
	   for(int i=0;i<len;i++)
	  {
		  for(int j=len-1;j>0;j--)
		  {
			  if(board[i][j-1]==board[i][j]&&board[i][j]!=0)
			  {
				  board[i][j]+=board[i][j-1];
				  board[i][j-1]=0;
				  
				  move=true;
				
			  }
			  else if(board[i][j]==0&&board[i][j-1]!=0)
			  {
				  board[i][j]=board[i][j-1];
				  board[i][j-1]=0;
				  move=true;
			  }
		  }
	  }
	   for(int i=0;i<len;i++)//move zeros
	  {
		  int j=len-1;
		  int k=len-1;
		  while(j>=0)
		  {
			  if(board[i][j]!=0)
			  {
				  int temp=board[i][k];
				  board[i][k]=board[i][j];
				  board[i][j]=temp;
				  k--;
			  }
			  j--;
		  }
	  }
	 }
  
  void moveUp()
  {
	  int len=board.length;
	 // boolean[][] flag=new boolean[len][len];
	 
	   for(int i=0;i<len-1;i++)
	  {
		  for(int j=0;j<len;j++)
		  {
			  if(board[i][j]==board[i+1][j]&&board[i][j]!=0)
			  {
				  board[i][j]+=board[i+1][j];
				  board[i+1][j]=0;
				 // flag[i][j]=true;
				  move=true;
				 //System.out.println(i+","+j);
			
			  }
			 else if(board[i][j]==0&&board[i+1][j]!=0)
			  {
				  board[i][j]=board[i+1][j];
				  board[i+1][j]=0;
				  //System.out.println(i+","+j);
				  move=true;
			  }
		  }
	  }
	  for(int i=0;i<len;i++)
	  {
		  int j=0;
		  int k=0;
		  while(j<len)
		  {
			  if(board[j][i]!=0)
			  {
				  int temp=board[k][i];
				  board[k][i]=board[j][i];
				  board[j][i]=temp;
				  k++;
			  }
			  j++;
		  }
	  }
  }
  void moveDown()
  {
	  int len=board.length;
	// boolean[][] flag=new boolean[len][len];
	 for(int i=len-1;i>0;i--)
	  {
		  for(int j=0;j<len;j++)
		  {
			  if(board[i][j]==board[i-1][j]&&board[i][j]!=0){
				  board[i][j]+=board[i-1][j];
				  board[i-1][j]=0;
				  //flag[i-1][j]=true;
				  move=true;
				
			  }
			  else if(board[i][j]==0&&board[i-1][j]!=0)
			  {
				  board[i][j]=board[i-1][j];
				  board[i-1][j]=0;
				  move=true;
			  }
		  }
	  }
	 
	   for(int i=0;i<len;i++)
	  {
		  int j=len-1;
		  int k=len-1;
		  while(j>=0)
		  {
			  if(board[j][i]!=0)
			  {
				  int temp=board[k][i];
				  board[k][i]=board[j][i];
				  board[j][i]=temp;
				  k--;
			  }
			  j--;
		  }
	  }
	
  }
  void print()
  {
	  int len=board.length;
	  for(int i=0;i<len;i++)
	  {
		  System.out.println();
		  System.out.print("\t\t+");
		  for(int k=0;k<len;k++)      
			  System.out.print("-------+");
		  System.out.print("\n\t\t|");
		  for(int j=0;j<len;j++){
			  if(board[i][j]!=0)
			  System.out.print(String.format("  %-5d|",board[i][j]));
		      else
				   System.out.print("       |");  
		  }
		  
	  }
	   System.out.print("\n\t\t+");
		  for(int k=0;k<len;k++)
			  System.out.print("-------+");
	  
  }
  boolean check()
  {
	  int len=board.length;
	  for(int i=0;i<len;i++)
	  {
		  for(int j=0;j<len;j++)
		  {
			  int val=board[i][j];
			  if(j+1<len&&val==board[i][j+1])
				  return false;
			  if(j-1>=0&&val==board[i][j-1])
				  return false;
			  if(i+1<len&&val==board[i+1][j])
				  return false;
			  if(i-1>=0&&val==board[i-1][j])
				  return false;
		  }
	  }
	  return true;
	  
  }
  boolean winner()
  {
	  int len=board.length;
	  for(int i=0;i<len;i++)
		  for(int j=0;j<len;j++)
			  if(board[i][j]==2048)
				  return true;
	  return false;
  }
  public void clearScreen()
     {
	   try{
		   Thread.sleep(50);
	      new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
	   }
	   catch(Exception e)
	   {	   
	   }
     }
}