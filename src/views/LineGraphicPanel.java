package views;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import models.Team;

public class LineGraphicPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private XYSeriesCollection xyDataset;

	public LineGraphicPanel() {
		setLayout(new BorderLayout());
		xyDataset = new XYSeriesCollection();
		JFreeChart xylineChart = ChartFactory.createXYLineChart("Puntaje Total de los Equipos por Ronda", "Rondas",
				"Puntaje de Equipos", xyDataset, PlotOrientation.VERTICAL, true, true, false);
		XYPlot plot = xylineChart.getXYPlot();
		XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
		renderer.setSeriesPaint(0, Color.RED);
		renderer.setSeriesPaint(1, Color.GREEN);
		renderer.setSeriesPaint(2, Color.YELLOW);
		renderer.setSeriesStroke(0, new BasicStroke(4.0f));
		renderer.setSeriesStroke(1, new BasicStroke(3.0f));
		renderer.setSeriesStroke(2, new BasicStroke(2.0f));
		plot.setRenderer(renderer);
		ChartPanel chartPanel = new ChartPanel(xylineChart);
		add(chartPanel, BorderLayout.CENTER);
	}

	public void graphicTeamsData(ArrayList<Team> teams) {
		for (int i = 0; i < teams.size(); i++) {
			XYSeries player = new XYSeries(teams.get(i).getTeamName());
			ArrayList<Integer> labPoints = teams.get(i).getLabPoints();
			for (int j = 0; j < teams.get(i).getLabPoints().size(); j++) {
				player.add((j + 1), labPoints.get(j));
			}
			xyDataset.addSeries(player);
		}
	}
}