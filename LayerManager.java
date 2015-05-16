import javax.swing.JLayeredPane;
import java.util.ListIterator;
import java.util.LinkedList;


public class LayerManager extends JLayeredPane{

	private Layer[] layers;
	private int numberOfLayers;

	public LayerManager(){
		layers = new Layer[5];
		numberOfLayers = 0;
	}
	public void addLayer(Layer layer, int depth){

		//Add the collision linked list to a array of linked list iterators.
		//Retrieve the collision linked list iterator from the Layer object.


		if(depth == 0){
			layer.setBounds(0, 0, GameControl.getFrameWidth(), GameControl.getFrameHeight());
			add(layer, JLayeredPane.DEFAULT_LAYER);
			layers[0] = layer;
		}
		else if(depth == 1){
			layer.setBounds(0, 0, GameControl.getFrameWidth(), GameControl.getFrameHeight());
			add(layer, JLayeredPane.PALETTE_LAYER);
			layers[1] = layer;
		}
		else if(depth == 2){
			layer.setBounds(0, 0, GameControl.getFrameWidth(), GameControl.getFrameHeight());
			add(layer, JLayeredPane.MODAL_LAYER);
			layers[2] = layer;
		}
		else if(depth == 3){
			layer.setBounds(0, 0, GameControl.getFrameWidth(), GameControl.getFrameHeight());
			add(layer, JLayeredPane.POPUP_LAYER);
			layers[3] = layer;
		}
		else if(depth == 4){
			layer.setBounds(0, 0, GameControl.getFrameWidth(), GameControl.getFrameHeight());
			add(layer, JLayeredPane.DRAG_LAYER);
			layers[4] = layer;
		}
		else{
			System.out.println("Not a correct depth. No layer has been added.");
		}
	}
	public ListIterator<GameBlock> getIteratorOfLayer(int depthIndex){
		return layers[depthIndex].getIteratorOfCollisionRectangles();
	}
	public LinkedList<GameBlock> getCollisionList(int depthIndex){
		return layers[depthIndex].getListOfCollisionRectangles();
	}




}