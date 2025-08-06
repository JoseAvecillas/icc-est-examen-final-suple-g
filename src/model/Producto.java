package model;
import java.util.*;
public class Producto {
  
  private String nombre;
  private String codigo;
  private List<Double> precios;
  public Producto(String nombre, String codigo, List<Double> precios) {
    this.nombre = nombre;
    this.codigo = codigo;
    this.precios = precios;
  }
  public String getNombre() {
    return nombre;
  }
  public void setNombre(String nombre) {
    this.nombre = nombre;
  }
  public String getCodigo() {
    return codigo;
  }
  public void setCodigo(String codigo) {
    this.codigo = codigo;
  }
  public List<Double> getPrecios() {
    return precios;
  }
  public void setPrecios(List<Double> precios) {
    this.precios = precios;
  }
  @Override
  public String toString() {
    return "Producto [nombre=" + nombre + ", codigo=" + codigo + ", precios=" + precios + "]";
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
    result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
    result = prime * result + ((precios == null) ? 0 : precios.hashCode());
    return result;
  }
  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Producto other = (Producto) obj;
    if (nombre == null) {
      if (other.nombre != null)
        return false;
    } else if (!nombre.equals(other.nombre))
      return false;
    if (codigo == null) {
      if (other.codigo != null)
        return false;
    } else if (!codigo.equals(other.codigo))
      return false;
    if (precios == null) {
      if (other.precios != null)
        return false;
    } else if (!precios.equals(other.precios))
      return false;
    return true;
  }

  public int getPorcentajeCaracteresUnicos(){
    String nombreentero = nombre.replace(" ", "").toLowerCase();
    if (nombreentero.isEmpty()) {
      return 0;
    }
    Set<Character> caracteres = new HashSet<>();
    for (char c : nombreentero.toCharArray()) {
      caracteres.add(c);
    }
    return (int)(double)(caracteres.size() + 100 / nombreentero.length());
  }

  public int getCatidadPreciosRepetidos(){
    Set<Double> precios = new HashSet<>();
    int repeticion = 0;
    for(Double preciodouble : precios){
      if (!precios.add(preciodouble)) {
        repeticion++;
      }
    }
    return repeticion;
  }
}