package simulator.isteinkaufsliste.service;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import simulator.model.Persona;
import simulator.model.Produkt;
import simulator.solleinkaufsliste.service.SollService;

public class Simulator {
	
	EinkaufslistenGenerator einkaufslistenGenerator = new EinkaufslistenGenerator();
	SollService sollService = new SollService();
	IstService istService = new IstService();
	
	public Map<Integer, List<String>> simuliereAblauf(Persona persona,
			Map<Integer, List<Produkt>> sollEinkaufsListenMap, int zeitRaum, boolean appTouchPoint,
			boolean homeTouchPoint, int Qapp, int Qhome, String matrixCombinationDateiName) throws ParseException {
		Map<Integer, List<String>> istEinkaufsListeMap = new HashMap<>();
		List<Integer> sollEinkaufsListenMapKeys = sollService.sortiereSollMapKey(sollEinkaufsListenMap);
		
		for(int i=1; i<=zeitRaum; i++) {
			// Sollliste für Tag i erstellen
			List<Produkt> sollListeTagI= sollService.erstelleSollEinkaufsListe(persona, i);
			
			//generierte Einkaufsliste (von der App). Die liste wird gleich in die DB geschrieben
			
			einkaufslistenGenerator.get_berechneteEinkaufsliste(1, i);
			
			
			//setze ggf. verbrauchte Produkte auf die istEinkaufsliste
			List<String> istEinkaufsliste = istService.get_einkaufsliste(1);
			
			double pApp = 0.0;
			switch (Qapp) {
			case 1:
				pApp=0.33;
				break;
				
			case 2:
				pApp=0.66;
				break;
				
			case 3:
				pApp=0.99;
				break;
				
			default:
				appTouchPoint=false;
				break;
			}
			
			double pHome = 0.0;
			switch (Qhome) {
			case 1:
				pHome=0.33;
				break;
				
			case 2:
				pHome=0.66;
				break;
				
			case 3:
				pHome=0.99;
				break;
				
			default:
				homeTouchPoint=false;
				break;
			}
			
			for(Produkt produkt : sollListeTagI) {
				if(einkaufslistenGenerator.itemAlreadyExist(istEinkaufsliste, produkt.getName())==false) {
					if (appTouchPoint && Math.random() <= pApp) {
						istService.put_Product_On_Einkaufsliste(1, produkt.getName(), i);
						istEinkaufsliste = istService.get_einkaufsliste(1);
					}
				}if(einkaufslistenGenerator.itemAlreadyExist(istEinkaufsliste, produkt.getName())==false) {
				
					if (homeTouchPoint && Math.random() <= pHome) {
						istService.put_Product_On_Einkaufsliste(1, produkt.getName(), i);
						istEinkaufsliste = istService.get_einkaufsliste(1);
					}
				}
			}
			
			istEinkaufsliste = istService.get_einkaufsliste(1);
			//Überprüfen, ob Tag i ist Einkaufstag
			if(sollEinkaufsListenMapKeys.contains(i)) {
				System.out.println("Simulation läuft... Einkaufstag: " + i);
				istEinkaufsListeMap.put(i, istEinkaufsliste);
				for(String produktName : istEinkaufsliste) {
					
					istService.buy_Product_From_Einkaufsliste(produktName, 1, i);
					istEinkaufsliste = istService.get_einkaufsliste(1);
				}
			}
			
		}
		
		einkaufslistenGenerator.schreibeGenerierteEinkaufslistenInEinerDatei(istEinkaufsListeMap, matrixCombinationDateiName);
		return null;
	}
}
