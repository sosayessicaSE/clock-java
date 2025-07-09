This program simulates a clock that shows the current time and date, updating every second. It uses two separate threads to handle updating and displaying the time so that they run in parallel.

# How it works:
The program is centered around a Clock class.
Inside it, there's a shared currentTime variable that holds the formatted time and date as a string.
There are two key methods:
-startClock() starts a background thread that updates currentTime every second.
-startDisplay() starts a second thread that prints the current time to the console every second.

The idea is to simulate how a real digital clock works, constantly refreshing the display with the current time without blocking anything else.
To make the program a bit more realistic and explore Java’s thread model, I used thread priorities:
The display thread has high priority so it gets more CPU time, making sure the time shown is always up to date.
The update thread has low priority because it just updates the internal variable quietly in the background.

The time is formatted using "HH:mm:ss dd-MM-yyyy", which shows the time in 24-hour format followed by the date.
Also, I used synchronized and volatile to make sure the threads don’t clash when accessing currentTime, avoiding timing issues or inconsistent values.
In short: one thread updates the time, another one prints it, and priorities help keep things running smoothly.
