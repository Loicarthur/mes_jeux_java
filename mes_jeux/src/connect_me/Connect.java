package connect_me;

import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class Connect extends BasicGame {
//ici on initialise le plateau de jeu linterface dacceuil et linterface des niveaux
	Plateau p;
	Acceuil a;
	int x = 1;
	int ac = 0;
	Niveaux n;

	public Connect(String title) {
		super(title);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init(GameContainer arg0) throws SlickException {
		// TODO Auto-generated method stub
		p = new Plateau(arg0.getGraphics(), x);
		a = new Acceuil(arg0.getGraphics());
		n = new Niveaux();

	}

	@Override
	public void render(GameContainer gc, Graphics arg1) throws SlickException {
		// TODO Auto-generated method stub
		if (ac == 0) {
			a.acceuil(arg1, gc.getInput());

		} else if (ac == 1) {
			n.choisir(arg1, gc.getInput());

		} else if (ac == 2) {
			p.dessinerplateau(gc.getInput(), this.x);
			p.dessinerPiece();

		}
	}

	@Override
	public void update(GameContainer gc, int arg1) throws SlickException {
		// TODO Auto-generated method stub
		Input inp = gc.getInput();
		if (ac == 2) {
			if (inp.isMousePressed(Input.MOUSE_RIGHT_BUTTON)) {
				int x = inp.getMouseX();
				int y = inp.getMouseY();
				p.clicCase(x, y);
			}

			if (inp.isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
				// Methode pour bouger les pieces pouvant juste aller en haut en bas a gauche et
				// a droite
				// bouton gauche de la souris pour selectionner et boutton droit pour deposers
				// sur une case et la recentrer
				if (p.select[0] != -1 && p.select[1] != -1 && p.carres[p.select[0]][p.select[1]].getType() != 0) {
					if (p.carres[p.select[0]][p.select[1]].getType() == 4
							|| p.carres[p.select[0]][p.select[1]].getType() == 2) {
						int x = inp.getMouseX();
						int y = inp.getMouseY();
						int x1 = p.quelleCase(x, y)[0];
						int y1 = p.quelleCase(x, y)[1];
						if (p.carres[x1][y1] == null) {
							p.carres[p.select[0]][p.select[1]].setX(x1);
							p.carres[p.select[0]][p.select[1]].setY(y1);
							p.carres[p.select[0]][p.select[1]].setColonne(x1 * 82);
							p.carres[p.select[0]][p.select[1]].setLigne(y1 * 82);
							p.ajouterPiece(p.carres[p.select[0]][p.select[1]]);
							Carre c = p.carres[p.select[0]][p.select[1]];
							int t1 = c.cote0.size();
							int t2 = c.cote1.size();
							int t3 = c.cote2.size();
							int t4 = c.cote3.size();
							c.supTrait();
							c.creerTrait(0, t1);
							c.creerTrait(1, t2);
							c.creerTrait(2, t3);
							c.creerTrait(3, t4);
							p.carres[p.select[0]][p.select[1]] = null;
						}
						p.select[0] = -1;
						p.select[0] = -1;
						// Methode pour les pieces pouvant juste aller dans deux directions oppose
						// meme principe que celle du haut en fonctionnement
					} else if (p.carres[p.select[0]][p.select[1]].getType() == 1) {
						int x = inp.getMouseX();
						int y = inp.getMouseY();
						int x1 = p.quelleCase(x, y)[0];
						int y1 = p.quelleCase(x, y)[1];
						if (y1 == p.carres[p.select[0]][p.select[1]].getY() && p.carres[x1][y1] == null) {
							p.carres[p.select[0]][p.select[1]].setX(x1);
							p.carres[p.select[0]][p.select[1]].setColonne(x1 * 82);
							p.ajouterPiece(p.carres[p.select[0]][p.select[1]]);
							Carre c = p.carres[p.select[0]][p.select[1]];
							int t1 = c.cote0.size();
							int t2 = c.cote1.size();
							int t3 = c.cote2.size();
							int t4 = c.cote3.size();
							c.supTrait();
							c.creerTrait(0, t1);
							c.creerTrait(1, t2);
							c.creerTrait(2, t3);
							c.creerTrait(3, t4);
							p.carres[p.select[0]][p.select[1]] = null;
							p.select[0] = -1;
							p.select[0] = -1;
						}
					}
				}
			}

			// Methode de rotation pour les pieces rotatives
			// on les rotes avec le boutton du milieu de la souris
			if (inp.isMousePressed(Input.MOUSE_MIDDLE_BUTTON)) {
				int x = inp.getMouseX();
				int y = inp.getMouseY();
				p.select[0] = p.quelleCase(x, y)[0];
				p.select[1] = p.quelleCase(x, y)[1];
				if (p.select[0] != -1 && p.select[1] != -1 && p.carres[p.select[0]][p.select[1]].getType() != 0) {
					if (p.carres[p.select[0]][p.select[1]].getType() == 4
							|| p.carres[p.select[0]][p.select[1]].getType() == 3) {
						Carre c = p.carres[p.select[0]][p.select[1]];
						int t1 = c.cote0.size();
						int t2 = c.cote1.size();
						int t3 = c.cote2.size();
						int t4 = c.cote3.size();
						c.supTrait();
						c.creerTrait(0, t4);
						c.creerTrait(1, t1);
						c.creerTrait(2, t2);
						c.creerTrait(3, t3);
						p.select[0] = -1;
						p.select[0] = -1;
					}
				}
			}

			// code permettant de passer dun niveau a un autre
			// apres avoir valider
			if (inp.isKeyPressed(Input.KEY_ESCAPE)) {
				ac = 0;
			}
			if (p.aGagner() && x <= 6) {
				x++;
				p = new Plateau(gc.getGraphics(), x);
			} else if (x >= 7) {
				this.x = 1;
				ac = 0;
			}
		} else if (ac == 1) {
			if (inp.isMouseButtonDown(Input.MOUSE_RIGHT_BUTTON)) {
				int x1 = gc.getInput().getMouseX();
				int y1 = gc.getInput().getMouseY();
				if (x1 < 469 + 70 && x1 > 469 && y1 < 85 && y1 > 15) {
					this.ac = 0;
				}
				int niveau = 1;
				for (int i = 148; i <= 304 + 148; i += 102) {
					for (int j = 52; j <= 304 + 52; j += 102) {
						if (x1 < i + 100 && x1 > i && y1 < j + 100 && y1 > j) {
							this.x = niveau;
							p = new Plateau(gc.getGraphics(), x);
							this.ac = 2;
						}
						niveau++;
					}
				}
			}
//			if(niveau )

		} else if (ac == 0) {
			if (inp.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)) {
				int x2 = gc.getInput().getMouseX();
				int y2 = gc.getInput().getMouseY();
				if (x2 < 350 && x2 > 250 && y2 < 214 && y2 > 164) {
					this.ac = 1;
				}
			}
		}

//		System.out.println(p.aGagner());
		System.out.println(x);
	}
}
