
import java.util.Arrays;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Pedro Cunha
 */
public class ParNComprasNClientes {

    private int nCompras;
    private int nClientes;

    public ParNComprasNClientes() {
        this.nClientes = 0;
        this.nCompras = 0;
    }

    public ParNComprasNClientes(ParNComprasNClientes outro) {
        this.nClientes = outro.getnClientes();
        this.nCompras = outro.getnCompras();
    }

    public int getnClientes() {
        return this.nClientes;
    }

    public int getnCompras() {
        return this.nCompras;
    }

    public void setnClientes(int nClientes) {
        this.nClientes = nClientes;
    }

    public void setnCompras(int nCompras) {
        this.nCompras = nCompras;
    }

    public void incCliente() {
        this.nClientes++;
    }

    public void incClientes(int nClientes) {
        this.nClientes += nClientes;

    }

    public void adicionaCompras(int nCompras) {
        this.nCompras += nCompras;
    }

    public ParNComprasNClientes clone() {
        return new ParNComprasNClientes(this);
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if ((!(this.getClass().getSimpleName().equals(o.getClass().getSimpleName()))) || o == null) {
            return false;
        } else {
            ParNComprasNClientes par = (ParNComprasNClientes) o;
            return this.nClientes == par.getnClientes() && this.nCompras == par.getnCompras();
        }
    }
    
    public int hashCode(){
        return Arrays.hashCode(new Object[]{this.nClientes,this.nCompras});
    }

}
