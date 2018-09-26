package space.builder;

import java.util.LinkedList;
import java.util.List;

import geom.BaseArea;
import geom.Circle;
import geom.Point;
import geom.Rectangle;
import javafx.scene.paint.Color;
import space.core.MovingSpaceObject;

@SuppressWarnings("restriction")
public abstract class SpaceObjectBuilder {
	protected final String name;
	protected BaseArea area;
	protected Point center;
	protected Color color= Color.BLACK;
	public List<MovingSpaceObject> trabants = new LinkedList<MovingSpaceObject>();
	
	public SpaceObjectBuilder(String name) throws IllegalArgumentException{
		if(name==null||name.isEmpty())
			throw new IllegalArgumentException("Name cannot be null or empty");
		this.name=name;
	}
	
	protected SpaceObjectBuilder center(Point p) {
		center=p;
		return this;
	}
	
	public SpaceObjectBuilder trabant(MovingSpaceObject val){ 
		trabants.add(val); 
		return this;
	}
	
	protected SpaceObjectBuilder circle(int radious) {
		area= new Circle(center,radious);
		return this;
	}
	
	protected SpaceObjectBuilder rect(int xSize, int ySize) {
		area=new Rectangle(center, xSize, ySize);
		return this;
	}
	
	public SpaceObjectBuilder color(Color col) {
		color=col;
		return this;
	}

}
