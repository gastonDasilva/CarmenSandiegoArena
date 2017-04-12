package ar.edu.carmenSandiego.ui;

import ar.gaston.carmenSanDiego.Pais;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.uqbar.arena.aop.windows.TransactionalDialog;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.tables.Column;
import org.uqbar.arena.widgets.tables.Table;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.lacar.ui.model.Action;

@SuppressWarnings("all")
public class EditarPaisWindow extends TransactionalDialog<Pais> {
  public EditarPaisWindow(final WindowOwner owner, final Pais model) {
    super(owner, model);
    String _defaultTitle = this.defaultTitle();
    this.setTitle(_defaultTitle);
  }
  
  public String defaultTitle() {
    return "Mapamundi - Editar Pais";
  }
  
  protected void createFormPanel(final Panel mainPanel) {
    throw new Error("Unresolved compilation problems:"
      + "\n<=> cannot be resolved.");
  }
  
  public void describeGrid(final Table<Pais> table, final String property, final String titulo) {
    Column<Pais> _column = new Column<Pais>(table);
    final Procedure1<Column<Pais>> _function = new Procedure1<Column<Pais>>() {
      public void apply(final Column<Pais> it) {
        it.setTitle(titulo);
        it.setFixedSize(200);
        it.bindContentsToProperty(property);
      }
    };
    ObjectExtensions.<Column<Pais>>operator_doubleArrow(_column, _function);
  }
  
  public Table<Pais> tablePais(final Panel mainPanel) {
    throw new Error("Unresolved compilation problems:"
      + "\n<=> cannot be resolved.");
  }
  
  protected void addActions(final Panel actions) {
    Button _button = new Button(actions);
    final Procedure1<Button> _function = new Procedure1<Button>() {
      public void apply(final Button it) {
        it.setCaption("Aceptar");
        final Action _function = new Action() {
          public void execute() {
            EditarPaisWindow.this.accept();
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
            EditarPaisWindow.this.cancel();
          }
        };
        it.onClick(_function);
      }
    };
    ObjectExtensions.<Button>operator_doubleArrow(_button_1, _function_1);
  }
  
  public void editarLugaresDeInteres() {
    throw new Error("Unresolved compilation problems:"
      + "\nmissing \')\' at \'}\'"
      + "\nThe method or field paisSeleccionado is undefined for the type Pais");
  }
  
  public void openDialog(final Dialog<?> dialog) {
    dialog.open();
  }
  
  public void editarConexiones() {
    throw new Error("Unresolved compilation problems:"
      + "\nmissing \')\' at \'}\'"
      + "\nThe method or field paisSeleccionado is undefined for the type Pais"
      + "\nInvalid number of arguments. The constructor EditarConexionesWindow() is not applicable for the arguments (EditarPaisWindow,Object)"
      + "\nType mismatch: cannot convert from EditarConexionesWindow to Dialog<?>");
  }
  
  public void editarCaracteristicas() {
    throw new Error("Unresolved compilation problems:"
      + "\nmissing \')\' at \'}\'"
      + "\nThe method or field paisSeleccionado is undefined for the type Pais"
      + "\nInvalid number of arguments. The constructor EditarCaracteristicasWindow() is not applicable for the arguments (EditarPaisWindow,Object)"
      + "\nType mismatch: cannot convert from EditarCaracteristicasWindow to Dialog<?>");
  }
}
