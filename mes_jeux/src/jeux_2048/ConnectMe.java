package jeux_2048;

import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class ConnectMe extends BasicGame {
	Plateau p;
	private long gameTime = System.currentTimeMillis();

	public ConnectMe(String title) {
		super(title);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void render(GameContainer arg0, Graphics arg1) throws SlickException {
		// TODO Auto-generated method stub
		p.dessinerplateau();
		p.dessinerpiece();
		p.showInfo();
		if(p.partieFinie()==true) {
			p.affichage("Jeu terminé");
		}else {
			p.affichage("Jeu en cours");
		}
//		p.showLevel();
	}

	@Override
	public void init(GameContainer arg0) throws SlickException {
		// TODO Auto-generated method 
		p = new Plateau(arg0.getGraphics());
	}

	@Override
	public void update(GameContainer arg0, int arg1) throws SlickException {
		Input in = arg0.getInput();
		if(System.currentTimeMillis() - gameTime >= 500) {
			if(in.isKeyPressed(Input.KEY_UP)) {
				p.Up();
				p.add();			
			}else if(in.isKeyPressed(Input.KEY_DOWN)) {
				p.Down();
				p.add();
			}else if(in.isKeyPressed(Input.KEY_LEFT)) {
				p.Left();
				p.add();
			}else if(in.isKeyPressed(Input.KEY_RIGHT)) {
				p.Right();
				p.add();
			}else if(in.isKeyPressed(Input.KEY_F1)) {
				p.removeAll();
				p = new Plateau(arg0.getGraphics());
				p.dessinerplateau();
				p.dessinerpiece();
				p.showInfo();
				if(p.partieFinie()==true) {
					p.affichage("Jeu terminé");
				}else {
					p.affichage("Jeu en cours");
				}
			}
			gameTime = System.currentTimeMillis();
		}
		
	}
	

}
