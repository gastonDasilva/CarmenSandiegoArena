package ar.edu.carmenSandiego.ui

import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.windows.SimpleWindow
import org.uqbar.arena.windows.WindowOwner
import org.uqbar.arena.layout.HorizontalLayout
import org.uqbar.arena.widgets.tables.Table
import org.uqbar.arena.widgets.Button
import org.uqbar.arena.bindings.NotNullObservable
import ar.gaston.carmenSanDiego.Pais
import AplicationModel.Mapamundi
import org.uqbar.arena.windows.Dialog

class MapamundiWindow extends  SimpleWindow<Mapamundi> {
	
	new(WindowOwner owner) {
		super(owner, new Mapamundi)
	}
	
	override def createMainTemplate(Panel mainPanel) {
		title = "Mapamundi"
		super.createMainTemplate(mainPanel)

		this.createGrillaPais(mainPanel)
		this.createGridActions(mainPanel)
	}
		
	override protected createFormPanel(Panel mainPanel) {
		val form = new Panel(mainPanel).layout = new HorizontalLayout
		new Label(form).text = "Paises"
		new Table<Pais>(form, typeof(Pais)) => [
						items <=> "paises"
						value <=> "paisSeleccionado"
						]
	}
	
	def createGrillaPais(Panel mainPanel) {
		
		new Label(mainPanel) => [
			value <=> "Pais.nombre"
		]
		new Table(mainPanel, typeof(Pais)) => [
			width = 600
			height = 400
			items <=> "Pais.caracteristicas"
		]
		
	    new Table(mainPanel, typeof(Pais)) => [
			width = 600
			height = 400
			items <=> "Pais.conexiones"
		]
		
		new Table(mainPanel, typeof(Pais)) => [
			width = 600
			height = 400
			items <=> "Pais.lugaresDeInteres"
		]
	}
	
		def void createGridActions(Panel mainPanel) {
		val elementSelected = new NotNullObservable("paiSeleccionado")
		val actionsPanel = new Panel(mainPanel).layout = new HorizontalLayout
		
		new Button(actionsPanel) => [
			caption = "Eliminar"
			onClick([|modelObject.eliminarPaisSeleccionado])
			bindEnabled(elementSelected)
		]
		
		new Button(actionsPanel) => [
			caption = "Editar"
			onClick([|this.editarPais])
			bindEnabled(elementSelected)
		]
		
		new Button(actionsPanel) => [
			caption = "nuevoPais"
			onClick([|this.nuevoPais])
			bindEnabled(elementSelected)
		]
		
	}
	
	def nuevoPais() {
		this.openDialog(new CrearPaisWindow(this)
	}
	
	def openDialog(Dialog<?> dialog) {
		dialog.open
	}
	
	def editarPais() {
		this.openDialog(new EditarPaisWindow(this, modelObject.paisSeleccionado))
	}
	
	override protected addActions(Panel actionsPanel) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	
	}
	
}