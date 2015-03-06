package com.gm.lists.singly;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TestInput {
	public static void main(String[] args) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		try {
			System.out.println(Integer.parseInt(reader.readLine()));
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
