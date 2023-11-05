package jeux_2048;

import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Plateau {

	Case[][] map;
	private Graphics g;
	private Image decoIm = null;
	private int score = 0;
	private int nb_m = 0;

	// constructeur de scene du jeu
	public Plateau(Graphics g) throws SlickException {
		map = new Case[4][4];
		add();
		add();
		this.g = g;
		decoIm = new Image("image/BO.PNG");

	}

	// ici on dessiner les pieces ajoutees sur la map avec la methode add()
	public void dessinerpiece() {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (map[j][i] != null) {
					map[j][i].dessiner(g);
				}
			}
		}
	}

	// methode pour dessiner la partie sur laquelle on joue sur le plateau
	public void dessinerplateau() throws SlickException {
		g.setColor(new Color(52, 102, 146));
		g.fillRect(0, 0, 326, 326);
		for (int i = 0; i <= 326; i += 82) {
			for (int j = 0; j <= 326; j += 82) {
				g.setColor(new Color(98, 144, 200));
				g.fillRect(i, j, 80, 80);

			}
		}
	}

	// on recerche tout dabord les cases vides sur le plateau
	public List<int[]> getFreeCase() {
		List<int[]> list = new ArrayList<int[]>();
		for (int x = 0; x < 4; x++) {
			for (int y = 0; y < 4; y++) {
				if (map[y][x] == null) {
					int t[] = { y, x };
					list.add(t);
				}
			}
		}
		return list;
	}

	// methode pour ajouter un carreau de point a la map
	public void add() throws SlickException {
		List<int[]> list = getFreeCase();
		if (list.size() != 0) {
			int ind = (int) (Math.random() * list.size());
			int[] te_c = list.get(ind);
			map[te_c[0]][te_c[1]] = new Case(g, te_c[1], te_c[0], Math.random() > 0.5 ? 2 : 4);
			// loperateur ternaire ici permet de selectionner la
			// valeur entre 2 et 4
		}
	}

	// methode up qui permet de deplacer les carreaux vers le haut
	// le bas, la gauche et la droite

	public boolean Up() throws SlickException {
		boolean vrai = false;
		for (int y = 0; y < 4; y++) {
			for (int x = 1; x < 4; x++) {
				if (map[y][x] != null) {
					int x_t = x - 1;
					while (map[y][x_t] == null) {
						Case c_t = new Case(g, x_t, y, map[y][x_t + 1].getValeur());
						map[y][x_t + 1] = null;
						map[y][x_t] = c_t;
						x_t--;
						if (x_t < 0)
							break;
					}
					x_t++;
					if (x_t > 0 && map[y][x_t].getValeur() == map[y][x_t - 1].getValeur()) {
						vrai = true;
						map[y][x_t - 1].setValeur(map[y][x_t - 1].getValeur() * 2);
						map[y][x_t] = null;
					}
				}
			}
		}
		return vrai;

	}

	public boolean Down() throws SlickException {
		boolean vrai = false;
		for (int y = 0; y < 4; y++) {
			for (int x = 4 - 2; x >= 0; x--) {
				if (map[y][x] != null) {
					int x_t = x + 1;
					while (map[y][x_t] == null) {
						Case c_t = new Case(g, x_t, y, map[y][x_t - 1].getValeur());
						map[y][x_t - 1] = null;
						map[y][x_t] = c_t;
						x_t++;
						if (x_t >= 4)
							break;
					}
					x_t--;
					if (x_t < 4 - 1 && map[y][x_t].getValeur() == map[y][x_t + 1].getValeur()) {
						map[y][x_t + 1].setValeur(map[y][x_t + 1].getValeur() * 2);
						map[y][x_t] = null;
						vrai = true;
					}
				}
			}
		}
		return vrai;

	}

	public boolean Left() throws SlickException {
		boolean vrai = false;
		for (int x = 0; x < 4; x++) {
			for (int y = 1; y < 4; y++) {
				if (map[y][x] != null) {
					int y_t = y - 1;
					while (map[y_t][x] == null) {
						Case c_t = new Case(g, x, y_t, map[y_t + 1][x].getValeur());
						map[y_t + 1][x] = null;
						map[y_t][x] = c_t;
						y_t--;
						if (y_t < 0)
							break;
					}
					y_t++;
					if (y_t > 0 && map[y_t][x].getValeur() == map[y_t - 1][x].getValeur()) {
						map[y_t - 1][x].setValeur(map[y_t][x].getValeur() * 2);
						map[y_t][x] = null;
						vrai = true;
					}
				}
			}
		}
		return vrai;
	}

	public boolean Right() throws SlickException {
		boolean vrai = false;
		for (int x = 0; x < 4; x++) {
			for (int y = 4 - 2; y >= 0; y--) {
				if (map[y][x] != null) {
					int y_t = y + 1;
					while (map[y_t][x] == null) {
						Case c_t = new Case(g, x, y_t, map[y_t - 1][x].getValeur());
						map[y_t - 1][x] = null;
						map[y_t][x] = c_t;
						y_t++;
						if (y_t >= 4)
							break;
					}
					y_t--;
					if (y_t < 4 - 1 && map[y_t][x].getValeur() == map[y_t + 1][x].getValeur()) {
						map[y_t + 1][x].setValeur(map[y_t + 1][x].getValeur() * 2);
						map[y_t][x] = null;
						vrai = true;
					}
				}
			}
		}
		return vrai;

	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getNb_m() {
		return nb_m;
	}

	public void setNb_m(int nb_m) {
		this.nb_m = nb_m;
	}

	void showInfo() {
		g.setColor(Color.white);
		g.drawString("Votre score -> " + this.plusGrandeValeur() + " \n", 326 + 10, 10);
		g.drawString("F1 pour rejouer", 326 + 10, 40);
	}

	void affichage(String s) {// methode pour afficher un texte en parametre dans le jeu
		g.setColor(Color.white);
		g.drawImage(decoIm, 10, 326 + 10);
		g.drawString(s, 200, 326 + 10);
	}

	void verifWin() {
		// TODO
	}

	void removeAll() {
		for (int x = 0; x < 4; x++) {
			for (int y = 0; y < 4; y++) {
				map[x][y]=null;
			}
		}
	}

	int plusGrandeValeur() {
		int max = 0;
		for (int x = 0; x < 4; x++) {
			for (int y = 0; y < 4; y++) {
				if (map[x][y] != null && map[x][y].getValeur() >= max) {
					max = map[x][y].getValeur();
				}
			}
		}
		return max;
	}

	boolean tableauPlein() {// Methode qui reyurne si le tableau de pieces est plein ou pas
		boolean plein = true;
		for (int x = 0; x < 4; x++) {
			for (int y = 0; y < 4; y++) {
				if (map[x][y] == null) {
					plein = false;
					break;
				}
			}
			if (plein == false)
				break;
		}
		return plein;
	}

	boolean partieFinie() {// methode qui determine si la partie est finie ou pas
		boolean fini = true;

		if (this.tableauPlein()) {
			for (int x = 0; x < 4; x++) {
				for (int y = 0; y < 3; y++) {
					if (map[x][y + 1].valeur == map[x][y].valeur) {
						fini = false;
						break;
					}
					if (fini == false)
						break;
				}

			}
			for (int x = 0; x < 3; x++) {
				for (int y = 0; y < 4; y++) {
					if (map[x + 1][y].valeur == map[x][y].valeur) {
						fini = false;
						break;
					}
				}
				if (fini == false)
					break;
			}
		} else {
			fini = false;
		}
		return fini;
	}

}
