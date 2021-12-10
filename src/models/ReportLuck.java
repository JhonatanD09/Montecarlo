package models;

public class ReportLuck {

	private String name;
	private float luck;
	
	public ReportLuck(String name, float luck) {
		this.name = name;
		this.luck = luck;
	}
	
	public float getLuck() {
		return luck;
	}
	
	public String getName() {
		return name;
	}	
}