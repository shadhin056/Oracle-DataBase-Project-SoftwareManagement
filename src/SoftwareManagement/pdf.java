package SoftwareManagement;
import java.io.*;
import java.util.*;
import java.sql.*; 
import java.sql.Date;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
public class pdf {  
	public  void pdf(String s) throws Exception{
                
                /* Create Connection objects */
                Class.forName ("oracle.jdbc.driver.OracleDriver"); 
                Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost", "lab", "cse301");
                Statement stmt = conn.createStatement();
                
               // String s = "SELECT * from account";
              //  String s = "SELECT table_name from user_tables";
//               Scanner S =new Scanner(System.in);
//              String s=S.nextLine();
                
                String timeStamp = new Timestamp(System.currentTimeMillis()).toString();
                String ts= timeStamp;
                ts = ts.replace(':','_');
                ts = ts.replace('-','_');
                ts = ts.replace(' ','_');
                System.out.println(ts);
                String fileName = "Report_" + ts + ".pdf";
                /* Define the SQL query */
                ResultSet rs = stmt.executeQuery(s);
                /* Step-2: Initialize PDF documents - logical objects */
                Document my_pdf_report = new Document();
                PdfWriter.getInstance(my_pdf_report, new FileOutputStream(fileName));
                my_pdf_report.open(); 
                
                ResultSetMetaData rsmd = rs.getMetaData();
    			int columnsNumber = rsmd.getColumnCount();
    			
                //we have four columns in our table
                PdfPTable my_report_table = new PdfPTable(columnsNumber);
                //create a cell object
                PdfPCell table_cell;
               
                for(int i=1; i<=columnsNumber; i++){
            		String str = rsmd.getColumnName(i);
                    table_cell=new PdfPCell(new Phrase(str));
                    my_report_table.addCell(table_cell);
    			}
                
                while (rs.next()) {              
                	for(int i=1; i<=columnsNumber; i++){
                		String str = rs.getString(i);
                        table_cell=new PdfPCell(new Phrase(str));
                        my_report_table.addCell(table_cell);
        			}
                }
                                
                Paragraph paragraph = new Paragraph();
    			paragraph.add("Report on " + s + "\n\n\n");
    			paragraph.setAlignment(Element.ALIGN_CENTER);
    			my_pdf_report.add(paragraph);
                         
                /* Attach report table to PDF */
                my_pdf_report.add(my_report_table);   
                my_pdf_report.addCreationDate();
                
                
                Paragraph paragraph1 = new Paragraph();
        		paragraph1.add("\n\n\n Report generated on " + timeStamp);
        		paragraph1.setAlignment(Element.ALIGN_RIGHT);
        		my_pdf_report.add(paragraph1);
        		
                my_pdf_report.close();
                
                /* Close all DB related objects */
                rs.close();
                stmt.close(); 
                conn.close();               
                }
        
}