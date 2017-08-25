package GUI;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Negocio.beans.Aluno;
import Negocio.beans.Atividade;
import Negocio.beans.Instrutor;
import fachada.Fachada;

public class TelaGerencAtiv extends JFrame {

	private JPanel contentPane;
	private JTextField textCPFBusca;
	private JTextField textNomeAluno;
	private JTextField textEnderecoAluno;
	private JTextField textNomeInstrutor;
	private JTextField textCPFInstrutor;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaGerencAtiv frame = new TelaGerencAtiv();
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
	public TelaGerencAtiv() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);

		JLabel lblAtividades = new JLabel("Atividades");
		lblAtividades.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblAtividades.setBounds(277, 11, 106, 14);
		contentPane.add(lblAtividades);

		JLabel lblNewLabel = new JLabel("CPF");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(10, 58, 55, 14);
		contentPane.add(lblNewLabel);

		textCPFBusca = new JTextField();
		textCPFBusca.setBounds(49, 57, 152, 20);
		contentPane.add(textCPFBusca);
		textCPFBusca.setColumns(10);

		JLabel lblAluno = new JLabel("Aluno");
		lblAluno.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAluno.setBounds(100, 121, 46, 14);
		contentPane.add(lblAluno);

		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNome.setBounds(10, 151, 46, 14);
		contentPane.add(lblNome);

		textNomeAluno = new JTextField();
		textNomeAluno.setBounds(84, 150, 196, 20);
		contentPane.add(textNomeAluno);
		textNomeAluno.setColumns(10);
		textNomeAluno.setEditable(false);

		JLabel lblEndereco = new JLabel("Endereco");
		lblEndereco.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEndereco.setBounds(10, 190, 67, 14);
		contentPane.add(lblEndereco);

		textEnderecoAluno = new JTextField();
		textEnderecoAluno.setBounds(84, 189, 196, 20);
		contentPane.add(textEnderecoAluno);
		textEnderecoAluno.setColumns(10);
		textEnderecoAluno.setEditable(false);

		JLabel lblInstrutor = new JLabel("Instrutor");
		lblInstrutor.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblInstrutor.setBounds(100, 259, 89, 14);
		contentPane.add(lblInstrutor);

		JLabel lblNome_1 = new JLabel("Nome");
		lblNome_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNome_1.setBounds(10, 298, 46, 14);
		contentPane.add(lblNome_1);

		textNomeInstrutor = new JTextField();
		textNomeInstrutor.setBounds(84, 297, 196, 20);
		contentPane.add(textNomeInstrutor);
		textNomeInstrutor.setColumns(10);
		textNomeInstrutor.setEditable(false);

		JLabel lblNewLabel_1 = new JLabel("CPF");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(10, 341, 46, 14);
		contentPane.add(lblNewLabel_1);

		textCPFInstrutor = new JTextField();
		textCPFInstrutor.setBounds(84, 340, 196, 20);
		contentPane.add(textCPFInstrutor);
		textCPFInstrutor.setColumns(10);
		textCPFInstrutor.setEditable(false);

		JLabel lblPlano = new JLabel("Plano");
		lblPlano.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPlano.setBounds(470, 123, 46, 14);
		contentPane.add(lblPlano);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(376, 153, 248, 162);
		contentPane.add(scrollPane);

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(251, 56, 89, 23);
		contentPane.add(btnBuscar);
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Fachada.getInstance().conectar("gerente", "senha1");
					if(textCPFBusca.getText().length() <= 0) {
						JOptionPane.showMessageDialog(null, "CPF inválido");
					}
					Aluno a1 = Fachada.getInstance().buscaAlunoAtividade(textCPFBusca.getText());
					Instrutor i1 = Fachada.getInstance().buscaInstrutorAtividade(textCPFBusca.getText());
					List<Atividade> atividades = Fachada.getInstance().buscaAtividadesPlano(textCPFBusca.getText());

					textNomeAluno.setText(a1.getNome());
					textEnderecoAluno.setText(a1.getEndereco());
					textCPFInstrutor.setText(i1.getCpf());
					textNomeInstrutor.setText(i1.getNome());

					table = new JTable();
					DefaultTableModel modelo = new DefaultTableModel();
					table.setModel(modelo);
					modelo.addColumn("Atividade");
					modelo.addColumn("Valor");
					scrollPane.setViewportView(table);

					for (Atividade atividade : atividades) {
						modelo.addRow(new Object[] { atividade.getDescricao(), atividade.getValor() });
					}

				} catch (Exception excep) {
					//excep.printStackTrace();
					 JOptionPane.showMessageDialog(null, excep.getMessage(),
					 "ERRO", JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(251, 415, 89, 23);
		contentPane.add(btnVoltar);
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaMain telaMain = new TelaMain();
				telaMain.setVisible(true);
				dispose();
			}
		});
	}
}
