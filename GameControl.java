import javax.swing.JFrame;
//This class will know the bounds of every single rectangle within the program.

public class GameControl extends JFrame{

	private static final int frameWidth = 1600;
	private static final int frameHeight = 1000;
	private LayerManager layerManager;

	public GameControl(){
		layerManager = new LayerManager();
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(frameWidth, frameHeight);


		layerManager.addLayer(new Background(), 0);
		layerManager.addLayer(new Foreground(), 1);
		layerManager.addLayer(new Player(), 2);
		add(layerManager);
	}
	public static int getFrameWidth(){
		return frameWidth;
	}
	public static int getFrameHeight(){
		return frameHeight;
	}
}