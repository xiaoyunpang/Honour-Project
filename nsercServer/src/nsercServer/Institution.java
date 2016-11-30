package nsercServer;

public class Institution {
	public String name;
	public int number;
	public int amount;
	public int avg;
	
	public Institution() {}
	
	public Institution(String name, int number, int amount) {
		this.name = name;
		this.number = number;
		this.amount = amount;
		this.avg = amount/number;
	}
	
	public String getname() { return this.name; }
	public int getnumber() { return this.number; }
	public int getamount() { return this.amount; }
	public int getavg() { return this.avg; }

}
