const responseContainer = document.createElement("div");
responseContainer.id = "responseContainer";
document.body.appendChild(responseContainer);

// move existing AI response element into container
const aiResponseElement = document.getElementById("aiResponse");
responseContainer.appendChild(aiResponseElement);

// create and append fox image
const foxImage = document.createElement("img");
foxImage.id = "foxImage";
foxImage.alt = "image of a fox";
responseContainer.appendChild(foxImage);

fetchFox();

//sends user question to AI
function sendQuestion() {
    const question = document.getElementById('question').value;
    const aiResponseElement = document.getElementById('aiResponse');

    // clear current content and add spinner
    aiResponseElement.innerHTML = `
        <div class="spinner"></div>
        <span style="margin-left: 10px;">Venter på svar...</span>
    `;

    const url = 'http://localhost:8080/villain?question=' + question;

    fetch(url)
        .then(response => {
            if (!response.ok){
                console.log("response not ok");
            }
            return response.json();
        })
        .then(data => {
            aiResponseElement.textContent = data.choices[0].message.content;
        })
        .catch(error => {
            console.log('Fejl: ' + error);
            aiResponseElement.textContent = "Noget gik galt, prøv igen.";
        });

    fetchFox();
}


//get random image of a fox
function fetchFox(){
    const url = "http://localhost:8080/fox"; //backend url
    fetch(url)
        .then(response => {
            if(!response.ok){
                console.log("could not fetch fox");
            }
            return response.json();
        }).then(data => {
            console.log("image: " + data.image);
            foxImage.src=data.image;
            //return data.image; //return fox image.
    }).catch(error => {
        console.log("fejl i ræv: " + error);
    });

}