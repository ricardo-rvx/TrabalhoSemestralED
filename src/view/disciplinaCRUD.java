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

public class disciplinaCRUD extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtCodDisciplina;
	private JTextField txtxNomeDIsciplina;
	private JTextField txtDiaSemana;
	private JTextField txtQtdHoras;
	private JTextField txtHoraini;
	private JTextField txtCodCurso;
	
	JPanel MainArea;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					disciplinaCRUD frame = new disciplinaCRUD();
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
	public disciplinaCRUD() {
		validacaoController vC = new validacaoController();
		setTitle("Disciplina\r\n");
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
		txtCodDisciplina.setBounds(149, 81, 150, 25);
		MainArea.add(txtCodDisciplina);
		txtCodDisciplina.setColumns(10);
		
		txtxNomeDIsciplina = new JTextField();
		txtxNomeDIsciplina.setColumns(10);
		txtxNomeDIsciplina.setBounds(149, 177, 150, 25);
		MainArea.add(txtxNomeDIsciplina);
		
		txtDiaSemana = new JTextField();
		txtDiaSemana.setColumns(10);
		txtDiaSemana.setBounds(149, 275, 150, 25);
		MainArea.add(txtDiaSemana);
		
		txtQtdHoras = new JTextField();
		txtQtdHoras.setColumns(10);
		txtQtdHoras.setBounds(634, 177, 150, 25);
		MainArea.add(txtQtdHoras);
		
		txtHoraini = new JTextField();
		txtHoraini.setColumns(10);
		txtHoraini.setBounds(634, 81, 150, 25);
		MainArea.add(txtHoraini);
		
		txtCodCurso = new JTextField();
		txtCodCurso.setColumns(10);
		txtCodCurso.setBounds(634, 275, 150, 25);
		MainArea.add(txtCodCurso);		
		
		JLabel lblCodigoDisciplina = new JLabel("Código Disciplina:");
		lblCodigoDisciplina.setLabelFor(txtCodDisciplina);
		lblCodigoDisciplina.setFont(new Font("Arial", Font.BOLD, 14));
		lblCodigoDisciplina.setBounds(12, 82, 127, 20);
		MainArea.add(lblCodigoDisciplina);
		
		JLabel lblHoraInicial = new JLabel("Hora Inicial:");
		lblHoraInicial.setLabelFor(txtHoraini);
		lblHoraInicial.setFont(new Font("Arial", Font.BOLD, 14));
		lblHoraInicial.setBounds(523, 86, 83, 12);
		MainArea.add(lblHoraInicial);
		
		JLabel lblNomeDisc = new JLabel("Nome:");
		lblNomeDisc.setLabelFor(txtxNomeDIsciplina);
		lblNomeDisc.setFont(new Font("Arial", Font.BOLD, 14));
		lblNomeDisc.setBounds(12, 182, 109, 12);
		MainArea.add(lblNomeDisc);
		
		JLabel lblQtdHoras = new JLabel("Qtd. Horas:");
		lblQtdHoras.setLabelFor(txtQtdHoras);
		lblQtdHoras.setFont(new Font("Arial", Font.BOLD, 14));
		lblQtdHoras.setBounds(523, 182, 82, 12);
		MainArea.add(lblQtdHoras);
		
		JLabel lblCodigoCurso = new JLabel("Código Curso:");
		lblCodigoCurso.setLabelFor(txtCodCurso);
		lblCodigoCurso.setFont(new Font("Arial", Font.BOLD, 14));
		lblCodigoCurso.setBounds(523, 281, 101, 12);
		MainArea.add(lblCodigoCurso);
		
		JLabel lblDiaSemana = new JLabel("Dia semana:");
		lblDiaSemana.setLabelFor(txtDiaSemana);
		lblDiaSemana.setFont(new Font("Arial", Font.BOLD, 14));
		lblDiaSemana.setBounds(12, 280, 95, 12);
		MainArea.add(lblDiaSemana);
		
		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.setBackground(new Color(128, 255, 128));
		btnEnviar.setFont(new Font("Arial", Font.BOLD, 16));
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String texts = vC.validarDisciplina(txtCodDisciplina.getText(), 
							txtxNomeDIsciplina.getText(), txtDiaSemana.getText(), 
							txtHoraini.getText(), txtQtdHoras.getText(), 
							txtCodCurso.getText(), false);//envia os dados para o controller
					vC.enviarDisciplina(texts);
					JOptionPane.showMessageDialog(null, "Dados cadastrados.");
				} catch (Exception err) {
					JOptionPane.showMessageDialog(null, err);
				}
				txtCodCurso.setText(null);
				txtCodDisciplina.setText(null);
				txtDiaSemana.setText(null);
				txtHoraini.setText(null);
				txtQtdHoras.setText(null);
				txtxNomeDIsciplina.setText(null);
			}
		});
		btnEnviar.setBounds(741, 383, 115, 20);
		MainArea.add(btnEnviar);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBackground(new Color(111, 162, 255));
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String chave = JOptionPane.showInputDialog("Insira o CÓDIGO ou NOME da disciplina");
				if(chave!=null) {
					try {
						String[] vetDisciplina = vC.buscarDisciplina(chave);
						txtCodDisciplina.setText(vetDisciplina[0]);
						txtxNomeDIsciplina.setText(vetDisciplina[1]);
						txtDiaSemana.setText(vetDisciplina[2]);
						txtHoraini.setText(vetDisciplina[3]);
						txtQtdHoras.setText(vetDisciplina[4]);
						txtCodCurso.setText(vetDisciplina[5]);
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
					String texts = vC.validarDisciplina(txtCodDisciplina.getText(), 
						txtxNomeDIsciplina.getText(), txtDiaSemana.getText(), 
						txtHoraini.getText(), txtQtdHoras.getText(), 
						txtCodCurso.getText(), true);
					vC.atualizarDisciplina(texts);
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
				int resultado = JOptionPane.showConfirmDialog(null, "Você deseja deletar esta disciplina?\r\n"
						+ "Todas as incrições atreladas a esta disciplina serão apagadas também.",
						"AVISO!!!", 1);
				if(resultado == 0) {
					try {
						String texts = vC.validarDisciplina(txtCodDisciplina.getText(), 
								txtxNomeDIsciplina.getText(), txtDiaSemana.getText(), 
								txtHoraini.getText(), txtQtdHoras.getText(), 
								txtCodCurso.getText(), true);
						
						vC.deleteDisciplina(texts);
						JOptionPane.showMessageDialog(null, "Valores deletados.");
					} catch (Exception err) {
						JOptionPane.showMessageDialog(null, err);
						err.printStackTrace();
					}
					txtCodCurso.setText(null);
					txtCodDisciplina.setText(null);
					txtDiaSemana.setText(null);
					txtHoraini.setText(null);
					txtQtdHoras.setText(null);
					txtxNomeDIsciplina.setText(null);
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
				txtCodDisciplina.setText(null);
				txtDiaSemana.setText(null);
				txtHoraini.setText(null);
				txtQtdHoras.setText(null);
				txtxNomeDIsciplina.setText(null);
				btnEnviar.setEnabled(true);
				
			}
		});
		btnLimpar.setFont(new Font("Arial", Font.BOLD, 16));
		btnLimpar.setBackground(Color.LIGHT_GRAY);
		btnLimpar.setBounds(399, 10, 115, 20);
		MainArea.add(btnLimpar);
	}
}
