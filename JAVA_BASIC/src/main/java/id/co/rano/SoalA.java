package id.co.rano;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import id.co.rano.service.ConsoleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SoalA implements CommandLineRunner {
	
	@Autowired
	private ConsoleService consoleService;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(SoalA.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		int countMhs, countLulus = 0, countTdkLulus = 0;
		double hadir, midTest, uas, finalValue;
		String nim, nama, display = "";
		Scanner scanInt = new Scanner(System.in);
		Scanner scanStr = new Scanner(System.in);
		Scanner scanDouble = new Scanner(System.in);
		System.out.println();
		System.out.print(consoleService.getUiFirstShow());
		countMhs = scanInt.nextInt();
		for (int i = 1; i <= countMhs; i++) {
			System.out.println();
			display = display.concat("\n");
			System.out.print(consoleService.getUiNim());
			nim = scanStr.nextLine();
			System.out.print(consoleService.getUiNama());
			nama = scanStr.nextLine();
			System.out.print(consoleService.getUiKehadiran());
			hadir = scanDouble.nextDouble();
			System.out.print(consoleService.getUiUts());
			midTest = scanDouble.nextDouble();
			System.out.print(consoleService.getUiUas());
			uas = scanDouble.nextDouble();
			finalValue = (0.2 * hadir) + (0.4 * midTest) + (0.4 * uas);
			if (finalValue >= 85 & finalValue <= 100) {
				display = display.concat(String.valueOf(i)).concat(".\t").concat(nim).concat("\t")
						.concat(nama).concat("\t").concat(String.valueOf(finalValue)).concat("\t\t")
						.concat("A");
				countLulus += 1;
			}
			if (finalValue >= 76 & finalValue <= 84) {
				display = display.concat(String.valueOf(i)).concat(".\t").concat(nim).concat("\t")
						.concat(nama).concat("\t").concat(String.valueOf(finalValue)).concat("\t\t")
						.concat("B");
				countLulus += 1;
			}
			if (finalValue >= 61 & finalValue <= 75) {
				display = display.concat(String.valueOf(i)).concat(".\t").concat(nim).concat("\t")
						.concat(nama).concat("\t").concat(String.valueOf(finalValue)).concat("\t\t")
						.concat("C");
				countLulus += 1;
			}
			if (finalValue >= 46 & finalValue <= 60) {
				display = display.concat(String.valueOf(i)).concat(".\t").concat(nim).concat("\t")
						.concat(nama).concat("\t").concat(String.valueOf(finalValue)).concat("\t\t")
						.concat("D");
				countTdkLulus += 1;
			}
			if (finalValue >= 0 & finalValue <= 45) {
				display = display.concat(String.valueOf(i)).concat(".\t").concat(nim).concat("\t")
						.concat(nama).concat("\t").concat(String.valueOf(finalValue)).concat("\t\t")
						.concat("E");
				countTdkLulus += 1;
			}
		}
		System.out.println();
		System.out.println("No.\tNIM\t\tNama\tNilai Akhir\tGrade");
		System.out.print("==============================================================");
		System.out.println(display);
		System.out.println("==============================================================");
		System.out.println();
		System.out.println(consoleService.getUiCountMhs().concat(String.valueOf(countMhs))
				.concat(" ").concat(consoleService.getUiCalculate()));
		System.out.println(consoleService.getUiLulus().concat(String.valueOf(countLulus))
				.concat(" ").concat(consoleService.getUiCalculate()));
		System.out.println(consoleService.getUiTdkLulus().concat(String.valueOf(countTdkLulus))
				.concat(" ").concat(consoleService.getUiCalculate()));
		System.out.println();
		System.out.println("==============================================================");
		scanInt.close();
		scanStr.close();
		scanDouble.close();
		
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(consoleService.getPatFileExport()));
			writer.write("No.\tNIM\t\t\tNama\tNilai Akhir\tGrade\n");
			writer.write("==============================================================");
			writer.write(display.concat("\n"));
			writer.write("==============================================================\n\n");
			writer.write(consoleService.getUiCountMhs().concat(String.valueOf(countMhs))
					.concat(" ").concat(consoleService.getUiCalculate()).concat("\n"));
			writer.write(consoleService.getUiLulus().concat(String.valueOf(countLulus))
					.concat(" ").concat(consoleService.getUiCalculate()).concat("\n"));
			writer.write(consoleService.getUiTdkLulus().concat(String.valueOf(countTdkLulus))
					.concat(" ").concat(consoleService.getUiCalculate()).concat("\n\n"));
			writer.write("==============================================================");
			writer.close();
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
