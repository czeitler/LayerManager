import java.awt.Color;


public class Player extends Layer {

	private GameBlock player;
	private int playerWidth;
	private int playerHeight;
	private int displacementX;
	private int displacementY;
	private Color colorOfPlayer;

	public Player(){
		super();

		playerWidth = 100;
		playerHeight = 100;
		displacementX = 10;
		displacementY = 600;
		colorOfPlayer = new Color(100, 100, 100);
		player = new GameBlock(displacementX, displacementY, playerWidth, playerHeight, colorOfPlayer);
		player.setId("1P");


		addCollisionRectangle(player);
	}
	public GameBlock getPlayer(){
		return player;
	}
	public void setDispX(int displacementX){
		this.displacementX = displacementX;
	}
	public int getDispX(){
		return displacementX;
	}



}