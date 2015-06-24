package Business;


import Utils.UnexistentCodeException;
import Utils.VendasProdutoMensais;
import Utils.Compra;
import java.util.ArrayList;




/**
 * Interface IContabilidade
 * @author Pedro Cunha, Stéphane Fernandes, Filipe de Oliveira
 */
public interface IContabilidade {
    /**
     * Inserção de Código de Produto no módulo de Contabilidade
     * @param code Codigo de produto a ser inserido
     */
    public void insertCode(String code);
    /**
     * Registo de uma compra no módulo de contabilidade
     * @param c Compra a ser registada
     */
    public void registerSale(Compra c);
     /**
     * 
     * @return Novo Objecto como cópia da instância Actual
     */
    public IContabilidade clone();
    /**
     * 
     * @return Lista Com os Códigos de Produtos nunca Comprados
     */
    public ArrayList<String> getNuncaComprados();
    /**
     * 
     * @param codigoP Código a ser procurado
     * @return Vendas de um produto mensalmente
     * @throws UnexistentCodeException Caso o código não exista
     */
    public VendasProdutoMensais getVendasMensais(String codigoP) throws UnexistentCodeException;
    /**
     * 
     * @return Compras realizadas mensalmente
     */
    public int[] comprasMensais();
    /**
     * 
     * @return Faturação registada mensalmente
     */
    public float[] faturacaoMensal();
    
}
