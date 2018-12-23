package id.co.rano;

import id.co.rano.service.ConsoleService;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SoalB_3 implements CommandLineRunner {
	
	@Autowired
	private ConsoleService consoleService;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(SoalB_3.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		String inputData;
		Scanner scanStr = new Scanner(System.in);
		System.out.println();
		System.out.print(consoleService.getUiInputData());
		inputData = scanStr.nextLine();
		StringBuilder compile = new StringBuilder(inputData.replaceAll(" ", ""));
		StringBuilder result = new StringBuilder();
		
		for (char c : compile.toString().toCharArray()) {
			int counter = (int) compile.chars().filter(num -> num == c).count();
			int index = result.indexOf(String.valueOf(c));
			if (index == -1) {
				result.append(c);
				if (counter > 1) {
					result.append(counter);
				}
			}
		}
		
		System.out.println(consoleService.getUiOutputData().concat(result.toString()));
		scanStr.close();
	}

}
