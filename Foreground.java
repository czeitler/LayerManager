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

		addNonCollisionRectangle(block1);



	}



}