package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import controller.*;

public class inscricaoCRUD extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtCodDisciplina;
	private JTextField txtCPFprofessor;
	private JTextField txtCodProcesso;
	
	JPanel MainArea;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					inscricaoCRUD frame = new inscricaoCRUD();
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
	public inscricaoCRUD() {
		validacaoController vC = new validacaoController();
		setTitle("Inscrições\r\n");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnVolta = new JButton("<- Voltar");
		btnVolta.setBounds(10, 10, 91, 20);
		btnVolta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				MainFrame.main(null);
			}
		});
		contentPane.add(btnVolta);
		
		
		MainArea = new JPanel();
		MainArea.setBorder(UIManager.getBorder("ComboBox.editorBorder"));
		MainArea.setBackground(new Color(220, 220, 220));
		MainArea.setBounds(10, 40, 866, 413);
		MainArea.setLayout(null);
		contentPane.add(MainArea);
		
		txtCodDisciplina = new JTextField();
		txtCodDisciplina.setFont(new Font("Arial", Font.PLAIN, 12));
		txtCodDisciplina.setBounds(147, 170, 150, 25);
		MainArea.add(txtCodDisciplina);
		txtCodDisciplina.setColumns(10);
		
		txtCPFprofessor = new JTextField();
		txtCPFprofessor.setColumns(10);
		txtCPFprofessor.setBounds(147, 246, 150, 25);
		MainArea.add(txtCPFprofessor);
		
		txtCodProcesso = new JTextField();
		txtCodProcesso.setColumns(10);
		txtCodProcesso.setBounds(147, 104, 150, 25);
		MainArea.add(txtCodProcesso);		
		
		JLabel lblCodigoDisciplina = new JLabel("Código Disciplina:");
		lblCodigoDisciplina.setLabelFor(txtCodDisciplina);
		lblCodigoDisciplina.setFont(new Font("Arial", Font.BOLD, 14));
		lblCodigoDisciplina.setBounds(10, 175, 127, 12);
		MainArea.add(lblCodigoDisciplina);
		
		JLabel lblCPFprofessor = new JLabel("CPF Professor:");
		lblCPFprofessor.setLabelFor(txtCPFprofessor);
		lblCPFprofessor.setFont(new Font("Arial", Font.BOLD, 14));
		lblCPFprofessor.setBounds(10, 251, 106, 12);
		MainArea.add(lblCPFprofessor);
		
		JLabel lblCodigoProcesso = new JLabel("Código processo:");
		lblCodigoProcesso.setLabelFor(txtCodProcesso);
		lblCodigoProcesso.setFont(new Font("Arial", Font.BOLD, 14));
		lblCodigoProcesso.setBounds(13, 105, 124, 20);
		MainArea.add(lblCodigoProcesso);
		
		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.setBackground(new Color(128, 255, 128));
		btnEnviar.setFont(new Font("Arial", Font.BOLD, 16));
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String texts = vC.validarInscricao(txtCodProcesso.getText(), txtCodDisciplina.getText(), 
							txtCPFprofessor.getText(), false);//envia os dados para o controller
					System.out.println(texts);
					vC.enviarInscricao(texts);
					JOptionPane.showMessageDialog(null, "Dados cadastrados.");
				} catch (Exception err) {
					JOptionPane.showMessageDialog(null, err);
					err.printStackTrace();
				}
				txtCodProcesso.setText(null);
				txtCodDisciplina.setText(null);
				txtCPFprofessor.setText(null);
			}
		});
		btnEnviar.setBounds(741, 383, 115, 20);
		MainArea.add(btnEnviar);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBackground(new Color(111, 162, 255));
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String chave = JOptionPane.showInputDialog("Insira o CÓDIGO do Processo");
				if(chave!=null) {
					try {
						String[] vetInscricao = vC.buscarInscricao(chave);
						txtCodProcesso.setText(vetInscricao[0]);
						txtCodDisciplina.setText(vetInscricao[1]);
						txtCPFprofessor.setText(vetInscricao[2]);
						btnEnviar.setEnabled(false);
					} catch (Exception err) {
						JOptionPane.showMessageDialog(null, err);
					}
				}
			}
		});
		btnBuscar.setFont(new Font("Arial", Font.BOLD, 16));
		btnBuscar.setBounds(24, 10, 115, 20);
		MainArea.add(btnBuscar);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String texts = vC.validarInscricao(txtCodProcesso.getText(), txtCodDisciplina.getText(), 
							txtCPFprofessor.getText(), true);
					vC.atualizarInscricao(texts);
					JOptionPane.showMessageDialog(null, "Valores atualizados.");
				} catch (Exception err) {
					JOptionPane.showMessageDialog(null, err);
				}
			}
		});
		btnAtualizar.setBackground(new Color(255, 249, 128));
		btnAtualizar.setFont(new Font("Arial", Font.BOLD, 16));
		btnAtualizar.setBounds(149, 10, 115, 20);
		MainArea.add(btnAtualizar);
		
		JButton btnDeletar = new JButton("Deletar");
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int resultado = JOptionPane.showConfirmDialog(null, "Você deseja deletar esta inscrição?\r\n",
						"AVISO!!!", 1);
				if(resultado == 0) {
					try {
						String texts = vC.validarInscricao(txtCodProcesso.getText(), txtCodDisciplina.getText(), 
								txtCPFprofessor.getText(), true);
						vC.deleteInscricao(texts);
					} catch (Exception err) {
						JOptionPane.showMessageDialog(null, err);
						err.printStackTrace();
					}
					txtCodProcesso.setText(null);
					txtCodDisciplina.setText(null);
					txtCPFprofessor.setText(null);
					btnEnviar.setEnabled(true);
				}
			}
		});
		btnDeletar.setBackground(new Color(255, 89, 89));
		btnDeletar.setFont(new Font("Arial", Font.BOLD, 16));
		btnDeletar.setBounds(274, 10, 115, 20);
		MainArea.add(btnDeletar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtCodProcesso.setText(null);
				txtCodDisciplina.setText(null);
				txtCPFprofessor.setText(null);
				btnEnviar.setEnabled(true);
				
			}
		});
		btnLimpar.setFont(new Font("Arial", Font.BOLD, 16));
		btnLimpar.setBackground(Color.LIGHT_GRAY);
		btnLimpar.setBounds(399, 10, 115, 20);
		MainArea.add(btnLimpar);
	}
}
