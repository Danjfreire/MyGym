package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Negocio.beans.Aluno;
import Negocio.beans.Instrutor;
import fachada.Fachada;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JSeparator;

public class TelaCadastroFuncionario extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroFuncionario frame = new TelaCadastroFuncionario();
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
	public TelaCadastroFuncionario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);

		JLabel lblCadastroFuncionario = new JLabel("Cadastro funcionario");
		lblCadastroFuncionario.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCadastroFuncionario.setBounds(247, 11, 170, 14);
		contentPane.add(lblCadastroFuncionario);

		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNome.setBounds(27, 63, 46, 14);
		contentPane.add(lblNome);

		JLabel lblNewLabel = new JLabel("CPF");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(27, 98, 46, 14);
		contentPane.add(lblNewLabel);

		JLabel lblSexo = new JLabel("Sexo");
		lblSexo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSexo.setBounds(27, 133, 46, 14);
		contentPane.add(lblSexo);

		JRadioButton rdbtnFemale = new JRadioButton("F");
		buttonGroup.add(rdbtnFemale);
		rdbtnFemale.setBounds(93, 130, 46, 23);
		contentPane.add(rdbtnFemale);

		JRadioButton rdbtnMale = new JRadioButton("M");
		buttonGroup.add(rdbtnMale);
		rdbtnMale.setBounds(93, 163, 39, 23);
		contentPane.add(rdbtnMale);

		JTextArea textNome = new JTextArea();
		textNome.setBounds(83, 59, 217, 23);
		contentPane.add(textNome);

		JTextArea textCPF = new JTextArea();
		textCPF.setBounds(83, 94, 217, 23);
		contentPane.add(textCPF);

		JLabel lblDataContrato = new JLabel("Data contrato");
		lblDataContrato.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDataContrato.setBounds(27, 193, 102, 14);
		contentPane.add(lblDataContrato);

		JTextArea textData = new JTextArea();
		textData.setBounds(125, 189, 137, 23);
		contentPane.add(textData);

		JLabel lblNewLabel_1 = new JLabel("CNPJ Filial");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(27, 236, 89, 14);
		contentPane.add(lblNewLabel_1);

		JTextArea textCNPJ = new JTextArea();
		textCNPJ.setBounds(125, 232, 137, 23);
		contentPane.add(textCNPJ);

		JLabel lblNewLabel_2 = new JLabel("Salario");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(27, 308, 46, 14);
		contentPane.add(lblNewLabel_2);

		JTextArea textSalario = new JTextArea();
		textSalario.setBounds(125, 304, 137, 23);
		contentPane.add(textSalario);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(27, 414, 89, 23);
		contentPane.add(btnVoltar);
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaMain telaMain = new TelaMain();
				telaMain.setVisible(true);
				dispose();
			}
		});

		JLabel lblFuncao = new JLabel("Funcao");
		lblFuncao.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblFuncao.setBounds(419, 64, 46, 14);
		contentPane.add(lblFuncao);

		JRadioButton rdbtnInstrutor = new JRadioButton("Instrutor");
		buttonGroup_1.add(rdbtnInstrutor);
		rdbtnInstrutor.setBounds(419, 95, 109, 23);
		contentPane.add(rdbtnInstrutor);

		JRadioButton rdbtnRecepcionista = new JRadioButton("Recepcionista");
		buttonGroup_1.add(rdbtnRecepcionista);
		rdbtnRecepcionista.setBounds(419, 121, 109, 23);
		contentPane.add(rdbtnRecepcionista);

		JRadioButton rdbtnManutencao = new JRadioButton("Manutencao");
		buttonGroup_1.add(rdbtnManutencao);
		rdbtnManutencao.setBounds(419, 147, 109, 23);
		contentPane.add(rdbtnManutencao);

		JRadioButton rdbtnVendas = new JRadioButton("Vendas");
		buttonGroup_1.add(rdbtnVendas);
		rdbtnVendas.setBounds(419, 173, 109, 23);
		contentPane.add(rdbtnVendas);

		JLabel lblComplemento = new JLabel("Complemento");
		lblComplemento.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblComplemento.setBounds(358, 266, 89, 14);
		contentPane.add(lblComplemento);

		JTextArea textComp = new JTextArea();
		textComp.setBounds(461, 262, 137, 23);
		contentPane.add(textComp);

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(469, 414, 89, 23);
		contentPane.add(btnCadastrar);
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					char sexo = 'C';
					if (rdbtnFemale.isSelected())
						sexo = 'F';
					else if (rdbtnMale.isSelected())
						sexo = 'M';

					if (sexo == 'C')
						JOptionPane.showMessageDialog(null, "Selecione o sexo", "Falha no cadastro",
								JOptionPane.WARNING_MESSAGE);

					if (rdbtnInstrutor.isSelected()) {
						Instrutor i1 = new Instrutor(textCPF.getText(), textNome.getText(), sexo, textData.getText(),
								Double.parseDouble(textSalario.getText()), textCNPJ.getText(), textComp.getText());
						Fachada.getInstance().cadastrarInstrutor(i1);
						JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso");
						dispose();
					} else {
						JOptionPane.showMessageDialog(null, "Só é possível cadastrar instrutores no momento",
								"Falha no cadastro", JOptionPane.WARNING_MESSAGE);
					}

				} catch (Exception excep) {
					// excep.printStackTrace();
					JOptionPane.showMessageDialog(null, excep.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
				}
			}
		});

	}
}
