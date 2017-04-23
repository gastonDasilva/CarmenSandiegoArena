package ar.edu.carmenSandiego.ui

import org.uqbar.arena.windows.WindowOwner
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.layout.VerticalLayout
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.widgets.List
import org.uqbar.arena.bindings.NotNullObservable
import org.uqbar.arena.layout.HorizontalLayout
import org.uqbar.arena.widgets.Button
import org.uqbar.arena.layout.ColumnLayout
import org.uqbar.arena.widgets.TextBox
import static extension org.uqbar.arena.xtend.ArenaXtendExtensions.*
import org.uqbar.arena.windows.Dialog

class EditarCaracteristicasWindow extends Dialog<CrearEditarPaisAppModel> {
	
	new(WindowOwner owner, CrearEditarPaisAppModel model) {
		super(owner, model)
		title= "Editar Caracteristicas"
	}
	
	override protected createFormPanel(Panel mainPanel) {
       mainPanel.layout = new VerticalLayout
       new Label(mainPanel).text = "Caracteristicas"
       new List<String>(mainPanel) => [
				(items <=> "paisSelec.caracteristicasDelPais")
				height = 150
				width = 200
				value <=> "caracteristicaASacar"
			]
			
       this.createGridActions(mainPanel)
       
       val selecPanel = new Panel(mainPanel).layout = new ColumnLayout(2)
       
       new TextBox(selecPanel).value <=> "caracteristicaAAgregar"
       
       val elementSelected = new NotNullObservable("caracteristicaAAgregar")
	   
	   new Button(selecPanel) => [
			caption = "Agregar"
			onClick([|this.modelObject.agregarCaracteristicaSelec()])
			bindEnabled(elementSelected)
		]
       }
       
       def void createGridActions(Panel mainPanel) {
		val elementSelected = new NotNullObservable("caracteristicaASacar")
		val actionsPanel = new Panel(mainPanel).layout = new HorizontalLayout
		
		new Button(actionsPanel) => [
			caption = "Eliminar"
			onClick([|modelObject.eliminarCaracteristicaSeleccionado()])
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

		new Button(actions) => [
			caption = "Cancelar"	
			onClick [|
				this.cancel
			]
		]
	}
	
}