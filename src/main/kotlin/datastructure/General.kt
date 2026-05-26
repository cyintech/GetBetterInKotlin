package datastructure

fun main() {
   val inputArray = intArrayOf(1,1,1,1,1,)
    val matrix = arrayOf(inputArray, intArrayOf(0,0,1,1,1))


//    println(matrix[0].contentToString(ین

    val ll = LinkedHashSet<Int>()
    ll.add(1)
    ll.add(2)
    ll.add(3)
    ll.add(4)
    ll.add(5)

//    println(ll)
    val queue = ArrayDeque<Pair<Int, String>>()

    queue.addLast(1 to "1")
    queue.addLast(1 to "2")
    queue.addLast(1 to "3")
    val array = queue.toTypedArray()
    //println(array.contentToString())

    val (a,b) = queue.removeFirst()

    val myArray = arrayOf(1 to "A", 2 to "4")

   // println(myArray.contentToString())

    //println(queue)
    //println("$a to $b")

    //strings

    val s = "Hello,My,Kotlin,This,is,my,IDE"
    val ss = s.split(",")
    //println(ss.joinToString(","))

    val c = s.split(",").joinToString(" ").indexOf("e", 7,ignoreCase = true)
//    println(c)
//    println(s.lastIndex)

    //TreeMap

    val tm = sortedMapOf<Int, Int>()
    val ts = sortedSetOf<Int>()
    tm[1] = 10
    tm[-1] = 100
    tm[0] = 10000
    ts.add(2)
    ts.add(100)
    ts.add(-3)


//    println(tm)
//    println(ts)
//    println(ts.add(-3))

    //pair and triple

    val triple = Triple(1,"One",true)
    triple.first
    triple.second
    triple.third

    val (x,y,z) = Triple(0,false,"Off")
//    println("$x $y $z")

    val d = (1 to "s" to "q" to "d" to 3)

//    println(d)

//    val myLambda = {
//        println("Hey from Lambda")
//    }
//
//    //myLambda()
//   myFun("HI", {a,b ->
//       println("$a $b")
//   })
//
//    val myF : (String) -> Unit = { s -> println(s)}
//    myF("Hello World of Higher Order Functions")
    //println(fact(4))
  //println(Int.MIN_VALUE)
 val intervals = ArrayList<IntArray>()
 intervals.add(intArrayOf(Int.MAX_VALUE, Int.MIN_VALUE))
 println(intervals[0][0])
 println(intervals[0][1])
 println(intervals.last().contentToString())
}



fun myFun(a : String, s : (Int,Char) -> Unit) {
    s(100,'c')
    println(a)
}

fun fact(n : Int) : Int {
return if (n == 0) 1 else n*fact(n-1)
}

// 5 * fact(4)
// 4 * fact(3)
// 3 * fact(2)
// 2 * fact(1)
// 1 * fact(0)
// 1 * 1 = 1
// 2 * 1 = 2
// 3 * 2 = 6
// 4 * 6 = 24
// 5 * 24 = 120

