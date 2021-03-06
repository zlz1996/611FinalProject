import java.util.ArrayList;
/**
 * 
 * @author lingdean
 * ReadData interface is used to read some data from the specific file if needed.
 */
public interface ReadData {
	
	default public int getDepositMoney(String accountType, String username) {
		ArrayList<String []> read_data = GetData.read(GetData.createFilePath("info.txt"), false);
		int money_num = 0;
		for (int i=0; i<read_data.size(); i++) {
			String [] data = read_data.get(i);
			for (int j=0; j<data.length; j++) {
				if(username.equals(data[0])) {
					if (accountType.equals("Saving")) {
						money_num = Integer.parseInt(data[3]);
					}
					else {
						money_num = Integer.parseInt(data[5]);
					}
				}
			}
		}
		return money_num;
	}
	
	default public String getDepositCurrency(String accountType, String username) {
		ArrayList<String []> read_data = GetData.read(GetData.createFilePath("info.txt"), false);
		String currency_type = "USD";
		
		for (int i=0; i<read_data.size(); i++) {
			String [] data = read_data.get(i);
			for (int j=0; j<data.length; j++) {
				if(username.equals(data[0])) {
					if (accountType.equals("Saving")) {
						currency_type = data[4];
					}
					else {
						currency_type =data[6];
					}
				}
			}
		}
		return currency_type;
	}
	
	default public int getLoan(String username) {
		ArrayList<String []> read_data = GetData.read(GetData.createFilePath("info.txt"), false);
		int money_num = 0;
		for (int i=0; i<read_data.size(); i++) {
			String [] data = read_data.get(i);
			for (int j=0; j<data.length; j++) {
				if(username.equals(data[0])) {
					if (data[7].equals("null")) {
						money_num = 0;
					}
					else {
						money_num = Integer.parseInt(data[7]);
					}
				}
			}
		}
		return money_num;
	}
	
	default public String getLoanCurrency(String username) {
		ArrayList<String []> read_data = GetData.read(GetData.createFilePath("info.txt"), false);
		String loan_currency = "";
		for (int i=0; i<read_data.size(); i++) {
			String [] data = read_data.get(i);
			for (int j=0; j<data.length; j++) {
				if(username.equals(data[0])) {
					loan_currency = data[8];
				}
			}
		}
		return loan_currency;
	}
	
	default public String getLoanDate(String username) {
		ArrayList<String []> read_data = GetData.read(GetData.createFilePath("info.txt"), false);
		String date = "";
		for (int i=0; i<read_data.size(); i++) {
			String [] data = read_data.get(i);
			for (int j=0; j<data.length; j++) {
				if(username.equals(data[0])) {
					date = data[9];
				}
			}
		}
		return date;
	}
	
	
	default public int getBankMoney(String currency) {
		ArrayList<String []> read_data = GetData.read(GetData.createFilePath("bank_money.txt"), false);
		int bank_money = 0;
		for (int i=0; i<read_data.size(); i++) {
			String [] data = read_data.get(i);
			for (int j=0; j<data.length; j++) {
				if(currency.equals(data[1])) {
					bank_money = Integer.parseInt(data[0]);
				}
			}
		}
		return bank_money;
	}
}
