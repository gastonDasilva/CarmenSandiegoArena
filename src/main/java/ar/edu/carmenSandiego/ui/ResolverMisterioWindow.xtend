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
import org.uqbar.arena.layout.VerticalLayout
import org.uqbar.arena.widgets.List
import ar.gaston.carmenSanDiego.Pais
import org.uqbar.arena.bindings.PropertyAdapter
import AplicationModel.LugaresDeInteresAppModel

class ResolverMisterioWindow extends SimpleWindow<ResolverMisterioAppModel>{
	
	new(WindowOwner owner, ResolverMisterioAppModel model) {
		super(owner, model)
	}
	
	override def createMainTemplate(Panel mainPanel) {
		title = "Resolviendo:"+this.modelObject.casoRandom.getNombreCaso  
		
		val Panel contentPanel = new Panel(mainPanel)
		contentPanel.layout = new ColumnLayout(2)
		this.crearPanelPrinciapal(contentPanel)
		this.crearBotoneraDeLugares(contentPanel)
		this.crearRecorridoDePaises(mainPanel)
	    this.destinosFallidos(mainPanel)
		
	}
	def crearPanelPrinciapal(Panel panel){
		val Panel botonPanel = new Panel(panel)
		botonPanel.layout = new VerticalLayout
		new Label(botonPanel).text = "Estás En:"
		new Label(botonPanel)=>[
			value <=> "paisDondeEstoy.nombrePais"
			fontSize = 13
		]
		new Button(botonPanel) => [
			caption = "Orden De Arresto"
			onClick([| new OrdenDeArrestoWindow(this,this.modelObject ).open ])
		]
		new Label(botonPanel).text =this.modelObject.devolverNombreDeVillanoSiExiste
		new Label(botonPanel)=>[
			value <=> "villanoAArrestar.nombreVillano"
			fontSize = 13
		]
		new Button(botonPanel) => [
			caption = "Viajar"
			onClick([| new ViajarWindow(this,this.modelObject ).open ])
		]     
		new Button(botonPanel) => [
			caption = "Expedientes"
			onClick([| new ExpedientesResolverMisterioWindow(this, this.modelObject.exp).open ])
		]
	}
	
	def destinosFallidos(Panel panel) {
		val Panel contentPanel = new Panel(panel)
		contentPanel.layout = new VerticalLayout
		new Label(contentPanel).text = "Destinos Fallidos"
		new List<Pais>(contentPanel) => [
				(items <=> "paisFallidos").adapter = new PropertyAdapter(Pais, "nombrePais")
				height = 50
				width = 30
				allowNull = true
			]
		
	}
	
	def crearRecorridoDePaises(Panel panel) {
		val Panel contentPanel = new Panel(panel)
		contentPanel.layout = new VerticalLayout
		new Label(contentPanel).text = "Recorrido Criminal"
		new Label(contentPanel)=>[
			value <=> "nombrePaises"
			fontSize = 8
		]
	}
	
	def crearBotoneraDeLugares(Panel panel) {
		val Panel contentPanel = new Panel(panel)
		contentPanel.layout = new VerticalLayout
		new Label(contentPanel).text = "Lugares"
		
		val botoneraPanel = new Panel(contentPanel)
		botoneraPanel.layout = new HorizontalLayout
		new Button(botoneraPanel) => [
			caption = this.modelObject.primerLugarNombre
			onClick([| new LugaresWindow(this,new LugaresDeInteresAppModel(this.modelObject,this.modelObject.paisDondeEstoy.getPrimerLugarDeInteres)).open ])
		]
		val botoneraPanel2 = new Panel(contentPanel)
		botoneraPanel2.layout = new HorizontalLayout
		new Button(botoneraPanel2) => [
			caption = this.modelObject.segundoLugarNombre
			onClick([| new LugaresWindow(this,new LugaresDeInteresAppModel(this.modelObject,this.modelObject.paisDondeEstoy.getSegundoLugarDeInteres)).open ])
		]
		val botoneraPanel3 = new Panel(contentPanel)
		botoneraPanel3.layout = new HorizontalLayout
		new Button(botoneraPanel3) => [
			caption = this.modelObject.tercerLugarNombre
		    onClick([| new LugaresWindow(this,new LugaresDeInteresAppModel(this.modelObject,this.modelObject.paisDondeEstoy.getTercerLugarDeInteres )).open ])
		]     
	}
	
	override protected addActions(Panel actionsPanel) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	override protected createFormPanel(Panel mainPanel) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
}