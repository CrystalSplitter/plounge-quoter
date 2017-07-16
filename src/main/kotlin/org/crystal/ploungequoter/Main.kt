package org.crystal.ploungequoter

import java.io.File
import java.nio.file.Paths
import java.nio.file.Path
import org.apache.commons.cli.Options
import java.awt.Color
import java.awt.Font

fun main(args: Array<String>) {
    // Handle parsing.
    PQParser.parse(args)
    // Make sure not to do anything if we're using help.
    if (!PQParser.isHelp) {
        // Generate the PLounge Quote.
        generatePloungeQuote(PQParser.getBackground())
    }
}


/**
 * Run the full Plounge Quote generation.
 * Add all the generation objects, then run the renderer.
 */
fun generatePloungeQuote(background_path: String?) {
    val PNGTYPE: String = "png"
    val JPGTYPE: String = "jpg"
    val OUTPUT_PATH: String = "output_new.png"


    // Load all the system fonts for any text generation.
    //FontMap.loadFonts()

    if (background_path == null) {
        throw IllegalArgumentException("background_path was null.")
    }

    var backgroundImagePath: Path =
            Paths.get(background_path)
    var renderer: Renderer = Renderer(backgroundImagePath)

    var quote: Text = Text(Vector2(100.0f,100.0f))
    quote.setContent("HELLO\nWORLD!")
    quote.font = Font("Inconsolata", Font.PLAIN, 10)
    quote.color = Color(0,0,255)
    quote.anchor = Anchor.BOT_LEFT

    // Need to make a layer here.

    //renderer.addRenderObj(quote)
    println("Rendering...")
    renderer.render(PNGTYPE,File(OUTPUT_PATH))
    print("Output at: "); println(OUTPUT_PATH)
}