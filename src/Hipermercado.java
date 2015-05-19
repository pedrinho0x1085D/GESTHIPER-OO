/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Pedro Cunha
 */
public class Hipermercado {

    private ICatalog clientes;
    private ICatalog produtos;
    private IContabilidade contabilidade;
    private IComprasDB compras;

    public Hipermercado() {
        this.clientes=new Catalog();
        this.produtos=new Catalog();
    }

    public ICatalog getClientes(){
        return this.clientes.clone();
    }
    
    public ICatalog getProdutos(){
        return this.produtos.clone();
    }
    
    public void setClientes(ICatalog icata){
        this.clientes=icata.clone();
    }
    
    public void setProdutos(ICatalog icata){
        this.produtos=icata.clone();
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
