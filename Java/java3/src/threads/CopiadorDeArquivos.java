package threads;

//é necessario implementar Runnable para que a classe possa ser disparada por uma thread
public class CopiadorDeArquivos implements Runnable {
	@Override
	public void run() {
		for(int i  =0; i < 10000; i++){
			System.out.println("copiador");
		}
	}

}
