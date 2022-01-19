package Test.Embaralhador;

import static org.junit.Assert.*;

import org.junit.Test;

import jogo.PalavraInversa;
import jogo.PalavraTrocaParImpar;

public class TestEmbaralhador {

	 @Test
	    public void tesInversor() {
	        PalavraInversa palavras = new PalavraInversa();
	        String resultado = palavras.embaralhar("CAJU");
	        assertEquals("UJAC", resultado);
	    }
	    
	    @Test
	    public void tesTrocaParImpar() {
	        PalavraTrocaParImpar palavras = new PalavraTrocaParImpar();
	        String resultado = palavras.embaralhar("CAJU");
	        assertEquals("UJAC", resultado);
	    }

}
