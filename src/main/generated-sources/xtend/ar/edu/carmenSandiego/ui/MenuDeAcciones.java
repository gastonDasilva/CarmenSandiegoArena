package ar.edu.carmenSandiego.ui;

import ar.edu.carmenSandiego.ui.ExpedientesWindow;
import ar.edu.carmenSandiego.ui.IniciarJuegoWindow;
import ar.edu.carmenSandiego.ui.MapamundiWindow;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.MainWindow;
import org.uqbar.lacar.ui.model.Action;

@SuppressWarnings("all")
public class MenuDeAcciones /* extends /* MainWindow<MenuAccionesAppModel> */  */{
  public MenuDeAcciones(final /* MenuAccionesAppModel */Object model) {
    super(model);
  }
  
  public void createContents(final Panel mainPanel) {
    this.setTitle("¿Dónde Está CarmenSandiego?");
    Label _label = new Label(mainPanel);
    _label.setText("¿Qué haremos ahora Detective?");
    Panel _panel = new Panel(mainPanel);
    ColumnLayout _columnLayout = new ColumnLayout(3);
    final Panel selecPanel = _panel.setLayout(_columnLayout);
    Button _button = new Button(selecPanel);
    final Procedure1<Button> _function = new Procedure1<Button>() {
      public void apply(final Button it) {
        it.setCaption("Resolver Misterio");
        it.setWidth(100);
        final Action _function = new Action() {
          public void execute() {
            IniciarJuegoWindow _iniciarJuegoWindow = new IniciarJuegoWindow(MenuDeAcciones.this);
            _iniciarJuegoWindow.open();
          }
        };
        it.onClick(_function);
      }
    };
    ObjectExtensions.<Button>operator_doubleArrow(_button, _function);
    Button _button_1 = new Button(selecPanel);
    final Procedure1<Button> _function_1 = new Procedure1<Button>() {
      public void apply(final Button it) {
        it.setCaption("Mapamundi");
        it.setWidth(100);
        final Action _function = new Action() {
          public void execute() {
            MapamundiWindow _mapamundiWindow = new MapamundiWindow(MenuDeAcciones.this);
            _mapamundiWindow.open();
          }
        };
        it.onClick(_function);
      }
    };
    ObjectExtensions.<Button>operator_doubleArrow(_button_1, _function_1);
    Button _button_2 = new Button(selecPanel);
    final Procedure1<Button> _function_2 = new Procedure1<Button>() {
      public void apply(final Button it) {
        it.setCaption("Expedientes");
        it.setWidth(100);
        final Action _function = new Action() {
          public void execute() {
            ExpedientesWindow _expedientesWindow = new ExpedientesWindow(MenuDeAcciones.this);
            _expedientesWindow.open();
          }
        };
        it.onClick(_function);
      }
    };
    ObjectExtensions.<Button>operator_doubleArrow(_button_2, _function_2);
  }
  
  public static void main(final String[] args) {
    throw new Error("Unresolved compilation problems:"
      + "\nMenuAccionesAppModel cannot be resolved.");
  }
}
