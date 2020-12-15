import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.*;

public class BalanceFrame extends JFrame implements ReadData{
	
	private String username;
	private JPanel [][] panels;
	private int checking_money;
	private int saving_money;
	private String checking_currency;
	private String saving_currency;
	
	public BalanceFrame() {
		this.setPanels(new JPanel[7][4]);
		this.setUsername(null);
		this.setChecking_money(0);
		this.setSaving_money(0);
		
		this.setTitle("Account Current Balance");
		this.setLayout(new GridLayout(7,4));
		this.setSize(1000,800);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.initcomp();
		this.setVisible(true);
	}
	
	public BalanceFrame(String username) {
		this.setPanels(new JPanel[7][4]);
		this.setUsername(username);
		this.setChecking_money(this.getDepositMoney("Checking"));
		this.setSaving_money(this.getDepositMoney("Saving"));
		this.setChecking_currency(this.getDepositCurrency("Checking"));
		this.setSaving_currency(this.getDepositCurrency("Saving"));
		
		this.setTitle("Account Current Balance");
		this.setLayout(new GridLayout(7,4));
		this.setSize(1000,800);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.initcomp();
		this.setVisible(true);
	}
	
	public void initcomp() {
		
		JLabel saving= new JLabel("Current Saving Account Balance:",SwingConstants.RIGHT);
		saving.setFont(new Font("Verdana",Font.PLAIN,18));
		this.panels[2][1].add(saving);
		
		JLabel saving_money = new JLabel(String.valueOf(this.saving_money),SwingConstants.CENTER);
		saving_money.setFont(new Font("Verdana",Font.PLAIN,22));
		this.panels[2][2].add(saving_money);
		
		JLabel saving_currency = new JLabel(this.saving_currency,SwingConstants.LEFT);
		saving_currency.setFont(new Font("Verdana",Font.PLAIN,22));
		this.panels[2][3].add(saving_currency);
		
		JLabel checking = new JLabel("Current Checking Account Balance:",SwingConstants.RIGHT);
		checking.setFont(new Font("Verdana",Font.PLAIN,18));
		this.panels[3][1].add(checking);
		
		JLabel checking_money = new JLabel(String.valueOf(this.checking_money),SwingConstants.CENTER);
		checking_money.setFont(new Font("Verdana",Font.PLAIN,22));
		this.panels[3][2].add(checking_money);
		
		JLabel checking_currency = new JLabel(this.checking_currency,SwingConstants.LEFT);
		checking_currency.setFont(new Font("Verdana",Font.PLAIN,22));
		this.panels[3][3].add(checking_currency);
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public JPanel[][] getPanels() {
		return panels;
	}

	public int getChecking_money() {
		return checking_money;
	}

	public void setChecking_money(int checking_money) {
		this.checking_money = checking_money;
	}

	public int getSaving_money() {
		return saving_money;
	}

	public void setSaving_money(int saving_money) {
		this.saving_money = saving_money;
	}

	public String getChecking_currency() {
		return checking_currency;
	}

	public void setChecking_currency(String checking_currency) {
		this.checking_currency = checking_currency;
	}

	public String getSaving_currency() {
		return saving_currency;
	}

	public void setSaving_currency(String saving_currency) {
		this.saving_currency = saving_currency;
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
	

	@Override
	public int getDepositMoney(String accountType) {
		ArrayList<String []> read_data = GetData.read(GetData.createFilePath("info.txt"), false);
		int money_num = 0;
		for (int i=0; i<read_data.size(); i++) {
			String [] data = read_data.get(i);
			for (int j=0; j<data.length; j++) {
				if(this.username.equals(data[j])) {
					if (accountType.equals("Saving")) {
						money_num = Integer.parseInt(data[j+3]);
					}
					else {
						money_num = Integer.parseInt(data[j+5]);
					}
				}
			}
		}
		return money_num;
	}

	@Override
	public String getDepositCurrency(String accountType) {
		ArrayList<String []> read_data = GetData.read(GetData.createFilePath("info.txt"), false);
		String currency_type = "USD";
		
		for (int i=0; i<read_data.size(); i++) {
			String [] data = read_data.get(i);
			for (int j=0; j<data.length; j++) {
				if(this.username.equals(data[j])) {
					if (accountType.equals("Saving")) {
						currency_type = data[j+4];
					}
					else {
						currency_type =data[j+6];
					}
				}
			}
		}
		return currency_type;
	}

	
}
