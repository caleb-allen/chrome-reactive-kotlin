package pl.wendigo.chrome

import org.junit.Test
import pl.wendigo.chrome.domain.runtime.EvaluateRequest
import java.util.concurrent.TimeUnit

class EditionRenderChromeTest {
    @Test
    fun testChromeSession() {
        val inspector = Inspector.connect("127.0.0.1:9223")
        val result = inspector.openedPages().firstOrError()
                .map {
                    println("Got page: $it")
                    ChromeProtocol.openSession(it)
                }
                .flatMap {
                    println("evaluating javascript...")
                    it.Runtime.evaluate(EvaluateRequest("10", returnByValue = true))
                }.doOnEvent { resp, err ->
                    println("Got response")
                    println(resp)
                    assert(err == null)
                    resp.exceptionDetails?.let {
                        println(it.exception?.description)
                    }
                    assert(resp.exceptionDetails == null)
                }.delay(1000, TimeUnit.MILLISECONDS)
                .blockingGet().result

        println(result)

        assert(result.type == "number")
        assert(result.value is Int)
        println(result.value!!::class.java)
    }


    @Test
    fun testChrome(){
        val i = Inspector.connect("127.0.0.1:9223").openedPages()
    }
}
