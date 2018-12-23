package id.co.rano;

import id.co.rano.service.ConsoleService;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SoalB_2 implements CommandLineRunner {
	
	@Autowired
	private ConsoleService consoleService;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(SoalB_2.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		String inputData;
		Scanner scanStr = new Scanner(System.in);
		System.out.println();
		System.out.print(consoleService.getUiInputData());
		inputData = scanStr.nextLine();
		String result = inputData.replaceAll("[aiueoAIUEO]", "");
		
		System.out.println(consoleService.getUiOutputData().concat(result.toString()));
		scanStr.close();
	}

}
