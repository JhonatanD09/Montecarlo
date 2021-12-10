package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import models.Champions;
import models.Competitor;
import models.Gender;
import models.ReportLuck;
import models.Team;
import views.MainFrame;

public class Control implements ActionListener {

	private Champions champions;
	private MainFrame mainFrame;
	private int totalRounds;

	public Control() {
		data();
		init();
	}

	private void data() {
		ArrayList<Competitor> competitorsColombia = new ArrayList<>();
		for (int i = 0; i < 6; i++) {
			competitorsColombia.add(new Competitor("Colombia Player: " + (i + 1), Champions.gender()));
		}
		Team teamColombia = new Team("Colombia", competitorsColombia);
		ArrayList<Competitor> competitorsUSA = new ArrayList<>();
		for (int i = 0; i < 6; i++) {
			competitorsUSA.add(new Competitor("USA Player: " + (i + 1), Champions.gender()));
		}
		Team teamUSA = new Team("USA", competitorsUSA);

		ArrayList<Team> teams = new ArrayList<>();
		teams.add(teamColombia);
		teams.add(teamUSA);

		champions = new Champions(teams);
		mainFrame = new MainFrame(this, teams);
	}

	private void init() {
		totalRounds = 0;
		mainFrame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (Actions.valueOf(e.getActionCommand())) {
		case ADD_TOTAL_ROUNDS:
			addTotalRounds();
			break;
		case START_GAME:
			startGame();
			break;
		default:
			break;
		}
	}

	private void addTotalRounds() {
		totalRounds = Integer.valueOf(JOptionPane.showInputDialog("Por favor, agregar la cantidad de juegos:"));
		mainFrame.setRoundsText(totalRounds);
	}

	private void startGame() {
		if (totalRounds != 0) {
			champions.startChampion(totalRounds);
			mainFrame.clearTables();

			ArrayList<ReportLuck> competitors = champions.getLucksCompetitors();
			for (int i = 0; i < competitors.size(); i++) {
				mainFrame.showPlayerInTable((i + 1), competitors.get(i));
			}

			Competitor theBestCompetitor = champions.getCompetitorMaxExperience();
			mainFrame.setCompetitor(theBestCompetitor);

			Team theBestTeam = champions.winGame();
			mainFrame.showTeamsInTable(theBestTeam);

			ArrayList<Gender> theBestGenders = champions.getGenderStacts();
			for (int i = 0; i < theBestGenders.size(); i++) {
				mainFrame.showGenderInTable(i + 1, theBestGenders.get(i));
			}

			Gender gender = champions.getTheBestGender();
			mainFrame.setTheBestGender(gender);

			mainFrame.graphicPlayerData(champions.getCompetitors());

			mainFrame.graphicTeamsData(champions.getTeams());

			System.out.println("Iniciando Juego...");
		} else {
			JOptionPane.showMessageDialog(mainFrame, "No tiene la cantidad de rondas");
		}
	}
}