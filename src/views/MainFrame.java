package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import controller.Actions;
import models.Competitor;
import models.Gender;
import models.ReportLuck;
import models.Team;

public class MainFrame extends JFrame {

	private static final int TITLE_SIZE = 28;
	private static final int TITLE_MARGIN = 20;
	private static final long serialVersionUID = 1L;
	private TabbedPane tabbedPane;
	private JLabel roundJLabel;

	public MainFrame(ActionListener actionListener, ArrayList<Team> teams) {
		setExtendedState(MAXIMIZED_BOTH);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setMinimumSize(new Dimension(1024, 720));
		setLocationRelativeTo(this);
		getContentPane().setBackground(Color.WHITE);
		setTitle("Montecarlo");

		JLabel titleJLabel = new JLabel("Un Problema Montecarlo", SwingConstants.CENTER);
		titleJLabel.setBorder(BorderFactory.createEmptyBorder(TITLE_MARGIN, TITLE_MARGIN, TITLE_MARGIN, TITLE_MARGIN));
		titleJLabel.setFont(new Font("Arial", Font.BOLD, TITLE_SIZE));
		add(titleJLabel, BorderLayout.PAGE_START);

		tabbedPane = new TabbedPane();
		add(tabbedPane, BorderLayout.CENTER);

		JPanel optionsJPanel = new JPanel();
		optionsJPanel.setLayout(new GridLayout(1, 2, 10, 0));
		optionsJPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		optionsJPanel.setBackground(Color.WHITE);

		JPanel gameInfoJPanel = new JPanel();
		gameInfoJPanel.setLayout(new GridLayout(2, 1));
		gameInfoJPanel.setBackground(Color.WHITE);
		JPanel infoGameJPanel = new JPanel();
		infoGameJPanel.setLayout(new GridLayout(1, 3, 10, 0));
		infoGameJPanel.setBackground(Color.WHITE);
		JPanel teamOneInfoJPanel = new JPanel();
		teamOneInfoJPanel.setLayout(new FlowLayout());
		teamOneInfoJPanel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		teamOneInfoJPanel.setBackground(Color.WHITE);
		JLabel flagCO = new JLabel(new ImageIcon("src/img/CO.png"));
		teamOneInfoJPanel.add(flagCO);
		JLabel teamOneJLabel = new JLabel(teams.get(0).getTeamName());
		teamOneJLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		teamOneJLabel.setFont(new Font("Arial", Font.BOLD, 14));
		teamOneInfoJPanel.add(teamOneJLabel);
		infoGameJPanel.add(teamOneInfoJPanel);
		JLabel vsJLabel = new JLabel("Vs", SwingConstants.CENTER);
		vsJLabel.setFont(new Font("Arial", Font.BOLD, 18));
		infoGameJPanel.add(vsJLabel);
		JPanel teamTwoInfoJPanel = new JPanel();
		teamTwoInfoJPanel.setLayout(new FlowLayout());
		teamTwoInfoJPanel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		teamTwoInfoJPanel.setBackground(Color.WHITE);
		JLabel flagUS = new JLabel(new ImageIcon("src/img/US.png"));
		teamTwoInfoJPanel.add(flagUS);
		JLabel teamTwoJLabel = new JLabel(teams.get(1).getTeamName());
		teamTwoJLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		teamTwoJLabel.setFont(new Font("Arial", Font.BOLD, 14));
		teamTwoInfoJPanel.add(teamTwoJLabel);
		infoGameJPanel.add(teamTwoInfoJPanel);
		gameInfoJPanel.add(infoGameJPanel);

		roundJLabel = new JLabel("Juegos: " + 0, SwingConstants.CENTER);
		roundJLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		roundJLabel.setFont(new Font("Arial", Font.BOLD, 16));
		gameInfoJPanel.add(roundJLabel);

		optionsJPanel.add(gameInfoJPanel);

		JPanel buttonsJPanel = new JPanel();
		buttonsJPanel.setLayout(new GridLayout(1, 2, 25, 25));
		buttonsJPanel.setBackground(Color.WHITE);

		JButton addTotalRoundsJButton = new JButton("Agregar Juegos");
		addTotalRoundsJButton.addActionListener(actionListener);
		addTotalRoundsJButton.setActionCommand(Actions.ADD_TOTAL_ROUNDS.toString());
		addTotalRoundsJButton.setFocusable(false);
		addTotalRoundsJButton.setBackground(Color.decode("#998CEB"));
		addTotalRoundsJButton.setForeground(Color.WHITE);
		addTotalRoundsJButton.setFont(new Font("Arial", Font.BOLD, 14));
		addTotalRoundsJButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		addTotalRoundsJButton.setBorder(BorderFactory.createEmptyBorder());
		buttonsJPanel.add(addTotalRoundsJButton);

		JButton startGameJButton = new JButton("Iniciar Juego");
		startGameJButton.addActionListener(actionListener);
		startGameJButton.setActionCommand(Actions.START_GAME.toString());
		startGameJButton.setFocusable(false);
		startGameJButton.setBackground(Color.decode("#49FF00"));
		startGameJButton.setForeground(Color.WHITE);
		startGameJButton.setFont(new Font("Arial", Font.BOLD, 14));
		startGameJButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		startGameJButton.setBorder(BorderFactory.createEmptyBorder());
		buttonsJPanel.add(startGameJButton);

		optionsJPanel.add(buttonsJPanel);

		add(optionsJPanel, BorderLayout.PAGE_END);
	}

	public void setRoundsText(int rounds) {
		roundJLabel.setText("Rondas: " + rounds);
	}

	public void clearTables() {
		tabbedPane.clearTables();
	}

	public void showPlayerInTable(int lap, ReportLuck player) {
		tabbedPane.showPlayerInTable(lap, player);
	}

	public void showTeamsInTable(Team team) {
		tabbedPane.showTeamsInTable(team);
	}

	public void showGenderInTable(int lap, Gender gender) {
		tabbedPane.showGenderInTable(lap, gender);
	}

	public void setCompetitor(Competitor competitor) {
		tabbedPane.setCompetitor(competitor);
	}

	public void setTheBestGender(Gender gender) {
		tabbedPane.setTheBestGender(gender);
	}

	public void graphicPlayerData(ArrayList<Competitor> competitors) {
		tabbedPane.graphicPlayerData(competitors);
	}

	public void graphicTeamsData(ArrayList<Team> teams) {
		tabbedPane.graphicTeamsData(teams);
	}
}