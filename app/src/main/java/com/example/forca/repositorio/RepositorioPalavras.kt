package model

class RepositorioPalavras {
    private var bancoPalavras = hashMapOf<String, String>()
    private var palavraSorteada = ""

    fun add(palavra: String, dica: String) {
        this.bancoPalavras.put(palavra,dica)
    }
    fun sortear() {
        this.palavraSorteada = this.bancoPalavras.keys.random()
    }
    fun getPalavra(): String {
        return this.palavraSorteada
    }
    fun getDica(): String {
        return this.bancoPalavras.getValue(this.palavraSorteada)
    }
}