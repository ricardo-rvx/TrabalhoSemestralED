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

public class professorCRUD extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtCPF;
	private JTextField txtxNomeProfessor;
	private JTextField txtQtdPontos;
	private JTextField txtAreaConhecimento;
	
	JPanel MainArea;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					professorCRUD frame = new professorCRUD();
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
	public professorCRUD() {
		validacaoController vC = new validacaoController();
		setTitle("Professor\r\n");
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
		
		txtCPF = new JTextField();
		txtCPF.setFont(new Font("Arial", Font.PLAIN, 12));
		txtCPF.setBounds(164, 76, 150, 25);
		MainArea.add(txtCPF);
		txtCPF.setColumns(10);
		
		txtxNomeProfessor = new JTextField();
		txtxNomeProfessor.setColumns(10);
		txtxNomeProfessor.setBounds(164, 140, 150, 25);
		MainArea.add(txtxNomeProfessor);
		
		txtQtdPontos = new JTextField();
		txtQtdPontos.setColumns(10);
		txtQtdPontos.setBounds(164, 290, 150, 25);
		MainArea.add(txtQtdPontos);
		
		txtAreaConhecimento = new JTextField();
		txtAreaConhecimento.setColumns(10);
		txtAreaConhecimento.setBounds(164, 218, 150, 25);
		MainArea.add(txtAreaConhecimento);
		
		JLabel lblCPF = new JLabel("CPF:");
		lblCPF.setLabelFor(txtCPF);
		lblCPF.setFont(new Font("Arial", Font.BOLD, 14));
		lblCPF.setBounds(10, 81, 34, 12);
		MainArea.add(lblCPF);
		
		JLabel lblAreaConhecimento = new JLabel("Area conhecimento:");
		lblAreaConhecimento.setLabelFor(txtAreaConhecimento);
		lblAreaConhecimento.setFont(new Font("Arial", Font.BOLD, 14));
		lblAreaConhecimento.setBounds(12, 223, 142, 12);
		MainArea.add(lblAreaConhecimento);
		
		JLabel lblNomeProfessor = new JLabel("Nome:");
		lblNomeProfessor.setLabelFor(txtxNomeProfessor);
		lblNomeProfessor.setFont(new Font("Arial", Font.BOLD, 14));
		lblNomeProfessor.setBounds(12, 145, 47, 12);
		MainArea.add(lblNomeProfessor);
		
		JLabel lblQtdPontos = new JLabel("Qtd. pontos:");
		lblQtdPontos.setLabelFor(txtQtdPontos);
		lblQtdPontos.setFont(new Font("Arial", Font.BOLD, 14));
		lblQtdPontos.setBounds(12, 295, 86, 12);
		MainArea.add(lblQtdPontos);
		
		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.setBackground(new Color(128, 255, 128));
		btnEnviar.setFont(new Font("Arial", Font.BOLD, 16));
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String texts = vC.validarProfessor(txtCPF.getText(), txtxNomeProfessor.getText(), 
							txtAreaConhecimento.getText(), txtQtdPontos.getText(), false);//envia os dados para o controller
					vC.enviarProfessor(texts);
					JOptionPane.showMessageDialog(null, "Dados cadastrados.");
				} catch (Exception err) {
					JOptionPane.showMessageDialog(null, err);
				}
				txtCPF.setText(null);
				txtAreaConhecimento.setText(null);
				txtQtdPontos.setText(null);
				txtxNomeProfessor.setText(null);
			}
		});
		btnEnviar.setBounds(741, 383, 115, 20);
		MainArea.add(btnEnviar);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBackground(new Color(111, 162, 255));
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String chave = JOptionPane.showInputDialog("Insira o CPF do Professor");
				if(chave!=null) {
					try {
						String[] vetProfessor = vC.buscarProfessor(chave);
						txtCPF.setText(vetProfessor[0]);
						txtxNomeProfessor.setText(vetProfessor[2]);
						txtAreaConhecimento.setText(vetProfessor[3]);
						txtQtdPontos.setText(vetProfessor[1]);
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
					String texts = vC.validarProfessor(txtCPF.getText(), txtxNomeProfessor.getText(), 
							txtAreaConhecimento.getText(), txtQtdPontos.getText(), true);
					vC.atualizarProfessor(texts);
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
				int resultado = JOptionPane.showConfirmDialog(null, "Você deseja deletar este curso?\r\n",
						"AVISO!!!", 1);
				if(resultado == 0) {
					try {
						String texts = vC.validarProfessor(txtCPF.getText(), txtxNomeProfessor.getText(), 
								txtAreaConhecimento.getText(), txtQtdPontos.getText(), true);
						vC.deleteProfessores(texts);
					} catch (Exception err) {
						JOptionPane.showMessageDialog(null, err);
						err.printStackTrace();
					}
					txtCPF.setText(null);
					txtAreaConhecimento.setText(null);
					txtQtdPontos.setText(null);
					txtxNomeProfessor.setText(null);
					btnEnviar.setEnabled(true);				}
			}
		});
		btnDeletar.setBackground(new Color(255, 89, 89));
		btnDeletar.setFont(new Font("Arial", Font.BOLD, 16));
		btnDeletar.setBounds(274, 10, 115, 20);
		MainArea.add(btnDeletar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtCPF.setText(null);
				txtAreaConhecimento.setText(null);
				txtQtdPontos.setText(null);
				txtxNomeProfessor.setText(null);
				btnEnviar.setEnabled(true);
				
			}
		});
		btnLimpar.setFont(new Font("Arial", Font.BOLD, 16));
		btnLimpar.setBackground(Color.LIGHT_GRAY);
		btnLimpar.setBounds(399, 10, 115, 20);
		MainArea.add(btnLimpar);
	}
}
