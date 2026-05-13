
fun getValidString(s: String) : String {
    var validS = ""
    val rSet = mutableSetOf<Int>()
    var openP = 0
    for (c in s.indices) {
        if (s[c]==')' && openP==0) {
            rSet.add(c)
        } else if (s[c]=='(') {
            openP++
        } else if (openP > 0 && s[c] == ')') {
            openP--
        }
    }

    if (rSet.isNotEmpty()) {
        for (c in s.indices) {
            if (rSet.contains(c)) {
                continue
            }
            validS += s[c]
        }
    }
    return validS
}

fun validStr(s : String) : String {
    val c = s.toCharArray()
    val stack = ArrayDeque<Int>()
    for (i in c.indices) {
        if (c[i]=='(') {
            stack.addLast(i)
        } else if (c[i]==')') {
            if (stack.isNotEmpty()) {
                stack.removeLast()
            } else
                c[i] = ' '
        }
    }

    while (stack.isNotEmpty()) {
        val index = stack.removeLast()
            c[index] = ' '
    }
    return String(c).replace(" ", "")
}