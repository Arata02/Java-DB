package en02;

public class Cat {
	private String name;
	private String kind;
	private String sex;
	private double weight;

	public void setName(String name) {
		this.name = name;
	}


	public void setKind(String kind) {
		this.kind = kind;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public String getName() {
		return name;
	}

	public String getKind() {
		return kind;
	}

	public String getSex() {
		return sex;
	}

	public double getWeight() {
		return weight;
	}

	public void printCat() {
		System.out.println(name + "(" + kind + ")" + " : " + weight + "kg");
	}
}

