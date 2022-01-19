package jogo;

public class MecanicaHard implements MecanicaDoJogo{

    private boolean mErrou = false;
    private BancoDePalavras mPalavras = new BancoDePalavras();
    private int mPalavrasCertas = 0;
    
    @Override
    public String getNome() {
        return "Modo Hard";
    }

    @Override
    public String getDescricao() {
        return "Se voc� errar a palavra o jogo termina!";
    }

    @Override
    public boolean isAcabou() {
        return mErrou;
    }

    @Override
    public String getPalavra() {
        return mPalavras.getNext();
    }

    @Override
    public String tentativa(String palavra, String resposta) {
        if(palavra.equals(resposta)){
            mPalavrasCertas++;
            return "Acertou. Parab�ns!";
        }else{
            mErrou = true;
            return "Voc� errou!";
        }
    }

    @Override
    public String getResultadoFinal() {
        return "\nTotal de pontos: " + mPalavrasCertas;
    }
    
}
