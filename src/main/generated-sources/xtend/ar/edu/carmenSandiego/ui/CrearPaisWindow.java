package ar.edu.carmenSandiego.ui;

import ar.edu.carmenSandiego.ui.CrearEditarPaisAppModel;
import ar.edu.carmenSandiego.ui.EditarPaisWindow;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.lacar.ui.model.Action;

@SuppressWarnings("all")
public class CrearPaisWindow extends EditarPaisWindow {
  public CrearPaisWindow(final WindowOwner owner, final CrearEditarPaisAppModel model) {
    super(owner, model);
  }
  
  public String defaultTitle() {
    return "Mapamundi -Nuevo Pais";
  }
  
  public Button botonAceptar(final Panel mainPanel) {
    Button _button = new Button(mainPanel);
    final Procedure1<Button> _function = new Procedure1<Button>() {
      public void apply(final Button it) {
        it.setCaption("Aceptar");
        final Action _function = new Action() {
          public void execute() {
            CrearEditarPaisAppModel _modelObject = CrearPaisWindow.this.getModelObject();
            _modelObject.agregarPais();
            CrearPaisWindow.this.close();
          }
        };
        it.onClick(_function);
      }
    };
    return ObjectExtensions.<Button>operator_doubleArrow(_button, _function);
  }
}
