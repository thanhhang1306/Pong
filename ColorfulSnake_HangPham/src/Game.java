


import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage; 
import java.awt.event.*; 


public class Game  extends JPanel implements Runnable, KeyListener{


	private BufferedImage back; 
	private int key;
	private  int lengthOfPart = 25;
	private  int partOfSnake = 20;
	private int[] xCoor = new int[partOfSnake];
	private int[] yCoor = new int[partOfSnake];
	private char movement = 'T';
	private int random_Int1, random_Int2, random_Int3;
	private ImageIcon background;


	public Game() {
		new Thread(this).start();	
		this.addKeyListener(this);
		key = -1;
		background = new ImageIcon("background.png");
	}



	public void run()
	{
		try
		{
			while(true)
			{
				Thread.currentThread().sleep(30);
				repaint();
			}
		}
		catch(Exception e)
		{
		}
	}

	public void drawSnake(Graphics g){
		/* this method will draw the parts. Even though the value inside the array is not declared
		 * Moving the snake will change the x[i] and y[i] positions accordingly and draw the block
		 * x[0] and y[0] initially starts at position 0,0 since int values in array are initialized to 0
		 * Meaning at first, only the top left corner block would be drawn since all the other values of array are also 0,0
		 */
		for (int i = 0; i < partOfSnake; i++){ // drawing parts
			if (i == 0){
				g.setColor(Color.WHITE);	
				g.fillRect(xCoor[i], yCoor[i], lengthOfPart, lengthOfPart);
			}
			else{
				random_Int1 = (int)(Math.random()*255 + 1);
				random_Int2 = (int)(Math.random()*255 + 1);
				random_Int3 = (int)(Math.random()*255 + 1);
				Color random_Color = new Color(random_Int1, random_Int2, random_Int3);
				g.setColor(random_Color);	
				g.fillRect(xCoor[i], yCoor[i], lengthOfPart, lengthOfPart);
			}
		}
	}


	public void moveSnake(){
		/* When the snake is moved, the previous block takes position 
		 * Of the block in front. Therefore if x[0] and y[0] are coordinate of the head
		 * The block afterward, which is  x[1] and y[1], moves to x[0] and y[0] 
		 * So movement would make x[i] = x[i - 1] and y[i] = y[i - 1]
		 * Make i = partOfSnakes (6) so that you can subtract better; initializing i to 0 would make it hard to -1 
		 * Since index of arrays end at 0. Also, the head moves to a new block so this for() doesn't apply to it
		 */
		for (int i = partOfSnake - 1; i > 0; i--){
			if (movement == 'R' || movement == 'L' || movement == 'U' || movement == 'D'){
				xCoor[i] = xCoor[i-1];
				yCoor[i] = yCoor[i-1];
			}
		}

		/* Movement code.... Using switch case
		 * The movement code will be directly related to the head, since all the body parts are moved 
		 * In relation to the head (the head move causes the body to move since the value of each index change relative
		 * to the value before it). Meaning only x[0] and y[0] will be impacted 
		 */
			switch (movement){ 	
			// 'R' for right 
			case 'R': 
				xCoor[0] = xCoor[0] + lengthOfPart;
				break;

				// 'L' for left 
			case 'L': 
				xCoor[0] = xCoor[0] - lengthOfPart;
				break;

				// 'U' for up
			case 'U':
				yCoor[0] = yCoor[0] - lengthOfPart;
				break;

				// 'D' for down
			case 'D': 
				yCoor[0] = yCoor[0] + lengthOfPart;
				break;
			default: 

			}
		// Break is utilized as you can only move in one direction at a time. Helps the code run smoother.
		// Note: Do---while is executed at least once 
	}




	public void paint(Graphics g){

		Graphics2D twoDgraph = (Graphics2D) g; 
		if( back ==null)
			back=(BufferedImage)( (createImage(getWidth(), getHeight()))); 


		Graphics g2d = back.createGraphics();

		g2d.clearRect(0,0,getSize().width, getSize().height);

		g2d.drawImage(background.getImage(),0,0,700,700, this);
		drawSnake(g2d);
		moveSnake();

		twoDgraph.drawImage(back, null, 0, 0);

	}



	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		key = e.getKeyCode();
		switch(key){
		case 37:
			if(movement != 'R'){
				movement = 'L';
			}
			break;
		case 39:
			if(movement != 'L'){
				movement = 'R';
			}
			break;
		case 38:
			if(movement != 'D'){
				movement = 'U';
			}
			break;
		case 40:
			if(movement != 'U'){
				movement = 'D';
			}
			break;
		}
	}



	@Override
	public void keyReleased(KeyEvent e) {
		// surprise 2 - character stop 
		switch(key){
		case 37:
			if(movement == 'L'){
				movement = 'W';
			}
			break;
		case 39:
			if(movement == 'R'){
				movement = 'W';
			}
			break;
		case 38:
			if(movement == 'U'){
				movement = 'W';
			}
			break;
		case 40:
			if(movement == 'D'){
				movement = 'W';
			}
			break;
		}
	}
}
