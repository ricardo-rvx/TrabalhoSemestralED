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
import javax.swing.JOptionPane;
import controller.*;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.border.BevelBorder;

public class consultaInscritos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	JPanel MainArea;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					consultaInscritos frame = new consultaInscritos();
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
	public consultaInscritos() {
		arquivosController aC = new arquivosController();
		setTitle("Consulta de inscritos\r\n");
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
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 96, 846, 307);
		MainArea.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
			
			JPanel panel = new JPanel();
			panel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
			panel.setBounds(333, 57, 200, 27);
			MainArea.add(panel);
			panel.setLayout(null);
			
			JButton btnBuscarDisciplina = new JButton("Buscar disciplina");
			btnBuscarDisciplina.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String chave = JOptionPane.showInputDialog("Insira o COD da Disciplina: ");
					try {
						String res = aC.buscarInscritos(chave);
						if(res!="") {
							textArea.setText(res);
						}else {
							JOptionPane.showMessageDialog(null, "Nenhuma inscrição encontrada.");
						}
					} catch (Exception err) {
						JOptionPane.showMessageDialog(null, "Não foi possível recuperar os dados;");
						err.printStackTrace();
					}
				}
			});
			btnBuscarDisciplina.setBounds(0, 0, 200, 27);
			panel.add(btnBuscarDisciplina);
			btnBuscarDisciplina.setFont(new Font("Arial", Font.BOLD, 16));
			
		
		
		
		
		
	}
}
