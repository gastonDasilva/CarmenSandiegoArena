package ar.edu.carmenSandiego.ui

import AplicationModel.ResolverMisterioAppModel
import org.uqbar.arena.windows.Dialog
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.windows.WindowOwner
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.layout.VerticalLayout
import static extension org.uqbar.arena.xtend.ArenaXtendExtensions.*
import org.uqbar.arena.widgets.List
import ar.gaston.carmenSanDiego.Pais
import org.uqbar.arena.bindings.PropertyAdapter
import org.uqbar.arena.widgets.Button
import org.uqbar.arena.layout.HorizontalLayout
import org.uqbar.arena.bindings.NotNullObservable

class ViajarWindow extends Dialog<ResolverMisterioAppModel>{
	
	new(WindowOwner owner, ResolverMisterioAppModel model) {
		super(owner, model)
	}
	
	override protected createFormPanel(Panel mainPanel) {
		title = "Viajar"
		val Panel panelPrincipal = new Panel(mainPanel)
		panelPrincipal.layout = new VerticalLayout
		new Label(panelPrincipal).text = "Estás En:"
		new Label(panelPrincipal)=>[
			value <=> "paisDondeEstoy.nombrePais"
			fontSize = 13
		]
		new Label(panelPrincipal).text = "Posibles Destinos"
		new List<Pais>(panelPrincipal) => [
				(items <=> "paisDondeEstoy.paisConexiones").adapter = new PropertyAdapter(Pais, "nombrePais")
				height = 50
				width = 200
				value <=>"paisSeleccionado"
				allowNull = true
			]
		val Panel botonPanel = new Panel(mainPanel)
		botonPanel.layout = new HorizontalLayout	
		val element = new NotNullObservable("paisAnterior")
		new Button(botonPanel) => [
			caption = "Volver Al Pais Anterior"
			onClick([| this.modelObject.volverAlPaisAnterior
				       this.close
				       //agragado por mi
				      // new ResolverMisterioWindow(this, this.modelObject).open	
			])
			bindEnabled(element)
		]
		val elementSelected = new NotNullObservable("paisSeleccionado")
		new Button(botonPanel) => [
			caption = "Viajar"
			onClick([| this.modelObject.viajar(this.modelObject.paisSeleccionado)
						//this.modelObject.setearNombreLugares(this.modelObject.paisSeleccionado)
				       this.close
				       ])
			bindEnabled(elementSelected)	       
		]
	}
	
}