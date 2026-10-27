package graficas;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import org.apache.commons.lang.SystemUtils;

import controller.CAula;
import controller.CUsuario;
import modelo.TAula;
import modelo.Usuario;
import javax.swing.JComboBox;

public class GUIAulas extends JDialog {

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtSuperficie;
	private JTextField txtAforo;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIAulas frame = new GUIAulas();
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
	public GUIAulas() {
		setType(Type.POPUP);
		setForeground(Color.RED);
		setTitle("MyUPMClassroom");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 642, 642);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 51, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		this.setLocationRelativeTo(null);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setForeground(Color.WHITE);
		lblNombre.setBounds(148, 280, 75, 14);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(249, 277, 313, 20);
		txtNombre.setColumns(10);
		
		JLabel lblSuperficie = new JLabel("Superfie:");
		lblSuperficie.setForeground(Color.WHITE);
		lblSuperficie.setBounds(148, 324, 75, 14);
		
		txtSuperficie = new JTextField();
		txtSuperficie.setBounds(249, 321, 313, 20);
		txtSuperficie.setColumns(10);
		
		JLabel lblAforo = new JLabel("Aforo:");
		lblAforo.setForeground(Color.WHITE);
		lblAforo.setBounds(148, 365, 75, 14);
		
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setForeground(Color.WHITE);
		lblTipo.setBounds(148, 407, 75, 14);
		
		txtAforo = new JTextField();
		txtAforo.setBounds(249, 362, 313, 20);
		txtAforo.setColumns(10);
		
		JComboBox comboBoxTipo = new JComboBox(TAula.values());
		comboBoxTipo.setBounds(249, 403, 313, 22);
		contentPane.add(comboBoxTipo);
		comboBoxTipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Aqui es donde me falto colocarle el metodo toString();
				String selecto = comboBoxTipo.getSelectedItem().toString();
				//Lo coloco en una etiqueta para comprobar efectivamente que es un String
				//select.setText(selecto);
			}
		});
		
		JButton btnCrearAula = new JButton("Crear Aula");
		btnCrearAula.setBounds(142, 492, 133, 23);
		btnCrearAula.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {					
					CAula cAula = new CAula();
					if(!txtNombre.getText().equals("") && !txtSuperficie.getText().equals("") && !txtAforo.getText().equals("") ) {
							if(txtNombre.getText().length()>30){JOptionPane.showMessageDialog(null, "Nombre no válido, más de 30 caracteres.", "MyUPMClassroom", JOptionPane.ERROR_MESSAGE);}
			                else if(txtSuperficie.getText().length()>2 || txtSuperficie.getText().charAt(0)>'4'){JOptionPane.showMessageDialog(null, "La superficie no puede ser mayor a 49.", "MyUPMClassroom", JOptionPane.ERROR_MESSAGE);}
			                else if((txtSuperficie.getText().charAt(0)<='0' || txtSuperficie.getText().charAt(0)>='9') || (txtSuperficie.getText().charAt(1)<='0' || txtSuperficie.getText().charAt(1)>='9') ){JOptionPane.showMessageDialog(null, "Superficie no válida, no puede tener caracteres", "MyUPMClassroom", JOptionPane.ERROR_MESSAGE);}
			                else if(txtSuperficie.getText().charAt(0)==0 && txtSuperficie.getText().charAt(1)==0){JOptionPane.showMessageDialog(null, "Superficie no válida,no puede ser 0.", "MyUPMClassroom", JOptionPane.ERROR_MESSAGE);}
			                else if(txtAforo.getText().length()>2){JOptionPane.showMessageDialog(null, "Aforo no válido, mayor que 99.", "MyUPMClassroom", JOptionPane.ERROR_MESSAGE);}
			                else if((txtAforo.getText().charAt(0)<='0' || txtAforo.getText().charAt(0)>='9') || (txtAforo.getText().charAt(1)<='0' || txtAforo.getText().charAt(1)>='9') ){JOptionPane.showMessageDialog(null, "El aforo no puede contener letras.", "MyUPMClassroom", JOptionPane.ERROR_MESSAGE);}
			                else if(txtAforo.getText().charAt(0)==0 && txtAforo.getText().charAt(1)==0){JOptionPane.showMessageDialog(null, "Aforo no válido, no puede ser 0.", "MyUPMClassroom", JOptionPane.ERROR_MESSAGE);}
			                else if(cAula.buscarPorNombre(txtNombre.getText())==null) {
							cAula.crear(txtNombre.getText(),txtSuperficie.getText(),txtAforo.getText(), comboBoxTipo.getSelectedItem().toString());
							JOptionPane.showMessageDialog(null, "Este aula se ha creado.", "MyUPMClassroom", JOptionPane.INFORMATION_MESSAGE);							
							}else {
								JOptionPane.showMessageDialog(null, "Este aula ya existe.", "MyUPMClassroom", JOptionPane.ERROR_MESSAGE);
							}
						}else{
						JOptionPane.showMessageDialog(null, "Hay campos en blanco.", "MyUPMClassroom", JOptionPane.ERROR_MESSAGE);
					}			
				} catch (Exception e2) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, "Error Inesperado.", "MyUPMClassroom", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(340, 492, 133, 23);
		btnCancelar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				dispose();
				GUIPAS mpas = new GUIPAS();
				mpas.setVisible(true);
			}
		});
		
		JLabel lblTituloAulas = new JLabel("Alta de Aulas");
		lblTituloAulas.setForeground(Color.WHITE);
		lblTituloAulas.setBounds(212, 141, 166, 50);
		lblTituloAulas.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 25));
		contentPane.setLayout(null);
		contentPane.add(lblSuperficie);
		contentPane.add(lblNombre);
		contentPane.add(lblAforo);
		contentPane.add(lblTipo);
		contentPane.add(btnCrearAula);
		contentPane.add(btnCancelar);
		contentPane.add(txtAforo);
		contentPane.add(txtSuperficie);
		contentPane.add(txtNombre);
		contentPane.add(lblTituloAulas);
		
		JLabel lblNewLabel = new JLabel("Todos los campos son obligatorios");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(300, 239, 210, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		ImageIcon ico = new ImageIcon(getClass().getResource("/LogoEtsisi.png"));
		lblNewLabel_1.setIcon(ico);
		lblNewLabel_1.setBounds(404, 11, 200, 119);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		ImageIcon ico2 = new ImageIcon(getClass().getResource("/LogoUPM.png"));
		lblNewLabel_2.setIcon(ico2);
		lblNewLabel_2.setBounds(29, 47, 222, 67);
		contentPane.add(lblNewLabel_2);
	}
	
	public void checkError () {
		
	}
}
