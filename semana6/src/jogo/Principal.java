package jogo;

import java.util.Scanner;

public class Principal extends JavaUtils{
	
	
    private static Scanner mOpcao;
	private static Scanner scanner;

	public static void main(String[] args){

        mOpcao = new Scanner(System.in);
        scanner = new Scanner(System.in);
        
  
        printLN(" ESCOLHA A MECÂNICA DO JOGO ");
        printLN("1 - Uma tentativa (Hard).");
        printLN("2 - Três tentativas (Easy).");
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
	            printLN("Opção invalida, programa terminado");
	            System.exit(0);
	         break;
	   } 


        MecanicaDoJogo mecanicaDoJogo = FabricaMecanicaDoJogo.get();

        printLN(" START ");
        printLN("Você vai jogar no modo: " + mecanicaDoJogo.getNome());
        printT("Descrição: " + mecanicaDoJogo.getDescricao());
        
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
