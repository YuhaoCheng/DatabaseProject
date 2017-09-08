import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.*;
/**
 * 连接数据库并从中获取S_no,S_name
 * @author Think
 *
 */
public class GetInformation {
		private String SNo; //表中的站的序号
		private String SName;//站的名字
		private String transfer[] = new String[2];
		private int judge;
		private int sn;// 某一站在地铁线上的位置
		private char line;// 某一站在那一条地铁上

		public GetInformation(){}

		public GetInformation(String name){
			this.SName = name;
		}


		public void setSno(String SNo){
			this.SNo = SNo;
		}

		public void setSName(String Sname){
			this.SName = Sname;
			System.out.println(this.SName);//
		}

		public void setSn(int sn){
			this.sn = sn;
		}

		public void setLine(char line){
			this.line = line;
		}

		public int getSn(){
			return this.sn;
		}

		public char getLine(){
			return this.line;
		}

		public String getSName(){
			return this.SName;
		}
        public String getSNo(){
        	return this.SNo;
        }

		public int getJudge(){
			return this.judge;
		}


		public String[] getTransfer(){
			return this.transfer;
		}

		/**
		 * 找到所输入的景点或车站名在数据库中所对应的SName和SNo，并将SNo分解为字符类型的line 和 整型的sn
		 *
		 */
		public void find(){
			String driver = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://127.0.0.1:3306/db_coursework";
			String user = "root";
			String password = "";
			String name;

			char[] l = new char[16];
				for(int i = 0; i<16;i++){
					l[i] = (char)(97+i);
				}

			try{
				Class.forName(driver);
				Connection conn = DriverManager.getConnection(url, user, password);
				if(conn.isClosed())
					{
					System.out.println("Fail to connect database ");
					}

				Statement statement = conn.createStatement();
		outer:	for(int i = 0; i<16;i++){
					String sql1 = "Select * from "+ l[i];
					ResultSet  rs1 = statement.executeQuery(sql1);
					 while(rs1.next()){
						 name = rs1.getString("attraction");
						 if((SName.equals(name))){
							 this.SName = rs1.getString("S_name");// snname.add(rs1)
							 this.SNo = rs1.getString("S_No");
							 this.judge = rs1.getInt("transfer");
							 break outer;
						 }
					}
					String sql2 = "Select * from "+ l[i];
					ResultSet  rs2 = statement.executeQuery(sql2);
					while(rs2.next()){
						 name = rs2.getString("S_name");
						if((SName.equals(name))){
							this.SNo = rs2.getString("S_No");
							this.judge = rs2.getInt("transfer");
							break outer;
						}
					}
				}
				if(judge != 0){
					String sql = "Select * from q";
					ResultSet  rs = statement.executeQuery(sql);
					int i = 0;
					while(rs.next()){
						String temp_t1 = rs.getString("T_line1");
						String temp_t2 = rs.getString("T_line2");
						if(temp_t1.equals(this.SNo)){
							this.transfer[i] = temp_t2;
							i++;
						}

					}
				}
				conn.close();

			}
				 catch(ClassNotFoundException e) {
			         System.out.println("Sorry,can`t find the Driver!");
			         e.printStackTrace();
			        } catch(SQLException e) {
			         e.printStackTrace();
			        } catch(Exception e) {
			         e.printStackTrace();
			        }
			if(SNo == null||SName == null){
				System.out.println("Error in GetInformation find()");
			}
			else{
			char[] temp = SNo.toCharArray();
			this.line = temp[0];

			int t = 0;
			t = (temp[1]-48)*10 + (temp[2]-48);
			this.sn = t;
			}


		}

		public void findBySNo(){
			String driver = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://127.0.0.1:3306/db_coursework";
			String user = "root";
			String password = "";
			String tempSN;

			char[] l = new char[16];
				for(int i = 0; i<16;i++){
					l[i] = (char)(97+i);
				}

			try{
				Class.forName(driver);
				Connection conn = DriverManager.getConnection(url, user, password);
				if(conn.isClosed())
					{
					System.out.println("Fail to connect database ");
					}

				Statement statement = conn.createStatement();
		outer:	for(int i = 0; i<16;i++){
					String sql1 = "Select * from "+ l[i];
					ResultSet  rs1 = statement.executeQuery(sql1);
					 while(rs1.next()){
						 tempSN = rs1.getString("S_No");
						 if((SNo.equalsIgnoreCase(tempSN))){
							 this.SName = rs1.getString("S_name");
							 this.SNo = rs1.getString("S_No");
							 this.judge = rs1.getInt("transfer");
							 break outer;
						 }
					}

				}
				if(judge != 0){
					String sql = "Select * from q";
					ResultSet  rs = statement.executeQuery(sql);
					int i = 0;
					while(rs.next()){
						String temp_t1 = rs.getString("T_line1");
						String temp_t2 = rs.getString("T_line2");
						if(temp_t1.equals(this.SNo)){
							this.transfer[i] = temp_t2;
							i++;
						}

					}
				}
				conn.close();

			}
				 catch(ClassNotFoundException e) {
			         System.out.println("Sorry,can`t find the Driver!");
			         e.printStackTrace();
			        } catch(SQLException e) {
			         e.printStackTrace();
			        } catch(Exception e) {
			         e.printStackTrace();
			        }
			if(SNo == null||SName == null){
				System.out.println("Error in GetInformation in findBySNo()");
			}
			else{
			char[] temp = SNo.toCharArray();
			this.line = temp[0];

			int t = 0;
			t = (temp[1]-48)*10 + (temp[2]-48);
			this.sn = t;
			}

		}

		public ArrayList<String> findLine(char temp){
			String driver = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://127.0.0.1:3306/db_coursework";
			String user = "root";
			String password = "";
			String name = "";
			int total = 0;

			char[] l = new char[16];
			for(int i = 0; i<16;i++){
				l[i] = (char)(97+i);
			}

		try{
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url, user, password);
			if(conn.isClosed())
				{
				System.out.println("Fail to connect database ");
				}

			Statement statement = conn.createStatement();
			String sql0 = "select count(*) as count from " + temp;
			System.out.println(sql0);
			ResultSet rs0 = statement.executeQuery(sql0);
			rs0.next();
			total = rs0.getInt("count");
			rs0.close();
			conn.close();

		}
			 catch(ClassNotFoundException e) {
		         System.out.println("Sorry,can`t find the Driver!");
		         e.printStackTrace();
		        } catch(SQLException e) {
		         e.printStackTrace();
		        } catch(Exception e) {
		         e.printStackTrace();
		        }
		ArrayList<String> tempLine = new ArrayList<String>();

			try{
				Class.forName(driver);
				Connection conn = DriverManager.getConnection(url, user, password);
				if(!conn.isClosed())
					{
					System.out.println("Fail to connect database ");
					}

				Statement statement = conn.createStatement();
				String sql1 = "Select * from " + temp +" order by S_No";
			    ResultSet  rs1 = statement.executeQuery(sql1);
			    int  i =0;
				System.out.println(sql1);
				while(rs1.next()){
					name = rs1.getString("S_Name");
					tempLine.add(name);
					i++;
				}
				conn.close();

			}
				 catch(ClassNotFoundException e) {
			         System.out.println("Sorry,can`t find the Driver!");
			         e.printStackTrace();
			        } catch(SQLException e) {
			         e.printStackTrace();
			        } catch(Exception e) {
			         e.printStackTrace();
			        }
			System.out.println(tempLine);
		return tempLine;
		}

}
