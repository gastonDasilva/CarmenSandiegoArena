package ar.edu.carmenSandiego.ui

import org.uqbar.arena.aop.windows.TransactionalDialog
import org.uqbar.arena.windows.WindowOwner
import org.uqbar.arena.widgets.Panel
import ar.gaston.carmenSanDiego.Pais
import org.uqbar.arena.widgets.tables.Table
import org.uqbar.arena.layout.ColumnLayout
import org.uqbar.arena.widgets.tables.Column
import org.uqbar.arena.bindings.NotNullObservable
import org.uqbar.arena.layout.HorizontalLayout
import org.uqbar.arena.widgets.Button
import org.uqbar.arena.widgets.Selector
import ar.gaston.carmenSanDiego.LugarDeInteres
import org.uqbar.arena.bindings.ObservableProperty


class EditarLugaresDeInteresWindow extends TransactionalDialog<Pais> {
	
	new(WindowOwner owner, Pais model) {
		super(owner, model)
		title= "Editar Lugar"
	}
	
	override protected createFormPanel(Panel mainPanel) {
		new Panel(mainPanel).layout = new ColumnLayout(2)
		
		val table = new Table(mainPanel, typeof(Pais)) => [
				   				width = 600
				   				height = 400
								items <=> "Pais"
							   ]
		new Column<Pais>(table) => [
			title = "Lugares De Interés"
			fixedSize = 100
			bindContentsToProperty("lugaresDeInteres")
		]
		
		this.createGridActions(mainPanel)	
		
		new Selector<LugarDeInteres>(mainPanel) => [
			allowNull(false)
			value <=> "lugaresDeInteres"
			val propiedadModelos = bindItems(new ObservableProperty(repoLugares, "lugares"))
			propiedadModelos.adaptWith(typeof(LugarDeInteres), "descripcionEntera") 
		]
		val elementSelected = new NotNullObservable("LugarSeleccionado")
		val actionsPanel = new Panel(mainPanel).layout = new HorizontalLayout
		new Button(actionsPanel) => [
			caption = "Agregar"
			onClick([|modelObject.agregarLugarSeleccionado])
			bindEnabled(elementSelected)
		]
			
	}
	
	def void createGridActions(Panel mainPanel) {
		val elementSelected = new NotNullObservable("LugarSeleccionado")
		val actionsPanel = new Panel(mainPanel).layout = new HorizontalLayout
		
		new Button(actionsPanel) => [
			caption = "Eliminar"
			onClick([|modelObject.eliminarLugarSeleccionado])
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