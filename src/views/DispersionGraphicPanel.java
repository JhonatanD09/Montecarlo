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

import models.Competitor;

public class DispersionGraphicPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private XYSeriesCollection xyDataset;

	public DispersionGraphicPanel() {
		setLayout(new BorderLayout());
		xyDataset = new XYSeriesCollection();
		JFreeChart xylineChart = ChartFactory.createXYLineChart("Puntaje Total de los Jugadores por Ronda", "Rondas",
				"Puntaje de Jugadores", xyDataset, PlotOrientation.VERTICAL, false, true, false);
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

	public void graphicPlayerData(ArrayList<Competitor> competitors) {
		for (int i = 0; i < competitors.size(); i++) {
			XYSeries player = new XYSeries(competitors.get(i).getName());
			System.out.println(competitors.get(i).getPointsToLap().size());
			for (int j = 0; j < competitors.get(i).getPointsToLap().size(); j++) {
				double labs = (double) competitors.get(i).getPointsToLap().get(j);
				player.add((j + 1), labs);
			}
			xyDataset.addSeries(player);
		}
	}
}