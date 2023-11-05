package connect_me;


import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;


public class Main {

	public static void main(String[] args) throws SlickException {
//		 TODO Auto-generated method stub
		Connect jeu = new Connect("Mon jeu");
		AppGameContainer app = new AppGameContainer(jeu);
		app.setTargetFrameRate(60);
		app.setShowFPS(false);
		app.setDisplayMode(600, 408, false);
		app.start();
	}

}
