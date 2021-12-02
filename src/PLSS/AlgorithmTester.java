package PLSS;

import java.lang.reflect.*;



public class AlgorithmTester {
	
	public Object[] execute(String methodName, Object[] data,int n) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		Algorithms algo = new Algorithms();
	    String X=(String) data[0];
	    String Y=(String) data[1];
	    int i= (int) data[2];
	    int j= (int) data[3];
	    System.out.println(data[0]);
	    System.out.println(data[1]);
	    
	    try {
		    Class<?>[] paramTypes = {String.class, String.class, int.class,int.class};
		    Method method = algo.getClass().getMethod(methodName, paramTypes);
		    long t0 = System.currentTimeMillis();
		    int plls=(int)method.invoke(algo,Y,X,j,i);
		    long tf = System.currentTimeMillis();
		    Object[] res= {plls,n,tf-t0};
		    return res;
	    }
	    
	    catch(Exception e) {
	    
		    Class<?>[] paramTypes = {String.class, String.class};
		    Method method = algo.getClass().getMethod(methodName, paramTypes);
		    long t0 = System.currentTimeMillis();
		    int plls=(int)method.invoke(algo,Y,X);
		    long tf = System.currentTimeMillis();
		    Object[] res= {plls,n,tf-t0};
		    return res;
	    }
	    
	    }
	    
			
	
	
	
	
	
	
	
	

	
	

}
