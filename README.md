# Morse_Code
# Morse Code Translator

.... ..       .- --       .... .. - . ... ....       - .... .       -.. . ...- . .-.. --- .--. . .-.       -... . .... .. -. -..       - .... .. ...       .--. .-. --- .--- . -.-. -       .- -. -..       - .... .. ...       .. ...       -- -.--       ...- . .-. -.--       ..-. .. .-. ... -       ... .. -.. .       --.- ..- . ... -

..-. --- .-.       -- .       -.-. --- -.. .. -. --.       .. ... -. .----. -       .--- ..- ... -       .- -... --- ..- -       -.-. .... .- ... .. -. --.       ... ..- -.-. -.-. . ... ...       --- .-.       .-- .-. .. - .. -. --.       -.-. --- -.. .       - ---       --. . -       - .... .. -. --. ...       -.. --- -. .       - .... .       .-. . .- .-..       ..-. ..- -.       .. ...       .. -.       -.-. .-. . .- - .. -. --.       ... --- -- . - .... .. -. --.       -.-. --- --- .-.. --..--       . -..- .--. . .-. .. -- . -. - .. -. --.       .-- .. - ....       .. -.. . .- ...       .- -. -..       - ..- .-. -. .. -. --.       .. -- .- --. .. -. .- - .. --- -.       .. -. - ---       ... --- -- . - .... .. -. --.       .-. . .- .-.. .-.-.-

.. ..-.       -.-- --- ..-       -... . .-.. .. . ...- .       - .... .- -       -.-. --- -.. .. -. --.       .. ...       .- -... --- ..- -       -- --- .-. .       - .... .- -.       .--- ..- ... -       ... ..- -.-. -.-. . ... ...       .- -. -..       - .... .- -       - .... .       - .... .-. .. .-.. .-..       --- ..-.       -.-. .-. . .- - .. -. --.       ... --- -- . - .... .. -. --.       ..-. ..- -.       .- -. -..       ..- -. .. --.- ..- .       -- .- - - . .-. ...       .--- ..- ... -       .- ...       -- ..- -.-. .... --..--       .-.. . - .----. ...       -... .       ..-. .-. .. . -. -.. ...       .- -. -..       -... ..- .. .-.. -..       ... --- -- .       .--. .-. . - - -.--       -.-. --- --- .-..       ... - ..- ..-. ..-.       - --- --. . - .... . .-. -.-.--

.- -. -..       .... . -.-- --..--       .. ..-.       -.-- --- ..- .----. ...- .       --. --- -       .-       -.-. .-. .- --.. -.--       .. -.. . .-       - .... .- -       ... --- ..- -. -.. ...       ..-. ..- -. --..--       -.-. --- ..- -. -       -- .       .. -. -.-.--       .. .----. --       .- .-.. .-- .- -.-- ...       ..- .--.       ..-. --- .-.       . -..- .--. . .-. .. -- . -. - .. -. --. --..--       - .-. -.-- .. -. --.       .-- . .. .-. -..       - .... .. -. --. ... --..--       .- -. -..       -... ..- .. .-.. -.. .. -. --.       ... --- -- . - .... .. -. --.       .- .-- . ... --- -- .       .--- ..- ... -       ..-. --- .-.       - .... .       ..-. ..- -.       --- ..-.       .. - .-.-.-

.-.. . - .----. ...       -.-. .-. . .- - . --..--       . -..- .--. . .-. .. -- . -. - --..--       -... .-. . .- -.-       - .... .. -. --. ... --..--       .-.. . .- .-. -. --..--       .- -. -..       .... .- ...- .       ..-. ..- -.       .- .-.. --- -. --.       - .... .       .-- .- -.-- -.-.--



A simple Java-based Morse Code Translator that converts text into Morse code and Morse code back into readable text.

This project started as a personal coding side quest to get back into programming, strengthen my Java fundamentals, and build something fun while learning how things work under the hood.

Rather than copying a ready-made solution, I wanted to understand the logic, choose the appropriate data structures, and implement the translation myself.

**This is a learning project, and it's open to ideas, improvements, and contributions from anyone interested in Morse code, Java, or building something together.**

## Features

- **Text to Morse:** Convert English letters into their corresponding Morse code.
- **Morse to Text:** Decode Morse code back into readable text.
- **Word separation:** Preserve spaces between words using a custom spacing convention.
- **Interactive console menu:** Choose which translation mode to use.
- **Array-based encoding:** Translate characters using their alphabetical positions.
- **HashMap-based decoding:** Retrieve characters using their Morse code sequences.

## How It Works

### 1. Text to Morse Code

The program uses a `String[]` array named `MorseArray` to store the Morse codes for the 26 English letters, from A to Z.

Each letter corresponds to an index in the array:

| Letter | Index | Morse Code |
|---|---:|---|
| A | 0 | `.-` |
| B | 1 | `-...` |
| C | 2 | `-.-.` |
| D | 3 | `-..` |
| E | 4 | `.` |

Instead of searching through the array for each character, the program calculates the index using character arithmetic:

`Character.toLowerCase(c) - 'a'`

This converts an English letter into its corresponding array index, allowing direct access to its Morse code.

**Why an array?**

English letters have predictable alphabetical positions. An array makes use of this property and provides constant-time lookup, O(1), for each supported character.

For a string containing *n* characters, the overall translation takes O(n) time, excluding the output costs and assuming constant-time character processing.

### 2. Morse Code to Text

Decoding requires the reverse mapping: a Morse sequence must be mapped back to its corresponding English letter.

For this, the project uses Java's `HashMap<String, Character>`, named `MorseMap`.

The map is populated using the existing `MorseArray`, avoiding the need to manually enter every reverse mapping.

For example:

| Morse Code | Character |
|---|---|
| `.-` | a |
| `-...` | b |
| `-.-.` | c |
| `-..` | d |
| `.` | e |

**Why a HashMap?**

Unlike English letters, Morse sequences don't have natural sequential array indices. A `HashMap` allows Morse strings to act as keys, making it convenient to retrieve their corresponding characters.

HashMap lookups take O(1) time on average. Decoding an entire message also requires processing its input and separating individual Morse sequences.

### 3. Word Separation

The current implementation uses a custom spacing convention:

- One space between Morse characters.
- Seven spaces between words.

This allows the decoder to distinguish individual letters from word boundaries.

For example, the message `HI HITESH` can be represented as:

```text
.... ..       .... .. - . ... ....
```

The encoder and decoder use the same convention so that messages can be translated in both directions.

## Technologies Used

- **Java** — Core programming language.
- **Arrays** — Store Morse codes and support direct character lookup.
- **HashMap** — Map Morse sequences back to characters.
- **Scanner** — Read user input from the console.
- **Git and GitHub** — Version control and project collaboration.

## What I'm Learning Through This Project

This project is part of my effort to become a better programmer through hands-on experimentation.

Some of the concepts explored include:

- Java methods and modular program structure.
- Arrays and character arithmetic.
- HashMap initialization and key-value relationships.
- Loops, conditionals, and string processing.
- Input handling and debugging.
- Time complexity and data-structure selection.
- Designing a program so that it can grow over time.

The main goal isn't just to make the translator work. It's to understand the decisions behind the implementation and improve the project incrementally.

## Future Plans

This is the first version, not the final destination. Here are some ideas I'd like to explore as I continue learning.

### 1. Improved Translation and Validation

- Handle invalid Morse sequences gracefully.
- Improve input validation and error messages.
- Support additional characters, numbers, and punctuation.
- Make spacing and message parsing more robust.

### 2. Real-Time Morse Translation

Explore real-time translation, where text or Morse input is processed as it is entered rather than only after submitting a complete message.

Possible directions include live text-to-Morse conversion, decoding incoming Morse signals, and experimenting with audio-based Morse input.

### 3. A Mobile Morse Translator

Build a mobile application that makes Morse translation accessible beyond the console.

Possible features include:

- A simple, user-friendly interface.
- Text-to-Morse and Morse-to-text translation.
- Copy and share translated messages.
- Audio playback of Morse signals.
- Microphone-based Morse input.
- Flashlight-based Morse signalling.
- A practice mode for learning Morse code.

These are future ideas and have not yet been implemented.

### 4. A Morse Code Learning Mode

Turn the translator into a small learning tool with quizzes, random messages, decoding challenges, and a scoring system.

### 5. Refactoring and Better Architecture

As the project grows, explore separating the translation logic from user input and output, adding automated tests, and organizing the code into reusable components.

## Getting Started

### Prerequisites

- Java Development Kit (JDK) installed.
- A terminal or Java-compatible IDE.
- Git, if you want to clone the repository.

### Run the Project

1. Clone this repository:

   ```bash
   git clone https://github.com/hitesh011204/Morse_Code.git
   ```

2. Navigate to the project directory.

3. Compile the Java file:

   ```bash
   javac Morse.java
   ```

4. Run the program:

   ```bash
   java Morse
   ```

5. Follow the console menu to choose a translation mode.

*Note: The source file is currently named `Morse.java`. Make sure the filename matches the public class name.*

## Contributing

**Contributions, suggestions, and creative ideas are welcome!**

This project is being developed as a learning journey, and I'd love for others to help make it better. Whether you're a beginner learning Java or an experienced developer interested in Morse code, feel free to participate.

You could contribute by:

- Improving the existing translation logic.
- Fixing bugs or handling edge cases.
- Adding support for more characters.
- Improving code readability and organization.
- Creating a mobile interface.
- Experimenting with real-time, audio, or flashlight-based translation.
- Adding tests, documentation, or entirely new features.

### How to Contribute

1. Fork the repository.
2. Create a branch for your changes.
3. Implement your feature or fix.
4. Test your changes.
5. Submit a pull request explaining what you changed and why.

If you have an idea but aren't sure how to implement it, feel free to open an issue and discuss it first.

Please keep contributions constructive, beginner-friendly, and focused on making the project better.

## A Note from the Developer

I started this project to get back into coding, learn by building, and make the process enjoyable instead of treating programming as something I only do for interviews or coursework.

This is a work in progress. I plan to keep learning, improving the implementation, and adding features over time.

If you find this project interesting, have an idea, spot a bug, or want to build something together, you're welcome here.

**Let's learn, experiment, and build something cool together!**
