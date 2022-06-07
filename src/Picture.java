
public class Picture {
	private String background, start, playerOne, playerTwo, background2;
	private int x, y;



	public Picture(int corx, int cory){
		x = corx;
		y = cory;
		background = "background.gif";
		background2 = "background2.gif";
		start = "start.gif";
		playerOne = "player1.gif";
		playerTwo = "player2.gif";
	}

	public String getBackground(){
		return background; 
	}
	public String getBackground2(){
		return background2;
	}

	public String getStart(){
		return start;
	}

	public String getPlayerOne(){
		return playerOne;
	}

	public String getPlayerTwo(){
		return playerTwo;
	}

	public int getX(){
		return x;
	}

	public int getY(){
		return y;
	}

}
