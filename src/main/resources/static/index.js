const foxImage = document.createElement("img")
foxImage.id="foxImage";
foxImage.alt="image of a fox";
document.body.appendChild(foxImage);

fetchFox();

//sends user question to AI
function sendQuestion() {
    const question = document.getElementById('question').value; //get question from user form.
    const aiResponseElement = document.getElementById('aiResponse'); //get ai response element.

    aiResponseElement.textContent = "Venter på svar..."; //set ai response

    const url = 'http://localhost:8080/villain?question=' + question;
    //get ai response from backend.
    fetch(url)//fetch ai response from backend url.
        .then(response => {
            if (!response.ok){
                console.log("response not ok");
            }
            return response.json();//convert response to json.
        })
        .then(data => {
            console.log("data: " + data);
            aiResponseElement.textContent = data.choices[0].message.content; //set ai response text: first message in Response.choices.
            //console.log("set ai response text");

        })
        .catch(error => { //error handling.
            console.log('Fejl: ' + error);
            aiResponseElement.textContent = "Noget gik galt, prøv igen.";
        }); //end of fetch.

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