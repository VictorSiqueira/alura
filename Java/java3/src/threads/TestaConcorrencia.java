package threads;

public class TestaConcorrencia {

	public static void main(String[] args) {
		
		BarraDeProgesso barra = new BarraDeProgesso();
		Thread t1 = new Thread(barra);
		t1.start();
		
		CopiadorDeArquivos copiador = new CopiadorDeArquivos();
		Thread t2 = new Thread(copiador);
		t2.start();
	}
	
	//para alterar alguem que tenha um metodo que fa�a alter��o
	//o ideal � por um modificador syncronized nesse metodo
	//e apos o start das threads, vc chama o metodo join();

}
