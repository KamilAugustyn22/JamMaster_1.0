const buttons = document.querySelectorAll(".transpose-btn");
let introChords = document.querySelector(".intro-chords");
let verseChords = document.querySelector(".verse-chords");
let reffChords = document.querySelector(".reff-chords");
let bridgeChords = document.querySelector(".bridge-chords");

for (const button of buttons){
    button.addEventListener("click", function (event){
        let chordsMajor = ["C","C#","D","D#","E","F","F#","G","G#","A","A#","H"];
        let chordsMinor = ["c","c#","d","d#","e","f","f#","g","g#","a","a#","h"];
        let intro = introChords.innerText;
        let verse = verseChords.innerText;
        let reffrain = reffChords.innerText;
        let bridge = bridgeChords.innerText;
        if(button.value == "+"){
             console.log(intro + "+");
             console.log(verse + "+");
             console.log(reffrain + "+");
             console.log(bridge + "+");
        }
        if(button.value == "-"){
            console.log(intro + "-");
            console.log(verse + "-");
            console.log(reffrain + "-");
            console.log(bridge + "-");
        }
    })
}