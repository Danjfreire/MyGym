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
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Negocio.beans.Aluno;
import fachada.Fachada;

public class TelaAtualizarAluno extends JFrame {

	private JPanel contentPane;
	private JTextField textCPF;
	private JTextField textNome;
	private JTextField textEndereco;
	private JTextField textDataNasc;
	private JTextField textIdade;
	private List<Aluno> resultado;
	private int indice = 0;
	private Aluno atual;
	private JButton btnPrevious;
	private JButton btnNext;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAtualizarAluno frame = new TelaAtualizarAluno();
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
	public TelaAtualizarAluno() {
		try {
			resultado = Fachada.getInstance().buscaAluno("");
			atual = resultado.get(indice);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}catch (Exception e2){
			e2.printStackTrace();
		}

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);

		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCpf.setBounds(10, 57, 46, 14);
		contentPane.add(lblCpf);

		textCPF = new JTextField();
		textCPF.setBounds(86, 56, 230, 20);
		contentPane.add(textCPF);
		textCPF.setColumns(10);
		//textCPF.setText(atual.getCpf());
		textCPF.setEditable(false);

		JLabel lblNewLabel = new JLabel("Nome");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(10, 107, 46, 14);
		contentPane.add(lblNewLabel);

		textNome = new JTextField();
		textNome.setBounds(86, 106, 230, 20);
		contentPane.add(textNome);
		textNome.setColumns(10);
		//textNome.setText(atual.getNome());

		JLabel lblNewLabel_1 = new JLabel("Endereco");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(10, 161, 60, 14);
		contentPane.add(lblNewLabel_1);

		textEndereco = new JTextField();
		textEndereco.setBounds(86, 160, 230, 20);
		contentPane.add(textEndereco);
		textEndereco.setColumns(10);
		//textEndereco.setText(atual.getEndereco());

		JLabel lblDataNascimento = new JLabel("Data nascimento");
		lblDataNascimento.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDataNascimento.setBounds(10, 240, 115, 14);
		contentPane.add(lblDataNascimento);

		textDataNasc = new JTextField();
		textDataNasc.setBounds(10, 265, 115, 20);
		contentPane.add(textDataNasc);
		textDataNasc.setColumns(10);
		//textDataNasc.setText(atual.getData_nasc());

		JLabel lblIdade = new JLabel("Idade");
		lblIdade.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblIdade.setBounds(216, 242, 46, 14);
		contentPane.add(lblIdade);

		textIdade = new JTextField();
		textIdade.setBounds(216, 265, 46, 20);
		contentPane.add(textIdade);
		textIdade.setColumns(10);
		//textIdade.setText(String.valueOf(atual.getIdade()));
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAtualizar.setBounds(467, 399, 110, 35);
		contentPane.add(btnAtualizar);
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Aluno a1 = new Aluno(textCPF.getText(), textNome.getText(), Integer.parseInt(textIdade.getText()),
							textEndereco.getText(), textDataNasc.getText(), 1);
					if (!Fachada.getInstance().atualizarAluno(a1)) {
						JOptionPane.showMessageDialog(null, "Atualização efetuada com sucesso");
					}
				} catch (SQLException excep) {
					excep.printStackTrace();
					 JOptionPane.showMessageDialog(null, excep.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
				}catch(Exception excep2){
					 JOptionPane.showMessageDialog(null, excep2.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		JButton btnRemover = new JButton("Remover");
		btnRemover.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnRemover.setBounds(257, 399, 110, 35);
		contentPane.add(btnRemover);
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					Fachada.getInstance().removerAluno(textCPF.getText());
					JOptionPane.showMessageDialog(null, "Remoção efetuada com sucesso");
					resultado.remove(indice);
				}catch(SQLException e){
					e.printStackTrace();
				}
			}
		});

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnVoltar.setBounds(51, 399, 110, 35);
		contentPane.add(btnVoltar);
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaMain telaMain = new TelaMain();
				telaMain.setVisible(true);
				dispose();
			}
		});

		btnPrevious = new JButton("Anterior");
		btnPrevious.setBounds(191, 330, 100, 25);
		contentPane.add(btnPrevious);
		btnPrevious.setEnabled(false);
		btnPrevious.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				indice--;
				preencherCampos(resultado.get(indice));
			}

		});
		
		
		btnNext = new JButton("Proximo");
		btnNext.setBounds(301, 330, 100, 25);
		contentPane.add(btnNext);
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				indice++;
				preencherCampos(resultado.get(indice));
			}

		});

		preencherCampos(resultado.get(indice));
	}
	
	void preencherCampos(Aluno a1){
		textCPF.setText(a1.getCpf());
		textNome.setText(a1.getNome());
		textEndereco.setText(a1.getEndereco());
		textDataNasc.setText(a1.getData_nasc());
		textIdade.setText(String.valueOf(a1.getIdade()));
		
		if (indice == resultado.size() - 1)
			btnNext.setEnabled(false);
		else
			btnNext.setEnabled(true);
		
		if (indice == 0)
			btnPrevious.setEnabled(false);
		else
			btnPrevious.setEnabled(true);
		
		
	}

}
