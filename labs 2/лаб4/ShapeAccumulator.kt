class ShapeAccumulator {
    private val shapes: MutableList<Shape> = ArrayList()

    fun add(shape: Shape) {
        shapes.add(shape)
    }

    fun addAll(collection: Collection<Shape>) {
        shapes.addAll(collection)
    }

    fun getTotalArea(): Double = shapes.sumByDouble { it.calcArea() }

    fun getTotalPerimeter(): Double = shapes.sumByDouble { it.calcPerimeter() }

    fun getMinAreaShape(): Shape? = shapes.minByOrNull { it.calcArea() }

    fun getMaxAreaShape(): Shape? = shapes.maxByOrNull { it.calcArea() }

    fun getMaxPerimeterShape(): Shape? = shapes.maxByOrNull { it.calcPerimeter() }

    fun getMinPerimeterShape(): Shape? = shapes.minByOrNull { it.calcPerimeter() }
}
