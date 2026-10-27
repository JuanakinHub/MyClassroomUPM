package graficas;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;

public class GUIAlumno extends JDialog {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIAlumno frame = new GUIAlumno();
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
	public GUIAlumno() {
		setTitle("MyUPMClassroom");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 677, 498);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 51, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		this.setLocationRelativeTo(null);
		
		JLabel lblTituloMenuAlumno = new JLabel("Bienvenido al Menú de Usuario Alumno");
		lblTituloMenuAlumno.setForeground(Color.WHITE);
		lblTituloMenuAlumno.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 19));
		
		JLabel lblPregunta = new JLabel("¿Qué deseas hacer?");
		lblPregunta.setForeground(Color.WHITE);
		
		JButton btnSuscribirse = new JButton("Suscribrirse Observador");
		btnSuscribirse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUISuscribirse msuscri = new GUISuscribirse();
				msuscri.setVisible(true);
			}
		});
		
		JButton btnVerAulas = new JButton("Ver Aulas");
		btnVerAulas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUIListaAulas frame = new GUIListaAulas();
				frame.setVisible(true);
			}
		});
		
		JButton btnCerrarSesion = new JButton("Cerrar Sesión");
		btnCerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				GUILogin log = new GUILogin();
				log.setVisible(true);
			}
		});
		
		JLabel lblNewLabel = new JLabel("");
		ImageIcon ico = new ImageIcon(getClass().getResource("/LogoEtsisi.png"));
		lblNewLabel.setIcon(ico);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		ImageIcon ico2 = new ImageIcon(getClass().getResource("/LogoUPM.png"));
		lblNewLabel_1.setIcon(ico2);
		contentPane.add(lblNewLabel_1);
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_1)
					.addPreferredGap(ComponentPlacement.RELATED, 231, Short.MAX_VALUE)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(122)
					.addComponent(lblTituloMenuAlumno, GroupLayout.PREFERRED_SIZE, 383, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(146, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(273)
					.addComponent(lblPregunta)
					.addContainerGap(281, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(147)
					.addComponent(btnSuscribirse)
					.addGap(97)
					.addComponent(btnVerAulas)
					.addContainerGap(183, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(531, Short.MAX_VALUE)
					.addComponent(btnCerrarSesion)
					.addGap(23))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1))
					.addGap(42)
					.addComponent(lblTituloMenuAlumno)
					.addGap(52)
					.addComponent(lblPregunta)
					.addGap(58)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSuscribirse)
						.addComponent(btnVerAulas))
					.addGap(56)
					.addComponent(btnCerrarSesion)
					.addGap(127))
		);
		contentPane.setLayout(gl_contentPane);
	}

}
