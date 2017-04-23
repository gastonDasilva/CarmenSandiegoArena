package ar.edu.carmenSandiego.ui;

import ar.edu.carmenSandiego.ui.CrearEditarPaisAppModel;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.uqbar.arena.bindings.NotNullObservable;
import org.uqbar.arena.bindings.ObservableItems;
import org.uqbar.arena.bindings.ObservableValue;
import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.layout.HorizontalLayout;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Control;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.List;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.Selector;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.arena.xtend.ArenaXtendExtensions;
import org.uqbar.lacar.ui.model.Action;
import org.uqbar.lacar.ui.model.ControlBuilder;
import org.uqbar.lacar.ui.model.ListBuilder;

@SuppressWarnings("all")
public class EditarCaracteristicasWindow extends Dialog<CrearEditarPaisAppModel> {
  public EditarCaracteristicasWindow(final WindowOwner owner, final CrearEditarPaisAppModel model) {
    super(owner, model);
    this.setTitle("Editar Caracteristicas");
  }
  
  protected void createFormPanel(final Panel mainPanel) {
    VerticalLayout _verticalLayout = new VerticalLayout();
    mainPanel.setLayout(_verticalLayout);
    Label _label = new Label(mainPanel);
    _label.setText("Caracteristicas");
    List<String> _list = new List<String>(mainPanel);
    final Procedure1<List<String>> _function = new Procedure1<List<String>>() {
      public void apply(final List<String> it) {
        ObservableItems<Selector<String>, String, ListBuilder<String>> _items = it.items();
        ArenaXtendExtensions.operator_spaceship(_items, "paisSelec.caracteristicasDelPais");
        it.setHeight(150);
        it.setWidth(200);
        ObservableValue<Control, ControlBuilder> _value = it.<ControlBuilder>value();
        ArenaXtendExtensions.operator_spaceship(_value, "caracteristicaASacar");
      }
    };
    ObjectExtensions.<List<String>>operator_doubleArrow(_list, _function);
    this.createGridActions(mainPanel);
    Panel _panel = new Panel(mainPanel);
    ColumnLayout _columnLayout = new ColumnLayout(2);
    final Panel selecPanel = _panel.setLayout(_columnLayout);
    TextBox _textBox = new TextBox(selecPanel);
    ObservableValue<Control, ControlBuilder> _value = _textBox.<ControlBuilder>value();
    ArenaXtendExtensions.operator_spaceship(_value, "caracteristicaAAgregar");
    final NotNullObservable elementSelected = new NotNullObservable("caracteristicaAAgregar");
    Button _button = new Button(selecPanel);
    final Procedure1<Button> _function_1 = new Procedure1<Button>() {
      public void apply(final Button it) {
        it.setCaption("Agregar");
        final Action _function = new Action() {
          public void execute() {
            CrearEditarPaisAppModel _modelObject = EditarCaracteristicasWindow.this.getModelObject();
            _modelObject.agregarCaracteristicaSelec();
          }
        };
        it.onClick(_function);
        it.<Object, ControlBuilder>bindEnabled(elementSelected);
      }
    };
    ObjectExtensions.<Button>operator_doubleArrow(_button, _function_1);
  }
  
  public void createGridActions(final Panel mainPanel) {
    final NotNullObservable elementSelected = new NotNullObservable("caracteristicaASacar");
    Panel _panel = new Panel(mainPanel);
    HorizontalLayout _horizontalLayout = new HorizontalLayout();
    final Panel actionsPanel = _panel.setLayout(_horizontalLayout);
    Button _button = new Button(actionsPanel);
    final Procedure1<Button> _function = new Procedure1<Button>() {
      public void apply(final Button it) {
        it.setCaption("Eliminar");
        final Action _function = new Action() {
          public void execute() {
            CrearEditarPaisAppModel _modelObject = EditarCaracteristicasWindow.this.getModelObject();
            _modelObject.eliminarCaracteristicaSeleccionado();
          }
        };
        it.onClick(_function);
        it.<Object, ControlBuilder>bindEnabled(elementSelected);
      }
    };
    ObjectExtensions.<Button>operator_doubleArrow(_button, _function);
  }
  
  protected void addActions(final Panel actions) {
    Button _button = new Button(actions);
    final Procedure1<Button> _function = new Procedure1<Button>() {
      public void apply(final Button it) {
        it.setCaption("Aceptar");
        final Action _function = new Action() {
          public void execute() {
            EditarCaracteristicasWindow.this.accept();
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
            EditarCaracteristicasWindow.this.cancel();
          }
        };
        it.onClick(_function);
      }
    };
    ObjectExtensions.<Button>operator_doubleArrow(_button_1, _function_1);
  }
}
