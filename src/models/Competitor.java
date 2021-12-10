package models;

import java.util.ArrayList;

import com.uptc.utils.Interval;
import com.uptc.models.methods.Uniform;

/**
 * 
 * @author jhona Clase competidor
 */
public class Competitor {
	
	
	
	private final int INITIAL_RES = (int) (30 + random(0, 10));

	private String name;
	private int res;
	private int experience;
	private float luck;
	private int countLuck;
	private int countLapsWin;
	private int competitorScore;
	private Gender gender;
	private ArrayList<Integer> pointsToLap;
	private int lapsNoRes;
	private boolean isRes;
	private int topExperience;

	/**
	 * Constructor de la clase
	 * 
	 * @param gender genero del competidor
	 * @param name   nombre del competidor
	 */
	public Competitor(String name, Gender gender) {
		this.name = name;
		this.res = INITIAL_RES;
		this.experience = 10;
		this.luck = (float)random(0, 4) ;
		this.countLuck = 0;
		this.countLapsWin = 0;
		this.gender = gender;
		this.competitorScore = 0;
		this.pointsToLap = new ArrayList<>();
		this.topExperience = experience + 9;
		this.lapsNoRes = 3;
		this.isRes = false;
	}

	private double random(int min, int max) {
		Uniform xiUniform = new Uniform(1);
		Interval interval = new Interval(0, 10, xiUniform.getAleatory());
		return interval.getInterval().get(0);
	}
	
	/**
	 * @return nombre del competidor
	 */
	public String getName() {
		return name;
	}

	/**
	 * 
	 * @return cantidad de rondas sin gastar resistencia
	 */
	public int getLapsNoRes() {
		return lapsNoRes;
	}

	/*
	 * disminuye la cantidad de rondas sin gastar experiencia
	 */
	public void setLapsNoRes() {
		this.lapsNoRes--;
	}

	/**
	 * 
	 * @return el top de experiecia a conseguir para no perder resistencia
	 */
	public int getTopExperience() {
		return topExperience;
	}

	/**
	 * cambia el valor de tope cuando este es alcanzado
	 */
	public void setTopExperience() {
		this.topExperience = (this.topExperience + 9);
	}

	/**
	 * 
	 * @return boolean que indica si consume o no resistencia
	 */
	public boolean isRes() {
		return isRes;
	}

	/**
	 * cambia el valor de si consume o no resistencia
	 * 
	 * @param isRes
	 */
	public void setIsRes(boolean isRes) {
		this.isRes = isRes;
	}

	/**
	 * Llamado de la resistencia del jugador
	 * 
	 * @return resistencia del jugador
	 */
	public int getRes() {
		return res;
	}

	/**
	 * Disminuye la resistencia del competidor por cansancio
	 */
	public void setRes(int valueTiredness) {
		this.res = (this.res - valueTiredness);
	}

	/**
	 * @return experiencia del competidor
	 */
	public int getExperience() {
		return experience;
	}

	/**
	 * Aumenta la experiencia del competidor en 3 puntos
	 */
	public void setExperience() {
		this.experience = (this.experience + 3);
	}

	/**
	 * @return factor de suerte del competidor
	 */
	public float getLuck() {
		return luck;
	}

	/**
	 * Reinicia el factor de suerte del competidor
	 */
	public void setLuck() {
		this.luck = (float)random(0, 4);
	}


	/**
	 * @return cantidad de veces que el competidor tenia la mayor suerte
	 */
	public int getCountLuck() {
		return countLuck;
	}

	/**
	 * Reinicia el contador de la cantidad de veces que el competidor tubo mayor
	 * suerte
	 */
	public void setCountLuck() {
		this.countLuck++;
	}

	public void resetCountLuck() {
		this.countLuck = 0;
	}

	/**
	 * @return Cantidad de rondas ganadas por un competidor
	 */
	public int getCountLapsWin() {
		return countLapsWin;
	}

	/**
	 * Reinicia la cantidad de rondas ganadas por un competidor
	 */
	public void setCountLapsWin() {
		this.countLapsWin = 0;
	}

	/**
	 * @return genero del competidor
	 */
	public Gender getGender() {
		return gender;
	}

	/**
	 * Reinicia la resistencia del jugador
	 */
	public void resetRes() {
		this.res = INITIAL_RES;
	}

	/**
	 * @return puntos optenidos por un competidor
	 */
	public int getCompetitorScore() {
		return competitorScore;
	}

	/**
	 * Aumenta la cantidad de puntos que consigue un jugador
	 * 
	 * @param competitorScore cantidad de puntos a aumentar
	 */
	public void setCompetitorScore(int competitorScore) {
		this.competitorScore = (this.competitorScore + competitorScore);
	}

	/**
	 * Reinicia los puntos optenidos por un competidor
	 */
	public void resetCompetitorScore() {
		this.competitorScore = 0;
	}

	/**
	 * Agrega a la lista los puntos que tiene cada jugador en una ronda
	 */
	public void addPointToLab() {
		this.pointsToLap.add(getCompetitorScore());
	}

	/**
	 * 
	 * @return Lista de puntos optenidos por ronda disputada de cada jugador
	 */
	public ArrayList<Integer> getPointsToLap() {
		return pointsToLap;
	}
	
}