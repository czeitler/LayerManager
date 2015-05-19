import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.Timer;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
//This class will know the bounds of every single rectangle within the program.

public class GameControl extends JFrame implements ActionListener, KeyListener{

	private static final int frameWidth = 1600;
	private static final int frameHeight = 1000;
	private LayerManager layerManager;
	private int playerDepth;
	private int backgroundDepth;
	private int foregroundDepth;

	private Background background;
	private Foreground foreground;
	private Player player;

	private Timer timer;

	public GameControl(){
		layerManager = new LayerManager();
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(frameWidth, frameHeight);
		setResizable(false);
		setTitle("Simple Java Game Engine: Lost Triangle");

		player = new Player();
		playerDepth = 2;
		foreground = new Foreground();
		foregroundDepth = 1;
		background = new Background();
		backgroundDepth = 0;

		layerManager.addLayer(background, backgroundDepth);
		layerManager.addLayer(foreground, foregroundDepth);
		layerManager.addLayer(player, playerDepth);
		add(layerManager);

		addKeyListener(this);
		timer = new Timer(100, this);
		timer.start();


	}
	public void actionPerformed(ActionEvent e){
		//We need to make changes to the layers before we update them with the layerManager.
		//updatePaintRectList(GameBlock oldBlock, GameBlock newBlock)
		/*GameBlock tempBlock = player.getPlayer();

		tempBlock.setDisplacementX(tempBlock.getDisplacementX() + 1);

		player.updatePaintRectList(player.getPlayer(), tempBlock);

		layerManager.updateLayer(player, playerDepth);
		layerManager.updateLayer(foreground, foregroundDepth);
		layerManager.updateLayer(background, backgroundDepth);*/
	}
	public void keyPressed(KeyEvent e){
		if(KeyEvent.VK_LEFT == e.getKeyCode()){
			GameBlock tempBlock = player.getPlayer();

			tempBlock.setDisplacementX(tempBlock.getDisplacementX() - 10);

			player.updatePaintRectList(player.getPlayer(), tempBlock);

			layerManager.updateLayer(player, playerDepth);
			layerManager.updateLayer(foreground, foregroundDepth);
			layerManager.updateLayer(background, backgroundDepth);

		}
		if(KeyEvent.VK_RIGHT == e.getKeyCode()){
			GameBlock tempBlock = player.getPlayer();

			tempBlock.setDisplacementX(tempBlock.getDisplacementX() + 10);

			player.updatePaintRectList(player.getPlayer(), tempBlock);

			layerManager.updateLayer(player, playerDepth);
			layerManager.updateLayer(foreground, foregroundDepth);
			layerManager.updateLayer(background, backgroundDepth);
		}
		if(KeyEvent.VK_UP == e.getKeyCode()){
			GameBlock tempBlock = player.getPlayer();

			tempBlock.setDisplacementY(tempBlock.getDisplacementY() - 10);

			player.updatePaintRectList(player.getPlayer(), tempBlock);

			layerManager.updateLayer(player, playerDepth);
			layerManager.updateLayer(foreground, foregroundDepth);
			layerManager.updateLayer(background, backgroundDepth);


		}
		if(KeyEvent.VK_DOWN == e.getKeyCode()){
			GameBlock tempBlock = player.getPlayer();

			tempBlock.setDisplacementY(tempBlock.getDisplacementY() + 10);

			player.updatePaintRectList(player.getPlayer(), tempBlock);

			layerManager.updateLayer(player, playerDepth);
			layerManager.updateLayer(foreground, foregroundDepth);
			layerManager.updateLayer(background, backgroundDepth);

		}
	}
	public void keyReleased(KeyEvent e){}
	public void keyTyped(KeyEvent e){}


	public static int getFrameWidth(){
		return frameWidth;
	}
	public static int getFrameHeight(){
		return frameHeight;
	}



}