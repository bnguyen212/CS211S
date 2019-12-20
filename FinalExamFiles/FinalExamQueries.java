import java.io.*;
import java.util.*;
import java.util.function.*;
import java.util.stream.*;
import java.time.*;

public class FinalExamQueries {

	public static List<BirthRecord> recordList = null;

	public static void main(String[] args) {
		recordList = createList();

		System.out.println("\n***Question A");
		recordList.stream().limit(10).forEach(System.out::println);
		qASortByNameApgar();
		System.out.println("\n");
		recordList.stream().limit(10).forEach(System.out::println);

		System.out.println("\n***Question B");
		qBPrintUniqueNames();

		System.out.println("\n***Question C");
		double averageWeightFemales = qCAverageWeightFemales();
		System.out.println(averageWeightFemales);

		System.out.println("\n***Question D");
		List<String> maleNameList = qDCreateListLongMaleNames();
		System.out.println(maleNameList);

		System.out.println("\n***Question E");
		long numberOfMultipleBirths = qENumberOfMultipleBirths();
		System.out.println(numberOfMultipleBirths);

		System.out.println("\n***Question F");
		Map<Integer, List<BirthRecord>> recordMapByDate = qFCreateMapRecordsByApgar();
		System.out.println(recordMapByDate);

		System.out.println("\n***Question G");
		BirthRecord shortestBaby = qGGetShortestBaby();
		System.out.println(shortestBaby);

		System.out.println("\n***Question H");
		boolean existsFemaleMultBirthOlivia = qHExistsAnyFemaleHalloweenBaby();
		System.out.println(existsFemaleMultBirthOlivia);

	}

	public static void qASortByNameApgar() {
		// Write a single statement to sort this list using a comparator.
		// Sort name and then birthDate <---- need to update
		// Use a lambda.
		Comparator<BirthRecord> compareByNameThenApgarScore = Comparator
														.comparing(BirthRecord::getName)
														.thenComparing(BirthRecord::getApgarScore);
		recordList = recordList.stream().sorted(compareByNameThenApgarScore).collect(Collectors.toList());
	}
	public static void qBPrintUniqueNames() {
		// print the unique name of every baby (in other words, do not print duplicate names)
		recordList.stream().map(BirthRecord::getName).distinct().forEach(System.out::println);
	}
	public static double qCAverageWeightFemales() {
		// the average weight of all female babies
		return recordList.stream().filter(birthRecord -> birthRecord.getGender() == BirthRecord.Gender.FEMALE).mapToDouble(BirthRecord::getWeight).average().getAsDouble();
	}
	public static List<String> qDCreateListLongMaleNames() {
		// a list of all the names of all male babies with names longer than 8 characters (note that this is a list of names, not birth records)
		return recordList.stream().filter(birthRecord -> birthRecord.getGender() == BirthRecord.Gender.MALE && birthRecord.getName().length() > 8).map(BirthRecord::getName).collect(Collectors.toList());
	}
	public static long qENumberOfMultipleBirths() {
		// the number of birth records that were multiple births (as defined by the instance data variable "multiple")
		return recordList.stream().filter(BirthRecord::isMultiple).count();
	}
	public static Map<Integer, List<BirthRecord>> qFCreateMapRecordsByApgar() {
		// a map of the birth records for each apgar score that includes all birth records with scores < 7 (key = apgar score, value = list of records)
		return recordList.stream().filter(br -> br.getApgarScore() < 7).collect(Collectors.groupingBy(BirthRecord::getApgarScore));
	}

	public static BirthRecord qGGetShortestBaby() {
		// the birth record of the shortest baby
		return recordList.stream().min((br1, br2) -> Double.compare(br1.getHeight(), br2.getHeight())).get();
	}
	public static boolean qHExistsAnyFemaleHalloweenBaby() {
		// whether there were any female babies that were part of a multiple birth and were named "Olivia"
		return recordList.stream().anyMatch(br -> br.isMultiple() && br.getName().equals("Olivia"));
	}


    private static List<BirthRecord> createList() {
        String line = "";
        String fileName = "BirthRecordData.csv";
        List<BirthRecord> list = new ArrayList<BirthRecord>();

        try (Scanner fileScan = new Scanner(
                new FileReader(new File(fileName)))) {
            line = fileScan.nextLine(); // column headers

            while(fileScan.hasNext() ) {
                line = fileScan.nextLine();
                Scanner lineScan = new Scanner(line);
                lineScan.useDelimiter(",");

                String name = lineScan.next();
                String genderString = lineScan.next();
                String weightString  = lineScan.next();
                String heightString = lineScan.next();
                String apgarString = lineScan.next();
                String year = lineScan.next();
                String month = lineScan.next();
                String day = lineScan.next();
                String multipleString = lineScan.next();

                BirthRecord.Gender gender = genderString.equalsIgnoreCase("female") ? BirthRecord.Gender.FEMALE : BirthRecord.Gender.MALE;
                double weight = Double.parseDouble(weightString);
                double height = Double.parseDouble(heightString);
                int apgar = Integer.parseInt(apgarString);
                LocalDate birthDate = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
                boolean multiple = Boolean.parseBoolean(multipleString);

                BirthRecord record = new BirthRecord(name, birthDate, weight, height, apgar, multiple, gender);

                list.add(record);
            }
        } catch (IOException ex){
            System.out.println(line);
            ex.printStackTrace();
        }
        return list;
    }

}
