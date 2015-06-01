
import java.util.Arrays;

/**
 * Tabela com relação de (Clientes/Produtos) distintos por mês, número de
 * compras mensais, faturação mensal e total
 *
 * @author Pedro Cunha, Stéphane Fernandes, Filipe de Oliveira
 */
public class Table {

    private String codigo;
    private int distintos[], nCompras[];
    private float faturacaoMensal[], faturacaoTotal;

    /**
     * Construtor vazio
     */
    public Table() {
        this.codigo = "";
        this.distintos = new int[12];
        this.nCompras = new int[12];
        this.faturacaoMensal = new float[12];
        this.faturacaoTotal = 0;
    }

    /**
     * Construtor Parametrizado
     *
     * @param codigo Código
     */
    public Table(String codigo) {
        this.codigo = codigo;
        this.distintos = new int[12];
        this.nCompras = new int[12];
        this.faturacaoMensal = new float[12];
        this.faturacaoTotal = 0;
    }

    /**
     * Construtor de Cópia
     *
     * @param other Tabela a ser copiada
     */
    public Table(Table other) {
        this.codigo = other.getCodigo();
        this.distintos = other.getDistintos();
        this.nCompras = other.getnCompras();
        this.faturacaoMensal = other.getFaturacaoMensal();
        this.faturacaoTotal = other.getFaturacaoTotal();
    }

    /**
     *
     * @return Código
     */
    public String getCodigo() {
        return this.codigo;
    }

    /**
     * Atualiza a relação mensal do número de compras
     *
     * @param nCompras Nova relação mensal do número de compras
     */
    public void setnCompras(int[] nCompras) {
        this.nCompras = nCompras;
    }

    /**
     *
     * @return Relação mensal do número de compras
     */
    public int[] getnCompras() {
        return this.nCompras;
    }

    /**
     *
     * @return Relação mensal dos (Clientes/Produtos) distintos
     */
    public int[] getDistintos() {
        return this.distintos;
    }

    /**
     *
     * @return Relação mensal da faturação registada
     */
    public float[] getFaturacaoMensal() {
        return this.faturacaoMensal;
    }

    /**
     *
     * @return Faturação total
     */
    public float getFaturacaoTotal() {
        return this.faturacaoTotal;
    }

    /**
     * Atualiza o código
     *
     * @param codigo Novo código
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * Atualiza a relação de (Clientes/Produtos) distintos
     *
     * @param distintos Nova relação de Clientes ou Produtos distintos
     */
    public void setDistintos(int[] distintos) {
        this.distintos = distintos;
    }

    /**
     * Atualiza a relação mensal de faturação registada
     *
     * @param faturacaoMensal Nova relação mensal de faturação registada
     */
    public void setFaturacaoMensal(float[] faturacaoMensal) {
        this.faturacaoMensal = faturacaoMensal;
    }

    /**
     * Atualiza a faturação total registada
     *
     * @param faturacaoTotal Nova faturação total registada
     */
    public void setFaturacaoTotal(float faturacaoTotal) {
        this.faturacaoTotal = faturacaoTotal;
    }

    /**
     * Adiciona Distinto à relação de distintos
     *
     * @param qtd Quantidade de distintos
     * @param mes Mês
     */
    public void adicionaDistintos(int qtd, int mes) {
        this.distintos[mes - 1] = qtd;
    }

    /**
     * Adiciona Faturação mensal
     *
     * @param fat Valor Faturado
     * @param mes Mês
     */
    public void adicionaFaturacaoMensal(float fat, int mes) {
        this.faturacaoMensal[mes - 1] = fat;
        this.faturacaoTotal += fat;
    }

    /**
     * Adiciona o número de Compras
     *
     * @param nCompras Número de Compras
     * @param mes Mês
     */
    public void adicionaNCompras(int nCompras, int mes) {
        this.nCompras[mes - 1] = nCompras;
    }

    /**
     *
     * @return Nova instância como cópia da actual
     */
    public Table clone() {
        return new Table(this);
    }

    /**
     * Teste de igualdade
     *
     * @param o Objecto a ser testado
     * @return True se this e o forem semanticamente iguais, False caso
     * contrário
     */
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if ((!(this.getClass().getSimpleName().equals(o.getClass().getSimpleName()))) || o == null) {
            return false;
        } else {
            Table t = (Table) o;
            return this.codigo.equals(t.getCodigo()) && this.distintos.equals(t.getDistintos()) && this.faturacaoMensal.equals(t.getFaturacaoMensal()) && this.faturacaoTotal == t.getFaturacaoTotal() && this.nCompras.equals(t.getnCompras());
        }

    }

    /**
     *
     * @return HashCode da Tabela
     */
    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.codigo, this.distintos, this.faturacaoMensal, this.faturacaoTotal, this.nCompras});
    }

    /**
     *
     * @return Representação textual da instância
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Código ");
        sb.append(this.codigo);
        sb.append("\n");
        sb.append("Disintos \n");
        for (int i = 0; i < 12; i++) {
            sb.append(this.distintos[i]);
        }
        sb.append("\n");
        sb.append("Numero de Compras ");
        for (int i = 0; i < 12; i++) {
            sb.append(this.nCompras[i]);
        }
        sb.append("\n");
        sb.append("Faturção Mensal \n");
        for (int i = 0; i < 12; i++) {
            sb.append(this.faturacaoMensal[i] + "€  ");
        }
        sb.append("\n");
        sb.append("Faturção Total \n");
        sb.append(this.faturacaoTotal + "€");
        return sb.toString();
    }
}
