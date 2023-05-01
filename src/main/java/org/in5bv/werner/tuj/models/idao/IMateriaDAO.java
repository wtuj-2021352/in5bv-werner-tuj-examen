package org.in5bv.werner.tuj.models.idao;

import javafx.collections.ObservableList;
import org.in5bv.werner.tuj.models.domain.Materia;

/**
 *
 * @author Werner Chacom
 */

public interface IMateriaDAO {

    public ObservableList<Materia> getAll();

    public boolean add(Materia materia);

    public boolean update(Materia materia);

    public boolean delete(int idMateria);

}
