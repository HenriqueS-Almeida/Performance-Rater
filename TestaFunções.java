package grafico;

public class TestaFun��es {
	public static void main(String[] args) {
		Fun��esBase f1 = new Fun��esBase();
		

		f1.alterarNota(1, 7);
		f1.alterarNota(2, 8);
		f1.alterarNota(3, 2);
		System.out.println(f1.calcularMedia());
		System.out.println(f1.calcularAprovacao());
	}

}
