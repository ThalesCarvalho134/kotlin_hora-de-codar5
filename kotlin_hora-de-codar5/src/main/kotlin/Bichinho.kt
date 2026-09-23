import kotlin.system.exitProcess

//Variável globais
var nomeBichinho: String = ""
var bichinho: Bichinho ?= null
var rodarInicio = true

//Data class Bichinho
data class Bichinho(
    var nome: String,
    var idade: Int = 0,
    var fome: Int = 50,
    var felicidade: Int = 50,
    var cansaco: Int = 50,
)

//Começo do código
fun main(){
    nomearBichinho()
}

//Função para nomear o bichinho (é chamada uma única vez quando começa a rodar o código)
fun nomearBichinho(){
    println("Qual será o nome do seu bichinho?")
    print("Nome: ")
    nomeBichinho = readln().uppercase()

    bichinho = Bichinho(nomeBichinho)

    inicio()
}

fun inicio(){

    // Este while faz com que o menu principal sempre seja retomado quando terminar todas as funções
    while (rodarInicio) {
        println("\nEscolha uma opção")
        println("1-Alimentar ${nomeBichinho}")
        println("2-Brincar com ${nomeBichinho}")
        println("3-Descansar ${nomeBichinho}")
        println("4-Ver status de ${nomeBichinho}")
        println("5-Finalizar programa\n")
        print("Opção escolhida: ")
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
                verStatusBichinho()
            }
            "5" ->{
                finalizar()
            }
        }
    }
}

fun verStatusBichinho(){
    println("\n----STATUS DO PET----")
    println("|Nome do pet: ${bichinho?.nome}")
    println("|Idade do pet: ${bichinho?.idade}")
    println("|Nivel de fome: ${bichinho?.fome}")
    println("|Nivel de felicidade: ${bichinho?.felicidade}")
    println("|Nivel de cansaço: ${bichinho?.cansaco}")
    }

fun finalizar(){
    println("Finalizando o programa Bichinho Virtual...")
    rodarInicio = false
}