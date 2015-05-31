
import java.io.Serializable;
import java.util.Arrays;
import java.util.TreeMap;
import java.util.Map;



/**
 * Nodo de Cliente
 * <p>Um Cliente é representado pelos seguintes atributos:</p>
 * <ul>
 * <li>Código de Cliente</li>
 * <li>Número de Compras por Mês</li>
 * <li>Número de Compras Realizadas</li>
 * <li>Mapeamento de todos os produtos Comprados</li>
 * </ul>
 * @author Pedro Cunha, Stéphane Fernandes, Filipe de Oliveira
 */
public class NodoCliente implements Serializable {

    private String codigoC;
    private int compraMes[];
    private int nCompras;
    private Map<String, NodoProdutoComprado> prodComprados;
    /**
     * Construtor Parametrizado
     * @param codigoC Código de Cliente
     * @param compraMes Número de Compras por mês
     * @param nCompras Número total de Compras
     */
    public NodoCliente(String codigoC, int[] compraMes, int nCompras) {
        this.codigoC = codigoC;
        this.compraMes = compraMes;
        this.nCompras = nCompras;
        this.prodComprados = new TreeMap<>();
    }
    /**
     * Construtor Parametrizado
     * @param codigoC Código de Cliente
     */
    public NodoCliente(String codigoC) {
        this.codigoC = codigoC;
        this.compraMes = new int[12];
        this.nCompras = 0;
        this.prodComprados = new TreeMap<>();
    }
    /**
     * Construtor de Cópia
     * @param other Nodo Cliente a ser copiado
     */
    public NodoCliente(NodoCliente other) {
        this.codigoC = other.getCodigoC();
        this.compraMes = other.getCompraMes();
        this.nCompras = other.getnCompras();
        this.prodComprados = other.getProdComprados();
    }
    /**
     * 
     * @return Código de Cliente 
     */
    public String getCodigoC() {
        return this.codigoC;
    }
    /**
     * 
     * @return Mapeamento dos Produtos Comprados pelo Cliente
     */
    public Map<String, NodoProdutoComprado> getProdComprados() {
        TreeMap<String, NodoProdutoComprado> res = new TreeMap<>();
        for (NodoProdutoComprado npc : this.prodComprados.values()) {
            res.put(npc.getCodigoP(), npc.clone());
        }
        return res;
    }
    /**
     * 
     * @return Compras por mês
     */
    public int[] getCompraMes() {
        return this.compraMes.clone();
    }
    /**
     * 
     * @return Número total de Compras
     */
    public int getnCompras() {
        return this.nCompras;
    }
    /**
     * Atualiza o Código de Cliente
     * @param codigoC Novo Código de Cliente
     */
    public void setCodigoC(String codigoC) {
        this.codigoC = codigoC;
    }
    /**
     * Atualiza as compras mensais
     * @param compraMes Novas compras mensais
     */
    public void setCompraMes(int[] compraMes) {
        this.compraMes = compraMes.clone();
    }
    /**
     * Atualiza o número total de Compras
     * @param nCompras Novo número total de Compras
     */
    public void setnCompras(int nCompras) {
        this.nCompras = nCompras;
    }
    /**
     * Atualiza o mapeamento de Produtos Comprados
     * @param produtosC Novo mapeamento de produtos comprados
     */
    public void setProdComprados(Map<String, NodoProdutoComprado> produtosC) {
        this.prodComprados = new TreeMap<>();
        for (NodoProdutoComprado npc : produtosC.values()) {
            this.prodComprados.put(npc.getCodigoP(), npc.clone());
        }
    }
    /**
     * Regista Compra
     * @param c Compra a ser registada
     */
    public void registaCompra(Compra c) {
        this.compraMes[c.getMes() - 1]++;
        this.nCompras++;
        this.atualizaProdutos(c.clone());

    }
    /**
     * 
     * @return Número de produtos distintos comprados por um cliente
     */
    public int getProdutosDistintosComprados(){
        return this.prodComprados.keySet().size();
    }
    /**
     * Atualiza Produtos Comprados
     * @param c Compra a ser registada no mapeamento de produtos Comprados
     */
    private void atualizaProdutos(Compra c) {
        if (!(this.prodComprados.containsKey(c.getCodigoProd()))) {
            this.prodComprados.put(c.getCodigoProd(), new NodoProdutoComprado(c.getCodigoProd()));
        }
        this.prodComprados.get(c.getCodigoProd()).incrementaQuantidade(c.getModo(), c.getMes(), c.getQuantidade());
        this.prodComprados.get(c.getCodigoProd()).incrementaValor(c.getModo(), c.getMes(), c.getValorUni(), c.getQuantidade());
    }

    /**
     * 
     * @return Novo objecto como cópia da instância actual
     */
    public NodoCliente clone() {
        return new NodoCliente(this);
    }
    /**
     * Teste de igualdade da instância actual com o parâmetro 
     * @param obj Objecto a ser testado
     * @return Igualdade entre a instância actual e o parâmetro obj
     */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj == null) || (this.getClass() != obj.getClass())) {
            return false;
        } else {
            NodoCliente e = (NodoCliente) obj;

            boolean flag = true;
            for (int i = 0; i < 12 && flag; i++) {
                if (this.compraMes[i] != e.getCompraMes(i + 1)) {
                    flag = false;
                }
            }
            return flag && (this.codigoC.equals(e.getCodigoC())) && this.prodComprados.equals(e.getProdComprados());

        }
    }

    /**
     * 
     * @return HashCode do Nodo Cliente
     */
    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.codigoC,this.compraMes,this.nCompras,this.prodComprados});
    }
    /**
     * 
     * @param mes Mês a ser consultado
     * @return Número de produtos distintos comprados num mês
     */
    public int getNProdutosComprados(int mes) {
        int counter = 0;
        for (NodoProdutoComprado ncc : this.prodComprados.values()) {
            if (ncc.getQtdCompMes('N', mes) != 0 || ncc.getQtdCompMes('P', mes) != 0) {
                counter++;
            }
        }
        return counter;
    }
    /**
     * 
     * @param mes Mês a ser consultado
     * @return Número de Compras realizadas no mês
     */
    public int getCompraMes(int mes) {
        return this.compraMes[mes - 1];
    }
    /**
     * 
     * @param mes Mês a ser consultado
     * @return Faturação resgistada no mês
     */
    public float getFaturacao(int mes) {
        float total = 0;
        for (NodoProdutoComprado ncc : this.prodComprados.values()) {
            total += ncc.getValorMes('N', mes);
            total += ncc.getValorMes('P', mes);
        }
        return total;

    }
}
