package testeIO;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class EntradaDeUmArquivo {
    public static void main(String[] args) throws IOException {
        //InputStream is = new FileInputStream("src/testeIO/leitura.txt"); //para ler um arquivo
        InputStream is = System.in; // para ler o input do teclado
        Scanner entrada = new Scanner(is);

        System.out.println("Digite sua mensagem:");
        while (entrada.hasNextLine()) {//loop para verificação de linhas
            System.out.println(entrada.nextLine());
        }
        
        /*Para escrever em outro Arquivo*/
        OutputStream os = new FileOutputStream("src/testeIO/saida.txt");        
        OutputStreamWriter osw = new OutputStreamWriter(os);
        BufferedWriter bw = new BufferedWriter(osw);
        
        while (entrada.hasNextLine()) {
            String linha = entrada.nextLine();
            bw.write(linha);
            bw.newLine(); 
        }
        bw.close();
        entrada.close();
    }
}