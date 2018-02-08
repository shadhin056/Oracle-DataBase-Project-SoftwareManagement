package SoftwareManagement;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

public class myProject {

	static pdf objpdf = new pdf();
	static DCon mCon = new DCon();
	static Connection connection;
	static String query = "";

	static String adminPass = "admin";
	static String userPass = "user";

	public static void main(String[] args) throws SQLException {

		connection = mCon.getConnection();

		if (connection != null) {
			// JOptionPane.showMessageDialog(null, "Database Connection
			// Successful");
			JOptionPane.showMessageDialog(null, "Welcome to Software Database");
		} else {
			JOptionPane.showMessageDialog(null, "Database Connection Failed!");
			return;
		}

		// JOptionPane.showMessageDialog(null,"YOU are not supposed to be
		// quiet");
		// OpenOption();

		JComboBox<String> cmb = new JComboBox<String>();

		cmb.addItem("Customer");
		cmb.addItem("Admin");
		int choicee = 0;
		Object[] message = { "Enter your choice", cmb };
		int result = JOptionPane.showConfirmDialog(null, message, "Enter your choice", JOptionPane.OK_CANCEL_OPTION);
		if (result == JOptionPane.OK_OPTION) {
			choicee = cmb.getSelectedIndex();
		} else {
			return;
		}

		if (choicee == 0) {
			String pass = JOptionPane.showInputDialog("Enter user Pass");
			if (pass.equals(userPass)) {
				// user do func
			} else {
				JOptionPane.showMessageDialog(null, "Wrong Pass");
				return;
			}
		} else if (choicee == 1) {
			String pass = JOptionPane.showInputDialog("Enter admin Pass");
			if (pass.equals(adminPass)) {
				// admin do func
			} else {
				JOptionPane.showMessageDialog(null, "Wrong Pass");
				return;
			}
		}

		// ................................
		switch (choicee) {
		case 1:
			adminJob();
			break;

		// .....................................................ami
		case 0:
			userJob();
			break;

		}
	} // main ends

	private static void adminJob() {
		// TODO Auto-generated method stub
		while (true) {
			int choice = MainMenu();
			if (choice == 7) {
				try {
					connection.close();
					JOptionPane.showMessageDialog(null, "Database Connection Closed. Good Bye!");
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;
			} else {
				switch (choice) {
				case 0: // showing all records
					Integer choice1 = SecondMenu();
					if (choice1 == 8) {
						break;
					} else {
						if (choice1 == 0) {
							JComboBox<String> cmbb = new JComboBox<String>();
							cmbb.addItem("No");
							cmbb.addItem("Yes");
							int choiceeF = 0;
							Object[] messagee = { "Wnat TO print This copy ??", cmbb };
							int resultt = JOptionPane.showConfirmDialog(null, messagee, "Enter your choice",
									JOptionPane.OK_CANCEL_OPTION);
							if (resultt == JOptionPane.OK_OPTION) {
								choiceeF = cmbb.getSelectedIndex();
							}
							switch (choiceeF) {
							case 0: {
								query = "select * from software";
								break;
							}
							case 1: {
								query = "select * from software";
								String d = query;
								try {
									objpdf.pdf(d);
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
								break;
							}
						}

						else if (choice1 == 1) {
							JComboBox<String> cmbb = new JComboBox<String>();
							cmbb.addItem("No");
							cmbb.addItem("Yes");
							int choiceeF = 0;
							Object[] messagee = { "Want TO print This copy ??", cmbb };
							int resultt = JOptionPane.showConfirmDialog(null, messagee, "Enter your choice",
									JOptionPane.OK_CANCEL_OPTION);
							if (resultt == JOptionPane.OK_OPTION) {
								choiceeF = cmbb.getSelectedIndex();
							}
							switch (choiceeF) {
							case 0: {
								query = "select * from transactions";
								break;
							}
							case 1: {
								query = "select * from transactions";
								String d = query;
								try {
									objpdf.pdf(d);
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
								break;
							}
						} else if (choice1 == 2) {
							JComboBox<String> cmbb = new JComboBox<String>();
							cmbb.addItem("No");
							cmbb.addItem("Yes");
							int choiceeF = 0;
							Object[] messagee = { "Want TO print This copy ??", cmbb };
							int resultt = JOptionPane.showConfirmDialog(null, messagee, "Enter your choice",
									JOptionPane.OK_CANCEL_OPTION);
							if (resultt == JOptionPane.OK_OPTION) {
								choiceeF = cmbb.getSelectedIndex();
							}
							switch (choiceeF) {
							case 0: {
								query = "select * from company";
								break;
							}
							case 1: {
								query = "select * from company";
								String d = query;
								try {
									objpdf.pdf(d);
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
								break;
							}
						} else if (choice1 == 3) {
							JComboBox<String> cmbb = new JComboBox<String>();
							cmbb.addItem("No");
							cmbb.addItem("Yes");
							int choiceeF = 0;
							Object[] messagee = { "Want TO print This copy ??", cmbb };
							int resultt = JOptionPane.showConfirmDialog(null, messagee, "Enter your choice",
									JOptionPane.OK_CANCEL_OPTION);
							if (resultt == JOptionPane.OK_OPTION) {
								choiceeF = cmbb.getSelectedIndex();
							}
							switch (choiceeF) {
							case 0: {
								query = "select * from customers";
								break;
							}
							case 1: {
								query = "select * from customers";
								String d = query;
								try {
									objpdf.pdf(d);
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
								break;
							}
						} else if (choice1 == 4) {
							JComboBox<String> cmbb = new JComboBox<String>();
							cmbb.addItem("No");
							cmbb.addItem("Yes");
							int choiceeF = 0;
							Object[] messagee = { "Want TO print This copy ??", cmbb };
							int resultt = JOptionPane.showConfirmDialog(null, messagee, "Enter your choice",
									JOptionPane.OK_CANCEL_OPTION);
							if (resultt == JOptionPane.OK_OPTION) {
								choiceeF = cmbb.getSelectedIndex();
							}
							switch (choiceeF) {
							case 0: {
								query = "select * from credit_card_order";
								break;
							}
							case 1: {
								query = "select * from credit_card_order";
								String d = query;
								try {
									objpdf.pdf(d);
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
								break;
							}

						}  else if(choice1 == 5) {
							JComboBox<String> cmbb = new JComboBox<String>();
							cmbb.addItem("No");
							cmbb.addItem("Yes");
							int choiceeF = 0;
							Object[] messagee = { "Want TO print This copy ??", cmbb };
							int resultt = JOptionPane.showConfirmDialog(null, messagee, "Enter your choice",
									JOptionPane.OK_CANCEL_OPTION);
							if (resultt == JOptionPane.OK_OPTION) {
								choiceeF = cmbb.getSelectedIndex();
							}
							switch (choiceeF) {
							case 0: {
								query = "select * from orders";
								break;
							}
							case 1: {
								query = "select * from orders";
								String d = query;
								try {
									objpdf.pdf(d);
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
								break;
							}

						}
						else if(choice1 == 6) {
							JComboBox<String> cmbb = new JComboBox<String>();
							cmbb.addItem("No");
							cmbb.addItem("Yes");
							int choiceeF = 0;
							Object[] messagee = { "Want TO print This copy ??", cmbb };
							int resultt = JOptionPane.showConfirmDialog(null, messagee, "Enter your choice",
									JOptionPane.OK_CANCEL_OPTION);
							if (resultt == JOptionPane.OK_OPTION) {
								choiceeF = cmbb.getSelectedIndex();
							}
							switch (choiceeF) {
							case 0: {
								query = "select * from supplies";
								break;
							}
							case 1: {
								query = "select * from supplies";
								String d = query;
								try {
									objpdf.pdf(d);
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
								break;
							}

						}
						else if(choice1 == 7) {
							JComboBox<String> cmbb = new JComboBox<String>();
							cmbb.addItem("No");
							cmbb.addItem("Yes");
							int choiceeF = 0;
							Object[] messagee = { "Want TO print This copy ??", cmbb };
							int resultt = JOptionPane.showConfirmDialog(null, messagee, "Enter your choice",
									JOptionPane.OK_CANCEL_OPTION);
							if (resultt == JOptionPane.OK_OPTION) {
								choiceeF = cmbb.getSelectedIndex();
							}
							switch (choiceeF) {
							case 0: {
								query = "select * from selected_software";
								break;
							}
							case 1: {
								query = "select * from selected_software";
								String d = query;
								try {
									objpdf.pdf(d);
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
								break;
							}

						}
						ExecuteSQL(connection, query, choice1); // function
																// executing
																// the query
					}
					break;
				case 1: // inserting records
					choice1 = SecondMenu();
					if (choice1 == 8) {
						break;
					} else {
						try {
							query = InsertMenu(choice1);
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						ExecuteUpdateSQL(connection, query, choice1); // function
																		// executing
																		// the
																		// insert,delete,update
																		// query
					}
					break;
				case 2: // updating records
					choice1 = SecondMenu();
					if (choice1 == 6) {
						break;
					} else {
						query = UpdateMenu(choice1);
						ExecuteUpdateSQL(connection, query, choice1);
					}
					break;
				case 3: // Deleting Records
					choice1 = SecondMenu();
					if (choice1 == 6) {
						break;
					} else {
						query = DeleteMenu(choice1);
						ExecuteUpdateSQL(connection, query, choice1);
					}
					break;
				case 4: // Searching Records
					choice1 = SecondMenu();
					if (choice1 == 6) {
						break;
					} else {
						query = SearchMenu(choice1);
						ExecuteSQL(connection, query);
					}
					break;
				case 5: // Entering SQL
					query = QueryMenu();
					ExecuteSQL(connection, query);
					break;
				case 6: // Entering SQL
//					// JOptionPane.showMessageDialog(null,"Coming Soon");
					try {
						BUY(connection);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						}
					break;
				default:
					JOptionPane.showMessageDialog(null, "Invalid Operation");
				}
			}
		}
	}

	private static void userJob() {
		// TODO Auto-generated method stub

		while (true) {
			int choice2 = MainMenu2();
			if (choice2 == 2) {
				try {
					connection.close();
					JOptionPane.showMessageDialog(null, "Database Connection Closed. Good Bye!");
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;
			} else {
				switch (choice2) {
				case 0: // showing all records
				{
					Integer choice1 = SecondMenu2();
					if (choice1 == 1) {
						break;
					} else {
						if (choice1 == 0) {
							JComboBox<String> cmbb = new JComboBox<String>();
							cmbb.addItem("No");
							cmbb.addItem("Yes");
							int choiceeF = 0;
							Object[] messagee = { "Want TO print This copy ??", cmbb };
							int resultt = JOptionPane.showConfirmDialog(null, messagee, "Enter your choice",
									JOptionPane.OK_CANCEL_OPTION);
							if (resultt == JOptionPane.OK_OPTION) {
								choiceeF = cmbb.getSelectedIndex();
							}
							switch (choiceeF) {
							case 0: {
								query = "select * from software";
								break;
							}
							case 1: {
								query = "select * from software";
								String d = query;
								try {
									objpdf.pdf(d);
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
								break;
							}
							
						} 
							
						ExecuteSQL(connection, query, choice1); // function
																// executing
																// the query
					}
					break;
				}
				case 1: // Searching Records
					choice2 = SecondMenu2();
					if (choice2 == 1) {
						break;
					} else {
						query = SearchMenu(choice2);
						ExecuteSQL(connection, query);
					}
					break;
//				case 2: // Entering SQL
//					// JOptionPane.showMessageDialog(null,"Coming Soon");
//					try {
//						accountOpenMenu(connection);
//					} catch (SQLException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//
//					break;
				default:
					JOptionPane.showMessageDialog(null, "Invalid Operation");
				}
			}
		}
	}

	// ............................................

	public static void BUY(Connection connection) throws SQLException {
		// TODO Auto-generated method stub
		String s = "";
		JTextField trans_id1 = new JTextField(20);
		JTextField order_id1 = new JTextField(20);
		JTextField total_amount1 = new JTextField(20);
		JComboBox<String> category1 = new JComboBox<String>();
		JComboBox<String> customer_id1 = new JComboBox<String>();
		JComboBox<String> soft_name1 = new JComboBox<String>();
		//JTextField accountno = new JTextField(10);
		JComboBox<String> accountno = new JComboBox<String>();
		
		JTextField DAaTE = new JTextField(20);
		Statement stmt = connection.createStatement();
		JComboBox<String> card_type = new JComboBox<String>();

//		ResultSet rs = stmt.executeQuery("select card  from cardtype");
//		while (rs.next()) {
//			category1.addItem(rs.getString(1));
//		}
		ResultSet rssx = stmt.executeQuery("select account_no  from credit_card_order");
		while (rssx.next()) {
			accountno.addItem(rssx.getString(1));
		}
		ResultSet rss = stmt.executeQuery("select customer_id  from customers");
		while (rss.next()) {
			customer_id1.addItem(rss.getString(1));
		}
		ResultSet rsss = stmt.executeQuery("select soft_id  from software");
		while (rsss.next()) {
			soft_name1.addItem(rsss.getString(1));
		}

		ResultSet rsss1 = stmt.executeQuery("select card  from cardtype");
		
		while (rsss1.next()) {
			card_type.addItem(rsss1.getString(1));
		}
		//String add ="ami";
		Object[] message = { "Transaction Id", trans_id1, "Order Id ", order_id1, "Customer Id", customer_id1, "Software ID ", soft_name1,
				"Payment Method", card_type, "Account No", accountno, "DATE", DAaTE};

		int result = JOptionPane.showConfirmDialog(null, message, "Buy a Product", JOptionPane.OK_CANCEL_OPTION);
		connection.setAutoCommit(false);
		
		String quan = JOptionPane.showInputDialog("Quantiy");
		String pri = JOptionPane.showInputDialog("Price");
		int q = Integer.parseInt(quan);
		int p = Integer.parseInt(pri);
	    
		int 	Max=q*p;
		
		if (result == JOptionPane.OK_OPTION) {
			s = "insert into orders values ('"+ order_id1.getText() + "','" + trans_id1.getText() + "','" + card_type.getSelectedItem().toString() + "','" + accountno.getSelectedItem().toString() +"')" ;
			System.out.println(s);
			ExecuteUpdateSQL2(connection, s, Max);
			
			s = "insert into transactions values ('" + trans_id1.getText() + "','"+ order_id1.getText() + "','"  +customer_id1.getSelectedItem().toString() + "',"  + Max + ")";
			System.out.println(s);
			ExecuteUpdateSQL2(connection, s, Max);
			s = "insert into selected_software values ('" + soft_name1.getSelectedItem().toString() +  "','"+ order_id1.getText() + "','" + DAaTE.getText()  + "')";
			System.out.println(s);
			ExecuteUpdateSQL2(connection, s, Max);
			connection.commit();
		}
	}

	// do the same thing for other tables as well
	public static void executeInsert(Connection connection, String query) throws SQLException {
		Statement stmt = connection.createStatement();
		stmt.executeUpdate(query);
	}

	public static int MainMenu2() { // function creating main dialog
		JComboBox<String> cmb = new JComboBox<String>();
		cmb.addItem("Show Records");
		// cmb.addItem("Insert Records");
		// cmb.addItem("Update Records");
		// cmb.addItem("Delete Records");
		cmb.addItem("Search Records");
		//cmb.addItem("BUY A product");
		cmb.addItem("Exit");

		int choice1 = 0;
		Object[] message = { "Enter your choice", cmb };
		int result = JOptionPane.showConfirmDialog(null, message, "Customer Option : ", JOptionPane.OK_CANCEL_OPTION);

		if (result == JOptionPane.OK_OPTION) {
			choice1 = cmb.getSelectedIndex();
		} else {
			JOptionPane.showMessageDialog(null, "Select an option");
			MainMenu2();
		}
		return choice1;
	}

	public static int MainMenu() { // function creating main dialog
		JComboBox<String> cmb = new JComboBox<String>();
		cmb.addItem("Show Records");
		cmb.addItem("Insert Records");
		cmb.addItem("Update Records");
		cmb.addItem("Delete Records");
		cmb.addItem("Search Records");
		cmb.addItem("Enter SQL");
		cmb.addItem("Buy a Product");
		cmb.addItem("Exit");

		int choice = 0;
		Object[] message = { "Enter your choice", cmb };
		int result = JOptionPane.showConfirmDialog(null, message, "Admin Option : ", JOptionPane.OK_CANCEL_OPTION);

		if (result == JOptionPane.OK_OPTION) {
			choice = cmb.getSelectedIndex();
		} else {
			JOptionPane.showMessageDialog(null, "Select an option");
			MainMenu();
		}
		return choice;
	}

	public static Integer SecondMenu2() { // function displaying table names
		JComboBox<String> cmb = new JComboBox<String>();
		cmb.addItem("Software");
		//cmb.addItem("Transactions");
		//cmb.addItem("Company");
		//cmb.addItem("Customers");
//		cmb.addItem("Credit Card Order");
//		cmb.addItem("Orders");
//		cmb.addItem("supplies");
//		cmb.addItem("selected_software");
		cmb.addItem("Go to Previous Menu");

		int choice = 0;
		Object[] message = { "Enter your choice", cmb };
		int result = JOptionPane.showConfirmDialog(null, message, "Enter your choice ", JOptionPane.OK_CANCEL_OPTION);
		if (result == JOptionPane.OK_OPTION) {
			choice = cmb.getSelectedIndex();
		} else {
			choice = 6;
		}
		return choice;
	}

	public static Integer SecondMenu() { // function displaying table names
		JComboBox<String> cmb = new JComboBox<String>();
		cmb.addItem("Software");
		cmb.addItem("Transactions");
		cmb.addItem("Company");
		cmb.addItem("Customers");
		cmb.addItem("Credit Card Order");
		cmb.addItem("Orders");
		cmb.addItem("supplies");
		cmb.addItem("selected_software");
		cmb.addItem("Go to Previous Menu");

		int choice = 0;
		Object[] message = { "Enter your choice", cmb };
		int result = JOptionPane.showConfirmDialog(null, message, "Enter your choice ", JOptionPane.OK_CANCEL_OPTION);
		if (result == JOptionPane.OK_OPTION) {
			choice = cmb.getSelectedIndex();
		} else {
			choice = 6;
		}
		return choice;
	}

	public static String InsertMenu(Integer i) throws SQLException { // function displaying insert
													// dialogs
		String s = "";
		if (i == 0) { // for software
			JTextField bn = new JTextField(20);
			//JTextField bc = new JTextField(20);
			JComboBox<String> bc = new JComboBox<String>();
			JTextField a = new JTextField(20);
			JTextField b = new JTextField(20);
			JTextField p = new JTextField(20);
			JTextField av = new JTextField(20);
			Statement stmt = connection.createStatement();
			
			ResultSet rs = stmt.executeQuery("select company_id  from company");
			while (rs.next()) {
				bc.addItem(rs.getString(1));
			}
			
			
			Object[] message = { "Software ID", bn, "Company ID", bc, "Software Name", a, "Category", b, "Price",p,"Available copy",av };
			//int pr=10;
			int result = JOptionPane.showConfirmDialog(null, message, "Insert Record into software",
					JOptionPane.OK_CANCEL_OPTION);
			if (result == JOptionPane.OK_OPTION) {
				s = "insert into software values ('" + bn.getText() + "','" + bc.getSelectedItem().toString()+ "','" + a.getText() + "','"+ b.getText() + "'," + p.getText() + "," + av.getText() + ")";
				System.out.println(s);
			}
		}

		else if (i == 1) { // for transactions
			JTextField an = new JTextField(15);
			JTextField bn = new JTextField(15);
			//JTextField bal = new JTextField(15);
			JComboBox<String> bal = new JComboBox<String>();
			JTextField bl = new JTextField(15);
			
			Statement stmt = connection.createStatement();
			ResultSet rsdp = stmt.executeQuery("select customer_id  from customers");
			while (rsdp.next()) {
				bal.addItem(rsdp.getString(1));
			}
			
			
			
			Object[] message = { "transaction Id ", an, "Order id ", bn, "Customer Id ", bal, "Total Amount ", bl };

			int result = JOptionPane.showConfirmDialog(null, message, "Insert Record into transaction",
					JOptionPane.OK_CANCEL_OPTION);
			if (result == JOptionPane.OK_OPTION) {
				s = "insert into transactions values ('" + an.getText() + "','" + bn.getText() + "','" + bal.getSelectedItem().toString()+ "'," + bl.getText() + ")";
				System.out.println(s);
			}
		} else if (i == 2) { // for company
			JTextField bn = new JTextField(20);
			JTextField bc = new JTextField(20);

			Object[] message = { "Company Id", bn, "Name", bc };
			int result = JOptionPane.showConfirmDialog(null, message, "Insert Record into company",
					JOptionPane.OK_CANCEL_OPTION);
			if (result == JOptionPane.OK_OPTION) {
				s = "insert into company values ('" + bn.getText() + "','" + bc.getText() + "')";
				System.out.println(s);
			}
		} else if (i == 3) { // for customers
			JTextField an = new JTextField(35);
			JTextField bn = new JTextField(35);
			JTextField bal = new JTextField(35);
			JTextField bl = new JTextField(35);
			JTextField em = new JTextField(35);
			Object[] message = { "Customer Id ", an, "Customer Name ", bn, "Address ", bal, "Phone    ", bl, "Email ",em };

			int result = JOptionPane.showConfirmDialog(null, message, "Insert Record into customers",JOptionPane.OK_CANCEL_OPTION);
			if (result == JOptionPane.OK_OPTION) {
				s = "insert into customers values ('" + an.getText() + "','" + bn.getText() + "','" + bal.getText()+ "','" + bl.getText() + "','" + em.getText() + "')";
				System.out.println(s);
			}
		} else if (i == 4) { // for credit_card_order
			JTextField an = new JTextField(15);
			JTextField bn = new JTextField(15);
			JTextField bal = new JTextField(15);
			Object[] message = { "Account No ", an, "Exp Date ", bn, "Card Type ", bal };

			int result = JOptionPane.showConfirmDialog(null, message, "Insert Record into credit card order",
					JOptionPane.OK_CANCEL_OPTION);
			if (result == JOptionPane.OK_OPTION) {
				s = "insert into credit_card_order values ('" + an.getText() + "','" + bn.getText() + "','"
						+ bal.getText() + "')";
				System.out.println(s);
			}
		} else if (i == 5) { // for orders
			JTextField an = new JTextField(15);
			JTextField Tr = new JTextField(15);
			JTextField bn = new JTextField(15);
			//JTextField bal = new JTextField(15);
			JComboBox<String> bal = new JComboBox<String>();
			Statement stmt = connection.createStatement();
			ResultSet rsk = stmt.executeQuery("select account_no  from credit_card_order");
			while (rsk.next()) {
				bal.addItem(rsk.getString(1));
			}
			
			
			Object[] message = { "Order Id ", an,"Transaction", Tr, "Payment Method ", bn, "Account No ", bal };

			int result = JOptionPane.showConfirmDialog(null, message, "Insert Record into orders",
					JOptionPane.OK_CANCEL_OPTION);
			if (result == JOptionPane.OK_OPTION) {
				s = "insert into orders values ('" + an.getText() +"','" + Tr.getText() + "','" + bn.getText() + "','" + bal.getSelectedItem().toString() + "')";
				System.out.println(s);
			}
		}
		 else if (i == 6) { // for supplies
				JTextField an = new JTextField(15);
				JTextField Tr = new JTextField(15);
				JTextField bn = new JTextField(15);
				
				
				Object[] message = { "company Id ", an,"soft id", Tr, "supplies date ", bn };

				int result = JOptionPane.showConfirmDialog(null, message, "Insert Record into supplies",
						JOptionPane.OK_CANCEL_OPTION);
				if (result == JOptionPane.OK_OPTION) {
					s = "insert into supplies values ('" + an.getText() +"','" + Tr.getText() + "','" + bn.getText() + "')";
					System.out.println(s);
				}
			}
		 else if (i == 7) { // for selected_software
				JTextField an = new JTextField(15);
				JTextField Tr = new JTextField(15);
				JTextField bn = new JTextField(15);
				
				Object[] message = { "soft Id ", an,"order id", Tr, "Soft date ", bn };

				int result = JOptionPane.showConfirmDialog(null, message, "Insert Record into selected_software",
						JOptionPane.OK_CANCEL_OPTION);
				if (result == JOptionPane.OK_OPTION) {
					s = "insert into selected_software values ('" + an.getText() +"','" + Tr.getText() + "','" + bn.getText() + "')";
					System.out.println(s);
				}
			}
		// do the same thing for other tables as well
		else {

		}
		return s;
	}

	public static String UpdateMenu(Integer i) { // function displaying update
													// dialog
		String s = "";
		if (i == 0) { // for software
			JComboBox<String> attr = new JComboBox<String>();
			attr.addItem("soft_id");
			attr.addItem("company_id");
			attr.addItem("soft_name");
			attr.addItem("category");
			attr.addItem("price");
			attr.addItem("available_copy");

			JTextField value = new JTextField(20);
			JTextField condition = new JTextField(20);
			Object[] message = { "Attribute", attr, "New Value (use ' ' for string)", value,
					"Where (write complete expression)", condition };
			int result = JOptionPane.showConfirmDialog(null, message, "Update software", JOptionPane.OK_CANCEL_OPTION);
			if (result == JOptionPane.OK_OPTION) {
				if (condition.getText() != null && condition.getText().length() > 0) {
					s = "update software set " + attr.getSelectedItem().toString() + " = " + value.getText() + " where "
							+ condition.getText();
					System.out.println(s);
				} else {
					s = "update software set " + attr.getSelectedItem().toString() + " = " + value;
					System.out.println(s);
				}
			}
		} else if (i == 1) { // function transaction
			JComboBox<String> attr = new JComboBox<String>();
			attr.addItem("trans_id ");
			attr.addItem("order_id ");
			attr.addItem("customer_id ");
			attr.addItem("total_amount ");

			JTextField value = new JTextField(20);
			JTextField condition = new JTextField(20);
			Object[] message = { "Attribute", attr, "New Value (use ' ' for string)", value,
					"Where (write complete expression)", condition };
			int result = JOptionPane.showConfirmDialog(null, message, "Update transaction",
					JOptionPane.OK_CANCEL_OPTION);
			if (result == JOptionPane.OK_OPTION) {
				if (condition.getText() != null && condition.getText().length() > 0) {
					s = "update transactions set " + attr.getSelectedItem().toString() + " = " + value.getText()
							+ " where " + condition.getText();
					System.out.println(s);
				} else {
					s = "update transactions set " + attr.getSelectedItem().toString() + " = " + value;
					System.out.println(s);
				}
			}
		} else if (i == 2) { // function company
			JComboBox<String> attr = new JComboBox<String>();
			attr.addItem("company_id ");
			attr.addItem("name ");

			JTextField value = new JTextField(20);
			JTextField condition = new JTextField(20);
			Object[] message = { "Attribute", attr, "New Value (use ' ' for string)", value,
					"Where (write complete expression)", condition };
			int result = JOptionPane.showConfirmDialog(null, message, "Update company", JOptionPane.OK_CANCEL_OPTION);
			if (result == JOptionPane.OK_OPTION) {
				if (condition.getText() != null && condition.getText().length() > 0) {
					s = "update company set " + attr.getSelectedItem().toString() + " = " + value.getText() + " where "
							+ condition.getText();
					System.out.println(s);
				} else {
					s = "update company set " + attr.getSelectedItem().toString() + " = " + value;
					System.out.println(s);
				}
			}
		} else if (i == 3) { // function customers
			JComboBox<String> attr = new JComboBox<String>();
			attr.addItem("customer_id ");
			attr.addItem("customer_name ");
			attr.addItem("address ");
			attr.addItem("phone ");
			attr.addItem("email ");

			JTextField value = new JTextField(20);
			JTextField condition = new JTextField(20);
			Object[] message = { "Attribute", attr, "New Value (use ' ' for string)", value,
					"Where (write complete expression)", condition };
			int result = JOptionPane.showConfirmDialog(null, message, "Update customers", JOptionPane.OK_CANCEL_OPTION);
			if (result == JOptionPane.OK_OPTION) {
				if (condition.getText() != null && condition.getText().length() > 0) {
					s = "update customers set " + attr.getSelectedItem().toString() + " = " + value.getText()
							+ " where " + condition.getText();
					System.out.println(s);
				} else {
					s = "update customers set " + attr.getSelectedItem().toString() + " = " + value;
					System.out.println(s);
				}
			}
		} else if (i == 4) { // function credit_card_order
			JComboBox<String> attr = new JComboBox<String>();
			attr.addItem("account_no ");
			attr.addItem("exp_date ");
			attr.addItem("card_type ");

			JTextField value = new JTextField(20);
			JTextField condition = new JTextField(20);
			Object[] message = { "Attribute", attr, "New Value (use ' ' for string)", value,
					"Where (write complete expression)", condition };
			int result = JOptionPane.showConfirmDialog(null, message, "Update credit_card_order",
					JOptionPane.OK_CANCEL_OPTION);
			if (result == JOptionPane.OK_OPTION) {
				if (condition.getText() != null && condition.getText().length() > 0) {
					s = "update credit_card_order set " + attr.getSelectedItem().toString() + " = " + value.getText()
							+ " where " + condition.getText();
					System.out.println(s);
				} else {
					s = "update credit_card_order set " + attr.getSelectedItem().toString() + " = " + value;
					System.out.println(s);
				}
			}
		}

		else if (i == 5) { // function orders
			JComboBox<String> attr = new JComboBox<String>();
			attr.addItem("order_id ");
			attr.addItem("payment_method ");
			attr.addItem("account_no ");

			JTextField value = new JTextField(20);
			JTextField condition = new JTextField(20);
			Object[] message = { "Attribute", attr, "New Value (use ' ' for string)", value,
					"Where (write complete expression)", condition };
			int result = JOptionPane.showConfirmDialog(null, message, "Update orders", JOptionPane.OK_CANCEL_OPTION);
			if (result == JOptionPane.OK_OPTION) {
				if (condition.getText() != null && condition.getText().length() > 0) {
					s = "update orders set " + attr.getSelectedItem().toString() + " = " + value.getText() + " where "
							+ condition.getText();
					System.out.println(s);
				} else {
					s = "update orders set " + attr.getSelectedItem().toString() + " = " + value;
					System.out.println(s);
				}
			}
		}
		// do the same thing for other tables as well
		else {

		}
		return s;
	}

	public static String DeleteMenu(Integer i) { // function displaying delete
													// dialog
		String s = "";
		if (i == 0) { // for software
			JTextField condition = new JTextField(20);
			Object[] message = { "Where (write complete expression)", condition };
			int result = JOptionPane.showConfirmDialog(null, message, "Delete from software",
					JOptionPane.OK_CANCEL_OPTION);
			if (result == JOptionPane.OK_OPTION) {
				if (condition.getText() != null && condition.getText().length() > 0) {
					s = "delete from software where " + condition.getText();
					System.out.println(s);
				} else {
					s = "delete from software";
					System.out.println(s);
				}
			}
		} else if (i == 1) { // for transaction
			JTextField condition = new JTextField(20);
			Object[] message = { "Where (write complete expression)", condition };
			int result = JOptionPane.showConfirmDialog(null, message, "Delete from transaction",
					JOptionPane.OK_CANCEL_OPTION);
			if (result == JOptionPane.OK_OPTION) {
				if (condition.getText() != null && condition.getText().length() > 0) {
					s = "delete from transactions where " + condition.getText();
					System.out.println(s);
				} else {
					s = "delete from transactions";
					System.out.println(s);
				}
			}
		} else if (i == 2) { // for company
			JTextField condition = new JTextField(20);
			Object[] message = { "Where (write complete expression)", condition };
			int result = JOptionPane.showConfirmDialog(null, message, "Delete from company",
					JOptionPane.OK_CANCEL_OPTION);
			if (result == JOptionPane.OK_OPTION) {
				if (condition.getText() != null && condition.getText().length() > 0) {
					s = "delete from company where " + condition.getText();
					System.out.println(s);
				} else {
					s = "delete from company";
					System.out.println(s);
				}
			}
		} else if (i == 3) { // for customers
			JTextField condition = new JTextField(20);
			Object[] message = { "Where (write complete expression)", condition };
			int result = JOptionPane.showConfirmDialog(null, message, "Delete from customers",
					JOptionPane.OK_CANCEL_OPTION);
			if (result == JOptionPane.OK_OPTION) {
				if (condition.getText() != null && condition.getText().length() > 0) {
					s = "delete from customers where " + condition.getText();
					System.out.println(s);
				} else {
					s = "delete from customers";
					System.out.println(s);
				}
			}
		} else if (i == 4) { // for credit_card_order
			JTextField condition = new JTextField(20);
			Object[] message = { "Where (write complete expression)", condition };
			int result = JOptionPane.showConfirmDialog(null, message, "Delete from credit_card_order",
					JOptionPane.OK_CANCEL_OPTION);
			if (result == JOptionPane.OK_OPTION) {
				if (condition.getText() != null && condition.getText().length() > 0) {
					s = "delete from credit_card_order where " + condition.getText();
					System.out.println(s);
				} else {
					s = "delete from credit_card_order";
					System.out.println(s);
				}
			}
		} else if (i == 5) { // for orders
			JTextField condition = new JTextField(20);
			Object[] message = { "Where (write complete expression)", condition };
			int result = JOptionPane.showConfirmDialog(null, message, "Delete from orders",
					JOptionPane.OK_CANCEL_OPTION);
			if (result == JOptionPane.OK_OPTION) {
				if (condition.getText() != null && condition.getText().length() > 0) {
					s = "delete from orders where " + condition.getText();
					System.out.println(s);
				} else {
					s = "delete from orders";
					System.out.println(s);
				}
			}
		}
		// do the same thing for other tables as well
		else {

		}
		return s;
	}

	public static String SearchMenu2(Integer i) { // function displaying search
		// dialog
String s = "";
if (i == 0) { // for software
JTextField condition = new JTextField(20);
Object[] message = { "Where (write complete expression)", condition };
int result = JOptionPane.showConfirmDialog(null, message, "Search into software",
JOptionPane.OK_CANCEL_OPTION);
if (result == JOptionPane.OK_OPTION) {
if (condition.getText() != null && condition.getText().length() > 0) {
s = "select * from software where " + condition.getText();
System.out.println(s);
}
}

else {

}
return s;
}
return s;}
	
	public static String SearchMenu(Integer i) { // function displaying search
													// dialog
		String s = "";
		if (i == 0) { // for software
			JTextField condition = new JTextField(20);
			Object[] message = { "Where (write complete expression)", condition };
			int result = JOptionPane.showConfirmDialog(null, message, "Search into software",
					JOptionPane.OK_CANCEL_OPTION);
			if (result == JOptionPane.OK_OPTION) {
				if (condition.getText() != null && condition.getText().length() > 0) {
					s = "select * from software where " + condition.getText();
					System.out.println(s);
				}
			}
		} else if (i == 1) { // for transactions
			JTextField condition = new JTextField(20);
			Object[] message = { "Where (write complete expression)", condition };
			int result = JOptionPane.showConfirmDialog(null, message, "Search into transactions",
					JOptionPane.OK_CANCEL_OPTION);
			if (result == JOptionPane.OK_OPTION) {
				if (condition.getText() != null && condition.getText().length() > 0) {
					s = "select * from transactions where " + condition.getText();
					System.out.println(s);
				}
			}
		}

		else if (i == 2) { // for company
			JTextField condition = new JTextField(20);
			Object[] message = { "Where (write complete expression)", condition };
			int result = JOptionPane.showConfirmDialog(null, message, "Search into company",
					JOptionPane.OK_CANCEL_OPTION);
			if (result == JOptionPane.OK_OPTION) {
				if (condition.getText() != null && condition.getText().length() > 0) {
					s = "select * from company where " + condition.getText();
					System.out.println(s);
				}
			}
		}

		else if (i == 3) { // for customers
			JTextField condition = new JTextField(20);
			Object[] message = { "Where (write complete expression)", condition };
			int result = JOptionPane.showConfirmDialog(null, message, "Search into customers",
					JOptionPane.OK_CANCEL_OPTION);
			if (result == JOptionPane.OK_OPTION) {
				if (condition.getText() != null && condition.getText().length() > 0) {
					s = "select * from customers where " + condition.getText();
					System.out.println(s);
				}
			}
		} else if (i == 4) { // for credit_card_order
			JTextField condition = new JTextField(20);
			Object[] message = { "Where (write complete expression)", condition };
			int result = JOptionPane.showConfirmDialog(null, message, "Search into credit_card_order",
					JOptionPane.OK_CANCEL_OPTION);
			if (result == JOptionPane.OK_OPTION) {
				if (condition.getText() != null && condition.getText().length() > 0) {
					s = "select * from credit_card_order where " + condition.getText();
					System.out.println(s);
				}
			}
		} else if (i == 5) { // for orders
			JTextField condition = new JTextField(20);
			Object[] message = { "Where (write complete expression)", condition };
			int result = JOptionPane.showConfirmDialog(null, message, "Search into orders",
					JOptionPane.OK_CANCEL_OPTION);
			if (result == JOptionPane.OK_OPTION) {
				if (condition.getText() != null && condition.getText().length() > 0) {
					s = "select * from orders where " + condition.getText();
					System.out.println(s);
				}
			}
		}

		// do the same thing for other tables as well
		else {

		}
		return s;
	}

	public static String QueryMenu() { // function displaying SQL dialog
		String s = "";
		JPanel panel = new JPanel();

		JTextArea query = new JTextArea("<<Enter your query here>>", 10, 20);

		query.setPreferredSize(new Dimension(100, 100));
		query.setLineWrap(true);
		JScrollPane scrollPane = new JScrollPane(query, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

		panel.setLayout(new BorderLayout());
		panel.add(scrollPane, BorderLayout.CENTER);

		Object[] message = { "Query", panel };

		int result = JOptionPane.showConfirmDialog(null, message, "Query Input", JOptionPane.OK_CANCEL_OPTION);
		if (result == JOptionPane.OK_OPTION) {
			s = query.getText();
			{
				
				try {
					objpdf.pdf(s);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

		return s;
	}

	public static void ExecuteSQL(Connection conn, String s, Integer ch1) { // executing
																			// query
																			// for
																			// show
																			// records
																			// option
		// data structure required for JTable
		Vector<String> cnames = new Vector<String>();
		Vector<Vector<String>> data = new Vector<Vector<String>>();

		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(s);
			ResultSetMetaData rsmd = rs.getMetaData();
			Integer columnsNumber = rsmd.getColumnCount();
			for (int i = 1; i <= columnsNumber; i++) {
				cnames.addElement(rsmd.getColumnName(i));
			}
			while (rs.next()) {
				Vector<String> row = new Vector<String>();
				for (int i = 1; i <= columnsNumber; i++) {
					row.addElement(rs.getString(i));
				}
				data.addElement(row);
			}
			DisplayTable(data, cnames, ch1); // function displaying result in a
												// table format

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			if (s.isEmpty())
				JOptionPane.showMessageDialog(null, "Empty Values");
			else
				JOptionPane.showMessageDialog(null, "Error in SQL");
			e.printStackTrace();
		}
	}

	public static void ExecuteSQL(Connection conn, String s) { // executing
																// query for
																// other options
		Vector<String> cnames = new Vector<String>();
		Vector<Vector<String>> data = new Vector<Vector<String>>();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(s);
			ResultSetMetaData rsmd = rs.getMetaData();
			Integer columnsNumber = rsmd.getColumnCount();
			for (int i = 1; i <= columnsNumber; i++) {
				cnames.addElement(rsmd.getColumnName(i));
			}
			while (rs.next()) {
				Vector<String> row = new Vector<String>();
				for (int i = 1; i <= columnsNumber; i++) {
					row.addElement(rs.getString(i));
				}
				data.addElement(row);
			}
			DisplayTable(data, cnames, 6); // function displaying result in a
											// table format
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			if (s.isEmpty())
				JOptionPane.showMessageDialog(null, "Empty Values");
			else
				JOptionPane.showMessageDialog(null, "Error in SQL");
			e.printStackTrace();
		}
	}

	public static void ExecuteUpdateSQL2(Connection conn, String s, Integer ch1) {
		try {
			conn.setAutoCommit(true); // changes shall be committed, not lost
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(s);
			JOptionPane.showMessageDialog(null, "Table suceesfully modified.");
			if (ch1 == 0)
				ExecuteSQL(conn, "select * from orders", ch1);
			else if (ch1 == 1)
				ExecuteSQL(conn, "select * from transactions", ch1);
			else if (ch1 == 2)
				ExecuteSQL(conn, "select * from selected_software", ch1);
			else {

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			if (s.isEmpty())
				JOptionPane.showMessageDialog(null, "Empty Values");
			else
				JOptionPane.showMessageDialog(null, "Error in SQL");
			e.printStackTrace();
		}
	}

	
	public static void ExecuteUpdateSQL(Connection conn, String s, Integer ch1) {
		try {
			conn.setAutoCommit(true); // changes shall be committed, not lost
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(s);
			JOptionPane.showMessageDialog(null, "Table suceesfully modified.");
			if (ch1 == 0)
				ExecuteSQL(conn, "select * from software", ch1);
			else if (ch1 == 1)
				ExecuteSQL(conn, "select * from transactions", ch1);
			else if (ch1 == 2)
				ExecuteSQL(conn, "select * from company", ch1);
			else if (ch1 == 3)
				ExecuteSQL(conn, "select * from customers", ch1);
			else if (ch1 == 4)
				ExecuteSQL(conn, "select * from credit_card_order", ch1);
			else if (ch1 == 5)
				ExecuteSQL(conn, "select * from orders", ch1);
			else if (ch1 == 6)
				ExecuteSQL(conn, "select * from supplies", ch1);
			else if (ch1 == 7)
				ExecuteSQL(conn, "select * from selected_software", ch1);
			// do the same for other values
			else {

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			if (s.isEmpty())
				JOptionPane.showMessageDialog(null, "Empty Values");
			else
				JOptionPane.showMessageDialog(null, "Error in SQL");
			e.printStackTrace();
		}
	}

	public static void DisplayTable(Vector data, Vector cnames, Integer i) {
		String caption = "";
		JPanel panel = new JPanel();
		JTable table = new JTable(data, cnames);
		JScrollPane scrollPane = new JScrollPane(table);

		panel.setLayout(new BorderLayout());
		panel.setSize(400, 300);
		panel.add(scrollPane, BorderLayout.CENTER);
		table.setBackground(Color.cyan);
		table.setForeground(Color.red);
		Object[] message = { panel };

		if (i == 0)
			caption = "software Information";
		else if (i == 1)
			caption = "Transactions Information";
		else if (i == 2)
			caption = "Company Information";
		else if (i == 3)
			caption = "Customer Information";
		else if (i == 4)
			caption = "Credit_card_order Information";
		else if (i == 5)
			caption = "Orders Information";
		else if (i == 6)
			caption = "supplies Information";
		else if (i == 7)
			caption = "selected_software Information";
		else
			caption = "Result Table";

		JOptionPane.showMessageDialog(null, message, caption, JOptionPane.INFORMATION_MESSAGE);
	}
}