package ar.edu.carmenSandiego.ui

import org.uqbar.arena.windows.Dialog
import AplicationModel.ResolverMisterioAppModel
import org.uqbar.arena.windows.WindowOwner
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.layout.VerticalLayout
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.widgets.Button
import org.uqbar.arena.layout.HorizontalLayout
import java.awt.Color

class FinDelJuegoExitosoWindows extends Dialog<ResolverMisterioAppModel> {
	
	new(WindowOwner owner, ResolverMisterioAppModel model) {
		super(owner, model)
	}
	
	override protected createFormPanel(Panel mainPanel) {
		title = this.modelObject.casoRandom.getNombreCaso+" - Resuelto"
		val Panel Panel = new Panel(mainPanel)
		Panel.layout = new VerticalLayout
		new Label(Panel).text = "En Hora Buena!!!"
		new Label(Panel).text = "ha detenido a "+ this.modelObject.villanoAArrestar.nombreVillano+ 
									 " y repuerado el objeto "+this.modelObject.casoRandom.objetoRobado
		val text = new Label(Panel).text  = "Felicitaciones!!!"
		text =>[
			foreground =Color.GREEN
			
			]
		val Panel botonPanel = new Panel(mainPanel)
		botonPanel.layout = new HorizontalLayout
		new Button(botonPanel) => [
			caption = "Disfrutar De Nuestra Victoria"
			onClick([| this.close])
		]   
	}
	
}