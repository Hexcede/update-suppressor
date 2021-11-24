# Update Suppressor

Adds a block which suppresses block updates. Emulates the behaviour of large block update suppressors in the vanilla game, in the form of a single block.

## Features

* Very little performance impact while suppressing updates. This is because the update suppressor block throws a custom error, while update suppressors in the vanilla game cause a stack overflow to create an error, which is expensive.
* Suppresses multiple crashes compared to vanilla update suppressors. This allows for updates originating from other locations to be suppressed without a crash, such as the random ticking of a grass block.
* Suppressed crashes are currently emitted as warnings in the console. This makes it possible to determine if a witnessed behaviour is possible with a vanilla update suppressor, and to see how the game might behave without these crashes.

## Planned Features

* In-game feedback when a crash is suppressed (visual or audio)
* Toggling update suppression through right clicking the block, or possibly through a redstone adapter block.
* More cute textures (my programmer art is bad)
