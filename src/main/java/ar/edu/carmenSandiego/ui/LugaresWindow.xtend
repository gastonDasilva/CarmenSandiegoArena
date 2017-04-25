package ar.edu.carmenSandiego.ui

import org.uqbar.arena.windows.Dialog
import org.uqbar.arena.windows.WindowOwner
import org.uqbar.arena.widgets.Panel
import AplicationModel.LugaresDeInteresAppModel
import org.uqbar.arena.layout.ColumnLayout
import org.uqbar.arena.widgets.Label
import static extension org.uqbar.arena.xtend.ArenaXtendExtensions.*
import org.uqbar.arena.widgets.Button
import org.uqbar.arena.layout.VerticalLayout

class LugaresWindow extends Dialog<LugaresDeInteresAppModel> {
	
	new(WindowOwner owner, LugaresDeInteresAppModel model) {
		super(owner, model)
	}
	
	override protected createFormPanel(Panel mainPanel) {
		title = "Resolviendo: "+ this.modelObject.resM.nombreCaso
		val form = new Panel(mainPanel).layout = new ColumnLayout(2)
		new Label(form).text = "Estas Visitando:"
		new Label(form)=>[
			value <=> "lugar.nombreLugar"
			fontSize = 13
		]
		val form2 = new Panel(mainPanel).layout = new VerticalLayout
		new Label(form2).text = this.modelObject.lugar.procesar
		new Button(form2) => [
			caption = "Continuar"
			onClick [|if(this.modelObject.lugar.hayInformante){
						 this.modelObject.resM.agregarPaisRecorrido()
				         this.close 
				         }else {
				         		if(this.modelObject.lugar.hayCuidador){
				         			this.modelObject.resM.agregarPaisAFallidos()
				         			this.close
				         		} else {
				         				 if(this.modelObject.lugar.hayVillanoEnElLugar){
				         					 this.modelObject.resM.agregarPaisRecorrido()
				         						if(this.modelObject.resM.ordenDeArrestoNoEmitida){
				         						this.close
				         							}else{
				         								  if(this.modelObject.resM.devolverTrueSiEsElMismoVillano){
				         										new FinDelJuegoExitosoWindows(this,this.modelObject.resM).open
				         									    }else{
				         							 		 		new FinDelJuegoFallidoWindows(this,this.modelObject).open
				         										     }
				         						         }
				         				      }else{
				         							this.modelObject.resM.agregarPaisRecorrido()
				         							this.close
				         				}	   }	
				         	} 
				                  	
			]
			setAsDefault
			disableOnError		
			]
	}
	
}