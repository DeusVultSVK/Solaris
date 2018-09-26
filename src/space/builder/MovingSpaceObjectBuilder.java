package space.builder;

import space.core.SpaceObject;

public abstract class MovingSpaceObjectBuilder extends SpaceObjectBuilder{
	
	protected int distance=0;
	protected double speed=0, rotationspeed=0;
	protected SpaceObject parent;
	
	public MovingSpaceObjectBuilder(String name,SpaceObject parent) throws IllegalArgumentException{
		super(name);
		if(parent==null)
			throw new IllegalArgumentException("Parent cannot be null");
		this.parent=parent;
	}
	
	public MovingSpaceObjectBuilder distance(int d) {
		distance=d;
		return (MovingSpaceObjectBuilder)this;
	}
	
	public MovingSpaceObjectBuilder speed(double s) {
		speed=s;
		return (MovingSpaceObjectBuilder)this;
	}
	public MovingSpaceObjectBuilder rotationspeed(double rs) {
		rotationspeed=rs;
		return (MovingSpaceObjectBuilder)this;
	}
}
