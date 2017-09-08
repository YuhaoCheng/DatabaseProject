import java.sql.Connection;
import java.util.*;
import java.io.*;
public class Calculation {
	public String start;
	public String end;
	private String output_one = "";
	private String output_two = "";

	public Calculation(){}
	public Calculation(String s, String e){
		this.start = s;
		//System.out.println(s + "鍒濆鍖� Start");
		this.end = e;
		//System.out.println(e + "鍒濆鍖朎nd");
	}

	public void setInfo(String s,String d){
		this.start = s;
		this.end = d;
	}

	public String getLine(){
		//if(output_one != "")
		    this.findShortPath();
			return output_one + output_two;
	}

	public void setStart(String name){
		this.start = name;
	}

	public void setEnd(String name){
		this.end = name;
	}

	public void findShortPath(){
		Entry s = new Entry(this.start);
		Entry e = new Entry(this.end);
		String[] stransfer = new String[2];
		char[] stline = new char[2];
		String[] etransfer = new String[2];
		char[] etline = new char[2];

		if(s.judge != 0){
			stransfer = s.transfer;
			for(int i = 0; (i<stransfer.length)&& (stransfer[i] != null);i++){
				char[] temp = stransfer[i].toCharArray();
				stline[i] = temp[0];
			}
		}
		if(e.judge != 0){
			etransfer = e.transfer;
			for(int i = 0; (i<etransfer.length) && (etransfer[i] != null);i++){
				char[] temp = etransfer[i].toCharArray();
				etline[i] = temp[0];
			}
		}
		int x =0;
		int y =0;
		int sx =0;
		int ey =0;
  outer:for(;x<stransfer.length;x++){
	  		if(stline[x]==e.line){
	  			sx=1;

	  			break outer;
	  		}
	  		else{
	  			for(;y<etransfer.length;y++){
	  				if(etline[y]==s.line){
	  					ey =1;

	  					break outer;
	  				}
	  				if((stline[x] == etline[y])&&(stransfer[x]!=null)&&(etransfer[y]!= null)){
	  					sx =1;
	  					ey =1;
	  					//System.out.println("Error");
	  					break outer;
	  				}
	  			}
	  		}
		}

		if((sx==1)&&(stransfer[x]!=null)){
			String temp = stransfer[x];
			Entry st0 = new Entry(temp);
			s = st0;
		}
		if((ey==1)&&(etransfer[y]!= null)){
			Entry et0 = new Entry(etransfer[y]);
			e = et0;
		}

		ArrayList<Entry> route = new ArrayList<Entry>();

		if(s.line == e.line){

			if(s.sn<=e.sn){
				int t = e.sn- s.sn;
				t = t-1;

				if(t < 0){
					t = 0;
				}
				int[] temp_sn = new int[t];
				route.add(s);

				for(int i = 0; i<t;i++){
					temp_sn[i] = s.sn + i +1;//鏄粠璧风偣绔欑殑涓嬩竴绔欏紑濮嬫暟鐨勶紝鎵�浠ュ姞1
				}

				String[] temp = new String[t];
				String[] temp_SNo = new String[t];
				for(int j = 0;j<t;j++){
					if(temp_sn[j]<10){
						temp[j] = "0" + Integer.toString(temp_sn[j]);
						temp_SNo[j] = s.line + temp[j];
					}
					else{
						temp[j] = Integer.toString(temp_sn[j]);
						temp_SNo[j] = s.line + temp[j];
					}
				}
				for(int m = 0; m<t;m++){
					Entry tempet =new Entry(temp_SNo[m]);

					route.add(tempet);
				}
				route.add(e);
				//System.out.println("~~~~~~~~~~@@@@@璺緞杈撳嚭锛�");
				for(int n = 0; n<(t+2);n++){
					//System.out.print(route.get(n) + "-->");
					//output_one += route.get(n) + "-->";
					String s1 = route.get(n).SName;
					this.write(s1);
					
				}
				for(int i = 0; i< route.size();i++){
					//output_one = output_one + route.get(i);
				}
            	//System.out.println(output_one);
				//System.out.println();
			}
			//s.sn<e.sn鐨勬儏鍐电粨鏉�
			if(s.sn > e.sn){
				int t = s.sn- e.sn;
				t = t-1;
				int[] temp_sn = new int[t];

				route.add(s);

				for(int i = 0; i<t;i++){
					temp_sn[i] = s.sn + i-t;//鏄粠璧风偣绔欑殑涓嬩竴绔欏紑濮嬫暟鐨勶紝鎵�浠ュ姞1
				}

				String[] temp = new String[t];
				String[] temp_SNo = new String[t];
				for(int j = 0;j<t;j++){
					if(temp_sn[j]<10){
						temp[j] = "0" + Integer.toString(temp_sn[j]);
						temp_SNo[j] = s.line + temp[j];
					}
					else{
						temp[j] = Integer.toString(temp_sn[j]);
						temp_SNo[j] = s.line + temp[j];
					}
				}

				for(int m = t-1; m>=0;m--){
					Entry tempet =new Entry(temp_SNo[m]);
					route.add(tempet);
				}
				route.add(e);

				//System.out.println("~~~~~~~~~~@@@@@璺緞杈撳嚭锛�");
				for(int n = 0; n<(t+2);n++){
					 //System.out.print(route.get(n) + "-->");
					//ouput_two += route.get(n) + "-->";
					String s1 = route.get(n).SName;
					this.write(s1);
				}
				for(int i = 0;i< route.size();i++){
					//output_two = output_two + route.get(i);
				}
				//System.out.println(output_two);
				//System.out.println();
			}
			//s.sn>e.sn鐨勬儏鍐电粨鏉�
		}
		if(s.line != e.line){
			String tempSNo_s = "";
			String tempSNo_e = "";

			Find fs = new Find(s,e);
			fs.findBestTransfer();
			tempSNo_s =  fs.getTransferSno();
			//瀵绘壘浜ょ偣

			Entry st = new Entry(tempSNo_s);


			Calculation c1 = new Calculation(this.start,tempSNo_s);
			c1.findShortPath();

			for(int i =0;(i<st.transfer.length)&&(st.transfer[i] != null);i++){
				String temp_0 = st.transfer[i];
				char[] temp = temp_0.toCharArray();
				if(temp[0] == e.line){
					Entry st_0 = new Entry(temp_0);
					st = st_0;
				}
			}
			if(e.judge==1){
				for(int i = 0;(i<e.transfer.length)&&(e.transfer[i]!= null);i++){
					String temp_0 = e.transfer[i];
					char[] temp1 = temp_0.toCharArray();
					for(int j = 0;(j<st.transfer.length)&&(st.transfer[j]!=null);j++){
						String temp_1 = st.transfer[j];
						char[] temp2 = temp_1.toCharArray();
						if(temp1[0] == temp2[0]){
							Entry e_0 = new Entry(temp_0);
							e = e_0;
						}
					}
				}
			}

			if(st.line == e.line){
				String temp_st = st.SNo;
				Calculation c2 = new Calculation(temp_st,this.end);
				c2.findShortPath();
			}
			else{
				Find fe = new Find(e,st);
				fe.findBestTransfer();

				tempSNo_e =  fe.getTransferSno();
				Entry et = new Entry(tempSNo_e);



				if(st.line == et.line){
					Calculation c3 = new Calculation(st.SNo,et.SNo);
					c3.findShortPath();
					Calculation c4 = new Calculation(et.SNo,e.SNo);
					c4.findShortPath();
				}
				else{
					Calculation c5 = new Calculation(st.SNo,et.SNo);
					c5.findShortPath();
					Calculation c5_1 = new Calculation(et.SNo,e.SNo);
					c5_1.findShortPath();
				}

			}
		}//if(s.sn != e.sn)


	}//find_short_path
	
	public void write(String s){
		try{
			FileWriter fw =new FileWriter("..\\route.txt",true);
			fw.write(s);
			fw.write("-->");
			fw.close();
			
		}catch(IOException e){
			e.printStackTrace();
			
		}
		
	}
}
