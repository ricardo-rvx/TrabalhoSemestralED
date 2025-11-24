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

public class cursoCRUD extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtCodCurso;
	private JTextField txtxNomeCurso;
	private JTextField txtAreaConhec;
	
	JPanel MainArea;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					cursoCRUD frame = new cursoCRUD();
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
	public cursoCRUD() {
		validacaoController vC = new validacaoController();
		setTitle("Cursos\r\n");
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
		
		txtCodCurso = new JTextField();
		txtCodCurso.setFont(new Font("Arial", Font.PLAIN, 12));
		txtCodCurso.setBounds(162, 76, 150, 25);
		MainArea.add(txtCodCurso);
		txtCodCurso.setColumns(10);
		
		txtxNomeCurso = new JTextField();
		txtxNomeCurso.setColumns(10);
		txtxNomeCurso.setBounds(162, 167, 150, 25);
		MainArea.add(txtxNomeCurso);
		
		txtAreaConhec = new JTextField();
		txtAreaConhec.setColumns(10);
		txtAreaConhec.setBounds(162, 260, 150, 25);
		MainArea.add(txtAreaConhec);
		
		JLabel lblCodCurso = new JLabel("Código Curso:");
		lblCodCurso.setLabelFor(txtCodCurso);
		lblCodCurso.setFont(new Font("Arial", Font.BOLD, 14));
		lblCodCurso.setBounds(10, 75, 101, 25);
		MainArea.add(lblCodCurso);
		
		JLabel lblNomeCurso = new JLabel("Nome Curso:");
		lblNomeCurso.setLabelFor(txtxNomeCurso);
		lblNomeCurso.setFont(new Font("Arial", Font.BOLD, 14));
		lblNomeCurso.setBounds(10, 172, 93, 12);
		MainArea.add(lblNomeCurso);
		
		JLabel lblAreaConhec = new JLabel("Área conhecimento:");
		lblAreaConhec.setLabelFor(txtAreaConhec);
		lblAreaConhec.setFont(new Font("Arial", Font.BOLD, 14));
		lblAreaConhec.setBounds(10, 265, 142, 12);
		MainArea.add(lblAreaConhec);
		
		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.setBackground(new Color(128, 255, 128));
		btnEnviar.setFont(new Font("Arial", Font.BOLD, 16));
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String texts = vC.validarCurso(txtCodCurso.getText(), 
							txtxNomeCurso.getText(), txtAreaConhec.getText(), false);//envia os dados para o controller
					vC.enviarCurso(texts);
					JOptionPane.showMessageDialog(null, "Dados cadastrados.");
				} catch (Exception err) {
					JOptionPane.showMessageDialog(null, err);
				}
				txtCodCurso.setText(null);
				txtAreaConhec.setText(null);
				txtxNomeCurso.setText(null);
			}
		});
		btnEnviar.setBounds(741, 383, 115, 20);
		MainArea.add(btnEnviar);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBackground(new Color(111, 162, 255));
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String chave = JOptionPane.showInputDialog("Insira o CÓDIGO ou NOME do Curso");
				if(chave!=null) {
					try {
						String[] vetCurso = vC.buscarCurso(chave);
						txtCodCurso.setText(vetCurso[0]);
						txtxNomeCurso.setText(vetCurso[1]);
						txtAreaConhec.setText(vetCurso[2]);
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
					String texts = vC.validarCurso(txtCodCurso.getText(), 
							txtxNomeCurso.getText(), txtAreaConhec.getText(), true);
					vC.atualizarCurso(texts);
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
						String texts = vC.validarCurso(txtCodCurso.getText(), 
								txtxNomeCurso.getText(), txtAreaConhec.getText(), true);
						vC.deleteCursos(texts);
					} catch (Exception err) {
						JOptionPane.showMessageDialog(null, err);
						err.printStackTrace();
					}
					txtCodCurso.setText(null);
					txtAreaConhec.setText(null);
					txtxNomeCurso.setText(null);
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
				txtCodCurso.setText(null);
				txtAreaConhec.setText(null);
				txtxNomeCurso.setText(null);
				btnEnviar.setEnabled(true);
				
			}
		});
		btnLimpar.setFont(new Font("Arial", Font.BOLD, 16));
		btnLimpar.setBackground(Color.LIGHT_GRAY);
		btnLimpar.setBounds(399, 10, 115, 20);
		MainArea.add(btnLimpar);
	}
}
