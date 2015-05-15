import java.awt.Rectangle;
import java.awt.Color;

public class GameBlock extends Rectangle{

	private int width;
	private int height;
	private int displacementX;
	private int displacementY;
	private Color gameBlockColor;

	public GameBlock(int displacementX, int displacementY, int width, int height){
		super(width, height);
		this.width = width;
		this.height = height;
		this.displacementX = displacementX;
		this.displacementY = displacementY;
	}
	//Has a color parameter
	public GameBlock(int displacementX, int displacementY, int width, int height, Color gameBlockColor){
		super(width, height);
		this.width = width;
		this.height = height;
		this.displacementX = displacementX;
		this.displacementY = displacementY;
		this.gameBlockColor = gameBlockColor;
	}
	public Rectangle getRectangle(){
		return new Rectangle(width, height);
	}

	public void setWidth(int width){
		this.width = width;
	}
	public void setHeight(int height){
		this.height = height;
	}
	public void setDisplacementX(int displacementX){
		this.displacementX = displacementX;
	}
	public void setDisplacementY(int displacementY){
		this.displacementY = displacementY;
	}
	public void setColorOfGameBlock(Color gameBlockColor){
		this.gameBlockColor = gameBlockColor;
	}
	public int getGameBlockWidth(){
		return width;
	}
	public int getGameBlockHeight(){
		return height;
	}
	public int getDisplacementX(){
		return displacementX;
	}
	public int getDisplacementY(){
		return displacementY;
	}
	public Color getColorOfGameBlock(){
		return gameBlockColor;
	}
}