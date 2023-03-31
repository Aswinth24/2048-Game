import java.util.*;
public class Main
{
  public static void main(String[] args)
  {
	  Game2048 game=new Game2048();
	 game.initializingBoard();
	 Scanner input=new Scanner(System.in);
	 System.out.println("\nw-> Up\ns->Down\na-> Left\nd-> Right\ne-> End");
	 //game.clearScreen();
	 while(true)
	{
		// System.out.println("\n\n\t\tOPTIONS \n\t\tUP\n\t\tDOWN\n\t\tLEFT\n\t\tRIGHT\n\t\tEND");
		 System.out.print("\n\t\t move : ");
		 int option=input.next().charAt(0);
	    switch(option)
		{
			case 'w':
			  game.moveUp();
			  break;
			case 's':
			  game.moveDown();
			  break;
			case 'a':
			 game.moveLeft();
			  break;
			case 'd':
			 game.moveRight();
			  break;
			case 'e':
			  return;
		}
		game.clearScreen();
		if(game.winner())
		{
			game.print();
			System.out.println("You Won!!!");
		}
		if(game.check())
		{
			game.print();
			System.out.println("Game Over!!!");
		}
		game.generateElement();
		game.print();
		
	}
  }	  
}
