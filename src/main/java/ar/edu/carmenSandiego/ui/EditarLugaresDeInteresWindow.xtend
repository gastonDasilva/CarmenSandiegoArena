package ar.edu.carmenSandiego.ui

import org.uqbar.arena.aop.windows.TransactionalDialog
import org.uqbar.arena.windows.WindowOwner
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.bindings.NotNullObservable
import org.uqbar.arena.layout.HorizontalLayout
import org.uqbar.arena.widgets.Button
import org.uqbar.arena.widgets.Selector
import ar.gaston.carmenSanDiego.LugarDeInteres
import org.uqbar.arena.layout.VerticalLayout
import AplicationModel.PaisAppModel
import org.uqbar.arena.widgets.List
import org.uqbar.arena.bindings.PropertyAdapter
import org.uqbar.arena.layout.ColumnLayout
import org.uqbar.arena.widgets.Label
import static extension org.uqbar.arena.xtend.ArenaXtendExtensions.*
class EditarLugaresDeInteresWindow extends TransactionalDialog<PaisAppModel> {
	
	new(WindowOwner owner, PaisAppModel model) {
		super(owner, model)
		title= "Editar Lugar"
	}
	
	override protected createFormPanel(Panel mainPanel) {
		mainPanel.layout = new VerticalLayout
		new Label(mainPanel).text = "Lugares De Interes"
		new List<LugarDeInteres>(mainPanel) => [
				(items <=> "paisSelec.lugaresDeInteres").adapter = new PropertyAdapter(LugarDeInteres, "nombreLugar")
				height = 150
				width = 130
				value <=> "LugarDeInteresSeleccionadoASacar"
			]
		this.createGridActions(mainPanel)	
		val selecPanel = new Panel(mainPanel).layout = new ColumnLayout(2)
		new Selector<LugarDeInteres>(selecPanel) => [
			items <=> "lugaresDeInteresPosibles"
			value <=> "LugarDeInteresSeleccionado"
		]
		val elementSelected = new NotNullObservable("LugarDeInteresSeleccionado")
		new Button(selecPanel) => [
			caption = "Agregar"
			onClick([|this.modelObject.agregarLugarDeInteresSelec()])
			bindEnabled(elementSelected)
		]
			
	}
	
	def void createGridActions(Panel mainPanel) {
		val elementSelected = new NotNullObservable("LugarDeInteresSeleccionadoASacar")
		val actionsPanel = new Panel(mainPanel).layout = new HorizontalLayout
		
		new Button(actionsPanel) => [
			caption = "Eliminar"
			onClick([|modelObject.eliminarLugarSeleccionado()])
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