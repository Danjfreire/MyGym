package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import fachada.Fachada;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class TelaCadastrarPlano extends JFrame {

	private JPanel contentPane;
	private JTextField textCPF;
	private JTextField textDataInicio;
	private JTextField textDataFim;
	private JTextField textContrato;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					TelaCadastrarPlano frame = new TelaCadastrarPlano();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public TelaCadastrarPlano(String cpfAluno) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 350, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCpf.setBounds(10, 11, 46, 14);
		contentPane.add(lblCpf);
		
		textCPF = new JTextField();
		textCPF.setBounds(10, 36, 314, 20);
		contentPane.add(textCPF);
		textCPF.setColumns(10);
		
		JLabel lblDataInicio = new JLabel("Data inicio");
		lblDataInicio.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDataInicio.setBounds(10, 89, 63, 14);
		contentPane.add(lblDataInicio);
		
		textDataInicio = new JTextField();
		textDataInicio.setBounds(10, 114, 129, 20);
		contentPane.add(textDataInicio);
		textDataInicio.setColumns(10);
		
		JLabel lblDataFim = new JLabel("Data Final");
		lblDataFim.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDataFim.setBounds(198, 89, 68, 14);
		contentPane.add(lblDataFim);
		
		textDataFim = new JTextField();
		textDataFim.setBounds(198, 114, 126, 20);
		contentPane.add(textDataFim);
		textDataFim.setColumns(10);
		
		JLabel lblCodigoContrato = new JLabel("Codigo contrato");
		lblCodigoContrato.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCodigoContrato.setBounds(10, 172, 129, 14);
		contentPane.add(lblCodigoContrato);
		
		textContrato = new JTextField();
		textContrato.setBounds(10, 197, 314, 20);
		contentPane.add(textContrato);
		textContrato.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					Fachada.getInstance().cadastrarPlano(cpfAluno, textDataInicio.getText(), textDataFim.getText());
					dispose();
				}catch(SQLException ex){
					JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnCadastrar.setBounds(104, 280, 109, 47);
		contentPane.add(btnCadastrar);
	}

}
