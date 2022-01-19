package jogo;

public class MecanicaEasy implements MecanicaDoJogo{

    private int mQtdPalavrasErradas = 3;
    private BancoDePalavras mPalavras = new BancoDePalavras();
    private int mPontos = 0;
    
    @Override
    public String getNome() {
        return "Modo Easy.";
    }

    @Override
    public String getDescricao() {
        return "A cada palavra errada voc� perder� um ponto, o jogo termina ap�s de tr� erros.";
    }

    @Override
    public boolean isAcabou() {
        if(mQtdPalavrasErradas <= 0){
            return true;
        }
       return false;
    }

    @Override
    public String getPalavra() {
        return mPalavras.getNext();
    }

    @Override
    public String tentativa(String palavra, String resposta) {
        if(palavra.equals(resposta)){
            mPontos++;
            return "Voc� acertou, continue com o jogo!!!\n +1 ponto ";
        }else{
            mQtdPalavrasErradas--;
            return "Que pena voc� n�o conseguiu, mas podemos tentar outra palavra.\n -> Resta: " + mQtdPalavrasErradas + " tentativas.";
        }
    }

    @Override
    public String getResultadoFinal() {
        
        String result = mPontos < 2 ? "\nVoc� errou!\n Total de pontos: " + mPontos : "\nParab�ns: \n Total de pontos: " + mPontos;
        
        return result;
    }
    
}
