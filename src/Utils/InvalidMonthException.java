package Utils;



/**
 * Excepção que trata um Mês que não seja válido (Inferior a 1 ou Superior a 12)
 * @author Pedro Cunha, Stéphane Fernandes, Filipe de Oliveira
 */
public class InvalidMonthException extends Exception{
    /**
     * Construtor Vazio
     */
    public InvalidMonthException(){
        super();
    }
    /**
     * Construtor parametrizado
     * @param mes Mês que despoletou a Excepção
     */
    public InvalidMonthException(int mes){
        super(mes+"");
    }
}
