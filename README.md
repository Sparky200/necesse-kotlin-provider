# Necesse Kotlin Provider Mod

This mod provides the Kotlin stdlib at runtime.
The versions will stay accurate to the stdlib version contained.

## Building
1. Clone
2. Let gradle do its stuff
3. Replace the game path variables with your game's path
   - Note that this is only used for building the project, the built jar does not need these set to work!
4. Run any of `gradle runClient`, `gradle runDevClient`, or `gradle runServer` and copy
   the result jar file from `build/libs`