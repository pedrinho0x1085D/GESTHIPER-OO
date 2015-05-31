
import java.io.Serializable;
import java.util.Comparator;


/**
 * Classe que permitirá a ordenação de Trios Código Quantidade Faturação utilizando o seguinte algoritmo:
 * <p>->Deverá estar ordenado por quantidade,</p>
 * <p>->Para quantidades iguais ordenar alfabeticamente os códigos</p>
 * @author Pedro Cunha, Stéphane Fernandes, Filipe de Oliveira
 */
public class ComparatorTrioCodQuantFat implements Comparator<TrioCodQuantFat>,Serializable{
    /**
     * Método de comparação que cumpre os requisitos pedidos. Por questão de Complexão também foi realizada
     * a comparação de Faturações, caso todos os outros campos forem iguais
     * @param tcqf1 TrioCodQuantFat a ser comparado
     * @param tcqf2 TrioCodQuantFat a ser comparado
     * @return Valor comparativo entre tcqf1 e tcqf2
     */
    public int compare(TrioCodQuantFat tcqf1,TrioCodQuantFat tcqf2){
        if(tcqf1.getQuantidade()!=tcqf2.getQuantidade()) return tcqf1.getQuantidade()-tcqf2.getQuantidade();
        else if(!(tcqf1.getCodigo().equals(tcqf2.getCodigo()))) return tcqf1.getCodigo().compareTo(tcqf2.getCodigo());
        else return (int)(tcqf1.getFaturacao()-tcqf2.getFaturacao());
    }
}
