package ar.edu.carmenSandiego.ui

import AplicationModel.VillanoAppModel
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.windows.WindowOwner
import org.uqbar.arena.layout.HorizontalLayout
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.widgets.List
import org.uqbar.arena.bindings.NotNullObservable
import org.uqbar.arena.widgets.Button
import org.uqbar.arena.widgets.TextBox
import org.uqbar.arena.layout.ColumnLayout
import static extension org.uqbar.arena.xtend.ArenaXtendExtensions.*
import org.uqbar.arena.windows.Dialog
import org.uqbar.arena.layout.VerticalLayout

class EditarSenhasParticularesWindow extends Dialog<VillanoAppModel> {
	
	new(WindowOwner owner, VillanoAppModel model) {
		super(owner, model)
		title= "Editar Señas Particulares"
	}
	
	override protected createFormPanel(Panel mainPanel) {
		mainPanel.layout = new VerticalLayout
		new Label(mainPanel).text = "Seña"
		new List<String>(mainPanel) => [
				(items <=> "villanoSelec.señasParticulares")
				height = 150
				width = 130
				value <=> "señaSeleccionadaASacar"
			]
		this.createGridActions(mainPanel)
		val selecPanel = new Panel(mainPanel).layout = new ColumnLayout(2)
        new TextBox(selecPanel).value <=> "señaAAgregar"
        val elementSelected = new NotNullObservable("señaAAgregar")
	    new Button(selecPanel) => [
			caption = "Agregar"
			onClick([|this.modelObject.agregarSeñaSelec()])
			bindEnabled(elementSelected)
		]	
	}
	
	def void createGridActions(Panel mainPanel) {
		val elementSelected = new NotNullObservable("señaSeleccionadaASacar")
		val actionsPanel = new Panel(mainPanel).layout = new HorizontalLayout
		
		new Button(actionsPanel) => [
			caption = "Eliminar"
			onClick([|modelObject.eliminarSeñaSeleccionado()])
			bindEnabled(elementSelected)
		]
	}
	
	override protected void addActions(Panel actions) {
		new Button(actions) => [
			caption = "Aceptar"
			onClick [|this.accept]
			setAsDefault
			disableOnError	
		]
	}
	
}