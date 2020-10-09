package modelo;

import java.util.Comparator;

public class nombre implements Comparator<usuario>{

	@Override
	public int compare(usuario arg0, usuario arg1) {
		
		return arg0.getNombre().compareTo(arg1.getNombre());
		
	}

}
