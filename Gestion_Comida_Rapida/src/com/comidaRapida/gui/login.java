package com.comidaRapida.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.UIManager;
import java.awt.SystemColor;

public class login extends JFrame {

	private JPanel contentPane;
	private JTextField tbxUsuario;
	private JPasswordField tbxPassword;
	private JButton btnIngresar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
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
	public login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 637, 378);
		this.setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255, 220));
		panel.setBounds(155, 24, 321, 289);
		contentPane.add(panel);
		panel.setLayout(null);
		
		btnIngresar = new JButton("Ingresar");
		btnIngresar.setForeground(new Color(255, 255, 255));
		btnIngresar.setBackground(new Color(244, 164, 96));
		btnIngresar.setBounds(100, 227, 118, 31);
		panel.add(btnIngresar);
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String usuario, password;
				
				usuario = tbxUsuario.getText();
				password = tbxPassword.getText();
				
				if("admin".equals(usuario) && "admin".equals(password)) {
					JOptionPane.showMessageDialog(login.this, "Bienvenido al Sistema", "Bienvenido", JOptionPane.INFORMATION_MESSAGE);
					menuPrincipal menu = new menuPrincipal();
					menu.setVisible(true);
					login.this.dispose();
				}else {
					JOptionPane.showMessageDialog(login.this, "Los datos ingresados son incorrectos", "Error", JOptionPane.ERROR_MESSAGE);
					tbxUsuario.setText("");
					tbxPassword.setText("");
				}
			}
		});
		btnIngresar.setFont(new Font("Montserrat", Font.BOLD, 13));
		
		tbxPassword = new JPasswordField();
		tbxPassword.setFont(new Font("Montserrat", Font.BOLD, 14));
		tbxPassword.setBounds(79, 177, 173, 20);
		panel.add(tbxPassword);
		
		JLabel lblNewLabel_2 = new JLabel("Contrase\u00F1a:");
		lblNewLabel_2.setBounds(79, 152, 102, 14);
		panel.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Montserrat", Font.BOLD, 13));
		
		tbxUsuario = new JTextField();
		tbxUsuario.setFont(new Font("Montserrat Medium", Font.PLAIN, 13));
		tbxUsuario.setBounds(79, 115, 173, 20);
		panel.add(tbxUsuario);
		tbxUsuario.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Usuario:");
		lblNewLabel_1.setBounds(79, 90, 74, 14);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Montserrat", Font.BOLD, 13));
		
		JLabel lblNewLabel = new JLabel("Hamburgueser\u00EDa");
		lblNewLabel.setBounds(48, 30, 218, 41);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Montserrat", Font.BOLD, 24));
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(login.class.getResource("/resources/usuario-de-perfil (1).png")));
		lblNewLabel_4.setBounds(42, 94, 32, 41);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_4_1 = new JLabel("");
		lblNewLabel_4_1.setIcon(new ImageIcon(login.class.getResource("/resources/contrasena.png")));
		lblNewLabel_4_1.setBounds(42, 156, 24, 41);
		panel.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(login.class.getResource("/resources/fondo.jpg")));
		lblNewLabel_3.setBounds(0, -6, 621, 345);
		contentPane.add(lblNewLabel_3);
	}
}
