
import java.util.Arrays;



/**
 * Par número de compras e número de clientes
 * @author Pedro Cunha, Stéphane Fernandes, Filipe de Oliveira
 */
public class ParNComprasNClientes {

    private int nCompras;
    private int nClientes;
    /**
     * Construtor Vazio
     */
    public ParNComprasNClientes() {
        this.nClientes = 0;
        this.nCompras = 0;
    }
    /**
     * Construtor de Cópia
     * @param outro Par a ser copiado
     */
    public ParNComprasNClientes(ParNComprasNClientes outro) {
        this.nClientes = outro.getnClientes();
        this.nCompras = outro.getnCompras();
    }
    /**
     * 
     * @return Número de Clientes
     */
    public int getnClientes() {
        return this.nClientes;
    }
    /**
     * 
     * @return Número de Compras
     */
    public int getnCompras() {
        return this.nCompras;
    }
    /**
     * Atualiza o número de Clientes
     * @param nClientes Novo número de Clientes
     */
    public void setnClientes(int nClientes) {
        this.nClientes = nClientes;
    }
    /**
     * Atualiza o número de Compras 
     * @param nCompras Novo número de Compras
     */
    public void setnCompras(int nCompras) {
        this.nCompras = nCompras;
    }
    /**
     * Incrementa o número de Clientes em uma unidade
     */
    public void incCliente() {
        this.nClientes++;
    }
    /**
     * Incrementa o número de Clientes
     * @param nClientes Valor a ser incrementado
     */
    public void incClientes(int nClientes) {
        this.nClientes += nClientes;

    }
    /**
     * Incrementa o número de compras
     * @param nCompras Número de compras a ser incrementado
     */
    public void adicionaCompras(int nCompras) {
        this.nCompras += nCompras;
    }
    /**
     * 
     * @return Novo objecto como cópia da instância actual
     */
    public ParNComprasNClientes clone() {
        return new ParNComprasNClientes(this);
    }
    /**
     * Teste de igualdade
     * @param o Objecto a ser testado
     * @return True se this e o forem semanticamente iguais, False caso contrário
     */
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if ((!(this.getClass().getSimpleName().equals(o.getClass().getSimpleName()))) || o == null) {
            return false;
        } else {
            ParNComprasNClientes par = (ParNComprasNClientes) o;
            return this.nClientes == par.getnClientes() && this.nCompras == par.getnCompras();
        }
    }
    /**
     * 
     * @return HashCode do Par
     */
    public int hashCode(){
        return Arrays.hashCode(new Object[]{this.nClientes,this.nCompras});
    }

    /**
     * 
     * @return Representação textual da instância
     */
    public String toString() {
       StringBuilder sb = new StringBuilder();
       
       
       sb.append("Número de Compras ");
       sb.append(this.nCompras);
       sb.append("\n");
       sb.append("Número de Clientes ");
       sb.append(this.nClientes);
       sb.append("\n");
       
       return sb.toString();
    }
}
