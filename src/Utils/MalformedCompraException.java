package Utils;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Pedro Cunha
 */
public class MalformedCompraException extends Exception{
    public MalformedCompraException(){
        super();
    }
    public MalformedCompraException(String args){
        super(args);
    }
}
