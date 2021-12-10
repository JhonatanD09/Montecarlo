package views;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JTabbedPane;
import javax.swing.LookAndFeel;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.basic.BasicTabbedPaneUI;

import models.Competitor;
import models.Gender;
import models.ReportLuck;
import models.Team;

public class TabbedPane extends JTabbedPane {

	private static final long serialVersionUID = 1L;
	private InfoDataPanel infoDataPanel;
	private DispersionGraphicPanel dispersionGraphicPanel;
	private LineGraphicPanel lineGraphicPanel;

	public TabbedPane() {
		setFocusable(false);
		setBorder(BorderFactory.createLineBorder(Color.WHITE));
		setBackground(Color.WHITE);
		setForeground(Color.DARK_GRAY);
		UIManager.put("TabbedPane.selected", Color.WHITE);
		LookAndFeel.installColorsAndFont(this, "TabbedPane.background", "TabbedPane.foreground", "TabbedPane.font");
		UIManager.put("TabbedPane.contentAreaColor", new ColorUIResource(Color.WHITE));

		infoDataPanel = new InfoDataPanel();
		dispersionGraphicPanel = new DispersionGraphicPanel();
		lineGraphicPanel = new LineGraphicPanel();

		addTab("Tablas Generales", infoDataPanel);
		addTab("Gráfica 1", dispersionGraphicPanel);
		addTab("Gráfica 2", lineGraphicPanel);

		this.setUI(new BasicTabbedPaneUI() {
			@Override
			protected void installDefaults() {
				super.installDefaults();
				highlight = Color.WHITE;
				lightHighlight = Color.DARK_GRAY;
				shadow = Color.DARK_GRAY;
				darkShadow = Color.WHITE;
				focus = Color.WHITE;
			}
		});
	}

	public void clearTables() {
		infoDataPanel.clearTables();
	}

	public void showPlayerInTable(int lap, ReportLuck player) {
		infoDataPanel.showPlayerInTable(lap, player);
	}

	public void showTeamsInTable(Team team) {
		infoDataPanel.showTeamsInTable(team);
	}

	public void showGenderInTable(int lap, Gender gender) {
		infoDataPanel.showGenderInTable(lap, gender);
	}

	public void setCompetitor(Competitor competitor) {
		infoDataPanel.setCompetitor(competitor);
	}

	public void setTheBestGender(Gender gender) {
		infoDataPanel.setTheBestGender(gender);
	}

	public void graphicPlayerData(ArrayList<Competitor> competitors) {
		dispersionGraphicPanel.graphicPlayerData(competitors);
	}

	public void graphicTeamsData(ArrayList<Team> teams) {
		lineGraphicPanel.graphicTeamsData(teams);
	}
}