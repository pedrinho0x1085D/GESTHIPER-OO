
import java.util.ArrayList;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Pedro Cunha
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
    public IContabilidade clone();
    public ArrayList<String> getNuncaComprados();
    public VendasProdutoMensais getVendasMensais(String codigoP) throws UnexistentCodeException;
    public int[] comprasMensais();
    public float[] faturacaoMensal();
    
}
