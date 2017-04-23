package ar.edu.carmenSandiego.ui

import org.uqbar.arena.windows.WindowOwner
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.widgets.Button
import AplicationModel.CrearEditarVillanoAppModel

class CrearVillanoWindow  extends EditarVillanoWindow {
	
	new(WindowOwner owner, CrearEditarVillanoAppModel model) {
		super(owner, model )//new VillanoAppModel(new Villano))
	}
	
	override defaultTitle() {
		"Expediente -Nuevo Villano"
	}
	
		override botonAceptar(Panel panel){
			new Button(panel) => [
				caption = "Aceptar"
				onClick [|
				this.modelObject.agregarVillano
				this.close
			]
		]
	}
	
}