package ar.edu.carmenSandiego.ui

import org.uqbar.arena.windows.SimpleWindow
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.windows.WindowOwner
import org.uqbar.arena.widgets.Button
import org.uqbar.arena.windows.Window

class MenuDeAcciones extends SimpleWindow<MenuDeAcciones>{
	
	
	new(WindowOwner parent, MenuDeAcciones model) {
		super(parent, model)
	}
	
	override def createMainTemplate(Panel mainPanel) {
		title = "¿Dónde Está CarmenSandiego?"
		taskDescription = "¿Qué haremos ahora detective?"

		super.createMainTemplate(mainPanel)
	}
	
	override protected addActions(Panel actionsPanel) {
		new Button(actionsPanel) => [
			caption = "Resolver Misterio"
			onClick([|this.resolverMisterio])
		]
		new Button(actionsPanel) => [
			caption = "Mapamundi"
			onClick([|this.mostrarMapamundi])
		]
		new Button(actionsPanel) => [
			caption = "Expedientes"
			onClick([|this.mostrarExpedientes])
		]
	}
	
	// ********************************************************
	// ** Acciones
	// ********************************************************
	def void mostrarExpedientes() {
	 this.openDialog(new ExpedientesWindow(this))
	}
		
	def void mostrarMapamundi() {
		this.openDialog(new MapamundiWindow(this))
	}
	
	def openDialog(Window window) {
		window.open
	}
	
	def void resolverMisterio() {
		this.openDialog(new ResolverMisterioWindow(this))
	}
	
	
	override protected createFormPanel(Panel mainPanel) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
}