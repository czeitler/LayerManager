import java.awt.Canvas;
import java.awt.Rectangle;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.LinkedList;
import java.util.ListIterator;

public abstract class Layer extends Component{

	protected LinkedList<GameBlock> listOfCollisionRectangles;
	protected LinkedList<GameBlock> listOfRectanglesToBePainted;
	protected int numberOfRectangles;

	public Layer(){
		listOfCollisionRectangles = new LinkedList();
		listOfRectanglesToBePainted = new LinkedList();
		numberOfRectangles = 0;
	}
	//Adds a collision rectangle to the layer space. This puts it in two linked list, listOfCollisionRectangles and listOfRectanglesToBePainted.
	//Collision rectangles from the linked list will not be painted directly from that linked list. They are also stored in listOfRectanglesToBePainted
	//which is how they are painted. Therefore when updating the look and display of the program, you only need to manipulate the listOfRectanglesToBePainted
	//linked list. When you need to make sure the collision dimensions move as well, you need to manipulate the listOfCollisionRectangles linked list.
	public void addCollisionRectangle(GameBlock newCollisionRectangle){
		listOfCollisionRectangles.add(newCollisionRectangle);
		listOfRectanglesToBePainted.add(newCollisionRectangle);
		numberOfRectangles++;
	}
	//Adds a non collision rectangle to the layer space. This puts it in a linked list that needs to be modified every time the user updates a component within the layer.
	public void addNonCollisionRectangle(GameBlock newNonCollisionRectangle){
		listOfRectanglesToBePainted.add(newNonCollisionRectangle);
		numberOfRectangles++;
	}

	//Given a rectangle, check if the given rectangle collides with any of the listOfCollisionRectangles
	public boolean checkCollision(GameBlock rect){
		ListIterator<GameBlock> listIteratorOfCollisionRectangles = listOfCollisionRectangles.listIterator();
		while(listIteratorOfCollisionRectangles.hasNext() == true){
			if(listIteratorOfCollisionRectangles.next().getBounds().intersects(rect)){
				return true;
			}
		}
	return false;
	}
	public abstract void updatePaintRectList(GameBlock oldBlock, GameBlock newBlock);
	public abstract void updateCollRectList(GameBlock oldBlock, GameBlock newBlock);



	//Returns the linked list that holds all of the collision rectangles.
	public LinkedList<GameBlock> getListOfCollisionRectangles(){
		return listOfCollisionRectangles;
	}
	//Returns the linked list that holds all of the painted rectangles.
	public LinkedList<GameBlock> getListOfAllRectangles(){
		return listOfRectanglesToBePainted;
	}
	//We need a method that will paint every single rectangle inside of the listOfRectanglesToBePainted.
	public void paint (Graphics g){
		super.paint(g);

		Graphics2D g2d = (Graphics2D) g;
		ListIterator<GameBlock> tempIterator = listOfRectanglesToBePainted.listIterator();

		for(int i = 0; i < numberOfRectangles; i++){
			GameBlock tempGameBlock = tempIterator.next();

			//Paint everything according to the data stored in tempGameBlock

			g2d.translate(tempGameBlock.getDisplacementX(), tempGameBlock.getDisplacementY()); //For every translate, you need to undo the translate so it goes back to origin.

			g2d.setColor(tempGameBlock.getColorOfGameBlock());

			g2d.draw(tempGameBlock.getRectangle());
			g2d.fill(tempGameBlock.getRectangle());

			g2d.translate(-tempGameBlock.getDisplacementX(), -tempGameBlock.getDisplacementY()); //For every translate, you need to undo the translate so it goes back to origin.

		}
	}
}