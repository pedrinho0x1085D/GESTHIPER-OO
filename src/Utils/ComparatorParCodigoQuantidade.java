package Utils;


import java.io.Serializable;
import java.util.Comparator;



/**
 * Classe que permitirá a ordenação de ParesCodigoQuantidade utilizando o seguinte algoritmo:
 * -><p>Deverá estar ordenado por quantidade,</p>
 * -><p>Para quantidades iguais ordenar alfabeticamente</p>
 * @author Pedro Cunha, Stéphane Fernandes, Filipe de Oliveira
 */
public class ComparatorParCodigoQuantidade implements Comparator<ParCodigoQuantidade>,Serializable{
    /**
     * Método de comparação que cumpre os requisitos pedidos
     * @param pcq1 ParCodigoQuantidade que será comparado 
     * @param pcq2 ParCodigoQuantidade que será comparado
     * @return Valor comparativo entre pcq1 e pcq2
     */
    public int compare(ParCodigoQuantidade pcq1,ParCodigoQuantidade pcq2){
        if(pcq1.getQuantidade()!=pcq2.getQuantidade()) return pcq2.getQuantidade()-pcq1.getQuantidade();
        else return pcq1.getCodigo().compareTo(pcq2.getCodigo());
    }
}
