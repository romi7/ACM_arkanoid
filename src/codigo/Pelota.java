package codigo;
/*
 * autor Jorge Cisneros
 * La clase pelota es la que vamos a utilizar para
 * el juego del arkanoid
 * Tiene dos constructores
 */
import java.awt.Color;

import acm.graphics.GObject;
import acm.graphics.GOval;

public class Pelota extends GOval{
	
	double xVelocidad = 3; //velocidad de la bola en el eje X
	double yVelocidad = -3; //velocidad de la bola en el eje Y

	
	/**
	 * Este es el constructor básico, que es idéntico
	 * al de la clase GOval
	 * @param _ancho
	 * @param _alto
	 */
	public Pelota(double _ancho, double _alto){
		super(_ancho, _alto);
	}

	/**
	 * Este es el constructor dabuti que permite
	 * pasar el color como parámetro 
	 * 
	 * @param _ancho indica el ancho y el alto de la bola
	 * @param _color
	 */
	public Pelota(double _ancho, Color _color){
		super(_ancho, _ancho);
		if (_ancho <=0){
			setSize(1, 1);
		}
		setFillColor(_color);
		setFilled(true);
	}
	/**
	 * se encarga de mover a la pelota y chequear si ha habido colisiones
	 * 
	 */
	public void muevete(Arkanoid _arkanoid){  
		//chequea si ha chocado con las paredes izq o derecha
		if (getX() + getWidth() >= _arkanoid.getWidth() 
				|| getX()<0){
			xVelocidad *= -1; 
		}
		//chequea si ha chocado con el techo
		if (this.getY()<0){
			yVelocidad *= -1; 
		} 
	if (chequeaColision(getX(), getY(), _arkanoid)){ 
		if (chequeaColision(getX()+ getWidth(),getY() , _arkanoid)){ 
			if (chequeaColision(getX(), getY() + getHeight() , _arkanoid)){ 
				if (chequeaColision(getX() + getWidth() , getY() + getHeight() , _arkanoid)){ 
			}
		
		}
		
	} 
	} 

		//voy a crear un metodo chqueacolision generico 
		// que sirva para comprobar los choques entre la bola y los ladrillos 
		//y la bola y el cursor
		move(xVelocidad, yVelocidad);
	} 
	
	private boolean chequeaColision(double posX, double posY, Arkanoid _arkanoid){ 
	boolean noHaChocado = true; 
	GObject auxiliar; 
	auxiliar = _arkanoid.getElementAt(posX, posY); 
	
	if (auxiliar instanceof Ladrillo){ 
		if (auxiliar.getX() == posY || auxiliar.getY() +auxiliar.getHeight() == posY){ 
			yVelocidad *= -1;
			
		} 
		else if(auxiliar.getX() == posX || auxiliar.getX() +auxiliar.getWidth()== posX){ 
			yVelocidad *= -1;
		}
		_arkanoid.remove(auxiliar); 
		noHaChocado = false;
	}  
	else if (auxiliar instanceof Barra){  
		yVelocidad *= -1;
		noHaChocado = false;
		
	}
	return noHaChocado;
	}
	
	

	
	
	
}










