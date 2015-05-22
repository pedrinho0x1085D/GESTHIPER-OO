
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
public class ComparatorTrioCodQuantFat implements Comparator<TrioCodQuantFat>,Serializable{
    public int compare(TrioCodQuantFat tcqf1,TrioCodQuantFat tcqf2){
        if(tcqf1.getQuantidade()!=tcqf2.getQuantidade()) return tcqf1.getQuantidade()-tcqf2.getQuantidade();
        else if(!(tcqf1.getCodigo().equals(tcqf2.getCodigo()))) return tcqf1.getCodigo().compareTo(tcqf2.getCodigo());
        else return (int)(tcqf1.getFaturacao()-tcqf2.getFaturacao());
    }
}
