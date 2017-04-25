package ar.edu.carmenSandiego.ui

import org.uqbar.arena.windows.WindowOwner
import org.uqbar.arena.aop.windows.TransactionalDialog
import AplicationModel.VillanoAppModel
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.layout.HorizontalLayout
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.widgets.List
import org.uqbar.arena.bindings.NotNullObservable
import org.uqbar.arena.widgets.TextBox
import org.uqbar.arena.widgets.Button
import org.uqbar.arena.layout.ColumnLayout
import static extension org.uqbar.arena.xtend.ArenaXtendExtensions.*
import org.uqbar.arena.layout.VerticalLayout

class EditarHobbiesWindow extends TransactionalDialog<VillanoAppModel> {
	
	new(WindowOwner owner, VillanoAppModel model) {
		super(owner, model)
		title= "Editar Hobbies"
	}
	
	override protected createFormPanel(Panel mainPanel) {
		mainPanel.layout = new VerticalLayout
		new Label(mainPanel).text = "Hobbies"
		new List<String>(mainPanel) => [
				(items <=> "villanoSelec.hobbies")
				height = 150
				width = 130
				value <=> "hobbiesASacar"
			]
		this.createGridActions(mainPanel)
		val selecPanel = new Panel(mainPanel).layout = new ColumnLayout(2)
        new TextBox(selecPanel).value <=> "hobbiesAAgregar"
        val elementSelected = new NotNullObservable("hobbiesAAgregar")
	    new Button(selecPanel) => [
			caption = "Agregar"
			onClick([|this.modelObject.agregarhobbieSelec()])
			bindEnabled(elementSelected)
		]	
	}
	
	def void createGridActions(Panel mainPanel) {
		val elementSelected = new NotNullObservable("hobbiesASacar")
		val actionsPanel = new Panel(mainPanel).layout = new HorizontalLayout
		
		new Button(actionsPanel) => [
			caption = "Eliminar"
			onClick([|modelObject.eliminarHobbieSeleccionado()])
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