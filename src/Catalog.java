
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeSet;

/**
 * Classe que implementa a estrutura de dados de um Catálogo
 *
 * @author Pedro Cunha, Stéphane Fernandes, Filipe de Oliveira
 */
public class Catalog implements ICatalog, Serializable {

    private HashMap<Character, TreeSet<String>> catalogo;

    /**
     * Método Construtor de vazio
     */
    public Catalog() {
        this.catalogo = new HashMap<>();
        for (Character c = 'A'; c <= 'Z'; c++) {
            this.catalogo.put(c, new TreeSet<String>());
        }
    }

    /**
     * Construtor de cópia de uma instância da classe Catalog
     *
     * @param other Catálogo a ser copiado
     */
    public Catalog(Catalog other) {
        this.catalogo = other.getCatalogo();
    }

    /**
     * 
     * @return Catálogo existente no objecto
     */
    public HashMap<Character, TreeSet<String>> getCatalogo() {
        HashMap<Character, TreeSet<String>> res = new HashMap<>();
        TreeSet<String> aux;
        Character counter = 'A';
        for (TreeSet<String> ts : this.catalogo.values()) {
            aux = new TreeSet<>();
            for (String st : ts) {
                aux.add(st);
            }
            res.put(counter, aux);
            counter++;
        }
        return res;
    }

    /**
     * 
     * @param newCat Novo Catálogo a ser colocado na estrutura
     */
    public void setCatalogo(HashMap<Character, TreeSet<String>> newCat) {
        this.catalogo = new HashMap<>();
        TreeSet<String> aux;
        Character counter = 'A';
        for (TreeSet<String> ts : newCat.values()) {
            aux = new TreeSet<>();
            for (String st : ts) {
                aux.add(st);
            }
            this.catalogo.put(counter, aux);
            counter++;
        }

    }
    /**
     * Método de inserção de um código na estrutura de Catálogo
     * @param code Código a ser inserido
     */
    public void insertCode(String code) {
        this.catalogo.get(Character.toUpperCase(code.charAt(0))).add(code);
    }

    /**
     * Método de verificação da existência de um Código no catálogo
     * @param code Código a ser verificado
     * @return Existência do Código
     */
    public boolean codeExists(String code) {
        return this.catalogo.get(Character.toUpperCase(code.charAt(0))).contains(code);
    }

    /**
     * Retorna todos os códigos existentes para uma letra
     * @param primLetra Letra a ser procurada
     * @return Lista com todos os códigos da letra dada
     */
    public ArrayList<String> getCodigosToArray(char primLetra) {
        ArrayList<String> res = new ArrayList<>();
        for (String codigo : this.catalogo.get(primLetra)) {
            res.add(codigo);
        }
        return res;
    }

    /**
     * Conta quantos códigos distintos existem no índice de uma dada letra
     * @param primLetra Letra que será utilizada para a procura
     * @return Nº de elementos no índice de uma letra
     */
    public int contaCodigosLetra(char primLetra) {
        return this.catalogo.get(primLetra).size();
    }

    /**
     * Retorna a árvore relativa ao índice de uma dada letra
     * @param primLetra Letra que será utilizada para a procura
     * @return Árvore relativa ao índice de uma dada letra
     */
    public TreeSet<String> getArvore(char primLetra) {
        TreeSet<String> res = new TreeSet<>();
        for (String st : this.catalogo.get(Character.toUpperCase(primLetra))) {
            res.add(st);
        }
        return res;
    }

    /**
     * Método clone
     * @return Uma nova instância de Catalog 
     */
    @Override
    public ICatalog clone() {
        return new Catalog(this);
    }

}
