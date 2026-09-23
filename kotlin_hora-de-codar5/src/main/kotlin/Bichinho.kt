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

    while (rodarInicio) {// Este while faz com que o menu principal sempre seja retomado quando terminar todas as funções
        print("----MENU PRINCIPAL----")
        println("\nEscolha uma opção")
        println("|1-Alimentar ${nomeBichinho}")
        println("|2-Brincar com ${nomeBichinho}")
        println("|3-Descansar ${nomeBichinho}")
        println("|4-Ver status de ${nomeBichinho}")
        println("|5-Finalizar programa\n")
        print("Opção escolhida: ")
        val escolhaOpcao = readln()

        when (escolhaOpcao) {
            "1" -> {
                alimentarBichinho()
            }

            "2" -> {
                brincarBichinho()
            }

            "3" -> {
                descansarBichinho()
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

fun alimentarBichinho(){
    println("Você escolheu alimentar o(a) ${nomeBichinho}")
    println("Alimentando ${nomeBichinho}...")
    Thread.sleep(2000)//parada de tempo por 2s

    bichinho?.fome -= 15
    passarTempo()

    if (rodarInicio) {
        print("${nomeBichinho} comeu bastante e agora está bem alimentado")
        println("Novos status: ")
        verStatusBichinho()
    }

}

fun brincarBichinho(){
    println("Você escolheu brincar com o(a) ${nomeBichinho}")
    println("Brincando ${nomeBichinho}...")
    Thread.sleep(3000)//parada de tempo por 3s

    bichinho?.felicidade += 10
    bichinho?.cansaco += 5
    passarTempo()

    if (rodarInicio) {
        print("${nomeBichinho} brincou muito e ficou mega feliz :)")
        println("Novos status: ")
        verStatusBichinho()
    }

}

fun descansarBichinho(){
    println("Você escolheu descansar o(a) ${nomeBichinho}")
    println("${nomeBichinho} está dormindo...")
    Thread.sleep(5000)//parada de tempo por 5s

    bichinho?.cansaco -= 100
    passarTempo()

    if (rodarInicio) {
        print("${nomeBichinho} dormiu bastante e agora está cheio de energia")
        println("Novos status: ")
        verStatusBichinho()
    }

}

fun verStatusBichinho(){
    println("\t\n----STATUS DO PET----")
    println("\t|Nome do pet: ${bichinho?.nome}")
    println("\t|Idade do pet: ${bichinho?.idade}")
    println("\t|Nivel de fome: ${bichinho?.fome}")
    println("\t|Nivel de felicidade: ${bichinho?.felicidade}")
    println("\t|Nivel de cansaço: ${bichinho?.cansaco}\n")
    }

fun passarTempo(){
    //Mudança dos status
    bichinho?.fome += 3
    bichinho?.cansaco += 10
    bichinho?.felicidade -= 3
    bichinho?.idade += 1

    //Verifica se ultrapassou o limite
    bichinho?.fome = bichinho?.fome?.coerceIn(0, 100)?: 0
    bichinho?.felicidade = bichinho?.felicidade?.coerceIn(0, 100)?: 100
    bichinho?.cansaco = bichinho?.cansaco?.coerceIn(0, 100)?: 0

    //Condição caso verificou verdadeiro
    if (bichinho?.fome == 100) {
        println("${bichinho?.nome} faleceu de fome. Você perdeu")
        finalizar()
    }
    else if (bichinho?.cansaco == 100) {
        println("${bichinho?.nome} ficou muito cansado. Você perdeu")
        finalizar()
    }
    else if (bichinho?.felicidade == 0) {
        println("${bichinho?.nome} ficou muito triste. Você perdeu")
        finalizar()
    }
}

fun finalizar(){
    println("Finalizando o programa Bichinho Virtual...")
    rodarInicio = false
}