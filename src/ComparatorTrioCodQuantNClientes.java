
import java.io.Serializable;
import java.util.Comparator;


/**
 *Classe que permitirá a ordenação de Trios Código Quantidade Número de Clientes utilizando o seguinte algoritmo:
 * <p>->Deverá estar ordenado por quantidade,</p>
 * <p>->Para quantidades iguais ordenar alfabeticamente os códigos</p>
 * @author Pedro Cunha, Stéphane Fernandes, Filipe de Oliveira
 */
public class ComparatorTrioCodQuantNClientes implements Comparator<TrioCodQuantNClientes>,Serializable{
    /**
     * Método de comparação que cumpre os requisitos pedidos. Por questão de Complexão também foi realizada
     * a comparação de Número de Clientes, caso todos os outros campos forem iguais
     * @param t1 TrioCodQuantNClientes a ser comparado
     * @param t2 TrioCodQuantNClientes a ser comparado
     * @return Valor comparativo entre t1 e t2
     */
    public int compare(TrioCodQuantNClientes t1,TrioCodQuantNClientes t2){
        if(t1.getQuantidade()!=t2.getQuantidade()) return t1.getQuantidade()-t2.getQuantidade();
        else if(!(t1.getCodigo().equals(t2.getCodigo()))) return t1.getCodigo().compareTo(t2.getCodigo());
        else return t1.getnClientes()-t2.getnClientes();
    }
}
