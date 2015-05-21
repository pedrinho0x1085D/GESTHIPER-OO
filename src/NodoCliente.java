
import java.io.Serializable;
import java.util.HashMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Pedro Cunha
 */
public class NodoCliente implements Serializable {

    private String codigoC;
    private int compraMes[];
    private int nCompras;
    private HashMap<String, NodoProdutoComprado> prodComprados;

    public NodoCliente(String codigoC, int[] compraMes, int nCompras) {
        this.codigoC = codigoC;
        this.compraMes = compraMes;
        this.nCompras = nCompras;
        this.prodComprados = new HashMap<>();
    }

    public NodoCliente(String codigoC) {
        this.codigoC = codigoC;
        this.compraMes = new int[12];
        this.nCompras = 0;
        this.prodComprados = new HashMap<>();
    }

    public NodoCliente(NodoCliente other) {
        this.codigoC = other.getCodigoC();
        this.compraMes = other.getCompraMes();
        this.nCompras = other.getnCompras();
        this.prodComprados = other.getProdComprados();
    }

    public String getCodigoC() {
        return this.codigoC;
    }

    public HashMap<String, NodoProdutoComprado> getProdComprados() {
        HashMap<String, NodoProdutoComprado> res = new HashMap<>();
        for (NodoProdutoComprado npc : this.prodComprados.values()) {
            res.put(npc.getCodigoP(), npc.clone());
        }
        return res;
    }

    public int[] getCompraMes() {
        return this.compraMes;
    }

    public int getnCompras() {
        return this.nCompras;
    }

    public void setCodigoC(String codigoC) {
        this.codigoC = codigoC;
    }

    public void setCompraMes(int[] compraMes) {
        this.compraMes = compraMes;
    }

    public void setnCompras(int nCompras) {
        this.nCompras = nCompras;
    }

    public void setProdComprados(HashMap<String, NodoProdutoComprado> produtosC) {
        this.prodComprados = new HashMap<>();
        for (NodoProdutoComprado npc : produtosC.values()) {
            this.prodComprados.put(npc.getCodigoP(), npc.clone());
        }
    }

    public void registaCompra(Compra c) {
        this.compraMes[c.getMes() - 1]++;
        this.nCompras++;
        this.atualizaProdutos(c.clone());

    }

    private void atualizaProdutos(Compra c) {
        if (!(this.prodComprados.containsKey(c.getCodigoProd()))) {
            this.prodComprados.put(c.getCodigoProd(), new NodoProdutoComprado());
        }
        this.prodComprados.get(c.getCodigoProd()).incrementaQuantidade(c.getModo(), c.getMes(), c.getQuantidade());
        this.prodComprados.get(c.getCodigoProd()).incrementaValor(c.getModo(), c.getMes(), c.getValorUni(), c.getQuantidade());
    }

    public NodoCliente clone() {
        return new NodoCliente(this);
    }
    public boolean equals(Object obj){
        if(this == obj) return true;
        if((obj == null) || (this.getClass() != obj.getClass())) return false;
        NodoCliente e = (NodoCliente) obj;
        return (this.codigoC.equals(e.getCodigoC()) && this.compraMes.equals(e.getCompraMes()) && this.nCompras.equals(e.getnCompras()) && this.prodComprados.equals(e.getProdComprados()));
    }
}
