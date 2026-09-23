import kotlin.system.exitProcess

var nomeBichinho: String = ""
var rodarMain = true
var rodarInicio = true

//Coisas a resolver (achar uma terceira opção)
fun main(){


    while (rodarMain) {
        println("Olá, o que deseja fazer: ")
        println("1-Nomear o bichinho")
        println("2-Ir para menu principal")
        println("3-Finalizar programa")
        val escolha = readln()

        when (escolha) {
            "1" -> {
                nomearBichinho()
            }
            "2" -> {
                inicio()
            }
            "3" -> {
                finalizar()
            }
        }
    }
}

fun nomearBichinho(){
    println("Qual será o nome do seu bichinho?")
    print("Nome: ")
    nomeBichinho = readln()
}

fun inicio(){


    while (rodarInicio) {
        println("\nEscolha uma opção")
        println("1-Alimentar")
        println("2-Brincar")
        println("3-Descansar")
        println("4-Ver status")
        println("5-Ir para configurações")
        val escolhaOpcao = readln()

        when (escolhaOpcao) {
            "1" -> {
                //alimentarBichinho()
            }

            "2" -> {
                //brincarBichinho()
            }

            "3" -> {
                //descansarBichinho()
            }

            "4" -> {
                //verStatusBichinho()
            }
        }
    }
}

fun finalizar(){
    println("Finalizando o programa Bichinho Virtual...")
    rodarInicio = false
    rodarMain = false
    exitProcess(0)
}