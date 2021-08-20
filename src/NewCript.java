import java.util.Scanner;

public class NewCript {

	public static void main(String[] args) {
		
		try {
       	 
        	
            Scanner entrada = new Scanner(System.in);


            System.out.println("*****************************************************");


            // Informa texto e chave de criptografia

            System.out.print("Informe o texto a ser criptografado: ");

            String texto = entrada.nextLine();

            System.out.print("Informe a chave: ");

            String chave = entrada.next();


            // Criptografando

            String textoCriptografado = " "; 
            textoCriptografado = encriptarComChave(chave, texto);

            // Descriptografando

            String textoDescriptografado = decriptarComChave(chave, textoCriptografado);


            // Imprimindo no CONSOLE os resultados

            System.out.println("\n\nTEXTO CRIPTOGRAFADO   : " + textoCriptografado);

            System.out.println("TEXTO DESCRIPTOGRAFADO: " + textoDescriptografado);


            System.out.println("*****************************************************");


        } catch (RuntimeException e) { // Trata erro de digitacao

            System.out.println("A chave de deslocamento foi informada incorretamente.");

            System.out.println("Execute o programa novamente e entre com uma chave valida.");

        }
	
	}



public static String encriptarComChave(String chave, String texto){
	
	String textoCifrado = "";
	
	int tamanhoTexto = texto.length();
	int letraCifradaASCII;
		
	// Criptografa cada caractere por vez 
	for(int c=0; c < tamanhoTexto; c++){
		// pega o codigo ASCII e faz a criptografia
		// não criptografa espaço.
		int letranormal = ((int) texto.charAt(c));
		if (letranormal != 32)
			letraCifradaASCII = ((int) texto.charAt(c)) + ((int) chave.charAt(c % chave.length()));
		else
			letraCifradaASCII = ((int) texto.charAt(c));
			
			// Verifica se o codigo ASCII esta no limite dos 			// caracteres imprimiveis
		while(letraCifradaASCII > 126)  {
				letraCifradaASCII -= 94;
		}
		textoCifrado = textoCifrado + (char)letraCifradaASCII;
		}
		
		// retorna a mensagem criptografada por completo
		return textoCifrado;
	}




public static String decriptarComChave(String chave, String textoCifrado)  {
	// Variavel que ira guardar o texto decifrado
	String texto = "";
	int tamanhoTexto = textoCifrado.length();
	int letraDecifradaASCII=0;
		
	// Deografa cada caractere por vez
	for(int c=0; c < tamanhoTexto; c++)   {
		int letracifradaASCII = (int) textoCifrado.charAt(c);
		if (letracifradaASCII != 32)
			letraDecifradaASCII = ((int) textoCifrado.charAt(c)) - ((int) chave.charAt(c % chave.length()));
		else
			letraDecifradaASCII = ((int) textoCifrado.charAt(c));
		// Verifica se o codigo ASCII esta no limite dos caracteres 		
		// imprimiveis
		while(letraDecifradaASCII < 32)
			letraDecifradaASCII += 94;

		// Transforma codigo ASCII deografado em caracter 		// ao novo texto
		texto = texto + (char)letraDecifradaASCII ;
	}
		
	return texto;
}

}
	