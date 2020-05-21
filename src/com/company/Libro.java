package com.company;

import java.security.InvalidParameterException;

public class Libro {
    // Atributos
    private String isbn;
    private String titulo;
    private String autor;
    private int numeroPaginas;
    private boolean leido;

    // Constructor
    public Libro(String isb, String tit, String aut, int numPag, Boolean lei){
        if(compruebaIsbn(isb)){
            isbn = isb;
            titulo = tit;
            autor = aut;
            numeroPaginas = numPag;
            leido = lei;
        } else throw new InvalidParameterException("Isbn Incorrecto");
    }

    private boolean compruebaIsbn(String isb) {
        //978-84-9032-147-8
        boolean ret = true;
        if(isb.length()==17) {
            String[] partes = isb.split("-");
            if(partes[0].length()!=3 ||
                    partes[1].length()!=2 ||
                    partes[2].length()!=4 ||
                    partes[3].length()!=3 ||
                    partes[4].length()!=1)
            {
                return false;
            }
            isb = isb.replace("-","");
            for (int i = 0; i < isb.length(); i++) {
                if (!Character.isDigit(isb.charAt(i)))
                {
                    return false;
                }
            }
        } else {
            ret = false;
        }
        return ret;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public String getAutor() {
        return autor;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setLeido(boolean leido) {
        this.leido = leido;
    }

    public String toString(){
        return "'" + titulo + "' de " + autor;
    }
}
