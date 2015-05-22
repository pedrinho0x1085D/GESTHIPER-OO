
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
public class ComparatorParCodigoQuantidade implements Comparator<ParCodigoQuantidade>,Serializable{
    public int compare(ParCodigoQuantidade pcq1,ParCodigoQuantidade pcq2){
        if(pcq1.getQuantidade()!=pcq2.getQuantidade()) return pcq1.getQuantidade()-pcq2.getQuantidade();
        else return pcq1.getCodigo().compareTo(pcq2.getCodigo());
    }
}
