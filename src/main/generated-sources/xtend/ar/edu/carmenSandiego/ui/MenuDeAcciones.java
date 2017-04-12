package ar.edu.carmenSandiego.ui;

import ar.edu.carmenSandiego.ui.ExpedientesWindow;
import ar.edu.carmenSandiego.ui.MapamundiWindow;
import ar.edu.carmenSandiego.ui.ResolverMisterioWindow;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.Window;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.lacar.ui.model.Action;

@SuppressWarnings("all")
public class MenuDeAcciones extends SimpleWindow<MenuDeAcciones> {
  public MenuDeAcciones(final WindowOwner parent, final MenuDeAcciones model) {
    super(parent, model);
  }
  
  public void createMainTemplate(final Panel mainPanel) {
    this.setTitle("¿Dónde Está CarmenSandiego?");
    this.setTaskDescription("¿Qué haremos ahora detective?");
    super.createMainTemplate(mainPanel);
  }
  
  protected void addActions(final Panel actionsPanel) {
    Button _button = new Button(actionsPanel);
    final Procedure1<Button> _function = new Procedure1<Button>() {
      public void apply(final Button it) {
        it.setCaption("Resolver Misterio");
        final Action _function = new Action() {
          public void execute() {
            MenuDeAcciones.this.resolverMisterio();
          }
        };
        it.onClick(_function);
      }
    };
    ObjectExtensions.<Button>operator_doubleArrow(_button, _function);
    Button _button_1 = new Button(actionsPanel);
    final Procedure1<Button> _function_1 = new Procedure1<Button>() {
      public void apply(final Button it) {
        it.setCaption("Mapamundi");
        final Action _function = new Action() {
          public void execute() {
            MenuDeAcciones.this.mostrarMapamundi();
          }
        };
        it.onClick(_function);
      }
    };
    ObjectExtensions.<Button>operator_doubleArrow(_button_1, _function_1);
    Button _button_2 = new Button(actionsPanel);
    final Procedure1<Button> _function_2 = new Procedure1<Button>() {
      public void apply(final Button it) {
        it.setCaption("Expedientes");
        final Action _function = new Action() {
          public void execute() {
            MenuDeAcciones.this.mostrarExpedientes();
          }
        };
        it.onClick(_function);
      }
    };
    ObjectExtensions.<Button>operator_doubleArrow(_button_2, _function_2);
  }
  
  public void mostrarExpedientes() {
    ExpedientesWindow _expedientesWindow = new ExpedientesWindow(this);
    this.openDialog(_expedientesWindow);
  }
  
  public void mostrarMapamundi() {
    MapamundiWindow _mapamundiWindow = new MapamundiWindow(this);
    this.openDialog(_mapamundiWindow);
  }
  
  public void openDialog(final Window window) {
    window.open();
  }
  
  public void resolverMisterio() {
    ResolverMisterioWindow _resolverMisterioWindow = new ResolverMisterioWindow(this);
    this.openDialog(_resolverMisterioWindow);
  }
  
  protected void createFormPanel(final Panel mainPanel) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
}
