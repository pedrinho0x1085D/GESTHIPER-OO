
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Pedro Cunha
 */
public interface ICatalog {
    public void insertCode(String code);
    public ArrayList<String> getCodigosToArray(char primLetra);
    
}
