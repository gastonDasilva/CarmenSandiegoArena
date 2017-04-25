package ar.edu.carmenSandiego.ui

import org.uqbar.arena.windows.WindowOwner
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.bindings.NotNullObservable
import org.uqbar.arena.layout.HorizontalLayout
import org.uqbar.arena.widgets.Button
import org.uqbar.arena.widgets.Selector
import ar.gaston.carmenSanDiego.LugarDeInteres
import org.uqbar.arena.layout.VerticalLayout
import org.uqbar.arena.widgets.List
import org.uqbar.arena.bindings.PropertyAdapter
import org.uqbar.arena.layout.ColumnLayout
import org.uqbar.arena.widgets.Label
import static extension org.uqbar.arena.xtend.ArenaXtendExtensions.*
import org.uqbar.arena.windows.Dialog
import org.uqbar.commons.model.UserException

class EditarLugaresDeInteresWindow extends Dialog<CrearEditarPaisAppModel> {
	
	new(WindowOwner owner, CrearEditarPaisAppModel model) {
		super(owner, model)
		title= "Editar Lugar"
	}
	
	override protected createFormPanel(Panel mainPanel) {
		mainPanel.layout = new VerticalLayout
		new Label(mainPanel).text = "Lugares De Interes"
		new List<LugarDeInteres>(mainPanel) => [
				(items <=> "paisSelec.lugaresDeInteres").adapter = new PropertyAdapter(LugarDeInteres, "nombreLugar")
				height = 150
				width = 130
				value <=> "lugarASacar"
			]
		val elementSelected1 = new NotNullObservable("lugarASacar")
		val actionsPanel = new Panel(mainPanel).layout = new HorizontalLayout
		
		new Button(actionsPanel) => [
			caption = "Eliminar"
			onClick([|modelObject.eliminarLugarSeleccionado()])
			bindEnabled(elementSelected1)
		]	
		val selecPanel = new Panel(mainPanel).layout = new ColumnLayout(2)
		new Selector<LugarDeInteres>(selecPanel) => [
			(items <=> "lugaresDeInteresPosibles").adapter = new PropertyAdapter(LugarDeInteres, "nombreLugar")
			value <=> "lugarDeInteresSeleccionado"
		]
		val elementSelected = new NotNullObservable("lugarDeInteresSeleccionado")
		new Button(selecPanel) => [
			caption = "Agregar"
			onClick([|this.modelObject.agregarLugarDeInteresSelec()])
			bindEnabled(elementSelected)
		]
			
	}
	
	override protected void addActions(Panel actions) {
		new Button(actions) => [
			caption = "Aceptar"
			onClick [|
				      if (this.modelObject.paisSelec.lugaresDeInteres.size !=3) {
    						throw new UserException("Debes agregar minimo 3 lugares de interes")
    					 }else{
    					 		this.accept
    					 	  }
			]
			setAsDefault
			disableOnError	
		]

		new Button(actions) => [
			caption = "Cancelar"	
			onClick [|
				this.cancel
			]
		]
	}
}