
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeSet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Pedro Cunha
 */
public class Catalog implements ICatalog,Serializable {

    private HashMap<Character, TreeSet<String>> catalogo;

  /**
   * Função que inicializa um novo catálogo
   */
    public Catalog() {
        this.catalogo = new HashMap<>();
        for (Character c = 'A'; c <= 'Z'; c++) {
            this.catalogo.put(c, new TreeSet<String>());
        }
    }
    
    public Catalog(Catalog other){
        this.catalogo=other.getCatalogo();
    }

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

    public void insertCode(String code) {
        this.catalogo.get(Character.toUpperCase(code.charAt(0))).add(code);
    }

    public boolean codeExists(String code) {
        return this.catalogo.get(Character.toUpperCase(code.charAt(0))).contains(code);
    }

    public ArrayList<String> getCodigosToArray(char primLetra) {
        ArrayList<String> res = new ArrayList<>();
        for (String codigo : this.catalogo.get(primLetra)) {
            res.add(codigo);
        }
        return res;
    }
    
    public int contaCodigosLetra(char primLetra){
        return this.catalogo.get(primLetra).size();
    }
    
    public TreeSet<String> getArvore(char primLetra){
        TreeSet<String> res=new TreeSet<>();
        for(String st:this.catalogo.get(Character.toUpperCase(primLetra)))
            res.add(st);
        return res;
    }

    @Override
    public ICatalog clone(){
        return new Catalog(this);
    }
    
    
}
