package proyecto;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;

public class ConsutarPasajes extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCantMal;
	private JTextField txtPrecio;
	private JTextField txtPuntos;
	
	private double precioEco = 400;
	private double precioEcoPremium = 500;
	private double precioEje = 600;
	private double precioPri = 700;
	
	JComboBox cboClase = new JComboBox();
	JComboBox cboDestino = new JComboBox();
	JComboBox cboTipo = new JComboBox();
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ConsutarPasajes dialog = new ConsutarPasajes();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ConsutarPasajes() {
		setTitle("Consultar Pasajes");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("Borrar");
		btnNewButton_1.setBounds(318, 15, 89, 23);
		contentPanel.add(btnNewButton_1);
		
		
		cboClase.setModel(new DefaultComboBoxModel(new String[] {"Economica", "Economica Premium", "Ejecutiva", "Primera"}));
		cboClase.setBounds(110, 12, 124, 20);
		contentPanel.add(cboClase);
		cboClase.addItemListener(new ItemHandler());
		
		
		JLabel lblNewLabel = new JLabel("Clase");
		lblNewLabel.setBounds(10, 15, 93, 14);
		contentPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Destino");
		lblNewLabel_1.setBounds(10, 49, 93, 14);
		contentPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Tipo de vuelo");
		lblNewLabel_2.setBounds(10, 88, 86, 14);
		contentPanel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Cantidad de maletas");
		lblNewLabel_3.setBounds(10, 128, 105, 14);
		contentPanel.add(lblNewLabel_3);
		
		txtCantMal = new JTextField();
		txtCantMal.setEditable(false);
		txtCantMal.setBounds(110, 125, 124, 20);
		contentPanel.add(txtCantMal);
		txtCantMal.setColumns(10);
		txtCantMal.setText("2");
		
		
		cboDestino.setModel(new DefaultComboBoxModel(new String[] {"Estados Unidos", "Brazil", "Puerto Rico", "Mexico", "Canada", "Espa\u00F1a"}));
		cboDestino.setBounds(110, 46, 121, 20);
		contentPanel.add(cboDestino);
		cboDestino.addItemListener(new ItemHandler());
		
		
		cboTipo.setModel(new DefaultComboBoxModel(new String[] {"Ida y Vuelta", "Ida"}));
		cboTipo.setBounds(110, 85, 124, 20);
		contentPanel.add(cboTipo);
		cboTipo.addItemListener(new ItemHandler());
		
		JLabel lblPuntosAlCliente = new JLabel("Puntos al cliente");
		lblPuntosAlCliente.setBounds(10, 158, 86, 14);
		contentPanel.add(lblPuntosAlCliente);
		
		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setBounds(10, 189, 46, 14);
		contentPanel.add(lblPrecio);
		
		txtPrecio = new JTextField();
		txtPrecio.setEditable(false);
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(110, 186, 124, 20);
		contentPanel.add(txtPrecio);
		txtPrecio.setText(String.valueOf(precioEco));
		
		txtPuntos = new JTextField();
		txtPuntos.setEditable(false);
		txtPuntos.setColumns(10);
		txtPuntos.setBounds(110, 155, 124, 20);
		contentPanel.add(txtPuntos);
		txtPuntos.setText("100");
	}
	
	private class ItemHandler implements ItemListener{

		@Override
		public void itemStateChanged(ItemEvent e) {
			if (e.getSource()==cboClase) {
				if (cboClase.getSelectedItem().equals("Economica")) {
					if(cboDestino.getSelectedItem().equals("Estados Unidos")){
						if (cboTipo.getSelectedItem().equals("Ida y vuelta")) {
							txtPrecio.setText(String.valueOf(precioEco*2));
						} else{
							txtPrecio.setText(String.valueOf(precioEco));

						}
					} else if(cboDestino.getSelectedItem().equals("Brazil")){
						if (cboTipo.getSelectedItem().equals("Ida y vuelta")) {
							txtPrecio.setText(String.valueOf(precioEco*2*3));
						} else{
							txtPrecio.setText(String.valueOf(precioEco*3));

						}
					} else if(cboDestino.getSelectedItem().equals("Puerto Rico")){
						if (cboTipo.getSelectedItem().equals("Ida y Vuelta")) {
							txtPrecio.setText(String.valueOf(precioEco*5));
						} else{
							txtPrecio.setText(String.valueOf(precioEco*1.2));

						}
					} else if(cboDestino.getSelectedItem().equals("Mexico")){
						if (cboTipo.getSelectedItem().equals("Ida y vuelta")) {
							txtPrecio.setText(String.valueOf(precioEco*2.5));
						} else{
							txtPrecio.setText(String.valueOf(precioEco*1.5));

						}
					} if(cboDestino.getSelectedItem().equals("Canada")){
						if (cboTipo.getSelectedItem().equals("Ida y vuelta")) {
							txtPrecio.setText(String.valueOf(precioEco*2.8));
						} else{
							txtPrecio.setText(String.valueOf(precioEco*1.8));

						}
					} 
				} else if(cboClase.getSelectedItem().equals("Economica Premium")){
					
				} else if(cboClase.getSelectedItem().equals("Ejecutiva")){
					txtPrecio.setText(String.valueOf(precioEco));

				} else if(cboClase.getSelectedItem().equals("Primera")){
					
				}
			} else if (e.getSource()==cboDestino) {
				
			} else if (e.getSource()==cboTipo) {
				
			}
			
		}
		
	}
	
}
