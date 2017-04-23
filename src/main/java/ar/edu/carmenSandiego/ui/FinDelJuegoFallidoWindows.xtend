package ar.edu.carmenSandiego.ui

import AplicationModel.ResolverMisterioAppModel
import org.uqbar.arena.windows.Dialog
import org.uqbar.arena.windows.WindowOwner
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.layout.VerticalLayout
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.widgets.Button
import org.uqbar.arena.layout.HorizontalLayout

class FinDelJuegoFallidoWindows  extends Dialog<ResolverMisterioAppModel>{
	
	new(WindowOwner owner, ResolverMisterioAppModel model) {
		super(owner, model)
	}
	
	override protected createFormPanel(Panel mainPanel) {
	    title = this.modelObject.casoRandom.getNombreCaso+" - Resuelto"
	    val Panel panel = new Panel(mainPanel)
		panel.layout = new VerticalLayout
		new Label(panel).text = "Malas noticias :("
		new Label(panel).text = "ha detenido a "+ this.modelObject.villanoAArrestar.nombreVillano+ 
									 ",  pero usted tenia una orden de arresto contra "
									   +this.modelObject.casoRandom.responsable.nombreVillano+
									   "Lamentablente este crímen quedará impune"
		val Panel botonPanel = new Panel(mainPanel)
		botonPanel.layout = new HorizontalLayout							   
		new Button(botonPanel) => [
			caption = "Aceptar el error cometido"
			onClick([| this.close])
		]   
									   
	}
	
}