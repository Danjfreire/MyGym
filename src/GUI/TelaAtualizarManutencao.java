package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Negocio.beans.Manutencao;
import fachada.Fachada;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class TelaAtualizarManutencao extends JFrame {

	private JPanel contentPane;
	private JTextField textCodigo;
	private JTextField textValor;
	private JTextField textProtocolo;
	private JTextField textDescricao;
	private JTextField textDataM;
	private JTextField textDataD;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					TelaAtualizarManutencao frame = new TelaAtualizarManutencao();
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
	public TelaAtualizarManutencao(Manutencao m1) {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 350, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel lblCodigo = new JLabel("Codigo");
		lblCodigo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCodigo.setBounds(10, 21, 46, 14);
		contentPane.add(lblCodigo);
		
		textCodigo = new JTextField();
		textCodigo.setBounds(10, 39, 314, 20);
		contentPane.add(textCodigo);
		textCodigo.setColumns(10);
		textCodigo.setText(String.valueOf(m1.getCod_manutencao()));
		textCodigo.setEditable(false);
		
		JLabel lblValor = new JLabel("Valor");
		lblValor.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblValor.setBounds(10, 70, 46, 14);
		contentPane.add(lblValor);
		
		textValor = new JTextField();
		textValor.setBounds(10, 95, 314, 20);
		contentPane.add(textValor);
		textValor.setColumns(10);
		textValor.setText(String.valueOf(m1.getValor()));
		
		JLabel lblProtocolo = new JLabel("Protocolo");
		lblProtocolo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblProtocolo.setBounds(10, 126, 69, 14);
		contentPane.add(lblProtocolo);
		
		textProtocolo = new JTextField();
		textProtocolo.setBounds(10, 151, 314, 20);
		contentPane.add(textProtocolo);
		textProtocolo.setColumns(10);
		textProtocolo.setText(m1.getProtocolo());
		
		JLabel lblDescricao = new JLabel("Descricao");
		lblDescricao.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDescricao.setBounds(10, 182, 69, 14);
		contentPane.add(lblDescricao);
		
		textDescricao = new JTextField();
		textDescricao.setBounds(10, 207, 314, 20);
		contentPane.add(textDescricao);
		textDescricao.setColumns(10);
		textDescricao.setText(m1.getDescricao());
		
		JLabel lblDataManutencao = new JLabel("Data manutencao");
		lblDataManutencao.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDataManutencao.setBounds(10, 238, 126, 14);
		contentPane.add(lblDataManutencao);
		
		textDataM = new JTextField();
		textDataM.setBounds(10, 262, 138, 20);
		contentPane.add(textDataM);
		textDataM.setColumns(10);
		textDataM.setText(m1.getData_manutencao());
		
		JLabel lblDataDevolucao = new JLabel("Data devolucao");
		lblDataDevolucao.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDataDevolucao.setBounds(191, 238, 133, 14);
		contentPane.add(lblDataDevolucao);
		
		textDataD = new JTextField();
		textDataD.setBounds(191, 262, 133, 20);
		contentPane.add(textDataD);
		textDataD.setColumns(10);
		textDataD.setText(m1.getData_devoluca());
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.setBounds(123, 333, 89, 23);
		contentPane.add(btnAtualizar);
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					Manutencao m2 = new Manutencao(Integer.parseInt(textCodigo.getText()), Double.parseDouble(textValor.getText()), 
							textProtocolo.getText(), textDescricao.getText(), textDataM.getText(), textDataD.getText());
					if (!Fachada.getInstance().atualizarManutencao(m2)){
						JOptionPane.showMessageDialog(null, "Manutencao atualizada com sucesso");
						dispose();
					}
				}catch(SQLException ex){
					JOptionPane.showMessageDialog(null, ex.getMessage());
				}
			}
		});
	}
}
