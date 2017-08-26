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
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		setResizable(false);
		
		JLabel lblMygym = new JLabel("MyGym");
		lblMygym.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblMygym.setBounds(350, 11, 103, 33);
		contentPane.add(lblMygym);
		
		JLabel lblAluno = new JLabel("Aluno");
		lblAluno.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAluno.setBounds(360, 55, 46, 14);
		contentPane.add(lblAluno);
		
		JButton btnCadastroAluno = new JButton("Cadastrar");
		btnCadastroAluno.setBounds(196, 95, 100, 25);
		contentPane.add(btnCadastroAluno);
		btnCadastroAluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaCadastroAluno telaCadastro = new TelaCadastroAluno();
				telaCadastro.setVisible(true);
				dispose();
			}
		});
		
		JButton btnInfo = new JButton("Atualizar");
		btnInfo.setBounds(452, 95, 100, 25);
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
		lblGerenciar.setBounds(327, 168, 116, 14);
		contentPane.add(lblGerenciar);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 43, 764, 88);
		contentPane.add(separator);
		
		JButton btnVendas = new JButton("Vendas");
		btnVendas.setBounds(327, 205, 100, 25);
		contentPane.add(btnVendas);
		btnVendas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaMenuVendedor telaVendas = new TelaMenuVendedor();
				telaVendas.setVisible(true);
				dispose();
			}
		});
		
		
		JButton btnEquipamento = new JButton("Equipamento");
		btnEquipamento.setBounds(515, 205, 116, 25);
		contentPane.add(btnEquipamento);
		btnEquipamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaEquipamento telaEquip = new TelaEquipamento();
				telaEquip.setVisible(true);
				dispose();
			}
		});
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 154, 764, 4);
		contentPane.add(separator_1);
		
		JButton btnAtividades = new JButton("Atividades");
		btnAtividades.setBounds(125, 205, 100, 25);
		contentPane.add(btnAtividades);
		btnAtividades.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaGerencAtiv telaAtividades = new TelaGerencAtiv();
				telaAtividades.setVisible(true);
				dispose();
			}
		});
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(10, 273, 764, 4);
		contentPane.add(separator_2);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.setBounds(327, 418, 89, 23);
		contentPane.add(btnLogout);
		
		JLabel lblFuncionarios = new JLabel("Funcionarios");
		lblFuncionarios.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblFuncionarios.setBounds(324, 280, 129, 14);
		contentPane.add(lblFuncionarios);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(322, 331, 105, 23);
		contentPane.add(btnCadastrar);
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastroFuncionario telaCadastro = new TelaCadastroFuncionario();
				telaCadastro.setVisible(true);
				dispose();
			}
		});
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(10, 394, 764, 4);
		contentPane.add(separator_3);
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaLogin telaLogin = new TelaLogin();
				telaLogin.setVisible(true);
				dispose();
			}
		});
	}
}
