package ar.edu.carmenSandiego.ui;

import AplicationModel.ExpedientesAppModel;
import AplicationModel.LugaresDeInteresAppModel;
import AplicationModel.ResolverMisterioAppModel;
import ar.edu.carmenSandiego.ui.ExpedientesResolverMisterioWindow;
import ar.edu.carmenSandiego.ui.LugaresWindow;
import ar.edu.carmenSandiego.ui.OrdenDeArrestoWindow;
import ar.edu.carmenSandiego.ui.ViajarWindow;
import ar.gaston.carmenSanDiego.Caso;
import ar.gaston.carmenSanDiego.LugarDeInteres;
import ar.gaston.carmenSanDiego.Pais;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
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
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.arena.xtend.ArenaXtendExtensions;
import org.uqbar.lacar.ui.model.Action;
import org.uqbar.lacar.ui.model.ControlBuilder;
import org.uqbar.lacar.ui.model.ListBuilder;
import org.uqbar.lacar.ui.model.bindings.Binding;

@SuppressWarnings("all")
public class ResolverMisterioWindow extends SimpleWindow<ResolverMisterioAppModel> {
  public ResolverMisterioWindow(final WindowOwner owner, final ResolverMisterioAppModel model) {
    super(owner, model);
  }
  
  public void createMainTemplate(final Panel mainPanel) {
    ResolverMisterioAppModel _modelObject = this.getModelObject();
    Caso _casoRandom = _modelObject.getCasoRandom();
    String _nombreCaso = _casoRandom.getNombreCaso();
    String _plus = ("Resolviendo:" + _nombreCaso);
    this.setTitle(_plus);
    final Panel contentPanel = new Panel(mainPanel);
    ColumnLayout _columnLayout = new ColumnLayout(2);
    contentPanel.setLayout(_columnLayout);
    this.crearPanelPrinciapal(contentPanel);
    this.crearBotoneraDeLugares(contentPanel);
    this.crearRecorridoDePaises(mainPanel);
    this.destinosFallidos(mainPanel);
  }
  
  public Button crearPanelPrinciapal(final Panel panel) {
    Button _xblockexpression = null;
    {
      final Panel botonPanel = new Panel(panel);
      VerticalLayout _verticalLayout = new VerticalLayout();
      botonPanel.setLayout(_verticalLayout);
      Label _label = new Label(botonPanel);
      _label.setText("Estás En:");
      Label _label_1 = new Label(botonPanel);
      final Procedure1<Label> _function = new Procedure1<Label>() {
        public void apply(final Label it) {
          ObservableValue<Control, ControlBuilder> _value = it.<ControlBuilder>value();
          ArenaXtendExtensions.operator_spaceship(_value, "paisDondeEstoy.nombrePais");
          it.setFontSize(13);
        }
      };
      ObjectExtensions.<Label>operator_doubleArrow(_label_1, _function);
      Button _button = new Button(botonPanel);
      final Procedure1<Button> _function_1 = new Procedure1<Button>() {
        public void apply(final Button it) {
          it.setCaption("Orden De Arresto");
          final Action _function = new Action() {
            public void execute() {
              ResolverMisterioAppModel _modelObject = ResolverMisterioWindow.this.getModelObject();
              OrdenDeArrestoWindow _ordenDeArrestoWindow = new OrdenDeArrestoWindow(ResolverMisterioWindow.this, _modelObject);
              _ordenDeArrestoWindow.open();
            }
          };
          it.onClick(_function);
        }
      };
      ObjectExtensions.<Button>operator_doubleArrow(_button, _function_1);
      Label _label_2 = new Label(botonPanel);
      ResolverMisterioAppModel _modelObject = this.getModelObject();
      String _devolverNombreDeVillanoSiExiste = _modelObject.devolverNombreDeVillanoSiExiste();
      _label_2.setText(_devolverNombreDeVillanoSiExiste);
      Label _label_3 = new Label(botonPanel);
      final Procedure1<Label> _function_2 = new Procedure1<Label>() {
        public void apply(final Label it) {
          ObservableValue<Control, ControlBuilder> _value = it.<ControlBuilder>value();
          ArenaXtendExtensions.operator_spaceship(_value, "villanoAArrestar.nombreVillano");
          it.setFontSize(13);
        }
      };
      ObjectExtensions.<Label>operator_doubleArrow(_label_3, _function_2);
      Button _button_1 = new Button(botonPanel);
      final Procedure1<Button> _function_3 = new Procedure1<Button>() {
        public void apply(final Button it) {
          it.setCaption("Viajar");
          final Action _function = new Action() {
            public void execute() {
              ResolverMisterioAppModel _modelObject = ResolverMisterioWindow.this.getModelObject();
              ViajarWindow _viajarWindow = new ViajarWindow(ResolverMisterioWindow.this, _modelObject);
              _viajarWindow.open();
            }
          };
          it.onClick(_function);
        }
      };
      ObjectExtensions.<Button>operator_doubleArrow(_button_1, _function_3);
      Button _button_2 = new Button(botonPanel);
      final Procedure1<Button> _function_4 = new Procedure1<Button>() {
        public void apply(final Button it) {
          it.setCaption("Expedientes");
          final Action _function = new Action() {
            public void execute() {
              ResolverMisterioAppModel _modelObject = ResolverMisterioWindow.this.getModelObject();
              ExpedientesAppModel _exp = _modelObject.getExp();
              ExpedientesResolverMisterioWindow _expedientesResolverMisterioWindow = new ExpedientesResolverMisterioWindow(ResolverMisterioWindow.this, _exp);
              _expedientesResolverMisterioWindow.open();
            }
          };
          it.onClick(_function);
        }
      };
      _xblockexpression = ObjectExtensions.<Button>operator_doubleArrow(_button_2, _function_4);
    }
    return _xblockexpression;
  }
  
  public List<Pais> destinosFallidos(final Panel panel) {
    List<Pais> _xblockexpression = null;
    {
      final Panel contentPanel = new Panel(panel);
      VerticalLayout _verticalLayout = new VerticalLayout();
      contentPanel.setLayout(_verticalLayout);
      Label _label = new Label(contentPanel);
      _label.setText("Destinos Fallidos");
      List<Pais> _list = new List<Pais>(contentPanel);
      final Procedure1<List<Pais>> _function = new Procedure1<List<Pais>>() {
        public void apply(final List<Pais> it) {
          ObservableItems<Selector<Pais>, Pais, ListBuilder<Pais>> _items = it.items();
          Binding _spaceship = ArenaXtendExtensions.operator_spaceship(_items, "paisFallidos");
          PropertyAdapter _propertyAdapter = new PropertyAdapter(Pais.class, "nombrePais");
          _spaceship.setAdapter(_propertyAdapter);
          it.setHeight(50);
          it.setWidth(30);
          it.allowNull(true);
        }
      };
      _xblockexpression = ObjectExtensions.<List<Pais>>operator_doubleArrow(_list, _function);
    }
    return _xblockexpression;
  }
  
  public Label crearRecorridoDePaises(final Panel panel) {
    Label _xblockexpression = null;
    {
      final Panel contentPanel = new Panel(panel);
      VerticalLayout _verticalLayout = new VerticalLayout();
      contentPanel.setLayout(_verticalLayout);
      Label _label = new Label(contentPanel);
      _label.setText("Recorrido Criminal");
      Label _label_1 = new Label(contentPanel);
      final Procedure1<Label> _function = new Procedure1<Label>() {
        public void apply(final Label it) {
          ObservableValue<Control, ControlBuilder> _value = it.<ControlBuilder>value();
          ArenaXtendExtensions.operator_spaceship(_value, "nombrePaises");
          it.setFontSize(8);
        }
      };
      _xblockexpression = ObjectExtensions.<Label>operator_doubleArrow(_label_1, _function);
    }
    return _xblockexpression;
  }
  
  public Button crearBotoneraDeLugares(final Panel panel) {
    Button _xblockexpression = null;
    {
      final Panel contentPanel = new Panel(panel);
      VerticalLayout _verticalLayout = new VerticalLayout();
      contentPanel.setLayout(_verticalLayout);
      Label _label = new Label(contentPanel);
      _label.setText("Lugares");
      final Panel botoneraPanel = new Panel(contentPanel);
      HorizontalLayout _horizontalLayout = new HorizontalLayout();
      botoneraPanel.setLayout(_horizontalLayout);
      Button _button = new Button(botoneraPanel);
      final Procedure1<Button> _function = new Procedure1<Button>() {
        public void apply(final Button it) {
          ResolverMisterioAppModel _modelObject = ResolverMisterioWindow.this.getModelObject();
          String _primerLugarNombre = _modelObject.getPrimerLugarNombre();
          it.setCaption(_primerLugarNombre);
          final Action _function = new Action() {
            public void execute() {
              ResolverMisterioAppModel _modelObject = ResolverMisterioWindow.this.getModelObject();
              ResolverMisterioAppModel _modelObject_1 = ResolverMisterioWindow.this.getModelObject();
              Pais _paisDondeEstoy = _modelObject_1.getPaisDondeEstoy();
              LugarDeInteres _primerLugarDeInteres = _paisDondeEstoy.getPrimerLugarDeInteres();
              LugaresDeInteresAppModel _lugaresDeInteresAppModel = new LugaresDeInteresAppModel(_modelObject, _primerLugarDeInteres);
              LugaresWindow _lugaresWindow = new LugaresWindow(ResolverMisterioWindow.this, _lugaresDeInteresAppModel);
              _lugaresWindow.open();
            }
          };
          it.onClick(_function);
        }
      };
      ObjectExtensions.<Button>operator_doubleArrow(_button, _function);
      final Panel botoneraPanel2 = new Panel(contentPanel);
      HorizontalLayout _horizontalLayout_1 = new HorizontalLayout();
      botoneraPanel2.setLayout(_horizontalLayout_1);
      Button _button_1 = new Button(botoneraPanel2);
      final Procedure1<Button> _function_1 = new Procedure1<Button>() {
        public void apply(final Button it) {
          ResolverMisterioAppModel _modelObject = ResolverMisterioWindow.this.getModelObject();
          String _segundoLugarNombre = _modelObject.getSegundoLugarNombre();
          it.setCaption(_segundoLugarNombre);
          final Action _function = new Action() {
            public void execute() {
              ResolverMisterioAppModel _modelObject = ResolverMisterioWindow.this.getModelObject();
              ResolverMisterioAppModel _modelObject_1 = ResolverMisterioWindow.this.getModelObject();
              Pais _paisDondeEstoy = _modelObject_1.getPaisDondeEstoy();
              LugarDeInteres _segundoLugarDeInteres = _paisDondeEstoy.getSegundoLugarDeInteres();
              LugaresDeInteresAppModel _lugaresDeInteresAppModel = new LugaresDeInteresAppModel(_modelObject, _segundoLugarDeInteres);
              LugaresWindow _lugaresWindow = new LugaresWindow(ResolverMisterioWindow.this, _lugaresDeInteresAppModel);
              _lugaresWindow.open();
            }
          };
          it.onClick(_function);
        }
      };
      ObjectExtensions.<Button>operator_doubleArrow(_button_1, _function_1);
      final Panel botoneraPanel3 = new Panel(contentPanel);
      HorizontalLayout _horizontalLayout_2 = new HorizontalLayout();
      botoneraPanel3.setLayout(_horizontalLayout_2);
      Button _button_2 = new Button(botoneraPanel3);
      final Procedure1<Button> _function_2 = new Procedure1<Button>() {
        public void apply(final Button it) {
          ResolverMisterioAppModel _modelObject = ResolverMisterioWindow.this.getModelObject();
          String _tercerLugarNombre = _modelObject.getTercerLugarNombre();
          it.setCaption(_tercerLugarNombre);
          final Action _function = new Action() {
            public void execute() {
              ResolverMisterioAppModel _modelObject = ResolverMisterioWindow.this.getModelObject();
              ResolverMisterioAppModel _modelObject_1 = ResolverMisterioWindow.this.getModelObject();
              Pais _paisDondeEstoy = _modelObject_1.getPaisDondeEstoy();
              LugarDeInteres _tercerLugarDeInteres = _paisDondeEstoy.getTercerLugarDeInteres();
              LugaresDeInteresAppModel _lugaresDeInteresAppModel = new LugaresDeInteresAppModel(_modelObject, _tercerLugarDeInteres);
              LugaresWindow _lugaresWindow = new LugaresWindow(ResolverMisterioWindow.this, _lugaresDeInteresAppModel);
              _lugaresWindow.open();
            }
          };
          it.onClick(_function);
        }
      };
      _xblockexpression = ObjectExtensions.<Button>operator_doubleArrow(_button_2, _function_2);
    }
    return _xblockexpression;
  }
  
  protected void addActions(final Panel actionsPanel) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  protected void createFormPanel(final Panel mainPanel) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
}
