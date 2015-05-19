import java.awt.Color;
import java.util.LinkedList;
import java.util.ListIterator;


public class Player extends Layer{

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
		player.setId("PLAYER");


		addCollisionRectangle(player);
	}
	public GameBlock getPlayer(){
		return player;
	}


	public void updateCollRectList(GameBlock oldBlock, GameBlock newBlock){
		//Keep the iterators on the same pace by calling next() on both iterators at the same time.
		//The iterator that will invoke hasNext() will be getListOfCollisionRectangles()






	}
	//The oldBlock(GameBlock) parameter should only be given a rectangle that was instantiated in the constructor.
	public void updatePaintRectList(GameBlock oldBlock, GameBlock newBlock){

		LinkedList<GameBlock> tempList = getListOfAllRectangles();
		ListIterator<GameBlock> itr = tempList.listIterator();

		//Find old block and switch it with the contents of the new block

		while(itr.hasNext()){
			GameBlock temp = itr.next();
			if(temp.isEquals(oldBlock)){ //We have found where the oldBlock is stored within the list. Now we need to switch it with newBlock contents.
				itr.set(newBlock);
			}
		}
	}






	public int getPlayerWidth(){
		return playerWidth;
	}
	public int getPlayerHeight(){
		return playerHeight;
	}
	public int getPlayerDisplacementX(){
		return displacementX;
	}
	public int getPlayerDisplacementY(){
		return displacementY;
	}
	public void setPlayerWidth(int playerWidth){
		this.playerWidth = playerWidth;
	}
	public void setPlayerHeight(int playerHeight){
		this.playerHeight = playerHeight;
	}
	public void setPlayerDisplacementX(int displacementX){
		this.displacementX = displacementX;
	}
	public void setPlayerDisplacementY(int displacemnetY){
		this.displacementY = displacementY;
	}
	public void movePlayerLeft(){
		displacementX--;
	}
	public void movePlayerRight(){
		displacementX++;
	}
	public void movePlayerUp(){
		displacementY++;
	}
	public void movePlayerDown(){
		displacementY--;
	}


}