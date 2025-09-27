package Student;

public class Student {
	int roll;
	String name;
	double marks;

	public Student(int roll, String name, double marks) {
		this.roll = roll;
		this.name = name;
		this.marks = marks;
	}

	public int getRoll() {
		return roll;
	}

	public String getName() {
		return name;
	}

	public double getMarks() {
		return marks;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setMarks(double marks) {
		this.marks = marks;
	}

	public static int compareNames(String name1, String name2) {
		int len1 = name1.length(), len2 = name2.length();
		int minLen = Math.min(len1, len2);

		for (int i = 0; i < minLen; i++) {
			char c1 = Character.toLowerCase(name1.charAt(i));
			char c2 = Character.toLowerCase(name2.charAt(i));
			if (c1 != c2)
				return c1 - c2;
		}

		return len1 - len2;
	}

	@Override
	public String toString() {
		return "Roll: " + roll + ", Name: " + name + ", Marks: " + marks;
	}
}
