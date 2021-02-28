package controller;

public class Struct {
	double tempo;
	int piloto;
	int id;
	int volta;
	
	public Struct(double tempo, int piloto, int id, int volta) {
		
		this.tempo = tempo;
		this.piloto = piloto;
		this.id = id;
		this.volta = volta;
		
	}
	
	public Struct() {
		this(0.0, 0, 0, 0);
	}
	
}
