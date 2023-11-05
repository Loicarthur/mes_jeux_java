package connect_me;

import java.util.ArrayList;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Carre {
	private int x;
	private int y;
	private int type;
	private int ligne = y * 82;
	private int colonne = x * 82;
	private Image image;
	ArrayList<int[]> cote0 = new ArrayList<int[]>();
	ArrayList<int[]> cote1 = new ArrayList<int[]>();
	ArrayList<int[]> cote2 = new ArrayList<int[]>();
	ArrayList<int[]> cote3 = new ArrayList<int[]>();

	public Carre(int x, int y, int type) throws SlickException {
		this.setX(x);
		this.setY(y);
		this.setType(type);
		this.ligne = y * 82;
		this.colonne = x * 82;
	}
	
	public void supTrait() {
		cote0.removeAll(cote0);
		cote1.removeAll(cote1);
		cote2.removeAll(cote2);
		cote3.removeAll(cote3);
	}

	//Methode permettant de generer des trait sur les carrés via les coordonnés et les stocke dans une liste
	//pour pourvoir dessiner les traits en fonction des coordonées on se base ainsi sur une representation geometrique
	//pour calculer les coordonnées de chaque trait de connection
	public void creerTrait(int cote, int nblien) {
		// links = new boolean[12];
		int x0 = this.x * 82 + 10;
		int y0 = (this.y * 82);
		int y1 = this.y * 82 + 10;
		int x1 = (this.x + 1) * 82 - 12;
		int x2 = this.x * 82 + 10;
		int y2 = (this.y + 1) * 82 - 12;
		int y3 = this.y * 82 + 10;
		int x3 = this.x * 82 - 1;

		if (cote == 0) {
			if (nblien == 1) {
				int[] tab0 = { x0 + 14, y0 };
				this.cote0.add(tab0);
			} else if (nblien == 2) {
				int[] tab0 = { x0 + 24, y0 };
				this.cote0.add(tab0);
				int[] tab1 = { x0 + 34, y0 };
				this.cote0.add(tab1);
			} else if (nblien == 3) {
				int[] tab0 = { x0 + 14, y0 };
				cote0.add(tab0);
				int[] tab1 = { x0 + 24, y0 };
				cote0.add(tab1);
				int[] tab2 = { x0 + 34, y0 };
				cote0.add(tab2);
			} else if (nblien == 4) {
				int[] tab0 = { x0 + 14, y0 };
				cote0.add(tab0);
				int[] tab1 = { x0 + 24, y0 };
				cote0.add(tab1);
				int[] tab2 = { x0 + 34, y0 };
				cote0.add(tab2);
				int[] tab3 = { x0 + 44, y0 };
				cote0.add(tab3);
			}

		} else if (cote == 1) {
			if (nblien == 1) {
				int[] tab4 = { x1, y1 + 14 };
				cote1.add(tab4);
			} else if (nblien == 2) {
				int[] tab3 = { x1, y1 + 24 };
				cote1.add(tab3);
				int[] tab5 = { x1, y1 + 34 };
				cote1.add(tab5);
			} else if (nblien == 3) {
				int[] tab3 = { x1, y1 + 14 };
				cote1.add(tab3);
				int[] tab4 = { x1, y1 + 24 };
				cote1.add(tab4);
				int[] tab5 = { x1, y1 + 34 };
				cote1.add(tab5);
			} else if (nblien == 4) {
				int[] tab3 = { x1, y1 + 14 };
				cote1.add(tab3);
				int[] tab4 = { x1, y1 + 24 };
				cote1.add(tab4);
				int[] tab5 = { x1, y1 + 34 };
				cote1.add(tab5);
				int[] tab6 = { x1, y1 + 44 };
				cote1.add(tab6);
			}

		} else if (cote == 2) {
			if (nblien == 1) {
				int[] tab7 = { x2 + 14, y2 };
				cote2.add(tab7);
			} else if (nblien == 2) {
				int[] tab6 = { x2 + 24, y2 };
				cote2.add(tab6);
				int[] tab8 = { x2 + 34, y2 };
				cote2.add(tab8);
			} else if (nblien == 3) {
				int[] tab6 = { x2 + 14, y2 };
				cote2.add(tab6);
				int[] tab7 = { x2 + 24, y2 };
				cote2.add(tab7);
				int[] tab8 = { x2 + 34, y2 };
				cote2.add(tab8);
			} else if (nblien == 4) {
				int[] tab6 = { x2 + 14, y2 };
				cote2.add(tab6);
				int[] tab7 = { x2 + 24, y2 };
				cote2.add(tab7);
				int[] tab8 = { x2 + 34, y2 };
				cote2.add(tab8);
				int[] tab9 = { x2 + 44, y2 };
				cote2.add(tab9);
			}

		} else if (cote == 3) {
			if (nblien == 1) {
				int[] tab10 = { x3, y3 + 14 };
				cote3.add(tab10);
			} else if (nblien == 2) {
				int[] tab9 = { x3, y3 + 24 };
				cote3.add(tab9);
				int[] tab11 = { x3, y3 + 34 };
				cote3.add(tab11);
			} else if (nblien == 3) {
				int[] tab9 = { x3, y3 + 14 };
				cote3.add(tab9);
				int[] tab10 = { x3, y3 + 24 };
				cote3.add(tab10);
				int[] tab11 = { x3, y3 + 34 };
				cote3.add(tab11);
			} else if (nblien == 4) {
				int[] tab9 = { x3, y3 + 14 };
				cote3.add(tab9);
				int[] tab10 = { x3, y3 + 24 };
				cote3.add(tab10);
				int[] tab11 = { x3, y3 + 34 };
				cote3.add(tab11);
				int[] tab12 = { x3, y3 + 44 };
				cote3.add(tab12);
			}
		}
	}

	public int getLigne() {
		return ligne;
	}

	public void setLigne(int ligne) {
		this.ligne = ligne;
	}

	public int getColonne() {
		return colonne;
	}

	public void setColonne(int colonne) {
		this.colonne = colonne;
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

	public int getType() {
		return type;
	}
	
	
	//methode de modification qui agit en mee temps sur le type de la piece et son image
	public void setType(int type) throws SlickException {
		this.type = type;
		if (type == 0)
			this.image = new Image("image/BR.png");
		else if (type == 1)
			this.image = new Image("image/BVO.png");
		else if (type == 2)
			this.image = new Image("image/BV.png");
		else if (type == 3)
			this.image = new Image("image/BB.png");
		else if (type == 4)
			this.image = new Image("image/BO.png");
	}

	public Image getImage() {
		return image;
	}

	//creation des trais en fonction du nombre de cote et du nombre
	//de traits par cote
	void deuxCote(int c1, int c2, int t1, int t2) {
		this.creerTrait(c1, t1);
		this.creerTrait(c2, t2);
	}

	//----------//-----------
	void troisCote(int c1, int c2, int c3, int t1, int t2, int t3) {
		this.creerTrait(c1, t1);
		this.creerTrait(c2, t2);
		this.creerTrait(c3, t3);
	}

	//-------------//---------
	void quatreCote(int c1, int c2, int c3, int c4, int t1, int t2, int t3, int t4) {
		this.creerTrait(c1, t1);
		this.creerTrait(c2, t2);
		this.creerTrait(c3, t3);
		this.creerTrait(c4, t4);
	}

	//methode permettant de connaitre si une piece est dans une case ou pas
	boolean etreDans(int x, int y) {
		boolean est = false;
		if (this.colonne <= x * 82 + 80 && this.colonne >= x * 82 && this.ligne <= y * 82 + 80
				&& this.ligne >= y * 82) {
			est = true;
		}
		return est;
	}

	//methode pour dessiner les pieces avec leurs liens en fonction de leurs type et de leurs nombre de lien
	public void dessiner(Graphics g) {
		g.drawImage(this.getImage(), colonne + 10, ligne + 10);
		g.setColor(Color.white);
		for (int i = 0; i < cote0.size(); i++) {
			if (cote0.get(i) != null) {
//				g.drawLine(cote0.get(i)[0], cote0.get(i)[1], cote0.get(i)[0], cote0.get(i)[1] - 10);
				g.fillRect(cote0.get(i)[0], cote0.get(i)[1], 2, 11);
			}
		}
		for (int i = 0; i < cote1.size(); i++) {
			if (cote1.get(i) != null) {
//				g.drawLine(cote1.get(i)[0], cote1.get(i)[1], cote1.get(i)[0] + 10, cote1.get(i)[1]);
				g.fillRect(cote1.get(i)[0], cote1.get(i)[1], 11, 2);
			}
		}
		for (int i = 0; i < cote2.size(); i++) {
			if (cote2.get(i) != null) {
//				g.drawLine(cote2.get(i)[0], cote2.get(i)[1], cote2.get(i)[0], cote2.get(i)[1] + 10);
				g.fillRect(cote2.get(i)[0], cote2.get(i)[1], 2, 11);
			}
		}
		for (int i = 0; i < cote3.size(); i++) {
			if (cote3.get(i) != null) {
//				g.drawLine(cote3.get(i)[0], cote3.get(i)[1], cote3.get(i)[0] - 10, cote3.get(i)[1]);
				g.fillRect(cote3.get(i)[0], cote3.get(i)[1], 11, 2);
			}
		}
	}


}
