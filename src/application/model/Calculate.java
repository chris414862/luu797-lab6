package application.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
/**
 * Class to help calculate input from user
 * 
 * @author chris414862
 * UTSA Application Programming CS3443 Fall 2018
 */
public class Calculate {
	/**
	 * 
	 * @param input
	 * @return
	 */
	public static boolean equalsOneHundred(HashMap<TextField, Slider> input) {
		int sum=0;
		Set set = input.keySet();
		Iterator<TextField> it = set.iterator();
		while(it.hasNext())
			sum += Integer.parseInt(it.next().getText());

		return sum == 100;
	}
	
	/**
	 * 
	 * @param strings
	 * @return
	 */
	public static ArrayList<Integer> stringsToIntArrayList(ArrayList<String> strings){
		ArrayList<Integer> newInts = new ArrayList<Integer>();
		for(int i = 0; i < strings.size(); i++) {
			newInts.add(Integer.parseInt(strings.get(i)));
		}		
		return newInts;		
	}
	
	/**
	 * 
	 * @param gradesAndWeights
	 * @return
	 */
	public static Double calcWeightedAvg(HashMap<TextField, Slider> gradesAndWeights) {
		double grade = 0.0;
		Iterator<TextField> it = gradesAndWeights.keySet().iterator();
		while(it.hasNext()) {
			TextField t = it.next();
			grade += (Double.parseDouble(t.getText())/100)*(gradesAndWeights.get(t).getValue());
		}
		return grade;
	}

	/**
	 * 
	 * @param grade
	 * @return
	 */
	public static String calcLetterGrade(double grade) {
		if(grade >= 90.0)
			return "A";
		else if(grade >= 80.0)
			return "B";
		else if(grade >= 70.0)
			return "C";
		else if(grade >= 60.0)
			return "D";
		else
			return "F";
	}
	
	/**
	 * 
	 * @param str
	 * @return
	 * @throws Exception
	 */
	public static ArrayList<Double> convertStringToDoubles(String str) throws Exception{
		ArrayList<Double> result = new ArrayList<Double>();
		String tokens[] = str.split(" +");
		for(int i = 0; i < tokens.length; i++) {
			result.add(Double.parseDouble(tokens[i].trim()));
		}
		return result;
	}
	
	/**
	 * 
	 * @param numbers
	 * @return
	 */
	public static String average(ArrayList<Double> numbers) {
		Double sum= 0.0;
		for(int i = 0; i < numbers.size(); i++) 
			sum += numbers.get(i);
		return String.format("%.2f", sum / numbers.size());
	}
}
