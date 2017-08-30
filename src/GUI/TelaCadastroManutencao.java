package GUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Negocio.beans.Equipamento;
import Negocio.beans.Manutencao;
import fachada.Fachada;

public class TelaCadastroManutencao extends JFrame {

	private JPanel contentPane;
	private JTextField textProtocolo;
	private JTextField textDesc;
	private JTextField textValor;
	private JTextField textDataM;
	private JTextField textDataD;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					TelaCadastroManutencao frame = new TelaCadastroManutencao();
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
	public TelaCadastroManutencao(Equipamento e1) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 350, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		setResizable(false);
		
		JLabel lblProtocolo = new JLabel("Protocolo");
		lblProtocolo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblProtocolo.setBounds(10, 11, 70, 14);
		contentPane.add(lblProtocolo);
		
		textProtocolo = new JTextField();
		textProtocolo.setBounds(10, 36, 314, 20);
		contentPane.add(textProtocolo);
		textProtocolo.setColumns(10);
		
		JLabel lblDescricao = new JLabel("Descricao");
		lblDescricao.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDescricao.setBounds(10, 84, 70, 14);
		contentPane.add(lblDescricao);
		
		textDesc = new JTextField();
		textDesc.setBounds(10, 109, 314, 20);
		contentPane.add(textDesc);
		textDesc.setColumns(10);
		
		JLabel lblValor = new JLabel("Valor");
		lblValor.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblValor.setBounds(10, 158, 46, 14);
		contentPane.add(lblValor);
		
		textValor = new JTextField();
		textValor.setBounds(10, 183, 314, 20);
		contentPane.add(textValor);
		textValor.setColumns(10);
		
		JLabel lblDataManutencao = new JLabel("Data manutencao");
		lblDataManutencao.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDataManutencao.setBounds(10, 241, 120, 14);
		contentPane.add(lblDataManutencao);
		
		textDataM = new JTextField();
		textDataM.setBounds(10, 266, 129, 20);
		contentPane.add(textDataM);
		textDataM.setColumns(10);
		
		JLabel lblDataDevolucao = new JLabel("Data devolucao");
		lblDataDevolucao.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDataDevolucao.setBounds(182, 241, 120, 14);
		contentPane.add(lblDataDevolucao);
		
		textDataD = new JTextField();
		textDataD.setBounds(182, 266, 142, 20);
		contentPane.add(textDataD);
		textDataD.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(112, 332, 103, 33);
		contentPane.add(btnCadastrar);
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					Manutencao m1 = new Manutencao(1, Double.parseDouble(textValor.getText()), textProtocolo.getText(), textDesc.getText(), textDataM.getText(),textDataD.getText());
					Fachada.getInstance().cadastrarManutencao(m1, e1.getCodigo());
					JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso");
					TelaEquipamento tela = new TelaEquipamento();
					tela.setVisible(true);
					dispose();
				}catch(SQLException ex){
					JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}

}
