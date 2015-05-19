
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
public class ComprasDB implements IComprasDB{

    private HashMap<String,NodoCliente> clientes;
    private HashMap<String,NodoProduto> produtos;
    private TreeSet<Compra> compras;
    
    public ComprasDB(){
        this.compras=new TreeSet<>(new ComparatorCompra());
    }
    
    @Override
    public void insertCodigoCliente(String codigoC) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insertCodigoProduto(String codigoP) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void registerSale(Compra c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IComprasDB clone() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
