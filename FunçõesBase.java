package grafico;


import java.util.LinkedList;
import java.util.List;

public class FunçõesBase{
	
	private List<Double> notas = new LinkedList<Double>();
	private Double mediaAnual = 6.0;
	
	public FunçõesBase() {
		this.notas.add(0, -1.0);
		this.notas.add(1, -1.0);
		this.notas.add(2, -1.0);
		this.notas.add(3, -1.0);
	}
	public FunçõesBase(Double mediaAnual) {
		this.mediaAnual=mediaAnual;
		this.notas.add(0, -1.0);
		this.notas.add(1, -1.0);
		this.notas.add(2, -1.0);
		this.notas.add(3, -1.0);
	}
	
	public Double getMediaBimestral(int bim) {
		return notas.get(bim-1);
	}
	
	public Double getMediaAnual() {
		return this.mediaAnual;
	}
	
	public void alterarNota(int bim, double nota){
		this.notas.set(bim-1, nota);
	}
	
	public Double calcularMedia() {
		Double media = 0.0;
		int cont = 0;
		for(int i = 0;i<=3;i++) {
			if(notas.get(i)>=0) {
			media =+ notas.get(i);
			cont++;
			}
		}
		if(cont!=0) {
		media = media/cont; 
		return media;
		}else 
			return 0.0;
	}
	
	public Double calcularAprovacao() {
		Double media = 0.0;
		int cont = 0;
		if(calcularMedia()<mediaAnual) {
			media = mediaAnual-calcularMedia();
			return media;
		}else {
			for(int i = 0;i<=3;i++) {
				if(notas.get(i)>=0) {
				media =+ notas.get(i);
				if(i>0)
				mediaAnual+=mediaAnual;
				cont++;
				}
			}
			if(cont!=0) {
			media = media-mediaAnual; 
			return media;
			}else
			
			return media=0.0;
		}
	}
}
