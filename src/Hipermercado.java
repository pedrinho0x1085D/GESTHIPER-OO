
import java.io.Serializable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Pedro Cunha
 */
public class Hipermercado implements Serializable {

    private ICatalog clientes;
    private ICatalog produtos;
    private IContabilidade contabilidade;
    private IComprasDB compras;

    public Hipermercado() {
        this.clientes=new Catalog();
        this.produtos=new Catalog();
        this.contabilidade=new Contabilidade();
        this.compras=new ComprasDB();
    }

    public ICatalog getClientes(){
        return this.clientes.clone();
    }
    
    public ICatalog getProdutos(){
        return this.produtos.clone();
    }
    
    public IContabilidade getContabilidade(){
        return this.contabilidade.clone();
    }
    
    public IComprasDB getCompras(){
        return this.compras.clone();
    }
    
    public void setClientes(ICatalog icata){
        this.clientes=icata.clone();
    }
    
    public void setProdutos(ICatalog icata){
        this.produtos=icata.clone();
    }
    
    public void setContabilidade(IContabilidade icont){
        this.contabilidade=icont.clone();
    }
    
    public void setCompras(IComprasDB icomp){
        this.compras=icomp.clone();
    }
    
    public void insertCliente(String codigoC) {
        this.clientes.insertCode(codigoC);
        this.compras.insertCodigoCliente(codigoC);
    }
    
        
    public void insertProduto(String codigoP) {
        this.produtos.insertCode(codigoP);
        this.contabilidade.insertCode(codigoP);
        this.compras.insertCodigoProduto(codigoP);
    }

    public void registerSale(Compra c) {
        this.contabilidade.registerSale(c);
        this.compras.registerSale(c);
    }

    public boolean compraValida(Compra c) {
        if (this.clientes.codeExists(c.getCodigoCli()) && this.produtos.codeExists(c.getCodigoProd())) {
            return true;
        } else {
            return false;
        }
    }
}
