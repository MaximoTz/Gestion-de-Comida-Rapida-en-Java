package com.comidaRapida.gui;

import java.awt.EventQueue;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import rsscalelabel.RSScaleLabel;

public class menuPrincipal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					menuPrincipal frame = new menuPrincipal();
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
	public menuPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1050, 770);
		this.setLocationRelativeTo(null);
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnuMenu = new JMenu("Archivo");
		menuBar.add(mnuMenu);
		
		JMenuItem actCerrarSesion = new JMenuItem("Cerrar Sesion");
		actCerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int confirmacion = JOptionPane.showConfirmDialog(menuPrincipal.this, "¿Está seguro que quiere cerrar sesión?", "Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				
				if(confirmacion == JOptionPane.YES_OPTION) {
					menuPrincipal.this.dispose();
					login login = new login();
					login.setVisible(true);
				}
			}
		});
		mnuMenu.add(actCerrarSesion);
		
		JMenu mnuMantenimiento = new JMenu("Mantenimiento");
		menuBar.add(mnuMantenimiento);
		
		JMenuItem actClientes = new JMenuItem("Clientes");
		actClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frmClientes clientes = new frmClientes();
				clientes.setVisible(true);
			}
		});
		mnuMantenimiento.add(actClientes);
		
		JMenuItem actProductos = new JMenuItem("Productos");
		actProductos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmProductos productos = new frmProductos();
				productos.setVisible(true);
			}
		});
		mnuMantenimiento.add(actProductos);
		
		JMenu mnuVentas = new JMenu("Ventas");
		menuBar.add(mnuVentas);
		
		JMenuItem actRegistrarVenta = new JMenuItem("Registrar Venta");
		actRegistrarVenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmPedidos pedidos = new frmPedidos();
				pedidos.setVisible(true);
			}
		});
		mnuVentas.add(actRegistrarVenta);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, 1034, 709);
		RSScaleLabel.setScaleLabel(lblNewLabel, getClass().getClassLoader().getResource("resources/fondoMenu2.jpg").getPath());
		contentPane.add(lblNewLabel);
		
		
		
	}
}
