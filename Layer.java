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
		listOfCollisionRectangles = new LinkedList<GameBlock>();
		listOfRectanglesToBePainted = new LinkedList<GameBlock>();
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
	public void updateRectangle(GameBlock oldRectangle, GameBlock newRectangle){

		boolean isRectInCollision = false;

		//Check if it is  a collision rectangle.
		ListIterator<GameBlock> itrColl = listOfCollisionRectangles.listIterator();

		while(itrColl.hasNext()){
			//If the GameBlock found within the iterator is equivalent id wise to the inputted oldRectangle, then the old rectangle
			//needs to removed from both the listOfCollisionRectangles and also listOfRectanglesToBePainted. The newRectangle
			//will then needed to be added to both of these list.
			if(itrColl.next().isEquals(oldRectangle)){//RETURNS TRUE, then the oldRectangle was a collision rectangle.
				isRectInCollision = true;
			}
		}
		if(isRectInCollision){ //remove the oldRectangle from the list of listOfCollisionRectangles and add the newRectangle to that list.
			listOfCollisionRectangles.remove(oldRectangle);
			listOfCollisionRectangles.add(newRectangle);
			listOfRectanglesToBePainted.remove(oldRectangle);
			listOfRectanglesToBePainted.add(newRectangle);
		}
		else{ //This means that the oldRectangle was a non-collision rectangle. Only the list named listOfRectanglesToBePainted needs to be updated.
			listOfRectanglesToBePainted.remove(oldRectangle);
			listOfRectanglesToBePainted.add(newRectangle);
		}
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
	public LinkedList<GameBlock> getListOfCollisionRectangles(){
		return listOfCollisionRectangles;
	}
	public LinkedList<GameBlock> getListOfAllRectangles(){
		return listOfRectanglesToBePainted;
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