
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
public class ComparatorCompra implements Comparator<Compra>{
    public int compare(Compra c1,Compra c2){
        if(!(c1.getCodigoCli().equals(c2.getCodigoCli()))) return c1.getCodigoCli().compareTo(c2.getCodigoCli());
        else if(!(c1.getCodigoProd().equals(c2.getCodigoProd()))) return c1.getCodigoProd().compareTo(c2.getCodigoProd());
        else if(c1.getMes()!=c2.getMes()) return c1.getMes()-c2.getMes();
        else if(c1.getModo()!=c2.getModo()) return c1.getModo() - c2.getModo();
        else if(c1.getQuantidade()!=c2.getQuantidade()) return c1.getQuantidade()-c2.getQuantidade();
        else if(c1.getValorUni()!=c2.getValorUni()) return (int)(c1.getValorUni()-c2.getValorUni());
        else return 0;
    }
}
