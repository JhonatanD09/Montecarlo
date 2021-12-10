package models;

import java.util.ArrayList;

/**
 * Clase equipo
 * 
 * @author jhona
 *
 */
public class Team {

	private String teamName;
	private int score;
	private int parcialScore;
	private int countWinGame;
	private ArrayList<Competitor> competitors;
	private ArrayList<Integer> gamePoints;
	private ArrayList<Integer> labPoints;
	private int pointsGame;

	/**
	 * Metodo constructor de la clase
	 * 
	 * @param competitors lista de competidores que conforman el equipo
	 */
	public Team(String teamName, ArrayList<Competitor> competitors) {
		this.teamName = teamName;
		this.score = 0;
		this.competitors = competitors;
		this.parcialScore = 0;
		this.countWinGame = 0;
		this.gamePoints = new ArrayList<>();
		this.pointsGame = 0;
	}

	public String getTeamName() {
		return teamName;
	}

	/**
	 * @return puntos que tiene el equipo
	 */
	public int getScore() {
		return score;
	}

	/**
	 * Metodo que suma puntos al equipo cuando son optenidos
	 * 
	 * @param score puntos a sumar
	 */
	public void setScore(int score) {
		this.score = (this.score + score);
	}

	/**
	 * @return Lista de competidores
	 */
	public ArrayList<Competitor> getCompetitors() {
		return competitors;
	}

	/**
	 * Reinicia los puntos del competidor por cada ronda
	 */
	public void resetCompetitorsScore() {
		for (Competitor competitor : competitors) {
			competitor.resetCompetitorScore();
		}
	}

	/**
	 * @return Marcador parcial por ronda, se reinicia en cada ronda
	 */
	public int getParcialScore() {
		return parcialScore;
	}

	/**
	 * suma los puntos optenidos al marcador parcial
	 * 
	 * @param parcialScore
	 */
	public void setParcialScore(int parcialScore) {
		this.parcialScore = (this.parcialScore + parcialScore);
	}

	/**
	 * reinicia el marcador parcial
	 */
	public void resetParcialScore() {
		this.parcialScore = 0;
	}

	/**
	 * retorna el competidor con mas suerte
	 * 
	 * @return competidor
	 */
	public Competitor luckCompetitor() {
		Competitor competitorTemp = competitors.get(0);
		for (Competitor competitor : competitors) {
			if (competitor.getLuck() > competitorTemp.getLuck()) {
				competitorTemp = competitor;
			}
		}
		return competitorTemp;
	}

	/**
	 * Reinicia la resistencia de los competidores
	 */
	public void resetRes() {
		for (Competitor competitor : competitors) {
			competitor.resetRes();
		}
	}

	/**
	 * Busca el competidor con mas puntos del equipo
	 * 
	 * @return competidor
	 */
	public Competitor getMaxScoreCompetitor() {
		Competitor competitorTemp = competitors.get(0);
		for (Competitor competitor : competitors) {
			if (competitor.getLuck() > competitorTemp.getLuck()) {
				competitorTemp = competitor;
			}
		}
		return competitorTemp;
	}

	/**
	 * Reincia la suerte de los competidores
	 */
	public void resetLuck() {
		for (Competitor competitor : competitors) {
			competitor.setLuck();
		}
	}

	/**
	 * Jugador con mas suerte de cada partida
	 * 
	 * @return jugador con mas suerte
	 */
	public Competitor getMaxLuck() {
		Competitor competitorTemp = competitors.get(0);
		for (Competitor competitor : competitors) {
			if (competitor.getCountLuck() > competitorTemp.getCountLuck()) {
				competitorTemp = competitor;
			}
		}
		return competitorTemp;
	}

	/**
	 * Jugador con mas experiencia total
	 * 
	 * @return jugador
	 */
	public Competitor getMaxExperience() {
		Competitor competitorTemp = competitors.get(0);
		for (Competitor competitor : competitors) {
			if (competitor.getExperience() > competitorTemp.getExperience()) {
				competitorTemp = competitor;
			}
		}
		return competitorTemp;
	}

	/**
	 * Retorna la cantidad de juegos ganados del equipo
	 */

	public int getCountWinGame() {
		return countWinGame;
	}

	/**
	 * Aumenta en uno el contador de juegos ganados del equipo
	 */

	public void setCountWinGame() {
		this.countWinGame++;
	}

	/**
	 * 
	 * @return lista de puntos por cada juego
	 */
	public ArrayList<Integer> getGamePoints() {
		return gamePoints;
	}

	/**
	 * 
	 * @return puntos obtenidos en cada juego
	 */
	public int getPointsGame() {
		return pointsGame;
	}

	/**
	 * Aumenta al contador del juego el puntaje optenido en una ronda
	 * 
	 * @param pointsGame
	 */
	public void setPointsGame(int pointsGame) {
		this.pointsGame = (this.pointsGame + pointsGame);
	}

	public ArrayList<Integer> getLabPoints() {
		labPoints = new ArrayList<>();
		for (int i = 0; i < competitors.get(0).getPointsToLap().size(); i++) {
			int points = 0;
			for (Competitor competitor : competitors) {
				points += competitor.getPointsToLap().get(i);
			}
			labPoints.add(points);
		}
		return labPoints;
	}

	/**
	 * Resetea el puntaje optenido en un juego
	 */
	public void resetPointsGame() {
		this.pointsGame = 0;
	}

	/**
	 * Agrega el puntaje total del juego a la la lista de historial de puntajes
	 */
	public void addPointsToList() {
		gamePoints.add(getPointsGame());
	}

	public void addPoinstToLab() {
		for (Competitor competitor : competitors) {
			competitor.addPointToLab();
		}
	}

}
