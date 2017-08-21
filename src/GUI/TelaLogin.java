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
		setBounds(100, 100, 650, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textLogin = new JTextField();
		textLogin.setBounds(200, 160, 215, 34);
		contentPane.add(textLogin);
		textLogin.setColumns(10);
		
		
		
		JLabel lblSenha = new JLabel("CPF:");
		lblSenha.setFont(new Font("Dialog", Font.BOLD, 15));
		lblSenha.setBounds(127, 167, 34, 18);
		contentPane.add(lblSenha);
		
		JLabel label = new JLabel("Senha:");
		label.setFont(new Font("Dialog", Font.BOLD, 15));
		label.setBounds(112, 256, 49, 18);
		contentPane.add(label);
		
		JLabel lblMygym = new JLabel("MyGym");
		lblMygym.setFont(new Font("Dialog", Font.BOLD, 40));
		lblMygym.setBounds(242, 25, 153, 107);
		contentPane.add(lblMygym);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(200, 249, 215, 34);
		contentPane.add(passwordField);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(242, 334, 128, 35);
		contentPane.add(btnLogin);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
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
