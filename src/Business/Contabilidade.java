package Business;


import Utils.UnexistentCodeException;
import Utils.VendasProdutoMensais;
import Utils.Compra;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.Map;
import java.util.TreeSet;


/**
 * Classe que implementa o módulo de Contabilidade
 * @author Pedro Cunha, Stéphane Fernandes, Filipe de Oliveira
 */
public class Contabilidade implements IContabilidade, Serializable {

    private Map<String, NodoContabilidade> contabilidade;
    /**
     * Construtor Vazio
     */
    public Contabilidade() {
        this.contabilidade = new TreeMap<>();
    }
    /**
     * Construtor Parametrizado
     * @param cont Map a ser colocado na Contabilidade
     */
    public Contabilidade(Map<String, NodoContabilidade> cont) {
        this.contabilidade = new TreeMap<>();
        for (NodoContabilidade nc : cont.values()) {
            this.contabilidade.put(nc.getCodigo(), nc.clone());
        }
    }
    /**
     * Construtor de Cópia
     * @param other Objecto a ser Copiado
     */
    public Contabilidade(Contabilidade other) {
        this.contabilidade = other.getContabilidade();
    }
    /**
     * Modifica a Contabilidade
     * @param cont Novo Map a ser colocado na instância
     */
    public void setContabilidade(Map<String, NodoContabilidade> cont) {
        this.contabilidade = new TreeMap<>();
        for (NodoContabilidade nc : cont.values()) {
            this.contabilidade.put(nc.getCodigo(), nc.clone());
        }

    }
    /**
     * 
     * @return Map de Contabilidade
     */
    public Map<String, NodoContabilidade> getContabilidade() {
        Map<String, NodoContabilidade> res = new TreeMap<>();
        for (NodoContabilidade nc : this.contabilidade.values()) {
            res.put(nc.getCodigo(), nc.clone());
        }
        return res;
    }

    /**
     * Inserção de Código de Produto
     * @param code Código a ser inserido
     */
    public void insertCode(String code) {
        this.contabilidade.put(code, new NodoContabilidade(code));
    }

    /**
     * Regista a Compra na Contabilidade
     * @param c Compra a ser registada
     */
    public void registerSale(Compra c) {
        this.contabilidade.get(c.getCodigoProd()).incrementaFaturacao(c.getModo(), c.getMes(), c.getQuantidade(), c.getValorUni());
        this.contabilidade.get(c.getCodigoProd()).incrementaNVendas(c.getModo(), c.getMes());
        this.contabilidade.get(c.getCodigoProd()).incrementaQtdComprada(c.getModo(), c.getMes(), c.getQuantidade());
    }
    /**
     * 
     * @return Lista Com os Códigos de Produtos nunca Comprados
     */
    public ArrayList<String> getNuncaComprados() {
        TreeSet<String> resaux = new TreeSet<>();
        ArrayList<String> res = new ArrayList<>();
        for (NodoContabilidade nc : this.contabilidade.values()) {
            if (nc.nuncaComprado()) {
                resaux.add(nc.getCodigo());
            }
        }

        for (String st : resaux) {
            res.add(st);
        }

        return res;
    }
    /**
     * 
     * @return Compras realizadas mensalmente
     */
    public int[] comprasMensais() {
        int[] res = new int[12];
        for (NodoContabilidade nc : this.contabilidade.values()) {
            for (int i = 1; i <= 12; i++) {
                res[i - 1] += nc.getNComprasMes('N', i);
                res[i - 1] += nc.getNComprasMes('P', i);
            }
        }
        return res;
    }
    /**
     * 
     * @return Faturação registada mensalmente
     */
    public float[] faturacaoMensal(){
        float[] res=new float[12];
        for(NodoContabilidade nc:this.contabilidade.values()){
            for(int i=1;i<=12;i++){
                res[i-1]+=nc.getFaturacaoMes('N', i);
                res[i-1]+=nc.getFaturacaoMes('P', i);
            }
        }
        return res;
    }
    /**
     * 
     * @param codigoP Código a ser procurado
     * @return Vendas de um produto mensalmente
     * @throws UnexistentCodeException Caso o código não exista
     */
    public VendasProdutoMensais getVendasMensais(String codigoP) throws UnexistentCodeException {
        if (!(this.contabilidade.containsKey(codigoP))) {
            throw new UnexistentCodeException(codigoP);
        } else {
            VendasProdutoMensais vpm = new VendasProdutoMensais(codigoP);
            NodoContabilidade nc = this.contabilidade.get(codigoP);
            vpm.setFatN(nc.getFaturacaoN());
            vpm.setFatP(nc.getFaturacaoP());
            vpm.setVendasN(nc.getnVendasN());
            vpm.setVendasP(nc.getnVendasP());
            return vpm.clone();
        }
    }

    /**
     * 
     * @return Novo Objecto como cópia da instância Actual
     */
    public IContabilidade clone() {
        return new Contabilidade(this);
    }

}
