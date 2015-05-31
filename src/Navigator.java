
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;


/**
 * Classe que servirá para navegar numa lista de Objectos
 * @author Pedro Cunha
 */
public class Navigator<T> {
	private ArrayList<T> items;
	private int current;
	/**
         * Construtor Utilizando Listas
         * @param l Lista a ser utilizada no navegador
         */
	public Navigator(ArrayList<T> l) {
		this.items = new ArrayList<>(l);
		this.current = 0;
	}
	/**
         * Construtor Utilizando Conjuntos
         * @param s Conjunto a ser utilizador no navegador
         */
	public Navigator(TreeSet<T> s) {
		this.items = new ArrayList<>(s);
		this.current = 0;
	}
	/**
         * 
         * @return Próximo elemento no navegador
         * @throws NoMoreItemsException Caso não hajam mais elementos
         */
	public T getNext() throws NoMoreItemsException {
		if (this.current >= this.items.size()) {
			throw new NoMoreItemsException();
		}
		else {
			this.current++;
			return this.items.get(this.current - 1);
		}
	}
	/**
         * 
         * @param n Número de elementos a apresentar
         * @return Lista com os n seguintes elementos
         * @throws NoMoreItemsException Caso não hajam mais elementos
         */
	public List<T> getNext(int n) throws NoMoreItemsException {
		if (this.current >= this.items.size()) {
			throw new NoMoreItemsException();
		}
		else {
			int curr = this.current;
			this.current += n;
			
			if (this.current > this.items.size()) {
				this.current = this.items.size();
			}
			
			return this.items.subList(curr, this.current);
		}
	}
	/**
         * Volta atrás n posições
         * @param n Número de posições a ser rebobinadas
         * @throws NoMoreItemsException Caso não hajam mais elementos
         */
	public void back(int n) throws NoMoreItemsException {
		if (this.current <= 0) {
			throw new NoMoreItemsException();
		}
		else {
			this.current -= n;
			
			if (this.current < 0) {
				this.current = 0;
			}
		}
	}
	/**
         * Volta atrás 1 posição
         * @throws NoMoreItemsException Caso não hajam mais elementos
         */
	public void back() throws NoMoreItemsException {
		if (this.current <= 0) {
			throw new NoMoreItemsException();
		}
		else {
			this.current--;
		}
	}
	/**
         * 
         * @return Tamanho do Navegador
         */
	public int size() {
		return this.items.size();
	}
	/**
         * 
         * @return Posição Actual
         */
	public int current() {
		return this.current;
	}
	/**
         * 
         * @return Items que faltam para o fim do navegador
         */
	public int itemsLeft() {
		return this.items.size() - this.current;
	}
}