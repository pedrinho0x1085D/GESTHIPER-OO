
import java.io.Serializable;
import java.util.Arrays;



/**
 * Classe que guarda o estado de uma compra
 * @author Pedro Cunha
 */
public class Compra implements Serializable{

    private String codigoProd;
    private float valorUni;
    private int quantidade;
    private char modo;
    private String codigoCli;
    private int mes;
/**
 * Método construtor de uma instância da classe compra vazia
 */
    public Compra() {
        this.codigoProd = new String();
        this.valorUni = 0;
        this.quantidade = 0;
        this.modo = 'N';
        this.codigoCli = new String();
        this.mes = 0;
    }
/**
 * construtor parametrizado 
 * @param codigoProd String correspondente ao código de produto
 * @param valorUni Float correspondente ao preço de cada unidade do produto
 * @param quantidade Quantidade vendida do produto
 * @param modo Corresponde ao modo de venda (N- Normal/P -Promocional)
 * @param codigoCli String correspondente ao código de cliente
 * @param mes 
 */
    
    public Compra(String codigoProd, float valorUni, int quantidade, char modo, String codigoCli, int mes) {
        this.codigoProd = codigoProd;
        this.valorUni = valorUni;
        this.quantidade = quantidade;
        this.modo = modo;
        this.codigoCli = codigoCli;
        this.mes = mes;
    }
    /**
     * Construtor de Cópia de uma Compra
     * @param c Compra a ser copiada
     */
    public Compra(Compra c){
        this.codigoProd = c.getCodigoProd();
        this.valorUni = c.getValorUni();
        this.quantidade = c.getQuantidade();
        this.modo = c.getModo();
        this.codigoCli = c.getCodigoCli();
        this.mes = c.getMes();
    }
/**
 * 
 * @return O código de um cliente
 */
    public String getCodigoCli() {
        return this.codigoCli;
    }
/**
 * 
 * @return O código de um produto 
 */    

    public String getCodigoProd() {
        return this.codigoProd;
    }

/**
 * 
 * @return  O mês 
 */    
    public int getMes() {
        return this.mes;
    }
/**
 * 
 * @return O modo de venda de um produto 
 */    

    public char getModo() {
        return this.modo;
    }
/**
 * 
 * @return A quantidade vendida de um produto
 */    

    public int getQuantidade() {
        return this.quantidade;
    }
/**
 * 
 * @return O valor de uma unidade de um produto
 */    

    public float getValorUni() {
        return this.valorUni;
    }

/**
 * 
 * @param codigoCli String com o nome de um produto a ser colocada na instância
 */    
    public void setCodigoCli(String codigoCli) {
        this.codigoCli = codigoCli;
    }

/**
 * 
 * @param codigoProd String com o nome de um cliente a ser colocada na instância
 */    
    public void setCodigoProd(String codigoProd) {
        this.codigoProd = codigoProd;
    }

/**
 * 
 * @param mes Corresponde ao mês a ser colocado na instância
 */    
    public void setMes(int mes) {
        this.mes = mes;
    }

/**
 * 
 * @param modo Corresponde ao modo em que foi feita uma compra (N/P) a ser colocado na instância
 */    
    public void setModo(char modo) {
        this.modo = modo;
    }

/**
 * 
 * @param quantidade Corresponde a quantidade a ser colocada na instância
 */    
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

/**
 * 
 * @param valorUni Corresponde ao preço de uma unidade de um produto a ser colocada na instância
 */    
    public void setValorUni(float valorUni) {
        this.valorUni = valorUni;
    }

 /**
  * 
  * @return Representação textual da instância 
  */
    public String toString() {
       StringBuilder sb = new StringBuilder();
       
       
       sb.append("Código do produto ");
       sb.append(this.codigoProd);
       sb.append("\n");
       sb.append("Valor Unitário ");
       sb.append(this.valorUni);
       sb.append("\n");
       sb.append("Quantidade ");
       sb.append(this.quantidade);
       sb.append("\n");
       sb.append("Modo ");
       sb.append(this.modo);
       sb.append("\n");
       sb.append("Código de Cliente ");
       sb.append(this.codigoCli);
       sb.append("\n");
       sb.append("Mês ");
       sb.append(this.mes);
       sb.append("\n");
        
        return sb.toString();
    }
/**
 * Teste de igualdade entre uma instância de Compra e uma outra qualquer instância 
 * @param o Objecto a ser comparado
 * @return Valor de igualdade entre este objecto e o
 */
    
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if ((!(this.getClass().getSimpleName().equals(o.getClass().getSimpleName()))) || o == null) {
            return false;
        } else {
            Compra co = (Compra) o;
            return (this.codigoCli.equals(co.getCodigoCli()) && this.codigoProd.equals(co.getCodigoProd()) && this.mes == co.getMes() && this.modo == co.getModo() && this.quantidade == co.getQuantidade() && this.valorUni == co.getValorUni());
        }
    }

/**
 * 
 * @return HashCode de um objecto Compra
 */    
    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.codigoCli,this.codigoProd,this.mes,this.modo,this.quantidade,this.valorUni});
    }

/**
 * 
 * @return Nova instância como cópia da instância actual
 */
    @Override
    public Compra clone(){
        return new Compra(this);
    } 
}
