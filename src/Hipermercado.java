
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.io.Serializable;
import java.util.ArrayList;


/**
 * Classe de convergência dos Módulos
 * @author Pedro Cunha, Stéphane Fernandes, Filipe de Oliveira
 */
public class Hipermercado implements Serializable {

    private ICatalog clientes;
    private ICatalog produtos;
    private IContabilidade contabilidade;
    private IComprasDB compras;
    /**
     * Construtor Vazio
     */
    public Hipermercado() {
        this.clientes = new Catalog();
        this.produtos = new Catalog();
        this.contabilidade = new Contabilidade();
        this.compras = new ComprasDB();
    }
    /**
     * 
     * @return Catálogo de Clientes
     */
    public ICatalog getClientes() {
        return this.clientes.clone();
    }
    /**
     * 
     * @return Catálogo de Produtos
     */
    public ICatalog getProdutos() {
        return this.produtos.clone();
    }
    /**
     * 
     * @return Módulo de Contabilidade
     */
    public IContabilidade getContabilidade() {
        return this.contabilidade.clone();
    }
    /**
     * 
     * @return Módulo de Compras
     */
    public IComprasDB getCompras() {
        return this.compras.clone();
    }
    /**
     * Atualiza o catálogo de Clientes
     * @param icata Novo Catálogo de Clientes
     */
    public void setClientes(ICatalog icata) {
        this.clientes = icata.clone();
    }
    /**
     * Atualiza o catálogo de Produtos
     * @param icata Novo Catálogo de Produtos
     */
    public void setProdutos(ICatalog icata) {
        this.produtos = icata.clone();
    }
    /**
     * Atualiza o Módulo de Contabilidade
     * @param icont Novo Módulo de Contabilidade
     */
    public void setContabilidade(IContabilidade icont) {
        this.contabilidade = icont.clone();
    }
    /**
     * Atualiza o Módulo de Compras
     * @param icomp Novo Módulo de Compras
     */
    public void setCompras(IComprasDB icomp) {
        this.compras = icomp.clone();
    }
    /**
     * Insere um novo código de Cliente nos módulos
     * @param codigoC Código de Cliente a ser inserido
     */
    public void insertCliente(String codigoC) {
        this.clientes.insertCode(codigoC);
        this.compras.insertCodigoCliente(codigoC);
    }
    /**
     * Insere um novo código de Produto nos módulos
     * @param codigoP Código de Produto a ser inserido
     */
    public void insertProduto(String codigoP) {
        this.produtos.insertCode(codigoP);
        this.contabilidade.insertCode(codigoP);
        this.compras.insertCodigoProduto(codigoP);
    }
    /**
     * Regista uma Compra nos Módulos
     * @param c Compra a ser registada
     */
    public void registerSale(Compra c) {
        this.contabilidade.registerSale(c);
        this.compras.registerSale(c);
    }
    /**
     * 
     * @return Lista com os códigos de Produtos Nunca Comprados
     */
    public ArrayList<String> getProdutosNuncaComprados() {
        return this.contabilidade.getNuncaComprados();
    }
    /**
     * 
     * @return Lista com os códigos de Clientes que nunca realizaram Compras
     */
    public ArrayList<String> getClientesNaoCompradores() {
        return this.compras.clientesNaoCompradores();
    }
    /**
     * 
     * @param mes Mês a ser procurado
     * @return Número de Compras e Clientes Distintos num mês
     * @throws InvalidMonthException Caso o mês passado como parâmetro seja inválido
     */
    public ParNComprasNClientes getTotNComprasNClientes(int mes) throws InvalidMonthException {
        return this.compras.getTotCompTotCli(mes);
    }
    /**
     * 
     * @param codigoC Código de cliente a ser procurado
     * @return Tabela com as compras, produtos distintos e total de dinheiro gasto por mês por parte de um cliente
     * @throws UnexistentCodeException Caso o código de cliente não exista
     */
    public Table getTableCliente(String codigoC) throws UnexistentCodeException {
        return this.compras.getTableCliente(codigoC);
    }
    /**
     * 
     * @param codigoP Código de produto a ser procurado
     * @return Tabela com as vezes que um produto foi comprado, clientes distintos e total facturado por mês de um produto
     * @throws UnexistentCodeException Caso o código de produto não exista
     */
    public Table getTableProduto(String codigoP) throws UnexistentCodeException {
        return this.compras.getTableProduto(codigoP);
    }
    /**
     * 
     * @param codigoP Código de produto a ser procurado
     * @return Tabela com vendas e faturações nos modos N e P mensais de um produto
     * @throws UnexistentCodeException Caso o código de produto não exista
     */
    public VendasProdutoMensais getVendasMensais(String codigoP) throws UnexistentCodeException {
        return this.contabilidade.getVendasMensais(codigoP);
    }   
    /**
     * 
     * @param codigoC Código do Cliente a ser procurado
     * @return Lista ordenada com os códigos de Produto comprados pelo Cliente e sua quantidade, ordenados por 
     * @throws UnexistentCodeException 
     */
    public ArrayList<ParCodigoQuantidade> getTopCompras(String codigoC) throws UnexistentCodeException {
        return this.compras.getTopCompras(codigoC);
    }
    /**
     * 
     * @param nElementos Número de elementos que o utilizador pretende que sejam apresentadas
     * @return Lista com os n Produtos mais comprados no ano em unidades vendidas
     */
    public ArrayList<TrioCodQuantNClientes> getTopComprados(int nElementos) {
        return this.compras.getTopComprados(nElementos);
    }
    /**
     * 
     * @param nElementos Número de elementos que o utilizador pretende que sejam apresentadas
     * @return Lista ordenada com os n Clientes que compraram mais produtos distintos, ordenada por número de produtos distintos e para casos com produtos iguais ordenada alfabeticamente
     */
    public ArrayList<ParCodigoQuantidade> getClientesMaisProdutosDistintos(int nElementos) {
        return this.compras.getClientesMaisProdutosDistintos(nElementos);
    }
    /**
     * 
     * @param codigoP Código de produto a ser procurado
     * @return Lista ordenada com os Clientes que mais compraram o produto e valor gasto
     * @throws UnexistentCodeException 
     */
    public ArrayList<TrioCodQuantFat> getTopCompradores(String codigoP) throws UnexistentCodeException {
        return this.compras.getTopCompradores(codigoP);
    }
    /**
     * 
     * @return Compras realizadas por mês
     */
    public int[] comprasMensais() {
        return this.contabilidade.comprasMensais();
    }
    /**
     * 
     * @return Faturação registada por mês
     */
    public float[] faturacaoMensal() {
        return this.contabilidade.faturacaoMensal();
    }
    /**
     * 
     * @return Clientes distintos compradores por mês
     */
    public int[] getCompradoresMensal() {
        return this.compras.getCompradoresMensal();
    }
    /**
     * Verifica se a compra passada é válida no Hipermercado
     * <p>Os requisitos para uma compra ser válida são:</p>
     * <p>O código de Cliente existir no catálogo de Clientes</p>
     * <p>O código de Produto existir no catálogo de Produtos<p>
     * @param c Compra a ser testada
     * @return true se os requisitos forem cumpridos, false caso contrário
     */
    public boolean compraValida(Compra c) {
        if (this.clientes.codeExists(c.getCodigoCli()) && this.produtos.codeExists(c.getCodigoProd())) {
            return true;
        } else {
            return false;
        }
    }
    /**
     * Método de escrita para um ficheiro de Objectos
     * @param filename Nome do Ficheiro destino
     * @throws IOException Caso hajam erros de disco
     */
    public void toObjFile(String filename) throws IOException{
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename));
        oos.writeObject(this);
        oos.flush();
        oos.close();
    }
    /**
     * Método de leitura a partir de um ficheiro de objectos
     * @param filename Nome do ficheiro de origem
     * @return Instância de Hipermercado lida a partir do ficheiro de objectos
     * @throws IOException Caso o ficheiro não exista
     * @throws ClassNotFoundException Caso o objecto lido não seja compatível com Hipermercado
     */
    public static Hipermercado readFromObjFile(String filename)throws IOException,ClassNotFoundException{
        ObjectInputStream ois= new ObjectInputStream(new FileInputStream(filename));
        Hipermercado res=(Hipermercado)ois.readObject();
        ois.close();
        return res;
    }
}
