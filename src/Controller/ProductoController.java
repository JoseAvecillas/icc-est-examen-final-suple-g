package Controller;

import java.util.*;

import model.Producto;

public class ProductoController {
  
  public TreeSet<Producto> ordenarProducto(List<Producto> productos) {
      return new TreeSet<>(productos);
    }
  public Map<String, List<Producto>> clasificarPorUnicidad(Set<Producto> producto){
    Map<String, List<Producto>> clasificacionporunicidad = new LinkedHashMap<>();
    clasificacionporunicidad.put("A", new LinkedList<>());
    clasificacionporunicidad.put("B", new LinkedList<>());
    clasificacionporunicidad.put("C", new LinkedList<>());
    clasificacionporunicidad.put("D", new LinkedList<>());
    clasificacionporunicidad.put("E", new LinkedList<>());
    
    for(Producto p : producto){
      double porcentaje = producto.getPorcentajeCaracteresUnicos();
      if (porcentaje >= 90 && porcentaje <= 100) {
        clasificacionporunicidad.get("A").add(p);
      }else if(porcentaje >= 70 && porcentaje <= 89){
        clasificacionporunicidad.get("B").add(p);
      }else if(porcentaje >= 50 && porcentaje <= 69){
        clasificacionporunicidad.get("C").add(p);
      }else if(porcentaje >= 30 && porcentaje <= 49){
        clasificacionporunicidad.get("D").add(p);
      }else if(porcentaje >= 0 && porcentaje <= 39){
        clasificacionporunicidad.get("E").add(p);
      }
      return clasificacionporunicidad;
    }
  }

  public List<Producto> obtenerDestacados(List<Producto> productos){
    return null;
  }

  public Producto buscarPorNombre(List<Producto> lista, String nombre){
    Collections.sort(lista, Comparator.comparing(Producto :: getNombre));
    
    int iniciolista = 0;
    int fin = lista.size() -1 ;

    while (iniciolista >= fin) {
      int medio = (iniciolista + fin)/2;
      int comparacion = lista.get(medio).getNombre().compareTo(nombre);

      if (comparacion == 0) {
        return lista.get(medio);
      }
         
    }
  }
}
