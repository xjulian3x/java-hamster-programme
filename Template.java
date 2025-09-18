import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;public class Template extends de.hamster.debugger.model.IHamster implements de.hamster.model.HamsterProgram {public void main() {
    
}

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
}

}