package id.co.rano;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import id.co.rano.service.ConsoleService;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SoalB_4 implements CommandLineRunner {
	
	@Autowired
	private ConsoleService consoleService;
	
	private Scanner scanStr;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(SoalB_4.class, args).close();
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		String inputData = "", maxStr = "", minStr = "", newString = "";
		scanStr = new Scanner(System.in);
		System.out.println();
		System.out.print(consoleService.getUiInputTeks());
		while((inputData = scanStr.nextLine()) != null) {
			newString = newString.concat(inputData.replace("-", " ").replaceAll("[^a-zA-Z0-9 ]", "").replaceAll(" +", " ").trim().concat(" "));
			if (inputData.endsWith("!")) {
				break;
			}
		}
		Map<String, Long> map = countWords(Stream.of(newString.toLowerCase().split(" ")));
		System.out.println(consoleService.getUiCountTeks().concat(String.valueOf(newString.split(" ").length)));
		System.out.println(consoleService.getUiCountDisplayString().concat(map.toString().replaceAll("[{}]", "")));
		System.out.println(consoleService.getUiOnceStringDisplay().concat(String.valueOf(map.values().stream().filter(v -> v == 1).count())));
		Long maxValue = map.entrySet().stream().max((entry1, entry2) -> entry1.getValue() > entry2.getValue() ? 1 : -1).get().getValue();
		Long minValue = map.entrySet().stream().min((entry1, entry2) -> entry1.getValue() > entry2.getValue() ? 1 : -1).get().getValue();
		int loop = 0;
		for (Entry<String, Long> entry: map.entrySet()) {
			if (entry.getValue() == maxValue) {
				if (loop == 0) {
					maxStr = maxStr.concat(entry.getKey());
				} else {
					maxStr = maxStr.concat(", ").concat(entry.getKey());
				}
				loop++;
			}
		}
		loop = 0;
		for (Entry<String, Long> entry: map.entrySet()) {
			if (entry.getValue() == minValue) {
				if (loop == 0) {
					minStr = minStr.concat(entry.getKey());
				} else {
					minStr = minStr.concat(", ").concat(entry.getKey());
				}
				loop++;
			}
		}
		
		System.out.println(consoleService.getUiCountStringLot()
				.concat(String.valueOf(map.values().stream().filter(v -> v == maxValue).count()))
				.concat(" ")
				.concat(consoleService.getUiCountStringAnd())
				.concat(maxStr));
		
		System.out.println(consoleService.getUiCountStringLess()
				.concat(String.valueOf(map.values().stream().filter(v -> v == minValue).count()))
				.concat(" ")
				.concat(consoleService.getUiCountStringAnd())
				.concat(minStr));
	}
	
	public static Map<String, Long> countWords(Stream<String> names) {
        return names.collect(groupingBy(name -> name, counting()));
    }

}
