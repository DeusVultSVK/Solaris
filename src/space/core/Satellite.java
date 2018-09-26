package space.core;

import java.util.LinkedList;
import java.util.List;

import geom.Rectangle;
import interfaces.logical.CollidingObject;
import interfaces.logical.DestructibleObject;
import javafx.scene.paint.Color;
import space.effect.Explosion;

@SuppressWarnings("restriction")
public class Satellite extends MovingSpaceObject implements DestructibleObject{
	private SpaceObject parent;
	
	protected Satellite(String name, SpaceObject parent, int size, int distance, double speed) {
		super(name, parent,null, new Rectangle(size,size), distance, speed);
		this.parent=parent;
	}
	
	@Override 
	public void rotate() {
		if(parent!=null)
			rotation=degreeTo(parent);
	}
	
	@Override
	public void remove() {
		parent.trabants.remove(this);
		parent=null;		
	}
	@Override
	public void destruct(CollidingObject other) {
		new Explosion("Explosion from" + name,center.x,center.y,800,6,1.03,Color.FIREBRICK);
		if(parent!=null)
			remove();
	}
	
	public static class Builder {
		private final String name;
		private SpaceObject parent;
		private Color color= Color.BLACK;
		private int distance = 0, xSize = 0, ySize=0, levelOfDetail=2;
		private double speed = 0;
		private List<MovingSpaceObject> trabants = new LinkedList<MovingSpaceObject>();
		
		public Builder(String name,SpaceObject parent) throws IllegalArgumentException{
			if(name==null||name.isEmpty())
				throw new IllegalArgumentException("Name cannot be null or empty");
			if(parent==null)
				throw new IllegalArgumentException("Parent cannot be null");
			this.name=name;
			this.parent=parent;
		}
		
		public Builder color(Color val){ 
			color= val; 
			return this;
		}
		
		public Builder distance(int val){ 
			if(val<0)
				throw new IllegalArgumentException("Distance cannot be negative");
			distance= val; 
			return this;
		}
		
		public Builder size(int xSize, int ySize){
			if(xSize<0||ySize<0)
				throw new IllegalArgumentException("Size cannot be negative");
			this.xSize=xSize;
			this.ySize=ySize;
			return this;
		}
		
		public Builder speed(double val){
			speed= val; 
			return this;
		}
		
		public Builder levelOfDetail(int val){ 
			if(val<0)
				throw new IllegalArgumentException("LoD cannot be negative");
			levelOfDetail= val; 
			return this;
		}
		
		public Builder trabant(MovingSpaceObject val){ 
			trabants.add(val); 
			return this;
		}
		
		public Satellite build() {
			return new Satellite(this);
		}
	}
	
	private Satellite(Builder builder) {
		super(builder.name,builder.parent,builder.color,new Rectangle(builder.xSize,builder.ySize),builder.distance,builder.speed);
		trabants=builder.trabants;
		area.levelOfDetail=builder.levelOfDetail;
	}
}
