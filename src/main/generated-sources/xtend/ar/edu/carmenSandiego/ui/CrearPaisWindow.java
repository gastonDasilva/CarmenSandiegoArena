package ar.edu.carmenSandiego.ui;

import ar.edu.carmenSandiego.ui.EditarPaisWindow;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.WindowOwner;

@SuppressWarnings("all")
public class CrearPaisWindow extends EditarPaisWindow {
  public CrearPaisWindow(final WindowOwner owner, final /* Mapamundi */Object model) {
    super(owner, model);
  }
  
  public String defaultTitle() {
    return "Mapamundi -Nuevo Pais";
  }
  
  public Button botonAceptar(final Panel mainPanel) {
    throw new Error("Unresolved compilation problems:"
      + "\nagregarPais cannot be resolved");
  }
}
