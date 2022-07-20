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

        let introChordsArr = intro.split(" ");
        let verseChordsArr = verse.split(" ");
        let reffChordsArr = reffrain.split(" ");
        let bridgeChordsArr = bridge.split(" ");

        let newIntro = [];
        let newVerse = [];
        let newReffrain = [];
        let newBridge = [];

        if(button.value === "+"){
             //intro
            for(let i = 0; i<introChordsArr.length; i++){
                for(let j = 0; j<chordsMinor.length; j++){
                    if(introChordsArr[i] === chordsMinor[j]){
                        newIntro[i] = chordsMinor[j + 1];
                    }
                    else if(introChordsArr[i] === chordsMajor[j]){
                        newIntro[i] = chordsMajor[j + 1];
                    }
                }
            }
            //verse
            for(let i = 0; i<verseChordsArr.length; i++){
                for(let j = 0; j<chordsMinor.length; j++){
                    if(verseChordsArr[i] === chordsMinor[j]){
                        newVerse[i] = chordsMinor[j + 1];
                    }
                    else if(verseChordsArr[i] === chordsMajor[j]){
                        newVerse[i] = chordsMajor[j + 1];
                    }
                }
            }
            //reffrain
            for(let i = 0; i<reffChordsArr.length; i++){
                for(let j = 0; j<chordsMinor.length; j++){
                    if(reffChordsArr[i] === chordsMinor[j]){
                        newReffrain[i] = chordsMinor[j + 1];
                    }
                    else if(reffChordsArr[i] === chordsMajor[j]){
                        newReffrain[i] = chordsMajor[j + 1];
                    }
                }
            }
            //bridge
            for(let i = 0; i<bridgeChordsArr.length; i++){
                for(let j = 0; j<chordsMinor.length; j++){
                    if(bridgeChordsArr[i] === chordsMinor[j]){
                        newBridge[i] = chordsMinor[j + 1];
                    }
                    else if(bridgeChordsArr[i] === chordsMajor[j]){
                        newBridge[i] = chordsMajor[j + 1];
                    }
                }
            }
            intro = newIntro.toString();
            verse = newVerse.toString();
            reffrain = newReffrain.toString();
            bridge = newBridge.toString();
            introChords.innerText = intro;
            verseChords.innerText = verse;
            reffChords.innerText = reffrain;
            bridgeChords.innerText = bridge;
        }
        if(button.value === "-"){
            //intro
            for(let i = 0; i<introChordsArr.length; i++){
                for(let j = 0; j<chordsMinor.length; j++){
                    if(introChordsArr[i] === chordsMinor[j]){
                        newIntro[i] = chordsMinor[j - 1];
                    }
                    else if(introChordsArr[i] === chordsMajor[j]){
                        newIntro[i] = chordsMajor[j - 1];
                    }
                }
            }
            //verse
            for(let i = 0; i<verseChordsArr.length; i++){
                for(let j = 0; j<chordsMinor.length; j++){
                    if(verseChordsArr[i] === chordsMinor[j]){
                        newVerse[i] = chordsMinor[j - 1];
                    }
                    else if(verseChordsArr[i] === chordsMajor[j]){
                        newVerse[i] = chordsMajor[j - 1];
                    }
                }
            }
            //reffrain
            for(let i = 0; i<reffChordsArr.length; i++){
                for(let j = 0; j<chordsMinor.length; j++){
                    if(reffChordsArr[i] === chordsMinor[j]){
                        newReffrain[i] = chordsMinor[j - 1];
                    }
                    else if(reffChordsArr[i] === chordsMajor[j]){
                        newReffrain[i] = chordsMajor[j - 1];
                    }
                }
            }
            //bridge
            for(let i = 0; i<bridgeChordsArr.length; i++){
                for(let j = 0; j<chordsMinor.length; j++){
                    if(bridgeChordsArr[i] === chordsMinor[j]){
                        newBridge[i] = chordsMinor[j - 1];
                    }
                    else if(bridgeChordsArr[i] === chordsMajor[j]){
                        newBridge[i] = chordsMajor[j - 1];
                    }
                }
            }
            intro = newIntro.toString();
            verse = newVerse.toString();
            reffrain = newReffrain.toString();
            bridge = newBridge.toString();
            introChords.innerText = intro;
            verseChords.innerText = verse;
            reffChords.innerText = reffrain;
            bridgeChords.innerText = bridge;
        }
    })
}