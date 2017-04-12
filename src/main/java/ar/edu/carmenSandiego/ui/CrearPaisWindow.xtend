package ar.edu.carmenSandiego.ui

import org.uqbar.arena.windows.WindowOwner
import ar.gaston.carmenSanDiego.Pais

class CrearPaisWindow extends EditarPaisWindow {
	
	new(WindowOwner owner) {
		super(owner, new Pais)
	}
	
	override defaultTitle() {
		"Mapamundi -Nuevo Pais"
	}
	
}