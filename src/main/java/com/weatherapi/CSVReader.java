package com.weatherapi;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {

	public CSVReader(){ }
	
    public List<String> getList(String location) {
    	
    	List<String> list = new ArrayList<String>();
        BufferedReader br = null;
        String city = "";

        try {
            br = new BufferedReader(new FileReader(location));
            while ((city = br.readLine()) != null) {
            	list.add(city);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
		return list;
    }
}
