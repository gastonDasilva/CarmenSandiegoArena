package ar.edu.carmenSandiego.ui

import ar.gaston.carmenSanDiego.Villano
import AplicationModel.VillanoAppModel
import org.uqbar.arena.windows.WindowOwner

class CrearVillanoWindow  extends EditarVillanoWindow {
	
	new(WindowOwner owner) {
		super(owner, new VillanoAppModel(new Villano))
	}
	
	override defaultTitle() {
		"Expediente -Nuevo Villano"
	}
	
}