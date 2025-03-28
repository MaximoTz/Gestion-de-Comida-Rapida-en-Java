package com.comidaRapida.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTable;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class frmClientes extends JFrame {

	private JPanel contentPane;

	private JTextField tbxNombre;

	private JTextField tbxApellidos;

	private JTextField tbxDireccion;

	private JTextField tbxTelefono;

	private JTextField tbxDNI;

	private JTable tblClientes;

	private JLabel lblNewLabel_1;

	private JButton btnAgregar;

	private JButton btnEditar;

	private JButton btnEliminar;

	private JButton btnBuscar;

	private DefaultTableModel modeloTabla;

	private List<Cliente> listaClientes = new ArrayList<>();

	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmClientes frame = new frmClientes();
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
	public frmClientes() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 996, 479);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 222, 173));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNombres = new JLabel("Nombres:");
		lblNombres.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombres.setBounds(56, 113, 56, 14);
		contentPane.add(lblNombres);

		tbxNombre = new JTextField();
		tbxNombre.setColumns(10);
		tbxNombre.setBounds(130, 110, 163, 20);
		contentPane.add(tbxNombre);

		JLabel lblNewLabel_1_1 = new JLabel("Apellidos:");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1.setBounds(56, 157, 56, 14);
		contentPane.add(lblNewLabel_1_1);

		tbxApellidos = new JTextField();
		tbxApellidos.setColumns(10);
		tbxApellidos.setBounds(130, 154, 163, 20);
		contentPane.add(tbxApellidos);

		JLabel lblNewLabel_1_1_1 = new JLabel("Direccion:");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_1.setBounds(31, 200, 81, 14);
		contentPane.add(lblNewLabel_1_1_1);

		tbxDireccion = new JTextField();
		tbxDireccion.setColumns(10);
		tbxDireccion.setBounds(130, 197, 163, 20);
		contentPane.add(tbxDireccion);

		JLabel lblNewLabel_1_1_1_1 = new JLabel("Telefono:");
		lblNewLabel_1_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_1_1.setBounds(56, 247, 56, 14);
		contentPane.add(lblNewLabel_1_1_1_1);

		tbxTelefono = new JTextField();
		tbxTelefono.setColumns(10);
		tbxTelefono.setBounds(130, 244, 163, 20);
		contentPane.add(tbxTelefono);

		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("DNI:");
		lblNewLabel_1_1_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_1_1_1.setBounds(66, 295, 46, 14);
		contentPane.add(lblNewLabel_1_1_1_1_1);

		tbxDNI = new JTextField();
		tbxDNI.setColumns(10);
		tbxDNI.setBounds(130, 292, 163, 20);
		contentPane.add(tbxDNI);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(305, 92, 541, 285);
		contentPane.add(scrollPane);

		modeloTabla = new DefaultTableModel(new Object[][] {}, new String[] {
				"ID", "Nombres", "Apellidos", "Direccion", "Telefono", "DNI"
		});
		tblClientes = new JTable(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Nombres", "Apellidos", "Direccion", "Telefono", "DNI"
			}
		));
		tblClientes.setFont(new Font("Tahoma", Font.PLAIN, 11));
		scrollPane.setViewportView(tblClientes);
		tblClientes.setRowHeight(30);

		modeloTabla = (DefaultTableModel) tblClientes.getModel();
		
		lblNewLabel_1 = new JLabel("-- Registrar Clientes --");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_1.setBounds(31, 26, 354, 42);
		contentPane.add(lblNewLabel_1);

		// FUNCIONALIDA DE BOTONES
		btnAgregar = new JButton("Agregar");
		btnAgregar.setBackground(new Color(144, 238, 144));
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Agregar Cliente
				agregarCliente();
			}
		});
		btnAgregar.setBounds(868, 92, 81, 60);
		contentPane.add(btnAgregar);

		btnEditar = new JButton("Editar");
		btnEditar.setBackground(new Color(255, 215, 0));
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Editar Cliente
				editarCliente();
			}
		});
		btnEditar.setBounds(868, 163, 81, 60);
		contentPane.add(btnEditar);

		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBackground(new Color(250, 128, 114));
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Eliminar cliente
				eliminarCliente();
			}
		});
		btnEliminar.setBounds(868, 241, 81, 60);
		contentPane.add(btnEliminar);

		btnBuscar = new JButton("Buscar");
		btnBuscar.setBackground(new Color(175, 238, 238));
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Buscar cliente
				buscarCliente();
			}
		});
		btnBuscar.setBounds(868, 316, 81, 60);
		contentPane.add(btnBuscar);

		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setForeground(new Color(255, 255, 255));
		btnLimpiar.setBackground(new Color(160, 82, 45));
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Limpiar Campos
				limpiarCampos();
			}
		});
		btnLimpiar.setBounds(177, 328, 118, 36);
		contentPane.add(btnLimpiar);
		
		JButton btnListar = new JButton("Listar");
		btnListar.setBackground(new Color(72, 209, 204));
		btnListar.setForeground(new Color(0, 0, 0));
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarDesdeArchivo();
			}
		});
		btnListar.setBounds(527, 388, 118, 36);
		contentPane.add(btnListar);

	}

	// AGREGAR
	private void agregarCliente() {
		String nombre = tbxNombre.getText().trim();
		String apellidos = tbxApellidos.getText().trim();
		String direccion = tbxDireccion.getText().trim();
		String telefono = tbxTelefono.getText().trim();
		String dni = tbxDNI.getText().trim();

		if (nombre.isEmpty() || apellidos.isEmpty() || direccion.isEmpty() || telefono.isEmpty() || dni.isEmpty()) {
			JOptionPane.showMessageDialog(frmClientes.this, "Todos los campos son obligatorios", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}

		for (Cliente c : listaClientes) {
			if (c.getDni().equals(dni)) {
				JOptionPane.showMessageDialog(frmClientes.this, "El DNI ingresado ya existe", "Error", JOptionPane.ERROR_MESSAGE);
				return;
			}

			if (c.getTelefono().equals(telefono)) {
				JOptionPane.showMessageDialog(frmClientes.this, "El tel�fono ingresado ya est� registrado", "Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
		}

		Cliente cliente = new Cliente(nombre, apellidos, direccion, telefono, dni);
		listaClientes.add(cliente);

		modeloTabla.addRow(new Object[] {
				cliente.getCodigoCliente(),
				cliente.getNombres(),
				cliente.getApellidos(),
				cliente.getDireccion(),
				cliente.getTelefono(),
				cliente.getDni()
		});

		guardarEnArchivo();
		limpiarCampos();

		JOptionPane.showMessageDialog(frmClientes.this, "Cliente agregado correctamente", "�xito", JOptionPane.INFORMATION_MESSAGE);
	}

	// BUSCAR
	private void buscarCliente() {
		String dni = JOptionPane.showInputDialog(frmClientes.this, "Ingrese el DNI del cliente a buscar:");
		Cliente clienteEncontrado = buscarClienteporDNI(dni);

		if (clienteEncontrado != null) {
			tbxDNI.setText(clienteEncontrado.getDni());
			tbxNombre.setText(clienteEncontrado.getNombres());
			tbxApellidos.setText(clienteEncontrado.getApellidos());
			tbxDireccion.setText(clienteEncontrado.getDireccion());
			tbxTelefono.setText(clienteEncontrado.getTelefono());
			
			JOptionPane.showMessageDialog(this, "Cliente encontrado", "Informaci�n", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	// EDITAR
	private Cliente clienteEditando = null;

	private void editarCliente() {
		if(clienteEditando == null) {
			String dniBuscado = tbxDNI.getText().trim();

			if (dniBuscado.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Ingrese el DNI del cliente a editar", "Error", JOptionPane.ERROR_MESSAGE);
        return;
			}
			
			Cliente clienteEncontrado = null;
	    for (Cliente c : listaClientes) {
	        if (c.getDni().equals(dniBuscado)) {
	            clienteEncontrado = c;
	            break;
	        }
	    }
	    
	    if (clienteEncontrado == null) {
        JOptionPane.showMessageDialog(this, "No se encontr� un cliente con ese DNI", "Error", JOptionPane.ERROR_MESSAGE);
        return;
	    }
	    
	    clienteEncontrado.setNombres(tbxNombre.getText().trim());
	    clienteEncontrado.setApellidos(tbxApellidos.getText().trim());
	    clienteEncontrado.setDireccion(tbxDireccion.getText().trim());
	    clienteEncontrado.setTelefono(tbxTelefono.getText().trim());
	    
	    actualizarTabla(dniBuscado, clienteEncontrado);
	    
	    guardarEnArchivo();
	    JOptionPane.showMessageDialog(frmClientes.this, "Cliente editado correctamente", "�xito", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	// ELIMINAR
	private void eliminarCliente() {
		String dni = JOptionPane.showInputDialog(frmClientes.this, "Ingrese el DNI del cliente a eliminar:");

		if (dni == null || dni.trim().isEmpty()) {
			JOptionPane.showMessageDialog(frmClientes.this, "Ingrese el DNI del cliente a eliminar", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}

		boolean encontrado = false;
		int filaSeleccionada = -1;

		for (int i = 0; i < listaClientes.size(); i++) {
			if (listaClientes.get(i).getDni().equals(dni)) {
				filaSeleccionada = i;
				encontrado = true;
				break;
			}
		}

		if (!encontrado) {
			JOptionPane.showMessageDialog(frmClientes.this, "No se encontr� un cliente con el DNI ingresado", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}

		int confirmacion = JOptionPane.showConfirmDialog(frmClientes.this, "�Est� seguro de eliminar este cliente?", "Confirmar eliminaci�n", JOptionPane.YES_NO_OPTION);
		if (confirmacion != JOptionPane.YES_OPTION) {
			return;
		}

		listaClientes.remove(filaSeleccionada);
		

		int filaTabla = buscarFilaPorDNI(dni);
		if (filaTabla != -1) {
			modeloTabla.removeRow(filaTabla);
		}
		
		guardarEnArchivo();
		JOptionPane.showMessageDialog(frmClientes.this, "Cliente eliminado correctamente", "�xito", JOptionPane.INFORMATION_MESSAGE);
	}

	// FUNCION BUSCAR CLIENTE POR DNI
	private Cliente buscarClienteporDNI(String dni) {
		if (dni == null || dni.trim().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Ingrese un DNI v�lido", "Error", JOptionPane.ERROR_MESSAGE);
			return null;
		}

		for (Cliente c : listaClientes) {
			if (c.getDni().equals(dni.trim())) {
				return c;
			}
		}

		JOptionPane.showMessageDialog(this, "No se encontr� un cliente con ese DNI", "Error", JOptionPane.ERROR_MESSAGE);
		return null;
	}

	// FUNCION BUSCAR FILA POR DNI
	private int buscarFilaPorDNI(String dni) {
		for (int i = 0; i < modeloTabla.getRowCount(); i++) {
			if (modeloTabla.getValueAt(i, 5).equals(dni)) {
				return i;
			}
		}
		return -1;
	}

	// FUNCION ACTUALIZAR TABLA
	private void actualizarTabla(String dni, Cliente cliente) {
		for (int i = 0; i < modeloTabla.getRowCount(); i++) {
			if (modeloTabla.getValueAt(i, 5).equals(dni)) {
				modeloTabla.setValueAt(cliente.getNombres(), i, 1);
				modeloTabla.setValueAt(cliente.getApellidos(), i, 2);
				modeloTabla.setValueAt(cliente.getDireccion(), i, 3);
				modeloTabla.setValueAt(cliente.getTelefono(), i, 4);
				break;
			}
		}
	}

	private void limpiarCampos() {
		tbxNombre.setText("");
		tbxApellidos.setText("");
		tbxDireccion.setText("");
		tbxTelefono.setText("");
		tbxDNI.setText("");
	}
	
	private void guardarEnArchivo() {
		File archivo = new File("clientes.txt");
		try (PrintWriter pw = new PrintWriter(new FileWriter(archivo))) {
			for (int i = 0; i < tblClientes.getRowCount(); i++) {
				int codigoCliente = Integer.parseInt(tblClientes.getValueAt(i, 0).toString());
				String nombres = tblClientes.getValueAt(i, 1).toString();
				String apellidos = tblClientes.getValueAt(i, 2).toString();
				String direccion = tblClientes.getValueAt(i, 3).toString();
				String telefono = tblClientes.getValueAt(i, 4).toString();
				String dni = tblClientes.getValueAt(i, 5).toString();

				pw.println(codigoCliente + "," + nombres + "," + apellidos + "," + direccion + "," + telefono + "," + dni);
			}
			JOptionPane.showMessageDialog(this, "Cliente guardado exitosamente.", "Informaci�n",
					JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(this, "Error al guardar en el archivo.", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void cargarDesdeArchivo() {
	    modeloTabla.setRowCount(0);
	    listaClientes.clear();

	    File archivo = new File("clientes.txt");
	    if (archivo.exists()) {
	        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
	            String linea;
	            while ((linea = br.readLine()) != null) {
	                String[] datos = linea.split(",");
	                if (datos.length == 6) {
	                    int codigoCliente = Integer.parseInt(datos[0]);
	                    String nombres = datos[1];
	                    String apellidos = datos[2];
	                    String direccion = datos[3];
	                    String telefono = datos[4];
	                    String dni = datos[5];

	                    Cliente cliente = new Cliente(nombres, apellidos, direccion, telefono, dni);
	                    cliente.setCodigoCliente(codigoCliente);
	                    listaClientes.add(cliente); 

	                    Object[] fila = { codigoCliente, nombres, apellidos, direccion, telefono, dni};
	                    modeloTabla.addRow(fila);
	                }
	            }
	        } catch (Exception e) {
	            JOptionPane.showMessageDialog(null, "Error al cargar los datos del archivo.", "Error",
	                    JOptionPane.ERROR_MESSAGE);
	        }
	    } else {
	        JOptionPane.showMessageDialog(null, "El archivo de clientes no existe.", "Error", JOptionPane.ERROR_MESSAGE);
	    }
	}
}
