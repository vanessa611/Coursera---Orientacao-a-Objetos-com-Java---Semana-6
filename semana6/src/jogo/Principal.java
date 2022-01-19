package jogo;

import java.util.Scanner;

public class Principal extends JavaUtils{
	
	
    private static Scanner mOpcao;
	private static Scanner scanner;

	public static void main(String[] args){

        mOpcao = new Scanner(System.in);
        scanner = new Scanner(System.in);
        
  
        printLN(" ESCOLHA A MEC�NICA DO JOGO ");
        printLN("1 - Uma tentativa (Hard).");
        printLN("2 - Tr�s tentativas (Easy).");
        printT("->");
        int opcao = mOpcao.nextInt();
	    switch(opcao){
	         case 1:
	            FabricaMecanicaDoJogo.set(new MecanicaHard());
	            break;
	         case 2: 
	            FabricaMecanicaDoJogo.set(new MecanicaEasy());
	            break;
	         default:
	            printLN("Op��o invalida, programa terminado");
	            System.exit(0);
	         break;
	   } 


        MecanicaDoJogo mecanicaDoJogo = FabricaMecanicaDoJogo.get();

        printLN(" START ");
        printLN("Voc� vai jogar no modo: " + mecanicaDoJogo.getNome());
        printT("Descri��o: " + mecanicaDoJogo.getDescricao());
        
        espaco();
        
        while(!mecanicaDoJogo.isAcabou()){
            String palavra = mecanicaDoJogo.getPalavra();
            Embaralhador embaralhador = FabricaEmbaralhadora.getRandom();
            String embaralhada = embaralhador.embaralhar(palavra);
            
            printLN("Adivinhe a palavra: " + embaralhada);
            printT("-> ");
            String resposta = scanner.nextLine().toUpperCase();
            String resultado = mecanicaDoJogo.tentativa(palavra, resposta);
            printLN("Resultado: " + resultado);
        }
        
        printLN(mecanicaDoJogo.getResultadoFinal());
    }
}
