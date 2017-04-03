package pacman.environnementRL;

import java.util.ArrayList;
import java.util.Arrays;

import pacman.elements.Position2D;
import pacman.elements.StateAgentPacman;
import pacman.elements.StateGamePacman;
import environnement.Etat;
/**
 * Classe pour définir un etat du MDP pour l'environnement pacman avec QLearning tabulaire

 */
public class EtatPacmanMDPClassic implements Etat , Cloneable{
	private Position2D pacmanPos;
	private ArrayList<Position2D> phantomsPos;
	private ArrayList<Position2D> dotsPos;

	
	public EtatPacmanMDPClassic(StateGamePacman _stategamepacman){
		/*Position 2d pacman
		* // fantoms
		*  // dots
		 */
		this.phantomsPos = new ArrayList<>();
		this.dotsPos = new ArrayList<>();

		this.pacmanPos = new Position2D(_stategamepacman.getPacmanState(0).getX(), _stategamepacman.getPacmanState(0).getY());

		for(int i = 0 ; i < _stategamepacman.getNumberOfGhosts() ; i++){
			this.phantomsPos.add(new Position2D(_stategamepacman.getGhostState(i).getX(), _stategamepacman.getGhostState(i).getY()));
		}

		for(int x = 0 ; x < _stategamepacman.getMaze().getSizeX() ; x++){
			for(int y = 0 ; y < _stategamepacman.getMaze().getSizeY() ; y++){
				if(_stategamepacman.getMaze().isFood(x, y)){
					this.dotsPos.add(new Position2D(x, y));
				}
			}
		}
		
		
	}
	
	@Override
	public String toString() {
		
		return "";
	}
	
	
	public Object clone() {
		EtatPacmanMDPClassic clone = null;
		try {
			// On recupere l'instance a renvoyer par l'appel de la 
			// methode super.clone()
			clone = (EtatPacmanMDPClassic)super.clone();
		} catch(CloneNotSupportedException cnse) {
			// Ne devrait jamais arriver car nous implementons 
			// l'interface Cloneable
			cnse.printStackTrace(System.err);
		}
		


		// on renvoie le clone
		return clone;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		EtatPacmanMDPClassic that = (EtatPacmanMDPClassic) o;

		if (pacmanPos != null ? !pacmanPos.equals(that.pacmanPos) : that.pacmanPos != null) return false;
		if (phantomsPos != null ? !phantomsPos.equals(that.phantomsPos) : that.phantomsPos != null) return false;
		return dotsPos != null ? dotsPos.equals(that.dotsPos) : that.dotsPos == null;
	}

	@Override
	public int hashCode() {
		int result = pacmanPos != null ? pacmanPos.hashCode() : 0;
		result = 31 * result + (phantomsPos != null ? phantomsPos.hashCode() : 0);
		result = 31 * result + (dotsPos != null ? dotsPos.hashCode() : 0);
		return result;
	}
}
