package ar.edu.carmenSandiego.ui

import org.uqbar.arena.windows.SimpleWindow
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.windows.WindowOwner
import AplicationModel.ExpedientesAppModel
import org.uqbar.arena.layout.ColumnLayout
import org.uqbar.arena.widgets.List
import org.uqbar.arena.widgets.Label
import ar.gaston.carmenSanDiego.Villano
import org.uqbar.arena.bindings.PropertyAdapter
import org.uqbar.arena.bindings.NotNullObservable
import org.uqbar.arena.widgets.Button
import org.uqbar.arena.windows.Dialog
import static extension org.uqbar.arena.xtend.ArenaXtendExtensions.*
import org.uqbar.arena.layout.VerticalLayout
import AplicationModel.CrearEditarVillanoAppModel


class ExpedientesWindow extends SimpleWindow<ExpedientesAppModel> {
	
	new(WindowOwner owner, ExpedientesAppModel model) {
		super(owner, model)
		title = defaultTitle
	}
	
		def defaultTitle() {
		"Expedientes"
	}
	override def createMainTemplate(Panel mainPanel) {
		mainPanel.layout = new VerticalLayout
		val Panel contentPanel = new Panel(mainPanel)
		contentPanel.layout = new ColumnLayout(2)
		this.crearListadoVillanos(contentPanel)
		this.crearEdicionDeVillanoSeleccionado(contentPanel)
	}
	
	
	
	def crearListadoVillanos(Panel owner) {
		val Panel panelDeListadoDevillanos = new Panel(owner)
		new Label(panelDeListadoDevillanos).text = "Villanos"
		new List<Villano>(panelDeListadoDevillanos) => [
				(items <=> "villanos").adapter = new PropertyAdapter(Villano, "nombre")
				height = 330
				width = 90
				value <=> "villanoSeleccionado"
				allowNull = true
			]
		this.crearBotoneraNuevoYEditar(panelDeListadoDevillanos)
	}
	
	def crearBotoneraNuevoYEditar(Panel owner){
		val elementSelected = new NotNullObservable("villanoSeleccionado")
		new Button(owner) => [
			caption = "Editar"
			onClick([|this.editarVillano])
			bindEnabled(elementSelected)
		]
		
		new Button(owner) => [
			caption = "Nuevo Villano "
			onClick([|this.nuevoVillano])
		]
		
	}
	
	def crearEdicionDeVillanoSeleccionado(Panel panel) {
		val Panel villanoSelecPanel = new Panel(panel)
		    villanoSelecPanel.layout = new VerticalLayout
		new Label(villanoSelecPanel).text = "Nombre:"
		new Label(villanoSelecPanel)=>[
			value <=> "villanoSeleccionado.nombre"
			fontSize = 10
		]
		new Label(villanoSelecPanel).text = "Sexo:"
		new Label(villanoSelecPanel)=>[
			value <=> "villanoSeleccionado.sexo"
			fontSize = 13
			]		
		new Label(villanoSelecPanel).text = "Señas Particulares:"
		new List<String>(villanoSelecPanel) => [
				(items <=> "villanoSeleccionado.señasParticulares")
				height = 150
				width = 90
			]
		new Label(villanoSelecPanel).text = "Hobbies:"
		new List<String>(villanoSelecPanel) => [
				(items <=> "villanoSeleccionado.hobbies")
				height = 150
				width = 90
			]
		
	}
	 
	def nuevoVillano() {
		this.openDialog(new CrearVillanoWindow(this, new CrearEditarVillanoAppModel(this.modelObject, new Villano)))
	}
	
	def openDialog(Dialog<?> dialog) {
		dialog.open
	}
	
	def editarVillano() {
		this.openDialog(new EditarVillanoWindow(this, new CrearEditarVillanoAppModel(this.modelObject, this.modelObject.villanoSeleccionado)))
	}
	
	override protected addActions(Panel actionsPanel) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	override protected createFormPanel(Panel mainPanel) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
}