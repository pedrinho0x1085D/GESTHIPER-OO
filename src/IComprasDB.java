
import java.util.ArrayList;


/**
 * Interface IComprasDB
 * @author Pedro Cunha, Stéphane Fernandes, Filipe de Oliveira
 */
public interface IComprasDB {
    /**
     * Inserção de Código de Cliente
     * @param codigoC Código a ser inserido
     */
    public void insertCodigoCliente(String codigoC);
    /**
     * Inserção de um Código de Produto
     * @param codigoP Código a ser inserido
     */
    public void insertCodigoProduto(String codigoP);
    /**
     * Registo de uma Compra
     * @param c Compra a ser registada
     */
    public void registerSale(Compra c);
    /**
     * 
     * @return Cópia da instância actual
     */
    public IComprasDB clone();
    /**
     * 
     * @return Lista com os clientes que não realizaram qualquer compra 
     */
    public ArrayList<String> clientesNaoCompradores();
    /**
     * Apresenta o número de Compras e Clientes num dado mês
     * @param mes Mês para o qual é pretendida 
     * @return Par com o Número de Compras e Número de Clientes num dado mês
     * @throws InvalidMonthException Caso o mês seja inferior a 1 ou superior a 12
     */
    public ParNComprasNClientes getTotCompTotCli(int mes) throws InvalidMonthException;
    /**
     * Tabela de Produtos Distintos Comprados, Faturação e Número de Compras por mês de um Cliente
     * @param codigoC Código de Cliente a ser procurado
     * @return Tabela de Produtos Distintos Comprados, Faturação e Número de Compras por mês de um Cliente
     * @throws UnexistentCodeException Caso o código de Cliente não exista
     */
    public Table getTableCliente(String codigoC) throws UnexistentCodeException;
    /**
     * Tabela de Compradores Distintos, Faturação e Número de Compras por mês de um Produto
     * @param codigoP Código de Produto a ser procurado
     * @return Tabela de Compradores Distintos, Faturação e Número de Compras por mês de um Produto
     * @throws UnexistentCodeException Caso o código de Produto não exista
     */
    public Table getTableProduto(String codigoP) throws UnexistentCodeException;
    /**
     * 
     * @param codigoC Código a ser procurado
     * @return Lista Ordenada com os Pares de Código Quantidade, ordenada por quantidade e para quantidades iguais ordenada alfabeticamente
     * @throws UnexistentCodeException 
     */
    public ArrayList<ParCodigoQuantidade> getTopCompras(String codigoC) throws UnexistentCodeException;
    /**
     * 
     * @param nElementos Número de Elementos pretendidos na Lista
     * @return Lista Ordenada com a Quantidade Comprada, Código de Produto e Número de Clientes Compradores de Todos os Produtos
     */
    public ArrayList<TrioCodQuantNClientes> getTopComprados(int nElementos);
    /**
     * 
     * @param nElementos Número de Elementos a conter na lista
     * @return Lista ordenada com os Clientes com mais produtos distintos Comprados
     */
    public ArrayList<ParCodigoQuantidade> getClientesMaisProdutosDistintos(int nElementos);
    /**
     * 
     * @param codigoP Código de Produto a ser procurado
     * @return Lista Ordenada com a Quantidade Comprada, Código de Cliente e Faturação de um Produto
     * @throws UnexistentCodeException Caso o código de Produto nao exista
     */
    public ArrayList<TrioCodQuantFat> getTopCompradores(String codigoP) throws UnexistentCodeException;
    /**
     * 
     * @return Array com o número de Clientes Compradores por mês
     */
    public int[] getCompradoresMensal();
}
