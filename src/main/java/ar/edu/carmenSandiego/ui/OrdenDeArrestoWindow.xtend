package ar.edu.carmenSandiego.ui

import AplicationModel.ResolverMisterioAppModel
import org.uqbar.arena.windows.Dialog
import org.uqbar.arena.windows.WindowOwner
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.layout.VerticalLayout
import static extension org.uqbar.arena.xtend.ArenaXtendExtensions.*
import org.uqbar.arena.layout.HorizontalLayout
import org.uqbar.arena.widgets.Selector
import org.uqbar.arena.widgets.Button
import org.uqbar.arena.bindings.PropertyAdapter
import ar.gaston.carmenSanDiego.Villano

class OrdenDeArrestoWindow extends Dialog<ResolverMisterioAppModel> {
	
	new(WindowOwner owner, ResolverMisterioAppModel model) {
		super(owner, model)
	}
	
	override protected createFormPanel(Panel mainPanel) {
		title = "Resolviendo:"+this.modelObject.casoRandom.getNombreCaso
		val Panel panelPrincipal = new Panel(mainPanel)
		panelPrincipal.layout = new VerticalLayout
		new Label(panelPrincipal).text =this.modelObject.devolverNombreDeVillanoSiExiste
		new Label(panelPrincipal)=>[
			value <=> "villanoAArrestar.nombreVillano"
			fontSize = 13
		]
		val Panel panelPrincipalSelecetor = new Panel(mainPanel)
		panelPrincipalSelecetor.layout = new HorizontalLayout
		new Label(panelPrincipalSelecetor).text = "Villano:"
		new Selector(panelPrincipalSelecetor) => [
			(items <=> "exp.villanos").adapter = new PropertyAdapter(Villano, "nombre")
			value <=> "villanoAArrestar"
			width = 200
		]
		new Button(mainPanel) => [
			caption = "Generar Orden De Arresto"
			onClick([| this.modelObject.generarOrdenDeArresto()
					   this.close
			])
		]
	}
	
	
}