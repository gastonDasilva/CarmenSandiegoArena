package ar.edu.carmenSandiego.ui

import org.uqbar.arena.windows.SimpleWindow
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.windows.WindowOwner
import AplicationModel.ResolverMisterioAppModel
import org.uqbar.arena.layout.ColumnLayout
import org.uqbar.arena.widgets.Label
import static extension org.uqbar.arena.xtend.ArenaXtendExtensions.*
import org.uqbar.arena.widgets.Button
import org.uqbar.arena.layout.HorizontalLayout

class ResolverMisterioWindow extends SimpleWindow<ResolverMisterioAppModel>{
	
	new(WindowOwner owner, ResolverMisterioAppModel model) {
		super(owner, model)
	}
	
	override def createMainTemplate(Panel mainPanel) {
		title = "Resolviendo:"+this.modelObject.casoRandom.getNombreCaso  
		val Panel contentPanel = new Panel(mainPanel)
		contentPanel.layout = new ColumnLayout(2)
		new Label(contentPanel).text = "Estás En:"
		new Label(contentPanel)=>[
			value <=> "paisDondeEstoy.nombrePais"
			fontSize = 13
		]
		val Panel botonPanel = new Panel(mainPanel)
		botonPanel.layout = new HorizontalLayout
		new Button(botonPanel) => [
			caption = "Orden De Arresto"
			onClick([| new OrdenDeArrestoWindow(this,this.modelObject ).open ])
		]
		new Label(contentPanel).text =this.modelObject.devolverNombreDeVillanoSiExiste
		new Label(contentPanel)=>[
			value <=> "villanoAArrestar.nombreVillano"
			fontSize = 13
		]
		new Button(botonPanel) => [
			caption = "Viajar"
			onClick([| new viajarWindow(this,this.modelObject ).open ])
		]     
		new Button(botonPanel) => [
			caption = "Expedientes"
			onClick([| new ExpedientesResolverMisterioWindow(this).open ])
		]
		this.crearBotoneraDeLugares(mainPanel)
		this.crearRecorridoDePaises(mainPanel)
	}
	
	def crearRecorridoDePaises(Panel panel) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	def crearBotoneraDeLugares(Panel panel) {
		new Label(panel).text = "Lugares"
		new Button(panel) => [
			caption = this.modelObject.paisDondeEstoy.getPrimerLugarDeInteres.nombreLugar
			onClick([| new lugaresWindow(this,this.modelObject ).open ])
		]   v
	}
	
	override protected addActions(Panel actionsPanel) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	override protected createFormPanel(Panel mainPanel) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
}