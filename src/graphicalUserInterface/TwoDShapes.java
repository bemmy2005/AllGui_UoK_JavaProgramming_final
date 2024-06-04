package graphicalUserInterface;



abstract class TwoDShapes {
	/*protected double area;
	protected double perimeter;

	public TwoDShapes(double area, double perimeter) {
		super();
		this.area = area;
		this.perimeter = perimeter;
	}
	public double getArea() {
		return area;
	}
	public void setArea(double area) {
		this.area = area;
	}
	public void setArea(String shape) {
		switch (shape.toLowerCase()) {
		case "circle":
			double radius = Circle.getRadius();
			this.area = Math.PI * radius * radius;
			//perimeter = 2 * Math.PI * radius;
			System.out.println("Circle Area: " + area);
			//System.out.println("Circle Perimeter: " + perimeter);
			break;

		case "rectangle":
			double length = Rectangle.getLength();
			double width = Rectangle.getWidth();
			area = length * width;
			//perimeter = 2 * (length + width);
			//System.out.println("Rectangle Area: " + area);
			//System.out.println("Rectangle Perimeter: " + perimeter);
			break;

		case "triangle":
			double a = Triangle.getA();
			double b = Triangle.getB();
			double c = Triangle.getC();
			double s = (a + b + c) / 2;  // Semi-perimeter
			area = Math.sqrt(s * (s - a) * (s - b) * (s - c));  // Using Heron's formula
			//perimeter = a + b + c;
			//System.out.println("Triangle Area: " + area);
			//System.out.println("Triangle Perimeter: " + perimeter);
			break;

		case "square":
			double side = Square.getSide();
			area = side * side;
			//perimeter = 4 * side;
			//System.out.println("Square Area: " + area);
			//System.out.println("Square Perimeter: " + perimeter);
			break;

		case "rhombus":
			double d1 = Rhombus.getD1(); // Diagonal 1
			double d2 = Rhombus.getD2(); // Diagonal 2
			area = (d1 * d2) / 2;
			double sideLength = Math.sqrt((d1/2)*(d1/2) + (d2/2)*(d2/2));  // Pythagorean theorem to find side length
			//perimeter = 4 * sideLength;
			//System.out.println("Rhombus Area: " + area);
			//System.out.println("Rhombus Perimeter: " + perimeter);
			break;

		case "parallelogram":
			double base = Parallelogram.getBase();
			double height = Parallelogram.getHeight();
			double sideParallelogram = Parallelogram.getSide();
			area = base * height;
			//perimeter = 2 * (base + sideParallelogram);
			//System.out.println("Parallelogram Area: " + area);
			//System.out.println("Parallelogram Perimeter: " + perimeter);
			break;

		default:
			System.out.println("Invalid shape");
		}
	}
	public double getPerimeter() {
		return perimeter;
	}
	public void setPerimeter(double perimeter) {
		this.perimeter = perimeter;
	}

	public void setPerimeter(String shape) {
		switch (shape.toLowerCase()) {
		case "circle":
			double radius = Circle.getRadius();
			//area = Math.PI * radius * radius;
			perimeter = 2 * Math.PI * radius;
			//System.out.println("Circle Area: " + area);
			System.out.println("Circle Perimeter: " + perimeter);
			break;

		case "rectangle":
			double length = Rectangle.getLength();
			double width = Rectangle.getWidth();
			//area = length * width;
			perimeter = 2 * (length + width);
			//System.out.println("Rectangle Area: " + area);
			//System.out.println("Rectangle Perimeter: " + perimeter);
			break;

		case "triangle":
			double a = Triangle.getA();
			double b = Triangle.getB();
			double c = Triangle.getC();
			double s = (a + b + c) / 2;  // Semi-perimeter
			//area = Math.sqrt(s * (s - a) * (s - b) * (s - c));  // Using Heron's formula
			perimeter = a + b + c;
			//System.out.println("Triangle Area: " + area);
			//System.out.println("Triangle Perimeter: " + perimeter);
			break;

		case "square":
			double side = Square.getSide();
			//area = side * side;
			perimeter = 4 * side;
			//System.out.println("Square Area: " + area);
			//System.out.println("Square Perimeter: " + perimeter);
			break;

		case "rhombus":
			double d1 = Rhombus.getD1(); // Diagonal 1
			double d2 = Rhombus.getD2(); // Diagonal 2
			//area = (d1 * d2) / 2;
			double sideLength = Math.sqrt((d1/2)*(d1/2) + (d2/2)*(d2/2));  // Pythagorean theorem to find side length
			perimeter = 4 * sideLength;
			//System.out.println("Rhombus Area: " + area);
			//System.out.println("Rhombus Perimeter: " + perimeter);
			break;

		case "parallelogram":
			double base = Parallelogram.getBase();
			double height = Parallelogram.getHeight();
			double sideParallelogram = Parallelogram.getSide();
			//area = base * height;
			perimeter = 2 * (base + sideParallelogram);
			//System.out.println("Parallelogram Area: " + area);
			//System.out.println("Parallelogram Perimeter: " + perimeter);
			break;

		default:
			System.out.println("Invalid shape");
		}
	}
	public double calculateArea() {
		return area;

	}
	public double calaculatePerimeter() {
		return perimeter;

	}*/
	private double area;
	private double perimeter;

	// Getters and setters
	public double getArea() {
		return area;
	}

	public void setArea(double area) {
		this.area = area;
	}

	public double getPerimeter() {
		return perimeter;
	}

	public void setPerimeter(double perimeter) {
		this.perimeter = perimeter;
	}

	// Abstract methods
	public abstract void calculateArea();
	public abstract void calculatePerimeter();

}
