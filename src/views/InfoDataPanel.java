package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import models.Competitor;
import models.Gender;
import models.ReportLuck;
import models.Team;

public class InfoDataPanel extends JPanel {

	private String[] headerPlayersTable = { "# Juegos", "Jugador", "Suerte" };
	private String[] headerTeamsTable = { "Equipo", "Juegos Ganados", "Puntaje" };
	private String[] headerGenreTable = { "# Juegos", "Genero Ganador" };
	private static final long serialVersionUID = 1L;
	private DefaultTableModel modelPlayers;
	private DefaultTableModel modelTeams;
	private DefaultTableModel modelGender;
	private JLabel playerNameJLabel;
	private JLabel playerExperienceJLabel;
	private JLabel genreDataJLabel;

	public InfoDataPanel() {
		setLayout(new GridLayout(2, 2, 10, 10));
		setBackground(Color.WHITE);

		JPanel dataJPanelOne = new JPanel();
		dataJPanelOne.setLayout(new BorderLayout());
		dataJPanelOne.setBackground(Color.WHITE);
		dataJPanelOne.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
		JLabel tableTitleJLabel = new JLabel("Jugador con más suerte en cada uno de los juegos:");
		tableTitleJLabel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
		tableTitleJLabel.setFont(new Font("Arial", Font.BOLD, 18));
		dataJPanelOne.add(tableTitleJLabel, BorderLayout.PAGE_START);

		modelPlayers = new DefaultTableModel();
		modelPlayers.setColumnIdentifiers(headerPlayersTable);
		JTable tablePlayers = new JTable(modelPlayers);
		tablePlayers.getTableHeader().setBackground(Color.decode("#408AD2"));
		tablePlayers.getTableHeader().setBorder(BorderFactory.createLineBorder(Color.decode("#408AD2")));
		tablePlayers.getTableHeader().setForeground(Color.WHITE);
		tablePlayers.getTableHeader().setFont(new Font("Arial", Font.PLAIN, 14));
		tablePlayers.setBackground(Color.WHITE);
		tablePlayers.setForeground(Color.decode("#505050"));
		tablePlayers.setFont(new Font("Arial", Font.PLAIN, 12));
		tablePlayers.setBorder(BorderFactory.createLineBorder(Color.decode("#CECECE")));
		JScrollPane tablePlayersJScrollPane = new JScrollPane(tablePlayers);
		dataJPanelOne.add(tablePlayersJScrollPane, BorderLayout.CENTER);
		add(dataJPanelOne);

		JPanel dataJPanelTwo = new JPanel();
		dataJPanelTwo.setLayout(new BorderLayout());
		dataJPanelTwo.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
		dataJPanelTwo.setBackground(Color.WHITE);
		JLabel titleJLabel = new JLabel("Jugador con más experiencia al final de los 5000 juegos:");
		titleJLabel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
		titleJLabel.setFont(new Font("Arial", Font.BOLD, 18));
		dataJPanelTwo.add(titleJLabel, BorderLayout.PAGE_START);
		JPanel playerJPanel = new JPanel();
		playerJPanel.setLayout(new GridLayout(2, 1));
		playerJPanel.setBackground(Color.WHITE);
		playerNameJLabel = new JLabel("Jugador: En espera...", SwingConstants.CENTER);
		playerNameJLabel.setFont(new Font("Arial", Font.BOLD, 16));
		playerJPanel.add(playerNameJLabel);
		playerExperienceJLabel = new JLabel("Experiencia: 0", SwingConstants.CENTER);
		playerExperienceJLabel.setFont(new Font("Arial", Font.BOLD, 16));
		playerJPanel.add(playerExperienceJLabel);
		dataJPanelTwo.add(playerJPanel, BorderLayout.CENTER);
		add(dataJPanelTwo);

		JPanel dataJPanelThree = new JPanel();
		dataJPanelThree.setLayout(new BorderLayout());
		dataJPanelThree.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
		dataJPanelThree.setBackground(Color.WHITE);
		JLabel titleTeamJLabel = new JLabel("Equipo ganador incluyendo sus puntajes:");
		dataJPanelThree.setBackground(Color.WHITE);
		titleTeamJLabel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
		titleTeamJLabel.setFont(new Font("Arial", Font.BOLD, 18));
		dataJPanelThree.add(titleTeamJLabel, BorderLayout.PAGE_START);
		modelTeams = new DefaultTableModel();
		modelTeams.setColumnIdentifiers(headerTeamsTable);
		JTable tableTeams = new JTable(modelTeams);
		tableTeams.getTableHeader().setBackground(Color.decode("#408AD2"));
		tableTeams.getTableHeader().setBorder(BorderFactory.createLineBorder(Color.decode("#408AD2")));
		tableTeams.getTableHeader().setForeground(Color.WHITE);
		tableTeams.getTableHeader().setFont(new Font("Arial", Font.PLAIN, 14));
		tableTeams.setBackground(Color.WHITE);
		tableTeams.setForeground(Color.decode("#505050"));
		tableTeams.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		tableTeams.setBorder(BorderFactory.createLineBorder(Color.decode("#CECECE")));
		JScrollPane tableTeamsJScrollPane = new JScrollPane(tableTeams);
		dataJPanelThree.add(tableTeamsJScrollPane, BorderLayout.CENTER);
		add(dataJPanelThree);

		JPanel dataJPanelFour = new JPanel();
		dataJPanelFour.setLayout(new BorderLayout());
		dataJPanelFour.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
		dataJPanelFour.setBackground(Color.WHITE);
		JLabel titleGenreJLabel = new JLabel("Género con más victorias en cada juego:");
		titleGenreJLabel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
		titleGenreJLabel.setFont(new Font("Arial", Font.BOLD, 18));
		dataJPanelFour.add(titleGenreJLabel, BorderLayout.PAGE_START);
		JPanel genreJPanel = new JPanel();
		genreJPanel.setLayout(new GridLayout(1, 2));
		genreJPanel.setBackground(Color.WHITE);
		modelGender = new DefaultTableModel();
		modelGender.setColumnIdentifiers(headerGenreTable);
		JTable tableGender = new JTable(modelGender);
		tableGender.getTableHeader().setBackground(Color.decode("#408AD2"));
		tableGender.getTableHeader().setBorder(BorderFactory.createLineBorder(Color.decode("#408AD2")));
		tableGender.getTableHeader().setForeground(Color.WHITE);
		tableGender.getTableHeader().setFont(new Font("Arial", Font.PLAIN, 14));
		tableGender.setBackground(Color.WHITE);
		tableGender.setForeground(Color.decode("#505050"));
		tableGender.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		tableGender.setBorder(BorderFactory.createLineBorder(Color.decode("#CECECE")));
		JScrollPane tableGenreJScrollPane = new JScrollPane(tableGender);
		tableGenreJScrollPane.getVerticalScrollBar().setBackground(Color.decode("#f0f1f1"));
		tableGenreJScrollPane.getHorizontalScrollBar().setBackground(Color.decode("#f0f1f1"));
		tableGenreJScrollPane.setBorder(BorderFactory.createEmptyBorder());
		tableGenreJScrollPane.setBackground(Color.decode("#f0f1f1"));
		genreJPanel.add(tableGenreJScrollPane);
		JPanel genreDataJPanel = new JPanel();
		genreDataJPanel.setLayout(new GridLayout(2, 1, 5, 5));
		genreDataJPanel.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
		genreDataJPanel.setBackground(Color.WHITE);
		JLabel genreTitleJLabel = new JLabel("Genero con más victorias totales:", SwingConstants.CENTER);
		genreTitleJLabel.setFont(new Font("Arial", Font.BOLD, 14));
		genreTitleJLabel.setBackground(getBackground());
		genreDataJPanel.add(genreTitleJLabel);
		genreDataJLabel = new JLabel("En espera...", SwingConstants.CENTER);
		genreDataJLabel.setFont(new Font("Arial", Font.BOLD, 18));
		genreDataJPanel.add(genreDataJLabel);
		genreJPanel.add(genreDataJPanel);
		dataJPanelFour.add(genreJPanel, BorderLayout.CENTER);
		add(dataJPanelFour);

		emptyRows();
	}

	private void emptyRows() {
		for (int i = 0; i < 10; i++) {
			modelPlayers.addRow(new Object[] {});
			modelTeams.addRow(new Object[] {});
			modelGender.addRow(new Object[] {});
		}
	}

	public void clearTables() {
		modelPlayers.setRowCount(0);
		modelTeams.setRowCount(0);
		modelGender.setRowCount(0);
	}

	public void showPlayerInTable(int lap, ReportLuck player) {
		modelPlayers.addRow(new Object[] { lap, player.getName(), player.getLuck() });
	}

	public void showTeamsInTable(Team team) {
		modelTeams.addRow(new Object[] { team.getTeamName(), team.getCountWinGame(), team.getScore() });
	}

	public void showGenderInTable(int lap, Gender gender) {
		modelGender.addRow(new Object[] { lap, gender });
	}

	public void setCompetitor(Competitor competitor) {
		playerNameJLabel.setText("Jugador: " + competitor.getName());
		playerExperienceJLabel.setText("Experiencia: " + competitor.getExperience());
	}

	public void setTheBestGender(Gender gender) {
		genreDataJLabel.setText(gender.toString());
	}
}