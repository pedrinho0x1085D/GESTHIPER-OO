package Business;


import java.util.ArrayList;

/**
 * Interface ICatalog
 * @author Pedro Cunha, Stéphane Fernandes, Filipe de Oliveira
 */
public interface ICatalog {
    /**
     * Inserção de Código 
     * @param code Código a ser inserido
     */
    public void insertCode(String code);
    /**
     * 
     * @param primLetra Letra a ser procurada
     * @return Lista com os códigos de uma letra
     */
    public ArrayList<String> getCodigosToArray(char primLetra);
    /**
     * Método de verificação da existência de um código
     * @param code Código a ser procurado
     * @return Existência do código
     */
    public boolean codeExists(String code);
    /**
     * 
     * @return Nova instância como cópia da instância actual
     */
    public ICatalog clone();
    
}
