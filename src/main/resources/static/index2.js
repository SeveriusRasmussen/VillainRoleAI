function sendQuestion() {
    const question = document.getElementById('question').value;
    const aiResponseElement = document.getElementById('aiResponse');

    aiResponseElement.textContent = "Venter på svar...";

    fetch('/villain?question=' + encodeURIComponent(question))
        .then(response => response.json())
        .then(data => {
            aiResponseElement.textContent = data.choices[0].message.content;
        })
        .catch(error => {
            console.error('Fejl:', error);
            aiResponseElement.textContent = "Noget gik galt, prøv igen.";
        });
}