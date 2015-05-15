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
	public void addCollisionRectangle(GameBlock newCollisionRectangle){
		listOfCollisionRectangles.add(newCollisionRectangle);
		listOfRectanglesToBePainted.add(newCollisionRectangle);
		numberOfRectangles++;
	}
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
	public ListIterator<GameBlock> getIteratorOfCollisionRectangles(){
		return listOfCollisionRectangles.listIterator();
	}
	public ListIterator<GameBlock> getIteratorOfToBePaintedRectangles(){
		return listOfRectanglesToBePainted.listIterator();
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