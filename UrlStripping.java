package com.interview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UrlStripping {

	public static void main(String[] args) 
	{
		List<String> list=new ArrayList<String>();
		list.add("http://fancysite.com");
		list.add("http://fancysite.com/abc/abc.html");
		list.add("http://fancysite.com/xyz.html");
		list.add("http://fancysite.com/xyz/abc/pqr.html");
		int givenLevel=2;
		int result=countLevel(list,givenLevel);
		System.out.println("the number of urls at a given level is:"+result);
		
	}

	private static int countLevel(List<String> list, int givenLevel) 
	{
		int finalCountOfUrl=0;
		String[] tempArray;
		Map<String,Integer> map=new HashMap<>();
		for(String s:list)
		{
			tempArray=s.split("http://fancysite.com");
			int counter=0;
			for(int i=0;i<tempArray.length;i++)
			{
				String temp=tempArray[i];
				for(int j=0;j<temp.length();j++)
				{
					if(temp.charAt(j)=='/')
					{
						map.put(s, ++counter);
					}
				}
				
			}
			
		}
		for(int countOfUrl:map.values())
		{
			if(countOfUrl==givenLevel)
			{
				finalCountOfUrl++;
			}
		}
		
		return finalCountOfUrl;
	}

}
