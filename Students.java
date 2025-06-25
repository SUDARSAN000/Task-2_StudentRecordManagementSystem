package Day_2;

public class Students {
	
	private int id ;
	private String name;
	private double mark;
	
	public Students(int id, String name, double mark) {
		this.id = id;
		this.name = name;
		this.mark = mark;
	}

	public int getId() { return id; }

	public String getName() { return name; }

	public void setName(String name) { this.name = name; }

	public double getMark() { return mark; }

	public void setMark(double mark) { this.mark = mark; }

	@Override
	public String toString() {
		return "Student [id   : " + id + ", name : " + name + ", mark : " + mark + "]";
	}
	
}
