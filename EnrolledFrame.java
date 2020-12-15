import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class EnrolledFrame extends JFrame{

	private String user_name;
	private JPanel [][] panels;
	private JButton CheckingButton;
	private JButton SavingButton;
	private JButton LoansButton;
	private JButton ExitButton;
	private JButton BalanceButton;
	private JButton TransactionButton;
	private JButton TransferButton;
	private boolean ifexit;
	private boolean ifloans;
	private boolean ifbalance;
	private boolean iftransaction;
	private boolean iftransfer;
	
	public EnrolledFrame() {
		this.setUser_name(null);
		this.setIfexit(false);
		this.initcomp();
	}
	
	public EnrolledFrame(String user_name) {
		this.setUser_name(user_name);
		this.setIfexit(false);
		this.initcomp();
	}
	
	public void initcomp() {
		this.setPanels(new JPanel[7][4]);
		
		String welcome_message1 = "Hello!" ;
		String welcome_message2 = "Mr./Mrs. " + this.user_name;
		JLabel message1 = new JLabel(welcome_message1,SwingConstants.RIGHT);
		message1.setFont(new Font("Verdana",Font.PLAIN,24));
		message1.setForeground(Color.blue);
		
		JLabel message2 = new JLabel(welcome_message2,SwingConstants.LEFT);
		message2.setFont(new Font("Verdana",Font.PLAIN,24));
		message2.setForeground(Color.blue);
		this.panels[0][1].add(message1);
		this.panels[0][2].add(message2);
		
		this.setCheckingButton(new JButton("Checking Account"));
		this.CheckingButton.setBackground(Color.black);
		this.CheckingButton.setOpaque(true);
		this.CheckingButton.addActionListener(new CheckingListener());
		this.panels[1][0].add(this.CheckingButton);
		
		this.setSavingButton(new JButton("Saving Account"));
		this.SavingButton.setBackground(Color.black);
		this.SavingButton.setOpaque(true);
		this.SavingButton.addActionListener(new SavingListener());
		this.panels[1][3].add(this.SavingButton);
		
		this.setBalanceButton(new JButton("Current Balance"));
		this.BalanceButton.setBackground(Color.black);
		this.BalanceButton.setOpaque(true);
		this.BalanceButton.addActionListener(new BalanceListener());
		this.panels[3][0].add(this.BalanceButton);
		
		this.setLoansButton(new JButton("Request Loan"));
		this.LoansButton.setBackground(Color.black);
		this.LoansButton.setOpaque(true);
		this.panels[3][3].add(this.LoansButton);
		
		this.setTransactionButton(new JButton("Transactions"));
		this.TransactionButton.setBackground(Color.black);
		this.TransactionButton.setOpaque(true);
		this.panels[5][0].add(this.TransactionButton);
		
		this.setTransferButton(new JButton("Transfer"));
		this.TransferButton.setBackground(Color.black);
		this.TransferButton.setOpaque(true);
		this.panels[5][3].add(this.TransferButton);
		
		this.setExitButton(new JButton("Exit"));
		this.ExitButton.setBackground(Color.black);
		this.ExitButton.setOpaque(true);
		this.ExitButton.addActionListener(new ExitListener());
		this.panels[6][1].add(this.ExitButton);
		
		this.setTitle("You have enrolled your account");
		this.setLayout(new GridLayout(7,4));
		// Set frame size to fit the screen
		this.setExtendedState(Frame.MAXIMIZED_BOTH);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(true);
		
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public JPanel[][] getPanels() {
		return panels;
	}

	public void setPanels(JPanel[][] panels) {
		this.panels = panels;
		for (int i=0; i<this.panels.length; i++) {
			for (int j=0; j<this.panels[0].length; j++) {
				this.panels[i][j] = new JPanel();
				this.panels[i][j].setLayout(new GridLayout(1,1));
				this.add(this.panels[i][j]);
			}
		}
	}

	public JButton getCheckingButton() {
		return CheckingButton;
	}

	public void setCheckingButton(JButton checkingButton) {
		CheckingButton = checkingButton;
	}

	public JButton getSavingButton() {
		return SavingButton;
	}

	public void setSavingButton(JButton savingButton) {
		SavingButton = savingButton;
	}

	public JButton getLoansButton() {
		return LoansButton;
	}

	public void setLoansButton(JButton loansButton) {
		LoansButton = loansButton;
	}

	public JButton getExitButton() {
		return ExitButton;
	}

	public void setExitButton(JButton exitButton) {
		ExitButton = exitButton;
	}

	public JButton getBalanceButton() {
		return BalanceButton;
	}

	public void setBalanceButton(JButton balanceButton) {
		BalanceButton = balanceButton;
	}

	public JButton getTransactionButton() {
		return TransactionButton;
	}

	public void setTransactionButton(JButton transactionButton) {
		TransactionButton = transactionButton;
	}

	public JButton getTransferButton() {
		return this.TransferButton;
	}

	public void setTransferButton(JButton transferButton) {
		this.TransferButton = transferButton;
	}

	public boolean isIfexit() {
		return ifexit;
	}

	public void setIfexit(boolean ifexit) {
		this.ifexit = ifexit;
		if(this.ifexit==true) {
			this.dispose();
		}
	}

	class CheckingListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			AccountFrame checkingFrame = new AccountFrame("Checking",user_name);
		}
		
	}
	
	class SavingListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			AccountFrame savingFrame = new AccountFrame("Saving",user_name);
		}
		
	}
	
	class BalanceListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			BalanceFrame balance = new BalanceFrame(user_name);
			
		}
		
	}
	
	class ExitListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			setIfexit(true);
			WelcomeFrame welcome = new WelcomeFrame();
		}

	}
	
	
}


