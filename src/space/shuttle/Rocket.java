/**
 * @Author Leonhard Applis
 * @Created 31.08.2018
 * @Package space.shuttle
 */
package space.shuttle;

import interfaces.CollidingObject;
import interfaces.DestructibleObject;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import space.effect.Explosion;

@SuppressWarnings("restriction")
public class Rocket extends Missile implements DestructibleObject {

	public Rocket(String name, SpaceShuttle emitter, int size) {
		super(name, emitter, size);
		color=Color.FIREBRICK;
	}
	
	public Rocket(String name, SpaceShuttle emitter, int size,double rotation, int speed) {
		super(name, emitter, size,rotation,speed);
		color=Color.FIREBRICK;
	}
	
	@Override
	public void destruct(CollidingObject other) {
		System.out.println(name+" collided with " + other.toString());
		new Explosion("Explosion from "+name, x, y,1000, size*3, 1.02, Color.FIREBRICK);
		remove();
	}
	
	@Override
	public void draw(GraphicsContext gc) {
		gc.setFill(color);
		gc.fillRect(x-size/2,y-size/2, size, size);
	}
}
