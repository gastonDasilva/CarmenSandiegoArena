package ar.edu.carmenSandiego.ui;

import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.uqbar.arena.aop.windows.TransactionalDialog;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.lacar.ui.model.Action;

@SuppressWarnings("all")
public class EditarPaisWindow /* extends /* TransactionalDialog<Mapamundi> */  */{
  public EditarPaisWindow(final WindowOwner owner, final /* Mapamundi */Object model) {
    super(owner, model);
    String _defaultTitle = this.defaultTitle();
    this.setTitle(_defaultTitle);
  }
  
  public String defaultTitle() {
    return "Mapamundi - Editar Pais";
  }
  
  protected void createFormPanel(final Panel mainPanel) {
    throw new Error("Unresolved compilation problems:"
      + "\nPais cannot be resolved to a type."
      + "\nPais cannot be resolved to a type."
      + "\nLugarDeInteres cannot be resolved to a type."
      + "\nThe method or field Pais is undefined"
      + "\nThe method or field Pais is undefined"
      + "\nThe method or field LugarDeInteres is undefined");
  }
  
  public Button botonAceptar(final Panel mainPanel) {
    Button _button = new Button(mainPanel);
    final Procedure1<Button> _function = new Procedure1<Button>() {
      public void apply(final Button it) {
        it.setCaption("Aceptar");
        final Action _function = new Action() {
          public void execute() {
            EditarPaisWindow.this.close();
          }
        };
        it.onClick(_function);
      }
    };
    return ObjectExtensions.<Button>operator_doubleArrow(_button, _function);
  }
  
  protected void addActions(final Panel actions) {
  }
  
  public void editarLugaresDeInteres() {
    throw new Error("Unresolved compilation problems:"
      + "\nPaisAppModel cannot be resolved."
      + "\npaisSeleccionado cannot be resolved");
  }
  
  public void openDialog(final Dialog<?> dialog) {
    dialog.open();
  }
  
  public void editarConexiones() {
    throw new Error("Unresolved compilation problems:"
      + "\nPaisAppModel cannot be resolved."
      + "\npaisSeleccionado cannot be resolved");
  }
  
  public void editarCaracteristicas() {
    throw new Error("Unresolved compilation problems:"
      + "\nPaisAppModel cannot be resolved."
      + "\npaisSeleccionado cannot be resolved");
  }
}
