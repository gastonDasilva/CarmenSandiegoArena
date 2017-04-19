package ar.edu.carmenSandiego.ui

import org.uqbar.arena.aop.windows.TransactionalDialog
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.windows.WindowOwner
import AplicationModel.VillanoAppModel
import org.uqbar.arena.layout.ColumnLayout
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.widgets.TextBox
import org.uqbar.arena.widgets.Button
import org.uqbar.arena.layout.HorizontalLayout
import org.uqbar.arena.widgets.List
import org.uqbar.arena.windows.Dialog
import static extension org.uqbar.arena.xtend.ArenaXtendExtensions.*
class EditarVillanoWindow extends TransactionalDialog<VillanoAppModel>  {
	
		new(WindowOwner owner, VillanoAppModel model) {
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
			value <=> "villanoSelec.nombre"
			width = 200	
		]
		
		new Label(form).text = "Sexo:"
		new TextBox(form) => [
			value <=> "villanoSelec.sexo"
			width = 200	
		]
		
		new Label(form).text = "Señas Particulares:"
		new Button(form) => [
			caption = "Editar Señas Particulares"
			onClick [|this.editarSeñasParticulares]
			setAsDefault
			disableOnError	
		]
		
		val Panel señasPanel = new Panel(mainPanel)
		señasPanel.layout = new HorizontalLayout
		new List<String>(señasPanel) => [
				(items <=> "villanoSelec.señasParticulares")
				height = 100
				width = 90
			]
			
		new Label(form).text = "Hobbies"
		new Button(form) => [
			caption = "Editar Hobbies"
			onClick [|this.editarHobbies]
			setAsDefault
			disableOnError	
		]
		
		new List<String>(señasPanel) => [
				(items <=> "villanoSelec.hobbies")
				height = 100
				width = 90
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
	
	def openDialog(Dialog<?> dialog) {
		dialog.open
	}
	
	def editarSeñasParticulares() {
		this.openDialog(new EditarSenhasParticularesWindow(this, modelObject))
	}
	
	def editarHobbies() {
			this.openDialog(new EditarHobbiesWindow(this, modelObject))
	}
 }
	
