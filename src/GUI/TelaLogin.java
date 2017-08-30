package GUI;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import fachada.Fachada;

public class TelaLogin extends JFrame {

	private JPanel contentPane;
	private JTextField textLogin;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaLogin frame = new TelaLogin();
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
	public TelaLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		textLogin = new JTextField();
		textLogin.setBounds(308, 161, 215, 34);
		contentPane.add(textLogin);
		textLogin.setColumns(10);
		
		JLabel lblSenha = new JLabel("Login:");
		lblSenha.setFont(new Font("Dialog", Font.BOLD, 15));
		lblSenha.setBounds(200, 167, 49, 18);
		contentPane.add(lblSenha);
		
		JLabel label = new JLabel("Senha:");
		label.setFont(new Font("Dialog", Font.BOLD, 15));
		label.setBounds(200, 243, 49, 18);
		contentPane.add(label);
		
		JLabel lblMygym = new JLabel("MyGym");
		lblMygym.setFont(new Font("Dialog", Font.BOLD, 40));
		lblMygym.setBounds(294, 11, 153, 107);
		contentPane.add(lblMygym);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(308, 237, 215, 34);
		contentPane.add(passwordField);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(319, 326, 128, 35);
		contentPane.add(btnLogin);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					if(textLogin.getText() == "" || String.valueOf(passwordField.getPassword()) == "" || textLogin.getText() == null 
							|| String.valueOf(passwordField.getPassword()) == null) {
						JOptionPane.showMessageDialog(null, "Os campos não podem estar vazios", "Falha de Login", JOptionPane.WARNING_MESSAGE);
					}
					Fachada.getInstance().conectar(textLogin.getText(), String.valueOf(passwordField.getPassword()));
					TelaMain telaMain = new TelaMain();
					telaMain.setVisible(true);
					dispose();
				}catch(Exception e){
					JOptionPane.showMessageDialog(null, "Falha no login, tente novamente", "Falha de login", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		
	}
}
