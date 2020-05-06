package issues.jackson

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.fasterxml.jackson.module.kotlin.registerKotlinModule

data class Case(
    val field: String = ""
) {
    val isField = field.isNotEmpty()
}

fun main() {
    val json = """{ "field": "value" }"""

    val jackson = ObjectMapper().registerKotlinModule()
    val obj: Case = jackson.readValue(json)

    assert(obj.isField) { "Should be true" }
}
