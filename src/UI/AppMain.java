/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Business.GlobalStats;
import Business.Hipermercado;

/**
 *
 * @author Pedro Cunha
 */
public class AppMain {
    public static void main(String[] args) {
        new FileLoadingGUI(new Hipermercado(),new GlobalStats()).setVisible(true);
    }
}
