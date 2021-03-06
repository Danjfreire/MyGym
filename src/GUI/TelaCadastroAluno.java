package GUI;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.SQLException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import Negocio.beans.Aluno;
import Negocio.beans.Dependente;
import fachada.Fachada;

public class TelaCadastroAluno extends JFrame {

	private JPanel contentPane;
	private JTextField textNome;
	private JTextField textCPF;
	private JTextField textEndereco;
	private JTextField textData;
	private JTextField textIdade;
	private File image;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroAluno frame = new TelaCadastroAluno();
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
	public TelaCadastroAluno() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);

		JLabel lblControleDeFuncionrios = new JLabel("Cadastrar aluno");
		lblControleDeFuncionrios.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblControleDeFuncionrios.setBounds(309, 11, 148, 25);
		contentPane.add(lblControleDeFuncionrios);

		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNome.setBounds(31, 137, 46, 14);
		contentPane.add(lblNome);

		textNome = new JTextField();
		textNome.setBounds(101, 136, 218, 20);
		contentPane.add(textNome);
		textNome.setColumns(10);

		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCpf.setBounds(31, 175, 46, 14);
		contentPane.add(lblCpf);

		textCPF = new JTextField();
		textCPF.setBounds(101, 174, 218, 20);
		contentPane.add(textCPF);
		textCPF.setColumns(10);

		JLabel lblEndereco = new JLabel("Endereco");
		lblEndereco.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEndereco.setBounds(31, 213, 73, 14);
		contentPane.add(lblEndereco);

		textEndereco = new JTextField();
		textEndereco.setBounds(101, 212, 218, 20);
		contentPane.add(textEndereco);
		textEndereco.setColumns(10);

		JLabel lblDataNascimento = new JLabel("Data nascimento");
		lblDataNascimento.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDataNascimento.setBounds(31, 271, 138, 14);
		contentPane.add(lblDataNascimento);

		textData = new JTextField();
		textData.setBounds(31, 296, 118, 20);
		contentPane.add(textData);
		textData.setColumns(10);

		JLabel lblIdade = new JLabel("Idade");
		lblIdade.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblIdade.setBounds(233, 273, 46, 14);
		contentPane.add(lblIdade);

		textIdade = new JTextField();
		textIdade.setBounds(237, 296, 46, 20);
		contentPane.add(textIdade);
		textIdade.setColumns(10);
		
		JLabel imagem = new JLabel("");
		imagem.setBounds(456, 68, 209, 217);
		contentPane.add(imagem);
		
		JButton btnFoto = new JButton("Foto");
		btnFoto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					JFileChooser chooser = new JFileChooser();
					FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & GIF Images", "jpg", "gif");
					chooser.setFileFilter(filter);
					chooser.showOpenDialog(null);
					image = new File(chooser.getSelectedFile().getAbsolutePath());
					BufferedImage ibage = ImageIO.read(image);
					BufferedImage img = new BufferedImage(207, 174, BufferedImage.TYPE_INT_RGB);
					img.getGraphics().drawImage(ibage, 0, 0, 207, 174, null);
					imagem.setIcon(new ImageIcon(img));
					
					
				} catch (Exception ex) {

				}
			}
		});
		btnFoto.setBounds(524, 307, 89, 23);
		contentPane.add(btnFoto);

		JCheckBox chckbxDependente = new JCheckBox("Dependente");
		chckbxDependente.setBounds(137, 95, 97, 23);
		contentPane.add(chckbxDependente);
		chckbxDependente.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (chckbxDependente.isSelected()) {
					textEndereco.setEnabled(false);
					textIdade.setEnabled(false);
					btnFoto.setEnabled(false);
				} else {
					textEndereco.setEnabled(true);
					textIdade.setEnabled(true);
					btnFoto.setEnabled(true);
				}

			}
		});

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(555, 498, 110, 35);
		contentPane.add(btnCadastrar);
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (!chckbxDependente.isSelected()) {
						//InputStream foto = new FileInputStream(image);
						Aluno a1 = new Aluno(textCPF.getText(), textNome.getText(),
								Integer.parseInt(textIdade.getText()), textEndereco.getText(), textData.getText(), 1,image);
						Fachada.getInstance().CadastrarAluno(a1);
					} else {
						Dependente d1 = new Dependente(textCPF.getText(), textNome.getText(), textData.getText());
						Fachada.getInstance().CadastrarDependente(d1);
					}
					JOptionPane.showMessageDialog(null, "Cadastro efetuado com sucesso");
					TelaMain tela = new TelaMain();
					tela.setVisible(true);
					dispose();
				} catch (SQLException excep) {
					JOptionPane.showMessageDialog(null, excep.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
				} catch (Exception excep2) {
					JOptionPane.showMessageDialog(null, excep2.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(63, 498, 110, 35);
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
