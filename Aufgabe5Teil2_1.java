// loops nicht erlaubt
import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;public class Aufgabe5Teil2_1 extends de.hamster.debugger.model.IHamster implements de.hamster.model.HamsterProgram {public void main() {
    aufgabe1d();
}

void aufgabe1a() {
	// bei jeder Position dreht sich der Hamster nach links
	if (maulLeer())
		;
	else
		gib();
		linksUm();
}

void aufgabe1b() {
	// wie aufgabe 1a
	if (!maulLeer()) {
		gib();
	}
	linksUm();
}

void aufgabe1c() {
	// 1: nichts
	// 2: ein korn wird genommen und vor gegangen
	// 3: nichts
	// 4: nichts
	if (kornDa() && vornFrei()) {
		nimm();
		vor();
	}
}

void aufgabe1d() {
	// keinen bock mehr weiter zur nächsten aufgabe
	if (vornFrei()) {
		vor();
	} else if (kornDa()) {
		nimm();
	} else if (!maulLeer()) {
		gib();
	} else {
		linksUm();
	}
}}