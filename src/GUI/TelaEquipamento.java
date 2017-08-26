package GUI;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Negocio.beans.Equipamento;
import Negocio.beans.Manutencao;
import fachada.Fachada;

public class TelaEquipamento extends JFrame {

	private JPanel contentPane;
	private JTable tableEquip;
	private JTable tableManun;
	private List<Equipamento> equipamentos;
	private List<Manutencao> manutencoes = new ArrayList<>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaEquipamento frame = new TelaEquipamento();
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
	public TelaEquipamento() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		setResizable(false);

		JLabel lblNewLabel = new JLabel("Equipamento");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(315, 11, 111, 24);
		contentPane.add(lblNewLabel);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(31, 51, 731, 128);
		contentPane.add(scrollPane);

		JLabel lblManutencao = new JLabel("Manutencao");
		lblManutencao.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblManutencao.setBounds(315, 255, 122, 14);
		contentPane.add(lblManutencao);

		tableEquip = new JTable();
		scrollPane.setViewportView(tableEquip);

		preecherEquipamentos();

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(41, 288, 721, 136);
		contentPane.add(scrollPane_1);

		tableManun = new JTable();
		scrollPane_1.setViewportView(tableManun);

		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.setBounds(315, 502, 89, 23);
		contentPane.add(btnAtualizar);
		btnAtualizar.setEnabled(false);
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Manutencao m1 = manutencoes.get(tableManun.getSelectedRow());
					TelaAtualizarManutencao tela = new TelaAtualizarManutencao(m1);
					tela.setVisible(true);
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Selecione uma manutencao", "Erro",
							JOptionPane.WARNING_MESSAGE);
				}
			}
		});

		JButton btnRemover = new JButton("Remover");
		btnRemover.setBounds(612, 502, 89, 23);
		contentPane.add(btnRemover);
		btnRemover.setEnabled(false);
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Manutencao m1 = manutencoes.get(tableManun.getSelectedRow());
					Fachada.getInstance().removerManutencao(String.valueOf(m1.getCod_manutencao()));
					JOptionPane.showMessageDialog(null, "Item removido com sucesso");
				} catch (SQLException ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
				} catch (Exception ex1) {
					JOptionPane.showMessageDialog(null, "Selecione uma manutencao", "Erro",
							JOptionPane.WARNING_MESSAGE);
				}
			}
		});

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(315, 206, 89, 23);
		contentPane.add(btnBuscar);
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Equipamento e1 = equipamentos.get(tableEquip.getSelectedRow());

				try {
					manutencoes = Fachada.getInstance().buscaManutencao(String.valueOf(e1.getCodigo()));
					DefaultTableModel modelo = new DefaultTableModel();
					tableManun.setModel(modelo);
					modelo.addColumn("Codigo");
					modelo.addColumn("Protocolo");
					modelo.addColumn("Valor");
					modelo.addColumn("Descricao");
					modelo.addColumn("Data manutencao");
					modelo.addColumn("Data devolucao");

					for (Manutencao manutencao : manutencoes) {
						modelo.addRow(new Object[] { manutencao.getCod_manutencao(), manutencao.getProtocolo(),
								manutencao.getValor(), manutencao.getDescricao(), manutencao.getData_manutencao(),
								manutencao.getData_devoluca() });
					}

					btnAtualizar.setEnabled(true);
					btnRemover.setEnabled(true);
				} catch (SQLException e2) {
					JOptionPane.showMessageDialog(null, e2.getMessage());
				}

			}
		});

		JButton btnVoltar = new JButton("voltar");
		btnVoltar.setBounds(38, 502, 89, 23);
		contentPane.add(btnVoltar);
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaMain telaMain = new TelaMain();
				telaMain.setVisible(true);
				dispose();
			}
		});

	}

	private void preecherEquipamentos() {
		try {
			equipamentos = Fachada.getInstance().buscaEquip(null);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		DefaultTableModel modelo = new DefaultTableModel();
		tableEquip.setModel(modelo);
		modelo.addColumn("Codigo");
		modelo.addColumn("Equipamento");
		modelo.addColumn("Descricao");
		modelo.addColumn("Filial");

		for (Equipamento equipamento : equipamentos) {
			modelo.addRow(new Object[] { equipamento.getCodigo(), equipamento.getTipo_equip(),
					equipamento.getDescricao(), equipamento.getCnpj_filial() });
		}

	}
}
