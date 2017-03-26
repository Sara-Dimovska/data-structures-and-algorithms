package singlyWclassSTudent;

public class Student 
{

	public String ime,prezime;
	public double prosek;
	
	public Student(String ime,String prezime,double prosek)
	{
		this.ime = ime;

		this.prezime = prezime;

		this.prosek = prosek;
	}
	public void display()
	{
		System.out.println(ime + "," + prezime + "," + prosek );
	}
}
