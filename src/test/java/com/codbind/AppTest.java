package com.codbind;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.codebind.App;

public class AppTest {

	@Test
	public void testMapShouldPopulateWithCorrectData() throws IOException {
		ArrayList<String> s = new ArrayList<String>();
		Map<String, ArrayList<String>> Hierarchy = new HashMap<String, ArrayList<String>>();
		s.add("Stjepan");
		Hierarchy.put("Adam",s);
		
		s = new ArrayList<String>();
		s.add("Adam");
		s.add("Fran");
		Hierarchy.put("Ivan",s);
		
		s = new ArrayList<String>();
		s.add("Leopold");
		Hierarchy.put("Luka",s);
		
		s = new ArrayList<String>();
		s.add("Marko");
		s.add("Robert");
		Hierarchy.put("Stjepan",s);
		Map<String, ArrayList<String>> RealHierachy = App.PopuniTablicu("C:\\Users\\buhac\\eclipse-workspace\\maven-demo\\src\\main\\java\\Family.txt");
		
		assertEquals(Hierarchy, RealHierachy);
		

	}
	@Test(expected = IOException.class)
	public void testShouldThrowExceptionWhenFileDoesntExist() throws IOException
	{
		Map<String, ArrayList<String>> RealHierachy = App.PopuniTablicu("DatotekaKojaNePostoji");

	}

}
