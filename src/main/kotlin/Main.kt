fun main(args: Array<String>) {

//    val upperCaseString : (String) -> String = { str  -> str.uppercase() }
//    val originalList = listOf(1,2,3)
//    val newList =  buildList<Int> {
//        addAll(originalList.map { it+1 })
//    }

    println(ItemData(itemName = "Tablet"))
println(ITEMNAME)
    //return valid string
//    println(getValidString("(()"))
//    //println(getValidString("lee(t(c)o)de)"))
//    println("\n********************\n")
//    println(validStr("(()"))
//    println(validStr("lee(t(c)o)de)"))

//    val myArray = DynamicArray()
//    myArray.append(1)
//    myArray.append(2)
//    myArray.append(3)
//    myArray.append(4)
//    myArray.append(5)
//    myArray.append(6)
//    myArray.append(7)
//    myArray.append(8)
//    myArray.append(9)
//    myArray.append(10)
//    myArray.append(11)
//    myArray.append(12)
//    println(myArray.sizeA()) //12
//
//    myArray.popBack()
//    println(myArray.sizeA()) //11
//
//    myArray.popBack()
//    myArray.popBack()
//    myArray.popBack()
//    println(myArray.sizeA()) //8
//
//    println(myArray.getElement(5))
//    println(myArray.getElement(0))
//    println(myArray.getElement(12))

    val newArray = intArrayOf(1,2,3,4,5,6)
    val b = IntArray(2)
    b[0] = 1
    b[1] = 2

    val twoD = arrayOf(
        intArrayOf(1,2,0),
        intArrayOf(3,4,5)
    )

//    for (i in twoD.indices) {
//        for (j in twoD[i].indices) {
//            print("${twoD[i][j]} ")
//        }
//        println()
//    }
}

data class ItemData(
    val itemName : String = ""
)

data object ITEMNAME {

}