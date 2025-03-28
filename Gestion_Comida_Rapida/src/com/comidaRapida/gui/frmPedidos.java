package com.comidaRapida.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class frmPedidos extends JFrame {

	private JPanel contentPane;
	private JTextField tbxCantidad;
	private JTextField tbxPrecioUnitario;
	private JTextField tbxSubTotal;
	private JTextField tbxIGV;
	private JTextField tbxTotalPagar;
	DefaultTableModel modeloTabla;
	private ArrayList<Venta> listaVentas = new ArrayList<>();
	private JComboBox cbxCliente;
	private JComboBox cbxProducto;
	private JTable tblPedidos;
	private JButton btnGuardar;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmPedidos frame = new frmPedidos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public frmPedidos() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1039, 557);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 222, 173));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("-- Registrar Pedido --");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_1.setBounds(40, 33, 338, 42);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblCliente = new JLabel("Cliente:");
		lblCliente.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCliente.setBounds(55, 132, 56, 14);
		contentPane.add(lblCliente);
		
		JLabel lblNewLabel_1_1 = new JLabel("Producto:");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1.setBounds(55, 181, 56, 14);
		contentPane.add(lblNewLabel_1_1);
		
		tbxCantidad = new JTextField();
		tbxCantidad.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				calcularVenta();
			}
		});
		tbxCantidad.setColumns(10);
		tbxCantidad.setBounds(131, 226, 166, 20);
		contentPane.add(tbxCantidad);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Cantidad:");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_1.setBounds(22, 229, 89, 14);
		contentPane.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Precio Unitario:");
		lblNewLabel_1_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_1_1.setBounds(22, 276, 89, 14);
		contentPane.add(lblNewLabel_1_1_1_1);
		
		tbxPrecioUnitario = new JTextField();
		tbxPrecioUnitario.setEnabled(false);
		tbxPrecioUnitario.setColumns(10);
		tbxPrecioUnitario.setBounds(131, 273, 166, 20);
		contentPane.add(tbxPrecioUnitario);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscarPedido();
			}
		});
		btnBuscar.setBackground(new Color(175, 238, 238));
		btnBuscar.setBounds(908, 342, 89, 53);
		contentPane.add(btnBuscar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eliminarPedido();
			}
		});
		btnEliminar.setBackground(new Color(250, 128, 114));
		btnEliminar.setBounds(908, 267, 89, 53);
		contentPane.add(btnEliminar);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editarPedido();
			}
		});
		btnEditar.setBackground(new Color(255, 215, 0));
		btnEditar.setBounds(908, 192, 89, 53);
		contentPane.add(btnEditar);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				agregarPedido();
			}
		});
		btnAgregar.setBackground(new Color(144, 238, 144));
		btnAgregar.setBounds(908, 118, 89, 53);
		contentPane.add(btnAgregar);
		
		JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("SubTotal:");
		lblNewLabel_1_1_1_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_1_1_1_1.setBounds(22, 323, 89, 14);
		contentPane.add(lblNewLabel_1_1_1_1_1_1);
		
		tbxSubTotal = new JTextField();
		tbxSubTotal.setEnabled(false);
		tbxSubTotal.setColumns(10);
		tbxSubTotal.setBounds(131, 320, 166, 20);
		contentPane.add(tbxSubTotal);
		
		JLabel lblNewLabel_1_1_1_1_1_1_1 = new JLabel("IGV(18%):");
		lblNewLabel_1_1_1_1_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_1_1_1_1_1.setBounds(22, 373, 89, 14);
		contentPane.add(lblNewLabel_1_1_1_1_1_1_1);
		
		tbxIGV = new JTextField();
		tbxIGV.setEnabled(false);
		tbxIGV.setColumns(10);
		tbxIGV.setBounds(131, 370, 166, 20);
		contentPane.add(tbxIGV);
		
		JLabel lblNewLabel_1_1_1_1_1_1_1_1 = new JLabel("Total a Pagar:");
		lblNewLabel_1_1_1_1_1_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_1_1_1_1_1_1.setBounds(22, 424, 89, 14);
		contentPane.add(lblNewLabel_1_1_1_1_1_1_1_1);
		
		tbxTotalPagar = new JTextField();
		tbxTotalPagar.setEnabled(false);
		tbxTotalPagar.setColumns(10);
		tbxTotalPagar.setBounds(131, 421, 166, 20);
		contentPane.add(tbxTotalPagar);
		
		cbxCliente = new JComboBox();
		cbxCliente.setBounds(130, 128, 166, 22);
		contentPane.add(cbxCliente);
		
		cargarClientesEnComboBox();
		
		cbxProducto = new JComboBox();
		cbxProducto.setBounds(130, 177, 166, 22);
		contentPane.add(cbxProducto);
		
		cargarProductosEnComboBox();
		cbxProducto.addActionListener(e -> {
			cargarPreciosDeProductos();
			calcularVenta();
		});
		
		JButton btnListar = new JButton("Listar");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarDesdeArchivo();
			}
		});
		btnListar.setBackground(new Color(72, 209, 204));
		btnListar.setBounds(908, 413, 89, 53);
		contentPane.add(btnListar);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardarCambiosEnPedido();
			}
		});
		btnGuardar.setForeground(new Color(255, 255, 255));
		btnGuardar.setBackground(new Color(147, 112, 219));
		btnGuardar.setBounds(751, 68, 140, 29);
		contentPane.add(btnGuardar);
		
		btnGuardar.setVisible(false);
		btnGuardar.setEnabled(false);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(318, 108, 573, 369);
		contentPane.add(scrollPane);
		
		modeloTabla = new DefaultTableModel(new Object[][] {}, new String[] {
				"ID", "Cliente", "Producto", "Cantidad", "Precio", "SubTotal", "IGV", "Total"
			});
		tblPedidos = new JTable(modeloTabla);
		tblPedidos.setFont(new Font("Tahoma", Font.PLAIN, 11));
		tblPedidos.setRowHeight(30);
		scrollPane.setViewportView(tblPedidos);
		
	}// FIN DEL CONSTRUCTOR
	
	//AGREGAR PEDIDO
	private void agregarPedido() {
		try {
	        String cliente = (String) cbxCliente.getSelectedItem();
	        String producto = (String) cbxProducto.getSelectedItem();
	        String cantidadStr = tbxCantidad.getText().trim();
	        String precioStr = tbxPrecioUnitario.getText().trim();

	        if (cliente == null || producto == null || cantidadStr.isEmpty() || precioStr.isEmpty()) {
	            JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios.");
	            return;
	        }

	        int cantidad;
	        double precio;
	        try {
	            cantidad = Integer.parseInt(cantidadStr);
	            precio = Double.parseDouble(precioStr);
	            if (cantidad <= 0 || precio <= 0) {
	                JOptionPane.showMessageDialog(this, "La cantidad y el precio deben ser valores positivos.");
	                return;
	            }
	        } catch (NumberFormatException e) {
	            JOptionPane.showMessageDialog(this, "Ingrese valores num�ricos v�lidos en cantidad y precio.");
	            return;
	        }

	        Venta venta = new Venta(cliente, producto, cantidad, precio);
	        listaVentas.add(venta);

	        tbxSubTotal.setText(String.format("%.2f", venta.getSubTotal()));
	        tbxIGV.setText(String.format("%.2f", venta.getIgv()));
	        tbxTotalPagar.setText(String.format("%.2f", venta.getTotal()));

	        modeloTabla.addRow(new Object[]{
	            venta.getCodigoVenta(), venta.getCliente(), venta.getProducto(),
	            venta.getCantidad(), venta.getPrecioUnitario(),
	            venta.getSubTotal(), venta.getIgv(), venta.getTotal()
	        });

	        JOptionPane.showMessageDialog(this, "Venta agregada correctamente.");
	        guardarEnArchivo(); 
	        limpiarCampos();

	    } catch (Exception e) {
	        JOptionPane.showMessageDialog(this, "Error al agregar la venta: " + e.getMessage());
	    }
	}
	
	//EDITAR PEDIDO
	private void editarPedido() {
		int filaSeleccionada = tblPedidos.getSelectedRow();
	    if (filaSeleccionada >= 0) {
	        Venta venta = listaVentas.get(filaSeleccionada);

	        cbxCliente.setSelectedItem(venta.getCliente());
	        cbxProducto.setSelectedItem(venta.getProducto());
	        tbxCantidad.setText(String.valueOf(venta.getCantidad()));
	        tbxPrecioUnitario.setText(String.valueOf(venta.getPrecioUnitario()));

	        btnGuardar.setEnabled(true);
	        btnGuardar.setVisible(true);
	    } else {
	        JOptionPane.showMessageDialog(this, "Selecciona una fila para editar.");
	    }
		
	}
	
	// GUARDAR CAMBIOS
	private void guardarCambiosEnPedido() {
		int filaSeleccionada = tblPedidos.getSelectedRow();
	    if (filaSeleccionada >= 0) {
	        try {
	            Venta venta = listaVentas.get(filaSeleccionada);

	            String nuevoCliente = (String) cbxCliente.getSelectedItem();
	            String nuevoProducto = (String) cbxProducto.getSelectedItem();
	            int nuevaCantidad = Integer.parseInt(tbxCantidad.getText());
	            double nuevoPrecio = Double.parseDouble(tbxPrecioUnitario.getText());

	            if (nuevaCantidad <= 0 || nuevoPrecio <= 0) {
	                JOptionPane.showMessageDialog(this, "La cantidad y el precio deben ser valores positivos.");
	                return;
	            }

	            venta.setCliente(nuevoCliente);
	            venta.setProducto(nuevoProducto);
	            venta.setCantidad(nuevaCantidad);
	            venta.setPrecioUnitario(nuevoPrecio);

	            modeloTabla.setValueAt(nuevoCliente, filaSeleccionada, 1);
	            modeloTabla.setValueAt(nuevoProducto, filaSeleccionada, 2);
	            modeloTabla.setValueAt(nuevaCantidad, filaSeleccionada, 3);
	            modeloTabla.setValueAt(nuevoPrecio, filaSeleccionada, 4);
	            modeloTabla.setValueAt(venta.getSubTotal(), filaSeleccionada, 5);
	            modeloTabla.setValueAt(venta.getIgv(), filaSeleccionada, 6);
	            modeloTabla.setValueAt(venta.getTotal(), filaSeleccionada, 7);

	            JOptionPane.showMessageDialog(this, "Pedido actualizado correctamente.");

	            btnGuardar.setEnabled(false);
	            btnGuardar.setVisible(false);
	            guardarEnArchivo();
	            limpiarCampos();

	        } catch (NumberFormatException e) {
	            JOptionPane.showMessageDialog(this, "Ingrese valores num�ricos v�lidos en cantidad y precio.");
	        } catch (Exception e) {
	            JOptionPane.showMessageDialog(this, "Error al guardar los cambios: " + e.getMessage());
	        }
	    } else {
	        JOptionPane.showMessageDialog(this, "No hay ninguna fila seleccionada.");
	    }
	}
	
	// ELIMINAR PEDIDO
	private void eliminarPedido() {
		int fila = tblPedidos.getSelectedRow();
	    if (fila == -1) {
	        JOptionPane.showMessageDialog(this, "Seleccione un pedido para eliminar.");
	        return;
	    }

	    int confirm = JOptionPane.showConfirmDialog(this, "�Est� seguro de eliminar este pedido?", "Confirmaci�n", JOptionPane.YES_NO_OPTION);
	    if (confirm == JOptionPane.YES_OPTION) {
	        listaVentas.remove(fila);
	        modeloTabla.removeRow(fila);
	        guardarEnArchivo(); 
	        JOptionPane.showMessageDialog(this, "Pedido eliminado correctamente.");
	    }
	}
	
	//BUSCAR PEDIDO
	private void buscarPedido() {
	    String input = JOptionPane.showInputDialog(this, "Ingrese el ID del pedido a buscar:");
	    if (input != null && !input.trim().isEmpty()) {
	        try {
	            int idBuscado = Integer.parseInt(input.trim());

	            for (int i = 0; i < modeloTabla.getRowCount(); i++) {
	                int idPedido = Integer.parseInt(modeloTabla.getValueAt(i, 0).toString());
	                if (idPedido == idBuscado) {
	                    tblPedidos.setRowSelectionInterval(i, i);

	                    cbxCliente.setSelectedItem(modeloTabla.getValueAt(i, 1).toString());
	                    cbxProducto.setSelectedItem(modeloTabla.getValueAt(i, 2).toString());
	                    tbxCantidad.setText(modeloTabla.getValueAt(i, 3).toString());
	                    tbxPrecioUnitario.setText(modeloTabla.getValueAt(i, 4).toString());
	                    tbxSubTotal.setText(modeloTabla.getValueAt(i, 5).toString());
	                    tbxIGV.setText(modeloTabla.getValueAt(i, 6).toString());
	                    tbxTotalPagar.setText(modeloTabla.getValueAt(i, 7).toString());

	                    btnGuardar.setEnabled(true);

	                    JOptionPane.showMessageDialog(this, "Pedido encontrado.");
	                    return;
	                }
	            }
	            JOptionPane.showMessageDialog(this, "No se encontr� un pedido con ese ID.");
	        } catch (NumberFormatException e) {
	            JOptionPane.showMessageDialog(this, "Ingrese un n�mero v�lido para el ID.");
	        }
	    } else {
	        JOptionPane.showMessageDialog(this, "Ingrese un ID para buscar.");
	    }
	}
	
	// LIMPIAR CAMPOS
	private void limpiarCampos() {
		cbxCliente.setSelectedIndex(-1);
	    cbxProducto.setSelectedIndex(-1);
	    tbxCantidad.setText("");
	    tbxPrecioUnitario.setText("");
	    tbxSubTotal.setText("");
	    tbxIGV.setText("");
	    tbxTotalPagar.setText("");
	}
	
	
	// CARGAR DATOS EN COMBOBOX CLIENTES
	private void cargarClientesEnComboBox() {
		File archivo = new File("clientes.txt");

		if (!archivo.exists()) {
			JOptionPane.showMessageDialog(this, "No hay clientes registrados", "Informaci�n",
					JOptionPane.INFORMATION_MESSAGE);
			return;
		}

		cbxCliente.removeAllItems();

		try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
			String linea;
			while ((linea = reader.readLine()) != null) {
				String[] datos = linea.split(",");

				if (datos.length >= 2) {
					String nombreCompleto = datos[1] + " " + datos[2];
					cbxCliente.addItem(nombreCompleto);
				}
			}
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(this, "Error al cargar clientes: " + ex.getMessage(), "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}
	
	// CARGAR DATOS EN COMBOBOX PRODUCTOS
	private void cargarProductosEnComboBox() {
		File archivo = new File("productos.txt");

		if (!archivo.exists()) {
			JOptionPane.showMessageDialog(this, "No hay productos registrados", "Informaci�n",
					JOptionPane.INFORMATION_MESSAGE);
			return;
		}

		cbxProducto.removeAllItems();

		try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
			String linea;
			while ((linea = reader.readLine()) != null) {
				String[] datos = linea.split(",");

				if (datos.length >= 2) {
					String nombreProducto = datos[1];
					cbxProducto.addItem(nombreProducto);
				}
			}
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(this, "Error al cargar productos: " + ex.getMessage(), "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}
	
	// CARGAR EL PRECIO DE LOS PRODUCTOS
	private void cargarPreciosDeProductos() {
		String productoSeleccionado = (String) cbxProducto.getSelectedItem();
		
		if(productoSeleccionado == null) {
			return;
		}
		
		File archivo = new File("productos.txt");
		
		try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
			String linea;
			while ((linea = reader.readLine()) != null) {
				String[] datos = linea.split(",");

				if (datos.length >= 3) {
					String nombreProducto = datos[1];
					String precio = datos[2];

					if (nombreProducto.equals(productoSeleccionado)) {
						tbxPrecioUnitario.setText(precio);
						break;
					}
				}
			}
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(this, "Error al obtener precio: " + ex.getMessage(), "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}
	
	// CALCULAR VENTA
	private void calcularVenta() {
		try {
	        double precioUnitario = Double.parseDouble(tbxPrecioUnitario.getText());
	        int cantidad = Integer.parseInt(tbxCantidad.getText());

	        double subtotal = precioUnitario * cantidad;
	        double igv = subtotal * 0.18;
	        double total = subtotal + igv;

	        tbxSubTotal.setText(String.format("%.2f", subtotal));
	        tbxIGV.setText(String.format("%.2f", igv));
	        tbxTotalPagar.setText(String.format("%.2f", total));

	    } catch (NumberFormatException ex) {
	        tbxSubTotal.setText("");
	        tbxIGV.setText("");
	        tbxTotalPagar.setText("");
	    }
	}
	
	private void guardarEnArchivo() {
	    File archivo = new File("pedidos.txt");
	    try (PrintWriter pw = new PrintWriter(new FileWriter(archivo))) {
	        for (int i = 0; i < tblPedidos.getRowCount(); i++) {
	            String codigoVenta = tblPedidos.getValueAt(i, 0).toString();
	            String cliente = tblPedidos.getValueAt(i, 1).toString();
	            String producto = tblPedidos.getValueAt(i, 2).toString();
	            String cantidad = tblPedidos.getValueAt(i, 3).toString();
	            String precioUnitario = tblPedidos.getValueAt(i, 4).toString();
	            String subTotal = tblPedidos.getValueAt(i, 5).toString();
	            String igv = tblPedidos.getValueAt(i, 6).toString();
	            String total = tblPedidos.getValueAt(i, 7).toString();

	            pw.println(codigoVenta + "," + cliente + "," + producto + "," + cantidad + "," + precioUnitario + "," + subTotal + "," + igv + "," + total);
	        }
	        pw.flush();
	        JOptionPane.showMessageDialog(this, "Pedido guardado exitosamente.", "Informaci�n",
	                JOptionPane.INFORMATION_MESSAGE);
	    } catch (Exception ex) {
	        JOptionPane.showMessageDialog(this, "Error al guardar en el archivo.", "Error", JOptionPane.ERROR_MESSAGE);
	    }
	}

	private void cargarDesdeArchivo() {
	    if (modeloTabla != null) {
	        modeloTabla.setRowCount(0);
	    }
	    listaVentas.clear();

	    File archivo = new File("pedidos.txt");
	    if (archivo.exists()) {
	        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
	            String linea;
	            boolean archivoVacio = true;
	            while ((linea = br.readLine()) != null) {
	                archivoVacio = false;
	                String[] datos = linea.split(",");
	                if (datos.length == 8) {
	                    try {
	                        int codigoVenta = Integer.parseInt(datos[0]);
	                        String cliente = datos[1];
	                        String producto = datos[2];
	                        int cantidad = Integer.parseInt(datos[3]);
	                        double precio = Double.parseDouble(datos[4]);
	                        double subTotal = Double.parseDouble(datos[5]);
	                        double igv = Double.parseDouble(datos[6]);
	                        double total = Double.parseDouble(datos[7]);

	                        Venta venta = new Venta(cliente, producto, cantidad, precio);
	                        venta.setCodigoVenta(codigoVenta);
	                        listaVentas.add(venta);

	                        Object[] fila = { codigoVenta, cliente, producto, cantidad, precio, subTotal, igv, total };
	                        modeloTabla.addRow(fila);
	                    } catch (NumberFormatException e) {
	                        JOptionPane.showMessageDialog(this, "Error en formato de datos en el archivo.", "Error", JOptionPane.ERROR_MESSAGE);
	                    }
	                }
	            }
	            if (archivoVacio) {
	                JOptionPane.showMessageDialog(this, "El archivo de pedidos est� vac�o.", "Informaci�n", JOptionPane.INFORMATION_MESSAGE);
	            }
	        } catch (Exception e) {
	            JOptionPane.showMessageDialog(this, "Error al cargar los datos del archivo.", "Error",
	                    JOptionPane.ERROR_MESSAGE);
	        }
	    } else {
	        JOptionPane.showMessageDialog(this, "El archivo de pedidos no existe.", "Informaci�n", JOptionPane.INFORMATION_MESSAGE);
	    }
	}
}
