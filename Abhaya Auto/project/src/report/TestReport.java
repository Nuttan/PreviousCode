package report;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

import properties.LoadFrameworkProp;

public class TestReport {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws ParserConfigurationException 
	 * @throws SAXException 
	 */
	/* 
	   Author Name                       : Vinusha Tanuku
	   Date of Preparation               : 16/05/2014
	   Date of Modified                  : 6/5/2014
	   Methods Called                    : ParsingTestResultXML
	   Purpose of Method                 : Generates Report for Current Test Execution Run
	   Dependencies	                     : --
	   Reviewed By                       : Pankaj
	   Modified By						 : Pankaj
	*/
	public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException {
		
		 ParsingTestResultXML result = new  ParsingTestResultXML();
		 AreaDataTable areaDataTable=new AreaDataTable();
		 Object[][] datatable=areaDataTable.generateAreaDataTable(result);
		 LoadFrameworkProp frameProp = new LoadFrameworkProp();
		 Date dNow = new Date( );
	     SimpleDateFormat ft =  new SimpleDateFormat ("dd/MM/yyyy hh:mm:ss");
	     SimpleDateFormat ft_filename =  new SimpleDateFormat ("ddMMyyyyhhmmss");  
	     for(int i=0;i<datatable.length;i++)
		   {
			   for(int j=0;j<4;j++)
			   {
				   System.out.println(datatable[i][j]);
			   }
		   }
	     PrintWriter pw = new PrintWriter(new FileWriter(frameProp.getHtmlReport()+"AutomationTestReport_"+ft_filename.format(dNow)+".html"));
	     pw.println("<h2 align=\"center\"><font face=\"Verdana\"><u>AVAYA.com AUTOMATION TEST REPORT - "+ft.format(dNow)+"<u></font></h2>");
		 
		 pw.println("<image src=\"http://www.avaya.com/usa/images/avaya-logo\" align=\"right\"><br><br><br>");
		 
		 pw.println("<TABLE align=\"center\" ><font face=\"Verdana\"><TR><TD  width=\"50%\">");
		 pw.println("<h4><u>COMPLETE TEST EXECUTION STATUS</u></h4>");
		 pw.println("<table BORDER=2 align=\"center\">" +
					"<tbody><tr><th>Total Tests</th><th>No.of Scripts Passed</th><th>No.of Scripts Skipped</th><th>No.of Scripts Failed</th><th>Total Time(sec) taken to Complete Test Run</th></tr><tr>	" +
					"<th colspan=\"6\">Suite</th></tr><tr><td class=\"num\" align=\"center\">"+result.gettotalcount()+"</td><td class=\"num\" align=\"center\">"+result.getpasscount()+"</td><td class=\"num\" align=\"center\">"+result.getskipcount().toString()+"</td>" +
					"<td class=\"num attn\" align=\"center\">"+result.getfailcount()+"</td><td class=\"num\" align=\"center\">"+Double.parseDouble(result.getduration().toString())/1000+"</td></tr></tbody></table></body></html>");
		 // Table with Test Status Count related w.r.t Browsers
		 pw.println("</TD><TD>");
		 pw.println("<h4><u>DETAILED TEST EXECUTION STATUS</u></h4>");
		 pw.println("<table border=2><tr><th>OS and Browser</th><th>Total No.of Test Scripts</th><th>No.of Scripts Passed</th><th>No.of Scripts Failed</th><th>No.of Scripts Skipped</th></tr>");
		 for(int i=0;i<result.getbrowserstatus().size();i=i+5)
		 {
			 pw.println("<tr><td align=\"center\">"+result.getbrowserstatus().get(i)+"<td align=\"center\">"+result.getbrowserstatus().get(i+1)+"<td align=\"center\">"+result.getbrowserstatus().get(i+2)+"<td align=\"center\">"+result.getbrowserstatus().get(i+3)+"<td align=\"center\">"+result.getbrowserstatus().get(i+4));
		 }
		
		 pw.println("</table><br>");
		 pw.println("</TD></TR>");
		 pw.println("<TR><TD>");
		 pw.println("<html><head><script type=\"text/javascript\" src=\"https://www.google.com/jsapi\"></script>"
				 +"<script type=\"text/javascript\">"
				 + "google.load(\"visualization\", \"1\", {packages:[\"corechart\"]});"
				 + "google.setOnLoadCallback(drawChart);"
				 + "function drawChart() {"
				 +  "var data = google.visualization.arrayToDataTable([");
		 pw.println("['Area', 'Pass', 'Fail', 'Skip'],");
		 			//System.out.println(datatable.length);
		 			for(int i=0;i<datatable.length;i++)
		 			{
		 				pw.println("['"+datatable[i][0]+"'"+", "+datatable[i][1]+", "+datatable[i][2]+", "+datatable[i][3]+"]");
		 				if(!(i==(datatable.length-1)))
		 				pw.print(",");
		 			}
				 pw.println("]);"
				 +"var chart = new google.visualization.BarChart(document.getElementById('chart_div'));"
				 + "chart.draw(data, {width: 600, height: 900, min: 0, isStacked: true, orientation: 'vertical', colors:['green','red','yellow']});"
				 +"}"
				 +"</script>"
				 +"</head>"
				 +"<body>"
				 +"<div id=\"chart_div\"></div>"
				 +"</body>"
				 +"</html>");
		 pw.println("</TD><TD>");
		 pw.println("<html><head><script type=\"text/javascript\" src=\"https://www.google.com/jsapi\"></script><script type=\"text/javascript\">google.load(\"visualization\", \"1\", {packages:[\"corechart\"]});google.setOnLoadCallback(drawChart);function drawChart() {var data = google.visualization.arrayToDataTable([['TestStatus', 'Count'],['Pass',"+     result.getpasscount().toString()+"],['Fail',"+      result.getfailcount().toString()+"],['Skipped',"+ result.getskipcount().toString()+"]]);var options = {title: 'Pie Chart', colors: ['green','red','yellow']};var chart = new google.visualization.PieChart(document.getElementById('piechart'));chart.draw(data, options);}</script></head><body align=\"centre\"><div align=\"center\"><div id=\"piechart\"  style=\"width: 600px; height: 500px; float:right \"></div></div></body></html>");
		 pw.println("</TD></font></TABLE>"); 
		 
		 
		 //Error Message 
		 if(Integer.parseInt(result.getfailcount().toString())>0 || Integer.parseInt(result.getskipcount().toString())>0)
		 {
			 pw.println("<h4><u>FAILED SCRIPTS DETAILS</u></h4>");
			 pw.println("<TABLE BORDER=2><TR><TH>Browser</TH><TH>TestName<TH>Test Description<TH>Status<TH>Error Message<TH>Duration(sec)<TH>Screen Shot</TR></font>");
			 for (int i = 0; i < Integer.parseInt(result.gettotalcount().toString()); i++) 
			 {
				 if(result.getStatus().get(i).toString().equals("FAIL") || result.getStatus().get(i).toString().equals("SKIP"))
				 {
					
					 pw.println("<TR><TD>"+result.gettestname().get(i)+"<TD>"+result.gettestmethodname().get(i) +"<TD>"+result.getTestMethodDesc().get(i)+"<TD>" + result.getStatus().get(i)+"<TD>"+result.geterrormessage().get(i)+"<TD>"+Double.parseDouble((String) result.gettestrundduration().get(i))/1000+"");
				
					 if(result.getscreenshotlinks().get(i)!="No Screen Shot")
					 {
					 pw.println("<TD><a href=\""+result.getscreenshotlinks().get(i)+"\">Screenshot</a></TD>");	
					 }
					 else
					 {
						 pw.println("<TD>--</TD>");
					 }
				 }
			 }
         
			 pw.println("</TABLE></body>");                 
			
		 }
		 
		 pw.close();	

	}

}
