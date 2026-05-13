

import org.jsoup.Jsoup

fun decodeSecretMessage(url: String) {
    val doc = Jsoup.connect(url)
        .userAgent("Mozilla/5.0")
        .timeout(10_000)
        .get()

    val table = doc.select("table").first() ?: error("Couldn't find a table in the doc")
    val rows = table.select("tr").drop(1) // skip header

    // x = column, y = row. y=0 is the bottom and increases upward,
    // so we'll need to flip when printing.
    val grid = mutableMapOf<Pair<Int, Int>, String>()

    for (row in rows) {
        val cells = row.select("td")
        if (cells.size < 3) continue

        val x = cells[0].text().trim().toIntOrNull() ?: continue
        val ch = cells[1].text().trim().takeIf { it.isNotEmpty() } ?: continue
        val y = cells[2].text().trim().toIntOrNull() ?: continue

        grid[x to y] = ch
    }

    check(grid.isNotEmpty()) { "Parsed an empty grid — double check the doc format" }

    val maxX = grid.keys.maxOf { it.first }
    val maxY = grid.keys.maxOf { it.second }

    // print top-to-bottom, so start from maxY and work down to 0
    for (y in maxY downTo 0) {
        val line = (0..maxX).joinToString("") { x -> grid[x to y] ?: " " }
        println(line)
    }
}

fun main() {
    // Replace with the actual Google Doc URL passed in
    val url = "https://docs.google.com/document/d/e/2PACX-1vSvM5gDlNvt7npYHhp_XfsJvuntUhq184By5xO_pA4b_gCWeXb6dM6ZxwN8rE6S4ghUsCj2VKR21oEP/pub"
    decodeSecretMessage(url)
}