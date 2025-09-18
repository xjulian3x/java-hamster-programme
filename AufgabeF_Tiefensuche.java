import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;public class AufgabeF_Tiefensuche extends de.hamster.debugger.model.IHamster implements de.hamster.model.HamsterProgram {public void main() {
    tiefenSuche();
}

void tiefenSuche() {
	// Gebe überall in Reihe 4 Körner
	while(vornFrei()) {
		if(!kornDa()) {
			gibKoernerMehrfach(4);
		}
		vor();
		if(!kornDa()) {
			gibKoernerMehrfach(4);
		}
	}
	kehrt();
	// für jedes "junction durchlaufen" 1 korn wegnehmen
	// --> 
	while(vornFrei()) {
		int drehCount = 0;
		int koernerAufFeld = zaehleKoerner();
		while((koernerAufFeld > 1) || !(vornFrei() && (drehCount != 2 || drehCount != 4))) {
			nimm();
			linksUm();
			drehCount++;
			koernerAufFeld = zaehleKoerner();
		}
		vor();
	}
}


// ***TEMPLATE***

/**
 * Dreht rechts (im Uhrzeigersinn), bzw. 3x links
 */
void rechtsUm() {
	kehrt();
	linksUm();
}

/**
 * Geht mehrfach vor1
 * @param times Wie oft vor gegangen werden soll
 */
void vorMehrfach(int times) {
	for(int i=0; i<times; i++) {
		vor();
	}
}

/**
 * dreht sich um 180 Grad / dreht sich 2x links
 */
void kehrt() {
	linksUm();
	linksUm();
}


/**
 * nimmt alle Körner auf jetzigem Feld
 */
void nimmAlle() {
	while(kornDa()) {
		nimm();
	}
}

/**
 * Gehe vor, bis Mauer erreicht
 */
void vorBisMauer() {
	while(vornFrei()) {
		vor();
	}
}

/**
 * Zählt wie viele Körner auf einem Feld sind
 * @returns Anzahl Körner auf Feld
 */
int zaehleKoerner() {
	int koerner = 0;
	while(kornDa()) {
		nimm();
		koerner++;
	}
	
	// genommene Körner fürs Zählen wieder zurückgeben
	gibKoernerMehrfach(koerner);
	
	return koerner;
}

void gibKoernerMehrfach(int koerner) {
	for(int i=0;i<koerner;i++) {
		if(maulLeer()) {
			// Hamster hat nicht genug Körner
			return;
		}
		gib();
	}
}}