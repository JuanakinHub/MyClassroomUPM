package graficas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;

public class GUIPAS extends JDialog {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIPAS frame = new GUIPAS();
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
	public GUIPAS() {
		setTitle("MyUPMClassroom");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 659, 510);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 51, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		this.setLocationRelativeTo(null);
		
		JLabel lblTituloMenuPAS = new JLabel("Bienvenido al Menú de Usuario PAS");
		lblTituloMenuPAS.setForeground(Color.WHITE);
		lblTituloMenuPAS.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 21));
		
		JButton btnDarAltaAulas = new JButton("Dar Alta Aulas");
		btnDarAltaAulas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				GUIAulas frame = new GUIAulas();
				frame.setVisible(true);
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
		
		JLabel lblPregunta = new JLabel("¿Qué deseas hacer?");
		lblPregunta.setForeground(Color.WHITE);
		
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
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(153, Short.MAX_VALUE)
					.addComponent(btnDarAltaAulas)
					.addGap(127)
					.addComponent(btnVerAulas)
					.addGap(175))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
							.addGap(28)
							.addComponent(lblNewLabel_1)
							.addPreferredGap(ComponentPlacement.RELATED, 182, Short.MAX_VALUE)
							.addComponent(lblNewLabel))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap(513, Short.MAX_VALUE)
							.addComponent(btnCerrarSesion)))
					.addGap(23))
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addGap(262)
					.addComponent(lblPregunta)
					.addContainerGap(274, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(133, Short.MAX_VALUE)
					.addComponent(lblTituloMenuPAS, GroupLayout.PREFERRED_SIZE, 379, GroupLayout.PREFERRED_SIZE)
					.addGap(121))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(30)
							.addComponent(lblNewLabel_1))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)))
					.addGap(41)
					.addComponent(lblTituloMenuPAS)
					.addPreferredGap(ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
					.addComponent(lblPregunta)
					.addGap(64)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnCerrarSesion)
							.addGap(21))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnDarAltaAulas)
								.addComponent(btnVerAulas))
							.addGap(87))))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
