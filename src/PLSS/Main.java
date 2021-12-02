package PLSS;
import java.io.File;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class Main {

	public static void main(String[] args) throws Exception, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		AlgorithmTester tester=new AlgorithmTester();
		DataGenerator engine = new DataGenerator();
		Object[] res= {};
		for(int n=0;n<=1000;n++) {
		Object[] data=engine.generate(n);
		res=tester.execute("plsscDynamique",data,n);
		print(res,"Resultat_plsscDynamique");
		}
		
		for(int n=0;n<=25;n++) {
			Object[] data=engine.generate(n);
			res=tester.execute("plsscRecursive",data,n);
			print(res,"Resutat_plsscRecursive");
			}
		
		for(int n=0;n<=25;n++) {
			Object[] data=engine.generate(n);
			res=tester.execute("plsscMemorization",data,n);
			print(res,"Resultat_plsscMemorization");
			}
		
		
		System.out.println("fin");
	}


	
	
	
	
	
	

	private static void print(Object[] data, String filename) throws Exception {
		File file = new File(filename+".txt");
		FileWriter fr = null;
		BufferedWriter br = null;
		String plls=data[0].toString();
		String n=data[1].toString();
		String t=data[2].toString();
		try {
			// to append to file, you need to initialize FileWriter using below constructor
			fr = new FileWriter(file, true);
			br = new BufferedWriter(fr);
			br.newLine();
			br.write(plls+"   "+n+"   "+t);

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
				fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}


	
	
	
	
	
	
	
	
	
	
}
