class DynamicArray{
    private var capacity = 10
    private var baseArray = IntArray(10)
    private var size = 0

    fun append(x: Int) {
        if (size == capacity) {
            resizeArray()
        }

        baseArray[size] = x
        size++
    }

    private fun resizeArray() {
        val newCapacity = capacity*2
        val newArray = IntArray(newCapacity)
        for (i in baseArray.indices) {
            newArray[i] = baseArray[i]
        }
        baseArray = newArray
        capacity = newCapacity
    }

    fun getElement(i: Int) : Int {
        return if (i < size) {
             baseArray[i]
        } else throw IndexOutOfBoundsException("index given $i")
    }

    fun setElement(i : Int, x: Int) {
        if (i < size) {
            baseArray[i] = x
        } else throw IndexOutOfBoundsException("index given $i")
    }

    fun sizeA() : Int {
        return size
    }

    fun popBack() {
        if (size > 0) {
            baseArray[baseArray.size-1] = 0
            size--
        }
    }

}