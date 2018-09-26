package space.effect;

import interfaces.DrawingObject;
import interfaces.logical.RemovableObject;
import interfaces.logical.UpdatingObject;
import javafx.scene.canvas.GraphicsContext;
import logic.EffectManager;

@SuppressWarnings("restriction")
public abstract class Effect implements UpdatingObject, DrawingObject, RemovableObject{
	
	String name;
	int x,y;
	double size;
	
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
	
	public boolean isCovered(int x, int y) {
		return
				y>=this.y-size && y<=this.y+size
			&&	x>=this.x-size && x<=this.x+size;
	}
	
	@Override
	public String toString() {return name+"@"+x+"|"+y;}
}
