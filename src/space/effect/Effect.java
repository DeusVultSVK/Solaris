package space.effect;

import interfaces.DrawingObject;
import interfaces.RemovableObject;
import interfaces.UpdatingObject;
import javafx.scene.canvas.GraphicsContext;
import logic.EffectManager;

@SuppressWarnings("restriction")
public abstract class Effect implements UpdatingObject, DrawingObject, RemovableObject{
	
	protected String name;
	protected int x,y;
	protected double size;
	
	public Effect(String name, int x, int y, double size){
		this.name = name;
		this.x = x;
		this.y = y;
		this.size = size;
		EffectManager.getInstance().addEffect(this);
	}
	
	public void remove() {
		EffectManager.getInstance().removeEffect(this);
	}
	
	public void update() {}
	
	public void draw(GraphicsContext gc) {}
	
	@Override
	public String toString() {return name+"@"+x+"|"+y;}
	public int getX() {return x;}
	public int getY() {return y;}
	public String getName() {return name;}
	public double getSize() {return size;}
	
}
