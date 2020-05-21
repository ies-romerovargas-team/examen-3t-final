package com.company;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.InvalidParameterException;
import java.util.*;

public class Biblioteca {
    // Atributos
    private List<Libro> lista;

    //Constructor
    public Biblioteca(){
        lista = new ArrayList<>();
    }

    //Metodos
    public boolean insertaLibro(Libro l){
        for (int i = 0; i < lista.size(); i++) {
            if(l.getIsbn().equals(lista.get(i).getIsbn())) {
                throw new InvalidParameterException(" ISBN Repetido");
            }
        }
        //
        lista.add(l);
        return true;
    }

    public void leeFicheroLibros(String fichero){
        try
        {
            FileInputStream fis = new FileInputStream(fichero);
            DataInputStream dis = new DataInputStream(fis);
            int numLibros = dis.readInt();
            lista.clear();
            String isb, tit, aut;
            int numPag;
            boolean le;
            for (int i = 0; i < numLibros; i++) {
                isb = dis.readUTF();
                tit = dis.readUTF();
                aut = dis.readUTF();
                numPag = dis.readInt();
                le = dis.readBoolean();

                Libro libroLeido = new Libro(isb, tit, aut, numPag, le);
                lista.add(libroLeido);
            }
            dis.close();
            fis.close();
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
    }

    public void ordenaPorPaginasDesc()
    {
        List<Libro> resultado = new LinkedList<>();
        int indice = 0;
        while(lista.size()!=0) {
            int maximo = lista.get(0).getNumeroPaginas();
            for (int i = 0; i < lista.size(); i++) {
                if (lista.get(i).getNumeroPaginas() >= maximo) {
                    maximo = lista.get(i).getNumeroPaginas();
                    indice = i;
                }
            }
            resultado.add(lista.get(indice));
            lista.remove(indice);
        }
        lista.addAll(resultado);
    }

    @Override
    public String toString()
    {
        String ret = "";
        for (int i = 0; i < lista.size() ; i++) {
            ret = ret + lista.get(i).toString() + "\n";
        }
        return ret;
    }
}
