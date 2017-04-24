package ar.edu.carmenSandiego.ui

import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.windows.SimpleWindow
import org.uqbar.arena.windows.WindowOwner
import org.uqbar.arena.widgets.Button
import org.uqbar.arena.bindings.NotNullObservable
import ar.gaston.carmenSanDiego.Pais
import AplicationModel.Mapamundi
import org.uqbar.arena.windows.Dialog
import org.uqbar.arena.layout.VerticalLayout
import org.uqbar.arena.layout.ColumnLayout
import org.uqbar.arena.widgets.List
import org.uqbar.arena.bindings.PropertyAdapter
import org.uqbar.arena.widgets.tables.Table
import org.uqbar.arena.widgets.tables.Column
import ar.gaston.carmenSanDiego.LugarDeInteres
import static extension org.uqbar.arena.xtend.ArenaXtendExtensions.*
import AplicationModel.PaisAppModel
import java.util.ArrayList
import java.util.function.Consumer

class MapamundiWindow extends  SimpleWindow<Mapamundi> {
	

	
	new(WindowOwner owner) {
		super(owner, new Mapamundi)
	}
	override def createMainTemplate(Panel mainPanel) {
		title = "Mapamundi"
		mainPanel.layout = new VerticalLayout
		val Panel contentPanel = new Panel(mainPanel)
		contentPanel.layout = new ColumnLayout(2)
		this.crearListadoPais(contentPanel)
		this.crearEdicionDePaisSeleccionado(contentPanel)
	}
		
	override protected createFormPanel(Panel mainPanel) {
	}
	
	def crearListadoPais(Panel owner) {
		val Panel panelDeListadoDePaises = new Panel(owner)
		new Label(panelDeListadoDePaises).text = "Paises"
		
		new List<Pais>(panelDeListadoDePaises) => [
				(items <=> "paises").adapter = new PropertyAdapter(Pais, "nombrePais")
				height = 150
	    		width = 130
				value <=> "paisSeleccionado"
				allowNull = true
			]
		//val Panel panelbotones = new Panel(owner)	
		val elementSelected = new NotNullObservable("paisSeleccionado")
		new Button(panelDeListadoDePaises) => [
			caption = "Eliminar"
			onClick([|modelObject.eliminarPaisSeleccionado])
			bindEnabled(elementSelected)
		]
		
		new Button(panelDeListadoDePaises) => [
			
			caption = "Editar"
			onClick([|this.editarPais])
			bindEnabled(elementSelected)
		]
		
		new Button(panelDeListadoDePaises) => [
			caption = "Nuevo"
			onClick([|this.nuevoPais])
		]
		
	}
	
	def crearEdicionDePaisSeleccionado(Panel owner) {
		val Panel nombrePaisPanel = new Panel(owner)
		nombrePaisPanel.layout = new VerticalLayout //ColumnLayout(2)
		new Label(nombrePaisPanel).text = "Nombre:"
		
		
		
		new Label(nombrePaisPanel)=>[
			value <=> "paisSeleccionado.nombrePais"
			fontSize = 13
		]
		
		/*val Panel PaisPanel = new Panel(owner)
		PaisPanel.layout = new VerticalLayout*/

		new Label(nombrePaisPanel).text = "Caracteristicas"
		new List(nombrePaisPanel) => [
			items <=> "paisSeleccionado.caracteristicasDelPais"
			width = 200
		]
	
		
		new Label(nombrePaisPanel).text = "Conexiones"
		
		new List(nombrePaisPanel) => [
			items <=> "paisSeleccionado.paisConexiones"
			width = 200
			allowNull= true
		]

		/*/
		new Label(nombrePaisPanel).text = "Lugares De Interes"
		val tablaDeLugares = new Table<LugarDeInteres>(nombrePaisPanel, LugarDeInteres) =>[
			items <=> "paisSeleccionado.lugaresDeInteres"
		]
		new Column(tablaDeLugares)=>[
			bindContentsToProperty("nombreLugar")
			title = "Lugares De Interes"
		]*/
				
		}	
	def nuevoPais() {
		this.openDialog(new CrearPaisWindow(this, new CrearEditarPaisAppModel(this.modelObject, new Pais)))
	}
	
	def openDialog(Dialog<?> dialog) {
		dialog.open
	}
	
	def editarPais() {
		this.openDialog(new EditarPaisWindow(this, new CrearEditarPaisAppModel(this.modelObject, this.modelObject.paisSeleccionado)))
	}
	
	override protected addActions(Panel actionsPanel) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
}
	
