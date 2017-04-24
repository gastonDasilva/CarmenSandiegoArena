package ar.edu.carmenSandiego.ui;

import AplicationModel.Mapamundi;
import ar.edu.carmenSandiego.ui.CrearEditarPaisAppModel;
import ar.edu.carmenSandiego.ui.CrearPaisWindow;
import ar.edu.carmenSandiego.ui.EditarPaisWindow;
import ar.gaston.carmenSanDiego.Pais;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.uqbar.arena.bindings.NotNullObservable;
import org.uqbar.arena.bindings.ObservableItems;
import org.uqbar.arena.bindings.ObservableValue;
import org.uqbar.arena.bindings.PropertyAdapter;
import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Control;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.List;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.Selector;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.arena.xtend.ArenaXtendExtensions;
import org.uqbar.lacar.ui.model.Action;
import org.uqbar.lacar.ui.model.ControlBuilder;
import org.uqbar.lacar.ui.model.ListBuilder;
import org.uqbar.lacar.ui.model.bindings.Binding;

@SuppressWarnings("all")
public class MapamundiWindow extends SimpleWindow<Mapamundi> {
  public MapamundiWindow(final WindowOwner owner) {
    super(owner, new Mapamundi());
  }
  
  public void createMainTemplate(final Panel mainPanel) {
    this.setTitle("Mapamundi");
    VerticalLayout _verticalLayout = new VerticalLayout();
    mainPanel.setLayout(_verticalLayout);
    final Panel contentPanel = new Panel(mainPanel);
    ColumnLayout _columnLayout = new ColumnLayout(2);
    contentPanel.setLayout(_columnLayout);
    this.crearListadoPais(contentPanel);
    this.crearEdicionDePaisSeleccionado(contentPanel);
  }
  
  protected void createFormPanel(final Panel mainPanel) {
  }
  
  public Button crearListadoPais(final Panel owner) {
    Button _xblockexpression = null;
    {
      final Panel panelDeListadoDePaises = new Panel(owner);
      Label _label = new Label(panelDeListadoDePaises);
      _label.setText("Paises");
      List<Pais> _list = new List<Pais>(panelDeListadoDePaises);
      final Procedure1<List<Pais>> _function = new Procedure1<List<Pais>>() {
        public void apply(final List<Pais> it) {
          ObservableItems<Selector<Pais>, Pais, ListBuilder<Pais>> _items = it.items();
          Binding _spaceship = ArenaXtendExtensions.operator_spaceship(_items, "paises");
          PropertyAdapter _propertyAdapter = new PropertyAdapter(Pais.class, "nombrePais");
          _spaceship.setAdapter(_propertyAdapter);
          it.setHeight(150);
          it.setWidth(130);
          ObservableValue<Control, ControlBuilder> _value = it.<ControlBuilder>value();
          ArenaXtendExtensions.operator_spaceship(_value, "paisSeleccionado");
          it.allowNull(true);
        }
      };
      ObjectExtensions.<List<Pais>>operator_doubleArrow(_list, _function);
      final NotNullObservable elementSelected = new NotNullObservable("paisSeleccionado");
      Button _button = new Button(panelDeListadoDePaises);
      final Procedure1<Button> _function_1 = new Procedure1<Button>() {
        public void apply(final Button it) {
          it.setCaption("Eliminar");
          final Action _function = new Action() {
            public void execute() {
              Mapamundi _modelObject = MapamundiWindow.this.getModelObject();
              _modelObject.eliminarPaisSeleccionado();
            }
          };
          it.onClick(_function);
          it.<Object, ControlBuilder>bindEnabled(elementSelected);
        }
      };
      ObjectExtensions.<Button>operator_doubleArrow(_button, _function_1);
      Button _button_1 = new Button(panelDeListadoDePaises);
      final Procedure1<Button> _function_2 = new Procedure1<Button>() {
        public void apply(final Button it) {
          it.setCaption("Editar");
          final Action _function = new Action() {
            public void execute() {
              MapamundiWindow.this.editarPais();
            }
          };
          it.onClick(_function);
          it.<Object, ControlBuilder>bindEnabled(elementSelected);
        }
      };
      ObjectExtensions.<Button>operator_doubleArrow(_button_1, _function_2);
      Button _button_2 = new Button(panelDeListadoDePaises);
      final Procedure1<Button> _function_3 = new Procedure1<Button>() {
        public void apply(final Button it) {
          it.setCaption("Nuevo");
          final Action _function = new Action() {
            public void execute() {
              MapamundiWindow.this.nuevoPais();
            }
          };
          it.onClick(_function);
        }
      };
      _xblockexpression = ObjectExtensions.<Button>operator_doubleArrow(_button_2, _function_3);
    }
    return _xblockexpression;
  }
  
  public List<Object> crearEdicionDePaisSeleccionado(final Panel owner) {
    List<Object> _xblockexpression = null;
    {
      final Panel nombrePaisPanel = new Panel(owner);
      VerticalLayout _verticalLayout = new VerticalLayout();
      nombrePaisPanel.setLayout(_verticalLayout);
      Label _label = new Label(nombrePaisPanel);
      _label.setText("Nombre:");
      Label _label_1 = new Label(nombrePaisPanel);
      final Procedure1<Label> _function = new Procedure1<Label>() {
        public void apply(final Label it) {
          ObservableValue<Control, ControlBuilder> _value = it.<ControlBuilder>value();
          ArenaXtendExtensions.operator_spaceship(_value, "paisSeleccionado.nombrePais");
          it.setFontSize(13);
        }
      };
      ObjectExtensions.<Label>operator_doubleArrow(_label_1, _function);
      Label _label_2 = new Label(nombrePaisPanel);
      _label_2.setText("Caracteristicas");
      List<Object> _list = new List<Object>(nombrePaisPanel);
      final Procedure1<List<Object>> _function_1 = new Procedure1<List<Object>>() {
        public void apply(final List<Object> it) {
          ObservableItems<Selector<Object>, Object, ListBuilder<Object>> _items = it.items();
          ArenaXtendExtensions.operator_spaceship(_items, "paisSeleccionado.caracteristicasDelPais");
          it.setWidth(200);
        }
      };
      ObjectExtensions.<List<Object>>operator_doubleArrow(_list, _function_1);
      Label _label_3 = new Label(nombrePaisPanel);
      _label_3.setText("Conexiones");
      List<Object> _list_1 = new List<Object>(nombrePaisPanel);
      final Procedure1<List<Object>> _function_2 = new Procedure1<List<Object>>() {
        public void apply(final List<Object> it) {
          ObservableItems<Selector<Object>, Object, ListBuilder<Object>> _items = it.items();
          ArenaXtendExtensions.operator_spaceship(_items, "paisSeleccionado.paisConexiones");
          it.setWidth(200);
          it.allowNull(true);
        }
      };
      _xblockexpression = ObjectExtensions.<List<Object>>operator_doubleArrow(_list_1, _function_2);
    }
    return _xblockexpression;
  }
  
  public void nuevoPais() {
    Mapamundi _modelObject = this.getModelObject();
    Pais _pais = new Pais();
    CrearEditarPaisAppModel _crearEditarPaisAppModel = new CrearEditarPaisAppModel(_modelObject, _pais);
    CrearPaisWindow _crearPaisWindow = new CrearPaisWindow(this, _crearEditarPaisAppModel);
    this.openDialog(_crearPaisWindow);
  }
  
  public void openDialog(final Dialog<?> dialog) {
    dialog.open();
  }
  
  public void editarPais() {
    Mapamundi _modelObject = this.getModelObject();
    Mapamundi _modelObject_1 = this.getModelObject();
    Pais _paisSeleccionado = _modelObject_1.getPaisSeleccionado();
    CrearEditarPaisAppModel _crearEditarPaisAppModel = new CrearEditarPaisAppModel(_modelObject, _paisSeleccionado);
    EditarPaisWindow _editarPaisWindow = new EditarPaisWindow(this, _crearEditarPaisAppModel);
    this.openDialog(_editarPaisWindow);
  }
  
  protected void addActions(final Panel actionsPanel) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
}
