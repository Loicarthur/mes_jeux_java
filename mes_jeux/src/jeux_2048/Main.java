package jeux_2048;


import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

public class Main {

	public static void main(String[] args) throws SlickException {
//		 TODO Auto-generated method stub
		ConnectMe jeu = new ConnectMe("Mon jeu");
		AppGameContainer app = new AppGameContainer(jeu);
		app.setTargetFrameRate(60);
		app.setShowFPS(false);
		app.setDisplayMode(500, 400, false);
		app.start();
	}

}
