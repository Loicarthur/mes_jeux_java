package connect_me;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class Niveaux {
    // ici on dessine linterface de niveaux ou lutilisateur va choisir le niveau quil veut jouer
	public void choisir(Graphics g, Input p) throws SlickException {
		int x = 1;

		Image img = new Image("image/GF.png");
		g.drawImage(img, 0, 0);
		g.setColor(Color.black);
		g.drawString("Choisissez un niveau", 210, 15);
		//ici on recupere les coordonnees de la souris
		int x1 = p.getMouseX();
		int y1 = p.getMouseY();
		if (x1 < 469 + 70 && x1 > 469 && y1 < 85 && y1 > 15) {
			g.setColor(Color.cyan);
			g.fillRoundRect(469, 15, 70, 70, 20);
		}
		Image img1 = new Image("image/home.png");
		g.drawImage(img1, 469, 15);
		g.setColor(Color.white);
//		g.fillRect(148, 52, 304, 304);
		for (int i = 148; i <= 304 + 148; i += 102) {
			for (int j = 52; j <= 304 + 52; j += 102) {
				if (x1 < i + 100 && x1 > i && y1 < j + 100 && y1 > j) {
					//ici on met un specifite de couleur pour savoir si le curseur la survole
					g.setColor(Color.cyan);
					g.fillRoundRect(i, j, 100, 100, 20);
				}
				g.setColor(new Color(251, 202, 14));
				g.fillRoundRect(i, j, 100, 100, 50);
				g.setColor(Color.black);
				g.drawString("" + x + "", ((i + i + 100 - 12) / 2), ((j + j + 100 - 19) / 2));
				x++;
			}
		}
	}

	public int[] quelleCase(int x, int y) {
		int tab[] = new int[2];
		for (int i = 148; i <= 304 + 148; i += 102) {
			for (int j = 52; j <= 304 + 52; j += 102) {
				if (x <= i + 100 && x >= i && y <= j + 100 && y >= j) {
					tab[0] = i;
					tab[1] = j;
				}
			}
		}
		return tab;
	}

}
