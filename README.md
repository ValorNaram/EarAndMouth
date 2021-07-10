# EarAndMouth

A program which listens to changes in the system clipboard and speaks out that new text. Ideal for people who cannot read but can see

## Using this app

1. Start "EarAndMouth.jar".

2. The program should say something like "Ohr gestartet".

3. Then it speaks the textual system clipboard content it founds in the clipboard due to the start process.

4. Then it listens for changes in the system clipboard by periodically looking into it.

5. If you copy e.g. a text from Wikipedia then "EarAndMouth" will speak it.

6. If you copy the exact same text (whitespaces included) again then "EarAndMouth" will not speak it because the text hasn't changed.

7. If you copy another text e.g. the next paragraph of the Wikipedia article you're viewing then "EarAndMouth" will speak it.

## Understand when EarAndMouth will speak

### First scenario

1. You copy a text from Wikipedia --> EarAndMouth will speak it

2. You copy the same text again --> EarAndMouth will **not** speak it.

### Second scenario

1. You copy a text from Wikipedia --> EarAndMouth will speak it

2. You copy the text from the next paragraph --> EarAndMouth will speak it.

3. You copy a text from the next paragraph --> EarAndMouth will speak it when the text is different from the text you copied at step 2.

4. ...

### Third scenario

1. You copied a text from a website.

2. You start EarAndMouth

3. EarAndMouth will say "Ohr gestartet" and then will speak out the text you copied

### Fourth scenario
