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
import org.uqbar.arena.layout.HorizontalLayout
import org.uqbar.arena.windows.Dialog
import AplicationModel.VillanoAppModel
import static extension org.uqbar.arena.xtend.ArenaXtendExtensions.*
class ExpedientesWindow extends SimpleWindow<ExpedientesAppModel> {
	
	new(WindowOwner owner) {
		super(owner, new ExpedientesAppModel)
		title = defaultTitle
	}
	
		def defaultTitle() {
		"Expedientes"
	}
	override def createMainTemplate(Panel mainPanel) {
		mainPanel.layout = new HorizontalLayout
		val Panel contentPanel = new Panel(mainPanel)
		contentPanel.layout = new ColumnLayout(2)
		this.crearListadoVillanos(contentPanel)
		this.crearEdicionDeVillanoSeleccionado(contentPanel)
	}
	
	
	
	def crearListadoVillanos(Panel owner) {
		val Panel panelDeListadoDePaises = new Panel(owner)
		panelDeListadoDePaises.layout = new HorizontalLayout
		new Label(panelDeListadoDePaises).text = "Villanos"
		new List<Villano>(panelDeListadoDePaises) => [
				(items <=> "villanos").adapter = new PropertyAdapter(Villano, "nombre")
				height = 150
				width = 130
				value <=> "villanoSeleccionado"
			]
		this.crearBotoneraNuevoYEditar(owner)
	}
	
	def crearBotoneraNuevoYEditar(Panel owner){
		val elementSelected = new NotNullObservable("villanoSeleccionado")
		new Button(owner) => [
			caption = "Editar"
			onClick([|this.editarVillano])
			bindEnabled(elementSelected)
		]
		
		new Button(owner) => [
			caption = "nuevoPais"
			onClick([|this.nuevoVillano])
			bindEnabled(elementSelected)
		]
		
	}
	
	def crearEdicionDeVillanoSeleccionado(Panel panel) {
		val Panel villanoSelecPanel = new Panel(panel)
		villanoSelecPanel.layout = new ColumnLayout(2)
		new Label(villanoSelecPanel).text = "Nombre:"
		new Label(villanoSelecPanel)=>[
			value <=> "villanoSeleccionado.nombre"
			fontSize = 13
		]
		new Label(villanoSelecPanel).text = "Sexo:"
		new Label(villanoSelecPanel)=>[
			value <=> "villanoSeleccionado.sexo"
			fontSize = 13
		]
		new Label(villanoSelecPanel).text = "Señas Particulares:"
		val Panel señasPanel = new Panel(panel)
		señasPanel.layout = new HorizontalLayout
		new List<String>(señasPanel) => [
				(items <=> "villanoSeleccionado.señasParticulares")
				height = 150
				width = 130
			]
		new Label(señasPanel).text = "Hobbies:"
		new List<String>(señasPanel) => [
				(items <=> "villanoSeleccionado.hobbies")
				height = 150
				width = 130
			]
		
	}
	
	def nuevoVillano() {
			this.openDialog(new CrearVillanoWindow(this))
	}
	
	def openDialog(Dialog<?> dialog) {
		dialog.open
	}
	
	def editarVillano() {
		this.openDialog(new EditarVillanoWindow(this, new VillanoAppModel(modelObject.villanoSeleccionado)))
	}
	
	override protected addActions(Panel actionsPanel) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	override protected createFormPanel(Panel mainPanel) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
}