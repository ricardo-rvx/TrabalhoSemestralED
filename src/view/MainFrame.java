package view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import javax.swing.border.BevelBorder;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class MainFrame {

	private JFrame frame;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame window = new MainFrame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBackground(new Color(230, 230, 230));
		frame.getContentPane().setBackground(new Color(221, 221, 221));
		frame.setBounds(100, 100, 900, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		Box verticalBoxConsultas = Box.createVerticalBox();
		verticalBoxConsultas.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		verticalBoxConsultas.setForeground(Color.WHITE);
		verticalBoxConsultas.setBackground(Color.WHITE);
		verticalBoxConsultas.setBounds(10, 161, 865, 70);
		frame.getContentPane().add(verticalBoxConsultas);
		
		Box boxLBL_1 = Box.createHorizontalBox();
		boxLBL_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		boxLBL_1.setBackground(new Color(125, 125, 125));
		verticalBoxConsultas.add(boxLBL_1);
		
		Component verticalStrut_5_1 = Box.createVerticalStrut(20);
		boxLBL_1.add(verticalStrut_5_1);
		
		Component verticalStrut_1_1_1 = Box.createVerticalStrut(20);
		boxLBL_1.add(verticalStrut_1_1_1);
		
		JLabel lblConsultas = new JLabel("Consultas");
		lblConsultas.setHorizontalAlignment(SwingConstants.CENTER);
		lblConsultas.setFont(new Font("Arial", Font.BOLD, 20));
		boxLBL_1.add(lblConsultas);
		
		Component verticalStrut_2_1_1 = Box.createVerticalStrut(20);
		boxLBL_1.add(verticalStrut_2_1_1);
		
		Component verticalStrut_3_1_1 = Box.createVerticalStrut(20);
		boxLBL_1.add(verticalStrut_3_1_1);
		
		Box boxBTNs_1 = Box.createHorizontalBox();
		boxBTNs_1.setForeground(new Color(221, 221, 221));
		boxBTNs_1.setBorder(new EmptyBorder(3, 3, 3, 3));
		boxBTNs_1.setBackground(new Color(221, 221, 221));
		verticalBoxConsultas.add(boxBTNs_1);
		
		Component verticalStrut_4_1 = Box.createVerticalStrut(20);
		boxBTNs_1.add(verticalStrut_4_1);
		
		Component verticalStrut_6_1 = Box.createVerticalStrut(20);
		boxBTNs_1.add(verticalStrut_6_1);
		
		Component verticalStrut_6 = Box.createVerticalStrut(20);
		boxBTNs_1.add(verticalStrut_6);
		
		JButton btnInscritos = new JButton("Inscritos");
		btnInscritos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				consultaInscritos cInscritos = new consultaInscritos();
				cInscritos.setVisible(true);
			}
		});
		btnInscritos.setFont(new Font("Arial", Font.BOLD, 16));
		btnInscritos.setBackground(new Color(216, 216, 216));
		btnInscritos.setAlignmentX(0.5f);
		boxBTNs_1.add(btnInscritos);
		
		Component verticalStrut_1_2 = Box.createVerticalStrut(20);
		boxBTNs_1.add(verticalStrut_1_2);
		
		JButton btnDisciplinas = new JButton("Disciplinas");
		btnDisciplinas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				consultaDisciplina cDisciplina = new consultaDisciplina();
				cDisciplina.setVisible(true);
			}
		});
		btnDisciplinas.setFont(new Font("Arial", Font.BOLD, 16));
		btnDisciplinas.setBackground(new Color(216, 216, 216));
		btnDisciplinas.setAlignmentX(0.5f);
		boxBTNs_1.add(btnDisciplinas);
		
		Component verticalStrut_2_2 = Box.createVerticalStrut(20);
		boxBTNs_1.add(verticalStrut_2_2);
		
		Component verticalStrut_6_1_1 = Box.createVerticalStrut(20);
		boxBTNs_1.add(verticalStrut_6_1_1);
		
		Component verticalStrut_3_2 = Box.createVerticalStrut(20);
		boxBTNs_1.add(verticalStrut_3_2);
		
		Box verticalBoxGerenciamento = Box.createVerticalBox();
		verticalBoxGerenciamento.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		verticalBoxGerenciamento.setBackground(Color.WHITE);
		verticalBoxGerenciamento.setForeground(Color.WHITE);
		verticalBoxGerenciamento.setBounds(10, 301, 866, 70);
		frame.getContentPane().add(verticalBoxGerenciamento);
		
		Box boxLBL = Box.createHorizontalBox();
		verticalBoxGerenciamento.add(boxLBL);
		boxLBL.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		boxLBL.setBackground(new Color(125, 125, 125));
		
		Component verticalStrut_5 = Box.createVerticalStrut(20);
		boxLBL.add(verticalStrut_5);
		
		Component verticalStrut_1_1 = Box.createVerticalStrut(20);
		boxLBL.add(verticalStrut_1_1);
		
		JLabel lblCadastramentos = new JLabel("Gerenciamento");
		lblCadastramentos.setFont(new Font("Arial", Font.BOLD, 20));
		boxLBL.add(lblCadastramentos);
		lblCadastramentos.setHorizontalAlignment(SwingConstants.CENTER);
		
		Component verticalStrut_2_1 = Box.createVerticalStrut(20);
		boxLBL.add(verticalStrut_2_1);
		
		Component verticalStrut_3_1 = Box.createVerticalStrut(20);
		boxLBL.add(verticalStrut_3_1);
		
		Box boxBTNs = Box.createHorizontalBox();
		boxBTNs.setForeground(new Color(221, 221, 221));
		verticalBoxGerenciamento.add(boxBTNs);
		boxBTNs.setBackground(new Color(221, 221, 221));
		boxBTNs.setBorder(new EmptyBorder(3, 3, 3, 3));
		
		Component verticalStrut_4 = Box.createVerticalStrut(20);
		boxBTNs.add(verticalStrut_4);
		JButton btnDisciplina = new JButton("Disciplina");
		boxBTNs.add(btnDisciplina);
		btnDisciplina.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnDisciplina.setToolTipText("Cadastra uma nova Disciplina");
		btnDisciplina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				disciplinaCRUD dCRUD = new disciplinaCRUD();
				dCRUD.setVisible(true);
			}
		});
		btnDisciplina.setFont(new Font("Arial", Font.BOLD, 16));
		btnDisciplina.setBackground(new Color(216, 216, 216));
		
		
		
		Component verticalStrut = Box.createVerticalStrut(20);
		boxBTNs.add(verticalStrut);
		
		JButton btnCurso = new JButton("Curso");
		btnCurso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				cursoCRUD cCRUD = new cursoCRUD();
				cCRUD.setVisible(true);
			}
		});
		btnCurso.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnCurso.setFont(new Font("Arial", Font.BOLD, 16));
		boxBTNs.add(btnCurso);
		btnCurso.setBackground(new Color(216, 216, 216));
		
		Component verticalStrut_1 = Box.createVerticalStrut(20);
		boxBTNs.add(verticalStrut_1);
		
		JButton btnProfessor = new JButton("Professor");
		btnProfessor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				professorCRUD pCRUD = new professorCRUD();
				pCRUD.setVisible(true);
			}
		});
		btnProfessor.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnProfessor.setFont(new Font("Arial", Font.BOLD, 16));
		boxBTNs.add(btnProfessor);
		btnProfessor.setBackground(new Color(216, 216, 216));
		
		Component verticalStrut_2 = Box.createVerticalStrut(20);
		boxBTNs.add(verticalStrut_2);
		
		JButton btnInscricao = new JButton("Inscrição");
		btnInscricao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				inscricaoCRUD iCRUD = new inscricaoCRUD();
				iCRUD.setVisible(true);
			}
		});
		btnInscricao.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnInscricao.setFont(new Font("Arial", Font.BOLD, 16));
		boxBTNs.add(btnInscricao);
		btnInscricao.setBackground(new Color(216, 216, 216));
		
		Component verticalStrut_3 = Box.createVerticalStrut(20);
		boxBTNs.add(verticalStrut_3);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Sistema concurso - ADS 3° Semestre 2025/2", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(4, 9, 877, 103);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		Box horizontalBox = Box.createHorizontalBox();
		horizontalBox.setBounds(6, 15, 865, 82);
		panel.add(horizontalBox);
		horizontalBox.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		
		JTextArea txtrProductedBy = new JTextArea();
		txtrProductedBy.setFont(new Font("Arial", Font.BOLD, 16));
		txtrProductedBy.setText("Producted by:\r\n| Guilherme Matos\t| Igor Menezes \t| Fabricio Oliveira \t| Ricardo Mitsujhy");
		horizontalBox.add(txtrProductedBy);
		
	}
}
