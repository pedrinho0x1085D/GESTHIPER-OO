package Business;


import Utils.Compra;
import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Nodo Produto
 * <p>Deverá guardar as seguintes informações</p>
 * <ul>
 * <li>Código de Produto</li>
 * <li>Número de vezes comprado</li>
 * <li>Quantidade Comprada</li>
 * <li>Número de Compras mensais</li>
 * <li>Mapeamento de todos os Clientes compradores</li>
 * </ul>
 * @author Pedro Cunha
 */
public class NodoProduto implements Serializable {

    private String codigoP;
    private int nVezesComprado;
    private int qtdComprada;
    private int compradoMes[];
    private Map<String, NodoClienteComprador> clientesComp;
    /**
     * Construtor Vazio
     */
    public NodoProduto() {
        this.codigoP = "";
        this.compradoMes = new int[12];
        this.nVezesComprado = 0;
        this.qtdComprada = 0;
        this.clientesComp = new HashMap<>();
    }
    /**
     * Construtor Parametrizado
     * @param codigoP Código de Produto
     */
    public NodoProduto(String codigoP) {
        this.codigoP = codigoP;
        this.clientesComp = new HashMap<>();
        this.compradoMes = new int[12];
        this.qtdComprada = 0;
        this.nVezesComprado = 0;

    }
    /**
     * Construtor de cópia
     * @param other Nodo a ser copiado
     */
    public NodoProduto(NodoProduto other) {
        this.clientesComp = other.getClientesComp();
        this.codigoP = other.getCodigoP();
        this.compradoMes = other.getCompradoMes();
        this.nVezesComprado = other.getnVezesComprado();
        this.qtdComprada = other.getQtdComprada();
    }
    /**
     * 
     * @return Mapeamento de todos os Clientes Compradores
     */
    public Map<String, NodoClienteComprador> getClientesComp() {
        HashMap<String, NodoClienteComprador> res = new HashMap<>();
        for (NodoClienteComprador ncc : this.clientesComp.values()) {
            res.put(ncc.getCodigoC(), ncc.clone());
        }
        return res;
    }
    /**
     * 
     * @return Código de Produto
     */
    public String getCodigoP() {
        return this.codigoP;
    }
    /**
     * 
     * @return Relação mensal do número de compras
     */
    public int[] getCompradoMes() {
        return this.compradoMes.clone();
    }
    /**
     * 
     * @return Quantidade Comprada
     */
    public int getQtdComprada() {
        return this.qtdComprada;
    }
    /**
     * 
     * @return Número de vezes comprado
     */
    public int getnVezesComprado() {
        return this.nVezesComprado;
    }
    /**
     * Atualiza o mapeamento de clientes compradores
     * @param clientesComp Novo mapeamento de clientes compradores
     */
    public void setClientesComp(Map<String, NodoClienteComprador> clientesComp) {
        this.clientesComp = new HashMap<>();
        for (NodoClienteComprador ncc : clientesComp.values()) {
            this.clientesComp.put(ncc.getCodigoC(), ncc.clone());
        }
    }
    /**
     * Atualiza o código de Produto
     * @param codigoP Novo código de Produto
     */
    public void setCodigoP(String codigoP) {
        this.codigoP = codigoP;
    }
    /**
     * Atualiza a relação mensal de compras
     * @param compradoMes Nova relação mensal de compras
     */
    public void setCompradoMes(int[] compradoMes) {
        this.compradoMes = compradoMes.clone();
    }
    /**
     * Atualiza a quantidade comprada
     * @param qtdComprada Nova quantidade comprada
     */
    public void setQtdComprada(int qtdComprada) {
        this.qtdComprada = qtdComprada;
    }
    /**
     * Atualiza o número de vezes que o produto foi comprado
     * @param nVezesComprado Novo número de compras
     */
    public void setnVezesComprado(int nVezesComprado) {
        this.nVezesComprado = nVezesComprado;
    }
    /**
     * Regista uma compra
     * @param c Compra a ser registada
     */
    public void registaCompra(Compra c) {
        this.compradoMes[c.getMes() - 1]++;
        this.nVezesComprado++;
        this.qtdComprada += c.getQuantidade();
        this.atualizaClientes(c.clone());
    }
    /**
     * Atualiza o mapeamento de clientes compradores, registando uma compra
     * @param c Compra a ser registada
     */
    private void atualizaClientes(Compra c) {
        if (!(this.clientesComp.containsKey(c.getCodigoCli()))) {
            this.clientesComp.put(c.getCodigoCli(), new NodoClienteComprador(c.getCodigoCli()));
        }
        this.clientesComp.get(c.getCodigoCli()).incrementaQtd(c.getModo(), c.getMes(), c.getQuantidade());
        this.clientesComp.get(c.getCodigoCli()).incrementaValor(c.getModo(), c.getMes(), c.getQuantidade(), c.getValorUni());
    }
    /**
     * 
     * @param mes Mês a ser consultado
     * @return Número de Compras no mês
     */
    public int comprasMes(int mes) {
        return this.compradoMes[mes - 1];
    }
    /**
     * 
     * @return Número de Clientes distintos Compradores
     */
    public int getClientesCompradores(){
        return this.clientesComp.keySet().size();
    }
    /**
     * 
     * @param mes Mês a ser consultado
     * @return Número de Clientes distintos compradores num mês
     */
    public int getNClientesCompradores(int mes) {
        int counter = 0;
        for (NodoClienteComprador ncc : this.clientesComp.values()) {
            if (ncc.getCompraMes('N', mes) != 0 || ncc.getCompraMes('P', mes) != 0) {
                counter++;
            }
        }
        return counter;
    }
    /**
     * 
     * @param mes Mês a ser consultado
     * @return Faturação registada no mês especificado
     */
    public float getFaturacao(int mes) {
        float total = 0;
        for (NodoClienteComprador ncc : this.clientesComp.values()) {
            total += ncc.getFaturacaoMes('N', mes);
            total += ncc.getFaturacaoMes('P', mes);
        }
        return total;
    }
    
    /**
     * 
     * @return Novo objecto como cópia da instância actual
     */
    public NodoProduto clone() {
        return new NodoProduto(this);
    }
    /**
     * 
     * @return HashCode do Nodo
     */
    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.clientesComp, this.codigoP, this.compradoMes, this.nVezesComprado, this.qtdComprada});
    }
    /**
     * Teste de igualdade
     * @param obj Objecto a ser testado
     * @return True se this e obj forem semanticamente iguais, False caso contrário
     */
    public boolean equals(Object obj){
        if(this == obj) return true;
        if((obj == null) || (this.getClass() != obj.getClass())) return false;
        else{
            NodoProduto e = (NodoProduto) obj;
            boolean flag = true;
            for (int i = 0; i < 12 && flag; i++) {
                if (this.compradoMes[i] != e.comprasMes(i + 1)) {
                    flag = false;
                } 
            }
            return flag && (this.codigoP.equals(e.getCodigoP())) && this.clientesComp.equals(e.getClientesComp()) && this.nVezesComprado==e.getnVezesComprado()&& this.qtdComprada==e.getQtdComprada();
        }
        
    }
}
