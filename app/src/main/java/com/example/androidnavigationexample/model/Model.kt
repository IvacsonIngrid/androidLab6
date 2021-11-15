package com.example.androidnavigationexample.model


data class Question(
    val text: String,
    val answers: List<String>
)

var sumOfTheCorrectAnswers = 0


// Negyedik a helyes!!!
val questions: MutableList<Question> = mutableListOf(
    Question(
        text = "Which is correct?",
        answers = listOf("var is read-only", "val is mutable", "var is like final in Java", "val is read-only")
    ),
    Question(
        text = "Which is top-level function?",
        answers = listOf("class A { fun member() = 2 }", "fun other() { fun local() = 3 }", "class Name { fun firstName() : String = \"Ian\" }", "fun topLevel() = 1")
    ),
    Question(
        text = "Which is incorrect?",
        answers = listOf("i in 1..9 := [1,9]", "i in 'a'..'d' := abcd", "i in 9 downTo 1 step 2 := 97531", "i in 1 until 10 := [1,10]")
    ),
    Question(
        text = "What will be printed?\nprintln(\"Kotlin\" in \"Java\"..\"Scala\")\nprintln(\"Kotlin\" in setOf(\"Java\", \"Scala\"))",
        answers = listOf("true true", "false true", "false false", "true false")
    ),
    Question(
        text = "What is the type of 'a' to 1.0?",
        answers = listOf("Char to Int", "Char to Double", "List<Any>", "Pair<Char, Double>")
    ),
    Question(
        text = "Which is the correct operator precedence?",
        answers = listOf("* in ?: || ==", "in == || ?: *", "== * in ?: ||", "* ?: in == ||")
    ),
    Question(
        text = "What will be the solution?  x = [1, 2, 3, 4]    x.filter{it % 2 == 0}",
        answers = listOf("[1, 2, 3, 4]", "[0.5, 1, 1.5, 2]", "[1, 3]", "[2, 4]")
    ),
    Question(
        text = "What will be the solution?  x = [1, 2, 3, 4]    x.count{it % 2 == 0}",
        answers = listOf("[2, 4]", "[1, 3]", "1", "2")
    ),
    Question(
        text = "What will be the solution?  x = [1, 2, 3, 4]    x.partition{it % 2 == 0}",
        answers = listOf("[1, 3]", "[2, 4]", "[1, 2, 3, 4]", "[1, 3] [2, 4]")
    ),
    Question(
        text = "Which is incorrect lambda syntax?",
        answers = listOf("list.any({ i: Int -> i > 0 })", "list.any() { i: Int -> i > 0 }", "list.any { i: Int -> i > 0 }", "list.any { i -> i: Int > 0 }")
    )

)