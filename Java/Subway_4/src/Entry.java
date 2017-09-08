
public class Entry {
	public String SName;
	public String SNo;
	public String[] transfer = new String[2];
	public int judge;
	public int sn;
	public char line;

	public Entry(){}
	/**
	 * 输入一个站的名字或者是序号都可以在MySQL中找到对应的项
	 * @param name
	 */
	public Entry(String name){
		char[] temp = name.toCharArray();
		if(name =="798艺术街区"){
			this.set(name);
		}
		else{
			if((temp[1]<48||temp[1]>57)||(temp[2]<48||temp[2]>57)){
				this.set(name);
			}
			else{
				this.setBySNo(name);
			}
		}
	}

	public void set(String name){
		GetInformation get = new GetInformation(name);
		get.find();
		String temp = get.getSName();
		if(!name.equals(temp)){
			this.SName = temp;
		}
		else{
			this.SName = name;
		}

		this.SNo = get.getSNo();
		this.sn = get.getSn();
		this.line = get.getLine();
		this.judge = get.getJudge();
		this.transfer = get.getTransfer();
	}

	public void setBySNo(String name){
		GetInformation get = new GetInformation();
		get.setSno(name);
		get.findBySNo();
		String temp = get.getSName();

		this.SNo = name;
		this.SName = temp;
		this.sn = get.getSn();
		this.line = get.getLine();
		this.judge = get.getJudge();
		this.transfer = get.getTransfer();

	}

	public String toString(){
		return this.SName + "-->";
	}

}
