/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lógica;

/**
 *
 * @author estudiantes
 */
public class Configuración {
    
    int[][] tablero;
    String dificultad;
    
    public void llenar(){
        int tamaño;
        reiniciar();
        if(dificultad.equals("facil")){
            tamaño=8;
        }
        else if(dificultad.equals("medio")){
            tamaño=6;
        }
        else{
            tamaño=4;
        }
        for(int i=0;i<=tamaño;i++){
            getTablero()[(int) (Math.random() * 9)][(int) (Math.random() * 9)]=i;  
        }
    }
    public boolean calificar(){
        
        boolean [][] contadosFilas = new boolean [9][9];
        boolean [][] contadosColumnas = new boolean [9][9];
        boolean [][] contadosCuadros = new boolean [3][3];
        boolean [] cuadro= new boolean [9];
        boolean comprobacion=true;
        
        /*Revisar que en cada fila del tablero esten todos los números del 1
        al 9*/
        for (int i=0;i<9;i++){
            for (int j=0;j<9;j++){
                if(getTablero()[i][j]>0&&getTablero()[i][j]<=9){
                    contadosFilas[getTablero()[i][j]-1][j]=true;
                }
            }
        }
        
        /*Revisar que en cada columna del tablero esten todos los números del
        1 al 9*/
        for (int i=0;i<9;i++){
            for (int j=0;j<9;j++){
                if(getTablero()[j][i]>0&&getTablero()[j][i]<=9){
                    contadosColumnas[j][getTablero()[j][i]-1]=true;
                }   
            }
        }
        
        /*Revisar que en cada cuadro 3x3 del tablero esten todos los números
        del 1 al 9*/
        
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                contadosCuadros[i][j]=true;
            }
        }
        
        for(int contk=0;contk<3;contk++){
            for(int contl=0;contl<3;contl++){
                for(int k=0+(contk*3);k<3+(contk*3);k++){
                    for(int l=0+(contl*3);l<3+(contl*3);l++){
                        cuadro[getTablero()[k][l]-1]=true;
                    }
                }
                for(int i=0;i<9&&contadosCuadros[contk][contl];i++){
                    if(!cuadro[i]){
                        contadosCuadros[contk][contl]=false;
                    }
                }
            }
        }
        
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(getTablero()[i][j]==0){
                    comprobacion=false;
                }
            }
        }
        
        /*Revisar que se cumplan las 3 condiciones anteriores al tiempo*/
        for(int i=0;i<9&&comprobacion;i++){
            for(int j=0;j<9&&comprobacion;j++){
                if(!contadosFilas[i][j]){
                    comprobacion=false;
                }
                else if(!contadosColumnas[i][j]){
                    comprobacion=false;
                }
                else if(!contadosCuadros[(int)(i/3)][(int)(j/3)]){
                    comprobacion=false;
                }
                else{
                    comprobacion=true;
                }
            }
        }  
        System.out.println(comprobacion);
        return comprobacion;
    }
    public void reiniciar(){
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                getTablero()[i][j]=0;
            }
        }
    }

    public int[][] getTablero() {
        if(tablero==null){
            tablero=new int[9][9];
        }
        return tablero;
    }

    public void setTablero(int[][] tablero) {
        this.tablero = tablero;
    }

    public String getDificultad() {
        return dificultad;
    }

    public void setDificultad(String dificultad) {
        this.dificultad = dificultad;
    }
    
    
}
