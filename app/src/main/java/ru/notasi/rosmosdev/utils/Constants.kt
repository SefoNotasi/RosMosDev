package ru.notasi.rosmosdev.utils

/**
 * https://stackoverflow.com/questions/44038721/constants-in-kotlin-whats-a-recommended-way-to-create-them
 *
 * https://stackoverflow.com/a/55054023
 * Constants must be in the class they are related to.
 * If you make a 'Constants' class you will end, eventually, will hundreds of constants inside it.
 * P.e: MAX_WIDTH, MAX_HEIGHT must be in the Screen class so you can access to it logically:
 * Screen.MAX_WIDTH and you don't need to put Constants.SCREEN_MAX_WIDTH
 * which will be duplicated with Constants.SCR_MAX_W and Constants.MAX_WIDTH
 * in 2 years because NOBODY scrolls hundreds/thousands lines down when they push Ctrl+space to autocomplete.
 * Seriously: don't do it. leads to unmaintainable – inigoD Apr 4, 2018 at 15:52
 */