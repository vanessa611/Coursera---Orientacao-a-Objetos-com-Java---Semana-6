package jogo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BancoDePalavras {
  
    private LerDados mDados = new LerDados();
    private List<String> mListPalavras = new ArrayList<>();
    
    public String getNext(){
        try {
            mListPalavras = mDados.getPalavraArquivo();
        } catch (IOException ex) {
            Logger.getLogger(BancoDePalavras.class.getName()).log(Level.SEVERE, null, ex);
        }
        Random random = new Random(System.currentTimeMillis());
        int referencia = random.nextInt();
        int indice = referencia % (mListPalavras.size());
        
        return  mListPalavras.get(Math.abs(indice));
    }
    
    public int getTamanho(){
        return mListPalavras.size();
    }
    
    public class LerDados extends JavaUtils{
        
        private FileReader mArquivo;
        private List<String> mList;

        public List<String> getPalavraArquivo() throws IOException{
            
            mList = new ArrayList<>();
            
            try{
                File f = new File("lista_palavras.txt");
                mArquivo = new FileReader(f);
                BufferedReader lerArq = new BufferedReader(mArquivo);

                String linha = lerArq.readLine(); 
                
                while (linha != null) {
                    mList.add(linha);
                    linha = lerArq.readLine(); 
                }
            }catch (IOException e) {
                printLN("Erro ao ler arquivo contendo as palavras");
            }finally{
                mArquivo.close();
            }  
            return  mList;
        }
    }
}
