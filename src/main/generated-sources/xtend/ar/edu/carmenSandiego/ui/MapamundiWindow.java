package ar.edu.carmenSandiego.ui;

import AplicationModel.Mapamundi;
import ar.edu.carmenSandiego.ui.CrearPaisWindow;
import ar.edu.carmenSandiego.ui.EditarPaisWindow;
import ar.gaston.carmenSanDiego.LugarDeInteres;
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
import org.uqbar.arena.widgets.tables.Column;
import org.uqbar.arena.widgets.tables.Table;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.arena.xtend.ArenaXtendExtensions;
import org.uqbar.lacar.ui.model.Action;
import org.uqbar.lacar.ui.model.ControlBuilder;
import org.uqbar.lacar.ui.model.ListBuilder;
import org.uqbar.lacar.ui.model.TableBuilder;
import org.uqbar.lacar.ui.model.bindings.Binding;
import org.uqbar.lacar.ui.model.bindings.ViewObservable;

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
  
  public Column<LugarDeInteres> crearEdicionDePaisSeleccionado(final Panel owner) {
    Column<LugarDeInteres> _xblockexpression = null;
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
      Table<Pais> _table = new Table<Pais>(nombrePaisPanel, Pais.class);
      final Procedure1<Table<Pais>> _function_1 = new Procedure1<Table<Pais>>() {
        public void apply(final Table<Pais> it) {
          ViewObservable<Table<Pais>, TableBuilder<Pais>> _items = it.items();
          ArenaXtendExtensions.operator_spaceship(_items, "paisSeleccionado");
        }
      };
      final Table<Pais> tablaDeCaracteristicas = ObjectExtensions.<Table<Pais>>operator_doubleArrow(_table, _function_1);
      Column<Pais> _column = new Column<Pais>(tablaDeCaracteristicas);
      final Procedure1<Column<Pais>> _function_2 = new Procedure1<Column<Pais>>() {
        public void apply(final Column<Pais> it) {
          it.bindContentsToProperty("caracteristicasDelPais");
          it.setTitle("Caracteristicas");
        }
      };
      ObjectExtensions.<Column<Pais>>operator_doubleArrow(_column, _function_2);
      Label _label_3 = new Label(nombrePaisPanel);
      _label_3.setText("Conexiones");
      Table<Pais> _table_1 = new Table<Pais>(nombrePaisPanel, Pais.class);
      final Procedure1<Table<Pais>> _function_3 = new Procedure1<Table<Pais>>() {
        public void apply(final Table<Pais> it) {
          ViewObservable<Table<Pais>, TableBuilder<Pais>> _items = it.items();
          ArenaXtendExtensions.operator_spaceship(_items, "paisSeleccionado.paisConexiones");
        }
      };
      final Table<Pais> tablaDeConexiones = ObjectExtensions.<Table<Pais>>operator_doubleArrow(_table_1, _function_3);
      Column<Pais> _column_1 = new Column<Pais>(tablaDeConexiones);
      final Procedure1<Column<Pais>> _function_4 = new Procedure1<Column<Pais>>() {
        public void apply(final Column<Pais> it) {
          it.bindContentsToProperty("nombrePais");
          it.setTitle("Conexiones");
        }
      };
      ObjectExtensions.<Column<Pais>>operator_doubleArrow(_column_1, _function_4);
      Label _label_4 = new Label(nombrePaisPanel);
      _label_4.setText("Lugares De Interes");
      Table<LugarDeInteres> _table_2 = new Table<LugarDeInteres>(nombrePaisPanel, LugarDeInteres.class);
      final Procedure1<Table<LugarDeInteres>> _function_5 = new Procedure1<Table<LugarDeInteres>>() {
        public void apply(final Table<LugarDeInteres> it) {
          ViewObservable<Table<LugarDeInteres>, TableBuilder<LugarDeInteres>> _items = it.items();
          ArenaXtendExtensions.operator_spaceship(_items, "paisSeleccionado.lugaresDeInteres");
        }
      };
      final Table<LugarDeInteres> tablaDeLugares = ObjectExtensions.<Table<LugarDeInteres>>operator_doubleArrow(_table_2, _function_5);
      Column<LugarDeInteres> _column_2 = new Column<LugarDeInteres>(tablaDeLugares);
      final Procedure1<Column<LugarDeInteres>> _function_6 = new Procedure1<Column<LugarDeInteres>>() {
        public void apply(final Column<LugarDeInteres> it) {
          it.bindContentsToProperty("nombreLugar");
          it.setTitle("Lugares De Interes");
        }
      };
      _xblockexpression = ObjectExtensions.<Column<LugarDeInteres>>operator_doubleArrow(_column_2, _function_6);
    }
    return _xblockexpression;
  }
  
  public void nuevoPais() {
    Mapamundi _modelObject = this.getModelObject();
    CrearPaisWindow _crearPaisWindow = new CrearPaisWindow(this, _modelObject);
    this.openDialog(_crearPaisWindow);
  }
  
  public void openDialog(final Dialog<?> dialog) {
    dialog.open();
  }
  
  public void editarPais() {
    Mapamundi _modelObject = this.getModelObject();
    EditarPaisWindow _editarPaisWindow = new EditarPaisWindow(this, _modelObject);
    this.openDialog(_editarPaisWindow);
  }
  
  protected void addActions(final Panel actionsPanel) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
}
