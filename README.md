# Lotto Number Generator
This Project was part of an application process.
The purpose of this application is to facilitate a seamless generation of tipping numbers for the lotto games Euro Jackpot and 6 out of 49. 
The application takes bad luck numbers as an argument which shall not be part of the generated tipping numbers.

# How to install
1. Download the latest release .jar file.
2. cd into the file location.
3. Execute the following command and replace `<numbers>` with up to six bad luck numbers, separated with a space:
```sh
java -jar lotto-number-generator.jar <numbers>
```

# User manual
- Upon opening the application you will be prompted to choose the lotto game for which the tipping numbers shall be generated.
- If no input is given, the game 6 out of 49 gets chosen.
- After the first tipping numbers are generated a few more options are available:
  change numbers: to change the bad luck numbers
  delete numbers: to delete the bad luck numbers
  regenerate: to regenerate a new random set of tipping numbers
  switch: to toggle between the games for which to generate the tipping numbers
  X: to end the application
- To use any of the options, simply type it in

Have fun using the app and good luck!*

*Honestly just don't play lotto, ego shooters are way more fun and prepare you for the real life ;)
