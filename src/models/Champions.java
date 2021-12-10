package models;

import java.util.ArrayList;

import com.uptc.models.methods.Uniform;

public class Champions {

	private ArrayList<Team> teams;
	private ArrayList<ReportLuck> lucksCompetitors;
	private ArrayList<Gender> genderStacts;
	private ArrayList<Competitor> competitors;

	/**
	 * 
	 * @param teams
	 */
	public Champions(ArrayList<Team> teams) {
		this.teams = teams;
		this.lucksCompetitors = new ArrayList<>();
		this.genderStacts = new ArrayList<>();
	}

	/**
	 * Inicia la cantidad de partidos de el campeonato
	 */
	public void startChampion(int games) {
		for (int i = 0; i < games; i++) {
			Game game = new Game(teams);
			game.initGame();
			resetRes();
			addLuckGameCompetitor();
			addGameWin();
			addPointsInGame(teams);
			resetCountLuck(teams);
			genderStacts.add(game.getCountFemaleWins() > game.getCountMaleWins() ? Gender.FEMALE : Gender.MALE);
		}
	}

	private void addGameWin() {
		if (teams.get(0).getPointsGame() > teams.get(1).getPointsGame()) {
			teams.get(0).setCountWinGame();
		} else {
			teams.get(1).setCountWinGame();
		}
	}

	/**
	 * Agrega a la lista de historial de puntajes los puntos del juego y reinica el
	 * copntador para el siguiente juego
	 * 
	 * @param teams2
	 */
	private void addPointsInGame(ArrayList<Team> teams) {
		for (Team team : teams) {
			team.addPointsToList();
			team.resetPointsGame();
		}
	}

	/**
	 * Reinicia el contador de veces que el competidor gano por tener mas suerte
	 */

	private void resetCountLuck(ArrayList<Team> teams) {
		for (Team team : teams) {
			for (Competitor c : team.getCompetitors()) {
				c.resetCountLuck();
			}
		}
	}

	/**
	 * reinicia la resistencia luego de un juego acabado
	 */
	private void resetRes() {
		for (Team team : teams) {
			team.resetRes();
		}
	}

	/**
	 * Agrega el competidor con mas suerte de cada partida
	 */
	private void addLuckGameCompetitor() {
		Competitor competitor = getMaxLuxkCompetitor();
		lucksCompetitors.add(new ReportLuck(competitor.getName(), competitor.getLuck()));
	}

	/**
	 * Retorna el competidor con mas experiencia optenida en los primeros mil juegos
	 */
	public Competitor getCompetitorMaxExperience() {
		return teams.get(0).getMaxExperience().getExperience() > teams.get(1).getMaxExperience().getExperience()
				? teams.get(0).getMaxExperience()
				: teams.get(1).getMaxExperience();
	}

	/**
	 * 
	 * @return Equipo ganador del campeonato
	 */
	public Team winGame() {
		return teams.get(0).getCountWinGame() > teams.get(1).getCountWinGame() ? teams.get(0) : teams.get(1);
	}

//	public Team

	/**
	 * 
	 * @return Lista de competidores con mas suerte por cada juego
	 */
	public ArrayList<ReportLuck> getLucksCompetitors() {
		return lucksCompetitors;
	}

	/**
	 * 
	 * @return Lista de genero con mas vistorias por juego
	 */
	public ArrayList<Gender> getGenderStacts() {
		return genderStacts;
	}

	/**
	 * 
	 * @return El genero con más victorias totales
	 */

	public Gender getTheBestGender() {
		int countMale = 0;
		int countFemale = 0;
		for (Gender gender : genderStacts) {
			if (gender == Gender.MALE) {
				countMale++;
			} else {
				countFemale++;
			}
		}
		return countMale > countFemale ? Gender.MALE : Gender.FEMALE;
	}

	/**
	 * 
	 * @return Competidor con mas suerte del campeonato
	 */
	private Competitor getMaxLuxkCompetitor() {
		return teams.get(0).getMaxLuck().getCountLuck() > teams.get(1).getMaxLuck().getCountLuck()
				? teams.get(0).getMaxLuck()
				: teams.get(1).getMaxLuck();
	}

	/**
	 * @return  Lista de competidores
	 */
	public ArrayList<Competitor> getCompetitors() {
		competitors = new ArrayList<>();
		for (Team team : teams) {
			for (Competitor competitor : team.getCompetitors()) {
				competitors.add(competitor);
			}
		}
		return competitors;
	}

	/**
	 * 
	 * @return lista de equipos
	 */
	public ArrayList<Team> getTeams() {
		return teams;
	}


	/**
	 * 
	 * @return Genero de un jugador
	 */
	public static Gender gender() {
		Uniform xiUniform = new Uniform(1);
		return xiUniform.getAleatory().get(0) > 0.5 ? Gender.FEMALE : Gender.MALE;
	}
}