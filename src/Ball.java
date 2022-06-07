// Hang Pham - P3
import java.awt.*;

public class Ball {

	private String ball;
	private int x, y, x1, y1,  dx, dy;
	private boolean change, change1;
	private Player play;


	public Ball(int corx, int cory, int corx1, int cory1){
		x = corx; y = cory; x1 = corx1; y1 = cory1;
		change = false; change1 = false; play = new Player();
	}


	public String getBall(){
		return ball;
	}

	public int getX(){
		return x;
	}

	public int getY(){
		return y;
	}

	public int getWidth(){ 
		return x1;
	}

	public int getHeight(){ 
		return y1;
	}

	public int getX_Width(){
		return x + x1;
	}

	public int getY_Height(){
		return y + y1;
	}



	public void reverse(){
		change = !change;
	}

	public void reverse1(){
		change1 = !change1;
	}


	public void setdx(int xx){
		dx = xx; 
	}

	public void setdy(int yy){
		dy = yy; 
	}

	public void move(){
		if(change){
			x+= dx;
		}
		else x -= dx;

		if(y>620||y<-10){ 
			reverse1();
		}
		if (change1){
			y-=dy;
		}
		else y+=dy;	
	}


	public void collide(Paddle p){
		if (this.getY() >= p.getY()-8  && this.getY() <= p.getY_Height()+8){
			if(this.getX()-3 <= p.getX_Width() && this.getX()-3>= p.getX()){	
				reverse();
				play.playmusic("ping1.wav");
			}
			else if(this.getX_Width()+3 <= p.getX_Width() && this.getX_Width()+3 >= p.getX()){
				reverse();
				play.playmusic("ping1.wav");
			}
		}
		else if(this.getY_Height() >= p.getY()-8 && this.getY_Height() <= p.getY_Height()+8){
			if(this.getX()-3 <= p.getX_Width() && this.getX()-3 >= p.getX()){
				reverse();
				play.playmusic("ping1.wav");
			}
			else if(this.getX_Width()+3 <= p.getX_Width() && this.getX_Width()+3 >= p.getX()){
				reverse();
				play.playmusic("ping1.wav");
			}
		}
	}

	/*public void collide(Paddle p){
		if(p.paddle(x,y)){
			reverse();
		}
		if(p.paddle(x+x1,y)){
			reverse();
		}
		if(p.paddle(x, y+y1)){
			reverse();
		}
		if(p.paddle(x+x1, y+y1)){
			reverse();
		}
	}*/



	public void restartMatch(){
		setdx(0);
		setdy(0);
		x = 480;
		y = 330;
	}



}
