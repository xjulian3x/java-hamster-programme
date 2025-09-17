import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;public class AufgabeF_HalloWelt extends de.hamster.debugger.model.IHamster implements de.hamster.model.HamsterProgram {public void main() {
	schreibeText("HALLO WELT");
	loescheAlles();
}

/**
 * @param zeichen Zeichen zum schreiben
 * schreibt ein Zeichen. Voraussetzung: start unten rechts nach rechts guckend. Endet unten rechts nach rechts guckend
 */
void schreibe(char zeichen) {
	switch(zeichen) {
		default:
			break;
		case 'A':
			linksUm();
			zeichneLinie(3);
			vor();
			linksUm();
			vor();
			zeichnePunkt();
			vor();
			rechtsUm();
			vor();
			zeichnePunkt();
			linksUm();
			vor();
			linksUm();
			vor();
			zeichnePunkt();
			vor();
			rechtsUm();
			vor();
			linksUm();
			zeichneLinie(3);
			kehrt();
			vor();
			rechtsUm();
			vor();
			zeichneLinie(3);
			// reset
			vor();
			rechtsUm();
			vor();
			linksUm();
			break;
		case 'E':
			kehrt();
			vor();
			zeichneLinie(4);
			rechtsUm();
			vor();
			zeichneLinie(4);
			rechtsUm();
			vor();
			zeichneLinie(3);
			kehrt();
			vorMehrfach(3);
			linksUm();
			vorMehrfach(2);
			linksUm();
			vor();
			zeichneLinie(3);
			// reset
			vor();
			rechtsUm();
			vorMehrfach(2);
			linksUm();
			break;
		case 'H':
			kehrt();
			vor();
			rechtsUm();
			zeichneLinie(5);
			kehrt();
			vorMehrfach(2);
			rechtsUm();
			vor();
			zeichneLinie(3);
			linksUm();
			vor();
			zeichneLinie(2);
			kehrt();
			vorMehrfach(3);
			zeichneLinie(2);
			// reset
			rechtsUm();
			vorMehrfach(4);
			rechtsUm();
			vorMehrfach(4);
			linksUm();
			break;
		case 'L':
			kehrt();
			vor();
			zeichneLinie(4);
			rechtsUm();
			vor();
			zeichneLinie(4);
			// reset
			rechtsUm();
			vorMehrfach(4);
			rechtsUm();
			vorMehrfach(4);
			linksUm();
			break;
		case 'O':
			for(int i=0; i<4; i++) {
				linksUm();
				vor();
				zeichneLinie(3);
				vor();
			}
			break;
		case 'T':
			kehrt();
			vorMehrfach(2);
			rechtsUm();
			zeichneLinie(5);
			linksUm();
			vor();
			zeichneLinie(2);
			kehrt();
			vorMehrfach(3);
			zeichneLinie(2);
			// reset
			rechtsUm();
			vorMehrfach(4);
			linksUm();
			break;
		case 'W':
			linksUm();
			vor();
			zeichneLinie(4);
			linksUm();
			vorMehrfach(4);
			linksUm();
			zeichneLinie(4);
			vor();
			linksUm();
			vor();
			zeichnePunkt();
			vor();
			linksUm();
			vor();
			zeichnePunkt();
			kehrt();
			vor();
			linksUm();
			vor();
			zeichnePunkt();
			// reset
			vor();
			break;
	}
}

void schreibeText(String text) {
	if(!existiertNaechstesFeld()) {
		return;
	}
	
	for(int i=0; i<text.length(); i++) {
		char zeichen = text.charAt(i);
		if(zeichen!=' ') {
			schreibe(zeichen);
		}
		zumNaechstenFeld();
	}
}

/**
 * @param length Länge der Linie als Ganzzahl
 * Zeichnet eine Linie mit der Länge length, Rotation des Hamsters bleibt gleich, Hamster bleibt am letzten Punkt der Linie stehen
 * Nach ausführen wurde eine Linie der Gesamtlänge length gezeichnet.
 */
// kehrt statt linksUmMehrfach, rechtsUm soll kehrt usen
void zeichneLinie(int length) {
	int i = 1;
	zeichnePunkt();
	while(i<length) {
		vor();
		zeichnePunkt();
		i++;
	}
}

void zeichnePunkt() {
	for(int i=0; i<12; i++) {
		gib();
	}
}

/**
 * Dreht times-mal links
 * @times Wie oft gedreht werden soll
 */
/* ersetzt durch kehrt, UNUSED
void linksUmMehrfach(int times) {
	int cleanTimes = times;
	while(cleanTimes-4 >= 0) {
		cleanTimes = cleanTimes - 4;
	}
	
	for(int i=0; i<cleanTimes; i++) {
		linksUm();
	}
	
}
*/

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
 * löscht alles, Start und Ende unten rechts mit Blick nach rechts
 */
void loesche() {
	linksUm();
	for(int i=0; i<5; i++) {
		while(vornFrei()) {
			nimmAlle();
			vor();
		}
		if(i%2==0) {
			nimmAlle();
			linksUm();
			if(!vornFrei()) {
				// Hamster ist oben links, guckt nach links, vor einer Mauer
				zurueck();
				return;
			}
			vor();
			linksUm();
		} else {
			nimmAlle();
			rechtsUm();
			if(!vornFrei()) {
				// Hamster ist unten links, guckt nach links, vor einer Mauer
				zurueck();
				return;
			}
			vor();
			rechtsUm();
		}
	}
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
 * Hamster geht von oben links oder unten links nach unten rechts und guckt nach rechts
 * Voraussetzung: Hamster ist oben links oder unten links und guckt nach links
 */
void zurueck() {
	linksUm(); // Hamster guckt jetzt nach unten
	vorBisMauer();
	linksUm(); // Hamster ist garantiert unten links und guckt jetzt nach rechts
	vorBisMauer();
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
 * Gehe von jetzigem Feld unten rechts zum Feld rechts daneben unten rechts
 */
void zumNaechstenFeld(boolean links) {
	if(!existiertNaechstesFeld(false, links)) {
		return;
	}
	/*if(!vornFrei()) { // Prüfe, ob nächstes Feld überhaupt existiert
		// es gibt kein neues Feld, zurück nach unten rechts
		rechtsUm();
		vor();
		linksUm();
		return;
	}*/
	vorMehrfach(2);
	if(links) {
		linksUm();
		vor();
		rechtsUm();
	} else {
		rechtsUm();
		vor();
		linksUm();
	}
	vorBisMauer();
}

void zumNaechstenFeld() {
	zumNaechstenFeld(false);
}

/**
 * @param zurueckZumAnfang ob Hamster zurueck zum Feld unten rechts soll, falls nächstes Feld existiert
 * Prüft, ob nächstes Feld existiert
 * Start unten rechts in einem Feld nach rechts guckend ODER im Feld darüber nach rechts guckend, Ende an selber Position
 */
boolean existiertNaechstesFeld(boolean zurueckZumAnfang, boolean links) {
	if(!vornFrei()) {
		// Hamster ist unten rechts/links, bewege zum "Testpunkt" im Feld darüber
		if(links) {
			rechtsUm();
			vor();
			linksUm();
		} else {
			linksUm();
			vor();
			rechtsUm();
		}
	}
	if(!vornFrei()) { // Prüfe, ob nächstes Feld überhaupt existiert
		// es gibt kein nächstes Feld, zurück nach unten rechts
		if(links) {
			linksUm();
			vor();
			rechtsUm();
		} else {
			rechtsUm();
			vor();
			linksUm();
		}
		return false;
	}
	// es gibt ein nächstes Feld
	if(!zurueckZumAnfang) {
			// nicht zum Anfang gehen, return
			return true;
		}
	// zurück nach unten rechts/links
	if(links) {
		linksUm();
		vor();
		rechtsUm();
	} else {	
		rechtsUm();
		vor();
		linksUm();
	}
	return true;
}

/**
 * Überladene Prozedur existiertNaechstesFeld(), um Rückkehr und rechts-Modus als default zu setzen
 */
boolean existiertNaechstesFeld() {
	return existiertNaechstesFeld(true, false);
}

/**
 * Überladene Prozedur existiertNaechstesFeld(), um Rückkehr und rechts-Modus als default zu setzen
 */
boolean existiertNaechstesFeld(boolean zurueckZumAnfang) {
	return existiertNaechstesFeld(zurueckZumAnfang, false);
}

/**
 * löscht alles, Voraussetzung: Hamster im letzen Feld rechts unten, nach rechts guckend
 */
void loescheAlles() {
	if(existiertNaechstesFeld()) {
		// rechts gibt es ein Feld --> wir sind nicht ganz links
		return;
	}
	
	// gehe nach unten links
	kehrt();
	vorBisMauer();
	while(existiertNaechstesFeld(true, true)) {
		kehrt();
		vorBisMauer();
		loesche();
		kehrt();
		vorBisMauer();
		zumNaechstenFeld(true); // gehe zum Feld links daneben
	}
	kehrt();
	vorBisMauer();
	loesche();
}}