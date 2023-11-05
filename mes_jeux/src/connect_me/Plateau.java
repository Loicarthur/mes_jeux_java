package connect_me;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class Plateau {

	Carre[][] carres = new Carre[5][5];
	int[] select = new int[2];
	Graphics g;

	//Constructeur d'instantiation permettant de mouler un plateau en fonction du niveau de jeux
	public Plateau(Graphics g, int x) throws SlickException {
		this.g = g;
		this.select[0] = -1;
		this.select[1] = -1;
		if (x ==1  || x==0) {
			this.niveau1();
		}
		if (x == 2) {
			this.niveau2();
		}
		if (x == 3) {
			this.niveau3();
		}
		if (x == 4) {
			this.niveau4();
		}
		if (x == 5) {
			this.niveau5();
		}
		if (x == 6) {
			this.niveau6();
		}
	}

	//Methode qui recupere la case pointee au coordonnees x et y
	int[] quelleCase(int x, int y) {
		int tab[] = new int[2];
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (x < i * 82 + 81 && x >= i * 82 && y < j * 82 + 81 && y >= j * 82) {
					tab[0] = i;
					tab[1] = j;
				}
			}
		}
		return tab;
	}

	//methode permettant de recentrer une piece dans sa case lors de son deplacement
	public void recentrer(Carre c) {
		for (int e = 0; e < 5; e++) {
			for (int f = 0; f < 5; f++) {
				if (c.etreDans(e, f)) {
					c.setX(e);
					c.setY(f);
					c.setColonne(c.getX() * 82);
					c.setLigne(c.getY() * 82);
				}
			}
		}
	}

	//methode pour pouvoir deplacer une piece sur la map
	void deplacerSurMap(Carre c) throws SlickException {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (c.getX() != i || c.getY() != j) {
					this.ajouterPiece(c);
				}
			}
		}
	}

	//Methode qui permet de savoir quelle case a ete cliquee en fonction de ses parametres
	void clicCase(int x, int y) {
		int i = quelleCase(x, y)[0];
		int j = quelleCase(x, y)[1];
		if (carres[i][j] != null) {
			select[0] = i;
			select[1] = j;
		} else {
			select[0] = -1;
			select[1] = -1;
		}
	}

	//Methode permettant de dessiner une case selectionnee
	//Lors de son deplacement
	void dessinerCaseSelectionnee() {
		if (select[0] != -1 && select[1] != -1 && carres[select[0]][select[1]] != null) {
			g.setColor(new Color(255, 0, 0, 128));
			g.fillRect(this.select[0], this.select[1], 80, 80);
			System.out.print(select[0]);
			System.out.println(select[1]);
			select[0] = -1;
			select[1] = -1;
		}
	}

	//Methode permettant de dessiner les pieces presentent sur le plateau
	void dessinerPiece() {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (carres[i][j] != null) {
					carres[i][j].dessiner(g);
				}
			}
		}
	}

	//methode permettant de dessiner le plateau de jeux sur lequel seront poseé les pieces
	public void dessinerplateau(Input p, int x) throws SlickException {
		Image img = new Image("image/GF.png");
		g.drawImage(img, 0, 0);
		g.setColor(new Color(98, 144, 200));
		for (int i = 0; i <= 408; i += 82) {
			for (int j = 0; j <= 408; j += 82) {
				g.setColor(new Color(7, 91, 129));
				g.fillRect(i, j, 80, 80);

			}
		}
		int x1 = p.getMouseX();
		int y1 = p.getMouseY();
		if (x1 < 469+70 && x1 > 469 && y1 < 85 && y1 > 15) {
			g.setColor(Color.cyan);
			g.fillRoundRect(469, 15, 70, 70,20);
		}
		Image img1 = new Image("image/home.png");
		g.drawImage(img1, 469, 15);
		g.setColor(Color.black);
		g.drawString("Niveau: "+x+"", 468, 100);
		g.drawString("Score: "+(x-1)*10+"", 468, 140);
	}

	//Methode permettant d'ajouter une piece a la map de pieces sur le plateau
	public void ajouterPiece(Carre carre) throws SlickException {
		carres[carre.getX()][carre.getY()] = carre;
	}

	//Methode permettant de vider un plateau de jeux afin den appeler un autre
	void toutEnlever() {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				this.carres[i][j] = null;
			}
		}
	}

	//Methode de niveau pour pouvoir generer chaque niveau apres validation 
	//ces methodes sont appeles dans le constructeur
	public void niveau1() throws SlickException {
		this.toutEnlever();
		Carre c1 = new Carre(0, 1, 0);
		Carre c2 = new Carre(3, 0, 2);
		c1.creerTrait(1, 2);
		c2.creerTrait(3, 2);
		ajouterPiece(c2);
		ajouterPiece(c1);
	}

	//----------//------------
	public void niveau2() throws SlickException {
		this.toutEnlever();
		Carre cR1 = new Carre(0, 1, 0);///// remettre 0
		Carre cR2 = new Carre(1, 1, 0);
		Carre cV1 = new Carre(3, 1, 2);
		Carre cV2 = new Carre(3, 3, 2);
		Carre cV3 = new Carre(1, 3, 2);
		cR1.deuxCote(1, 2, 3, 3);
		cR2.deuxCote(3, 1, 3, 2);
		cV1.deuxCote(0, 2, 3, 1);
		cV2.creerTrait(0, 1);
		cV3.creerTrait(3, 2);
		ajouterPiece(cV1);
		ajouterPiece(cV2);
		ajouterPiece(cV3);
		ajouterPiece(cR2);
		ajouterPiece(cR1);
	}

	//--------------//------------
	public void niveau3() throws SlickException {
		this.toutEnlever();
		Carre cR1 = new Carre(3, 0, 0);
		Carre cR2 = new Carre(4, 0, 0);
		Carre cV1 = new Carre(1, 1, 2);
		Carre cV2 = new Carre(0, 3, 2);
		Carre cV3 = new Carre(3, 3, 2);
		cR1.troisCote(1, 2, 3, 3, 2, 2);
		cR2.deuxCote(3, 2, 3, 4);
		cV1.deuxCote(0, 1, 2, 4);
		cV2.creerTrait(1, 2);
		cV3.deuxCote(0, 3, 4, 4);
		;
		ajouterPiece(cV1);
		ajouterPiece(cV2);
		ajouterPiece(cV3);
		ajouterPiece(cR2);
		ajouterPiece(cR1);
	}

	public void niveau4() throws SlickException {
		this.toutEnlever();
		Carre cR1 = new Carre(4, 3, 0);
		Carre cR2 = new Carre(4, 4, 0);
		Carre cV1 = new Carre(1, 1, 2);
		Carre cV2 = new Carre(2, 2, 2);
		Carre cV3 = new Carre(0, 4, 2);
		cR1.troisCote(0, 2, 3, 4, 4, 2);
		cR2.creerTrait(0, 4);
		;
		cV1.deuxCote(0, 1, 2, 2);
		cV2.deuxCote(1, 2, 3, 2);
		;
		cV3.deuxCote(2, 3, 4, 3);
		;
		ajouterPiece(cV1);
		ajouterPiece(cV2);
		ajouterPiece(cV3);
		ajouterPiece(cR2);
		ajouterPiece(cR1);
	}

	public void niveau5() throws SlickException {
		this.toutEnlever();
		Carre cR1 = new Carre(3, 0, 0);
		Carre cB1 = new Carre(3, 1, 3);
		Carre cB2 = new Carre(1, 2, 3);
		Carre cV1 = new Carre(0, 0, 2);
		Carre cV2 = new Carre(4, 4, 2);
		cR1.creerTrait(2, 3);
		cB2.creerTrait(0, 2);
		cB1.deuxCote(2, 3, 1, 3);
		cV2.deuxCote(1, 2, 1, 2);
		;
		cV1.deuxCote(0, 3, 2, 2);
		;
		ajouterPiece(cV1);
		ajouterPiece(cV2);
		ajouterPiece(cB1);
		ajouterPiece(cB2);
		ajouterPiece(cR1);
	}

	void niveau6() throws SlickException {
		this.toutEnlever();
		Carre cv1 = new Carre(1, 0, 2);
		Carre cv2 = new Carre(4, 1, 2);
		Carre cb2 = new Carre(1, 3, 3);
		Carre cb1 = new Carre(3, 2, 3);
		Carre cr1 = new Carre(3, 3, 0);
		Carre co = new Carre(0, 1, 4);
		cv1.troisCote(0, 1, 3, 1, 3, 2);
		cv2.deuxCote(1, 2, 4, 2);
		cb1.deuxCote(0, 3, 4, 4);
		cb2.deuxCote(2, 3, 2, 2);
		cr1.deuxCote(0, 3, 4, 3);
		co.troisCote(0, 1, 3, 1, 4, 4);
		ajouterPiece(cv1);
		ajouterPiece(cv2);
		ajouterPiece(cb1);
		ajouterPiece(cb2);
		ajouterPiece(cr1);
		ajouterPiece(co);
	}

	//Methode permettant de savooir si une case est connecte a toutes ses cases  cases adjacentes
	public boolean[] connecte(Carre c) {
		boolean[] gagne = { true, true, true, true };
		if (c.getX() == 0 && c.getY() == 0) {
			if (carres[c.getX() + 1][c.getY()] != null) {
				Carre c1 = carres[c.getX() + 1][c.getY()];
				if (c.cote1.size() != c1.cote3.size()) {
					gagne[1] = false;
				}
			} else if (carres[c.getX()][c.getY() + 1] != null) {
				Carre c1 = carres[c.getX()][c.getY() + 1];
				if (c.cote2.size() != c1.cote0.size()) {
					gagne[2] = false;
				}
			} else if (carres[c.getX()][c.getY() + 1] == null && carres[c.getX() + 1][c.getY()] == null) {
				gagne[1] = false;
				gagne[2] = false;
			}
		} else if (c.getX() == 4 && c.getY() == 4) {
			if (carres[c.getX() - 1][c.getY()] != null) {
				Carre c1 = carres[c.getX() - 1][c.getY()];
				if (c.cote3.size() != c1.cote1.size()) {
					gagne[3] = false;
				}
			} else if (carres[c.getX()][c.getY() - 1] != null) {
				Carre c1 = carres[c.getX()][c.getY() - 1];
				if (c.cote0.size() != c1.cote2.size()) {
					gagne[0] = false;
				}
			} else if (carres[c.getX()][c.getY() - 1] == null && carres[c.getX() - 1][c.getY()] == null) {
				gagne[0] = false;
				gagne[3] = false;
			}
		}
		if (c.getX() == 0 && c.getY() == 4) {
			if (carres[c.getX() + 1][c.getY()] != null) {
				Carre c1 = carres[c.getX() + 1][c.getY()];
				if (c.cote1.size() != c1.cote3.size()) {
					gagne[1] = false;
				}
			} else if (carres[c.getX()][c.getY() - 1] != null) {
				Carre c1 = carres[c.getX()][c.getY() - 1];
				if (c.cote0.size() != c1.cote2.size()) {
					gagne[0] = false;
				}
			} else if (carres[c.getX()][c.getY() - 1] == null && carres[c.getX() + 1][c.getY()] == null) {
				gagne[1] = false;
				gagne[0] = false;
			}

		}
		if (c.getX() == 4 && c.getY() == 0) {
			if (carres[c.getX() - 1][c.getY()] != null) {
				Carre c1 = carres[c.getX() - 1][c.getY()];
				if (c.cote3.size() != c1.cote1.size()) {
					gagne[0] = false;
				}
			} else if (carres[c.getX()][c.getY() + 1] != null) {
				Carre c1 = carres[c.getX()][c.getY() + 1];
				if (c.cote2.size() != c1.cote0.size()) {
					gagne[0] = false;
				}
			} else if (carres[c.getX()][c.getY() + 1] == null && carres[c.getX() - 1][c.getY()] == null) {
				gagne[3] = false;
				gagne[2] = false;
			}
		}
		if (c.getY() == 4 && c.getX() < 4 && c.getX() > 0) {
			if (carres[c.getX() + 1][c.getY()] != null) {
				Carre c1 = carres[c.getX() + 1][c.getY()];
				if (c.cote1.size() != c1.cote3.size()) {
					gagne[1] = false;
				}
			} else if (carres[c.getX() - 1][c.getY()] != null) {
				Carre c1 = carres[c.getX() - 1][c.getY()];
				if (c.cote3.size() != c1.cote1.size()) {
					gagne[3] = false;
				}
			} else if (carres[c.getX()][c.getY() - 1] != null) {
				Carre c1 = carres[c.getX()][c.getY() - 1];
				if (c.cote0.size() != c1.cote2.size()) {
					gagne[0] = false;
				}
			} else if (carres[c.getX()][c.getY() - 1] == null && carres[c.getX() + 1][c.getY()] == null
					&& carres[c.getX() - 1][c.getY()] == null) {
				gagne[0] = false;
				gagne[1] = false;
				gagne[3] = false;
			}
		}
		if (c.getY() == 0 && c.getX() < 4 && c.getX() > 0) {
			if (carres[c.getX() + 1][c.getY()] != null) {
				Carre c1 = carres[c.getX() + 1][c.getY()];
				if (c.cote1.size() != c1.cote3.size()) {
					gagne[1] = false;
				}
			} else if (carres[c.getX() - 1][c.getY()] != null) {
				Carre c1 = carres[c.getX() - 1][c.getY()];
				if (c.cote3.size() != c1.cote1.size()) {
					gagne[3] = false;
				}
			} else if (carres[c.getX()][c.getY() + 1] != null) {
				Carre c1 = carres[c.getX()][c.getY() + 1];
				if (c.cote2.size() != c1.cote0.size()) {
					gagne[2] = false;
				}
			} else if (carres[c.getX()][c.getY() + 1] == null && carres[c.getX() + 1][c.getY()] == null
					&& carres[c.getX() - 1][c.getY()] == null) {
				gagne[1] = false;
				gagne[2] = false;
				gagne[3] = false;
			}
		}
		if (c.getX() == 4 && c.getY() < 4 && c.getY() > 0) {
			if (carres[c.getX() - 1][c.getY()] != null) {
				Carre c1 = carres[c.getX() - 1][c.getY()];
				if (c.cote3.size() != c1.cote1.size()) {
					gagne[3] = false;
				}
			} else if (carres[c.getX()][c.getY() + 1] != null) {
				Carre c1 = carres[c.getX()][c.getY() + 1];
				if (c.cote2.size() != c1.cote0.size()) {
					gagne[2] = false;
				}
			} else if (carres[c.getX()][c.getY() - 1] != null) {
				Carre c1 = carres[c.getX()][c.getY() - 1];
				if (c.cote0.size() != c1.cote2.size()) {
					gagne[0] = false;
				}
			} else if (carres[c.getX()][c.getY() - 1] == null && carres[c.getX()][c.getY() + 1] == null
					&& carres[c.getX() - 1][c.getY()] == null) {
				gagne[0] = false;
				gagne[2] = false;
				gagne[3] = false;
			}
		}
		if (c.getX() == 0 && c.getY() < 4 && c.getY() > 0) {
			if (carres[c.getX() + 1][c.getY()] != null) {
				Carre c1 = carres[c.getX() + 1][c.getY()];
				if (c.cote1.size() != c1.cote3.size()) {
					gagne[1] = false;
				}
			} else if (carres[c.getX()][c.getY() + 1] != null) {
				Carre c1 = carres[c.getX()][c.getY() + 1];
				if (c.cote2.size() != c1.cote0.size()) {
					gagne[2] = false;
				}
			} else if (carres[c.getX()][c.getY() - 1] != null) {
				Carre c1 = carres[c.getX()][c.getY() - 1];
				if (c.cote0.size() != c1.cote2.size()) {
					gagne[0] = false;
				}
			} else if (carres[c.getX()][c.getY() - 1] == null && carres[c.getX()][c.getY() + 1] == null
					&& carres[c.getX() + 1][c.getY()] == null) {
				gagne[0] = false;
				gagne[1] = false;
				gagne[2] = false;
			}
		} else if (c.getY() != 4 && c.getY() != 0 && c.getX() != 4 && c.getX() != 0) {
			if (carres[c.getX() + 1][c.getY()] != null) {
				Carre c1 = carres[c.getX() + 1][c.getY()];
				if (c.cote1.size() != c1.cote3.size()) {
					gagne[1] = false;
				}
			} else if (carres[c.getX() - 1][c.getY()] != null) {
				Carre c1 = carres[c.getX() - 1][c.getY()];
				if (c.cote3.size() != c1.cote1.size()) {
					gagne[3] = false;
				}
			} else if (carres[c.getX()][c.getY() + 1] != null) {
				Carre c1 = carres[c.getX()][c.getY() + 1];
				if (c.cote2.size() != c1.cote0.size()) {
					gagne[2] = false;
				}
			} else if (carres[c.getX()][c.getY() - 1] != null) {
				Carre c1 = carres[c.getX()][c.getY() - 1];
				if (c.cote0.size() != c1.cote2.size()) {
					gagne[0] = false;
				}
			} else if (carres[c.getX()][c.getY() - 1] == null && carres[c.getX()][c.getY() + 1] == null
					&& carres[c.getX() + 1][c.getY()] == null && carres[c.getX() - 1][c.getY()] == null) {
				gagne[0] = false;
				gagne[1] = false;
				gagne[2] = false;
				gagne[3] = false;
			}
		}

		return gagne;
	}

	//methodes permettant de savoir si toutes les cases du plateau sont sont connectes ou pas 
	public boolean[] gagne() {
		boolean[] vrai = new boolean[25];
		for (int i = 0; i < 25; i++) {
			vrai[i] = true;
		}
		int f = 0;
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (carres[i][j] != null) {
					this.connecte(carres[i][j]);
					for (int e = 0; e < 4; e++) {
						if (connecte(carres[i][j])[e] == false) {
							vrai[f] = false;
							break;
						}
					}
				}
				f++;
			}
		}
		return vrai;
	}

	//methode a retour booleene permettant de savoir si le niveau est valide ou nom
	public boolean aGagner() {
		boolean victoire = true;
		for (int i = 0; i < 25; i++) {
			if (this.gagne()[i] == false) {
				victoire = false;
				break;
			}
		}
		return victoire;
	}

}
