package graficas;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import controller.CUsuario;
import view.ICUsuario;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.Label;

public class GUILogin extends JDialog {

	private JPanel contentPane;
	private JTextField txtDNI;
	
	private ICUsuario icUsuario;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUILogin frame = new GUILogin();
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
	public GUILogin() {
		
		setBackground(Color.GRAY);
		setType(Type.POPUP);
		setTitle("MyUPMClassroom");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 653, 521);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 51, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		this.setLocationRelativeTo(null);
		
		JLabel lblIntroduzca = new JLabel("");	
		ImageIcon ico = new ImageIcon(getClass().getResource("/LogoEtsisi.png"));
		lblIntroduzca.setIcon(ico);
		contentPane.add(lblIntroduzca);
		
		
		JLabel lblNewLabel = new JLabel("");
		ImageIcon ico2 = new ImageIcon(getClass().getResource("/LogoUPM.png"));
		lblNewLabel.setIcon(ico2);
		contentPane.add(lblNewLabel);
		
		txtDNI = new JTextField();
		txtDNI.setColumns(10);
		
		JLabel lblTituloLogin = new JLabel("Login Usuarios");
		lblTituloLogin.setForeground(Color.WHITE);
		lblTituloLogin.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					CUsuario cusu = new CUsuario();
					if(!txtDNI.getText().equals("")) {
						dispose();
						cusu.login(txtDNI.getText());
					}else {
						JOptionPane.showMessageDialog(null, "El campo esta en blanco.", "MyUPMClassroom", JOptionPane.ERROR_MESSAGE);
					}
					//GUICUsuario guicUsuario = new GUICUsuario(icUsuario);
					//guicUsuario.listarUsuarios();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				GUIInicio frame = new GUIInicio();
				frame.setVisible(true);
			}
		});
		
		JLabel lblNewLabel_1 = new JLabel("Introduzca el DNI para logearse:");
		lblNewLabel_1.setForeground(Color.WHITE);
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(102)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnEntrar, Alignment.TRAILING)
						.addComponent(lblNewLabel_1, Alignment.TRAILING))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(18)
							.addComponent(txtDNI, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(94)
							.addComponent(btnCancelar)))
					.addContainerGap(184, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(35)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 208, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 146, Short.MAX_VALUE)
					.addComponent(lblIntroduzca, GroupLayout.PREFERRED_SIZE, 204, GroupLayout.PREFERRED_SIZE)
					.addGap(35))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(206, Short.MAX_VALUE)
					.addComponent(lblTituloLogin, GroupLayout.PREFERRED_SIZE, 262, GroupLayout.PREFERRED_SIZE)
					.addGap(160))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(43)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(26)
							.addComponent(lblIntroduzca, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
					.addComponent(lblTituloLogin)
					.addGap(58)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(txtDNI, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 97, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnEntrar)
						.addComponent(btnCancelar))
					.addGap(71))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
