package graficas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.LayoutStyle.ComponentPlacement;

public class GUIInicio extends JDialog {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIInicio frame = new GUIInicio();
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
	public GUIInicio() {
		
		  
		setTitle("MyUPMClassroom");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 654, 560);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 51, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		this.setLocationRelativeTo(null);
		
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				GUILogin log = new GUILogin();
				log.setVisible(true);
			}
		});
		
		JButton btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				GUIUsuario altaU = new GUIUsuario();
				altaU.setVisible(true);
			}
		});
		
		JLabel lblTituloMenuInicio = new JLabel("MyUPMClassroom");
		lblTituloMenuInicio.setForeground(Color.WHITE);
		lblTituloMenuInicio.setFont(new Font("Tahoma", Font.ITALIC, 25));
		
		JLabel lblBienvenido = new JLabel("Bienvenido a la aplicacion");
		lblBienvenido.setForeground(Color.WHITE);
		
		JLabel lblPregunta = new JLabel("¿Qué desea hacer?");
		lblPregunta.setForeground(Color.WHITE);
		
		JLabel lblNewLabel_1 = new JLabel("");
		ImageIcon ico = new ImageIcon(getClass().getResource("/LogoEtsisi.png"));
		lblNewLabel_1.setIcon(ico);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("");
		ImageIcon ico2 = new ImageIcon(getClass().getResource("/LogoUPM.png"));
		lblNewLabel.setIcon(ico2);
		contentPane.add(lblNewLabel);
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(254)
					.addComponent(lblPregunta)
					.addContainerGap(282, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(238)
					.addComponent(lblBienvenido)
					.addContainerGap(269, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(193)
					.addComponent(lblTituloMenuInicio, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(215, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(41)
							.addComponent(lblNewLabel))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(144)
							.addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(132)
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 212, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(126)
							.addComponent(btnRegistrarse)))
					.addGap(39))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(44)
							.addComponent(lblNewLabel))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(25)
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)))
					.addGap(65)
					.addComponent(lblTituloMenuInicio)
					.addGap(43)
					.addComponent(lblBienvenido)
					.addGap(37)
					.addComponent(lblPregunta)
					.addGap(85)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnLogin, GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
						.addComponent(btnRegistrarse, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(107))
		);
		contentPane.setLayout(gl_contentPane);
	}
	
}
