
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.TreeSet;

/**
 * Classe que implementa o módulo de Compras 
 * @author Pedro Cunha, Stéphane Fernandes, Filipe de Oliveira
 */
public class ComprasDB implements IComprasDB,Serializable {

    private Map<String, NodoCliente> clientes;
    private Map<String, NodoProduto> produtos;
    /**
     * Construtor Vazio 
     */
    public ComprasDB() {
        this.clientes = new HashMap<>();

        this.produtos = new HashMap<>();
    }

    /**
     * Construtor de Cópia de um objecto ComprasDB
     * @param other Objecto a ser Copiado
     */
    public ComprasDB(ComprasDB other) {
        this.clientes = other.getClientes();

        this.produtos = other.getProdutos();
    }
    /**
     * 
     * @return Estrutura Relativa aos Clientes da Base de Dados
     */
    public Map<String, NodoCliente> getClientes() {
        HashMap<String, NodoCliente> res = new HashMap<>();
        for (NodoCliente nc : this.clientes.values()) {
            res.put(nc.getCodigoC(), nc.clone());
        }
        return res;
    }

    /**
     * 
     * @return Estrutura Relativa aos Produtos da Base de Dados
     */
    public Map<String, NodoProduto> getProdutos() {
        HashMap<String, NodoProduto> res = new HashMap<>();
        for (NodoProduto np : this.produtos.values()) {
            res.put(np.getCodigoP(), np.clone());
        }
        return res;
    }
    
    /**
     * Atualiza os Clientes existentes na Base de Dados
     * @param res Objecto a ser colocado
     */
    public void setClientes(Map<String, NodoCliente> res) {
        this.clientes = new HashMap<>();
        for (NodoCliente nc : res.values()) {
            this.clientes.put(nc.getCodigoC(), nc.clone());
        }

    }

    /**
     * Atualiza os Produtos existentes na Base de Dados
     * @param res Objecto a ser Colocado
     */
    public void setProdutos(Map<String, NodoProduto> res) {
        this.produtos = new HashMap<>();
        for (NodoProduto np : res.values()) {
            this.produtos.put(np.getCodigoP(), np.clone());
        }
    }

    /**
     * Insere um Código de Cliente na Estrutura
     * @param codigoC Código a ser inserido
     */
    public void insertCodigoCliente(String codigoC) {
        this.clientes.put(codigoC, new NodoCliente(codigoC));
    }

    /**
     * Insere um Código de Produto na Estrutura
     * @param codigoP Código a ser inserido
     */
    public void insertCodigoProduto(String codigoP) {
        this.produtos.put(codigoP, new NodoProduto(codigoP));
    }

    /**
     * Regista uma Compra na Estrutura
     * @param c Compra a ser Registada
     */
    public void registerSale(Compra c) {
        this.clientes.get(c.getCodigoCli()).registaCompra(c.clone());
        this.produtos.get(c.getCodigoProd()).registaCompra(c.clone());
    }

    /**
     * 
     * @return Nova instância como cópia da actual
     */
    public IComprasDB clone() {
        return new ComprasDB(this);
    }
    
    /**
     * 
     * @return Lista com os clientes que não realizaram qualquer compra 
     */
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
    /**
     * Apresenta o número de Compras e Clientes num dado mês
     * @param mes Mês para o qual é pretendida 
     * @return Par com o Número de Compras e Número de Clientes num dado mês
     * @throws InvalidMonthException Caso o mês seja inferior a 1 ou superior a 12
     */
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

    /**
     * Tabela de Produtos Distintos Comprados, Faturação e Número de Compras por mês de um Cliente
     * @param codigoC Código de Cliente a ser procurado
     * @return Tabela de Produtos Distintos Comprados, Faturação e Número de Compras por mês de um Cliente
     * @throws UnexistentCodeException Caso o código de Cliente não exista
     */
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

    /**
     * Tabela de Compradores Distintos, Faturação e Número de Compras por mês de um Produto
     * @param codigoP Código de Produto a ser procurado
     * @return Tabela de Compradores Distintos, Faturação e Número de Compras por mês de um Produto
     * @throws UnexistentCodeException Caso o código de Produto não exista
     */
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

    /**
     * 
     * @param codigoC Código a ser procurado
     * @return Lista Ordenada com os Pares de Código Quantidade, ordenada por quantidade e para quantidades iguais ordenada alfabeticamente
     * @throws UnexistentCodeException 
     */
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
    /**
     * 
     * @param nElementos Número de Elementos pretendidos na Lista
     * @return Lista Ordenada com a Quantidade Comprada, Código de Produto e Número de Clientes Compradores de Todos os Produtos
     */
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
    /**
     * 
     * @param nElementos Número de Elementos a conter na lista
     * @return Lista ordenada com os Clientes com mais produtos distintos Comprados
     */
    public ArrayList<ParCodigoQuantidade> getClientesMaisProdutosDistintos(int nElementos) {
        ArrayList<ParCodigoQuantidade> res = new ArrayList<>();
        ArrayList<ParCodigoQuantidade> resAux = new ArrayList<>();
        TreeSet<ParCodigoQuantidade> auxil = new TreeSet<>(new ComparatorParCodigoQuantidade());
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
    /**
     * 
     * @param codigoP Código de Produto a ser procurado
     * @return Lista Ordenada com a Quantidade Comprada, Código de Cliente e Faturação de um Produto
     * @throws UnexistentCodeException Caso o código de Produto nao exista
     */
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
    /**
     * 
     * @return Array com o número de Clientes Compradores por mês
     */
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
