package ar.edu.carmenSandiego.ui

import org.uqbar.arena.windows.Dialog
import org.uqbar.arena.windows.WindowOwner
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.layout.VerticalLayout
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.widgets.Button
import org.uqbar.arena.layout.HorizontalLayout
import AplicationModel.LugaresDeInteresAppModel
import java.awt.Color

class FinDelJuegoFallidoWindows  extends Dialog<LugaresDeInteresAppModel>{
	
	new(WindowOwner owner, LugaresDeInteresAppModel model) {
		super(owner, model)
	}
	
	override protected createFormPanel(Panel mainPanel) {
	    title = this.modelObject.resM.casoRandom.getNombreCaso+" - Resuelto"
	    val Panel panel = new Panel(mainPanel)
		panel.layout = new VerticalLayout
		val text = new Label(panel).text = "Malas noticias :("
		text =>[
			foreground =Color.RED
			
			]
		
		new Label(panel).text = "ha detenido a "+ this.modelObject.lugar.getVillano.nombreVillano+ 
									 ",  pero usted tenia una orden de arresto contra "
									   +this.modelObject.resM.villanoAArrestar.nombreVillano+
									   " Lamentablente este crímen quedará impune"
		val Panel botonPanel = new Panel(mainPanel)
		botonPanel.layout = new HorizontalLayout							   
		new Button(botonPanel) => [
			caption = "Aceptar el error cometido"
			onClick([| this.close])
		]   
									   
	}
	
}