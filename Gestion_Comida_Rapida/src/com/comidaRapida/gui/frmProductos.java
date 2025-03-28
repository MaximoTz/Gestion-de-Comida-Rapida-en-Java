package com.comidaRapida.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;

public class frmProductos extends JFrame {

	private JPanel contentPane;

	private JTextField tbxNombre;

	private JTextField tbxPrecio;

	private JTextField tbxStockActual;

	private JTextField tbxStockMin;

	private JTextField tbxStockMax;

	private JTable tblProductos;

	private DefaultTableModel modeloTabla;

	private JScrollPane scrollPane;

	private List<Producto> listaProductos = new ArrayList<>();
	private JScrollPane scrollPane_1;
	private JButton btnGuardar;

	private Producto productoEditar = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmProductos frame = new frmProductos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public frmProductos() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1033, 492);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 222, 173));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("-- Registrar Productos --");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_1.setBounds(27, 31, 392, 42);
		contentPane.add(lblNewLabel_1);

		JLabel lblNombres = new JLabel("Nombres:");
		lblNombres.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombres.setBounds(43, 115, 56, 14);
		contentPane.add(lblNombres);

		tbxNombre = new JTextField();
		tbxNombre.setColumns(10);
		tbxNombre.setBounds(119, 112, 173, 20);
		contentPane.add(tbxNombre);

		JLabel lblNewLabel_1_1 = new JLabel("Precio:");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1.setBounds(43, 159, 56, 14);
		contentPane.add(lblNewLabel_1_1);

		tbxPrecio = new JTextField();
		tbxPrecio.setColumns(10);
		tbxPrecio.setBounds(119, 156, 173, 20);
		contentPane.add(tbxPrecio);

		JLabel lblNewLabel_1_1_1 = new JLabel("Stock Actual:");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_1.setBounds(10, 202, 89, 14);
		contentPane.add(lblNewLabel_1_1_1);

		tbxStockActual = new JTextField();
		tbxStockActual.setColumns(10);
		tbxStockActual.setBounds(119, 199, 173, 20);
		contentPane.add(tbxStockActual);

		JLabel lblNewLabel_1_1_1_1 = new JLabel("Stock Min:");
		lblNewLabel_1_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_1_1.setBounds(10, 249, 89, 14);
		contentPane.add(lblNewLabel_1_1_1_1);

		tbxStockMin = new JTextField();
		tbxStockMin.setColumns(10);
		tbxStockMin.setBounds(119, 246, 173, 20);
		contentPane.add(tbxStockMin);

		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Stock Max:");
		lblNewLabel_1_1_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_1_1_1.setBounds(10, 297, 89, 14);
		contentPane.add(lblNewLabel_1_1_1_1_1);

		tbxStockMax = new JTextField();
		tbxStockMax.setColumns(10);
		tbxStockMax.setBounds(119, 294, 173, 20);
		contentPane.add(tbxStockMax);

		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(312, 96, 564, 285);
		contentPane.add(scrollPane_1);

		modeloTabla = new DefaultTableModel(new Object[][] {},
				new String[] { "ID", "Nombre", "Precio", "Stock Actual", "Stock Min.", "Stock Max." });

		tblProductos = new JTable(modeloTabla);
		tblProductos.setRowHeight(30);
		scrollPane_1.setViewportView(tblProductos);

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBackground(new Color(175, 238, 238));
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// BUSCAR PRODUCTO
				String id = JOptionPane.showInputDialog(frmProductos.this, "Ingrese el ID del producto a buscar:");

				if (id == null || id.trim().isEmpty()) {
					JOptionPane.showMessageDialog(frmProductos.this, "Debe ingresar un ID v�lido.", "Error",
							JOptionPane.ERROR_MESSAGE);
					return;
				}

				try {
					int idBuscado = Integer.parseInt(id.trim());

					boolean encontrado = false;

					for (Producto producto : listaProductos) {
						if (producto.getCodigoProducto() == idBuscado) {
							tbxNombre.setText(producto.getNombre());
							tbxPrecio.setText(String.valueOf(producto.getPrecio()));
							tbxStockActual.setText(String.valueOf(producto.getStockActual()));
							tbxStockMin.setText(String.valueOf(producto.getStockMinimo()));
							tbxStockMax.setText(String.valueOf(producto.getStockMaximo()));
							encontrado = true;
							break;
						}
					}

					if (!encontrado) {
						JOptionPane.showMessageDialog(frmProductos.this, "No se encontr� un producto con ese ID.",
								"No encontrado", JOptionPane.INFORMATION_MESSAGE);
					}
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(frmProductos.this, "El ID debe ser un n�mero entero.", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnBuscar.setBounds(900, 312, 90, 50);
		contentPane.add(btnBuscar);

		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBackground(new Color(250, 128, 114));
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// ELIMINAR PRODUCTO
				eliminarProductos();
			}
		});
		btnEliminar.setBounds(900, 243, 90, 50);
		contentPane.add(btnEliminar);

		JButton btnEditar = new JButton("Editar");
		btnEditar.setBackground(new Color(255, 215, 0));
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// EDITAR PRODUCTO
				editarProducto();

			}
		});
		btnEditar.setBounds(900, 182, 90, 50);
		contentPane.add(btnEditar);

		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.setBackground(new Color(144, 238, 144));
		btnAgregar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// AGREGAR PRODUCTO
				agregarProducto();
			}
		});
		btnAgregar.setBounds(900, 115, 90, 56);
		contentPane.add(btnAgregar);

		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setForeground(new Color(255, 255, 255));
		btnLimpiar.setBackground(new Color(160, 82, 45));
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarCampos();
			}
		});
		btnLimpiar.setBounds(172, 326, 118, 36);
		contentPane.add(btnLimpiar);

		btnGuardar = new JButton("Guardar");
		btnGuardar.setBackground(new Color(147, 112, 219));
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// BOTON GUARDAR
				guardarCambiosProducto();
			}
		});
		btnGuardar.setBounds(657, 392, 118, 36);
		btnGuardar.setVisible(false);
		btnGuardar.setEnabled(false);
		contentPane.add(btnGuardar);

		JButton btnListar = new JButton("Listar");
		btnListar.setForeground(new Color(0, 0, 0));
		btnListar.setBackground(new Color(64, 224, 208));
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// BOTON LISTAR
				cargarDesdeArchivo();
			}
		});
		btnListar.setBounds(448, 392, 118, 36);
		contentPane.add(btnListar);
	}

	// AGREGAR PRODUCTO
	private void agregarProducto() {
		try {
			String nombre = tbxNombre.getText().trim();
			if (nombre.isEmpty()) {
				JOptionPane.showMessageDialog(frmProductos.this, "El nombre no puede estar vac�o.", "Error",
						JOptionPane.ERROR_MESSAGE);
				return;
			}

			double precio = Double.parseDouble(tbxPrecio.getText().trim());
			int stockActual = Integer.parseInt(tbxStockActual.getText().trim());
			int stockMin = Integer.parseInt(tbxStockMin.getText().trim());
			int stockMax = Integer.parseInt(tbxStockMax.getText().trim());

			if (precio < 0 || stockActual < 0 || stockMin < 0 || stockMax < 0) {
				JOptionPane.showMessageDialog(frmProductos.this, "Los valores num�ricos deben ser positivos.", "Error",
						JOptionPane.ERROR_MESSAGE);
				return;
			}
			if (stockMin > stockMax) {
				JOptionPane.showMessageDialog(frmProductos.this,
						"El stock m�nimo no puede ser mayor que el stock m�ximo.", "Error", JOptionPane.ERROR_MESSAGE);
				return;
			}

			int nuevoID = listaProductos.size() + 1;

			Producto producto = new Producto(nombre, precio, stockActual, stockMin, stockMax);
			listaProductos.add(producto);

			modeloTabla.addRow(new Object[] { producto.getCodigoProducto(), producto.getNombre(), producto.getPrecio(),
					producto.getStockActual(), producto.getStockMinimo(), producto.getStockMaximo() });
			
			guardarEnArchivo();
			limpiarCampos();
			
			JOptionPane.showMessageDialog(frmProductos.this, "Producto agregado correctamente", "�xito",
					JOptionPane.INFORMATION_MESSAGE);
		} catch (NumberFormatException ex) {
			JOptionPane.showMessageDialog(frmProductos.this,
					"Ingrese valores num�ricos v�lidos en los campos correspondientes.", "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}
	
	// EDITAR PRODUCTO
	private void editarProducto() {
		int filaSeleccionada = tblProductos.getSelectedRow();
		if (filaSeleccionada == -1) {
			JOptionPane.showMessageDialog(frmProductos.this, "Seleccione un producto para editar.",
					"Advertencia", JOptionPane.WARNING_MESSAGE);
			return;
		}

		int idProducto = (int) modeloTabla.getValueAt(filaSeleccionada, 0);

		for (Producto p : listaProductos) {
			if (p.getCodigoProducto() == idProducto) {
				productoEditar = p;
				tbxNombre.setText(p.getNombre());
				tbxPrecio.setText(String.valueOf(p.getPrecio()));
				tbxStockActual.setText(String.valueOf(p.getStockActual()));
				tbxStockMin.setText(String.valueOf(p.getStockMinimo()));
				tbxStockMax.setText(String.valueOf(p.getStockMaximo()));

				btnGuardar.setEnabled(true);
				btnGuardar.setVisible(true);
				return;
			}
		}
	}
	
	// GUARDAR CAMBIOS
	private void guardarCambiosProducto() {
		if (productoEditar == null) {
			JOptionPane.showMessageDialog(frmProductos.this,
					"Seleccione un producto y edite los datos antes de guardar.", "Advertencia",
					JOptionPane.WARNING_MESSAGE);
			return;
		}

		productoEditar.setNombre(tbxNombre.getText());
		productoEditar.setPrecio(Double.parseDouble(tbxPrecio.getText()));
		productoEditar.setStockActual(Integer.parseInt(tbxStockActual.getText()));
		productoEditar.setStockMinimo(Integer.parseInt(tbxStockMin.getText()));
		productoEditar.setStockMaximo(Integer.parseInt(tbxStockMax.getText()));

		int filaSeleccionada = tblProductos.getSelectedRow();
		modeloTabla.setValueAt(productoEditar.getNombre(), filaSeleccionada, 1);
		modeloTabla.setValueAt(productoEditar.getPrecio(), filaSeleccionada, 2);
		modeloTabla.setValueAt(productoEditar.getStockActual(), filaSeleccionada, 3);
		modeloTabla.setValueAt(productoEditar.getStockMinimo(), filaSeleccionada, 4);
		modeloTabla.setValueAt(productoEditar.getStockMaximo(), filaSeleccionada, 5);

		btnGuardar.setVisible(false);
		btnGuardar.setEnabled(false);

		JOptionPane.showMessageDialog(frmProductos.this, "Producto actualizado correctamente.", "�xito",
				JOptionPane.INFORMATION_MESSAGE);
		guardarEnArchivo();
		limpiarCampos();
		productoEditar = null;
		
	}
	
	// ELIMINAR PRODUCTOS
	private void eliminarProductos() {
		String id = JOptionPane.showInputDialog(frmProductos.this, "Ingrese el ID del producto a eliminar:");

		if (id == null || id.trim().isEmpty()) {
			JOptionPane.showMessageDialog(frmProductos.this, "Debe ingresar un ID v�lido", "Error",
					JOptionPane.ERROR_MESSAGE);
			return;
		}

		try {
			int idEliminar = Integer.parseInt(id.trim());

			boolean encontrado = false;

			for (int i = 0; i < listaProductos.size(); i++) {
				if (listaProductos.get(i).getCodigoProducto() == idEliminar) {
					listaProductos.remove(i);
					modeloTabla.removeRow(i);
					JOptionPane.showMessageDialog(frmProductos.this, "Producto eliminado correctamente",
							"�xito", JOptionPane.INFORMATION_MESSAGE);
					encontrado = true;
					break;
				}
			}
			guardarEnArchivo();
			if (!encontrado) {
				JOptionPane.showMessageDialog(frmProductos.this, "No se encontr� un producto con ese ID",
						"No encontrado", JOptionPane.INFORMATION_MESSAGE);
			}
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(frmProductos.this, "El ID debe ser un n�mero entero.", "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	// LIMPIAR CAMPOS
	private void limpiarCampos() {
		tbxNombre.setText("");
		tbxPrecio.setText("");
		tbxStockActual.setText("");
		tbxStockMin.setText("");
		tbxStockMax.setText("");
	}
	
	// GUARDAR EN ARCHIVO Productos.txt
	private void guardarEnArchivo() {
		File archivo = new File("productos.txt");
		try (PrintWriter pw = new PrintWriter(new FileWriter(archivo))) {
			for (int i = 0; i < tblProductos.getRowCount(); i++) {
				int codigoCliente = Integer.parseInt(tblProductos.getValueAt(i, 0).toString());
				String nombres = tblProductos.getValueAt(i, 1).toString();
				String apellidos = tblProductos.getValueAt(i, 2).toString();
				String direccion = tblProductos.getValueAt(i, 3).toString();
				String telefono = tblProductos.getValueAt(i, 4).toString();
				String dni = tblProductos.getValueAt(i, 5).toString();

				pw.println(codigoCliente + "," + nombres + "," + apellidos + "," + direccion + "," + telefono + "," + dni);
			}
			JOptionPane.showMessageDialog(this, "Cliente guardado exitosamente.", "Informaci�n",
					JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(this, "Error al guardar en el archivo.", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	// CARGAR DATOS DEL ARCHIVO
	private void cargarDesdeArchivo() {
	    modeloTabla.setRowCount(0);
	    listaProductos.clear();

	    File archivo = new File("productos.txt");
	    if (archivo.exists()) {
	        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
	            String linea;
	            while ((linea = br.readLine()) != null) {
	                String[] datos = linea.split(",");
	                if (datos.length == 6) {
	                    int codigoProducto = Integer.parseInt(datos[0]);
	                    String nombres = datos[1];
	                    double precio = Double.parseDouble(datos[2]);
	                    int stockActual = Integer.parseInt(datos[3]);
	                    int stockMinimo = Integer.parseInt(datos[4]);
	                    int stockMaximo = Integer.parseInt(datos[5]);

	                    Producto producto = new Producto(nombres, precio, stockActual, stockMinimo, stockMaximo);
	                    producto.setCodigoProducto(codigoProducto);
	                    listaProductos.add(producto); 

	                    Object[] fila = { codigoProducto, nombres, precio, stockActual, stockMinimo, stockMaximo};
	                    modeloTabla.addRow(fila);
	                }
	            }
	        } catch (Exception e) {
	            JOptionPane.showMessageDialog(null, "Error al cargar los datos del archivo.", "Error",
	                    JOptionPane.ERROR_MESSAGE);
	        }
	    } else {
	        JOptionPane.showMessageDialog(null, "El archivo de productos no existe.", "Error", JOptionPane.ERROR_MESSAGE);
	    }
	}
}
