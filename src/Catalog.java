
import java.util.ArrayList;
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
public class Catalog implements ICatalog{
    private TreeSet<String> catalogo[];
    
    /*Duvida aqui na inicializacao*/
    public Catalog(){
        for(int i=0;i<27;i++)
            this.catalogo[i]=new TreeSet<>();
    }
    
    private int getPos(char primLetra){
        if(Character.isAlphabetic(primLetra)) return Character.toUpperCase(primLetra)-'A'+1;
        else return 0;
    }
    
    public void insertCode(String code){
        this.catalogo[getPos(code.charAt(0))].add(code);
    }
    
    public boolean codeExists(String code){
        return this.catalogo[getPos(code.charAt(0))].contains(code);
    }
    
    public ArrayList<String> getCodigosToArray(char primLetra){
        ArrayList<String> res=new ArrayList<>();
        for(String codigo:this.catalogo[getPos(primLetra)])
            res.add(codigo);
        return res;
    }
}
