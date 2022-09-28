package grafico;

public class TestaFunções {
	public static void main(String[] args) {
		FunçõesBase f1 = new FunçõesBase();
		

		f1.alterarNota(1, 7);
		f1.alterarNota(2, 8);
		f1.alterarNota(3, 2);
		System.out.println(f1.calcularMedia());
		System.out.println(f1.calcularAprovacao());
	}

}
