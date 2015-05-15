import javax.swing.JLayeredPane;



public class LayerManager extends JLayeredPane{

	Layer[] layers;

	public LayerManager(){
		layers = new Layer[5];
	}
	public void addLayer(Layer layer, int depth){

		if(depth == 0){
			layer.setBounds(0,0, 1000, 750);
			add(layer, JLayeredPane.DEFAULT_LAYER);
			layers[0] = layer;
		}
		else if(depth == 1){
			layer.setBounds(0, 0, 1000, 7500);
			add(layer, JLayeredPane.PALETTE_LAYER);
			layers[1] = layer;
		}
		else if(depth == 2){
			layer.setBounds(0,0, 1000, 750);
			add(layer, JLayeredPane.MODAL_LAYER);
			layers[2] = layer;
		}
		else if(depth == 3){
			layer.setBounds(0,0, 1000, 750);
			add(layer, JLayeredPane.POPUP_LAYER);
			layers[3] = layer;
		}
		else if(depth == 4){
			layer.setBounds(0,0, 1000, 750);
			add(layer, JLayeredPane.DRAG_LAYER);
			layers[4] = layer;
		}
		else{
			System.out.println("Not a correct depth. No layer has been added.");
		}
	}




}