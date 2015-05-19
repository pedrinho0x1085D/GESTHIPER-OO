/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Pedro Cunha
 */
public interface IContabilidade {
    public void insertCode(String code);
    public void registerSale(Compra c);
    public IContabilidade clone();
}
