package ar.edu.carmenSandiego.ui

import org.uqbar.arena.windows.WindowOwner
import ar.gaston.carmenSanDiego.Pais
import org.uqbar.arena.aop.windows.TransactionalDialog
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.layout.ColumnLayout
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.widgets.TextBox
import org.uqbar.arena.widgets.Button
import org.uqbar.arena.widgets.tables.Table
import org.uqbar.arena.windows.Dialog
import org.uqbar.arena.widgets.tables.Column

class EditarPaisWindow extends TransactionalDialog<Pais>{
	
	new(WindowOwner owner, Pais model) {
		super(owner, model)
		title = defaultTitle
	}
	
	def defaultTitle() {
		"Mapamundi - Editar Pais"
	}
	
	override protected createFormPanel(Panel mainPanel) {
		val form = new Panel(mainPanel).layout = new ColumnLayout(2)
		new Label(form).text = "Nombre"
		
		new TextBox(form) => [
			value <=> "nombrePais"
			width = 200	
		]
		new Label(form).text = "Características"
		
		new Button(mainPanel) => [
			caption = "Editar Caracteristicas"
			onClick [|this.editarCaracteristicas]
			setAsDefault
			disableOnError	
		]
		
		val tableCaracteristicas = tablePais(mainPanel)
		this.describeGrid(tableCaracteristicas,"caracteristicasDelPais", "Características")
		
		new Label(form).text = "Conexiones"
		new Button(mainPanel) => [
			caption = "Editar Conexiones"
			onClick [|this.editarConexiones]
			setAsDefault
			disableOnError	
		]
		
		val tableConexiones = tablePais(mainPanel)
		this.describeGrid(tableConexiones,"conexionesPais","Conexiones")
		
		new Label(form).text = "Lugares De Interes"
		new Button(mainPanel) => [
			caption = "Editar Lugares"
			onClick [|this.editarLugaresDeInteres]
			setAsDefault
			disableOnError	
		]
		
		val tableLugares = tablePais(mainPanel)
		this.describeGrid(tableLugares,"LugaresDelPais","Lugares De Interes")
	}
	
	def void describeGrid(Table<Pais> table, String property, String titulo) {
		new Column<Pais>(table) => [
			title = titulo
			fixedSize = 200
			bindContentsToProperty(property)
		]	
	}
	
	def Table<Pais> tablePais(Panel mainPanel){
		val table =new Table(mainPanel, typeof(Pais)) => [
				   		width = 600
				   		height = 400
						items <=> "Pais" // Preguntar si aca va pais o Pais la clase
				]
										
		return table
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
	
	// ********************************************************
	// ** Acciones
	// ********************************************************
	
	def editarLugaresDeInteres() {
		this.openDialog(new EditarLugaresDeInteresWindow(this, modelObject.paisSeleccionado)
	}
	
	def openDialog(Dialog<?> dialog) {
		dialog.open
	}
	
	def editarConexiones() {
		this.openDialog(new EditarConexionesWindow(this, modelObject.paisSeleccionado)
	}
	
	def editarCaracteristicas() {
		this.openDialog(new EditarCaracteristicasWindow(this, modelObject.paisSeleccionado)
	}
	
	
	
	
	
	
	
}