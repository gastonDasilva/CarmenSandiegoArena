package ar.edu.carmenSandiego.ui

import ar.gaston.carmenSanDiego.LugarDeInteres
import ar.gaston.carmenSanDiego.Pais
import org.uqbar.arena.layout.ColumnLayout
import org.uqbar.arena.widgets.Button
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.widgets.List
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.widgets.TextBox
import org.uqbar.arena.widgets.tables.Column
import org.uqbar.arena.widgets.tables.Table
import org.uqbar.arena.windows.Dialog
import org.uqbar.arena.windows.WindowOwner
import static extension org.uqbar.arena.xtend.ArenaXtendExtensions.*


class EditarPaisWindow extends Dialog<CrearEditarPaisAppModel>{

	new(WindowOwner owner, CrearEditarPaisAppModel model) {
		super(owner, model)	 
		title = defaultTitle
	}
		
	def defaultTitle() {
		"Mapamundi - Editar Pais"
	}
	
	override protected createFormPanel(Panel mainPanel) {
		val form = new Panel(mainPanel).layout = new ColumnLayout(2)
		new Label(form).text = "Nombre:"
		
		new TextBox(form) => [
			value <=> "paisSelec.nombrePais"
			width = 50	
		]
		new Label(form).text = "Características"
 		
		new Button(form) => [
			caption = "Editar Caracteristicas"
			onClick [|this.editarCaracteristicas]
			setAsDefault
			disableOnError	
			]
		
		//val caracteristicasPanel = new Panel(mainPanel).layout = new VerticalLayout		
		new List<String>(mainPanel) => [
				(items <=> "paisSelec.caracteristicasDelPais")
				height = 60
				width = 80
				]
		
		val form2 = new Panel(mainPanel).layout = new ColumnLayout(2)
		new Label(form2).text = "Conexiones"
		new Button(form2) => [
			caption = "Editar Conexiones"
			onClick [|this.editarConexiones]
			setAsDefault
			disableOnError	
			]
		
		//val ConexionesPanel = new Panel(mainPanel).layout = new VerticalLayout
	 	val tablaDeConexiones = new Table<Pais>(mainPanel, Pais) => [
			items <=> "paisSelec.paisConexiones"
		] 
		new Column(tablaDeConexiones)=>[
			title = "Conexiones"
			bindContentsToProperty("nombrePais")
		]
		
		val form3 = new Panel(mainPanel).layout = new ColumnLayout(2)
		new Label(form3).text = "Lugares De Interes"
		new Button(form3) => [
			caption = "Editar Lugares"
			onClick [|this.editarLugaresDeInteres]
			setAsDefault
			disableOnError	
			]
		//val lugaresPanel = new Panel(mainPanel).layout = new VerticalLayout
		val tablaDeLugares = new Table<LugarDeInteres>(mainPanel, LugarDeInteres) =>[
			items <=> "paisSelec.lugaresDeInteres"
			]
		new Column(tablaDeLugares)=>[
			bindContentsToProperty("nombreLugar")
			title = "Lugares De Interes"
			]
		this.botonAceptar(mainPanel)	
		new Button(mainPanel) => [
			caption = "Cancelar"	
			onClick [|
				this.cancel
				]
			]
	}
	def botonAceptar(Panel mainPanel){
			new Button(mainPanel) => [
			caption = "Aceptar"
			onClick [|
				this.modelObject.editarPais
				
				this.close
			]
		]
	}
	
	override protected void addActions(Panel actions) {
	}
	
	// ********************************************************
	// ** Acciones
	// ********************************************************
	
	def editarLugaresDeInteres() {
		this.openDialog(new EditarLugaresDeInteresWindow(this, this.modelObject))
}
	
	def openDialog(Dialog<?> dialog) {
		dialog.open
	}
	 
	def editarConexiones() {
		this.openDialog(new EditarConexionesWindow(this, this.modelObject))
	}
	
	def editarCaracteristicas(){
		this.openDialog(new EditarCaracteristicasWindow(this, this.modelObject))
	}
}	
	
	
	
