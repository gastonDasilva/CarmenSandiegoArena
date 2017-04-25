package ar.edu.carmenSandiego.ui

import org.uqbar.arena.windows.SimpleWindow
import org.uqbar.arena.windows.WindowOwner
import org.uqbar.arena.widgets.Panel
import AplicationModel.ResolverMisterioAppModel
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.widgets.Button
import org.uqbar.arena.layout.VerticalLayout
import org.uqbar.arena.layout.HorizontalLayout

class IniciarJuegoWindow extends SimpleWindow<ResolverMisterioAppModel> {
	
	new(WindowOwner parent,ResolverMisterioAppModel model) {
		super(parent, model)
	}
	
	override def createMainTemplate(Panel mainPanel) {
		title = this.modelObject.casoRandom.getNombreCaso
		val Panel contentPanel = new Panel(mainPanel)
		contentPanel.layout = new VerticalLayout
		new Label(contentPanel).text = "Detective, tenemos una caso para usted!"
		new Label(contentPanel).text = this.modelObject.agarrarCasoRandom.getReporteDelCaso
		val Panel botonPanel = new Panel(mainPanel)
		botonPanel.layout = new HorizontalLayout
		new Button(botonPanel) => [
			caption = "Aceptar el Caso"
			width = 100
			onClick [ | new ResolverMisterioWindow(this, this.modelObject).open ]
		]
		
	}

	
	override protected addActions(Panel actionsPanel) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	override protected createFormPanel(Panel mainPanel) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
}