
import java.io.Serializable;
import java.util.Comparator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Pedro Cunha
 */
public class ComparatorTrioCodQuantNClientes implements Comparator<TrioCodQuantNClientes>,Serializable{
    public int compare(TrioCodQuantNClientes t1,TrioCodQuantNClientes t2){
        if(t1.getQuantidade()!=t2.getQuantidade()) return t1.getQuantidade()-t2.getQuantidade();
        else if(!(t1.getCodigo().equals(t2.getCodigo()))) return t1.getCodigo().compareTo(t2.getCodigo());
        else return t1.getnClientes()-t2.getnClientes();
    }
}
