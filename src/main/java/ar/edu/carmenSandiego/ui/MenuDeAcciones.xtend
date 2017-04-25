package ar.edu.carmenSandiego.ui

import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.widgets.Button
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.windows.MainWindow
import org.uqbar.arena.layout.ColumnLayout
import AplicationModel.MenuAccionesAppModel

class MenuDeAcciones extends MainWindow<MenuAccionesAppModel>{
	
	new(MenuAccionesAppModel model) {
		super(model)
	}
	
	override createContents(Panel mainPanel) {
		title = "¿Dónde Está CarmenSandiego?"
		new Label(mainPanel).text = "¿Qué haremos ahora Detective?"
		val selecPanel = new Panel(mainPanel).layout = new ColumnLayout(3)
		new Button(selecPanel) => [
			caption = "Resolver Misterio"
			width = 100
			onClick [ | new IniciarJuegoWindow(this,this.modelObject.res).open ]
		]
		new Button(selecPanel) => [
			caption = "Mapamundi"
			width = 100
			onClick [ | new MapamundiWindow(this,this.modelObject.map).open ]
		]
		new Button(selecPanel) => [
			caption = "Expedientes"
			width = 100
			onClick [ | new ExpedientesWindow(this, this.modelObject.exp).open ]
		]
	}
	def static main(String[] args) {
		new MenuDeAcciones(new MenuAccionesAppModel).startApplication
	
}
}