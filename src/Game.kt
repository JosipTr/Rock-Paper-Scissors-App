fun main(args: Array<String>) {
    val options = arrayOf("Rock", "Paper", "Scissors")
    val gameChoice = getGameChoice(options)
    val userChoice = getUserChoice(options)
    printResult(gameChoice,userChoice)
}

fun getGameChoice(optionsParam: Array<String>) =
    optionsParam[(Math.random() * optionsParam.size).toInt()]

fun getUserChoice(optionsParam: Array<String>): String {
    var isValidChoice = false
    var userChoice = ""

    while (!isValidChoice) {
        print("Please enter one of the following:")
        for (option in optionsParam) print(" $option")
        println("")
        print("Enter choice: ")
        val userInput = readLine()
        if (userInput != null && userInput in optionsParam) {
            isValidChoice = true
            userChoice = userInput
        }
        if (!isValidChoice) println("You must enter a valid choice.")
    }
    return userChoice
}

fun printResult(gameParam: String, choiceParam: String) {
    val result: String
    if (gameParam == choiceParam) result = "Draw!"
    else if ((gameParam == "Rock" && choiceParam == "Scissors") ||
            (gameParam == "Paper" && choiceParam == "Rock") ||
            (gameParam == "Scissors" && choiceParam == "Paper")) result = "You lose!"
    else result = "You win!"
    println("You chose $choiceParam. I chose $gameParam. $result")

}