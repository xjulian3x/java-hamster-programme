import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;public class Aufgabe2_4 extends de.hamster.debugger.model.IHamster implements de.hamster.model.HamsterProgram {public void main() {
    // Haus des Nikolaus
    // r,ol,u,or,l,or,ul,u
    
    // nach rechts
	gib();
	vor();
	gib();
	vor();
	gib();
	vor();
	gib();
	vor();
	gib();
	// nach oben links
	linksUm();
	vor();
	linksUm();
	vor();
	gib();
	vor();
	linksUm();
	linksUm();
	linksUm();
	vor();
	gib();
	vor();
	linksUm();
	vor();
	gib();
	vor();
	linksUm();
	linksUm();
	linksUm();
	vor();
	gib();
	// nach unten
	linksUm();
	linksUm();
	vor();
	gib();
	vor();
	gib();
	vor();
	gib();
	// nach oben rechts
	linksUm();
	vor();
	gib();
	vor();
	linksUm();
	vor();
	vor();
	linksUm();
	linksUm();
	linksUm();
	vor();
	gib();
	vor();
	linksUm();
	vor();
	gib();
	//nach links
	linksUm();
	vor();
	gib();
	vor();
	gib();
	vor();
	gib();
	vor();
	// Dach (oben links,unten rechts)
	linksUm();
	linksUm();
	vor();
	linksUm();
	vor();
	gib();
	linksUm();
	linksUm();
	linksUm();
	vor();
	linksUm();
	vor();
	gib();
	linksUm();
	linksUm();
	vor();
	linksUm();
	vor();
	gib();
	// nach unten
	vor();
	linksUm();
	linksUm();
	linksUm();
	vor();
	vor();
	gib();
	vor();
	gib();
	vor();
	gib();
}
}