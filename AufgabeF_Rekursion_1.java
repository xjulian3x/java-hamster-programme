import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;public class AufgabeF_Rekursion_1 extends de.hamster.debugger.model.IHamster implements de.hamster.model.HamsterProgram {public void main() {
	folgeSpur(0);
}


void folgeSpur(int versuchteLinksdrehungen) {
	if(versuchteLinksdrehungen>=3) {
		return; // Abbruchbedingung
	}
	if(vornFrei()) {
		vor();
	}
	if(!kornDa()) {
		kehrt();
		vor();
		kehrt();
		for(int i=0;i<versuchteLinksdrehungen+1;i++) {
			linksUm();
		}
		folgeSpur(versuchteLinksdrehungen+1);
	} else if(!vornFrei()) {
		for(int i=0;i<versuchteLinksdrehungen+1;i++) {
			linksUm();
		}
		folgeSpur(versuchteLinksdrehungen+1);
	} else {
		folgeSpur(0);
	}
}

/**
 * Dreht rechts (im Uhrzeigersinn), bzw. 3x links
 */
void rechtsUm() {
	kehrt();
	linksUm();
}

/**
 * Geht mehrfach vor
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
}}