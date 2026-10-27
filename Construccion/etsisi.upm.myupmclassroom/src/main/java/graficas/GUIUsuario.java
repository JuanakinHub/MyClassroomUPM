package graficas;


import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bd.SQLite;
import controller.CUsuario;
import modelo.Usuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;



public class GUIUsuario extends JDialog {

	
	
	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtPapellido;
	private JTextField txtSapellido;
	private JTextField txtCorreo;
	private JTextField txtContraseña;
	private JTextField txtDNI;
	private JTextField txtConfirmarContra;
	
	boolean crea;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) throws SQLException{
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SQLite con = new SQLite();
					con.prueba();
					GUIUsuario frame = new GUIUsuario();
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
	public GUIUsuario() {
		setType(Type.POPUP);
		setForeground(Color.RED);
		setTitle("MyUPMClassroom");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 830, 762);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 51, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		this.setLocationRelativeTo(null);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setForeground(Color.WHITE);
		lblNombre.setBounds(203, 270, 75, 14);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(362, 267, 313, 20);
		txtNombre.setColumns(10);
		
		JLabel lblPapellido = new JLabel("1º Apellido:");
		lblPapellido.setForeground(Color.WHITE);
		lblPapellido.setBounds(203, 311, 75, 14);
		
		txtPapellido = new JTextField();
		txtPapellido.setBounds(362, 308, 313, 20);
		txtPapellido.setColumns(10);
		
		JLabel lblSapellido = new JLabel("2º Apellido:");
		lblSapellido.setForeground(Color.WHITE);
		lblSapellido.setBounds(203, 369, 75, 14);
		
		JLabel lblCorreo = new JLabel("Correo:");
		lblCorreo.setForeground(Color.WHITE);
		lblCorreo.setBounds(203, 428, 75, 14);
		
		JLabel lblContraseña = new JLabel("Contraseña:");
		lblContraseña.setForeground(Color.WHITE);
		lblContraseña.setBounds(203, 485, 75, 14);
		
		txtSapellido = new JTextField();
		txtSapellido.setBounds(362, 366, 313, 20);
		txtSapellido.setColumns(10);
		
		txtCorreo = new JTextField();
		txtCorreo.setBounds(362, 425, 313, 20);
		txtCorreo.setColumns(10);
		
		txtContraseña = new JTextField();
		txtContraseña.setBounds(362, 482, 313, 20);
		txtContraseña.setColumns(10);
		
		JLabel lblDNI = new JLabel("DNI:");
		lblDNI.setForeground(Color.WHITE);
		lblDNI.setBounds(203, 584, 75, 14);
		
		txtDNI = new JTextField();
		txtDNI.setBounds(362, 581, 313, 20);
		txtDNI.setColumns(10);
		
		JButton btnCrearUsuario = new JButton("Crear Usuario");
		btnCrearUsuario.setBounds(215, 660, 133, 23);
		btnCrearUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Boolean correcto= true;


				try {
					CUsuario cUsuario = new CUsuario();

					 if(txtContraseña.getText().equals("") || txtNombre.getText().equals("") || txtPapellido.getText().equals("") || txtSapellido.getText().equals("") || txtDNI.getText().equals("") || txtCorreo.getText().equals("") || txtConfirmarContra.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Hay campos en blanco.", "MyUPMClassroom", JOptionPane.ERROR_MESSAGE);}
					else if(txtNombre.getText().length()>30) JOptionPane.showMessageDialog(null, "Nombre no válido, más de 30 caracteres.", "MyUPMClassroom", JOptionPane.ERROR_MESSAGE);
					else if(txtPapellido.getText().length()>20 || txtSapellido.getText().length()>20) JOptionPane.showMessageDialog(null, "Apellidos no válidos, más de 20 caracteres", "MyUPMClassroom", JOptionPane.ERROR_MESSAGE);
					else if(txtCorreo.getText().length()>100) JOptionPane.showMessageDialog(null, "Correo no válido, más de 100 caracteres.", "MyUPMClassroom", JOptionPane.ERROR_MESSAGE);
					else if(txtContraseña.getText().length()>255) JOptionPane.showMessageDialog(null, "Contraseña no válida, más de 255 caracteres.", "MyUPMClassroom", JOptionPane.ERROR_MESSAGE);
					else if(txtDNI.getText().length()!=9) 	JOptionPane.showMessageDialog(null, "DNI debe tener 9 caracteres.", "MyUPMClassroom", JOptionPane.INFORMATION_MESSAGE);
					else if(!(txtDNI.getText().charAt(8)>='a' && txtDNI.getText().charAt(8)<='z') && !(txtDNI.getText().charAt(8)>='A' && txtDNI.getText().charAt(8)<='Z'))	JOptionPane.showMessageDialog(null, "Último caracter del DNI debe ser una letra", "MyUPMClassroom", JOptionPane.ERROR_MESSAGE);
					else if((txtContraseña.getText().equals(txtConfirmarContra.getText()))) {
						for (int i = 0;i<8 && correcto==true;i++) { if(txtDNI.getText().charAt(i)<'0' ||  txtDNI.getText().charAt(i)>'9') {JOptionPane.showMessageDialog(null, "DNI debe contener 8 números (0,9)", "MyUPMClassroom", JOptionPane.ERROR_MESSAGE);
							correcto=false;
						}}
						if(correcto!=false) {
							if(cUsuario.ComprobarexisteCuentaUPM(txtCorreo.getText())) {
								if(cUsuario.buscarPorDNI(txtDNI.getText())==null) {
									cUsuario.crear(txtNombre.getText(), txtPapellido.getText(), txtSapellido.getText(), txtCorreo.getText(), txtContraseña.getText(), txtConfirmarContra.getText(), txtDNI.getText(), null);
									JOptionPane.showMessageDialog(null, "El usuario se ha creado", "MyUPMClassroom", JOptionPane.INFORMATION_MESSAGE);
								}else {
									JOptionPane.showMessageDialog(null, "El usuario ya existe.", "MyUPMClassroom", JOptionPane.ERROR_MESSAGE);
								}		
							}else {
								JOptionPane.showMessageDialog(null, "Correo no valido.", "MyUPMClassroom", JOptionPane.ERROR_MESSAGE);
							}
						}
						}else{
							JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden.", "MyUPMClassroom", JOptionPane.ERROR_MESSAGE);
							}
				} catch (Exception e2) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, "Error Inesperado", "MyUPMClassroom", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(439, 660, 133, 23);
		btnCancelar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				dispose();
				GUIInicio frame = new GUIInicio();
				frame.setVisible(true);
			}
		});
		
		JLabel lblNewLabel_6 = new JLabel("Alta de Usuarios");
		lblNewLabel_6.setForeground(Color.WHITE);
		lblNewLabel_6.setBounds(296, 144, 203, 61);
		lblNewLabel_6.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 25));
		contentPane.setLayout(null);
		contentPane.add(lblDNI);
		contentPane.add(lblContraseña);
		contentPane.add(lblPapellido);
		contentPane.add(lblNombre);
		contentPane.add(lblSapellido);
		contentPane.add(lblCorreo);
		contentPane.add(btnCrearUsuario);
		contentPane.add(btnCancelar);
		contentPane.add(lblNewLabel_6);
		contentPane.add(txtDNI);
		contentPane.add(txtContraseña);
		contentPane.add(txtCorreo);
		contentPane.add(txtSapellido);
		contentPane.add(txtPapellido);
		contentPane.add(txtNombre);
		
		JLabel lblConfContraseña = new JLabel("Confirmar Contraseña:");
		lblConfContraseña.setForeground(Color.WHITE);
		lblConfContraseña.setHorizontalAlignment(SwingConstants.LEFT);
		lblConfContraseña.setBounds(204, 539, 116, 14);
		contentPane.add(lblConfContraseña);
		
		txtConfirmarContra = new JTextField();
		txtConfirmarContra.setBounds(362, 536, 311, 20);
		contentPane.add(txtConfirmarContra);
		txtConfirmarContra.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Todos los campos son obligatorios.");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(418, 229, 228, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		ImageIcon ico = new ImageIcon(getClass().getResource("/LogoEtsisi.png"));
		lblNewLabel_1.setIcon(ico);
		lblNewLabel_1.setBounds(593, 11, 200, 137);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(21, 55, 210, 93);
		ImageIcon ico2 = new ImageIcon(getClass().getResource("/LogoUPM.png"));
		lblNewLabel_2.setIcon(ico2);
		contentPane.add(lblNewLabel_2);
	}
}
