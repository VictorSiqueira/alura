package testeIO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


public class TestaEntrada {
    public static void main(String[] args) throws IOException {
    	//  lerSystemIn();
    	lerFile();
    }
    
    
    /**
     * Metodo de teste para ler o System.in
     * @author victor.justino *
     */
    private static void lerSystemIn() {
    	InputStream is = System.in;
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);

        System.out.println("Digite sua mensagem:");        
        try {
        	String linha = br.readLine();
	        while (linha != null) {
	            System.out.println(linha);           
				linha = br.readLine();
	        }
	        //ao fechar a comunica��o com o BufferedReader,
	        //ele mesmo j� trata de fechar os recursos dos 
	        //quais ele depende.
	        br.close();	
		} catch (IOException e) {
			e.printStackTrace();
		}
			
    }
    
    
    /**
     * Metodo de teste para ler um arquivo
     * @author victor.justino *
     */
    private static void lerFile() {    	
        try {
        	File file = new File("src/testeIO/leitura.txt");
        	
        	/**
        	 * Qualquer classe que seja um InputStream serve aqui. 
        	 * As que a pr�pria API do Java traz consigo s�o 
        	 * encontradas na documenta��o da pr�pria InputStream
        	 * no campo Direct Known Subclasses.
        	 * 
        	 * AudioInputStream, ByteArrayInputStream, 
        	 * FileInputStream, InputStream (do CORBA),
        	 * ObjectInputStream, PipedInputStream,
        	 * SequenceInputStream, StringBufferInputStream,
        	 * FilterInputStream.
        	 * 
        	 * Essa �ltima, ainda tem suas filhas que, ainda que
        	 * indiretamente, tamb�m s�o um InputStream. S�o elas:
        	 * BufferedInputStream, CheckedInputStream, 
        	 * CipherInputStream, DataInputStream, 
        	 * DeflaterInputStream, DigestInputStream, 
        	 * InflaterInputStream, LineNumberInputStream,
        	 * ProgressMonitorInputStream, PushbackInputStream.
        	 */
        	InputStream is = new FileInputStream(file);
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
           /* mesmo codigo de cima resumido em 1 linha
            BufferedReader br = new BufferedReader(
            		new InputStreamReader(
                        new FileInputStream("arquivo.txt")));*/

        	String linha = br.readLine();
	        while (linha != null) {
	            System.out.println(linha);           
				linha = br.readLine();
	        }
	        br.close();	
		} catch (IOException e) {
			e.printStackTrace();
		}	
    }    
}


