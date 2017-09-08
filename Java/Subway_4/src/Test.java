
public class Test {

	public static void main(String[] args) {
		String start = "北邮本部";
		String end  = "潘家园";
		Calculation c = new Calculation(start,end); 
        c.findShortPath();
       // String queryLine = c.getLine();
       // System.out.println("得到的");
      // System.out.println(queryLine);
	}

}
