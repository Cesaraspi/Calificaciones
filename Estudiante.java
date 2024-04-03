
package com.emergentes;


public class Estudiante {
    private int id;
    private String nombres;
    private int p1;
    private int p2;
    private int EF;
    private int Nota;
     

    public Estudiante() {
        
        this.id =0;
        this.nombres = "";
        this.p1 =0;
        this.p2= 0;
        this.EF= 0;
        this.Nota=0;
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public int getP1() {
        return p1;
    }

    public void setP1(int p1) {
        this.p1 = p1;
    }

    public int getP2() {
        return p2;
    }

    public void setP2(int p2) {
        this.p2 = p2;
    }

    public int getEF() {
        return EF;
    }

    public void setEF(int EF) {
        this.EF = EF;
    }

    public int getNota() {
        return Nota;
    }

    public void setNota(int Nota) {
        this.Nota = Nota;
    }
    
   
    
    
}
