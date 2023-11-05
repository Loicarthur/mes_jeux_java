package jeux_2048;


import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Case {
	int x, y;
	int valeur;
	Image image;
	Graphics g;

	public Case(Graphics g, int x, int y, int valeur) throws SlickException {
		this.x = x;
		this.y = y;
		this.g = g;
		this.setValeur(valeur);
		
	}

	public Graphics getG() {
		return g;
	}

	public void setG(Graphics g) {
		this.g = g;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getValeur() {
		return valeur;
	}

	public void setValeur(int valeur) throws SlickException {
		if (valeur == 2 || valeur == 2) {
			this.image = new Image("image/cc.png");
		}else
		if(valeur ==4) {
			this.image = new Image("image/cb.png");	
		}else
		if (valeur == 8) {
			this.image = new Image("image/cr.png");
		}else
		if (valeur == 16) {
			this.image = new Image("image/cv.png");
		}else
		if (valeur == 32) {
			this.image = new Image("image/cj.png");
		}else
		if (valeur == 64 || valeur == 128) {
			this.image = new Image("image/co.png");
		}else
		if (valeur >= 256) {
			this.image = new Image("image/cvo.png");
		}
		this.valeur = valeur;
	}

	public Image getImage() {
		return image;
	}

	public void dessiner(Graphics g) {
		g.drawImage(this.getImage(), this.y*82 + 10, this.x*82 + 10);
		g.setColor(Color.white);
		g.drawString(""+this.valeur+"", ((y + y)*82 + 80 - 12) / 2, ((x + x)*82 + 80 - 19) / 2);
		//ici on dessine sur le carreau sa valeur et on le recentre en tenant compte de la taille du caractere
	}

	public void setImage(Image image) {
		this.image = image;
	}

}
