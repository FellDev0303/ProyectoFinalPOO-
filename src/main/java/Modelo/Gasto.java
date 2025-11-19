/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author LENOVO
 */
public class Gasto {
    protected String nombre;
    protected int costo;

    public Gasto(String nombre, int costo) {
        this.nombre = nombre;
        this.costo = costo;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCosto() {
        return costo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }
    

    @Override 
    public String toString(){
    return nombre + "- $"+ costo;
    }
    
}
