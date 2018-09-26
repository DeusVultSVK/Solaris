
package space.core;

import javafx.scene.paint.Color;

import geom.Circle;
import space.builder.*;
@SuppressWarnings("restriction")
public class Planet extends MovingSpaceObject {

	public Planet(String name, SpaceObject parent, Color color, int size, int distance, double speed) {
		super(name, parent, color, new Circle(size), distance, speed);
	}
	
	public static class Builder extends MovingSpaceObjectBuilder {
		
		public Builder(String name,SpaceObject parent) throws IllegalArgumentException{
			super(name,parent);
		}
		
		public Builder radious(int radious) {
			area=new Circle(center,radious);
			return this;
		}
		
		public Planet build() {
			return new Planet(this);
		}
	}
	
	
	private Planet(SpaceObjectBuilder builder) {
		super(builder);
		
		if(!builder instanceof Planet.Builder)
		{
			
		}
		else {
			builder=(Planet.Builder) builder;
			super(builder.name,builder.parent,builder.color,builder.area,builder.distance,builder.speed);
			trabants=builder.trabants;
		}
	}
	
	
}
