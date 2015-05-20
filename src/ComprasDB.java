
import java.util.ArrayList;
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
        this.clientes=new HashMap<>();
        this.compras=new TreeSet<>(new ComparatorCompra());
        this.produtos=new HashMap<>();
    }
    
    public ComprasDB(ComprasDB other){
        this.clientes=other.getClientes();
        this.compras=other.getCompras();
        this.produtos=other.getProdutos();
    }
    public HashMap<String,NodoCliente> getClientes(){
        HashMap<String,NodoCliente> res=new HashMap<>();
        for(NodoCliente nc:this.clientes.values())
            res.put(nc.getCodigoC(),nc.clone());
        return res;
    }
    
    public TreeSet<Compra> getCompras(){
        TreeSet<Compra> res=new TreeSet<>(new ComparatorCompra());
        for(Compra c:this.compras)
            res.add(c.clone());
        return res;
    }
    
    public HashMap<String,NodoProduto> getProdutos(){
        HashMap<String,NodoProduto> res=new HashMap<>();
        for(NodoProduto np:this.produtos.values())
            res.put(np.getCodigoP(), np.clone());
        return res;
    }
    
    public void setClientes(HashMap<String,NodoCliente> res){
        this.clientes=new HashMap<>();
        for(NodoCliente nc:res.values())
            this.clientes.put(nc.getCodigoC(),nc.clone());
        
    }
    
    public void setCompras(TreeSet<Compra> res){
        this.compras=new TreeSet<>(new ComparatorCompra());
        for(Compra c:res)
            this.compras.add(c.clone());
    }
    
    public void setProdutos(HashMap<String,NodoProduto> res){
        this.produtos=new HashMap<>();
        for(NodoProduto np:res.values())
            this.produtos.put(np.getCodigoP(), np.clone());
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
        this.compras.add(c.clone());
        this.produtos.get(c.getCodigoProd()).registaCompra(c.clone());
    }

    @Override
    public IComprasDB clone() {
        return new ComprasDB(this);
    }

    
    public ArrayList<String> clientesNaoCompradores() {
        TreeSet<String> resaux=new TreeSet<>();
        ArrayList<String> res=new ArrayList<>();
        for(NodoCliente nc:this.clientes.values())
            if(nc.getnCompras()==0) resaux.add(nc.getCodigoC());
        for(String st:resaux)
            res.add(st);
        return res;
    }
    
    
}
