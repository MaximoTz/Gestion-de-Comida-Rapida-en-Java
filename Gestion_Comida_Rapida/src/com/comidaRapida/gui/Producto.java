package com.comidaRapida.gui;

import java.util.concurrent.atomic.AtomicInteger;

public class Producto {
	private static final AtomicInteger contador = new AtomicInteger(2000);

	private int codigoProducto;
	private String nombre;
	private double precio;
	private int stockActual;
	private int stockMinimo;
	private int stockMaximo;

	public Producto(String nombre, double precio, int stockActual, int stockMinimo, int stockMaximo) {
		if (stockMinimo > stockMaximo) {
			System.out.println("El stock m�nimo no puede ser mayor al stock m�ximo.");
			return;
		}

		if (stockActual < stockMinimo || stockActual > stockMaximo) {
			System.out.println("El stock actual debe estar entre el stock m�nimo y el stock m�ximo.");
			return;
		}

		this.codigoProducto = contador.incrementAndGet();
		this.nombre = nombre;
		this.precio = precio;
		this.stockActual = stockActual;
		this.stockMinimo = stockMinimo;
		this.stockMaximo = stockMaximo;
	}

	public int getCodigoProducto() {
		return codigoProducto;
	}

	public void setCodigoProducto(int codigoProducto) {
		this.codigoProducto = codigoProducto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getStockActual() {
		return stockActual;
	}

	public void setStockActual(int stockActual) {
		if (stockActual < stockMinimo || stockActual > stockMaximo) {
			System.out.println("El stock actual debe estar entre " + stockMinimo + " y " + stockMaximo + ".");
			return;
		}
		this.stockActual = stockActual;
	}

	public int getStockMinimo() {
		return stockMinimo;
	}

	public void setStockMinimo(int stockMinimo) {
		if (stockMinimo > stockMaximo) {
			System.out.println("El stock m�nimo no puede ser mayor al stock m�ximo.");
			return;
		}
		this.stockMinimo = stockMinimo;
	}

	public int getStockMaximo() {
		return stockMaximo;
	}

	public void setStockMaximo(int stockMaximo) {
		if (stockMinimo > stockMaximo) {
			System.out.println("El stock m�ximo no puede ser menor al stock m�nimo.");
			return;
		}
		this.stockMaximo = stockMaximo;
	}
}
