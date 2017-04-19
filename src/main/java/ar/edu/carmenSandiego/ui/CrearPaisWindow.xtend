package ar.edu.carmenSandiego.ui

import org.uqbar.arena.windows.WindowOwner
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.widgets.Button
import AplicationModel.Mapamundi

class CrearPaisWindow extends EditarPaisWindow {
	
	new(WindowOwner owner, Mapamundi model) {
		super(owner, model)
	}
	
	override defaultTitle() {
		"Mapamundi -Nuevo Pais"
	}
	
	override botonAceptar(Panel mainPanel){
			new Button(mainPanel) => [
			caption = "Aceptar"
			onClick [|
				this.modelObject.agregarPais
				this.close
			]
		]
	}
	
}