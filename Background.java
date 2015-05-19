import java.awt.Color;



public class Background extends Layer{

	GameBlock mainBackground;
	GameBlock cloud;
	GameBlock sun;

	Color backgroundColor;
	Color cloudColor;
	Color sunColor;



	public Background(){
		super();

		backgroundColor = new Color(135, 206, 235);
		backgroundColor.brighter();
		cloudColor = Color.LIGHT_GRAY;
		cloudColor.brighter();
		sunColor = Color.YELLOW;
		sunColor.brighter();

		mainBackground = new GameBlock(0, 0, GameControl.getFrameWidth(), GameControl.getFrameHeight(), backgroundColor);
		cloud = new GameBlock(800,100,100,100, cloudColor);
		sun = new GameBlock(100,100,150,150, sunColor);

		mainBackground.setId("3MB");
		cloud.setId("3C");
		sun.setId("3S");

		addNonCollisionRectangle(mainBackground);
		addNonCollisionRectangle(cloud);
		addNonCollisionRectangle(sun);

	}



}