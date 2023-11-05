package connect_me;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

//Interface d'acceuil pour lutilisateur la ou il choisi de jouer ou pas

public class Acceuil {
	private Image img;
	private Image imgp;
	private Image imgg;
	private Image imgc;

	public Acceuil(Graphics g) throws SlickException {
		img = new Image("image/AF.png");
		imgp = new Image("image/play.png");
		imgg = new Image("image/game.png");
		imgc = new Image("image/credits.png");
	}

	void acceuil(Graphics g, Input p) {
		g.drawImage(img, 0, 0);
		//ici on creer un fond pour les options survolles par la souris 
		int x1 = p.getMouseX();
		int y1 = p.getMouseY();
		if (x1 < 350 && x1 > 250 && y1 < 214 && y1 > 164) {
			g.setColor(Color.black);
			g.fillRoundRect(249, 163, 101, 51, 20);
		}
		if (x1 < 350 && x1 > 250 && y1 < 214 + 82 && y1 > 164 + 82) {
			g.setColor(Color.black);
			g.fillRoundRect(248, 162 + 82, 102, 52, 20);
		}
		g.drawImage(imgp, 250, 164);
		g.drawImage(imgc, 250, 164 + 82);
		g.drawImage(imgg, 175, 50);
	}

	

	

}
