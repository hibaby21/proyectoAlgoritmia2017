package proyecto.algoritmia;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Tienda extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnNewMenu;
	private JMenuItem mntmXss;
	private JMenu mnNewMenu_1;
	private JMenu mnNewMenu_2;
	private JMenu mnNewMenu_3;
	private JMenu mnNewMenu_4;
	private JMenuItem mntmNewMenuItem;
	private JMenuItem mntmNewMenuItem_1;
	private JMenuItem mntmNewMenuItem_2;
	private JMenuItem mntmNewMenuItem_3;
	private JMenuItem mntmNewMenuItem_4;
	private JMenuItem mntmNewMenuItem_5;
	private JMenuItem mntmNewMenuItem_6;
	private JMenuItem mntmNewMenuItem_7;
	private JMenuItem mntmNewMenuItem_8;
	private JMenuItem mntmNewMenuItem_9;
	
	//Declaracion de variables
	
	// Datos mínimos del primer pasaje 
	public static String pasaje0 = "Clase Economica"; 
	public static double precio0 = 450.0; 
	public static int cantMaletas0 = 2; 
	public static int puntos = 100; 
	 
	// Datos mínimos del segundo modelo 
	public static String pasaje1 = "Clase Economica Premium"; 
	public static double precio1 = 550.0; 
	public static int cantMaletas1 = 2; 
	public static int nluces1 = 200;
	// Datos mínimos del tercer modelo 
	public static String pasaje2 = "Clase de Negocios"; 
	public static double precio2 = 699.0; 
	public static int cantMaletas2 = 3; 
	public static int nluces2 = 300; 
	 
	// Datos mínimos del cuarto modelo 
	public static String pasaje3 = "Primera Clase"; 
	public static double precio3 = 999.0; 
	public static int cantMaletas3 = 4; 
	public static int nluces3 = 400; 
	 
	 
	// Porcentajes de descuento de acuerdo a la cantidad de pasajes cmprados
	public static double porcentaje1 = 3.5; 
	public static double porcentaje2 = 5.0; 
	public static double porcentaje3 = 6.0; 
	public static double porcentaje4 = 7.5; 
	 
	// Cantidad óptima de pasajes vendidos
	public static int cantidadOptima = 4000; 
	 
	// Modelo para el cual se otorga el obsequio 
	public static int modeloObsequiable = 3; 
	 
	// Cantidad mínima de lámparas adquiridas para obtener el obsequio 
	public static int cantidadMinimaObsequiable = 4;  
	// Obsequio 
	public static String obsequio = "S/.300 de credito para hospedarse en cualquier hotel"; 
	 
	// Número de cliente que recibe el premio sorpresa
	public static int numeroClienteSorpresa = 7; 
	 
	// Premio sorpresa
	public static String premioSorpresa = "Netflix gratis por 6 meses"; 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tienda frame = new Tienda();
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
	public Tienda() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnNewMenu = new JMenu("Archivo");
		menuBar.add(mnNewMenu);
		
		mntmXss = new JMenuItem("Salir");
		mnNewMenu.add(mntmXss);
		
		mnNewMenu_1 = new JMenu("Mantenimiento");
		menuBar.add(mnNewMenu_1);
		
		mntmNewMenuItem = new JMenuItem("Consultar pasajes");
		mnNewMenu_1.add(mntmNewMenuItem);
		
		mntmNewMenuItem_1 = new JMenuItem("Modificar pasajes");
		mnNewMenu_1.add(mntmNewMenuItem_1);
		
		mntmNewMenuItem_2 = new JMenuItem("Listar pasajes");
		mnNewMenu_1.add(mntmNewMenuItem_2);
		
		mnNewMenu_2 = new JMenu("Ventas");
		menuBar.add(mnNewMenu_2);
		
		mntmNewMenuItem_3 = new JMenuItem("Vender");
		mntmNewMenuItem_3.addActionListener(this);
		mnNewMenu_2.add(mntmNewMenuItem_3);
		
		mntmNewMenuItem_4 = new JMenuItem("Generar reportes");
		mnNewMenu_2.add(mntmNewMenuItem_4);
		
		mnNewMenu_3 = new JMenu("Configuraci\u00F3n");
		menuBar.add(mnNewMenu_3);
		
		mntmNewMenuItem_5 = new JMenuItem("Configurar descuentos");
		mnNewMenu_3.add(mntmNewMenuItem_5);
		
		mntmNewMenuItem_6 = new JMenuItem("Configurar obsequio");
		mnNewMenu_3.add(mntmNewMenuItem_6);
		
		mntmNewMenuItem_7 = new JMenuItem("Configurar cantidad \u00F3ptima de pasajes vendidos");
		mnNewMenu_3.add(mntmNewMenuItem_7);
		
		mntmNewMenuItem_8 = new JMenuItem("Configurar premio sorpresa");
		mnNewMenu_3.add(mntmNewMenuItem_8);
		
		mnNewMenu_4 = new JMenu("Ayuda");
		menuBar.add(mnNewMenu_4);
		
		mntmNewMenuItem_9 = new JMenuItem("Acerca de Tienda");
		mnNewMenu_4.add(mntmNewMenuItem_9);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == mntmNewMenuItem_3) {
			actionPerformedMntmNewMenuItem_3(arg0);
		}
	}
	protected void actionPerformedMntmNewMenuItem_3(ActionEvent arg0) {
		DialogoVender dialogoVender = new DialogoVender();
		dialogoVender.setLocationRelativeTo(this);
		dialogoVender.setVisible(true);
	}
}
