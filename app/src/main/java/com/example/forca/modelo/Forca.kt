package model

class Forca(private var palavra: String, private var dica: String) {
    private var tamPalavra = this.palavra.length
    private var palavOculta = mutableListOf<Char>()
    private var letrasUsadas = ""
    private var acertos = 0
    private var tentativas = 6

    fun getPalavra(): String {
        return this.palavra
    }

    fun getDica(): String {
        return this.dica
    }

    fun getTamPalavra(): Int {
        return this.tamPalavra
    }

    fun getPalavraOculta(): String {
        return this.palavOculta.joinToString(" ")
    }

    fun getLetrasUsadas(): String {
        return this.letrasUsadas
    }

    fun getTentativas(): Int {
        return this.tentativas
    }

    fun getAcertos(): Int {
        return this.acertos
    }

    fun iniciar() {
        for (i in 0 until this.tamPalavra) {
            this.palavOculta.add('_')
        }
    }

    fun terminou(): Boolean {
        return this.acertos == this.tamPalavra || this.tentativas == 0
    }

    fun letrasDistintas(): Int {
        var letraDistintas = this.palavra.toList()
        return letraDistintas.distinct().size
    }

    fun testarLetras(letra: String) {
        if (this.letrasUsadas.contains(letra[0])) {
            throw Throwable("Letra ${letra[0].uppercase()} já usada, digite outra letra!")
        }
        else if (letra.length > 1) {
            throw Throwable("Digite apenas uma letra!")
        }
        else {
            this.letrasUsadas += "${letra[0]} "
        }
    }

    fun adivinhar(letra: String) {
        try {
            this.testarLetras(letra)

            var existe = false

            for ((i, letraP) in this.palavra.withIndex()) {
                if (letra[0].uppercaseChar() == letraP.uppercaseChar()) {
                    this.acertos ++
                    this.palavOculta[i] = letra[0].uppercaseChar()
                    existe = true
                }
            }
            if (!existe) {
                this.tentativas --
            }
        }
        catch (e: Throwable) {
            println(e.message)
        }
    }
}

