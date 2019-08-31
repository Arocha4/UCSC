//Antoine Rocha
//arocha4 
//pa6 Complex.java



class Complex{

    //--------------------------------------------------------------------------
    // Private Data Fields 
    //--------------------------------------------------------------------------
    private double re;
    private double im;
   
    //--------------------------------------------------------------------------
    // Public Constant Fields 
    //--------------------------------------------------------------------------
    public static final Complex ONE = Complex.valueOf(1,0);
    public static final Complex ZERO = Complex.valueOf(0,0);
    public static final Complex I = Complex.valueOf(0,1);

    //--------------------------------------------------------------------------
    // Constructors 
    //--------------------------------------------------------------------------
    Complex(double a, double b){
	this.re = a;
	this.im = b;
    }

    Complex(double a){
	this.re = a;
	this.im = 0;
    }

    Complex(String str){
	double[] part = new double[2];
	String s = str.trim();
	String NUM = "(\\d+\\.\\d*|\\.?\\d+)";
	String SGN = "[+-]?";
	String OP =  "\\s*[+-]\\s*";
	String I =   "i";
	String OR =  "|";
	String REAL = SGN+NUM;
	String IMAG = SGN+NUM+"?"+I;
        String COMP = REAL+OR+
                     IMAG+OR+
	   REAL+OP+NUM+"?"+I;
       
       if( !s.matches(COMP) ){
	   throw new NumberFormatException("Cannot parse input string \""+s+"\" as Complex");
       }
       s = s.replaceAll("\\s","");     
       if( s.matches(REAL) ){
	   part[0] = Double.parseDouble(s);
	   part[1] = 0;
       }
       else if( s.matches(SGN+I) ){
	   part[0] = 0;
	   part[1] = Double.parseDouble( s.replace( I, "1.0" ) );
       }
       else if( s.matches(IMAG) ){
	   part[0] = 0;
	   part[1] = Double.parseDouble( s.replace( I , "" ) );
       }
       else if( s.matches(REAL+OP+I) ){
	   part[0] = Double.parseDouble( s.replaceAll( "("+REAL+")"+OP+".+" , "$1" ) );
	   part[1] = Double.parseDouble( s.replaceAll( ".+("+OP+")"+I , "$1"+"1.0" ) );
       }
       else{    
	   part[0] = Double.parseDouble( s.replaceAll( "("+REAL+").+"  , "$1" ) );
	   part[1] = Double.parseDouble( s.replaceAll( ".+("+OP+NUM+")"+I , "$1" ) );
       }
       
       this.re = part[0];
       this.im = part[1];
    }
    

    //---------------------------------------------------------------------------
    // Public methods 
    //---------------------------------------------------------------------------

    // Complex arithmetic -------------------------------------------------------

    // copy()
    // Return a new Complex equal to this Complex
    Complex copy(){
	Complex c = new Complex(this.re, this.im);
	return c;
      
    }
   
    // add()
    // Return a new Complex representing the sum this plus z.
    Complex add(Complex z){
	Complex c = new Complex(this.re + z.re, this.im + z.im);
	return c;
    }
   
    // negate()
    // Return a new Complex representing the negative of this.
    Complex negate(){
	Complex c = new Complex(0 - this.re,0 - this.im);
	return c;
    }

    // sub()
    // Return a new Complex representing the difference this minus z.
    Complex sub(Complex z){
	Complex c = new Complex(this.re - z.re, this.im - z.im);
	return c;
    }

    // mult()
    // Return a new Complex representing the product this times z.
    Complex mult(Complex z){
	double real, imaginary;
       
	real = (this.re * z.re) - (this.im * z.im);
	imaginary = (this.re * z.im) + (this.im * z.re);
               
	Complex c = new Complex(real, imaginary);
	return c;
    }

    // recip()
    // Return a new Complex representing the reciprocal of this.
    // Throw an ArithmeticException with appropriate message if 
    // this.equals(Complex.ZERO).
    Complex recip()throws ArithmeticException{
	double real, imaginary;
      
	if(this.equals(Complex.ZERO))
	    throw new NumberFormatException("Cannot divide by zero.");
      
	real = this.re / (this.re * this.re + this.im * this.im);
	imaginary = (0 - this.im) / (this.re * this.re + this.im * this.im) ;
      
	Complex p = new Complex(real, imaginary);
	return p;
    }

    // div()
    // Return a new Complex representing the quotient of this by z.
    // Throw an ArithmeticException with appropriate message if 
    // z.equals(Complex.ZERO).
    Complex div(Complex z)throws ArithmeticException{
	double real, imaginary;
       
	if(z.equals(Complex.ZERO))
	    throw new NumberFormatException("Cannot divide by zero.");
       
	real = (this.re*z.re+this.im*z.im)/(z.re*z.re+z.im*z.im);
          	imaginary = (this.re*z.im-this.im*z.re)/(z.re*z.re+z.im*z.im);

		Complex w = new Complex(real, imaginary);
		return w;
    }
		// conj()
		// Return a new Complex representing the conjugate of this Complex.
		Complex conj(){
		    Complex c = new Complex(this.re,0 - this.im);
		    return c;
		}

                // Re() 
		// Return the real part of this.
		double Re(){
		    return re;
		}
		// Im()
		// Return the imaginary part of this.
		double Im(){
		    return im;
		}

		// abs()
		// Return the modulus of this Complex, i.e. the distance between 
		// points (0, 0) and (re, im).
		double abs(){
		    return Math.sqrt(this.re * this.re + this.im * this.im);
		}

		// arg()
		// Return the argument of this Complex, i.e. the angle this Complex
		// makes with positive real axis.
		double arg(){
		    return Math.atan2(im, re);
		}

		// Other functions ---------------------------------------------------------
   
		// toString()
		// Return a String representation of this Complex.
		// The String returned will be readable by the constructor Complex(String s)
		public String toString(){
		    String com = "0";
      
		    if(this.re == 0 && this.im == 0)   //if both real and imaginary parts are 0
			com = "0";
		    else if(this.re == 0)    //if real part is 0
			com = this.im + "i";
		    else if(this.im == 0)    //if imaginary part is 0
			com = this.re + "";
		    else{
			if(this.im > 0) 
			    com = this.re + "+" + this.im + "i";
			else if(this.im < 0)
			    com = this.re + "-" + (0 - this.im) + "i";
		    }
		    return com;
      
		}

		// equals()
		// Return true iff this and obj have the same real and imaginary parts.
		public boolean equals(Object obj){
		    return this == (Complex)obj;
		}

		// valueOf()
		// Return a new Complex with real part a and imaginary part b.
		static Complex valueOf(double a, double b){
		    Complex c = new Complex (a, b);
		    return c;
		}

		// valueOf()
		// Return a new Complex with real part a and imaginary part 0.
		static Complex valueOf(double a){
		    Complex c = new Complex (a, 0);
		    return c;
		}

		// valueOf()
		// Return a new Complex constructed from s.
		static Complex valueOf(String s){
      
		    return new Complex(s);
		}	

    }
