package space.builder;

import space.core.Planet;
import space.core.SpaceObject;

public class PlanetBuilder extends MovingSpaceObjectBuilder {

	public PlanetBuilder(String name, SpaceObject parent) throws IllegalArgumentException {
		super(name, parent);
	}
	
	public PlanetBuilder radious(int r) {
		return (PlanetBuilder) super.circle(r);
	}
	
	public Planet build() {
		return new Planet(this);
	}
}
