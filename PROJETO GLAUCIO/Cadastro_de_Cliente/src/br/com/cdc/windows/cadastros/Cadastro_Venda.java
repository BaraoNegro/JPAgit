package br.com.cdc.windows.cadastros;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.jgoodies.forms.factories.DefaultComponentFactory;

import br.com.cdc.connection.Conexao;
import br.com.cdc.model.Cliente;
import br.com.cdc.model.Produto;
import br.com.cdc.model.TableModelProduto;
import br.com.cdc.model.TableModelVenda;
import br.com.cdc.model.Venda;

public class Cadastro_Venda extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable tableVendas;
	private JTable table;
	private JTable table_1;
	private JTextField textValorTotal;

	public static void main(String[] args) {
		try {
			Cadastro_Venda dialog = new Cadastro_Venda();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
			dialog.setResizable(false);
			dialog.setModal(true);
			dialog.setEnabled(true);
			dialog.setTitle("Cadastro de Venda");
			dialog.setLocationRelativeTo(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Cadastro_Venda() {
		
		setBounds(100, 100, 780, 490);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		List<Produto> produtoCombo = Conexao.listarProduto();
		
		String produtos[] = new String[produtoCombo.size()];
		
		for(int i = 0; i < produtoCombo.size(); i++) {
			
			Produto produto = new Produto();
			produtos[i] = produtoCombo.get(i).getNome();
		}
		
		List<Cliente> clienteCombo = Conexao.listarClientes();
		
		String clientes[] = new String[clienteCombo.size()];
		
		for(int i = 0; i < clienteCombo.size(); i++) {
			
			Cliente cliente = new Cliente();
			clientes[i] = clienteCombo.get(i).getNome();
		}
		
		JLabel lblCadastroDeVenda = DefaultComponentFactory.getInstance().createTitle("Cadastro de Venda");
		lblCadastroDeVenda.setBounds(5, 5, 422, 58);
		lblCadastroDeVenda.setFont(new Font("Dialog", Font.BOLD, 45));
		
		JLabel lblCliente = new JLabel("Cliente:");
		lblCliente.setBounds(11, 207, 64, 21);
		lblCliente.setFont(new Font("Dialog", Font.BOLD, 16));
		
		JLabel lblProduto = new JLabel("Produto:");
		lblProduto.setBounds(11, 257, 81, 21);
		lblProduto.setFont(new Font("Dialog", Font.BOLD, 16));
		
		JComboBox comboBoxCliente = new JComboBox(clientes);
		comboBoxCliente.setBounds(102, 202, 290, 31);
		comboBoxCliente.setFont(new Font("Dialog", Font.PLAIN, 16));
		contentPanel.setLayout(null);
		
		JComboBox comboBoxProduto = new JComboBox(produtos);
		comboBoxProduto.setBounds(102, 252, 290, 31);
		comboBoxProduto.setFont(new Font("Dialog", Font.PLAIN, 16));
		contentPanel.setLayout(null);
		
		contentPanel.add(lblCadastroDeVenda);
		contentPanel.add(lblCliente);
		contentPanel.add(lblProduto);
		contentPanel.add(comboBoxCliente);
		contentPanel.add(comboBoxProduto);
		
		JLabel lblVendaCadastradas = new JLabel("Produtos da Venda");
		lblVendaCadastradas.setFont(new Font("Dialog", Font.BOLD, 25));
		lblVendaCadastradas.setBounds(460, 47, 265, 21);
		contentPanel.add(lblVendaCadastradas);
		
		//TESTE
		
		
		
		
		
		
		List<Venda> vendas = Conexao.listarVenda();
		
		ArrayList dados = new ArrayList();
		
		for(int i = 0; i < vendas.size(); i++) {
			
			Venda venda = new Venda();
			venda.setId(vendas.get(i).getId());
			venda.setProduto(vendas.get(i).getProduto());
			dados.add(venda);
		}
		
		TableModelVenda modelo = new TableModelVenda(dados);
		
		tableVendas = new JTable();
		tableVendas.setShowVerticalLines(true);
		tableVendas.setShowHorizontalLines(true);
		tableVendas.setFont(new Font("Dialog", Font.PLAIN, 14));
		tableVendas.setColumnSelectionAllowed(true);
		tableVendas.setBounds(1002, 100, 176, 505);
		
		tableVendas.setModel(modelo);
		tableVendas.getColumnModel().getColumn(0).setPreferredWidth(30);
		tableVendas.getColumnModel().getColumn(0).setResizable(false);
		tableVendas.getColumnModel().getColumn(1).setPreferredWidth(210);
		tableVendas.getColumnModel().getColumn(1).setResizable(false);
		
	
		
		/*tableProdutos = new JTable();
		tableProdutos.setBounds(610, 80, 148, 355);
		contentPanel.add(tableProdutos);
		
		tableProdutos.setModel(modelo);
		tableProdutos.getColumnModel().getColumn(0).setPreferredWidth(30);
		tableProdutos.getColumnModel().getColumn(0).setResizable(false);
		tableProdutos.getColumnModel().getColumn(1).setPreferredWidth(210);
		tableProdutos.getColumnModel().getColumn(1).setResizable(false);

		JScrollPane scrollPane = new JScrollPane(tableProdutos);
		scrollPane.setBounds(461, 78, 297, 357);
		contentPanel.add(scrollPane);*/
		
		//FIM TESTE
		
		/*List<Venda> vendas = Conexao.listarVenda();
		
		ArrayList dados = new ArrayList();
		
		for(int i = 0; i < vendas.size(); i++) {
			
			Venda venda = new Venda();
			venda.setId(vendas.get(i).getId());
			dados.add(vendas);
		}
		
		TableModelVenda modelo = new TableModelVenda(dados);
		
		table = new JTable();
		table.setBounds(613, 84, 141, 361);
		table.setModel(modelo);
		table.getColumnModel().getColumn(0).setPreferredWidth(30);
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(1).setPreferredWidth(210);
		table.getColumnModel().getColumn(1).setResizable(false);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(460, 84, 265, 361);
		contentPanel.add(scrollPane);
		
		/*JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Venda venda = new Venda();
				
				
				//venda.setProduto(comboBoxProduto.getSelectedItem().toString());
				//venda.setCliente(comboBoxCliente.getSelectedItem().toString());
				
				try {
					
					Conexao.guardar(venda);
					
				}catch(NullPointerException f) {
					
					JOptionPane.showMessageDialog(null,"Ops.. Deve ter faltado preencher algo ai moral: \n" +f);
				}
				catch(Exception npe){
					
					JOptionPane.showMessageDialog(null, "Ops.. Algo deu errado: \n" +npe);
				}
				
				comboBoxProduto.setSelectedItem(produtos[0]);
				comboBoxCliente.setSelectedItem(clientes[0]);
				JOptionPane.showMessageDialog(null,"Venda Cadastrada!");
				modelo.addVenda(venda);
				tableVendas.getModel();
			}
		});*/
		/*btnSalvar.setFont(new Font("Dialog", Font.BOLD, 16));
		btnSalvar.setBounds(93, 417, 90, 28);
		contentPanel.add(btnSalvar);*/
		
		JButton btnAddProd = new JButton("Adicionar");
		btnAddProd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				comboBoxProduto.setSelectedItem(produtos[0]);
				comboBoxCliente.setSelectedItem(clientes[0]);
			}
		});
		btnAddProd.setFont(new Font("Dialog", Font.BOLD, 16));
		btnAddProd.setBounds(102, 294, 118, 28);
		contentPanel.add(btnAddProd);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
         	    Cadastro_Venda.this.dispose();
			}
		});
		btnVoltar.setFont(new Font("Dialog", Font.BOLD, 16));
		btnVoltar.setBounds(293, 417, 90, 28);
		contentPanel.add(btnVoltar);
		
		textValorTotal = new JTextField();
		textValorTotal.setBounds(607, 403, 118, 42);
		contentPanel.add(textValorTotal);
		textValorTotal.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane(tableVendas);
		scrollPane.setBounds(460, 79, 265, 313);
		contentPanel.add(scrollPane);
		
		JLabel lblValorTotal = new JLabel("Valor Total:");
		lblValorTotal.setFont(new Font("Dialog", Font.BOLD, 25));
		lblValorTotal.setBounds(460, 406, 142, 32);
		contentPanel.add(lblValorTotal);
		
		JButton btnGravar = new JButton("Gravar");
		btnGravar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnGravar.setFont(new Font("Dialog", Font.BOLD, 16));
		btnGravar.setBounds(193, 417, 90, 28);
		contentPanel.add(btnGravar);
		
	}
}
