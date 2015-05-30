
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
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
public class ComprasDB implements IComprasDB,Serializable {

    private Map<String, NodoCliente> clientes;
    private Map<String, NodoProduto> produtos;

    public ComprasDB() {
        this.clientes = new TreeMap<>();

        this.produtos = new TreeMap<>();
    }

    public ComprasDB(ComprasDB other) {
        this.clientes = other.getClientes();

        this.produtos = other.getProdutos();
    }

    public Map<String, NodoCliente> getClientes() {
        TreeMap<String, NodoCliente> res = new TreeMap<>();
        for (NodoCliente nc : this.clientes.values()) {
            res.put(nc.getCodigoC(), nc.clone());
        }
        return res;
    }

    public Map<String, NodoProduto> getProdutos() {
        TreeMap<String, NodoProduto> res = new TreeMap<>();
        for (NodoProduto np : this.produtos.values()) {
            res.put(np.getCodigoP(), np.clone());
        }
        return res;
    }

    public void setClientes(Map<String, NodoCliente> res) {
        this.clientes = new TreeMap<>();
        for (NodoCliente nc : res.values()) {
            this.clientes.put(nc.getCodigoC(), nc.clone());
        }

    }

    public void setProdutos(Map<String, NodoProduto> res) {
        this.produtos = new TreeMap<>();
        for (NodoProduto np : res.values()) {
            this.produtos.put(np.getCodigoP(), np.clone());
        }
    }

    @Override
    public void insertCodigoCliente(String codigoC) {
        this.clientes.put(codigoC, new NodoCliente(codigoC));
    }

    @Override
    public void insertCodigoProduto(String codigoP) {
        this.produtos.put(codigoP, new NodoProduto(codigoP));
    }

    @Override
    public void registerSale(Compra c) {
        this.clientes.get(c.getCodigoCli()).registaCompra(c.clone());
        this.produtos.get(c.getCodigoProd()).registaCompra(c.clone());
    }

    @Override
    public IComprasDB clone() {
        return new ComprasDB(this);
    }

    public ArrayList<String> clientesNaoCompradores() {
        TreeSet<String> resaux = new TreeSet<>();
        ArrayList<String> res = new ArrayList<>();
        for (NodoCliente nc : this.clientes.values()) {
            if (nc.getnCompras() == 0) {
                resaux.add(nc.getCodigoC());
            }
        }
        for (String st : resaux) {
            res.add(st);
        }
        return res;
    }

    public ParNComprasNClientes getTotCompTotCli(int mes) throws InvalidMonthException {
        if (mes < 1 || mes > 12) {
            throw new InvalidMonthException(mes);
        } else {
            ParNComprasNClientes pncnc = new ParNComprasNClientes();
            for (NodoProduto np : this.produtos.values()) {
                pncnc.adicionaCompras(np.comprasMes(mes));
                pncnc.incClientes(np.getNClientesCompradores(mes));

            }
            return pncnc.clone();
        }
    }

    public Table getTableCliente(String codigoC) throws UnexistentCodeException {
        if (!(this.clientes.containsKey(codigoC))) {
            throw new UnexistentCodeException(codigoC);
        } else {
            int mesCount;
            Table tab = new Table(codigoC);
            NodoCliente nc = this.clientes.get(codigoC);
            for (mesCount = 1; mesCount <= 12; mesCount++) {
                tab.adicionaDistintos(nc.getNProdutosComprados(mesCount), mesCount);
                tab.adicionaFaturacaoMensal(nc.getFaturacao(mesCount), mesCount);
                tab.adicionaNCompras(nc.getCompraMes(mesCount), mesCount);
            }
            return tab.clone();
        }
    }

    public Table getTableProduto(String codigoP) throws UnexistentCodeException {
        if (!(this.produtos.containsKey(codigoP))) {
            throw new UnexistentCodeException(codigoP);
        } else {
            int mesCount;
            Table tab = new Table(codigoP);
            NodoProduto nc = this.produtos.get(codigoP);
            for (mesCount = 1; mesCount <= 12; mesCount++) {
                tab.adicionaDistintos(nc.getNClientesCompradores(mesCount), mesCount);
                tab.adicionaFaturacaoMensal(nc.getFaturacao(mesCount), mesCount);
                tab.adicionaNCompras(nc.comprasMes(mesCount), mesCount);
            }
            return tab.clone();
        }
    }

    public ArrayList<ParCodigoQuantidade> getTopCompras(String codigoC) throws UnexistentCodeException {
        if (!(this.clientes.containsKey(codigoC))) {
            throw new UnexistentCodeException(codigoC);
        } else {
            ArrayList<ParCodigoQuantidade> res = new ArrayList<>();
            NodoCliente nc = this.clientes.get(codigoC);
            TreeSet<ParCodigoQuantidade> auxil = new TreeSet<>(new ComparatorParCodigoQuantidade());
            for (NodoProdutoComprado npc : nc.getProdComprados().values()) {
                auxil.add(new ParCodigoQuantidade(npc.getCodigoP(), npc.getQtdTotal()));
            }
            for (ParCodigoQuantidade pcq : auxil) {
                res.add(pcq.clone());
            }
            return res;
        }
    }

    public ArrayList<TrioCodQuantNClientes> getTopComprados(int nElementos) {
        ArrayList<TrioCodQuantNClientes> res = new ArrayList<>();
        ArrayList<TrioCodQuantNClientes> resaux = new ArrayList<>();
        TreeSet<TrioCodQuantNClientes> auxil = new TreeSet<>(new ComparatorTrioCodQuantNClientes());
        for (NodoProduto np : this.produtos.values()) {
            auxil.add(new TrioCodQuantNClientes(np.getCodigoP(), np.getQtdComprada(), np.getClientesCompradores()));
        }
        for (TrioCodQuantNClientes tcq : auxil) {
            resaux.add(tcq.clone());
        }
        for (int i = 0; i < nElementos && i < resaux.size(); i++) {
            res.add(resaux.get(i));
        }
        return res;
    }

    public ArrayList<ParCodigoQuantidade> getClientesMaisProdutosDistintos(int nElementos) {
        ArrayList<ParCodigoQuantidade> res = new ArrayList<>();
        ArrayList<ParCodigoQuantidade> resAux = new ArrayList<>();
        TreeSet<ParCodigoQuantidade> auxil = new TreeSet<>();
        for (NodoCliente nc : this.clientes.values()) {
            auxil.add(new ParCodigoQuantidade(nc.getCodigoC(), nc.getProdutosDistintosComprados()));
        }
        for (ParCodigoQuantidade pcq : auxil) {
            resAux.add(pcq.clone());
        }
        for (int i = 0; i < nElementos && i < resAux.size(); i++) {
            res.add(resAux.get(i));
        }
        return res;
    }

    public ArrayList<TrioCodQuantFat> getTopCompradores(String codigoP) throws UnexistentCodeException {
        if (!(this.produtos.containsKey(codigoP))) {
            throw new UnexistentCodeException(codigoP);
        } else {
            TreeSet<TrioCodQuantFat> auxil = new TreeSet<>(new ComparatorTrioCodQuantFat());
            ArrayList<TrioCodQuantFat> res = new ArrayList<>();
            NodoProduto np = this.produtos.get(codigoP);
            for (NodoClienteComprador ncc : np.getClientesComp().values()) {
                auxil.add(new TrioCodQuantFat(ncc.getCodigoC(), ncc.getQuantidadeTotal(), ncc.getFaturacaoTotal()));
            }
            for (TrioCodQuantFat tcqf : auxil) {
                res.add(tcqf.clone());
            }
            return res;
        }
    }

    public int[] getCompradoresMensal() {
        int[] res = new int[12];
        for (NodoCliente nc : this.clientes.values()) {
            for (int mes = 1; mes <= 12; mes++) {
                if (nc.getCompraMes(mes) != 0) {
                    res[mes - 1]++;
                }
            }
        }
        return res;
    }

}
