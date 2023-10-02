package com.latam.alura.tienda.dao;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;

import com.latam.alura.tienda.modelo.Categoria;
import com.latam.alura.tienda.modelo.Producto;

public class ProductoDao {
	
	private EntityManager em;

	public ProductoDao(EntityManager em) {
		this.em = em;
	}
	
	public void guardar(Producto producto) {
		this.em.persist(producto);
	}
	
	
	public void actualizar(Producto producto) {
		this.em.merge(producto);
	}
	
	public void remover(Producto producto) {
		producto=this.em.merge(producto);
		this.em.remove(producto);
	}
	
	public Producto consultaPorId(Long id) {
		return em.find(Producto.class, id);
	}
	
	public List<Producto> consultarTodos(){
		String jqpl = "SELECT P FROM Producto AS P";
		return em.createQuery(jqpl,Producto.class).getResultList();
	}
	
	public List<Producto> consultaPorNombre(String nombre){
		String jpql ="SELECT P FROM Producto AS P WHERE P.nombre=:nombre";
		return em.createQuery(jpql,Producto.class).setParameter("nombre", nombre).getResultList();
	}
	
	public List<Producto> consultaPorNombreDeCategoria(String nombre){
		String jpql="SELECT p FROM Producto AS p WHERE p.categoria.nombre=:nombre";
		return em.createQuery(jpql,Producto.class).setParameter("nombre", nombre).getResultList();
	}

	public List<Producto> consultaPorParametros(String nombre, BigDecimal precio, LocalDate fecha){
		StringBuilder jpql = new StringBuilder("SELECT p FROM Producto p WHERE 1=1");
		if (nombre!=null && !nombre.trim().isEmpty()){
			jpql.append("AND p.nombre=:nombre");
		}	
		if (nombre!=null && !nombre.trim().isEmpty()){
			jpql.append("AND p.nombre=:nombre");
		}
		if (nombre!=null && !nombre.trim().isEmpty()){
			jpql.append("AND p.nombre=:nombre");
		}		
	}
	 
	public BigDecimal consultarPrecioPorNombreDeProducto(String nombre) {
		return em.createNamedQuery("Producto.consultaDePrecio", BigDecimal.class).setParameter("nombre", nombre).getSingleResult();
	}
}