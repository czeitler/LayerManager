import java.awt.Color;




public class Foreground extends Layer{

	GameBlock block1;
	GameBlock block2;
	GameBlock block3;
	GameBlock block4;
	GameBlock block5;

	Color foregroundColor;


	public Foreground(){
		super();

		foregroundColor = new Color(0, 112, 60);

		block1 = new GameBlock(0, 700, 300, 300, foregroundColor);
		block1.setId("FOREGROUND_1");
		block2 = new GameBlock(450, 600, 250, 1000, foregroundColor);
		block2.setId("FOREGROUND_2");
		block3 = new GameBlock(700, 500 , 300, 1000, foregroundColor);
		block3.setId("FOREGROUND_3");
		block4 = new GameBlock(1000, 450, 300, 1000, foregroundColor);
		block4.setId("FOREGROUND_4");

		addNonCollisionRectangle(block1);
		addNonCollisionRectangle(block2);
		addNonCollisionRectangle(block3);
		addNonCollisionRectangle(block4);
	}
	public void updateCollRectList(GameBlock oldBlock, GameBlock newBlock){}
	public void updatePaintRectList(GameBlock oldBlock, GameBlock newBlock){}



}