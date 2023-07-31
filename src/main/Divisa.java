/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 *
 * @author elias
 */
public class Divisa {
    private String nombre = "";
    private float valor_pesos_m = 0;
    
    public Divisa(String nombre, float valor_pesos_m){
        this.nombre = nombre;
        this.valor_pesos_m = valor_pesos_m;
    }
    
    public String getNombre(){
        return this.nombre;
    }
    
    public float getValor(){
        return this.valor_pesos_m;
    }
}
