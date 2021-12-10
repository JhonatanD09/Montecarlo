package models;

import java.util.ArrayList;

/**
 * Clase juego
 * 
 * @author jhona
 *
 */
public class Game {

	private ArrayList<Team> teams;
	private int teamColombiaWins;
	private int teamUSAWins;
	private Competitor competitorActualLuck;
	private int countCompetitorSuperLuck;
	private int countMaleWins;
	private int countFemaleWins;

	/**
	 * Metodo constructor de la clase
	 * 
	 * @param teams equipos que entran al juego
	 */
	public Game(ArrayList<Team> teams) {
		this.teams = teams;
		this.countMaleWins = 0;
		this.countFemaleWins = 0;
	}

	/**
	 * Inicio de un juego
	 */
	public void initGame() {
		teamColombiaWins = 0;
		teamUSAWins = 0;
		while (teamColombiaWins < 10 && teamUSAWins < 10) {
			throwTeams(teams);
		}
	}

	/**
	 * En este metodo se recorren los equipos, y se realizan los lanzamientos por
	 * cada competidor del equipo resetea los puntos del competidor, cada ronda
	 * Asigna al jugador con mas suerte un lanzamiento extra reinicia la suerte de
	 * los jugadores Asigna experiencia al competidor con mas puntos de la ronda
	 * 
	 * @param teams lista de equipos
	 */
	private void throwTeams(ArrayList<Team> teams) {
		for (Team team : teams) {
			throwArrowCompetitors(team);
		}
		valideTeamWinInLap();
		valideAndReset();

	}

	public void valideAndReset(){
		for (Team team : teams) {			
			luckCompetiror(team);
			valideSuperLuckCompetitor();
			valideExperienceCompetitor();
			team.resetLuck();
			team.setPointsGame(team.getParcialScore());
			team.resetParcialScore();
			team.addPoinstToLab();
			team.resetCompetitorsScore();
		}
	}
	
	/**
	 * Aumrenta la experiencia al ganador de un juego
	 */
	private void valideExperienceCompetitor() {
		if (this.teams.get(0).getMaxScoreCompetitor().getCompetitorScore() > this.teams.get(1).getMaxScoreCompetitor()
				.getCompetitorScore()) {
			this.teams.get(0).getMaxScoreCompetitor().setExperience();
			valideGenderWinLab(this.teams.get(0).getMaxScoreCompetitor());
		} else {
			this.teams.get(1).getMaxScoreCompetitor().setExperience();
			valideGenderWinLab(this.teams.get(1).getMaxScoreCompetitor());
		}
	}

	/**
	 * Aumenta el contador de partidas ganadas dependiendo el genero
	 * 
	 * @param competitor
	 */
	private void valideGenderWinLab(Competitor competitor) {
		if (competitor.getGender().equals(Gender.MALE)) {
			countMaleWins++;
		} else {
			countFemaleWins++;
		}
	}

	/**
	 * Valida si un competidor tiene super suerte 3 veces seguidas
	 */
	private void valideSuperLuckCompetitor() {
		if (countCompetitorSuperLuck == 3) {
			throwArrowLuck(competitorActualLuck, searchTeam(competitorActualLuck));
			countCompetitorSuperLuck = 0;
		}
	}

	/**
	 * Mira que competidor tiene mas suerte si es el mismo que tubo suerte la
	 * ocacion anterior aumenta un contador de suerte
	 * 
	 * @param team
	 */
	private void luckCompetiror(Team team) {
		Competitor temp = team.luckCompetitor();
		if (competitorActualLuck != null) {
			if (competitorActualLuck.equals(temp)) {
				countCompetitorSuperLuck++;
			}
		}
		throwArrowLuck(temp, team);
	}

	/**
	 * valida que equipo tiene mas puntos en una ronda, y aumenta la cantidad de
	 * rondas ganadas para el equipo con mas puntos
	 */
	private void valideTeamWinInLap() {
		if (this.teams.get(0).getParcialScore() > this.teams.get(1).getParcialScore()) {
			teamColombiaWins++;
		} else {
			teamUSAWins++;
		}
	}

	/**
	 * Metodo para recorrer los competidores, para que cada uno haga su lanzamiento
	 * le setea al marcador de equipo los puntos conseguidos por cada competidor
	 * 
	 * @param equipo
	 */
	private void throwArrowCompetitors(Team team) {
		for (Competitor competitor : team.getCompetitors()) {
			throwArrow(competitor);
			team.setParcialScore(competitor.getCompetitorScore());
			team.setScore(competitor.getCompetitorScore());
			if (competitor.getExperience() == competitor.getTopExperience()) {
				competitor.setIsRes(true);
			}
		}
	}

	/**
	 * Lanzamientos de cada competidor disminuye por cansancio la resistencia
	 * 
	 * @param competitor
	 */
	private void throwArrow(Competitor competitor) {
		switch (competitor.getGender()) {
		case FEMALE:
			for (int i = 0; i < competitor.getRes() / 5; i++) {
				competitor.setCompetitorScore(pointsInShotFemale(Math.random()));
			}
			valideCompetitorBonusRes(competitor);
			break;
		case MALE:
			for (int i = 0; i < competitor.getRes() / 5; i++) {
				competitor.setCompetitorScore(pointsInShotMale(Math.random()));
			}
			valideCompetitorBonusRes(competitor);
			break;
		}
	}

	private void valideCompetitorBonusRes(Competitor competitor) {
		if (competitor.isRes()) {
			valideBonusRes(competitor);
		} else {
			competitor.setRes((int) (Math.random() * 2 + 1));
		}
	}

	private void valideBonusRes(Competitor competitor) {
		if (competitor.getLapsNoRes() == 0) {
			competitor.setIsRes(false);
		} else {
			competitor.setLapsNoRes();
		}
	}

	/**
	 * Lanzamientos de cada competidor disminuye por cansancio la resistencia
	 * 
	 * @param competitor
	 */
	private void throwArrowLuck(Competitor competitor, Team team) {
		switch (competitor.getGender()) {
		case FEMALE:
			competitor.setCountLuck();
			for (int i = 0; i < competitor.getRes() / 5; i++) {
				team.setScore(pointsInShotFemale(Math.random()));
			}
			break;
		case MALE:
			competitor.setCountLuck();
			for (int i = 0; i < competitor.getRes() / 5; i++) {
				team.setScore(pointsInShotMale(Math.random()));
			}
			break;
		}
	}

	/**
	 * Asignacion de puntos para una mujer
	 * 
	 * @param xi numero psudoaleatorio
	 * @return puntos optenidos
	 */
	private int pointsInShotFemale(double xi) {
		if (xi > 0 && xi < 0.3) {
			return 10;
		} else if (xi >= 0.3 && xi < 0.68) {
			return 9;
		} else if (xi >= 0.68 && xi < 0.95) {
			return 8;
		}
		return 0;
	}

	/**
	 * Asignacion de puntos para un hombre
	 * 
	 * @param xi numero psudoaleatorio
	 * @return puntos optenidos
	 */
	private int pointsInShotMale(double xi) {
		if (xi > 0 && xi < 0.2) {
			return 10;
		} else if (xi >= 0.2 && xi < 0.53) {
			return 9;
		} else if (xi >= 0.53 && xi < 0.93) {
			return 8;
		}
		return 0;
	}

	/**
	 * Buscar un equipo
	 * 
	 * @return equipo
	 */
	private Team searchTeam(Competitor competitor) {
		for (Team team : teams) {
			for (Competitor c : team.getCompetitors()) {
				if (c.equals(competitor)) {
					return team;
				}
			}
		}
		return null;
	}

	/**
	 * 
	 * @return Cantidad de rondas ganadas por hombres
	 */
	public int getCountMaleWins() {
		return countMaleWins;
	}

	/**
	 * 
	 * @return Cantidad de rondas ganadas por mujeres
	 */
	public int getCountFemaleWins() {
		return countFemaleWins;
	}
}
