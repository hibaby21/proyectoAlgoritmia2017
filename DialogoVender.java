package proyecto.algoritmia;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

public class DialogoVender extends JDialog implements ActionListener{

	private final JPanel contentPanel = new JPanel();
	private JButton btnVender;
	private JButton btnCerrar;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JComboBox cboClase;
	private JComboBox cbotipoVuelo;
	private JTextField txtCantPas;
	private JTextField txtPrecio;
	private JScrollPane scrollPane;
	private JLabel lblNewLabel_1;
	private JComboBox cboDestino;
	
	//Declarar Variables
	double impComp, impDscto, impPag, precioPasaje;
	int cantPas, clase, tipoVuelo, destino, cantClientes;
	String claseVuelo, obsequio, premioSorpresa;
	private JTextArea txtS;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DialogoVender dialog = new DialogoVender();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DialogoVender() {
		setBounds(100, 100, 450, 425);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		btnVender = new JButton("Vender");
		btnVender.addActionListener(this);
		btnVender.setBounds(335, 11, 89, 23);
		contentPanel.add(btnVender);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(335, 45, 89, 23);
		contentPanel.add(btnCerrar);
		
		lblNewLabel = new JLabel("Clase");
		lblNewLabel.setBounds(10, 15, 104, 14);
		contentPanel.add(lblNewLabel);
		
		lblNewLabel_2 = new JLabel("Tipo de vuelo");
		lblNewLabel_2.setBounds(10, 84, 104, 14);
		contentPanel.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Cantidad");
		lblNewLabel_3.setBounds(10, 49, 104, 14);
		contentPanel.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Precio");
		lblNewLabel_4.setBounds(10, 154, 104, 14);
		contentPanel.add(lblNewLabel_4);
		
		cboClase = new JComboBox();
		cboClase.setModel(new DefaultComboBoxModel(new String[] {"Economica", "Economica Premium", "Negocios", "Primera"}));
		cboClase.setBounds(124, 12, 133, 20);
		cboClase.addItemListener(new ItemHandler());
		contentPanel.add(cboClase);
		
		cbotipoVuelo = new JComboBox();
		cbotipoVuelo.setModel(new DefaultComboBoxModel(new String[] {"Ida y Vuelta", "Solo Ida"}));
		cbotipoVuelo.setBounds(124, 81, 133, 20);
		cbotipoVuelo.addItemListener(new ItemHandler());
		contentPanel.add(cbotipoVuelo);
		
		txtCantPas = new JTextField();
		txtCantPas.addActionListener(this);
		txtCantPas.setBounds(124, 46, 133, 20);
		contentPanel.add(txtCantPas);
		txtCantPas.setColumns(10);
		txtCantPas.setText("1");
//		txtCantPas.getDocument().addDocumentListener(new DocumentListener() {
//			
//			@Override
//			public void removeUpdate(DocumentEvent e) {
//				// TODO Auto-generated method stub
//				
//			}
//			
//			@Override
//			public void insertUpdate(DocumentEvent e) {
//				try {
//					txtS.setText(e.getDocument().getText(0, 4));
//				} catch (BadLocationException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//				
//			}
//			
//			@Override
//			public void changedUpdate(DocumentEvent e) {
//				// TODO Auto-generated method stub
//				
//			}
//		});
		
		txtPrecio = new JTextField();
		txtPrecio.setEditable(false);
		txtPrecio.setBounds(124, 151, 133, 20);
		contentPanel.add(txtPrecio);
		txtPrecio.setColumns(10);
		txtPrecio.setText(String.valueOf(Tienda.precio0*1.6));
		
		scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 187, 414, 188);
		contentPanel.add(scrollPane);
		
		txtS = new JTextArea();
		txtS.setFont(new Font("monospaced", Font.PLAIN, 12));
		scrollPane.setViewportView(txtS);
		
		lblNewLabel_1 = new JLabel("Destino");
		lblNewLabel_1.setBounds(10, 118, 46, 14);
		contentPanel.add(lblNewLabel_1);
		
		cboDestino = new JComboBox();
		cboDestino.setModel(new DefaultComboBoxModel(new String[] {"Brazil", "Estados Unidos", "Mexico", "Puerto Rico", "Republica Dominicana"}));
		cboDestino.setBounds(124, 115, 133, 20);
		cboDestino.addItemListener(new ItemHandler());
		contentPanel.add(cboDestino);
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == txtCantPas) {
			actionPerformedTxtCantPas(arg0);
		}
		if (arg0.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(arg0);
		}
		if (arg0.getSource() == btnVender) {
			actionPerformedBtnVender(arg0);
		}
	}
	protected void actionPerformedBtnVender(ActionEvent arg0) {
		cantClientes++;
		
		// Declaracion de variables
		clase = cboClase.getSelectedIndex();
		tipoVuelo = cbotipoVuelo.getSelectedIndex();
		destino = cboDestino.getSelectedIndex();
		cantPas = Integer.parseInt(txtCantPas.getText());
		
		//Ejecutando los metodos
		ItemHandler handler = new ItemHandler();
		handler.procesarPrecio(clase, tipoVuelo, destino);
		calcClase();
		calcImpComp();
		calcImpDscto();
		calcImpPag();
		calcObsequio();
		calcPremioSorpresa();
		mostrarResultados();

		
	}
	
	protected void actionPerformedBtnCerrar(ActionEvent arg0) {
	}
	
	protected void calcClase(){
		switch (clase) {
		case 0:
			claseVuelo = "Economica";
			break;
		case 1:
			claseVuelo = "Economica Premium";
			break;
		case 2:
			claseVuelo = "Negocios";
			break;
		case 3:
			claseVuelo = "Primera";
			break;
		default:
			break;
		}
	}
	
	protected void calcObsequio(){
		if (clase==Tienda.modeloObsequiable&&cantPas>=Tienda.cantidadMinimaObsequiable) {
			obsequio = Tienda.obsequio;
		} else{
			obsequio = "Ninguno";
		}
	}
	
	protected void calcPremioSorpresa(){
		if (cantClientes==Tienda.numeroClienteSorpresa) {
			premioSorpresa = Tienda.premioSorpresa;
		} else{
			premioSorpresa = "Ninguno";
		}
	}
	
	protected void calcImpComp(){
		impComp = precioPasaje * cantPas;
	}
	
	protected void calcImpDscto(){
		if (cantPas<5) {
			impDscto = impComp * (Tienda.porcentaje1/100);
		} else if (cantPas < 10) {
			impDscto = impComp * (Tienda.porcentaje2/100);
		} else if (cantPas < 15) {
			impDscto = impComp * (Tienda.porcentaje3/100);
		} else{
			impDscto = impComp * (Tienda.porcentaje4/100);
		}
	}
	
	protected void calcImpPag(){
		impPag = impComp - impDscto;
	}
	
	protected void mostrarResultados(){
		txtS.setText(String.format("%-20s", "Clase") + " : " + claseVuelo + "\n" );
		imprimir(String.format("%-20s", "Precio de cada pasaje") + " : " + precioPasaje);
		imprimir(String.format("%-20s", "Pasajes comprados") + " : " + cantPas);
		imprimir(String.format("%-20s", "Importe de compra") + " : " + impComp);
		imprimir(String.format("%-20s", "Importe de descuento") + " : " + impDscto);
		imprimir(String.format("%-20s", "Importe de pago") + " : " + impPag);
		imprimir(String.format("%-20s", "Obsequio") + " : " + obsequio);
		imprimir(String.format("%-20s", "Premio Sorpresa") + " : " + premioSorpresa);

	}
	
	protected void imprimir(String cad){
		txtS.append(cad + "\n");
	}
	
	private class ItemHandler implements ItemListener{

		@Override
		public void itemStateChanged(ItemEvent e) {
			// TODO Auto-generated method stub
			if (e.getSource()==cboClase) {
			procesarPrecio(cboClase.getSelectedIndex(), cbotipoVuelo.getSelectedIndex(), cboDestino.getSelectedIndex());
			}
			
			if(e.getSource()==cbotipoVuelo){
				procesarPrecio(cboClase.getSelectedIndex(), cbotipoVuelo.getSelectedIndex(), cboDestino.getSelectedIndex());

			}
			
			if (e.getSource()==cboDestino) {
				procesarPrecio(cboClase.getSelectedIndex(), cbotipoVuelo.getSelectedIndex(), cboDestino.getSelectedIndex());

			}
			
			
		}
		void procesarPrecio(int a, int b, int c){
		
			if(a==0){
				precioPasaje = Tienda.precio0;
			} else if (a==1){
				precioPasaje = Tienda.precio1;
			} else if (a==2){
				precioPasaje = Tienda.precio2;
			} else{
				precioPasaje = Tienda.precio3;
			}
			
			if(b==0){
				
			} else {
				precioPasaje = precioPasaje*0.65;
			} 
			
			if(c==0){
				precioPasaje = precioPasaje * 1.6;
			} else if (c==1){
				precioPasaje = precioPasaje * 2.2;
			} else if (c==2){
				precioPasaje = precioPasaje * 1.8;
			} else if(c==3){
				precioPasaje = precioPasaje * 1.3;
			} else{
				precioPasaje = precioPasaje * 1.1;
			}
			
			txtPrecio.setText(String.valueOf(precioPasaje));
			
		}
	}
	
	protected void actionPerformedTxtCantPas(ActionEvent arg0) {
		txtPrecio.setText("dsksksj");
	}
}
