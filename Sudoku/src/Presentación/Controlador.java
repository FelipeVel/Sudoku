/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentación;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author estudiantes
 */
public class Controlador implements ActionListener {
    private final VentanaPrincipal ventana;

    public Controlador(VentanaPrincipal aThis) {
        ventana = aThis;
    }
    
    public static boolean isNumeric(String cadena) {

        boolean resultado;

        try {
            Integer.parseInt(cadena);
            resultado = true;
        } catch (NumberFormatException excepcion) {
            resultado = false;
        }

        return resultado;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        boolean seguir=true;
        if(e.getSource().equals(ventana.getTerminar())){
            for(int i=0;i<9;i++){
                for(int j=0;j<9;j++){
                    if(!ventana.getTablero()[i][j].getText().equals("")&&isNumeric(ventana.getTablero()[i][j].getText())&&Integer.parseInt(ventana.getTablero()[i][j].getText())<=9 && Integer.parseInt(ventana.getTablero()[i][j].getText())>=0)
                        ventana.getNumeros()[i][j]=Integer.parseInt(ventana.getTablero()[i][j].getText());
                    else if(ventana.getTablero()[i][j].getText().equals("")){
                        ventana.getMensaje().setText("Aún hay celdas vacías");
                        seguir=false;
                    }
                    else if(!isNumeric(ventana.getTablero()[i][j].getText())){
                        ventana.getMensaje().setText("Hay caracteres que no son numéricos");
                        seguir=false;
                    }
                    else if(!(Integer.parseInt(ventana.getTablero()[i][j].getText())<=9) || !(Integer.parseInt(ventana.getTablero()[i][j].getText())>=0)){
                        ventana.getMensaje().setText("Los valores deben estar entre 1 y 9");
                        seguir=false;
                    }
                }
            }
            if(seguir)
                ventana.getModelo().calificar();
        }
        else if(e.getSource().equals(ventana.getFacil())){
            ventana.setDificultad("facil");
            ventana.getModelo().dificultad();            
        }
            
        else if(e.getSource().equals(ventana.getMedio())){
            ventana.setDificultad("medio");
            ventana.getModelo().dificultad();            
        }
            
        else if(e.getSource().equals(ventana.getDificil())){
            ventana.setDificultad("dificil");
            ventana.getModelo().dificultad();
        }
        
    }
}
