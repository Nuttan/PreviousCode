package FirstOOPSPackage;
	
class TestApp {
	 
    public static void main(String args[]) {
    	testapp2 t=new testapp2();
    	t.test();
    }  
}

class testapp2
{
	static int index = 0;
	public  void test() {
		   index++;
	        
	        System.out.println(++index); 
	    }
}



