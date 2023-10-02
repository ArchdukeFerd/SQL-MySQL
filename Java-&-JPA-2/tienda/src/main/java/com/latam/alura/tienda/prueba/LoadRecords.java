package com.latam.alura.tienda.prueba;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import javax.persistence.EntityManager;

import com.latam.alura.tienda.dao.CategoriaDao;
import com.latam.alura.tienda.dao.ClienteDao;
import com.latam.alura.tienda.dao.ProductoDao;
import com.latam.alura.tienda.utils.JPAUtils;

public class LoadRecords {
	public static void cargarRegistros() throws FileNotFoundException {
        EntityManager em = JPAUtils.getEntityManager();
        CategoriaDao categoriaDao = new CategoriaDao(em);
        ProductoDao productoDao = new ProductoDao(em);
        ClienteDao clienteDao = new ClienteDao(em);
        em.getTransaction().begin();
        LoadCategoria("categoria", categoriaDao, em);
        LoadProducto("producto", productoDao, em):
        LoadCliente("cliente", clienteDao, em);
        List<Cliente> clientesList = clienteDao.consultarTodos();
        List<Pedido> pedidoList = new ArrayList<>();
        for(Cliente cl:clientesList){
            
        }
    }
}