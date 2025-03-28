package com.comidaRapida.gui;

import java.util.concurrent.atomic.AtomicInteger;

public class Venta {

	private static final AtomicInteger contador = new AtomicInteger(3000);

	private int codigoVenta;
	private String cliente;
	private String producto;
	private int cantidad;
	private double precioUnitario;
	private double subTotal;
    private double igv;
    private double total;
	
	public Venta(String cliente, String producto, int cantidad, double precioUnitario) {
		super();
		this.codigoVenta = contador.incrementAndGet();
		this.cliente = cliente;
		this.producto = producto;
		this.cantidad = cantidad;
		this.precioUnitario = precioUnitario;
		calcularTotales();
	}
	
	private void calcularTotales() {
        this.subTotal = this.cantidad * this.precioUnitario;
        this.igv = this.subTotal * 0.18;
        this.total = this.subTotal + this.igv;
    }

	public int getCodigoVenta() {
		return codigoVenta;
	}

	public void setCodigoVenta(int codigoVenta) {
		this.codigoVenta = codigoVenta;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public String getProducto() {
		return producto;
	}

	public void setProducto(String producto) {
		this.producto = producto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(double precioUnitario) {
		this.precioUnitario = precioUnitario;
		calcularTotales();
	}
	
	public double getSubTotal() {
        return subTotal;
    }

    public double getIgv() {
        return igv;
    }

    public double getTotal() {
        return total;
    }
	

}
