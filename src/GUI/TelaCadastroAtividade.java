package GUI;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Negocio.beans.Especialidade;
import Negocio.beans.Instrutor;
import Negocio.beans.Plano;
import fachada.Fachada;

public class TelaCadastroAtividade extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTable table;
	List<Instrutor>instrutores;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					TelaCadastroAtividade frame = new TelaCadastroAtividade();
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
	public TelaCadastroAtividade(Plano p1) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel lblAtividades = new JLabel("Atividades");
		lblAtividades.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAtividades.setBounds(10, 23, 98, 14);
		contentPane.add(lblAtividades);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(343, 72, 198, 136);
		contentPane.add(scrollPane);
		
		JRadioButton rdbtnMusculacao = new JRadioButton("Musculacao");
		buttonGroup.add(rdbtnMusculacao);
		rdbtnMusculacao.setBounds(6, 56, 109, 23);
		contentPane.add(rdbtnMusculacao);
		rdbtnMusculacao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					Especialidade esp = new Especialidade(rdbtnMusculacao.getText());
					instrutores = Fachada.getInstance().buscarInstrutores(esp);
					table = new JTable();
					DefaultTableModel modelo = new DefaultTableModel();
					table.setModel(modelo);
					modelo.addColumn("Instrutor");
					scrollPane.setViewportView(table);
					
					for (Instrutor instrutor : instrutores) {
						modelo.addRow(new Object[]{instrutor.getNome()});
					}
					
				}catch(SQLException ex){
					
				}catch(Exception ex){
					
				}
			}
		});
		
		JRadioButton rdbtnCrossfit = new JRadioButton("CrossFit");
		buttonGroup.add(rdbtnCrossfit);
		rdbtnCrossfit.setBounds(6, 82, 109, 23);
		contentPane.add(rdbtnCrossfit);
		
		JRadioButton rdbtnZumba = new JRadioButton("Zumba");
		buttonGroup.add(rdbtnZumba);
		rdbtnZumba.setBounds(6, 107, 109, 23);
		contentPane.add(rdbtnZumba);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Boxe");
		buttonGroup.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setBounds(6, 133, 109, 23);
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnKarate = new JRadioButton("Karate");
		buttonGroup.add(rdbtnKarate);
		rdbtnKarate.setBounds(6, 159, 109, 23);
		contentPane.add(rdbtnKarate);
		
		JRadioButton rdbtnNatacao = new JRadioButton("Natacao");
		buttonGroup.add(rdbtnNatacao);
		rdbtnNatacao.setBounds(6, 185, 109, 23);
		contentPane.add(rdbtnNatacao);
		
		JRadioButton rdbtnSpinning = new JRadioButton("Spinning");
		buttonGroup.add(rdbtnSpinning);
		rdbtnSpinning.setBounds(6, 211, 109, 23);
		contentPane.add(rdbtnSpinning);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Yoga");
		buttonGroup.add(rdbtnNewRadioButton_1);
		rdbtnNewRadioButton_1.setBounds(6, 237, 109, 23);
		contentPane.add(rdbtnNewRadioButton_1);
		
		JButton btnConcluir = new JButton("Concluir");
		btnConcluir.setBounds(215, 303, 116, 34);
		contentPane.add(btnConcluir);
		
		JLabel lblInstrutores = new JLabel("Instrutores");
		lblInstrutores.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblInstrutores.setBounds(357, 25, 149, 14);
		contentPane.add(lblInstrutores);
				
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setBounds(392, 223, 89, 23);
		contentPane.add(btnAdicionar);
	}
}
