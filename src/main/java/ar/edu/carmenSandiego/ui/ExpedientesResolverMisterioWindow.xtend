package ar.edu.carmenSandiego.ui


import org.uqbar.arena.windows.WindowOwner
import org.uqbar.arena.widgets.Panel


class ExpedientesResolverMisterioWindow extends ExpedientesWindow {
	
	new(WindowOwner owner) {
		super(owner)
	}
	override defaultTitle() {
		"Resolviendo Misterio - Expedientes"
	}
	
	override crearBotoneraNuevoYEditar(Panel owner){
	}
	override protected addActions(Panel actionsPanel) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	override protected createFormPanel(Panel mainPanel) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
}