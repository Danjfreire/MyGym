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
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaMain extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					TelaMain frame = new TelaMain();
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
	public TelaMain() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel lblMygym = new JLabel("MyGym");
		lblMygym.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblMygym.setBounds(284, 11, 103, 33);
		contentPane.add(lblMygym);
		
		JLabel lblAluno = new JLabel("Aluno");
		lblAluno.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAluno.setBounds(294, 55, 46, 14);
		contentPane.add(lblAluno);
		
		JButton btnCadastroAluno = new JButton("Cadastrar");
		btnCadastroAluno.setBounds(149, 95, 100, 25);
		contentPane.add(btnCadastroAluno);
		btnCadastroAluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaCadastroAluno telaCadastro = new TelaCadastroAluno();
				telaCadastro.setVisible(true);
				dispose();
			}
		});
		
		JButton btnInfo = new JButton("Info");
		btnInfo.setBounds(384, 95, 100, 25);
		contentPane.add(btnInfo);
		btnInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaAtualizarAluno telaInfo = new TelaAtualizarAluno();
				telaInfo.setVisible(true);
				dispose();
			}
		});
		
		JLabel lblGerenciar = new JLabel("Gerenciamento");
		lblGerenciar.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblGerenciar.setBounds(271, 169, 116, 14);
		contentPane.add(lblGerenciar);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 43, 614, 88);
		contentPane.add(separator);
		
		JButton btnVendas = new JButton("Vendas");
		btnVendas.setBounds(271, 205, 100, 25);
		contentPane.add(btnVendas);
		btnVendas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaMenuVendedor telaVendas = new TelaMenuVendedor();
				telaVendas.setVisible(true);
				dispose();
			}
		});
		
		
		JButton btnEquipamento = new JButton("Equipamento");
		btnEquipamento.setBounds(469, 205, 116, 25);
		contentPane.add(btnEquipamento);
		btnEquipamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaEquipamento telaEquip = new TelaEquipamento();
				telaEquip.setVisible(true);
				dispose();
			}
		});
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 154, 614, 4);
		contentPane.add(separator_1);
		
		JButton btnAtividades = new JButton("Atividades");
		btnAtividades.setBounds(66, 206, 100, 25);
		contentPane.add(btnAtividades);
		btnAtividades.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaGerencAtiv telaAtividades = new TelaGerencAtiv();
				telaAtividades.setVisible(true);
				dispose();
			}
		});
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(10, 273, 614, 4);
		contentPane.add(separator_2);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.setBounds(284, 415, 89, 23);
		contentPane.add(btnLogout);
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaLogin telaLogin = new TelaLogin();
				telaLogin.setVisible(true);
				dispose();
			}
		});
	}
}
