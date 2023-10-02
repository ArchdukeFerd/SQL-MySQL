package com.latam.alura.tienda.prueba;

import java.io.FileNotFoundException;

import javax.persistence.EntityManager;

import com.latam.alura.tienda.modelo.Pedido;
import com.latam.alura.tienda.utils.JPAUtils;

public class PruebaDeDesempeno {
    public static void main(String[] args) throws FileNotFoundException{
        LoadRecords.cargarRegistros();
        EntityManager em = JPAUtils.getEntityManager();
        Pedido pedido = em.fin(Pedido.class, 3l);
        System.out.println(pedido.getFecha());
    }

}