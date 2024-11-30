package com.mataku.preview.catalog

import com.google.devtools.ksp.processing.CodeGenerator
import com.google.devtools.ksp.processing.Dependencies
import com.google.devtools.ksp.processing.KSPLogger
import com.google.devtools.ksp.processing.Resolver
import com.google.devtools.ksp.processing.SymbolProcessor
import com.google.devtools.ksp.symbol.KSAnnotated
import com.google.devtools.ksp.symbol.KSFunctionDeclaration
import com.google.devtools.ksp.validate

class PreviewCatalogProcessor(
    val codeGenerator: CodeGenerator,
    val logger: KSPLogger
) : SymbolProcessor {
    override fun process(resolver: Resolver): List<KSAnnotated> {
        val symbols =
            resolver.getSymbolsWithAnnotation("androidx.compose.ui.tooling.preview.Preview")
                .filterIsInstance<KSFunctionDeclaration>()

        if (symbols.iterator().hasNext()) {
            val file = codeGenerator.createNewFile(
                dependencies = Dependencies.ALL_FILES,
                packageName = "com.mataku.preview.catalog",
                fileName = "PreviewCatalog2"
            )

            file.bufferedWriter().use { writer ->
                writer.appendLine("package com.mataku.preview.catalog")

                writer.appendLine("object PreviewCatalog2 {")
                writer.appendLine("  val previews = listOf<String>(")
                symbols.forEach { symbol ->
                    // --info
                    logger.info("MATAKUDEBUG Processing symboll: ${symbol}")
                    symbol.validate()
                    writer.appendLine(" \"${symbol.simpleName.asString()}\",")
                }
                writer.appendLine(")")
                writer.appendLine("}")
            }
        }

        return emptyList()
    }
}