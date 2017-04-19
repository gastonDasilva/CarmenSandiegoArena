package ar.edu.carmenSandiego.ui;

import ar.edu.carmenSandiego.ui.CrearPaisWindow;
import ar.edu.carmenSandiego.ui.EditarPaisWindow;
import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.tables.Column;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;

@SuppressWarnings("all")
public class MapamundiWindow /* extends /* SimpleWindow<Mapamundi> */  */{
  public MapamundiWindow(final WindowOwner owner) {
    throw new Error("Unresolved compilation problems:"
      + "\nMapamundi cannot be resolved.");
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
    throw new Error("Unresolved compilation problems:"
      + "\nPais cannot be resolved to a type."
      + "\nThe method or field Pais is undefined"
      + "\neliminarPaisSeleccionado cannot be resolved");
  }
  
  public /* Column<LugarDeInteres> */Object crearEdicionDePaisSeleccionado(final Panel owner) {
    throw new Error("Unresolved compilation problems:"
      + "\nPais cannot be resolved to a type."
      + "\nPais cannot be resolved to a type."
      + "\nLugarDeInteres cannot be resolved to a type."
      + "\nThe method or field Pais is undefined"
      + "\nThe method or field Pais is undefined"
      + "\nThe method or field LugarDeInteres is undefined");
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
