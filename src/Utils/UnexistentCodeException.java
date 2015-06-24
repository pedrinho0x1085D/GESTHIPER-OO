package Utils;


/**
 * Classe que trata das Excepções que provenham da inexistência de código (Cliente/Produto)
 * @author Pedro Cunha, Stéphane Fernandes, Filipe de Oliveira
 */
public class UnexistentCodeException extends Exception{
    /**
     * Construtor Vazio
     */
    public UnexistentCodeException(){
        super();
    }
    /**
     * Construtor Parametrizado
     * @param code Código que despoletou a excepção
     */
    public UnexistentCodeException(String code){
        super(code);
    }
}
