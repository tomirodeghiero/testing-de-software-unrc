package assignment7_exercises.point;



/**
 * Clase Point representa un punto en el plano, caracterizado por sus coordenadas
 * x e y. 
 */
public class Point {

	private float x; // coordenada x del punto
	private float y; // coordenada y del punto

	/**
	 * Constructor por defecto. Genera un punto en la interseccion entre los ejes
	 * de x e y.
	 */
	public Point() {
		x = 0;
		y = 0;
	}

	/**
	 * Constructor de la clase, que toma como parametros los valores para la 
	 * inicializacion.
	 * @param x es el valor a utilizar para setear la primera coordenada del punto
	 * @param y es el valor a utilizar para setear la segunda coordenda del punto.
	 */
	public Point(float x, float y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * @return el valor de la primera coordenada del punto.
	 */
	public float getX() {
		return x;
	}

	/**
	 * @return el valor de la segunda coordenada del punto.
	 */	
	public float getY() {
		return y;

	}

	/**
	 * Cambia el valor de la primera coordenada del punto
	 * @param x es el valor con el cual setear la primera coordenada del punto
	 */
	public void setX(float x) {
		this.x = x;
	}

	/**
	 * Cambia el valor de la segunda coordenada del punto
	 * @param x es el valor con el cual setear la segunda coordenada del punto
	 */
	public void setY(float y) {
		this.y = y;
	}

	/**
	 * Intercambia los valores de la primera y segunda coordenadas del punto.
	 */
	public void swap() {
		x = x+y;
		y = x-y;
		x = x+y; 
	}


	/**
	 *@precondition other!=null 
	 *@param other el punto al cual se debe calcular la distancia
	 *@return la distancia desde el punto this al punto other
	 */
	public Double distanceTo(Point other) {
		return Math.sqrt(Math.pow(other.x - this.x, 2) + Math.pow(other.y - this.y, 2) );

	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		Point other = (Point) obj;
		return Float.compare(this.x, other.x) == 0 && Float.compare(this.y, other.y) == 0;
	}

	@Override
	public int hashCode() {
		int result = Float.floatToIntBits(x);
		result = 31 * result + Float.floatToIntBits(y);
		return result;
	}


}

