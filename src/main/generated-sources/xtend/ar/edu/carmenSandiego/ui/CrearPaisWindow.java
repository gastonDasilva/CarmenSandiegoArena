package ar.edu.carmenSandiego.ui;

import ar.edu.carmenSandiego.ui.EditarPaisWindow;
import ar.gaston.carmenSanDiego.Pais;
import org.uqbar.arena.windows.WindowOwner;

@SuppressWarnings("all")
public class CrearPaisWindow extends EditarPaisWindow {
  public CrearPaisWindow(final WindowOwner owner) {
    super(owner, new Pais());
  }
  
  public String defaultTitle() {
    return "Mapamundi -Nuevo Pais";
  }
}
