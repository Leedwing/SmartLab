package simulator.main;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import simulator.isteinkaufsliste.service.IstService;
import simulator.isteinkaufsliste.service.Simulator;
import simulator.model.Persona;
import simulator.model.Produkt;
import simulator.solleinkaufsliste.service.SollService;
import simulator.isteinkaufsliste.service.EinkaufslistenGenerator;

public class Main {

	public static void main(String[] args) throws ParseException, SQLException {
		SollService sollService = new SollService();
		IstService istService = new IstService();
		Simulator simulator = new Simulator();
		EinkaufslistenGenerator einkaufslistenGenerator = new EinkaufslistenGenerator();
		Persona persona;
		
		/*einkaufslistenGenerator.reset();
		persona = sollService.deserializierePersona();
		Map<Integer, List<Produkt>> sollEinkaufsListenMap = new HashMap<>();
		for(int i=0; i<150; i++) {
			List<Produkt> liste = sollService.erstelleSollEinkaufsListe(persona, i);
			sollEinkaufsListenMap.put(i, liste);
		}
		sollService.schreibeSollEinkaufslistenInEinerDatei(sollEinkaufsListenMap, "sollEinkaufsListeTest.csv");*/
		

		// sportler = sollService.erstellePersonaMitVerbrauchsdaten("Sportler", 3, 6,
		// 1000);
		// printPersonaData(sportler);
		// sollService.serializierePersona("Sportler", 3, 6, 1000);
		
		persona = sollService.deserializierePersona();
		
		Map<Integer, List<Produkt>> sollEinkaufsListenMap = sollService.erstelleSollEinkaufslistenBeimEinkauf(persona,
				150);
		//sollService.schreibeSollEinkaufslistenInEinerDatei(sollEinkaufsListenMap, "sollEinkaufsListe.csv");

//		for(int i=11; i<12; i++) {
//			einkaufslistenGenerator.reset();
//			Map<Integer, List<String>> istEinkaufsListenMap = einkaufslistenGenerator.erstelleIstEinkaufslisteMapBeimKauf(
//					persona, sollEinkaufsListenMap, 33, true, true, 3, 3, "istEinkaufsliste_1133_" + i + ".csv");
//			einkaufslistenGenerator.printIstEinkaufsListen(istEinkaufsListenMap);
//		}
		
		for(int i=2; i<4; i++) {
			einkaufslistenGenerator.reset();
			for(int j=0; j<4; j++) {
				simulator.simuliereAblauf(persona, sollEinkaufsListenMap, 150, true, true, i, j, "istEinkaufsliste_11"+ i + "" + j +".csv");
			}
			
		}
		
		//simulator.simuliereAblauf(persona, sollEinkaufsListenMap, 150, true, true, 0, 3, "istEinkaufsliste_1103_test.csv");
		

		
		
		// einkaufslistenGenerator.schreibeEinkaufslistenInEinerDatei(null,
		// "sollEinkaufsLite.txt");

		// Map<Integer, List<Produkt>> sollListeMap =
		// sollService.erstelleSollEinkaufslistenBeimEinkauf(sportler, 5);

		// sollService.printSollEinkaufsListen(sollListeMap);

		// List<Produkt> sportlerSollEinkaufsliste =
		// sollService.erstelleSollEinkaufsListe(sportler,
		// sportler.getEinkaufsAblauf().get(4));
		//
		//
		// System.out.println("*****SollEinkaufslite******");
		// for (Produkt produkt : sportlerSollEinkaufsliste) {
		// System.out.println(produkt.getName());
		// }

		// Einkaufsliste generator

		// IstService istService = new IstService();
		//istService.put_Product_On_Einkaufsliste(1, "Butter", 3);
		// System.out.println(istService.get_einkaufsliste(1));

		// System.out.println("##### Berechnete Einkaufsliste vom Generator: " +
		// einkaufslistenGenerator.get_berechneteEinkaufsliste(1, 150));
		// istService.put_Product_On_Einkaufsliste(1, "Joghurt", 5);
		// istService.put_Product_On_Einkaufsliste(1, "Salami", 6);
		// istService.buy_Product_From_Einkaufsliste("Joghurt", 1, 100);
		// istService.buy_Product_From_Einkaufsliste("Salami", 1, 100);
		// System.out.println("##### Einkaufsliste aus der DB: " +
		// istService.get_einkaufsliste(1));

	}

	public static void printPersonaData(Persona persona) {
		System.out.println("");
		System.out.println("-------------------------------Persona Data---------------------------------");
		System.out.println("");
		System.out.println("Einkaufsablauf in Tagenabstand (kumuliert): " + persona.getEinkaufsAblauf());
		System.out.println(
				"Verbrauchsablauf Butter kumuliert:" + persona.getProduktMap().get("Butter").getVerbrauchsablauf());
		System.out.println(
				"Verbrauchsablauf Milch kumuliert:" + persona.getProduktMap().get("Milch").getVerbrauchsablauf());
		System.out.println(
				"Verbrauchsablauf Kaese kumuliert:" + persona.getProduktMap().get("Kaese").getVerbrauchsablauf());
		System.out.println(
				"Verbrauchsablauf Salami kumuliert:" + persona.getProduktMap().get("Salami").getVerbrauchsablauf());
		System.out.println(
				"Verbrauchsablauf Joghurt kumuliert:" + persona.getProduktMap().get("Joghurt").getVerbrauchsablauf());

		System.out.println("");
		System.out.println("-----------------------------------------------------------------------------");
		System.out.println("");
	}
}
