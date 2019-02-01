# 10-pin-bowling-score-calculator

Java program that calculates the score of a game of bowling (also known as “ten - pin
bowling”)

### 1. `class BowlingGame`

The BowlingGame class represents a single bowling game.   
Each game has 10 frames by default, but 2 bonus frames are awarded if last frame was a strike/spare. So, a game can have a maximum of 12 frames and a minimum of 10.

#### Methods 

1. `void roll (int pins)` - Updates the frames based on the number of pins knocked in each roll

2. `boolean isValidRoll(int pins, int attempt)` - Checks if the pins knocked are valid for this attempt

3. `int getScore()` - Returns the current score of the game

4. `boolean isFinished()` - Indicates wheather the game is finished or not

5. `boolean isStrike(int attempt)` - Checks if the attempt is a strike

6. `boolean isSpare(int attempt)` - Checks if the attempt is a spare


### 2. `class Frame`
The frame class represents a single frame of the 10 - pin Bowling game score board.   
Each frame has 2 rolls. The total points for the frame is calculated after all rolls (including bonus rolls)


#### Methods

1. `boolean isStrike()` - Getter method
2. `void setStrike(boolean isStrike)` - Setter method
2. `boolean isSpare()` - Getter method
2. `void setSpare(boolean isSpare)` - Setter method
2. `int getTemp()` - Getter method
2. `int getFirstRoll()` - Getter method
2. `void setFirstRoll(int firstRoll)` - Setter method
2. `int getSecondRoll()` - Getter method
2. `void setSecondRoll(int secondRoll)` - Setter method
2. `int getBonus()` - Getter method
2. `void setBonus(int bonus)` - Setter method
2. `int getPoints()` - Getter method
2. `void setPoints(int points)` - Setter method
2. `void decreaseBonus()` - Decreases the bonus by 1
2. `void addToTemp(int val)` - Adds a number to temp and updates it's value


### 3. `class Main`
The class with main method, to test the program
