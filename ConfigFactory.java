package config;

import org.json.JSONObject;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class ConfigFactory implements KeyListener {
	
	static public Config read(String path) {
		if(!path.endsWith(".json"))
			throw new IllegalArgumentException("Faulty Path!");
		try {
			Path castedPath = Paths.get(path);
			List<String> allLines = Files.readAllLines(castedPath);
			
			String completeFile = "";
			for(String line : allLines)
				completeFile+=line;
			JSONObject read = new JSONObject(completeFile);
			return new Config(path,read);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	static public void save(Config config) {
		if(config.path==null||config.path=="")
			return;
		try {
			File f = new File(config.path);
			if(!f.exists())
				f.createNewFile();
			FileWriter fW = new FileWriter(f);
			config.toJSON().write(fW);
			fW.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	static public void saveConfigTo(Config config, String path) {
		if(!path.endsWith(".json"))
			path+="/configSave.json";
		try {
			File f = new File(path);
			if(!f.exists())
				f.createNewFile();
			FileWriter fW = new FileWriter(f);
			config.toJSON().write(fW);
			fW.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	static public void shutDown(Config config){
		if(config.path==null||config.path=="")
			return;

		File file = new File(config.path);
		if (file.exists()) {
			ConfigFactory.save(config);
			System.exit(0);

		}




	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e){
		if ((e.getKeyCode() == KeyEvent.VK_ESCAPE)) {
			System.out.println("woot!");
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

}



