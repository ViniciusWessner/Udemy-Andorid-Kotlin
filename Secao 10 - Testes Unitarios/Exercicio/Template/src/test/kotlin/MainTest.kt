import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class MainTest {

    @Test
    @DisplayName("Testa os cenarios portaria")

    fun testaPortaria(){
        //verificando se idade é a correta
        Assertions.assertEquals(portaria(0,"",""), "Negado.")
        Assertions.assertEquals(portaria(20,"",""), "Negado.")
        //Verificando o tipo de convite (passando um errado)
        Assertions.assertEquals(portaria(20,"VIP",""), "Negado.")
        // Verificando o código do convite com o "xt" e sem o "Xt"
        Assertions.assertEquals(portaria(20,"comum","xt4545"), "Welcome.")
        Assertions.assertEquals(portaria(20,"comum","4545"), "Negado.")
        //Testando o tipo do convite premium e luxo com a validação do cod do convite XL
        Assertions.assertEquals(portaria(20,"premium","xt5589"), "Negado.")
        Assertions.assertEquals(portaria(20,"premium","xt5589"), "Negado.")
        Assertions.assertEquals(portaria(20,"luxo","xl4545"), "Welcome.")
    }
}