import javax.swing.JLayeredPane;
import java.util.ListIterator;
import java.util.LinkedList;


public class LayerManager extends JLayeredPane{

	private Layer[] layers;

	public LayerManager(){
		layers = new Layer[5];

		//Making every layer inside of layers equalivalent to null.
		for(int i = 0; i < 5; i++)
			layers[i] = null;

	}

	//Creates an inital layer at an inital depth.
	//This should only be called once per layer. This needs to be called before updateLayer
	public void addLayer(Layer layer, int depth){
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

	//YOU MUST HAVE ALREADY HAVE CALLED ADD LAYER ON THIS DEPTH OR THIS METHOD WILL NOT WORK!
	//This updates the layer given a new layer and a depth to add it to.
	public void updateLayer(Layer layer, int depth){
		if(depth == 0){
			setLayer(layer, JLayeredPane.DEFAULT_LAYER);
			layers[0] = layer;
		}
		else if(depth == 1){
			setLayer(layer, JLayeredPane.PALETTE_LAYER);
			layers[1] = layer;
		}
		else if(depth == 2){
			setLayer(layer, JLayeredPane.MODAL_LAYER);
			layers[2] = layer;
		}
		else if(depth == 3){
			setLayer(layer, JLayeredPane.POPUP_LAYER);
			layers[3] = layer;
		}
		else if(depth == 4){
			setLayer(layer, JLayeredPane.DRAG_LAYER);
			layers[4] = layer;
		}
		else{
			System.out.println("Not a correct depth. No layer has been added.");
		}
	}
}