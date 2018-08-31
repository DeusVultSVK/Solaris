package logic;

import space.*;
import space.advanced.AsteroidBelt;
import space.advanced.DistantGalaxy;
import space.core.Planet;
import space.core.Satellite;
import space.core.Star;
import space.shuttle.ShuttleNavigator;
import space.shuttle.SpaceShuttle;

import java.util.Timer;
import java.util.TimerTask;

import javafx.application.*;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.canvas.*;
import javafx.scene.paint.Color;
@SuppressWarnings("restriction")
public class Program extends Application{
	
	private UpdateManager updateManager;
	
	public static void main(String[] args) {
		System.out.println("Starting Solaris");
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		Group root = new Group();
        Canvas canvas = new Canvas();
        root.getChildren().add(canvas);
       
        Scene scene = new Scene(root,1200 , 600);
        
        GraphicsContext gc = canvas.getGraphicsContext2D();

        UpdateManager.getInstance().initUpdateManager(25, gc);
        updateManager = UpdateManager.getInstance();
        
        initSpace();
        //Listeners for resize
        //scene.widthProperty().addListener(evt -> drawAll(gc));
        //scene.heightProperty().addListener(evt -> drawAll(gc));
	
        canvas.widthProperty().bind(scene.widthProperty());
        canvas.heightProperty().bind(scene.heightProperty());
        
        primaryStage.setTitle("Solaris");
        primaryStage.setScene(scene);
        primaryStage.show();
	}
	
	private void initSpace() {
		DistantGalaxy milkyway = new DistantGalaxy("MilkyWay",1200,800,250);
		
		//Sun Will be centered in the first update
		Star sun = new Star("Sun",Color.ORANGE,60);
		Planet earth = new Planet("Earth", sun, Color.CYAN, 25, 150, Math.PI/200);
		Planet mars = new Planet("Mars", sun, Color.INDIANRED, 35, 250, Math.PI/100);
		Planet moon = new Planet("Moon", earth, Color.LIGHTGRAY,10,30,Math.PI/80);
		
		Planet saturn = (new Planet.Builder("Saturn", sun))
							.size(45)
							.color(Color.LIGHTGOLDENRODYELLOW)
							.speed(Math.PI/1000)
							.distance(480)
							.build();
		
		AsteroidBelt andromeda = new AsteroidBelt("Andromeda",sun,350,Math.PI/2000,200);
		
		ShuttleNavigator nasa = new ShuttleNavigator.Builder("NASA")
				.shuttleName("Ikarus")
				.idlingTurns(2)
				.doesRespawn(true)
				.shuttlesize(4)
				.shuttleOrbitingDistance(40)
				.shuttleSpeed(Math.PI/85)
				.start(earth)
				.next(mars)
				.build();
		
		ShuttleNavigator AlienOverlord = new ShuttleNavigator.Builder("AlienOverlord")
				.shuttleName("Aliens")
				.doesRespawn(true)
				.shuttlesize(6)
				.shuttleOrbitingDistance(30)
				.shuttleSpeed(Math.PI/125)
				.start(mars)
				.next(earth)
				.next(sun)
				.next(earth)
				.build();
		
		Satellite Astra = new Satellite("Astra",earth,5,20, -Math.PI/100);
		
		Planet phobos = new Planet("Phobos", saturn, Color.LIGHTGRAY, 8, 70, -Math.PI/200);
		Planet deimos = new Planet("Deimos", saturn, Color.GRAY, 7, 50, Math.PI/50);

		updateManager.addSpaceObject(milkyway);
		updateManager.addSpaceObject(sun);
		updateManager.toUpdate.add(nasa);
	}
	
}
