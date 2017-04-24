package ar.edu.carmenSandiego.ui

import org.uqbar.arena.aop.windows.TransactionalDialog
import org.uqbar.arena.windows.WindowOwner
import org.uqbar.arena.widgets.Panel
import AplicationModel.PaisAppModel
import org.uqbar.arena.layout.VerticalLayout
import ar.gaston.carmenSanDiego.Pais
import org.uqbar.arena.widgets.List
import org.uqbar.arena.bindings.PropertyAdapter
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.bindings.NotNullObservable
import org.uqbar.arena.layout.HorizontalLayout
import org.uqbar.arena.widgets.Button
import org.uqbar.arena.widgets.Selector
import org.uqbar.arena.layout.ColumnLayout
import static extension org.uqbar.arena.xtend.ArenaXtendExtensions.*

class EditarConexionesWindow extends TransactionalDialog<PaisAppModel> {
	
	new(WindowOwner owner, PaisAppModel model) {
		super(owner, model)
		title= "Editar Conexiones"
	}
	
	override protected createFormPanel(Panel mainPanel) {
		mainPanel.layout = new VerticalLayout
		new Label(mainPanel).text = "Conexiones"
		new List<Pais>(mainPanel) => [
				(items <=> "paisSelec.paisConexiones").adapter = new PropertyAdapter(Pais, "nombrePais")
				height = 150
				width = 130
				value <=> "paisConexionSelecASacar"
				allowNull = true
			]
	 	this.createGridActions(mainPanel)	
		val selecPanel = new Panel(mainPanel).layout = new ColumnLayout(2)
		new Selector<Pais>(selecPanel) => [
			items <=> "paisConexionesPosibles"
			value <=> "paisConexionSeleccionado"
		]
		val elementSelected = new NotNullObservable("paisConexionSelec")
		new Button(selecPanel) => [
			caption = "Agregar"
			onClick([|this.modelObject.agregarPaisConexionSelec()])
			bindEnabled(elementSelected)
			
		]
		
	}
	
	def void createGridActions(Panel mainPanel) {
		val elementSelected = new NotNullObservable("paisConexionSelecASacar")
		val actionsPanel = new Panel(mainPanel).layout = new HorizontalLayout
		
		new Button(actionsPanel) => [
			caption = "Eliminar"
			onClick([|modelObject.eliminarPaisConexionSeleccionado()])
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
	