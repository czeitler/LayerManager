import javax.swing.JFrame;
//This class will know the bounds of every single rectangle within the program.

public class GameControl extends JFrame{

	private static final int frameWidth = 1600;
	private static final int frameHeight = 1000;
	private LayerManager layerManager;
	private Background backgroundLayer;
	private Foreground foregroundLayer;
	private Player playerLayer;

	public GameControl(){
		layerManager = new LayerManager();
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(frameWidth, frameHeight);

		backgroundLayer = new Background();
		foregroundLayer = new Foreground();
		playerLayer = new Player();


		layerManager.addLayer(backgroundLayer, 0);
		layerManager.addLayer(foregroundLayer, 1);
		layerManager.addLayer(playerLayer, 2);
		add(layerManager);


		int i = 250;

			i++;
			GameBlock temp = playerLayer.getPlayer();
			playerLayer.setDispX(playerLayer.getDispX() + i );
			GameBlock temp2 = playerLayer.getPlayer();

			playerLayer.updateRectangle(temp, temp2);


			layerManager.updateLayer(playerLayer, 2);

			repaint();




	}
	public static int getFrameWidth(){
		return frameWidth;
	}
	public static int getFrameHeight(){
		return frameHeight;
	}
}