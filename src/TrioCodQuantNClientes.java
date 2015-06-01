
import java.util.Arrays;

/**
 * Trio Código/Quantidade/Número de Clientes
 *
 * @author Pedro Cunha, Stéphane Fernandes, Filipe de Oliveira
 */
public class TrioCodQuantNClientes {

    private String codigo;
    private int quantidade;
    private int nClientes;
    /**
     * Construtor Vazio
     */
    public TrioCodQuantNClientes() {
        this.codigo = "";
        this.quantidade = 0;
        this.nClientes = 0;
    }
    /**
     * Construtor Parametrizado
     * @param codigo Código do Produto
     * @param quantidade Quantidade Comprada
     * @param nClientes Número de Clientes distintos
     */
    public TrioCodQuantNClientes(String codigo, int quantidade, int nClientes) {
        this.codigo = codigo;
        this.quantidade = quantidade;
        this.nClientes = nClientes;
    }
    /**
     * Construtor de cópia
     * @param tcqc Trio a ser copiado
     */
    public TrioCodQuantNClientes(TrioCodQuantNClientes tcqc) {
        this.codigo = tcqc.getCodigo();
        this.nClientes = tcqc.getnClientes();
        this.quantidade = tcqc.getQuantidade();
    }
    /**
     * 
     * @return Código de produto
     */
    public String getCodigo() {
        return this.codigo;
    }
    /**
     * 
     * @return Quantidade Comprada
     */
    public int getQuantidade() {
        return this.quantidade;
    }
    /**
     * 
     * @return Número de Clientes distintos
     */
    public int getnClientes() {
        return this.nClientes;
    }
    /**
     * Atualiza o código de Produto
     * @param codigo Novo código de Produto
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    /**
     * Atualiza a quantidade comprada
     * @param quantidade Nova quantidade comprada
     */
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    /**
     * Atualiza o Número de Clientes
     * @param nClientes Novo número de clientes
     */
    public void setnClientes(int nClientes) {
        this.nClientes = nClientes;
    }
    /**
     * 
     * @return Novo objecto como cópia da instância actual
     */
    public TrioCodQuantNClientes clone() {
        return new TrioCodQuantNClientes(this);
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
            TrioCodQuantNClientes trio = (TrioCodQuantNClientes) o;
            return (this.codigo.equals(trio.getCodigo())) && (this.nClientes == trio.getnClientes()) && (this.quantidade == trio.getQuantidade());
        }
    }
    /**
     * 
     * @return HashCode do Trio
     */
    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.codigo, this.nClientes, this.quantidade});
    }

    /**
     *
     * @return Representação textual da instância
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Código do produto ");
        sb.append(this.codigo);
        sb.append("\n");
        sb.append("Quantidade ");
        sb.append(this.quantidade);
        sb.append("\n");
        sb.append("Numero de Clientes ");
        sb.append(this.nClientes);
        sb.append("\n");

        return sb.toString();
    }
}
