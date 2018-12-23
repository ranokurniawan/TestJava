package id.co.rano;

import id.co.rano.service.ConsoleService;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SoalB_1 implements CommandLineRunner {
	
	@Autowired
	private ConsoleService consoleService;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(SoalB_1.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		String inputData;
		Scanner scanStr = new Scanner(System.in);
		System.out.println();
		System.out.print(consoleService.getUiInputData());
		inputData = scanStr.nextLine();
		StringBuilder result = new StringBuilder();
		for (char c : inputData.toString().toCharArray()) {
			if (Character.isLowerCase(c)) {
				result.append(Character.toUpperCase(c));
			} else {
				result.append(Character.toLowerCase(c));
			}
		}
		System.out.println(consoleService.getUiOutputData().concat(result.toString()));
		scanStr.close();
	}

}
