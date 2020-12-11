fun main(args: Array<String>) {
    val shapeAccumulator = ShapeAccumulator()

    val listOfRectangle = arrayListOf(Rectangle(6.3, 3.2))
    val listOfCircle = arrayListOf(Circle(3.4))
    val square = Square(7.7)
    val triangle = Triangle(5.0, 6.0, 7.0)

    shapeAccumulator.add(square)
    shapeAccumulator.add(triangle)
    shapeAccumulator.addAll(listOfRectangle)
    shapeAccumulator.addAll(listOfCircle)

    println(
        "maxArea: "+
                "${shapeAccumulator.getMaxAreaShape()!!::class.simpleName}"+
                " ${shapeAccumulator.getMaxAreaShape()!!.calcArea()}\n"+
                "minArea: "+
                "${shapeAccumulator.getMinAreaShape()!!::class.simpleName}"+
                " ${shapeAccumulator.getMinAreaShape()!!.calcArea()}\n"+
                "maxPerimeter: "+
                "${shapeAccumulator.getMaxPerimeterShape()!!::class.simpleName}"+
                " ${shapeAccumulator.getMaxPerimeterShape()!!.calcPerimeter()}\n"+
                "minPerimeter: "+
                "${shapeAccumulator.getMinPerimeterShape()!!::class.simpleName}"+
                " ${shapeAccumulator.getMinPerimeterShape()!!.calcPerimeter()}\n"+
                "totalArea: "+
                "${shapeAccumulator.getTotalArea()}\n"+
                "totalPerimeter: "+
                "${shapeAccumulator.getTotalPerimeter()}"
    )
}
