package MainController;
import Controler.StudentController;

public class Main {

	public static void main(String[] args) {
		StudentController s1 = new StudentController();
		try
		{
			s1.start();			
		}catch(Exception Ex) {
			System.out.println(Ex);
		}
	}
}
