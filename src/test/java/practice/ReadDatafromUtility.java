package practice;

import java.io.IOException;

import genericUtilities.PropertyFileUtility;

public class ReadDatafromUtility {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		PropertyFileUtility pUtility= new PropertyFileUtility();
		String url = pUtility.ReadDataFromPropertyFile("url");
		System.out.println(url);
	}

}
