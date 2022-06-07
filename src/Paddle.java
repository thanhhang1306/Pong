
public class Paddle {
	private int x, y, dy, x1, y1;


	public Paddle(int posx, int posy, int posx1, int posy1){
		x = posx;
		y = posy;
		x1 = posx1;
		y1 = posy1;
		dy = 0;
	}


	public int getX(){ //corner top left 
		return x;
	}

	public int getY(){ // corner top left start 
		return y;
	}

	public void setY(int setY){
		y = setY; 
	}

	public int getWidth(){ 
		return x1;
	}

	public int getHeight(){ 
		return y1;
	}

	public int getX_Width(){// corner top right 
		return x + x1;
	}

	public int getY_Height(){ //corner bottom left 
		return y + y1;
	}


	public void setdy(int yy){
		dy = yy; 
	}

	public void move(){
		y += dy;
	}

	/*public boolean paddle(int x, int y){
		if(x >= this.x && x <= (this.x + this.x1) && y >= this.y && y <= (this.y + this.y1)){
			return true;
		}
			return false;
	}*/

}
