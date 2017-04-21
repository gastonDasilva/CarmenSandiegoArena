package ar.edu.carmenSandiego.ui;

import AplicationModel.PaisAppModel;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.uqbar.arena.aop.windows.TransactionalDialog;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.lacar.ui.model.Action;

@SuppressWarnings("all")
public class EditarLugaresDeInteresWindow extends TransactionalDialog<PaisAppModel> {
  public EditarLugaresDeInteresWindow(final WindowOwner owner, final PaisAppModel model) {
    super(owner, model);
    this.setTitle("Editar Lugar");
  }
  
  protected void createFormPanel(final Panel mainPanel) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method agregarLugarDeInteresSelec() is undefined for the type PaisAppModel");
  }
  
  public void createGridActions(final Panel mainPanel) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method eliminarLugarSeleccionado() is undefined for the type PaisAppModel");
  }
  
  protected void addActions(final Panel actions) {
    Button _button = new Button(actions);
    final Procedure1<Button> _function = new Procedure1<Button>() {
      public void apply(final Button it) {
        it.setCaption("Aceptar");
        final Action _function = new Action() {
          public void execute() {
            EditarLugaresDeInteresWindow.this.accept();
          }
        };
        it.onClick(_function);
        it.setAsDefault();
        it.disableOnError();
      }
    };
    ObjectExtensions.<Button>operator_doubleArrow(_button, _function);
    Button _button_1 = new Button(actions);
    final Procedure1<Button> _function_1 = new Procedure1<Button>() {
      public void apply(final Button it) {
        it.setCaption("Cancelar");
        final Action _function = new Action() {
          public void execute() {
            EditarLugaresDeInteresWindow.this.cancel();
          }
        };
        it.onClick(_function);
      }
    };
    ObjectExtensions.<Button>operator_doubleArrow(_button_1, _function_1);
  }
}
