/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentación;

/**
 *
 * @author estudiantes
 */

import Lógica.Configuración;
import javax.swing.JTextField;

public class Modelo {
    
    private Configuración miSistema;
    private VentanaPrincipal ventana;     
    
    public void iniciar(){
        getVentana().setVisible(true);
    }
    
    public void calificar(){
        try{
            getMiSistema().setTablero(getVentana().getNumeros());            

            if(getMiSistema().calificar()){
                getVentana().getMensaje().setText("El sudoku ha sido solucionado correctamente");
            }
            else{            
                getVentana().getMensaje().setText("El sudoku no se ha solucionado correctamente");
            }
        }
        catch (NumberFormatException err){
           getVentana().getMensaje().setText("Algunas casillas aún están vacías");     
        }
    } 
    
    
    
    
    public void llenar(){
        getMiSistema().setDificultad(getVentana().getDificultad());
        getMiSistema().llenar();
        
        getVentana().setNumeros(getMiSistema().getTablero());
        
        JTextField [][] tablero=getVentana().getTablero();
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(getVentana().getNumeros()[i][j]!=0){
                    tablero[i][j].setText(""+(getVentana().getNumeros())[i][j]);                
                }
                else{
                    tablero[i][j].setText(""); 
                }
            }
        }
        getVentana().setTablero(tablero);
    }
    
    public void dificultad(){
        getMiSistema().setDificultad(getVentana().getDificultad());
        llenar();
    }

    public Configuración getMiSistema() {
        if(miSistema==null){
            miSistema = new Configuración();
        }
        return miSistema;
    }

    public void setMiSistema(Configuración miSistema) {
        this.miSistema = miSistema;
    }

    public VentanaPrincipal getVentana() {
        if(ventana==null){
            ventana=new VentanaPrincipal(this);
        }
        return ventana;
    }

    public void setVentana(VentanaPrincipal ventana) {
        this.ventana = ventana;
    }
    
    
}
