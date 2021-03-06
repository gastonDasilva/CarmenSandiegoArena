package ar.edu.carmenSandiego.ui;

import AplicationModel.PaisAppModel;
import ar.gaston.carmenSanDiego.Pais;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.uqbar.arena.aop.windows.TransactionalDialog;
import org.uqbar.arena.bindings.NotNullObservable;
import org.uqbar.arena.bindings.ObservableItems;
import org.uqbar.arena.bindings.ObservableValue;
import org.uqbar.arena.bindings.PropertyAdapter;
import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.layout.HorizontalLayout;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Control;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.List;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.Selector;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.arena.xtend.ArenaXtendExtensions;
import org.uqbar.lacar.ui.model.Action;
import org.uqbar.lacar.ui.model.ControlBuilder;
import org.uqbar.lacar.ui.model.ListBuilder;
import org.uqbar.lacar.ui.model.bindings.Binding;

@SuppressWarnings("all")
public class EditarConexionesWindow extends TransactionalDialog<PaisAppModel> {
  public EditarConexionesWindow(final WindowOwner owner, final PaisAppModel model) {
    super(owner, model);
    this.setTitle("Editar Conexiones");
  }
  
  protected void createFormPanel(final Panel mainPanel) {
    VerticalLayout _verticalLayout = new VerticalLayout();
    mainPanel.setLayout(_verticalLayout);
    Label _label = new Label(mainPanel);
    _label.setText("Conexiones");
    List<Pais> _list = new List<Pais>(mainPanel);
    final Procedure1<List<Pais>> _function = new Procedure1<List<Pais>>() {
      public void apply(final List<Pais> it) {
        ObservableItems<Selector<Pais>, Pais, ListBuilder<Pais>> _items = it.items();
        Binding _spaceship = ArenaXtendExtensions.operator_spaceship(_items, "paisSelec.paisConexiones");
        PropertyAdapter _propertyAdapter = new PropertyAdapter(Pais.class, "nombrePais");
        _spaceship.setAdapter(_propertyAdapter);
        it.setHeight(150);
        it.setWidth(130);
        ObservableValue<Control, ControlBuilder> _value = it.<ControlBuilder>value();
        ArenaXtendExtensions.operator_spaceship(_value, "paisConexionSelecASacar");
      }
    };
    ObjectExtensions.<List<Pais>>operator_doubleArrow(_list, _function);
    this.createGridActions(mainPanel);
    Panel _panel = new Panel(mainPanel);
    ColumnLayout _columnLayout = new ColumnLayout(2);
    final Panel selecPanel = _panel.setLayout(_columnLayout);
    Selector<Pais> _selector = new Selector<Pais>(selecPanel);
    final Procedure1<Selector<Pais>> _function_1 = new Procedure1<Selector<Pais>>() {
      public void apply(final Selector<Pais> it) {
        ObservableItems<Selector<Pais>, Pais, ListBuilder<Pais>> _items = it.items();
        ArenaXtendExtensions.operator_spaceship(_items, "paisConexionesPosibles");
        ObservableValue<Control, ControlBuilder> _value = it.<ControlBuilder>value();
        ArenaXtendExtensions.operator_spaceship(_value, "paisConexionSeleccionado");
      }
    };
    ObjectExtensions.<Selector<Pais>>operator_doubleArrow(_selector, _function_1);
    final NotNullObservable elementSelected = new NotNullObservable("paisConexionSelec");
    Button _button = new Button(selecPanel);
    final Procedure1<Button> _function_2 = new Procedure1<Button>() {
      public void apply(final Button it) {
        it.setCaption("Agregar");
        final Action _function = new Action() {
          public void execute() {
            PaisAppModel _modelObject = EditarConexionesWindow.this.getModelObject();
            _modelObject.agregarPaisConexionSelec();
          }
        };
        it.onClick(_function);
        it.<Object, ControlBuilder>bindEnabled(elementSelected);
      }
    };
    ObjectExtensions.<Button>operator_doubleArrow(_button, _function_2);
  }
  
  public void createGridActions(final Panel mainPanel) {
    final NotNullObservable elementSelected = new NotNullObservable("paisConexionSelecASacar");
    Panel _panel = new Panel(mainPanel);
    HorizontalLayout _horizontalLayout = new HorizontalLayout();
    final Panel actionsPanel = _panel.setLayout(_horizontalLayout);
    Button _button = new Button(actionsPanel);
    final Procedure1<Button> _function = new Procedure1<Button>() {
      public void apply(final Button it) {
        it.setCaption("Eliminar");
        final Action _function = new Action() {
          public void execute() {
            PaisAppModel _modelObject = EditarConexionesWindow.this.getModelObject();
            _modelObject.eliminarPaisConexionSeleccionado();
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
            EditarConexionesWindow.this.accept();
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
            EditarConexionesWindow.this.cancel();
          }
        };
        it.onClick(_function);
      }
    };
    ObjectExtensions.<Button>operator_doubleArrow(_button_1, _function_1);
  }
}
