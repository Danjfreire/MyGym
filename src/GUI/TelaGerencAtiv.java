package GUI;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
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
import Negocio.beans.Plano;
import fachada.Fachada;

public class TelaGerencAtiv extends JFrame {

	private JPanel contentPane;
	private JTextField textCPFBusca;
	private JTextField textNomeAluno;
	private JTextField textEnderecoAluno;
	private JTable table;
	private JTable table_1;
	List<Plano> planos;
	List<Atividade> atividades;
	Plano planoAtual;

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
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		setResizable(false);
		JLabel lblAtividades = new JLabel("Atividades");
		lblAtividades.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblAtividades.setBounds(347, 11, 106, 14);
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

		JLabel lblPlano = new JLabel("Plano");
		lblPlano.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPlano.setBounds(569, 33, 46, 14);
		contentPane.add(lblPlano);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(432, 58, 317, 89);
		contentPane.add(scrollPane);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(432, 267, 317, 162);
		contentPane.add(scrollPane_1);
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.setBounds(432, 493, 106, 39);
		contentPane.add(btnRemover);
		btnRemover.setEnabled(false);
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					Atividade a1 = atividades.get(table_1.getSelectedRow());
					Fachada.getInstance().removerAtividadePlano(a1);
					JOptionPane.showMessageDialog(null, "Atividade removida com sucesso");
				}catch(SQLException ex){
					JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
				}catch(Exception ex1){
					JOptionPane.showMessageDialog(null, "Selecione uma atividade", "Erro", JOptionPane.WARNING_MESSAGE);
				}
				
			}
		});

		JButton btnNovaAtividade = new JButton("Nova atividade");
		btnNovaAtividade.setBounds(643, 493, 106, 39);
		contentPane.add(btnNovaAtividade);
		btnNovaAtividade.setEnabled(false);
		btnNovaAtividade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					TelaCadastroAtividade tela = new TelaCadastroAtividade(planoAtual, textCPFBusca.getText());
					tela.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		JButton btnExibir = new JButton("Exibir");
		btnExibir.setBounds(552, 181, 89, 23);
		contentPane.add(btnExibir);
		btnExibir.setEnabled(false);
		btnExibir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Plano p1 = planos.get(table.getSelectedRow());
					planoAtual = p1;
					atividades = Fachada.getInstance().buscaAtividadesPlano(p1);

					table_1 = new JTable();
					table_1.setBounds(432, 267, 317, 162);
					contentPane.add(table_1);
					scrollPane_1.setViewportView(table_1);
					DefaultTableModel modelo = new DefaultTableModel();
					table_1.setModel(modelo);
					modelo.addColumn("Atividade");
					modelo.addColumn("Instrutor");
					
					btnRemover.setEnabled(true);
					btnNovaAtividade.setEnabled(true);

					for (int i = 0; i < atividades.size(); i++) {
						Instrutor i1 = Fachada.getInstance().buscaInstrutorAtividade(p1.getCodigo(),
								atividades.get(i).getDescricao());
						if (i1 != null)
							modelo.addRow(new Object[] { atividades.get(i).getDescricao(), i1.getNome() });
					}

				} catch (SQLException ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
				} catch (Exception ex1) {
					//ex1.printStackTrace();
					 JOptionPane.showMessageDialog(null, ex1.getMessage(),
					 "Erro", JOptionPane.WARNING_MESSAGE);
				}
			}
		});

		JButton btnNovoPlano = new JButton("Novo plano");
		btnNovoPlano.setBounds(120, 263, 106, 39);
		contentPane.add(btnNovoPlano);
		btnNovoPlano.setEnabled(false);
		btnNovoPlano.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaCadastrarPlano tela = new TelaCadastrarPlano(textCPFBusca.getText());
				tela.setVisible(true);
			}
		});

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(251, 56, 89, 23);
		contentPane.add(btnBuscar);
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (textCPFBusca.getText().length() < 11 ) {
						JOptionPane.showMessageDialog(null, "CPF inválido");
					}
					Aluno a1 = Fachada.getInstance().buscaAlunoAtividade(textCPFBusca.getText());
					// Instrutor i1 =
					// Fachada.getInstance().buscaInstrutorAtividade(textCPFBusca.getText());
					planos = Fachada.getInstance().buscaPlano(textCPFBusca.getText());

					textNomeAluno.setText(a1.getNome());
					textEnderecoAluno.setText(a1.getEndereco());

					table = new JTable();
					DefaultTableModel modelo = new DefaultTableModel();
					table.setModel(modelo);
					modelo.addColumn("Codigo");
					modelo.addColumn("Data inicio");
					modelo.addColumn("Data fim");
					scrollPane.setViewportView(table);

					for (Plano plan : planos) {
						modelo.addRow(new Object[] { plan.getCodigo(), plan.getData_inicio(), plan.getData_fim() });
					}
					btnExibir.setEnabled(true);
					btnNovoPlano.setEnabled(true);

				} catch (Exception excep) {
					excep.printStackTrace();
					JOptionPane.showMessageDialog(null, excep.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(120, 493, 106, 39);
		contentPane.add(btnVoltar);
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaMain telaMain = new TelaMain();
				telaMain.setVisible(true);
				dispose();
			}
		});

		JLabel lblAtividades_1 = new JLabel("Atividades");
		lblAtividades_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAtividades_1.setBounds(552, 230, 89, 14);
		contentPane.add(lblAtividades_1);

	}
}
