import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;public class Aufgabe5Teil2_2 extends de.hamster.debugger.model.IHamster implements de.hamster.model.HamsterProgram {public void main() {
    if(vornFrei()) {
    	vor();
    	if(!vornFrei()) {
    		kehrt();
    		vor();
    		kehrt();
    		return;
    	}
    	if(vornFrei()) {
    		vor();
    		if(!vornFrei()) {
    			kehrt();
    			vor();
    			vor();
    			kehrt();
    			return;
    		}
    	}
    }
}




// TEMPLATE ohne loop methoden
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