package ar.edu.carmenSandiego.ui;

import AplicationModel.Mapamundi;
import AplicationModel.PaisAppModel;
import ar.edu.carmenSandiego.ui.EditarCaracteristicasWindow;
import ar.edu.carmenSandiego.ui.EditarConexionesWindow;
import ar.edu.carmenSandiego.ui.EditarLugaresDeInteresWindow;
import ar.gaston.carmenSanDiego.LugarDeInteres;
import ar.gaston.carmenSanDiego.Pais;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.uqbar.arena.aop.windows.TransactionalDialog;
import org.uqbar.arena.bindings.ObservableValue;
import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Control;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.widgets.tables.Column;
import org.uqbar.arena.widgets.tables.Table;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.arena.xtend.ArenaXtendExtensions;
import org.uqbar.lacar.ui.model.Action;
import org.uqbar.lacar.ui.model.ControlBuilder;
import org.uqbar.lacar.ui.model.TableBuilder;
import org.uqbar.lacar.ui.model.bindings.ViewObservable;

@SuppressWarnings("all")
public class EditarPaisWindow extends TransactionalDialog<Mapamundi> {
  public EditarPaisWindow(final WindowOwner owner, final Mapamundi model) {
    super(owner, model);
    String _defaultTitle = this.defaultTitle();
    this.setTitle(_defaultTitle);
  }
  
  public String defaultTitle() {
    return "Mapamundi - Editar Pais";
  }
  
  protected void createFormPanel(final Panel mainPanel) {
    Panel _panel = new Panel(mainPanel);
    ColumnLayout _columnLayout = new ColumnLayout(2);
    final Panel form = _panel.setLayout(_columnLayout);
    Label _label = new Label(form);
    _label.setText("Nombre:");
    TextBox _textBox = new TextBox(form);
    final Procedure1<TextBox> _function = new Procedure1<TextBox>() {
      public void apply(final TextBox it) {
        ObservableValue<Control, ControlBuilder> _value = it.<ControlBuilder>value();
        ArenaXtendExtensions.operator_spaceship(_value, "paisSeleccionado.nombrePais");
        it.setWidth(200);
      }
    };
    ObjectExtensions.<TextBox>operator_doubleArrow(_textBox, _function);
    Label _label_1 = new Label(form);
    _label_1.setText("Características");
    Button _button = new Button(form);
    final Procedure1<Button> _function_1 = new Procedure1<Button>() {
      public void apply(final Button it) {
        it.setCaption("Editar Caracteristicas");
        final Action _function = new Action() {
          public void execute() {
            EditarPaisWindow.this.editarCaracteristicas();
          }
        };
        it.onClick(_function);
        it.setAsDefault();
        it.disableOnError();
      }
    };
    ObjectExtensions.<Button>operator_doubleArrow(_button, _function_1);
    Table<Pais> _table = new Table<Pais>(mainPanel, Pais.class);
    final Procedure1<Table<Pais>> _function_2 = new Procedure1<Table<Pais>>() {
      public void apply(final Table<Pais> it) {
        it.setWidth(600);
        it.setHeight(400);
        ViewObservable<Table<Pais>, TableBuilder<Pais>> _items = it.items();
        ArenaXtendExtensions.operator_spaceship(_items, "paisSeleccionado.caracteristicasDelPais");
      }
    };
    final Table<Pais> tablaDeCaracteristicas = ObjectExtensions.<Table<Pais>>operator_doubleArrow(_table, _function_2);
    Column<Pais> _column = new Column<Pais>(tablaDeCaracteristicas);
    final Procedure1<Column<Pais>> _function_3 = new Procedure1<Column<Pais>>() {
      public void apply(final Column<Pais> it) {
        it.bindContentsToProperty("caracteristicasDelPais");
        it.setTitle("Caracteristicas");
        it.setFixedSize(200);
      }
    };
    ObjectExtensions.<Column<Pais>>operator_doubleArrow(_column, _function_3);
    Panel _panel_1 = new Panel(mainPanel);
    ColumnLayout _columnLayout_1 = new ColumnLayout(2);
    final Panel form2 = _panel_1.setLayout(_columnLayout_1);
    Label _label_2 = new Label(form2);
    _label_2.setText("Conexiones");
    Button _button_1 = new Button(form2);
    final Procedure1<Button> _function_4 = new Procedure1<Button>() {
      public void apply(final Button it) {
        it.setCaption("Editar Conexiones");
        final Action _function = new Action() {
          public void execute() {
            EditarPaisWindow.this.editarConexiones();
          }
        };
        it.onClick(_function);
        it.setAsDefault();
        it.disableOnError();
      }
    };
    ObjectExtensions.<Button>operator_doubleArrow(_button_1, _function_4);
    Table<Pais> _table_1 = new Table<Pais>(mainPanel, Pais.class);
    final Procedure1<Table<Pais>> _function_5 = new Procedure1<Table<Pais>>() {
      public void apply(final Table<Pais> it) {
        ViewObservable<Table<Pais>, TableBuilder<Pais>> _items = it.items();
        ArenaXtendExtensions.operator_spaceship(_items, "paisSeleccionado.paisConexiones");
      }
    };
    final Table<Pais> tablaDeConexiones = ObjectExtensions.<Table<Pais>>operator_doubleArrow(_table_1, _function_5);
    Column<Pais> _column_1 = new Column<Pais>(tablaDeConexiones);
    final Procedure1<Column<Pais>> _function_6 = new Procedure1<Column<Pais>>() {
      public void apply(final Column<Pais> it) {
        it.setTitle("Conexiones");
        it.bindContentsToProperty("nombrePais");
      }
    };
    ObjectExtensions.<Column<Pais>>operator_doubleArrow(_column_1, _function_6);
    Panel _panel_2 = new Panel(mainPanel);
    ColumnLayout _columnLayout_2 = new ColumnLayout(2);
    final Panel form3 = _panel_2.setLayout(_columnLayout_2);
    Label _label_3 = new Label(form3);
    _label_3.setText("Lugares De Interes");
    Button _button_2 = new Button(form3);
    final Procedure1<Button> _function_7 = new Procedure1<Button>() {
      public void apply(final Button it) {
        it.setCaption("Editar Lugares");
        final Action _function = new Action() {
          public void execute() {
            EditarPaisWindow.this.editarLugaresDeInteres();
          }
        };
        it.onClick(_function);
        it.setAsDefault();
        it.disableOnError();
      }
    };
    ObjectExtensions.<Button>operator_doubleArrow(_button_2, _function_7);
    Table<LugarDeInteres> _table_2 = new Table<LugarDeInteres>(mainPanel, LugarDeInteres.class);
    final Procedure1<Table<LugarDeInteres>> _function_8 = new Procedure1<Table<LugarDeInteres>>() {
      public void apply(final Table<LugarDeInteres> it) {
        ViewObservable<Table<LugarDeInteres>, TableBuilder<LugarDeInteres>> _items = it.items();
        ArenaXtendExtensions.operator_spaceship(_items, "paisSeleccionado.lugaresDeInteres");
      }
    };
    final Table<LugarDeInteres> tablaDeLugares = ObjectExtensions.<Table<LugarDeInteres>>operator_doubleArrow(_table_2, _function_8);
    Column<LugarDeInteres> _column_2 = new Column<LugarDeInteres>(tablaDeLugares);
    final Procedure1<Column<LugarDeInteres>> _function_9 = new Procedure1<Column<LugarDeInteres>>() {
      public void apply(final Column<LugarDeInteres> it) {
        it.bindContentsToProperty("nombreLugar");
        it.setTitle("Lugares De Interes");
      }
    };
    ObjectExtensions.<Column<LugarDeInteres>>operator_doubleArrow(_column_2, _function_9);
    this.botonAceptar(mainPanel);
    Button _button_3 = new Button(mainPanel);
    final Procedure1<Button> _function_10 = new Procedure1<Button>() {
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
    ObjectExtensions.<Button>operator_doubleArrow(_button_3, _function_10);
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
    Mapamundi _modelObject = this.getModelObject();
    Pais _paisSeleccionado = _modelObject.getPaisSeleccionado();
    PaisAppModel _paisAppModel = new PaisAppModel(_paisSeleccionado);
    EditarLugaresDeInteresWindow _editarLugaresDeInteresWindow = new EditarLugaresDeInteresWindow(this, _paisAppModel);
    this.openDialog(_editarLugaresDeInteresWindow);
  }
  
  public void openDialog(final Dialog<?> dialog) {
    dialog.open();
  }
  
  public void editarConexiones() {
    Mapamundi _modelObject = this.getModelObject();
    Pais _paisSeleccionado = _modelObject.getPaisSeleccionado();
    PaisAppModel _paisAppModel = new PaisAppModel(_paisSeleccionado);
    EditarConexionesWindow _editarConexionesWindow = new EditarConexionesWindow(this, _paisAppModel);
    this.openDialog(_editarConexionesWindow);
  }
  
  public void editarCaracteristicas() {
    Mapamundi _modelObject = this.getModelObject();
    Pais _paisSeleccionado = _modelObject.getPaisSeleccionado();
    PaisAppModel _paisAppModel = new PaisAppModel(_paisSeleccionado);
    EditarCaracteristicasWindow _editarCaracteristicasWindow = new EditarCaracteristicasWindow(this, _paisAppModel);
    this.openDialog(_editarCaracteristicasWindow);
  }
}
