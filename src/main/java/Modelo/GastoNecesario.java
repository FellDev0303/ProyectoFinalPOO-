/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author LENOVO
 */
public class GastoNecesario extends Gasto{

    public GastoNecesario(String nombre, int costo) {
        super(nombre, costo);
    }
    
    @Override
    public String toString(){
    return "[Necesario]"+ super.toString();
    }
    
}
