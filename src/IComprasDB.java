
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
public interface IComprasDB {
    public void insertCodigoCliente(String codigoC);
    public void insertCodigoProduto(String codigoP);
    public void registerSale(Compra c);
    public IComprasDB clone();
    public ArrayList<String> clientesNaoCompradores();
    public ParNComprasNClientes getTotCompTotCli(int mes);
    public Table getTableCliente(String codigoC);
    public Table getTableProduto(String codigoC);
}
