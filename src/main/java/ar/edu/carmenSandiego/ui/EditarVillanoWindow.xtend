package ar.edu.carmenSandiego.ui

import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.windows.WindowOwner
import AplicationModel.VillanoAppModel
import org.uqbar.arena.layout.ColumnLayout
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.widgets.TextBox
import org.uqbar.arena.widgets.Button
import org.uqbar.arena.widgets.List
import org.uqbar.arena.windows.Dialog
import static extension org.uqbar.arena.xtend.ArenaXtendExtensions.*
import AplicationModel.CrearEditarVillanoAppModel

class EditarVillanoWindow extends Dialog<CrearEditarVillanoAppModel>  {
	
		new(WindowOwner owner, CrearEditarVillanoAppModel model) {
		super(owner, model)
		title = defaultTitle
	}
	
	def defaultTitle() {
		"Expedientes - Editar Villano"
	}
	
	override protected createFormPanel(Panel mainPanel) {
		val form = new Panel(mainPanel).layout = new ColumnLayout(2)
		new Label(form).text = "Nombre:"
		new TextBox(form) => [
			value <=> "vil.nombre"
			width = 200	
		]
		
		new Label(form).text = "Sexo:"
		new TextBox(form) => [
			value <=> "vil.sexo"
			width = 200	
		]
		
		new Label(form).text = "Señas Particulares:"
		new Button(form) => [
			caption = "Editar Señas Particulares"
			onClick [|this.editarSeñasParticulares]
			setAsDefault
			disableOnError	
		]
		
		/*val Panel señasPanel = new Panel(mainPanel)
		señasPanel.layout = new VerticalLayout*/
		new List<String>(mainPanel) => [
				(items <=> "vil.señasParticulares")
				height = 50
				width = 30
			]
		
		val form2 = new Panel(mainPanel).layout = new ColumnLayout(2)	
		new Label(form2).text = "Hobbies"
		new Button(form2) => [
			caption = "Editar Hobbies"
			onClick [|this.editarHobbies]
			setAsDefault
			disableOnError	
		]
		
		new List<String>(mainPanel) => [
				(items <=> "vil.hobbies")
				height = 50
				width = 30
			]	
		val Panel botonAceptarPanel = new Panel(mainPanel)	
		this.botonAceptar(botonAceptarPanel)
	}
	
	
	def botonAceptar(Panel panel) {
			new Button(panel) => [
			caption = "Aceptar"
			onClick [|this.modelObject.editarVillano
					  this.close]
		]
	}
	
	override protected void addActions(Panel actions) {
	}
	
	def openDialog(Dialog<?> dialog) {
		dialog.open
	}
	
	def editarSeñasParticulares() {
		this.openDialog(new EditarSenhasParticularesWindow(this, new VillanoAppModel(modelObject.vil)))
	}
	
	def editarHobbies() {
			this.openDialog(new EditarHobbiesWindow(this, new VillanoAppModel(modelObject.vil)))
	}
 }
	
