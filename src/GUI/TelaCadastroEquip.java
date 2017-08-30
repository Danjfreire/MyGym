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
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Negocio.beans.Equipamento;
import fachada.Fachada;

public class TelaCadastroEquip extends JFrame {

	private JPanel contentPane;
	private JTextField textTipo;
	private JTextField textDesc;
	private JTextField textCNPJ;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroEquip frame = new TelaCadastroEquip();
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
	public TelaCadastroEquip() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 350, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		setResizable(false);
		
		JLabel lblTipoDeEquipamento = new JLabel("Tipo de equipamento");
		lblTipoDeEquipamento.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTipoDeEquipamento.setBounds(10, 11, 145, 14);
		contentPane.add(lblTipoDeEquipamento);
		
		textTipo = new JTextField();
		textTipo.setBounds(10, 36, 314, 20);
		contentPane.add(textTipo);
		textTipo.setColumns(10);
		
		JLabel lblDescricao = new JLabel("Descricao");
		lblDescricao.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDescricao.setBounds(10, 85, 66, 14);
		contentPane.add(lblDescricao);
		
		textDesc = new JTextField();
		textDesc.setBounds(10, 110, 314, 20);
		contentPane.add(textDesc);
		textDesc.setColumns(10);
		
		JLabel lblCnpjFilial = new JLabel("CNPJ Filial");
		lblCnpjFilial.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCnpjFilial.setBounds(10, 165, 97, 14);
		contentPane.add(lblCnpjFilial);
		
		textCNPJ = new JTextField();
		textCNPJ.setBounds(10, 190, 314, 20);
		contentPane.add(textCNPJ);
		textCNPJ.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(119, 272, 107, 23);
		contentPane.add(btnCadastrar);
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
				Equipamento e1 = new Equipamento(1, textTipo.getText(), textDesc.getText(), textCNPJ.getText());
				Fachada.getInstance().cadastrarEquip(e1);
				TelaEquipamento tela = new TelaEquipamento();
				JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso");
				dispose();
				tela.setVisible(true);
				}catch(SQLException ex){
					JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}

}
