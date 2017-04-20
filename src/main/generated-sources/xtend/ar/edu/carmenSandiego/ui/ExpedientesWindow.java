package ar.edu.carmenSandiego.ui;

import AplicationModel.ExpedientesAppModel;
import AplicationModel.VillanoAppModel;
import ar.edu.carmenSandiego.ui.CrearVillanoWindow;
import ar.edu.carmenSandiego.ui.EditarVillanoWindow;
import ar.gaston.carmenSanDiego.Villano;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.uqbar.arena.bindings.NotNullObservable;
import org.uqbar.arena.bindings.ObservableItems;
import org.uqbar.arena.bindings.ObservableValue;
import org.uqbar.arena.bindings.PropertyAdapter;
import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.layout.HorizontalLayout;
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
public class ExpedientesWindow extends SimpleWindow<ExpedientesAppModel> {
  public ExpedientesWindow(final WindowOwner owner) {
    super(owner, new ExpedientesAppModel());
    String _defaultTitle = this.defaultTitle();
    this.setTitle(_defaultTitle);
  }
  
  public String defaultTitle() {
    return "Expedientes";
  }
  
  public void createMainTemplate(final Panel mainPanel) {
    HorizontalLayout _horizontalLayout = new HorizontalLayout();
    mainPanel.setLayout(_horizontalLayout);
    final Panel contentPanel = new Panel(mainPanel);
    ColumnLayout _columnLayout = new ColumnLayout(2);
    contentPanel.setLayout(_columnLayout);
    this.crearListadoVillanos(contentPanel);
    this.crearEdicionDeVillanoSeleccionado(contentPanel);
  }
  
  public Button crearListadoVillanos(final Panel owner) {
    Button _xblockexpression = null;
    {
      final Panel panelDeListadoDePaises = new Panel(owner);
      HorizontalLayout _horizontalLayout = new HorizontalLayout();
      panelDeListadoDePaises.setLayout(_horizontalLayout);
      Label _label = new Label(panelDeListadoDePaises);
      _label.setText("Villanos");
      List<Villano> _list = new List<Villano>(panelDeListadoDePaises);
      final Procedure1<List<Villano>> _function = new Procedure1<List<Villano>>() {
        public void apply(final List<Villano> it) {
          ObservableItems<Selector<Villano>, Villano, ListBuilder<Villano>> _items = it.items();
          Binding _spaceship = ArenaXtendExtensions.operator_spaceship(_items, "villanos");
          PropertyAdapter _propertyAdapter = new PropertyAdapter(Villano.class, "nombre");
          _spaceship.setAdapter(_propertyAdapter);
          it.setHeight(150);
          it.setWidth(130);
          ObservableValue<Control, ControlBuilder> _value = it.<ControlBuilder>value();
          ArenaXtendExtensions.operator_spaceship(_value, "villanoSeleccionado");
        }
      };
      ObjectExtensions.<List<Villano>>operator_doubleArrow(_list, _function);
      _xblockexpression = this.crearBotoneraNuevoYEditar(owner);
    }
    return _xblockexpression;
  }
  
  public Button crearBotoneraNuevoYEditar(final Panel owner) {
    Button _xblockexpression = null;
    {
      final NotNullObservable elementSelected = new NotNullObservable("villanoSeleccionado");
      Button _button = new Button(owner);
      final Procedure1<Button> _function = new Procedure1<Button>() {
        public void apply(final Button it) {
          it.setCaption("Editar");
          final Action _function = new Action() {
            public void execute() {
              ExpedientesWindow.this.editarVillano();
            }
          };
          it.onClick(_function);
          it.<Object, ControlBuilder>bindEnabled(elementSelected);
        }
      };
      ObjectExtensions.<Button>operator_doubleArrow(_button, _function);
      Button _button_1 = new Button(owner);
      final Procedure1<Button> _function_1 = new Procedure1<Button>() {
        public void apply(final Button it) {
          it.setCaption("nuevoPais");
          final Action _function = new Action() {
            public void execute() {
              ExpedientesWindow.this.nuevoVillano();
            }
          };
          it.onClick(_function);
          it.<Object, ControlBuilder>bindEnabled(elementSelected);
        }
      };
      _xblockexpression = ObjectExtensions.<Button>operator_doubleArrow(_button_1, _function_1);
    }
    return _xblockexpression;
  }
  
  public List<String> crearEdicionDeVillanoSeleccionado(final Panel panel) {
    List<String> _xblockexpression = null;
    {
      final Panel villanoSelecPanel = new Panel(panel);
      ColumnLayout _columnLayout = new ColumnLayout(2);
      villanoSelecPanel.setLayout(_columnLayout);
      Label _label = new Label(villanoSelecPanel);
      _label.setText("Nombre:");
      Label _label_1 = new Label(villanoSelecPanel);
      final Procedure1<Label> _function = new Procedure1<Label>() {
        public void apply(final Label it) {
          ObservableValue<Control, ControlBuilder> _value = it.<ControlBuilder>value();
          ArenaXtendExtensions.operator_spaceship(_value, "villanoSeleccionado.nombre");
          it.setFontSize(13);
        }
      };
      ObjectExtensions.<Label>operator_doubleArrow(_label_1, _function);
      Label _label_2 = new Label(villanoSelecPanel);
      _label_2.setText("Sexo:");
      Label _label_3 = new Label(villanoSelecPanel);
      final Procedure1<Label> _function_1 = new Procedure1<Label>() {
        public void apply(final Label it) {
          ObservableValue<Control, ControlBuilder> _value = it.<ControlBuilder>value();
          ArenaXtendExtensions.operator_spaceship(_value, "villanoSeleccionado.sexo");
          it.setFontSize(13);
        }
      };
      ObjectExtensions.<Label>operator_doubleArrow(_label_3, _function_1);
      Label _label_4 = new Label(villanoSelecPanel);
      _label_4.setText("Señas Particulares:");
      final Panel señasPanel = new Panel(panel);
      HorizontalLayout _horizontalLayout = new HorizontalLayout();
      señasPanel.setLayout(_horizontalLayout);
      List<String> _list = new List<String>(señasPanel);
      final Procedure1<List<String>> _function_2 = new Procedure1<List<String>>() {
        public void apply(final List<String> it) {
          ObservableItems<Selector<String>, String, ListBuilder<String>> _items = it.items();
          ArenaXtendExtensions.operator_spaceship(_items, "villanoSeleccionado.señasParticulares");
          it.setHeight(150);
          it.setWidth(130);
        }
      };
      ObjectExtensions.<List<String>>operator_doubleArrow(_list, _function_2);
      Label _label_5 = new Label(señasPanel);
      _label_5.setText("Hobbies:");
      List<String> _list_1 = new List<String>(señasPanel);
      final Procedure1<List<String>> _function_3 = new Procedure1<List<String>>() {
        public void apply(final List<String> it) {
          ObservableItems<Selector<String>, String, ListBuilder<String>> _items = it.items();
          ArenaXtendExtensions.operator_spaceship(_items, "villanoSeleccionado.hobbies");
          it.setHeight(150);
          it.setWidth(130);
        }
      };
      _xblockexpression = ObjectExtensions.<List<String>>operator_doubleArrow(_list_1, _function_3);
    }
    return _xblockexpression;
  }
  
  public void nuevoVillano() {
    CrearVillanoWindow _crearVillanoWindow = new CrearVillanoWindow(this);
    this.openDialog(_crearVillanoWindow);
  }
  
  public void openDialog(final Dialog<?> dialog) {
    dialog.open();
  }
  
  public void editarVillano() {
    ExpedientesAppModel _modelObject = this.getModelObject();
    Villano _villanoSeleccionado = _modelObject.getVillanoSeleccionado();
    VillanoAppModel _villanoAppModel = new VillanoAppModel(_villanoSeleccionado);
    EditarVillanoWindow _editarVillanoWindow = new EditarVillanoWindow(this, _villanoAppModel);
    this.openDialog(_editarVillanoWindow);
  }
  
  protected void addActions(final Panel actionsPanel) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  protected void createFormPanel(final Panel mainPanel) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
}
