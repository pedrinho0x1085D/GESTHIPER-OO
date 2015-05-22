
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeSet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Pedro Cunha
 */
public class Contabilidade implements IContabilidade, Serializable {

    private HashMap<String, NodoContabilidade> contabilidade;

    public Contabilidade() {
        this.contabilidade = new HashMap<>();
    }

    public Contabilidade(HashMap<String, NodoContabilidade> cont) {
        this.contabilidade = new HashMap<>();
        for (NodoContabilidade nc : cont.values()) {
            this.contabilidade.put(nc.getCodigo(), nc.clone());
        }
    }

    public Contabilidade(Contabilidade other) {
        this.contabilidade = other.getContabilidade();
    }

    public void setContabilidade(HashMap<String, NodoContabilidade> cont) {
        this.contabilidade = new HashMap<>();
        for (NodoContabilidade nc : cont.values()) {
            this.contabilidade.put(nc.getCodigo(), nc.clone());
        }

    }

    public HashMap<String, NodoContabilidade> getContabilidade() {
        HashMap<String, NodoContabilidade> res = new HashMap<>();
        for (NodoContabilidade nc : this.contabilidade.values()) {
            res.put(nc.getCodigo(), nc.clone());
        }
        return res;
    }

    @Override
    public void insertCode(String code) {
        this.contabilidade.put(code, new NodoContabilidade(code));
    }

    @Override
    public void registerSale(Compra c) {
        this.contabilidade.get(c.getCodigoProd()).incrementaFaturacao(c.getModo(), c.getMes(), c.getQuantidade(), c.getValorUni());
        this.contabilidade.get(c.getCodigoProd()).incrementaNVendas(c.getModo(), c.getMes());
        this.contabilidade.get(c.getCodigoProd()).incrementaQtdComprada(c.getModo(), c.getMes(), c.getQuantidade());
    }

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

    @Override
    public IContabilidade clone() {
        return new Contabilidade(this);
    }

}
