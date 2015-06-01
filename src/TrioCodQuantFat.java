
import java.util.Arrays;

/**
 * Trio Código/Quantidade/Faturação
 *
 * @author Pedro Cunha, Stéphane Fernandes, Filipe de Oliveira
 */
public class TrioCodQuantFat {

    private String codigo;
    private int quantidade;
    private float faturacao;

    /**
     * Construtor Vazio
     */
    public TrioCodQuantFat() {
        this.codigo = "";
        this.quantidade = 0;
        this.faturacao = 0;
    }

    /**
     * Construtor Parametrizado
     *
     * @param codigo Código de Produto
     * @param quantidade Quantidade vendida
     * @param faturacao Faturação registada
     */
    public TrioCodQuantFat(String codigo, int quantidade, float faturacao) {
        this.codigo = codigo;
        this.quantidade = quantidade;
        this.faturacao = faturacao;
    }

    /**
     * Construtor de cópia
     *
     * @param tcqc Trio a ser copiado
     */
    public TrioCodQuantFat(TrioCodQuantFat tcqc) {
        this.codigo = tcqc.getCodigo();
        this.faturacao = tcqc.getFaturacao();
        this.quantidade = tcqc.getQuantidade();
    }

    /**
     *
     * @return Código de Produto
     */
    public String getCodigo() {
        return this.codigo;
    }

    /**
     *
     * @return Quantidade Vendida
     */
    public int getQuantidade() {
        return this.quantidade;
    }

    /**
     *
     * @return Faturação Registada
     */
    public float getFaturacao() {
        return this.faturacao;
    }

    /**
     * Atualiza o código
     *
     * @param codigo Novo Código
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * Atualiza a quantidade vendida
     *
     * @param quantidade Nova quantidade vendida
     */
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    /**
     * Atualiza a faturação registada
     *
     * @param faturacao Nova faturação registada
     */
    public void setFaturacao(int faturacao) {
        this.faturacao = faturacao;
    }

    /**
     *
     * @return Novo objecto como cópia da instância actual
     */
    public TrioCodQuantFat clone() {
        return new TrioCodQuantFat(this);
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
            TrioCodQuantFat trio = (TrioCodQuantFat) o;
            return (this.codigo.equals(trio.getCodigo())) && (this.faturacao == trio.getFaturacao()) && (this.quantidade == trio.getQuantidade());
        }
    }

    /**
     *
     * @return HashCode do Trio
     */
    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.codigo, this.faturacao, this.quantidade});
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
        sb.append("Faturação ");
        sb.append(this.faturacao);
        sb.append("\n");

        return sb.toString();
    }

}
