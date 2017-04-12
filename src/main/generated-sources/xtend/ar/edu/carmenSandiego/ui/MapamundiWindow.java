package ar.edu.carmenSandiego.ui;

import AplicationModel.Mapamundi;
import ar.gaston.carmenSanDiego.Pais;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.tables.Table;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;

@SuppressWarnings("all")
public class MapamundiWindow extends SimpleWindow<Mapamundi> {
  public MapamundiWindow(final WindowOwner owner) {
    super(owner, new Mapamundi());
  }
  
  public void createMainTemplate(final Panel mainPanel) {
    this.setTitle("Mapamundi");
    super.createMainTemplate(mainPanel);
    this.createGrillaPais(mainPanel);
    this.createGridActions(mainPanel);
  }
  
  protected void createFormPanel(final Panel mainPanel) {
    throw new Error("Unresolved compilation problems:"
      + "\n<=> cannot be resolved."
      + "\n<=> cannot be resolved.");
  }
  
  public Table<Pais> createGrillaPais(final Panel mainPanel) {
    throw new Error("Unresolved compilation problems:"
      + "\n<=> cannot be resolved."
      + "\n<=> cannot be resolved."
      + "\n<=> cannot be resolved."
      + "\n<=> cannot be resolved.");
  }
  
  public void createGridActions(final Panel mainPanel) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field eliminarPaisSeleccionado is undefined for the type Mapamundi");
  }
  
  public void nuevoPais() {
    throw new Error("Unresolved compilation problems:"
      + "\nmissing \')\' at \'}\'");
  }
  
  public void openDialog(final Dialog<?> dialog) {
    dialog.open();
  }
  
  public void editarPais() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field paisSeleccionado is undefined for the type Mapamundi");
  }
  
  protected void addActions(final Panel actionsPanel) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
}
