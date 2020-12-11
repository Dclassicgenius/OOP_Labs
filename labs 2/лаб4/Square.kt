import java.lang.IllegalArgumentException

class Square(val a: Double) : Shape {
    init {
        if (a <= 0)
            throw IllegalArgumentException("Square size must be positive")
    }
    override fun calcArea(): Double {
        return a * a
    }

    override fun calcPerimeter(): Double {
        return 4 * a
    }
}
