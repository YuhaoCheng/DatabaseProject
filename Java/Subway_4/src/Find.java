import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Find {
	String tempSNo_s = "";
	int column_s =0;
	int judge1 = 1;
	int judge2 = 1;//判断start和end是否在一条线上，如果在，则标记为0
	int distance =0;
	Entry start; //在哪儿站附近找换乘站
	Entry end;//参考变量

	String driver = "com.mysql.jdbc.Driver";
	String url = "jdbc:mysql://127.0.0.1:3306/db_coursework";
	String user = "root";
	String password = "";

	public Find(Entry s, Entry e){
		this.start = s;

		this.end = e;

        if(start.line == end.line){

        	judge2 = 0;
        	distance = start.sn - end.sn;
        }

		System.out.println();
	}

	public String getTransferSno(){
	   return this.tempSNo_s;
	}

	public void findBestTransfer(){


		try{
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url, user, password);
			if(conn.isClosed())
				System.out.println("Fail to connect database ");

			 Statement statement = conn.createStatement();
			 String sql1_0 = "select count(*) as count from " + start.line + " where transfer = 1";
			 ResultSet rs1_0 = statement.executeQuery(sql1_0);

			 rs1_0.next();
			 column_s = rs1_0.getInt("count");
			 if(start.judge == 1){column_s = column_s - 1;}
			 rs1_0.close();
			 int[] array_s = new int[column_s];


			 String  sql1 = "select * from " + start.line +"  where transfer = 1 order by S_No";
			 ResultSet rs1 = statement.executeQuery(sql1);


			 int i =0;
	outer:   while(rs1.next()){

				 String t0 = start.SNo;
				 String temp_s = rs1.getString("S_No");

				 if(temp_s.equals(t0)){

					 //System.out.println("找到了自己！！！");
				 }
				 else{
					 Entry temp = new Entry(temp_s);

					 if(end.judge!=0){
						 for(int a = 0;a<temp.transfer.length&&(temp.transfer[a] != null);a++){
							 String b = temp.transfer[a];
							 char[] templ = b.toCharArray();
							 if(templ[0] == end.line){
								 tempSNo_s = temp_s;
								 judge1 =0;

								 break outer;
							 }
						 }
					 }
					 else{
						 for(int c =0;c<end.transfer.length&&(end.transfer[c]!=null);c++){
							 String temp_0 = end.transfer[c];
							 char[] temp1 = temp_0.toCharArray();
							 for(int d = 0;d<temp.transfer.length&&(temp.transfer[d]!=null);d++){
								 String temp_1 = temp.transfer[d];
								 char[] temp2 = temp_1.toCharArray();
								 if(temp1[0] == temp2[0]){

									 tempSNo_s = temp_1;

									break outer;
								 }
							 }
						 }
					 }



					 int t = this.subtract(t0,temp_s);
					 array_s[i] = t;
					 i++;
				 }
			}
			rs1.close();
			conn.close();
			if(judge1==1&&(judge2==1)){
				this.bubbleSort(array_s);
				if((start.sn +array_s[0])>=10){
					tempSNo_s = String.valueOf(start.line) + (start.sn + array_s[0]);
				}
				else{
					tempSNo_s = String.valueOf(start.line) + '0'+(start.sn + array_s[0]);
				}
				GetInformation g = new GetInformation();
				g.setSno(tempSNo_s);
				g.findBySNo();

				if(g.getJudge() != 1){
					if((start.sn -array_s[0]) >= 10){
						tempSNo_s = String.valueOf(start.line) + (start.sn -array_s[0]);}
					else{
						tempSNo_s = String.valueOf(start.line) + '0'+(start.sn - array_s[0]);
					}
				}
				else{
					Entry temp = new Entry(tempSNo_s);
					for(int m = 0;m <temp.transfer.length;m++){

						if(temp.transfer[m] != start.SNo){
							if((start.sn +array_s[0]) >= 10){
								tempSNo_s = String.valueOf(start.line) + (start.sn +array_s[0]);}
							else{
								tempSNo_s = String.valueOf(start.line) + '0'+(start.sn + array_s[0]);
							}
						}
					}
				}
			}

			if(judge1==1&&(judge2!=1)){
			  this.bubbleSort(array_s);
			  if(distance<0){
				  if((start.sn +array_s[0]) >= 10){
						tempSNo_s = String.valueOf(start.line) + (start.sn +array_s[0]);}
					else{
						tempSNo_s = String.valueOf(start.line) + '0'+(start.sn + array_s[0]);
					}
			  }
			  else{
				  if((start.sn -array_s[0]) >= 10){
						tempSNo_s = String.valueOf(start.line) + (start.sn -array_s[0]);}
				   else{
						tempSNo_s = String.valueOf(start.line) + '0'+(start.sn - array_s[0]);
					}
			  }
			}




		}
		catch(ClassNotFoundException d) {
			System.out.println("Sorry,can`t find the Driver!");
			d.printStackTrace();
		}
		catch(SQLException d) {
			d.printStackTrace();
		}
		catch(Exception d) {
			d.printStackTrace();
		}

		if(start.SName =="白堆子"){
			tempSNo_s ="A09";
		}
		//if(start.SName == "大望路"){
			//tempSNo_s = "K10";
		//}
		//if(start.SName == "九龙山" && end.SName=="东直门"){
			//tempSNo_s = "B09";
		//}

	}



	public  int subtract(String s1,String s2){  //s1是现在的站，就是要找s1附近最近的换乘站，是s1-s2
		char[] temp1 = s1.toCharArray();
		char[] temp2 = s2.toCharArray();

		int  temp1_int=(temp1[1]-48)*10 + (temp1[2]-48);
		int  temp2_int=(temp2[1]-48)*10 + (temp2[2]-48);

		int result = Math.abs(temp1_int-temp2_int);
		//System.out.println(result + "in substract");
		return result;
	}
	public static void bubbleSort(int[] numbers) {
	    int temp; // 记录临时中间值
	    int size = numbers.length; // 数组大小
	    for (int i = 0; i < size - 1; i++) {
	        for (int j = i + 1; j < size; j++) {
	            if (numbers[i] > numbers[j]) { // 交换两数的位置
	                temp = numbers[i];
	                numbers[i] = numbers[j];
	                numbers[j] = temp;
	            }
	        }
	    }
	}
}
