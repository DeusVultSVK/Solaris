package space;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class MovingSpaceObject extends SpaceObject {
	
	
	protected int distance;
	protected double speed, relativePos; //Pos in radiant-degree to parent
	protected Color color;
	//Init Relative to parent
	//Add to parents Trabants
	@SuppressWarnings("restriction")
	public MovingSpaceObject(String name,SpaceObject parent,Color color, int size,int distance, double speed) {
		super(name,parent.getX()+distance,parent.getY()+distance,size);
		
		this.distance=distance;
		this.speed=speed;
		this.color=color;
		relativePos=0;
		// MAYBE:
		parent.addTrabant(this);
	}
	@SuppressWarnings("restriction")
	public void update(GraphicsContext gc,int parentX, int parentY) {
		move(parentX,parentY);
		super.update(gc);
	}
	
	protected void move(int parentX, int parentY) {
		// rotate relative position
		relativePos+=speed;
		if (relativePos >= Math.PI*2)
			relativePos -=  Math.PI*2;
		
		x = parentX+ (int)(Math.sin(relativePos)*distance);
		y = parentY+ (int)(Math.cos(relativePos)*distance);
		//Change my Koords, according to parent, distance and speed
	};
	
	@Override
	protected void draw(GraphicsContext gc) {
		gc.setFill(color);
		//change so the center is drawn, not the edgepoint
		gc.fillOval(x-size/2, y-size/2, size/2, size/2);
	}
}
