import javax.swing.JFrame;



public class Executable{

	public static void main(String[] args){
		JFrame mainFrame = new JFrame();

		mainFrame.setVisible(true);

		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setSize(1000, 750);


		LayerManager lm = new LayerManager();

		lm.addLayer(new Background(), 0);

		lm.addLayer(new Foreground(), 1);


		mainFrame.add(lm);


	}






}