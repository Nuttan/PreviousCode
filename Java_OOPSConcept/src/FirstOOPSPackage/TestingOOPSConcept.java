package FirstOOPSPackage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TestingOOPSConcept {
	
	public String name;
	
	public TestingOOPSConcept()
	{
		System.out.println("I am inside default constructor");
	}
	
	public TestingOOPSConcept(String str)
	{
		this.name=str;
		System.out.println(" i am inside parameterized constructor and the Value is :" +str);
		
	}
	
	private static void show()
	{
		System.out.println("Inside static method");
	}
	
	private void nonstaticshow()
	{
		System.out.println("Inside non static method");
	}

	public static void main(String[] args) {
		
		//TestingOOPSConcept obj1=new TestingOOPSConcept();
		TestingOOPSConcept obj2=new TestingOOPSConcept("Nuttan");
		TestingOOPSConcept.show();
		obj2.nonstaticshow();
		
		
		String removeElem = "Perl";
        List<String> myList = new ArrayList<String>();
        myList.add("Java");
        myList.add("Unix");
        myList.add("Oracle");
        myList.add("C++");
        myList.add("Perl");
        System.out.println("Before remove:");
        System.out.println(myList);
        Iterator<String> itr = myList.iterator();
        while(itr.hasNext()){
            if(removeElem.equals(itr.next())){
                itr.remove();
               
            }
        }
        System.out.println("After remove:");
        System.out.println(myList);
        

	}

}
