package ar.edu.carmenSandiego.ui

import org.uqbar.arena.windows.SimpleWindow
import org.uqbar.arena.windows.WindowOwner
import org.uqbar.arena.widgets.Panel
import AplicationModel.ResolverMisterioAppModel
import org.uqbar.arena.layout.HorizontalLayout
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.widgets.Button

class IniciarJuegoWindow extends SimpleWindow<ResolverMisterioAppModel> {
	
	new(WindowOwner parent) {
		super(parent, new ResolverMisterioAppModel)
	}
	
	override def createMainTemplate(Panel mainPanel) {
		title = this.modelObject.casoRandom.getNombreCaso
		val Panel contentPanel = new Panel(mainPanel)
		contentPanel.layout = new HorizontalLayout
		new Label(contentPanel).text = "Detective, tenemos una caso para usted"
		new Label(contentPanel).text = "this.modelObject.agarrarCasoRandom.getReporteDelCaso"
		new Button(contentPanel) => [
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