import java.awt.Color;




public class Foreground extends Layer{

	GameBlock block1;
	Color foregroundColor;

	public Foreground(){
		super();

		foregroundColor = new Color(0, 112, 60);


		block1 = new GameBlock(0, 700, 300, 300, foregroundColor);
		block1.setId("BLOCK1");

		addNonCollisionRectangle(block1);



	}



}