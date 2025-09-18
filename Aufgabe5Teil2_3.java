import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;public class Aufgabe5Teil2_3 extends de.hamster.debugger.model.IHamster implements de.hamster.model.HamsterProgram {public void main() {
    vor();
    safeNimm();
    vor();
    safeNimm();
    vor();
    safeNimm();
    vor();
    safeNimm();
    vor();
    safeNimm();
    linksUm();
    vor();
    safeNimm();
    linksUm();
    
    vor();
    safeNimm();
    vor();
    safeNimm();
    vor();
    safeNimm();
    vor();
    safeNimm();
    vor();
    safeNimm();
    rechtsUm();
    vor();
    safeNimm();
    rechtsUm();
    
    vor();
    safeNimm();
    vor();
    safeNimm();
    vor();
    safeNimm();
    vor();
    safeNimm();
    vor();
    safeNimm();
    linksUm();
    vor();
    safeNimm();
    linksUm();
    
    vor();
    safeNimm();
    vor();
    safeNimm();
    vor();
    safeNimm();
    vor();
    safeNimm();
    vor();
    safeNimm();
}

void safeNimm() {
	if(kornDa()) {
		nimm();
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
 * dreht sich um 180 Grad / dreht sich 2x links
 */
void kehrt() {
	linksUm();
	linksUm();
}
}